<#import "./elements/header.ftl" as header>
<#import "./elements/footer.ftl" as footer>
<#import "./elements/donate.ftl" as donate>

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
        <link type="text/css" rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css" media="screen,projection"/>
        <link type="text/css" rel="stylesheet" href="/css/nerd-fonts-generated.css">
        <link type="text/css" rel="stylesheet" href="/css/style.min.css">
        <script type="text/javascript" src="//code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
        <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/highlight.js/9.12.0/highlight.min.js"></script>
        <script type="text/javascript" src="//twemoji.maxcdn.com/2/twemoji.min.js?2.3.0"></script>
        <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment-with-locales.min.js"></script>
        <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/markdown-it/8.4.0/markdown-it.min.js"></script>
        <script type="text/javascript" src="/js/script.min.js"></script>
    </head>
    <body>
        <@donate.pushpin />
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
        <link type="text/css" rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css" media="screen,projection"/>
        <link type="text/css" rel="stylesheet" href="/css/nerd-fonts-generated.css">
        <link type="text/css" rel="stylesheet" href="/css/style.min.css">
        <script type="text/javascript" src="//code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
        <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/highlight.js/9.12.0/highlight.min.js"></script>
        <script type="text/javascript" src="//twemoji.maxcdn.com/2/twemoji.min.js?2.3.0"></script>
        <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment-with-locales.min.js"></script>
        <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/markdown-it/8.4.0/markdown-it.min.js"></script>
        <script type="text/javascript" src="/js/script.min.js"></script>
    </head>
    <body>
        <@donate.pushpin />
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