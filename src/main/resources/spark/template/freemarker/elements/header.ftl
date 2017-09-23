<#macro index page="">
<header>
    <div class="section">
        <div class="container">
            <div class="row center">
                <div class="col s3 l1 offset-l1">
                    <h4 style="font-family:'Anydore';" class="header kyubey-red-text center-on-small-only">yube</h4>
                </div>
                <div class="col s1 offset-s6 l6 offset-l3">
                    <br />
                    <a class="hide-on-med-and-down waves-effect waves-teal btn-flat" href="/features">Features</a>
                    <a class="hide-on-med-and-down waves-effect waves-teal btn-flat" href="/support">Support</a>
                    <a class="hide-on-med-and-down waves-effect waves-teal btn-flat" href="/faq">FAQ</a>
                    <a class="hide-on-med-and-down waves-effect waves-teal btn kyubey-red" href="/invite">Invite!</a>
                    <ul id="nav-dropdown" class="dropdown-content">
                        <li>
                            <a href="/features">Features</a>
                        </li>
                        <li>
                            <a href="/support">Support</a>
                        </li>
                        <li>
                            <a href="/faq">FAQ</a>
                        </li>
                    </ul>
                    <a class="hide-on-large-only dropdown-button btn-flat" href="#" data-activates="nav-dropdown"><i class="material-icons">more_vert</i></a>
                </div>
            </div>
            <div class="row center">
                <div class="col s12 m1">
                    <img src="/img/kyubey.png" alt="kyubey.png" style="width:250px;">
                </div>
                <div class="col s12 m6 offset-m4">
                    <h1 style="font-family:'Anydore';" class="kyubey-red-text">yube</h1>
                    <#if page == "">
                        <h5>He'll make your Discord magical!</h5>
                        <a class="waves-effect waves-light btn kyubey-red" href="/invite"><i class="material-icons left">exit_to_app</i>Invite!</a>
                    <#else>
                        <h5>${page}</h5>
                    </#if>
                </div>
            </div>
        </div>
    </div>
</header>
</#macro>

<#macro main page="">
<header>
    <nav class="kyubey-red">
        <div class="nav-wrapper">
            <a href="/" class="brand-logo" style="font-family:'Anydore';margin-left:10px;">yube</a>
            <ul id="nav-mobile" class="right hide-on-med-and-down">
                <li>
                    <a href="#"><i class="material-icons">more_vert</i></a>
                </li>
            </ul>
        </div>
    </nav>
</header>
</#macro>