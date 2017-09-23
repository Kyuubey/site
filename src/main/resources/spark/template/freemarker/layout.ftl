<#macro main title="Kyubey" desc="Do you want to become a magical girl?" page="">
    <!DOCTYPE html>
    <html lang="en">
        <head>
            <meta charset="utf-8">
            <meta og:title="${title}">
            <meta og:description="${desc}">
            <meta name="viewport" content="width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes">
            <title>${title}</title>
            <link type="text/css" rel="stylesheet" href="//fonts.googleapis.com/css?family=Noto+Sans">
            <link type="text/css" rel="stylesheet" href="//fonts.googleapis.com/icon?family=Material+Icons">
            <link type="text/css" rel="stylesheet" href="/bower_components/materialize/dist/css/materialize.min.css" media="screen,projection"/>
            <link type="text/css" rel="stylesheet" href="/css/nerd-fonts-generated.css">
            <link type="text/css" rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/highlight.js/9.12.0/styles/atom-one-light.min.css">
            <script type="text/javascript" src="//code.jquery.com/jquery-3.2.1.min.js"></script>
            <script type="text/javascript" src="/bower_components/materialize/dist/js/materialize.min.js"></script>
            <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/highlight.js/9.12.0/highlight.min.js"></script>
            <script type="text/javascript" src="//twemoji.maxcdn.com/2/twemoji.min.js?2.3.0"></script>
            <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment-with-locales.min.js"></script>
            <style>*{font-family:'Noto Sans', 'Roboto', sans-serif}html,body{margin:0;width:100%;height:100%;background-color:#ebebeb!important;}.card{width:99%;border-radius:5px;}.card .card-image{border-radius:5px 5px 0 0;}.card .card-action:last-child{border-radius:0 0 5px 5px;}.kyubey-red{background-color:#fd6767!important;}.kyubey-red-text{color:#fd6767!important;}a.link{color:#fd6767!important;}.kyubey-greyish{background-color:#ebebeb!important;}.kyubey-greyish-text{color:#ebebeb!important;}.kyubey-pink{background-color:#db79fb!important;}.kyubey-pink-text{color:#db79fb!important;}a.link:hover{cursor:pointer;text-decoration:underline;}@font-face{font-family:'Anydore';src:url("/fonts/Anydore.otf")format("opentype");font-weight:normal;font-style:normal;}.emoji{height:25px;}.hljs{background:#ebebeb;}</style>
        </head>
        <body>
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
                            <div class="col s2">
                                <ul>
                                    <li>
                                        <a class="btn-floating kyubey-red" href="/support"><i class="material-icons">edit</i></a>
                                        <span class="hide-on-med-and-down"> FAQ</span>
                                    </li>
                                    <li>
                                        <br />
                                    </li>
                                    <li>
                                        <a class="btn-floating kyubey-red" href="https://patreon.com/noud"><i class="material-icons">attach_money</i></a>
                                        <span class="hide-on-med-and-down"> Donate</span>
                                    </li>
                                </ul>
                            </div>
                            <div class="col s2">
                                <ul>
                                    <li>
                                        <a class="btn-floating kyubey-red" href="/about"><i class="material-icons">info</i></a>
                                        <span class="hide-on-med-and-down"> About</span>
                                    </li>
                                    <li>
                                        <br />
                                    </li>
                                    <li>
                                        <a class="btn-floating kyubey-red" href="/invite"><i class="material-icons">exit_to_app</i></a>
                                        <span class="hide-on-med-and-down"> Invite!</span>
                                    </li>
                                </ul>
                            </div>
                            <div class="col s4 offset-s4 m3 offset-m5">
                                <ul>
                                    <li>
                                        <a class="black-text" href="https://github.com/Kyuubey/Kyubey"><i class="nf nf-fa-github_square"></i> GitHub</a>
                                    </li>
                                    <li>
                                        <a class="black-text" href="https://discord.gg/qngdWCZ"><img src="https://discordapp.com/assets/41484d92c876f76b20c7f746221e8151.svg" height="16" style="margin-left:-3px;margin-bottom:-3px;"><span style="margin-left:2px;">Discord</span></a>
                                    </li>
                                    <li>
                                        <a class="black-text" href="https://noud02.me"><i class="nf nf-fa-server"></i> noud02.me</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col s3 offset-s1">
                                <sub>Quick Links</sub>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col s3">
                                <h5 class="kyubey-red-text" style="font-family:'Anydore';">yube</h5>
                            </div>
                            <div style="margin-top:15px;" class="col s4 offset-s5 m3 offset-m6">
                                <span>Design by <a class="kyubey-red-text link" href="https://github.com/sr229">Enra</a></span>
                            </div>
                        </div>
                    </div>
                </div>
            </footer>
            <script type="text/javascript">$(document).ready(function(){setInterval(function(){$(".carousel.carousel-slider").carousel("next");}, 10000);$(".carousel.carousel-slider").carousel({fullWidth:true});$(".dropdown-button").dropdown();hljs.configure({classPrefix:"hljs-",tabReplace:"    "});$("pre code").each(function(i,b){hljs.highlightBlock(b);});twemoji.parse(document.body);$(".momentify").each(function(i,e){e.innerHTML=moment(Number(e.innerHTML.replace(/,/g, ""))).format("L @ LT");});});</script>
        </body>
    </html>
</#macro>
