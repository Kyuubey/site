<#import "layout.ftl" as layout>

<@layout.main>
    <div class="row">
        <div class="carousel carousel-slider" data-indicators="true">
            <#list items as item>
                <div class="carousel-item kyubey-red white-text" href="#carousel!">
                    <h2 class="center">${item.title}</h2>
                    <div class="row">
                        <#list item.features as feature>
                            <div class="col s3">
                                <div class="card">
                                    <div class="card-image red white-text">
                                        <br />
                                        <br />
                                        <br />
                                        <br />
                                    </div>
                                    <div class="card-content black-text">
                                        <span class="card-title">${feature.name}</span>
                                        <p class="truncate">${feature.description}</p>
                                    </div>
                                    <div class="card-action">
                                        <a href="/features#${feature.name}">More</a>
                                    </div>
                                </div>
                            </div>
                        </#list>
                    </div>
                </div>
            </#list>
        </div>
    </div>
</@layout.main>