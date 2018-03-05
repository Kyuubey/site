package moe.kyubey.site.views

import moe.kyubey.site.entities.Log
import moe.kyubey.site.entities.View
import moe.kyubey.site.views.components.logMessage
import kotlinx.html.*

object Logs : View {
    override fun render() = render(emptyList())

    fun render(logs: List<Log>): String {
        return Layout.logs {
            if (logs.isNotEmpty()) {
                div {
                    classes = setOf("row")
                    div {
                        classes = setOf("col", "s12", "l4")
                        h5 {
                            style = "font-weight:bold;"
                            +"Logs for ${logs[0].guildName}"
                        }
                        p { +"Channel: #${logs[0].channelName}" }
                        p {
                            +"Last message: "
                            span {
                                classes = setOf("momentify")
                                +logs[0].timestamp.toString()
                            }
                        }
                    }
                }
                div {
                    classes = setOf("row")
                    div {
                        classes = setOf("col s12")
                        ul { for (log in logs.asReversed()) logMessage(log) }
                    }
                }
            } else {
                div {
                    classes = setOf("row")
                    div {
                        classes = setOf("s12", "center")
                        h3 { +":<" }
                        h5 { +"No logs found." }
                    }
                }
            }
        }
    }
}