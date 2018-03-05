package moe.kyubey.site.views

import kotlinx.html.*
import kotlinx.html.stream.appendHTML
import moe.kyubey.site.views.components.*
import moe.kyubey.site.views.stylesheets.mainStyle

object Layout {
    private val stylesheet = mainStyle().render()
    private const val KEYWORDS = "kyubey, discord, music, bot, logs, fun, nsfw, custom commands, contract"
    private const val DESCRIPTION = "A fun Discord bot with features like music, memes, custom commands and more!"

    fun main(pageTitle: String = "Kyubey", pageDesc: String = "He'll make your Discord magical!", pageName: String? = null, block: DIV.() -> Unit = {}): String {
        return buildString {
            appendln("<!DOCTYPE html>")
            appendHTML().html {
                head {
                    meta(charset="UTF-8")
                    meta("viewport", "width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes")
                    meta { attributes["og:title"] = pageTitle }
                    meta { attributes["og:description"] = pageDesc }
                    meta { name = "keywords"; content = KEYWORDS }
                    meta { name = "description"; content = DESCRIPTION }
                    meta { name = "google-site-verification"; content = "FRAz8Nsa7l05see2iXE8juZhZ8XcXJx9-ZOIjdHmDOw" }
                    title(pageTitle)
                    link("//fonts.googleapis.com/css?family=Noto+Sans", "stylesheet")
                    link("//fonts.googleapis.com/icon?family=Material+Icons", "stylesheet")
                    link("//use.fontawesome.com/releases/v5.0.6/css/all.css", "stylesheet")
                    link("//cdnjs.cloudflare.com/ajax/libs/highlight.js/9.12.0/styles/atom-one-light.min.css", "stylesheet")
                    link("//cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css", "stylesheet")
                    script("text/javascript", "//code.jquery.com/jquery-3.2.1.min.js") {}
                    script("text/javascript", "//cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js") {}
                    script("text/javascript", "//cdnjs.cloudflare.com/ajax/libs/highlight.js/9.12.0/highlight.min.js") {}
                    script("text/javascript", "//twemoji.maxcdn.com/2/twemoji.min.js?2.3.0") {}
                    script("text/javascript", "//cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment-with-locales.min.js") {}
                    script("text/javascript", "//cdnjs.cloudflare.com/ajax/libs/markdown-it/8.4.0/markdown-it.min.js") {}
                    script("text/javascript", "/js/script.min.js") {}
                    style { type = "text/css"; unsafe { raw(stylesheet) } }
                }
                body {
                    donatePushpin()
                    mainHeader(pageName)
                    div {
                        classes = setOf("section", "kyubey-red")
                        div {
                            classes = setOf("container")
                            block()
                        }
                    }
                    mainFooter()
                }
            }
            appendln()
        }
    }

    fun logs(pageTitle: String = "Kyubey - Logs", pageDesc: String = "Message Logs", block: DIV.() -> Unit = {}): String {
        return buildString {
            appendln("<!DOCTYPE html>")
            appendHTML().html {
                head {
                    meta(charset="UTF-8")
                    meta("viewport", "width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes")
                    meta { attributes["og:title"] = pageTitle }
                    meta { attributes["og:description"] = pageDesc }
                    title(pageTitle)
                    link("//fonts.googleapis.com/css?family=Noto+Sans", "stylesheet")
                    link("//fonts.googleapis.com/icon?family=Material+Icons", "stylesheet")
                    link("//use.fontawesome.com/releases/v5.0.6/css/all.css", "stylesheet")
                    link("//cdnjs.cloudflare.com/ajax/libs/highlight.js/9.12.0/styles/atom-one-light.min.css", "stylesheet")
                    link("//cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css", "stylesheet")
                    script("text/javascript", "//code.jquery.com/jquery-3.2.1.min.js") {}
                    script("text/javascript", "//cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js") {}
                    script("text/javascript", "//cdnjs.cloudflare.com/ajax/libs/highlight.js/9.12.0/highlight.min.js") {}
                    script("text/javascript", "//twemoji.maxcdn.com/2/twemoji.min.js?2.3.0") {}
                    script("text/javascript", "//cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment-with-locales.min.js") {}
                    script("text/javascript", "//cdnjs.cloudflare.com/ajax/libs/markdown-it/8.4.0/markdown-it.min.js") {}
                    script("text/javascript", "/js/script.min.js") {}
                    style { type = "text/css"; unsafe { raw(stylesheet) } }
                }
                body {
                    donatePushpin()
                    logsHeader()
                    div {
                        div {
                            classes = setOf("section", "kyubey-greyish")
                            div {
                                classes = setOf("container")
                                block()
                            }
                        }
                    }
                    mainFooter()
                }
            }
            appendln()
        }
    }

