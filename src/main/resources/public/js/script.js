$(document).ready(function(){
    hljs.configure({
        classPrefix:"hljs-",
        tabReplace:"    "
    });
    var md = markdownit({
        html: false,
        xhtmlOut: false,
        breaks: false,
        linkify: true,
        typographer: false,
        highlight: function (str, lang) {
            if (lang && hljs.getLanguage(lang)) {
                try {
                    return hljs.highlight(lang, str).value.replace(/```/g, "");
                } catch (e) {}
            }

            return '';
        }
    })
    setInterval(function(){
        $(".carousel.carousel-slider").carousel("next");
    }, 10000);
    $(".carousel.carousel-slider").carousel({fullWidth:true});
    $(".dropdown-button").dropdown();
    $("pre code").each(function(i,b){
        hljs.highlightBlock(b);
    });
    $(".momentify").each(function(i,e){
        e.innerHTML = moment(Number(e.innerHTML.replace(/,/g, ""))).format("LT l");
    });
    $(".momentify-tooltip").each(function(i,e){
        document.getElementById(e.getAttribute('data-tooltip-id')).innerHTML = "<span>" + moment(Number(e.getAttribute('data-tooltip').replace(/,/g, ""))).format("LT l") + "</span><div class=\"backdrop\"></div>";
    });
    $(".markup").each(function(i,e){
        e.innerHTML = md.render(e.innerHTML);
    });
    twemoji.parse(document.body);
});
