<#import "layout.ftl" as layout>

<#macro logitem data color="white">
    <div class="card hoverable ${color}" id="${data.messageId}">
        <div class="card-content">
            <div class="row">
                <div class="hide-on-med-and-down col l1">
                    <img class="circle" src="${data.authorAvatar}" alt="avatar" height="75">
                </div>
                <div class="col s11 l9">
                    <h6 class="truncate" style="font-size:20px;font-weight:lighter;">${data.authorName}#${data.authorDiscrim}</h6>
                    <p class="markup has-emotes" style="word-wrap:break-word;">${data.content}</p>
                    <#list data.embeds as embed>
                        <#if embed.type == "RICH">
                            <div class="embed-wrapper">
                                <div class="embed embed-color z-depth-2" color="${embed.color???then(embed.color.value?split("-")[1], "4095")}"></div>
                                <div class="embed embed-content z-depth-2">
                                    <div class="inner-content">
                                        <#if embed.author??>
                                            <div class="embed-author">
                                                <#if embed.author.icon_url??>
                                                    <img class="embed-author-icon" src="${embed.author.icon_url}" alt="icon">
                                                </#if>
                                                <#if embed.author.name??>
                                                    <a class="embed-author-name link" href="${embed.author.url???then(embed.author.url, "#")}">${embed.author.name}</a>
                                                </#if>
                                            </div>
                                        </#if>
                                        <#if embed.title??>
                                            <a class="embed-title has-emotes link" href="${embed.url???then(embed.url, "#")}">${embed.title}</a>
                                        </#if>
                                        <#if embed.description??>
                                            <div class="embed-description has-emotes markup">${embed.description}</div>
                                        </#if>
                                        <#if embed.fields??>
                                            <#list embed.fields as field>
                                                <div class="embed-field${field.inline???then(" field-inline", "")}">
                                                    <div class="embed-field-title has-emotes">${field.name}</div>
                                                    <#if field.value??>
                                                        <div class="embed-field-markup has-emotes markup">${field.value}</div>
                                                    </#if>
                                                </div>
                                            </#list>
                                        </#if>
                                        <#if embed.image??>
                                            <br />
                                            <br />
                                            <img class="embed-image" src="${embed.image.url}" alt="image">
                                        </#if>
                                        <#if embed.footer??>
                                            <br />
                                            <br />
                                            <div class="embed-footer left">
                                                <#if embed.footer.icon_url??>
                                                    <img class="embed-footer-icon" src="${embed.footer.icon_url}" alt="icon">
                                                </#if>
                                                <a class="embed-footer-text has-emotes link" href="${embed.footer.url???then(embed.footer.url, "#")}">${embed.footer.text}</a>
                                            </div>
                                        </#if>
                                    </div>
                                    <#if embed.thumbnail??>
                                        <img class="embed-thumbnail" src="${embed.thumbnail.url}" alt="thumb">
                                    </#if>
                                </div>
                            </div>
                        </#if>
                    </#list>
                    <#list data.attachments as attachment>
                        <img height="128" src="${attachment}" alt="attachment.jpeg.png.gif.bmp.tar.gz.xz">
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
                    <p class="left hide-on-med-and-down" style="font-size:11px;line-height:2.1;"><i class="material-icons left">fingerprint</i> ${data.messageId?split(",")?join("")}</p>
                    <i class="material-icons left hide-on-large-only tooltipped" data-position="left" data-tooltip="${data.messageId?split(",")?join("")}">fingerprint</i>
                </div>
            </div>
        </div>
    </div>
</#macro>

<@layout.logs "Kyubey - Logs" ":eyes:" "Logs">
    <#if (logs?size > 0)>
        <div class="row">
            <div class="col s12 l4">
                <h5 style="font-weight:bold;">Logs for ${logs[0].guildName}</h5>
                <p>Channel: #${logs[0].channelName}</p>
                <p>Last message: <span class="momentify">${logs[0].timestamp?split(",")?join("")}</span></p>
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
    <#else>
        <div class="row">
            <div class="s12 center">
                <h3>:<</h3>
                <h5>No logs were found.</h5>
            </div>
        </div>
    </#if>
</@layout.logs>