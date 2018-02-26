package moe.kyubey.site.views

import kotlinx.html.*
import moe.kyubey.site.entities.View

object Login : View {
    override fun render(): String {
        return Layout.blank("Kyubey - Login", "Login to manage your server(s)!") {
            div {
                classes = setOf("section")
                div {
                    classes = setOf("container", "center")
                    div {
                        classes = setOf("row")
                        div {
                            classes = setOf("col", "s12", "l6", "offset-l3")
                            div {
                                classes = setOf("card", "white")
                                div {
                                    classes = setOf("card-content", "center")
                                    span {
                                        classes = setOf("card-title")
                                        +"Login"
                                    }
                                    a("/login/discord") {
                                        classes = setOf("waves-effect", "waves-light", "btn", "kyubey-red")
                                        i { classes = setOf("left", "fab", "fa-discord") }
                                        +"Login with Discord"
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}