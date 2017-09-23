<#import "layout.ftl" as layout>

<#macro logitem data color="">
    <div class="card ${(color != "") ? then (color, "kyubey-greyish")}">
        <div class="card-content">
            <div class="row">
                <div class="col s1">
                    <img class="circle" src="${data.author.avatarURL}" alt="avatar" height="75">
                </div>
                <div class="col s10">
                    <h5 class="truncate">${data.author.username}</h5>
                    <span>${data.contentHTML}</span>
                </div>
                <div class="col s1">
                    <h6>${data.event}</h6>
                    <span class="momentify">${data.timestamp}</span>
                </div>
            </div>
        </div>
    </div>
</#macro>

<@layout.main "Kyubey - Logs" ":eyes:" "Logs">
    <div class="row">
        <div class="col s12">
            <ul>
                <#list logs as log>
                    <li>
                        <#switch log.event>
                            <#case "DELETE">
                                <@logitem log "kyubey-red" />
                                <#break>
                            <#case "UPDATE">
                                <@logitem log "kyubey-pink" />
                                <#break>
                            <#default>
                                <@logitem log />
                        </#switch>
                    </li>
                </#list>
            </ul>
        </div>
    </div>
</@layout.main>