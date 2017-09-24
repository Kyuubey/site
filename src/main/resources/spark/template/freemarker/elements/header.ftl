<#macro index page="">
<header>
    <div class="section">
        <div class="container">
            <div class="row center">
                <div class="col s3 l1 offset-l1">
                    <h4 style="font-family:'Anydore';" class="header kyubey-red-text center-on-small-only">yube</h4>
                </div>
                <div class="col s1 offset-s6 l6 offset-l3">
                    <br />
                    <a class="hide-on-med-and-down waves-effect waves-teal btn-flat" href="/features">Features</a>
                    <a class="hide-on-med-and-down waves-effect waves-teal btn-flat" href="/support">Support</a>
                    <a class="hide-on-med-and-down waves-effect waves-teal btn-flat" href="/faq">FAQ</a>
                    <a class="hide-on-med-and-down waves-effect waves-teal btn kyubey-red" href="/invite">Invite!</a>
                    <ul id="nav-dropdown" class="dropdown-content">
                        <li>
                            <a href="/features">Features</a>
                        </li>
                        <li>
                            <a href="/support">Support</a>
                        </li>
                        <li>
                            <a href="/faq">FAQ</a>
                        </li>
                    </ul>
                    <a class="hide-on-large-only dropdown-button btn-flat" href="#" data-activates="nav-dropdown"><i class="material-icons">more_vert</i></a>
                </div>
            </div>
            <div class="row center">
                <div class="col s12 m1">
                    <img src="/img/kyubey.png" alt="kyubey.png" style="width:250px;">
                </div>
                <div class="col s12 m6 offset-m4">
                    <h1 style="font-family:'Anydore';" class="kyubey-red-text">yube</h1>
                    <#if page == "">
                        <h5>He'll make your Discord magical!</h5>
                        <a class="waves-effect waves-light btn kyubey-red" href="/invite"><i class="material-icons left">exit_to_app</i>Invite!</a>
                    <#else>
                        <h5>${page}</h5>
                    </#if>
                </div>
            </div>
        </div>
    </div>
</header>
</#macro>

<#macro logs page="">
<div id="filter-modal" class="modal">
    <div class="modal-content">
        <h4>Filters</h4>
        <div class="row">
            <div class="col s12 l4">
                <h5>Time</h5>
                <div class="row">
                    <div class="input-field col s12">
                        <label for="timestamp-filter-start">Timestamp start</label>
                        <input type="text" class="timepicker" id="timestamp-filter-start">
                    </div>
                    <div class="input-field col s12">
                        <label for="timestamp-filter-end">Timestamp end</label>
                        <input type="text" class="timepicker" id="timestamp-filter-end">
                    </div>
                </div>
            </div>
            <div class="col s12 l8">
                <h5>Other</h5>
                <div class="row">
                    <div class="input-field col s6">
                        <select id="events-filter" multiple>
                            <option value="" disabled selected>Select events</option>
                            <option value="delete">Deleted</option>
                            <option value="create">Created</option>
                            <option value="update">Edited</option>
                        </select>
                        <label>Events</label>
                    </div>
                    <div class="input-field col s6">
                        <label for="user-filter">User ID</label>
                        <input type="text" id="user-filter">
                    </div>
                    <div class="input-field col s6">
                        <label for="keyword-filter">Keywords (use "," to split)</label>
                        <input type="text" id="keyword-filter">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="modal-footer">
        <a href="#" class="modal-action modal-close waves-effect waves-teal btn-flat" id="apply-log-filters">Apply</a>
    </div>
</div>
<header>
    <nav class="kyubey-red">
        <div class="nav-wrapper">
            <a href="/" class="brand-logo" style="font-family:'Anydore';margin-left:10px;">yube</a>
            <ul id="nav-mobile" class="right hide-on-med-and-down">
                <li>
                    <a class="modal-trigger" href="#filter-modal"><i class="material-icons">filter_list</i></a>
                </li>
                <li>
                    <a href="#"><i class="material-icons">more_vert</i></a>
                </li>
            </ul>
        </div>
    </nav>
</header>
</#macro>