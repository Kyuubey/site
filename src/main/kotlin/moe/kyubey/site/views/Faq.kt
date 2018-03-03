package moe.kyubey.site.views

import moe.kyubey.site.entities.View
import kotlinx.html.*

object Faq : View {
    override fun render(): String {
        return Layout.main {
            div {
                classes = setOf("row")
                ul {
                    classes = setOf("collapsible", "popout")
                    attributes["data-collapsible"] = "accordion"
                    li {
                        div {
                            classes = setOf("collapsible-header")
                            +"What prefixes are available for this bot?"
                        }
                        div {
                            classes = setOf("collapsible-body", "white")
                            span {
                                +"Kyubey has multiple prefixes "
                                code { +"k;" }
                                +", "
                                code { +"k#" }
                                +", "
                                code { +"kyubey " }
                                +" and "
                                code { +"kyubey pls " }
                            }
                        }
                    }
                    li {
                        div {
                            classes = setOf("collapsible-header")
                            +"How do I execute commands?"
                        }
                        div {
                            classes = setOf("collapsible-body", "white")
                            h6 { +"You can execute a command like this:" }
                            blockQuote { code { +"kyubey pls hug @noud02#0080" } }
                        }
                    }
                    li {
                        div {
                            classes = setOf("collapsible-header")
                            +"What do all those things on the help command mean?"
                        }
                        div {
                            classes = setOf("collapsible-body", "white")
                            blockQuote { code { +"buy &lt;item: string&gt; [amount: number]" } }
                            h6 {
                                +"Here, buy is the command, and the rest are the arguments."
                                br
                                +"If an argument has brackets [] it is not required, else the argument is required"
                                br
                                +"The things after the colons are the argument types, you probably don't have to look at those as the argument names explain those anyway."
                                // br
                                // +"More info can be found in the documentation!"
                            }
                        }
                    }
                    li {
                        div {
                            classes = setOf("collapsible-header")
                            +"I found a bug/error/exploit!"
                        }
                        div {
                            classes = setOf("collapsible-body", "white")
                            h6 { +"If you find a bug/error/exploit/whatever you can report it in my support guild for a reward." }
                        }
                    }
                }
            }
        }
    }
}