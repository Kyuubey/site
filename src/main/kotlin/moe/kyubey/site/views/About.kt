package moe.kyubey.site.views

import kotlinx.html.*
import moe.kyubey.site.entities.View

object About : View {
    override fun render(): String {
        return Layout.main("Kyubey - About", "Kyubey is a free and open-source Discord bot.", "About") {
            div {
                classes = setOf("row")
                div {
                    classes = setOf("col", "s12", "l6", "offset-l3")
                    div {
                        classes = setOf("card", "white")
                        div {
                            classes = setOf("card-content", "kyubey-red-text")
                            span {
                                classes = setOf("card-title")
                                +"About Kyubey"
                            }
                            p {
                                +"Kyubey is a free and open-source Discord bot, made for fun."
                                br
                                br
                                +"Kyubey was started by Noud Kerver back in September 2016 as a nonprofit Discord bot."
                                br
                                +"Kyubey's goal is to become one of the greatest Discord bots."
                                br
                                br
                                +"Even though Kyubey started as closed-source, all repositories are now open-source."
                            }
                        }
                        div {
                            classes = setOf("card-action")
                            a("https://github.com/noud02/Akatsuki") { +"GitHub" }
                            a("mailto:noud.kerver@hotmail.nl") { +"Contact" }
                        }
                    }
                }
            }
        }
    }
}