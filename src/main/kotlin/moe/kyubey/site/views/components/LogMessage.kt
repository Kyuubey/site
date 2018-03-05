package moe.kyubey.site.views.components

import kotlinx.html.*
import moe.kyubey.site.entities.Log
import java.text.SimpleDateFormat
import java.util.*

fun UL.logMessage(log: Log) {
    val color = when (log.event) {
        "CREATE" -> "white"
        "UPDATE" -> "kyubey-pink"
        "DELETE" -> "kyubey-red"
        else -> "kyubey-greyish"
    }

    li {
        div {
            classes = setOf("card", "hoverable", color)
            div {
                classes = setOf("card-content")
                div {
                    classes = setOf("row")
                    div {
                        classes = setOf("hide-on-med-and-down", "col", "l2")
                        img {
                            classes = setOf("circle")
                            src = log.authorAvatar
                            alt = "avatar"
                            height = "75"
                        }
                    }
                    div {
                        classes = setOf("col", "s11", "l8")
                        h6 {
                            classes = setOf("truncate")
                            style = "font-size:20px;font-weight:lighter;"
                            +"${log.authorName}#${log.authorDiscrim}${if (log.authorNick.isNullOrBlank()) "" else " (${log.authorNick})"}"
                        }
                        p {
                            classes = setOf("markup", "has-emotes")
                            style = "word-wrap:break-word;"
                            +log.content
                        }
                        log.embeds
                                .asSequence()
                                .filter { it["type"] == "RICH" }
                                .forEach {
                                    div {
                                        classes = setOf("embed-wrapper")
                                        div {
                                            classes = setOf("embed", "embed-color", "z-depth-2")
                                            attributes["color"] = if ("color" in it) {
                                                val color = it["color"] as Int

                                                color.toString()
                                            } else
                                                "4096"
                                        }
                                        div {
                                            classes = setOf("embed", "embed-content", "z-depth-2")
                                            div {
                                                classes = setOf("inner-content")
                                                if ("author" in it) {
                                                    val author = it["author"] as Map<String, Any>

                                                    div {
                                                        classes = setOf("embed-author")
                                                        if ("icon_url" in author) {
                                                            img {
                                                                classes = setOf("embed-author-icon")
                                                                src = author["icon_url"] as String
                                                                alt = "icon"
                                                            }
                                                        }
                                                        if ("name" in author) {
                                                            a(if ("url" in author) author["url"] as String else "#") {
                                                                +(author["name"] as String)
                                                            }
                                                        }
                                                    }
                                                }
                                                if ("title" in it) {
                                                    a(if ("url" in it) it["url"] as String else "#") {
                                                        classes = setOf("embed-title", "has-emotes", "markup", "link")
                                                        +(it["title"] as String)
                                                    }
                                                }

                                                if ("description" in it) {
                                                    div {
                                                        classes = setOf("embed-description", "has-emotes", "markup")
                                                        +(it["description"] as String)
                                                    }
                                                }

                                                if ("fields" in it) {
                                                    val fields = it["fields"] as List<Map<String, Any>>
                                                    for (field in fields) {
                                                        div {
                                                            classes = setOf("embed-field")

                                                            if ("inline" in field && (field["inline"] as Boolean))
                                                                classes += "field-inline"

                                                            div {
                                                                classes = setOf("embed-field-title", "markup", "has-emotes")
                                                                +(field["name"] as String)
                                                            }
                                                            div {
                                                                classes = setOf("embed-field-markup", "has-emotes", "markup")
                                                                +(field["value"] as String)
                                                            }
                                                        }
                                                    }
                                                }

                                                if ("image" in it) {
                                                    val image = it["image"] as Map<String, Any>
                                                    br
                                                    br
                                                    img {
                                                        classes = setOf("embed-image")
                                                        src = image["url"] as String
                                                        alt = "image"
                                                    }
                                                }

                                                if ("footer" in it) {
                                                    val footer = it["footer"] as Map<String, Any>
                                                    br
                                                    br
                                                    div {
                                                        classes = setOf("embed-footer", "left")
                                                        if ("icon_url" in footer) {
                                                            img {
                                                                classes = setOf("embed-footer-icon")
                                                                src = footer["icon_url"] as String
                                                                alt = "icon"
                                                            }
                                                        }

                                                        a(if ("url" in footer) footer["url"] as String else "#") {
                                                            classes = setOf("embed-footer-text", "has-emotes", "link")
                                                            +(footer["text"] as String)
                                                        }
                                                    }
                                                }
                                            }
                                            if ("thumbnail" in it) {
                                                val thumb = it["thumbnail"] as Map<String, Any>
                                                img {
                                                    classes = setOf("embed-thumbnail")
                                                    src = thumb["url"] as String
                                                    alt = "thumbnail"
                                                }
                                            }
                                        }
                                    }
                                }
                        for (attachment in log.attachments) {
                            img {
                                height = "128"
                                src = attachment
                                alt = "attachment"
                            }
                        }
                    }
                    div {
                        classes = setOf("col", "s1", "l2")
                        when (log.event) {
                            "CREATE" -> {
                                p {
                                    classes = setOf("left", "hide-on-med-and-down")
                                    i { classes = setOf("fas", "fa-comment") }
                                    +" Created"
                                }
                                i {
                                    classes = setOf("fas", "fa-comment", "left", "hide-on-large-only", "tooltipped")
                                    attributes["data-position"] = "left"
                                    attributes["data-tooltip"] = "Created"
                                }
                            }

                            "DELETE" -> {
                                p {
                                    classes = setOf("left", "hide-on-med-and-down")
                                    i { classes = setOf("fas", "fa-trash") }
                                    +" Deleted"
                                }
                                i {
                                    classes = setOf("fas", "fa-trash", "left", "hide-on-large-only", "tooltipped")
                                    attributes["data-position"] = "left"
                                    attributes["data-tooltip"] = "Deleted"
                                }
                            }

                            "UPDATE" -> {
                                p {
                                    classes = setOf("left", "hide-on-med-and-down")
                                    i { classes = setOf("fas", "fa-edit") }
                                    +" Edited"
                                }
                                i {
                                    classes = setOf("fas", "fa-edit", "left", "hide-on-large-only", "tooltipped")
                                    attributes["data-position"] = "left"
                                    attributes["data-tooltip"] = "Edited"
                                }
                            }

                            else -> {
                                p {
                                    classes = setOf("left", "hide-on-med-and-down")
                                    i { classes = setOf("fas", "fa-question") }
                                    +" Unknown"
                                }
                                i {
                                    classes = setOf("fas", "fa-question", "left", "hide-on-large-only", "tooltipped")
                                    attributes["data-position"] = "left"
                                    attributes["data-tooltip"] = "Unknown"
                                }
                            }
                        }

                        val dateFormat = SimpleDateFormat("hh:mm:ss")

                        br
                        p {
                            classes = setOf("left", "hide-on-med-and-down")
                            i { classes = setOf("fas", "fa-calendar-alt") }
                            +" ${dateFormat.format(Date(log.timestamp))}"
                        }
                        i {
                            classes = setOf("fas", "fa-calendar-alt", "left", "hide-on-large-only", "tooltipped")
                            attributes["data-position"] = "left"
                            attributes["data-tooltip"] = dateFormat.format(Date(log.timestamp))
                        }
                        br
                        p {
                            classes = setOf("left", "hide-on-med-and-down")
                            style = "font-size:0.5rem;line-height:2.1;"
                            i { classes = setOf("fas", "fa-id-card") }
                            +" ${log.messageId}"
                        }
                        i {
                            classes = setOf("fas", "fa-id-card", "left", "hide-on-large-only", "tooltipped")
                            attributes["data-position"] = "left"
                            attributes["data-tooltip"] = log.messageId.toString()
                        }
                    }
                }
            }
        }
    }
}