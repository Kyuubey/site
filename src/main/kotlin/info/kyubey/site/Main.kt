package info.kyubey.site

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
}