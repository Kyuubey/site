package info.kyubey.site

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import info.kyubey.site.db.schema.Logs
import info.kyubey.site.entities.Config
import info.kyubey.site.entities.DatabaseConfig
import info.kyubey.site.entities.Log
import me.aurieh.ares.exposed.async.asyncTransaction
import org.commonmark.parser.Parser
import org.commonmark.renderer.html.HtmlRenderer
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.select
import org.slf4j.LoggerFactory
import spark.ModelAndView
import spark.kotlin.*
import spark.template.freemarker.FreeMarkerEngine
import java.io.File
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

fun main(args: Array<String>) {
    val mapper = ObjectMapper(YAMLFactory()).apply { registerModule(KotlinModule()) }
    val config = if (System.getenv("USE_ENV") != null || System.getenv("DYNO") != null) {
        Config(
                System.getenv("PORT").toInt(),
                System.getenv("BOT_INVITE"),
                System.getenv("GUILD_INVITE"),
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

    val mdParser = Parser.builder().build()
    val htmlRenderer = HtmlRenderer.builder().build()

    val logger = LoggerFactory.getLogger("main")
    val db = Database.connect(
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

    port(config.port)
    staticFiles.location("/public")

    before {
        logger.info(
                "${
                request.protocol()
                } ${
                request.ip()
                } ${
                request.requestMethod()
                } ${
                request.pathInfo()
                }${
                if (request.queryString() != null)
                    "?${request.queryString()}"
                else
                    ""
                }"
        )
    }

    get("/") {
        val model = HashMap<String, Any>()

        try {
            FreeMarkerEngine().render(
                    ModelAndView(model, "index.ftl")
            )
        } catch (e: Throwable) {
            e.printStackTrace()
        }
    }

    get("/documentation") {
        val model = HashMap<String, Any>()

        val md = mdParser.parse(javaClass.classLoader.getResource("Kyubey_Documentation.md").readText())
        val html = htmlRenderer.render(md)

        model["docs"] = html

        FreeMarkerEngine().render(ModelAndView(model, "docs.ftl"))
    }

    redirect.get("/invite", config.botInvite)
    redirect.get("/support", config.guildInvite)

    get("/faq") {
        val model = HashMap<String, Any>()

        FreeMarkerEngine().render(
                ModelAndView(model, "faq.ftl")
        )
    }

    get("/logs/:channel/:timestamp") {
        val model = HashMap<String, Any>()
        val timestamp = request.params(":timestamp").toLong()

        asyncTransaction(pool) {
            val query = Logs.select {
                Logs.channelId.eq(request.params(":channel").toLong()) and
                        Logs.timestamp.between(timestamp - 7200000, timestamp)
            }.limit(
                    request.queryParamOrDefault("limit", "100").toIntOrNull() ?: 100
            )
            var logsRaw: List<ResultRow> = query.toList()

            if (request.queryParams("event") != null)
                logsRaw = logsRaw.filter {
                    request.queryParamsValues("event").any {
                        e -> it[Logs.event] == e
                    }
                }

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


            /*if (query != null) {
                query = query.filter {
                    // this is safe, trust me
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

            model["logs"] = logs

            FreeMarkerEngine().render(
                    ModelAndView(model, "logs.ftl")
            )
        }.execute().get()
    }
}