<#macro main title="Kyubey" desc="Do you want to become a magical girl?" page="">
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="utf-8">
        <meta og:title="${title}">
        <meta og:description="Do you want to become a magical girl?">
        <!-- Disable viewport until I fix the site for mobile devices -->
        <!--<meta name="viewport" content="width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes">-->
        <title>${title}</title>
        <link type="text/css" rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link type="text/css" rel="stylesheet" href="/bower_components/materialize/dist/css/materialize.min.css" media="screen,projection"/>
        <link type="text/css" rel="stylesheet" href="/css/nerd-fonts-generated.css">
        <style>html,body{margin:0;width:100%;height:100%;background-color:#ebebeb!important;}.card{width:99%;}.kyubey-red{background-color:#fd6767!important;}.kyubey-red-text{color:#fd6767!important;}a.link{color:#fd6767!important;}a.link:hover{cursor:pointer;text-decoration:underline;}@font-face{font-family:'Anydore';src:url("/fonts/Anydore.otf")format("opentype");font-weight:normal;font-style:normal;}</style>
    </head>
    <body>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="/bower_components/materialize/dist/js/materialize.min.js"></script>
    <header>
        <div class="section">
            <div class="container">
                <div class="row center">
                    <div class="col s3 m1 offset-m1">
                        <h4 style="font-family:'Anydore';" class="header center-on-small-only">Kyubey</h4>
                    </div>
                    <div class="col s6 offset-s3 m6 offset-m3">
                        <br />
                        <a class="waves-effect waves-teal btn-flat" href="/features">Features</a>
                        <a class="waves-effect waves-teal btn-flat" href="/support">Support</a>
                        <a class="waves-effect waves-teal btn-flat" href="/faq">Faq</a>
                    </div>
                </div>
                <div class="row center">
                    <div class="col s3 m1 offset-m1">
                        <img src="/img/kyubey.png" alt="kyubey.png">
                    </div>
                    <div class="col s3 offset-s3 m6 offset-m3">
                        <h1 style="font-family:'Anydore';" class="kyubey-red-text">Kyubey</h1>
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
    <main>
        <div class="section kyubey-red">
            <div class="container">
                <#nested />
            </div>
        </div>
    </main>
    <footer>
        <div class="section">
            <div class="container">
                <div class="row">
                    <div class="col s3 m2">
                        <ul>
                            <li>
                                <h6><a class="btn-floating kyubey-red" href="/support"><i class="material-icons">edit</i></a> FAQ</h6>
                            </li>
                            <li>
                                <h6><a class="btn-floating kyubey-red" href="https://patreon.com/noud"><i class="material-icons">attach_money</i></a> Donate</h6>
                            </li>
                        </ul>
                    </div>
                    <div class="col s3 m2">
                        <ul>
                            <li>
                                <h6><a class="btn-floating kyubey-red" href="/about"><i class="material-icons">info</i></a> About</h6>
                            </li>
                            <li>
                                <h6><a class="btn-floating kyubey-red" href="/invite"><i class="material-icons">exit_to_app</i></a> Invite!</h6>
                            </li>
                        </ul>
                    </div>
                    <div class="col s6 m4 offset-m4">
                        <ul>
                            <li>
                                <a class="black-text" href="https://github.com/Kyuubey/Kyubey"><i class="nf nf-fa-github_square"></i> GitHub</a>
                            </li>
                            <li>
                                <a class="black-text" href="https://discord.gg/qngdWCZ"><i class="nf nf-fa-phone"></i> Support Server</a>
                            </li>
                            <li>
                                <a class="black-text" href="https://noud02.me"><i class="nf nf-fa-server"></i> noud02's Website</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="row">
                    <div class="col s1 offset-s1">
                        <sub>Quick Links</sub>
                    </div>
                </div>
                <div class="row">
                    <div class="col s3">
                        <h5 style="font-family:'Anydore';">Kyubey</h5>
                    </div>
                    <div class="col s3 offset-s6">
                        <span>Design by <a class="kyubey-red-text link" href="https://github.com/sr229">Enra</a></span>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <script type="text/javascript">$(document).ready(function(){setInterval(function(){$(".carousel.carousel-slider").carousel("next");}, 10000);$(".carousel.carousel-slider").carousel({fullWidth:true});});</script>
    </body>
    </html>
</#macro>