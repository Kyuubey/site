package info.kyubey.site

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import info.kyubey.site.db.schema.Logs
// import com.rethinkdb.RethinkDB
import info.kyubey.site.entities.Config
import info.kyubey.site.entities.Log
import me.aurieh.ares.exposed.async.asyncTransaction
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

data class Feature(val name: String = "feature", val description: String = "description")

data class Item(val features: List<Feature>, val title: String = "Features")

fun main(args: Array<String>) {
    val mapper = ObjectMapper(YAMLFactory()).apply { registerModule(KotlinModule()) }
    val config = mapper.readValue<Config>(File("./config.yml"))
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

    /*val r = RethinkDB.r*/

    /*val conn = r.connection()
            .hostname(System.getenv("KYUBEY_DB_HOST"))
            .db(System.getenv("KYUBEY_DB_NAME"))
            .user(System.getenv("KYUBEY_DB_USER"), System.getenv("KYUBEY_DB_PASS"))
            .connect()*/

    before {
        logger.info("${request.protocol()} ${request.ip()} ${request.requestMethod()} ${request.pathInfo()}?${request.queryString()}")
    }

    get("/") {
        val model = HashMap<String, Any>()
        val items = mutableListOf<Item>()


        for (i in 0 until 4) {
            val features = mutableListOf<Feature>()
            for (x in 0 until 4) {
                features.add(Feature("Lorem ipsum", "Lorem ipsum dolor sit amet, appetere gubergren eloquentiam sit id, ne his idque detracto intellegat. Sed an soluta detracto torquatos. Mea ex assum omittam, ne decore iisque scripta usu. Alterum ocurreret vis ne, rebum graeci ut mea."))
            }
            items.add(Item(features))
        }

        model.put("items", items)

        try {
            FreeMarkerEngine().render(
                    ModelAndView(model, "index.ftl")
            )
        } catch (e: Throwable) {
            e.printStackTrace()
        }
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
                Log(
                        it[Logs.event],
                        it[Logs.messageId],
                        it[Logs.content],
                        it[Logs.attachments].toList(),
                        it[Logs.embeds].map { it.toMap() },
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

            model.put("logs", logs)

            FreeMarkerEngine().render(
                    ModelAndView(model, "logs-v2.ftl")
            )
        }.execute().get()
    }
}