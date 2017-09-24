function emoteParser (string, customClass) {
    let el;

    if (string instanceof HTMLElement) {
        el = string;
        string = string.innerHTML;
    }

    const regex = /&lt;\:([^:]+)\:(\d+)&gt;/i;

    while (regex.test(string)) {
        const matches = string.match(regex);
        const src = `https://cdn.discordapp.com/emojis/${matches[2]}.png`;
        string = string.replace(regex, `<img class="${customClass || "emoji"}" src="${src}" alt="${matches[1]}">`);
    }

    if (el) el.innerHTML = string;
    else return string;
}

$(document).ready(function(){
    hljs.configure({
        classPrefix:"hljs-",
        tabReplace:"    "
    });
    var md = markdownit({
        html: false,
        xhtmlOut: false,
        breaks: true,
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
    $(".embed-color").each(function (i, el) {
        el.style['background-color'] = `#${Number(el.getAttribute("color")).toString(16)}`;
    });
    $("#we-dont-like-ads-too").pushpin({
        top: window.height - 10
    }).find(".close").on("click", function () {
        $("#we-dont-like-ads-too").remove();
    });
    setTimeout(function() {
        $("#we-dont-like-ads-too").remove();
    }, 75000);
    twemoji.parse(document.body);
    emoteParser(document.body);
});
