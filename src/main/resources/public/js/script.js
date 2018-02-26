function emoteParser (string, customClass) {
    let el;

    if (string instanceof HTMLElement) {
        el = string;
        string = string.innerHTML;
    }

    const regex = /&lt;:([^:]+):(\d+)&gt;/i;

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
    const md = markdownit({
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
    });
    $(".carousel.carousel-slider").carousel({fullWidth:true});
    $(".dropdown-button").dropdown();
    $(".modal").modal();
    $("select").material_select();
    setInterval(function(){
        $(".carousel.carousel-slider").carousel("next");
    }, 10000);
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
    $(".has-emotes").each(function(i,e){
        emoteParser(e);
    });
    $(".embed-color").each(function (i, el) {
        el.style['background-color'] = `#${Number(el.getAttribute("color")).toString(16)}`;
    });
    $("#we-dont-like-ads-too .close").on("click", function () {
        $("#we-dont-like-ads-too").remove();
    });
    $('.timepicker').pickatime({
        default: 'now',
        fromnow: 0,
        twelvehour: false,
        donetext: 'OK',
        cleartext: 'Clear',
        canceltext: 'Cancel',
        autoclose: false,
        ampmclickable: true
    });

    $("#apply-log-filters").on("click", function(e) {
        const events = $("#events-filter").val();
        const users = $("#user-filter").val().split(/,\s?/i);
        const keywords = $("#keyword-filter").val().split(/,\s?/i);
        let qs = "";

        for (const event of events) if (event !== "") qs += `${qs.length > 1 && "&" || "?"}event=${escape(event)}`;
        for (const user of users) if (user !== "") qs += `${qs.length > 1 && "&" || "?"}user=${escape(user)}`;
        for (const keyword of keywords) if (keyword !== "") qs += `${qs.length > 1 && "&" || "?"}keyword=${escape(keyword)}`;

        window.location.search = qs;
    });

    setTimeout(function() {
        $("#we-dont-like-ads-too").remove();
    }, 75000);
    $("#we-dont-like-ads-too").pushpin({
        top: window.height - 10
    });
    twemoji.parse(document.body);
});