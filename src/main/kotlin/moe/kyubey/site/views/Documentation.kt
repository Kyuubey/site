package moe.kyubey.site.views

import kotlinx.html.unsafe
import moe.kyubey.site.entities.View
import org.commonmark.parser.Parser
import org.commonmark.renderer.html.HtmlRenderer

object Documentation : View {
    private val mdParser = Parser.builder().build()
    private val htmlRenderer = HtmlRenderer.builder().build()

    override fun render(): String {
        return Layout.secondary("Kyubey - Docs", "Documentation for Kyubey", "Documentation") {
            unsafe {
                val md = mdParser.parse(javaClass.classLoader.getResource("Kyubey_Documentation.md").readText())

                raw(htmlRenderer.render(md))
            }
        }
    }
}