package info.kyubey.site

import com.rethinkdb.RethinkDB
import spark.ModelAndView
import spark.kotlin.get
import spark.kotlin.port
import spark.kotlin.staticFiles
import spark.template.velocity.VelocityTemplateEngine

class Feature(val name: String = "feature", val description: String = "description")

class Item(val features: List<Feature>, val title: String = "Features")

fun main(args: Array<String>) {
    port(1991)
    staticFiles.location("/public")

    val r = RethinkDB.r

    // TODO switch to PostgreSQL once rewrite is up

    val conn = r.connection()
            .hostname(System.getenv("KYUBEY_DB_HOST"))
            .db(System.getenv("KYUBEY_DB_NAME"))
            .user(System.getenv("KYUBEY_DB_USER"), System.getenv("KYUBEY_DB_PASS"))
            .connect()

    get("/") {
        val model = HashMap<String, Any>()
        val items = mutableListOf<Item>()


        for (i in 0 until 4) {
            val features = mutableListOf<Feature>()
            for (x in 0 until 4) {
                features.add(Feature())
            }
            items.add(Item(features))
        }

        model.put("items", items)

        VelocityTemplateEngine().render(
                ModelAndView(model, "index.vm")
        )
    }

    get("/faq") {
        val model = HashMap<String, Any>()

        VelocityTemplateEngine().render(
                ModelAndView(model, "faq.vm")
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

            model.put("logs", query)
        }

        VelocityTemplateEngine().render(
                ModelAndView(model, "logs.vm")
        )
    }
}