package moe.kyubey.site.views.components

import kotlinx.html.*

fun BODY.donatePushpin() {
    div {
        classes = setOf("card", "kyubey-red", "z-depth-4")
        id = "we-dont-like-ads-too"
        div {
            classes = setOf("card-content", "kyubey-greyish-text", "center")
            span {
                classes = setOf("card-title")
                a {
                    classes = setOf("info kyubey-greyish-text")
                    i {
                        classes = setOf("fas fa-info-circle", "left")
                    }
                }
                +"Hey!"
                a {
                    classes = setOf("close kyubey-greyish-text")
                    i {
                        classes = setOf("fas fa-times", "right")
                    }
                }
            }
            p {
                +"We know you hate ads, we do too, and that's why there aren't any ads here! But hosting a site costs money, so donating would help us keep the site (and Kyubey) online!"
            }
            br()
            p {
                a("https://paypal.me/awau") {
                    classes = setOf("waves-effect", "waves-teal", "btn", "white", "kyubey-red-text", "center")
                    i {
                        classes = setOf("left", "fas", "fa-dollar-sign")
                    }
                    +"Donate!"
                }
            }
            p {
                a("https://patreon.com/yuwui") {
                    classes = setOf("kyubey-greyish-text")
                    style = "font-size:12px;"
                    +"Or become a patreon!"
                }
            }
        }
    }
}
