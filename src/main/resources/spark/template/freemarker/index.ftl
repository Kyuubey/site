<#import "layout.ftl" as layout>

<@layout.main>
    <div class="row center">
        <div class="carousel carousel-slider center" data-indicators="true">
            <#list items as item>
                <div class="carousel-item kyubey-red white-text" href="#carousel!">
                    <h2>${item.title}</h2>
                    <div class="row center">
                        <#list item.features as feature>
                            <div class="col s3 center">
                                <div class="card">
                                    <div class="card-content red white-text">
                                        <br />
                                        <br />
                                        <br />
                                        <br />
                                    </div>
                                    <div class="card-action black-text">
                                        <span class="card-title">${feature.name}</span>
                                        <p>${feature.description}</p>
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