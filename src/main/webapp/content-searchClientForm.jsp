<%@include file="taglib.jsp"%>

<div class="col-sm-10 text-left">
    <br>
    <form action="search-client" method="GET">
        <label for="searchTerm">Search</label>
        <input type="text" id="searchTerm" name="searchTerm" autofocus>
        &nbsp;
        <button type="submit" value="byLastname" name="searchType">By LastName</button>
        &nbsp;
        <button type="submit" value="viewAll" name="searchType">All</button>
    </form>
    <br>
    <p><a href="/aboveCareStaffManagement">Back to home page</a></p>

</div>
