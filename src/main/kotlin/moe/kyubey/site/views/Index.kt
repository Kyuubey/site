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
                            +"Music"
                        }
                        p {
                            +"Music that works, free, for everyone."
                        }
                    }
                    div {
                        classes = setOf("carousel-item", "kyubey-red", "white-text")
                        h2 {
                            +"Fun"
                        }
                        p {
                            +"Generate a meme, hug someone or create custom commands using Lua. Kyubey makes your server fun for everyone!"
                        }
                    }
                    div {
                        classes = setOf("carousel-item", "kyubey-red", "white-text")
                        h2 {
                            +"Moderation"
                        }
                        p {
                            +"From banning to muting, adblocker to modlogs, Kyubey has everything you need to keep your server safe."
                        }
                    }
                }
            }
        }
    }
}