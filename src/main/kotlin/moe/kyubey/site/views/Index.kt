package moe.kyubey.site.views

import kotlinx.html.*
import moe.kyubey.site.entities.View

object Index : View {
    override fun render(): String {
        return Layout.main {
            div {
                classes = setOf("row")
                div {
                    classes = setOf("carousel", "center", "carousel-slider", "features")
                    attributes["data-indicators"] = "true"

                    div {
                        classes = setOf("carousel-item", "kyubey-red", "white-text")
                        h2 {
                            +"Title"
                        }
                        p {
                            +"Description"
                        }
                    }
                    div {
                        classes = setOf("carousel-item", "kyubey-red", "white-text")
                        h2 {
                            +"Title"
                        }
                        p {
                            +"Description"
                        }
                    }
                    div {
                        classes = setOf("carousel-item", "kyubey-red", "white-text")
                        h2 {
                            +"Title"
                        }
                        p {
                            +"Description"
                        }
                    }
                }
            }
        }
    }
}