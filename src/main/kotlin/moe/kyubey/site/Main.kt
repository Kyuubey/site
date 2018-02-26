package moe.kyubey.site

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import io.javalin.Javalin
import moe.kyubey.site.db.schema.Logs
import moe.kyubey.site.entities.Config
import moe.kyubey.site.entities.DatabaseConfig
import moe.kyubey.site.entities.Log
import me.aurieh.ares.exposed.async.asyncTransaction
import moe.kyubey.site.entities.DiscordConfig
import moe.kyubey.site.utils.DiscordAuth
import moe.kyubey.site.views.*
import okhttp3.*
import org.eclipse.jetty.util.MultiMap
import org.eclipse.jetty.util.UrlEncoded
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.select
import org.json.JSONObject
import java.io.File
import java.nio.charset.Charset
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

fun main(args: Array<String>) {
    val mapper = ObjectMapper(YAMLFactory()).apply { registerModule(KotlinModule()) }
    val config = if (System.getenv("USE_ENV") != null || System.getenv("DYNO") != null) {
        Config(
                System.getenv("PORT").toInt(),
                System.getenv("BOT_INVITE"),
                System.getenv("GUILD_INVITE"),
                DiscordConfig(
                        System.getenv("CLIENT_ID"),
                        System.getenv("CLIENT_SECRET"),
                        System.getenv("CALLBACK_URL"),
                        System.getenv("ADMINS").split(",\\s?".toRegex())
                ),
                if (System.getenv("DATABASE_URL") != null) {
                    val pgUrl = System.getenv("DATABASE_URL").removePrefix("postgres://")
                    DatabaseConfig(
                            pgUrl.split("/")[1],
                            pgUrl.split(":")[0],
                            pgUrl.split(":")[1].split("@")[0],
                            pgUrl.split("@")[1].split("/")[0]
                    )
                } else
                    DatabaseConfig(
                            System.getenv("DATABASE_NAME"),
                            System.getenv("DATABASE_USER"),
                            System.getenv("DATABASE_PASS"),
                            System.getenv("DATABASE_HOST")
                    )
        )
    } else
        mapper.readValue(File("./config.yml"))

    Database.connect(
            "jdbc:postgresql://${config.database.host}/${config.database.name}",
            "org.postgresql.Driver",
            config.database.user,
            config.database.pass
    )
    val pool: ExecutorService by lazy {
        Executors.newCachedThreadPool {
            Thread(it, "Akatsuki-Pool-Thread").apply {
                isDaemon = true
            }
        }
    }
    val okhttp = OkHttpClient()
    val app = Javalin.create().apply {
        port(config.port)
        enableStaticFiles("/public")
        enableDynamicGzip()
        enableCorsForAllOrigins()
        enableStandardRequestLogging()
    }.start()

    DiscordAuth.config = config

    // redirects
    app.get("/docs") { it.redirect("/documentation") }
    app.get("/support") { it.redirect(config.guildInvite) }
    app.get("/invite") { it.redirect(config.botInvite) }
    app.get("/login/discord") {
        if (!it.sessionAttribute<String?>("access_token").isNullOrEmpty())
            it.redirect("/dashboard")
        else
            it.redirect(HttpUrl.Builder().apply {
                scheme("https")
                host("discordapp.com")
                addPathSegment("api")
                addPathSegment("oauth2")
                addPathSegment("authorize")
                addQueryParameter("client_id", config.discord.clientId)
                addQueryParameter("redirect_uri", config.discord.redirectUri)
                addQueryParameter("response_type", "code")
                addQueryParameter("scope", "identify guilds")
            }.build().toString())
    }
    app.get("/authorize/discord") { ctx ->
        val code = ctx.queryParam("code")

        if (code != null) {
            val json = DiscordAuth.exchangeCode(code)

            if (json.has("error")) {
                ctx.redirect("/login?fail=true&message=${json.getString("error")}")
            } else {
                ctx.sessionAttribute("access_token", json.getString("access_token"))
                ctx.redirect("/dashboard")
            }
        } else {
            ctx.status(400).html("<h1>400 Bad request</h1>")
        }
    }

    // routes
    app.get("/") { it.html(Index.render()) }
    app.get("/documentation") { it.html(Documentation.render()) }
    app.get("/faq") { it.html(Faq.render()) }
    app.get("/login") {
        if (!it.sessionAttribute<String?>("access_token").isNullOrEmpty())
            it.redirect("/dashboard")
        else
            it.html(Login.render())
    }
    app.get("/logout") {
        it.sessionAttribute("access_token", "")
        it.redirect("/")
    }
    app.get("/dashboard") { ctx ->
        val token = ctx.sessionAttribute<String?>("access_token")

        if (!token.isNullOrEmpty()) {
            val user = DiscordAuth.getUser(token!!)

            ctx.html("<h1>Hello ${user.getString("username")}#${user.getString("discriminator")}!</h1>")
        } else {
            ctx.redirect("/login")
        }
    }
    app.get("/admin/dashboard") { ctx ->
        val token = ctx.sessionAttribute<String?>("access_token")

        if (!token.isNullOrEmpty()) {
            val user = DiscordAuth.getUser(token!!)

            ctx.html(AdminDashboard.render(user))
        } else {
            ctx.redirect("/login")
        }
    }
    app.get("/logs/:channel/:timestamp") { ctx ->
        val timestamp = ctx.param("timestamp")!!.toLong()

        val html = asyncTransaction(pool) {
            val query = Logs.select {
                Logs.channelId.eq(ctx.param("channel")!!.toLong()) and Logs.timestamp.between(timestamp - 7200000, timestamp)
            }.limit(ctx.queryParamOrDefault("limit", "100").toIntOrNull() ?: 100)

            var logsRaw: List<ResultRow> = query.toList()

            if (ctx.queryParams("event") != null) {
                logsRaw = logsRaw.filter {
                    ctx.queryParams("event")!!.any { e -> it[Logs.event] == e }
                }
            }

            // TODO filters
            /*if (query != null) {
                query = query.filter {
                    (it as Map<String, Any>)["timestamp"].toString().toBigInteger() <= request.params(":timestamp").toBigInteger()
                }

                if (request.queryParams("event") != null)
                    query = query.filter {
                        request.queryParamsValues("event").any { event -> (it as Map<String, Any>)["event"].toString().toLowerCase() == event.toLowerCase() }
                    }

                if (request.queryParams("user") != null)
                    query = query.filter {
                        request.queryParamsValues("user").any { user -> ((it as Map<String, Any>)["author"] as Map<String, Any>)["id"] == user }
                    }

                if (request.queryParams("keyword") != null)
                    query = query.filter {
                        request.queryParamsValues("keyword").any { keyword -> (it as Map<String, Any>)["content"].toString().toLowerCase().contains(keyword.toLowerCase()) }
                    }

                if (request.queryParams("end_timestamp") != null)
                    query = query.filter {
                        (it as Map<String, Any>)["timestamp"].toString().toBigInteger() < request.queryParams("end_timestamp").toBigInteger()
                    }

                if (request.queryParams("exclude_event") != null)
                    query = query.filter {
                        request.queryParamsValues("exclude_event").any { event -> (it as Map<String, Any>)["event"].toString().toLowerCase() != event.toLowerCase() }
                    }
                    */

            val logs = logsRaw.map {
                @Suppress("UNCHECKED_CAST")
                Log(
                        it[Logs.event],
                        it[Logs.messageId],
                        it[Logs.content],
                        it[Logs.attachments].toList(),
                        it[Logs.embeds].toList() as List<HashMap<String, Any>>, // FIXME shouldn't this be a JSONObject?
                        it[Logs.timestamp],
                        it[Logs.authorId],
                        it[Logs.authorName],
                        it[Logs.authorDiscrim],
                        it[Logs.authorAvatar],
                        it[Logs.authorNick],
                        it[Logs.guildId],
                        it[Logs.guildName],
                        it[Logs.channelId],
                        it[Logs.channelName]
                )
            }

            return@asyncTransaction moe.kyubey.site.views.Logs.render(logs)
        }.execute().get()

        ctx.html(html)
    }
}