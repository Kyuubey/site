package moe.kyubey.site.views.components

import kotlinx.html.*

fun BODY.mainFooter() {
    footer {
        div {
            classes = setOf("section")
            div {
                classes = setOf("container")
                div {
                    classes = setOf("row")
                    div {
                        classes = setOf("col", "left")
                        ul {
                            li {
                                a("/faq") {
                                    classes = setOf("btn-floating", "kyubey-red")
                                    i {
                                        classes = setOf("fas", "fa-edit")
                                    }
                                }
                                span {
                                    classes = setOf("hide-on-med-and-down")
                                    +" Blog"
                                }
                            }
                            li { br }
                            li {
                                a("https://patreon.com/noud") {
                                    classes = setOf("btn-floating", "kyubey-red")
                                    i {
                                        classes = setOf("fas", "fa-dollar-sign")
                                    }
                                }
                                span {
                                    classes = setOf("hide-on-med-and-down")
                                    +" Donate"
                                }
                            }
                        }
                    }
                    div {
                        classes = setOf("col", "left")
                        ul {
                            li {
                                a("/about") {
                                    classes = setOf("btn-floating", "kyubey-red")
                                    i {
                                        classes = setOf("fab", "fa-github-alt")
                                    }
                                }
                                span {
                                    classes = setOf("hide-on-med-and-down")
                                    +" About"
                                }
                            }
                            li { br }
                            li {
                                a("/invite") {
                                    classes = setOf("btn-floating", "kyubey-red")
                                    i {
                                        classes = setOf("fas", "fa-sign-in-alt")
                                    }
                                }
                                span {
                                    classes = setOf("hide-on-med-and-down")
                                    +" Invite!"
                                }
                            }
                        }
                    }
                    div {
                        classes = setOf("col", "right")
                        ul {
                            li {
                                a("https://github.com/Kyuubey") {
                                    classes = setOf("black-text")
                                    i {
                                        classes = setOf("fab", "fa-github-square")
                                    }
                                    +" GitHub"
                                }
                            }
                            li {
                                a("https://discord.gg/qngdWCZ") {
                                    classes = setOf("black-text")
                                    i {
                                        classes = setOf("fab", "fa-discord")
                                    }
                                    +" Discord"
                                }
                            }
                            li {
                                a("https://noud.moe") {
                                    classes = setOf("black-text")
                                    i {
                                        classes = setOf("fas fa-server")
                                    }
                                    +" noud.moe"
                                }
                            }
                        }
                    }
                }
                div {
                    classes = setOf("row")
                    div {
                        classes = setOf("col", "s3", "offset-s1")
                        sub {
                            +"Quick Links"
                        }
                    }
                }
                div {
                    classes = setOf("row")
                    div {
                        classes = setOf("col", "left")
                        h5 {
                            classes = setOf("kyubey-red-text")
                            style = "font-family:'Anydore';"
                            +"\uE014yube\uE137"
                        }
                    }
                    div {
                        classes = setOf("col", "right")
                        style = "margin-top:15px;"
                        span {
                            +"Design by "
                            a("https://github.com/sr229") {
                                classes = setOf("link", "kyubey-red-text")
                                +"Enra"
                            }
                        }
                    }
                }
            }
        }
    }
}