package moe.kyubey.site.views.stylesheets

import azadev.kotlin.css.*
import azadev.kotlin.css.dimens.*

fun mainStyle(): Stylesheet {
    return Stylesheet {
        "*" {
            fontFamily = "'Noto Sans', 'Roboto', sans-serif"
        }

        html and body {
            margin = 0
            width = 100.percent
            height = 100.percent
            backgroundColor = 0xEBEBEB
        }

        ".card" {
            borderRadius = 5.px

            " .card-image" {
                borderRadius = box(5.px, 5.px, 0, 0)
            }

            " .card-action".lastChild {
                borderRadius = box(0, 0, 5.px, 5.px)
            }
        }

        ".kyubey-red" {
            backgroundColor = "#FD6767 !important"
        }

        ".kyubey-red-text" {
            color = "#FD6767 !important"
        }

        a.c("link") {
            color = "#FD6767 !important"
        }

        ".kyubey-greyish" and ".hljs" and ".embed" {
            backgroundColor = "#EBEBEB !important"
        }

        ".kyubey-greyish-text" {
            color = "#EBEBEB !important"
        }

        ".kyubey-pink" {
            backgroundColor = "#DB79FB !important"
        }

        ".kyubey-pink-text" {
            color = "#DB79FB !important"
        }

        a.c("link").hover {
            cursor = POINTER
            textDecoration = UNDERLINE
        }

        at("font-face") {
            fontFamily = "'Anydore'"
            src = "url(\"/fonts/Anydore.otf\") format(\"opentype\")"
            fontWeight = NORMAL
            fontStyle = NORMAL
        }

        ".emoji" {
            height = 25.px
        }

        pre {
            "*" {
                fontFamily = "'Roboto Mono', monospace"
            }
        }

        ".embed-wrapper" {
            maxWidth = 520.px
            position = RELATIVE
            display = "flex"
        }

        ".embed" {
            display = "flex"
            position = RELATIVE
            border = "1px, solid, rgba(216, 216, 216, 0.6)"
            padding = box(8.px, 5.px)
            boxSizing = BORDER_BOX

            " * .left" {
                marginLeft = 0
            }

            " .embed-content" {
                width = 100.percent
                display = "flex"
                position = RELATIVE

                " .inner-content" {
                    flex = 1
                }
            }

            " .embed-color" {
                width = 5.0.px
                flexShrink = 0
                borderRadius = box(51.px, 0, 0, 5.px)
            }

            " .embed-fields" {
                display = "flex"
                flexDirection = "row"
                flexWrap = "wrap"
                color = 0x36393E
                marginTop = (-10).px
                marginBottom = 11.px

                " .embed-field" {
                    flex = 0
                    paddingTop = 10.px
                    minWidth = 100.percent
                    maxWidth = 506.px
                }

                " .embed-field .field-inline" {
                    flex = 1
                    minWidth = 150.px
                    flexBasis = AUTO
                }
            }

            " .embed-author" {
                display = "flex"
                alignItems = CENTER
                marginBottom = 5.px

                ".embed-author-icon" {
                    marginRight = 9.px
                    width = 20.px
                    height = 20.px
                    objectFit = "contain"
                    borderRadius = 50.percent
                }

                ".embed-author-name" {
                    color = 0xFD6767
                }
            }

            " .embed-footer"..".embed-footer-text" and ".embed-title" {
                color = 0xFD6767
            }

            " .embed-description" {
                display = BLOCK
                fontSize = 14.px
                fontWeight = 500
                marginBottom = 10.px
                letterSpacing = 0
            }

            " .markup" {
                marginTop = 0
                fontSize = 14.px
                lineHeight = 16.px

                " .emoji" {
                    height = 14.px
                }
            }

            " .embed-footer" {
                " .embed-footer" {
                    display = INLINE_BLOCK
                    fontWeight = 600
                    fontSize = 12.px
                    color = "hsla(0,0%,100%,.6)"
                    letterSpacing = 0
                }

                " .embed-footer-icon" {
                    marginRight = 10.px
                    height = 18.px
                    width = 18.px
                    objectFit = "contain"
                    float = LEFT
                    borderRadius = 2.45.px
                }

                " .embed-footer-text" {
                    fontSize = 11.px

                    " .emoji" {
                        height = 11.px
                    }
                }
            }

            " .embed-content" {
                " .embed-thumbnail" {
                    maxHeight = 80.px
                    maxWidth = 80.px
                    borderRadius = 3.px
                    width = AUTO
                    objectFit = "contain"
                    flexShrink = 0
                    marginLeft = 20.px
                }
            }

            " .embed-image" {
                maxWidth = 250.px
                position = RELATIVE
                margin = 0
                verticalAlign = BOTTOM
            }

            " .embed-author-name" and " .embed-title" {
                " .emoji" {
                    height = 15.px
                }
            }
        }

        "#we-dont-like-ads-too" {
            position = FIXED
            fontSize = 15.px
            bottom = 5.px
            right = 2.px
            padding = 5.px
            maxWidth = 400.px
            zIndex = 1000

            a.c("close").hover {
                cursor = POINTER
            }
        }

        ".dropdown-content".li / span / label {
            top = (-11).px
        }

        ".features" {
            height = "15rem !important"
        }

        ".documentation".img {
            maxWidth = 100.percent
        }

        ".btn-floating".i {
            fontSize = "1.25rem"
        }

        ".admin-cards" {
            " .card" {
                height = 250.px
            }
        }

        "#terminal-overlay" {
            backgroundColor = BLACK
            position = ABSOLUTE
            left = 0
            right = 0
            bottom = 0
            height = 248.px // 144

            " #toolbar" {
                height = 48.px
                backgroundColor = 0xEBEBEB
                boxShadow = "0 0 2px gray"

                " .toolbar-item" {
                    lineHeight = 50.px
                    height = 100.percent
                }
            }

            " .terminal-container" {
                height = 200.px// 98

                " #terminal" {
                    height = 100.percent
                }
            }
        }
    }
}