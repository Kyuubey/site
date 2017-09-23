<#import "./elements/header.ftl" as header>
<#import "./elements/footer.ftl" as footer>

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
        <link type="text/css" rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/highlight.js/9.12.0/styles/atom-one-light.min.css">
        <link type="text/css" rel="stylesheet" href="/bower_components/materialize/dist/css/materialize.min.css" media="screen,projection"/>
        <link type="text/css" rel="stylesheet" href="/css/nerd-fonts-generated.css">
        <link type="text/css" rel="stylesheet" href="/css/style.min.css">
        <script type="text/javascript" src="//code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="/bower_components/materialize/dist/js/materialize.min.js"></script>
        <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/highlight.js/9.12.0/highlight.min.js"></script>
        <script type="text/javascript" src="//twemoji.maxcdn.com/2/twemoji.min.js?2.3.0"></script>
        <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment-with-locales.min.js"></script>
        <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/markdown-it/8.4.0/markdown-it.min.js"></script>
        <script type="text/javascript" src="/js/script.min.js"></script>
    </head>
    <body>
        <@header.index page />
        <main>
            <div class="section kyubey-red">
                <div class="container">
                    <#nested />
                </div>
            </div>
        </main>
        <@footer.main />
    </body>
</html>
</#macro>

<#macro other title="Kyubey" desc="Do you want to become a magical girl?" page="">
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta og:title="${title}">
        <meta og:description="${desc}">
        <meta name="viewport" content="width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes">
        <title>${title}</title>
        <link type="text/css" rel="stylesheet" href="//fonts.googleapis.com/css?family=Noto+Sans">
        <link type="text/css" rel="stylesheet" href="//fonts.googleapis.com/icon?family=Material+Icons">
        <link type="text/css" rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/highlight.js/9.12.0/styles/atom-one-light.min.css">
        <link type="text/css" rel="stylesheet" href="/bower_components/materialize/dist/css/materialize.min.css" media="screen,projection"/>
        <link type="text/css" rel="stylesheet" href="/css/nerd-fonts-generated.css">
        <link type="text/css" rel="stylesheet" href="/css/style.min.css">
        <script type="text/javascript" src="//code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="/bower_components/materialize/dist/js/materialize.min.js"></script>
        <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/highlight.js/9.12.0/highlight.min.js"></script>
        <script type="text/javascript" src="//twemoji.maxcdn.com/2/twemoji.min.js?2.3.0"></script>
        <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment-with-locales.min.js"></script>
        <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/markdown-it/8.4.0/markdown-it.min.js"></script>
        <script type="text/javascript" src="/js/script.min.js"></script>
        <style>*{font-family:'Noto Sans', 'Roboto', sans-serif}html,body{margin:0;width:100%;height:100%;background-color:#ebebeb!important;}.card{width:99%;border-radius:5px;}.card .card-image{border-radius:5px 5px 0 0;}.card .card-action:last-child{border-radius:0 0 5px 5px;}.kyubey-red{background-color:#fd6767!important;}.kyubey-red-text{color:#fd6767!important;}a.link{color:#fd6767!important;}.kyubey-greyish{background-color:#ebebeb!important;}.kyubey-greyish-text{color:#ebebeb!important;}.kyubey-pink{background-color:#db79fb!important;}.kyubey-pink-text{color:#db79fb!important;}a.link:hover{cursor:pointer;text-decoration:underline;}@font-face{font-family:'Anydore';src:url("/fonts/Anydore.otf")format("opentype");font-weight:normal;font-style:normal;}.emoji{height:25px;}.hljs{background:#ebebeb;}</style>
    </head>
    <body>
        <@header.main />
        <main>
            <div class="section kyubey-greyish">
                <div class="container">
                    <#nested />
                </div>
            </div>
        </main>
        <@footer.main />
    </body>
</html>
</#macro>