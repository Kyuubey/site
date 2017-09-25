package info.kyubey.site

import com.rethinkdb.RethinkDB
import org.slf4j.LoggerFactory
import spark.ModelAndView
import spark.kotlin.*
import spark.template.freemarker.FreeMarkerEngine

class Feature(val name: String = "feature", val description: String = "description")

class Item(val features: List<Feature>, val title: String = "Features")

fun main(args: Array<String>) {
    port(1991)
    staticFiles.location("/public")

    val logger = LoggerFactory.getLogger("main")
    val r = RethinkDB.r

    // TODO switch to PostgreSQL once rewrite is up

    val conn = r.connection()
            .hostname(System.getenv("KYUBEY_DB_HOST"))
            .db(System.getenv("KYUBEY_DB_NAME"))
            .user(System.getenv("KYUBEY_DB_USER"), System.getenv("KYUBEY_DB_PASS"))
            .connect()

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

    redirect.get("/invite", "https://discordapp.com/oauth2/authorize?client_id=236829027539746817&scope=bot&permissions=3468486")
    redirect.get("/support", "https://discord.gg/qngdWCZ")

    get("/faq") {
        val model = HashMap<String, Any>()

        FreeMarkerEngine().render(
                ModelAndView(model, "faq.ftl")
        )
    }

    get("/logs/:channel/:timestamp") {
        val model = HashMap<String, Any>()

        // val first = request.params(":timestamp").toBigInteger() - 7200000.toBigInteger()
        var query: List<Any>? = null

        try {
            query = r
                    .table("Logs")
                    .orderBy().optArg("index", r.desc("timestamp"))
                    .filter { log ->
                        log
                                .g("channel")
                                .g("id")
                                .eq(request.params(":channel"))
                                // FIXME meme
                                /*.and(
                                        log
                                                .g("timestamp")
                                                .lt(request.params(":timestamp").toBigInteger())
                                )
                                .and(
                                        log
                                                .g("timestamp")
                                                .gt(first)
                                )*/
                    }
                    .limit(100)
                    .coerceTo("array")
                    .run<List<Any>>(conn)
        } catch (e: Throwable) {
            e.printStackTrace()
        }

        if (query != null) {
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

            model.put("logs", query)
        }

        FreeMarkerEngine().render(
                ModelAndView(model, "logs-v2.ftl")
        )
    }
}