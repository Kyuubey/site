package moe.kyubey.site.entities

import kotlinx.html.*

class MAIN(consumer: TagConsumer<*>) : HTMLTag(
        "main",
        consumer,
        emptyMap(),
        inlineTag = true,
        emptyTag = false
), HtmlInlineTag

fun BODY.main(block: MAIN.() -> Unit = {}) {
    MAIN(consumer).visit(block)
}