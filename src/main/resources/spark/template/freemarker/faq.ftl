<#import "layout.ftl" as layout>

<@layout.main "Kyubey - FAQ" "Frequently Asked Questions" "FAQ">
    <div class="row">
        <ul class="collapsible popout" data-collapsible="accordion">
            <li>
                <div class="collapsible-header">What prefixes are available for this bot?</div>
                <div class="collapsible-body white">
                    <span>Kyubey has multiple prefixes, <code>k;</code>, <code>k#</code>, <code>kyubey </code> and <code>kyubey pls </code></span>
                </div>
            </li>
            <li>
                <div class="collapsible-header">How do I execute commands?</div>
                <div class="collapsible-body white">
                    <h6>You can execute a command like this:</h6>
                    <blockquote><code>kyubey pls hug @noud02#0080</code></blockquote>
                </div>
            </li>
            <li>
                <div class="collapsible-header">What do all those things on the help command mean?</div>
                <div class="collapsible-body white">
                    <blockquote><code>buy &lt;item: string&gt; [amount: number]</code></blockquote>
                    <h6>
                        Here, buy is the command, and the rest are the arguments.
                        <br />
                        If an argument has brackets ([]) it is not required, else the argument is required
                        <br />
                        The things after the colons are the argument types, you probably don't have to look at those as the argument names explain those anyway.
                    </h6>
                </div>
            </li>
            <li>
                <div class="collapsible-header">I found a bug/error/exploit!</div>
                <div class="collapsible-body white">
                    <h6>If you find a bug/error/exploit/whatever you can report it in my support guild for a reward.</h6>
                </div>
            </li>
        </ul>
    </div>
</@layout.main>