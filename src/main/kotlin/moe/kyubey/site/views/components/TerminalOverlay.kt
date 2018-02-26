package moe.kyubey.site.views.components

import kotlinx.html.*

fun BODY.terminalOverlay() {
    div {
        id = "terminal-overlay"
        div {
            id = "toolbar"
            a("#") {
                id = "collapse-terminal"
                classes = setOf("toolbar-item", "left", "btn-flat", "kyubey-red-text")
                i { classes = setOf("fas", "fa-chevron-down") }
            }
            a("#") {
                classes = setOf("toolbar-item", "right", "btn-flat", "kyubey-red-text")
                i { classes = setOf("fas", "fa-ellipsis-v") }
            }
            a("#") {
                classes = setOf("toolbar-item", "right", "btn-flat", "kyubey-red-text")
                i { classes = setOf("fas", "fa-code") }
            }
        }
        div {
            classes = setOf("terminal-container")
            div { id = "terminal" }
        }
    }
}