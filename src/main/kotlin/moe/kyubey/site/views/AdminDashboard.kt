package moe.kyubey.site.views

import kotlinx.html.*
import moe.kyubey.site.entities.View
import org.json.JSONObject

object AdminDashboard : View {
    override fun render() = render(JSONObject())

    fun render(user: JSONObject): String {
        return Layout.admin {
            div {
                classes = setOf("row", "admin-cards")
                div {
                    classes = setOf("col", "s12", "l4")
                    div {
                        classes = setOf("card", "white")
                        div {
                            classes = setOf("card-content")
                            span {
                                classes = setOf("card-title")
                                +"Voice Connections"
                            }

                            canvas { id = "voice-connection-chart" }
                        }
                    }
                }
                div {
                    classes = setOf("col", "s12", "l4")
                    div {
                        classes = setOf("card", "kyubey-red")
                        div {
                            classes = setOf("card-content", "white-text")
                            span {
                                classes = setOf("card-title")
                                +"Title"
                            }
                            +"Content"
                        }
                    }
                }
                div {
                    classes = setOf("col", "s12", "l4")
                    div {
                        classes = setOf("card", "white")
                        div {
                            classes = setOf("card-content")
                            span {
                                classes = setOf("card-title")
                                +"Title"
                            }
                            +"Content"
                        }
                    }
                }
            }
        }
    }
}