    fun secondary(pageTitle: String = "Kyubey", pageDesc: String = "He'll make your Discord magical!", pageName: String = "", block: DIV.() -> Unit = {}): String {
        return buildString {
            appendln("<!DOCTYPE html>")
            appendHTML().html {
                head {
                    meta(charset="UTF-8")
                    meta("viewport", "width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes")
                    meta { attributes["og:title"] = pageTitle }
                    meta { attributes["og:description"] = pageDesc }
                    meta { name = "keywords"; content = KEYWORDS }
                    meta { name = "description"; content = DESCRIPTION }
                    title(pageTitle)
                    link("//fonts.googleapis.com/css?family=Noto+Sans", "stylesheet")
                    link("//fonts.googleapis.com/icon?family=Material+Icons", "stylesheet")
                    link("//use.fontawesome.com/releases/v5.0.6/css/all.css", "stylesheet")
                    link("//cdnjs.cloudflare.com/ajax/libs/highlight.js/9.12.0/styles/atom-one-light.min.css", "stylesheet")
                    link("//cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css", "stylesheet")
                    script("text/javascript", "//code.jquery.com/jquery-3.2.1.min.js") {}
                    script("text/javascript", "//cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js") {}
                    script("text/javascript", "//cdnjs.cloudflare.com/ajax/libs/highlight.js/9.12.0/highlight.min.js") {}
                    script("text/javascript", "//twemoji.maxcdn.com/2/twemoji.min.js?2.3.0") {}
                    script("text/javascript", "//cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment-with-locales.min.js") {}
                    script("text/javascript", "//cdnjs.cloudflare.com/ajax/libs/markdown-it/8.4.0/markdown-it.min.js") {}
                    script("text/javascript", "/js/script.min.js") {}
                    style { type = "text/css"; unsafe { raw(stylesheet) } }
                }
                body {
                    donatePushpin()
                    secondaryHeader(pageName)
                    div {
                        div {
                            classes = setOf("section", "kyubey-greyish")
                            div {
                                classes = setOf("container", "documentation")
                                block()
                            }
                        }
                    }
                    mainFooter()
                }
            }
            appendln()
        }
    }

    fun blank(pageTitle: String = "Kyubey", pageDesc: String = "He'll make your Discord magical!", block: BODY.() -> Unit = {}): String {
        return buildString {
            appendln("<!DOCTYPE html>")
            appendHTML().html {
                head {
                    meta(charset="UTF-8")
                    meta("viewport", "width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes")
                    meta { attributes["og:title"] = pageTitle }
                    meta { attributes["og:description"] = pageDesc }
                    meta { name = "keywords"; content = KEYWORDS }
                    meta { name = "description"; content = DESCRIPTION }
                    title(pageTitle)
                    link("//fonts.googleapis.com/css?family=Noto+Sans", "stylesheet")
                    link("//fonts.googleapis.com/icon?family=Material+Icons", "stylesheet")
                    link("//use.fontawesome.com/releases/v5.0.6/css/all.css", "stylesheet")
                    link("//cdnjs.cloudflare.com/ajax/libs/highlight.js/9.12.0/styles/atom-one-light.min.css", "stylesheet")
                    link("//cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css", "stylesheet")
                    script("text/javascript", "//code.jquery.com/jquery-3.2.1.min.js") {}
                    script("text/javascript", "//cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js") {}
                    script("text/javascript", "//cdnjs.cloudflare.com/ajax/libs/highlight.js/9.12.0/highlight.min.js") {}
                    script("text/javascript", "//twemoji.maxcdn.com/2/twemoji.min.js?2.3.0") {}
                    script("text/javascript", "//cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment-with-locales.min.js") {}
                    script("text/javascript", "//cdnjs.cloudflare.com/ajax/libs/markdown-it/8.4.0/markdown-it.min.js") {}
                    script("text/javascript", "/js/script.min.js") {}
                    style { type = "text/css"; unsafe { raw(stylesheet) } }
                }
                body {
                    block()
                }
            }
            appendln()
        }
    }

    fun admin(block: DIV.() -> Unit = {}): String {
        return buildString {
            appendln("<!DOCTYPE html>")
            appendHTML().html {
                head {
                    meta(charset="UTF-8")
                    meta("viewport", "width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes")
                    meta { attributes["og:title"] = "Kyubey - Admin Panel" }
                    meta { attributes["og:description"] = "\uD83E\uDD14" }
                    title("Kyubey - Admin Panel")
                    link("//fonts.googleapis.com/css?family=Noto+Sans", "stylesheet")
                    link("//fonts.googleapis.com/icon?family=Material+Icons", "stylesheet")
                    link("//use.fontawesome.com/releases/v5.0.6/css/all.css", "stylesheet")
                    link("//cdnjs.cloudflare.com/ajax/libs/highlight.js/9.12.0/styles/atom-one-light.min.css", "stylesheet")
                    link("//cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css", "stylesheet")
                    link("//cdn.jsdelivr.net/npm/xterm@3.1.0/dist/xterm.css", "stylesheet")
                    script("text/javascript", "//code.jquery.com/jquery-3.2.1.min.js") {}
                    script("text/javascript", "//cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js") {}
                    script("text/javascript", "//cdnjs.cloudflare.com/ajax/libs/highlight.js/9.12.0/highlight.min.js") {}
                    script("text/javascript", "//twemoji.maxcdn.com/2/twemoji.min.js?2.3.0") {}
                    script("text/javascript", "//cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment-with-locales.min.js") {}
                    script("text/javascript", "//cdnjs.cloudflare.com/ajax/libs/markdown-it/8.4.0/markdown-it.min.js") {}
                    script("text/javascript", "//cdn.jsdelivr.net/npm/xterm@3.1.0/dist/xterm.js") {}
                    script("text/javascript", "//cdn.jsdelivr.net/npm/xterm@3.1.0/dist/addons/fit/fit.js") {}
                    script("text/javascript", "//cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.min.js") {}
                    script("text/javascript", "/js/script.min.js") {}
                    script("text/javascript", "/js/dashboard.js") {}
                    style { type = "text/css"; unsafe { raw(stylesheet) } }
                }
                body {
                    terminalOverlay()
                    adminHeader()
                    div {
                        div {
                            classes = setOf("section", "kyubey-greyish")
                            div {
                                classes = setOf("container", "admin-dashboard")
                                block()
                            }
                        }
                    }
                }
            }
            appendln()
        }
    }
}