<#import "layout.ftl" as layout>

<#macro logitem data color="white">
    <div class="card ${color}">
        <div class="card-content">
            <div class="row">
                <div class="hide-on-med-and-down col l1">
                    <img class="circle" src="${data.author.avatarURL}" alt="avatar" height="75">
                </div>
                <div class="col s11 l9">
                    <h6 class="truncate" style="font-size:20px;font-weight:lighter;">${data.author.username}#${data.author.discriminator}</h6>
                    <p class="markup" style="word-wrap:break-word;">${data.content}</p>
                    <#list data.embeds as embed>
                        <#if embed.type == "rich">
                            <!-- TODO: embeds, probb gonna use discords css here again -->
                            <div>insert embed here</div>
                        </#if>
                    </#list>
                    <#list data.attachments as attachment>
                        <img height="128" src="${attachment.url}" alt="attachment.jpeg.png.gif.bmp.tar.gz.xz">
                    </#list>
                </div>
                <div class="col s1 l2">
                    <#switch data.event>
                        <#case "CREATE">
                            <p class="left hide-on-med-and-down"><i class="material-icons left">message</i> Created</p>
                            <i class="material-icons left hide-on-large-only tooltipped" data-position="left" data-tooltip="Created">message</i>
                            <#break>
                        <#case "DELETE">
                            <p class="left hide-on-med-and-down"><i class="material-icons left">delete</i> Deleted</p>
                            <i class="material-icons left hide-on-large-only tooltipped" data-position="left" data-tooltip="Deleted">delete</i>
                            <#break>
                        <#case "UPDATE">
                            <p class="left hide-on-med-and-down"><i class="material-icons left">edit</i> Edited</p>
                            <i class="material-icons left hide-on-large-only tooltipped" data-position="left" data-tooltip="Edited">edit</i>
                            <#break>
                        <#default>
                            <p class="left hide-on-med-and-down"><i class="material-icons left">error</i> Unknown</p>
                            <i class="material-icons left hide-on-large-only tooltipped" data-position="left" data-tooltip="Unknown">error</i>
                    </#switch>
                    <p class="left hide-on-med-and-down"><i class="material-icons left">date_range</i> ${data.timestamp?split(",")?join("")?number?number_to_datetime?string}</p>
                    <i class="material-icons left hide-on-large-only tooltipped" data-position="left" data-tooltip="${data.timestamp?split(",")?join("")?number?number_to_datetime?string}">date_range</i>
                    <p class="left hide-on-med-and-down" style="font-size:11px;line-height:2.1;"><i class="material-icons left">fingerprint</i> ${data.id?split(" ")[0]}</p>
                    <i class="material-icons left hide-on-large-only tooltipped" data-position="left" data-tooltip="${data.id?split(" ")[0]}">fingerprint</i>
                </div>
            </div>
        </div>
    </div>
</#macro>

<@layout.other "Kyubey - Logs" ":eyes:" "Logs">
    <div class="row">
        <div class="col s12 l4">
            <h5 style="font-weight:bold;">Logs for ${logs[0].guild.name}</h5>
            <p>Channel: #${logs[0].channel.name}</p>
            <p>Last message: <span class="momentify">${logs[0].timestamp}</span></p>
        </div>
    </div>
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
</@layout.other>