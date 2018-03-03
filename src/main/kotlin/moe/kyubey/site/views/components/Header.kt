package moe.kyubey.site.views.components

import kotlinx.html.*

fun BODY.mainHeader(pageName: String? = null) {
    header {
        div {
            classes = setOf("section")
            div {
                classes = setOf("container")
                div {
                    classes = setOf("row", "center")
                    div {
                        classes = setOf("col", "left")
                        h4 {
                            classes = setOf("header", "kyubey-red-text", "center-on-small-only")
                            a("/") {
                                classes = setOf("kyubey-red-text")
                                style = "font-family:'Anydore';"
                                +"\uE014yube\uE137"
                            }
                        }
                    }
                    div {
                        classes = setOf("col", "right")
                        br
                        /*a("https://blog.kyubey.moe") {
                            classes = setOf("hide-on-med-and-down", "waves-effect", "waves-teal", "btn-flat")
                            +"Blog"
                        }*/
                        a("/support") {
                            classes = setOf("hide-on-med-and-down", "waves-effect", "waves-teal", "btn-flat")
                            +"Support"
                        }
                        a("/faq") {
                            classes = setOf("hide-on-med-and-down", "waves-effect", "waves-teal", "btn-flat")
                            +"FAQ"
                        }
                        a("/invite") {
                            classes = setOf("hide-on-med-and-down", "waves-effect", "waves-teal", "btn", "kyubey-red")
                            +"Invite!"
                        }
                        ul {
                            id = "nav-dropdown"
                            classes = setOf("dropdown-content")
                            li {
                                /*a("https://blog.kyubey.moe") {
                                    +"Blog"
                                }*/
                                a("/support") {
                                    +"Support"
                                }
                                a("/faq") {
                                    +"FAQ"
                                }
                            }
                        }
                        a("#") {
                            classes = setOf("hide-on-large-only", "dropdown-button", "btn-flat")
                            attributes["data-activates"] = "nav-dropdown"
                            i {
                                classes = setOf("fas", "fa-ellipsis-v")
                            }
                        }
                    }
                }
                div {
                    classes = setOf("row", "center")
                    div {
                        classes = setOf("col", "s12", "m1", "left")
                        img {
                            src = "/img/kyubey.png"
                            alt = "kyubey.png"
                            style = "width:250px;"
                        }
                    }
                    div {
                        classes = setOf("col", "s12", "m6", "right")
                        h1 {
                            classes = setOf("kyubey-red-text")
                            style = "font-family:'Anydore';"
                            +"\uE014yube\uE137"
                        }
                        if (pageName == null) {
                            h5 { +"He'll make your Discord magical!" }
                            a("/invite") {
                                classes = setOf("waves-effect", "waves-light", "btn", "kyubey-red")
                                i { classes = setOf("left", "fas", "fa-sign-in-alt") }
                                +"Invite!"
                            }
                        } else {
                            h5 { +pageName }
                        }
                    }
                }
            }
        }
    }
}

fun BODY.logsHeader() {
    div {
        classes = setOf("modal")
        id = "filter-modal"
        div {
            classes = setOf("modal-content")
            h4 { +"Filters" }
            div {
                classes = setOf("row")
                div {
                    classes = setOf("col", "s12", "l4")
                    h5 { +"Time" }
                    div {
                        classes = setOf("row")
                        div {
                            classes = setOf("input-field", "col", "s12")
                            label {
                                htmlFor = "timestamp-filter-start"
                                +"Timestamp start"
                            }
                            input {
                                type = InputType.text
                                classes = setOf("timepicker")
                                id = "timestamp-filter-start"
                            }
                        }
                        div {
                            classes = setOf("input-field", "col", "s12")
                            label {
                                htmlFor = "timestamp-filter-end"
                                +"Timestamp end"
                            }
                            input {
                                type = InputType.text
                                classes = setOf("timepicker")
                                id = "timestamp-filter-end"
                            }
                        }
                    }
                }
                div {
                    classes = setOf("col", "s12", "l8")
                    h5 { +"Other" }
                    div {
                        classes = setOf("row")
                        div {
                            classes = setOf("input-field", "col", "s6")
                            select {
                                id = "events-filter"
                                multiple = true
                                option {
                                    value = ""
                                    disabled = true
                                    selected = true
                                    +"Select events"
                                }
                                option {
                                    value = "delete"
                                    +"Deleted"
                                }
                                option {
                                    value = "create"
                                    +"Created"
                                }
                                option {
                                    value = "update"
                                    +"Edited"
                                }
                            }
                            label { +"Events" }
                        }
                        div {
                            classes = setOf("input-field", "col", "s6")
                            label {
                                htmlFor = "user-filter"
                                +"User ID"
                            }
                            input {
                                type = InputType.text
                                id = "user-filter"
                            }
                        }
                        div {
                            classes = setOf("input-field", "col", "s6")
                            label {
                                htmlFor = "keyword-filter"
                                +"Keywords (user ',' to split)"
                            }
                            input {
                                type = InputType.text
                                id = "keyword-filter"
                            }
                        }
                    }
                }
            }
        }
        div {
            classes = setOf("modal-footer")
            a("#") {
                id = "apply-log-filters"
                classes = setOf("modal-action", "modal-close", "waves-effect", "waves-teal", "btn-flat")
                +"Apply"
            }
        }
    }
    header {
        nav {
            classes = setOf("kyubey-red")
            div {
                classes = setOf("nav-wrapper")
                a("/") {
                    classes = setOf("brand-logo")
                    span {
                        style = "font-family:'Anydore';margin-left:10px;"
                        +"\uE014yube\uE137"
                    }
                    span {
                        style = "font-size:25px;"
                        +" Logs"
                    }
                }
                ul {
                    id = "nav-mobile"
                    classes = setOf("right", "hide-on-med-and-down")
                    li {
                        a("#filter-modal") {
                            classes = setOf("modal-trigger")
                            i {
                                classes = setOf("fas fa-filter")
                            }
                        }
                    }
                    li {
                        a("#") {
                            i {
                                classes = setOf("fas", "fa-ellipsis-v")
                            }
                        }
                    }
                }
            }
        }
    }
}

fun BODY.secondaryHeader(pageName: String = "") {
    header {
        nav {
            classes = setOf("kyubey-red")
            div {
                classes = setOf("nav-wrapper")
                a("/") {
                    classes = setOf("brand-logo")
                    style = "margin-left:10px;"
                    span {
                        style = "font-family:'Anydore';"
                        +"\uE014yube\uE137"
                    }
                    span {
                        style = "font-size:25px;"
                        +" $pageName"
                    }
                }
                ul {
                    id = "nav-mobile"
                    classes = setOf("right", "hide-on-med-and-down")
                    li {
                        a("#") {
                            i {
                                classes = setOf("fas", "fa-ellipsis-v")
                            }
                        }
                    }
                }
            }
        }
    }
}

fun BODY.adminHeader() {
    header {
        nav {
            classes = setOf("nav-wrapper")
            a("/") {
                classes = setOf("brand-logo", "center")
                span {
                    style = "font-family:'Anydore';"
                    +"\uE014yube\uE137"
                }
                span {
                    style = "font-size:25px;"
                    +" Admin"
                }
            }
            ul {
                classes = setOf("left")
                li {
                    a("#") {
                        style = "line-height:4.75rem;"
                        i {
                            classes = setOf("fas", "fa-bars")
                        }
                    }
                }
            }
        }
    }
}