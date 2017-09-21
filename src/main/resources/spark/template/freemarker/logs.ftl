<#import "layout.ftl" as layout>

<@layout.main "Kyubey - Logs" ":eyes:" "Logs">
    <#list logs as log>
        <div>#{log.HTMLContent}</div>
    </#list>
</@layout.main>