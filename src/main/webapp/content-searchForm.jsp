<%@include file="taglib.jsp"%>

<div class="col-md-6 text-right"">
    <br><br>

    <c:choose>
        <c:when test="${searchFor == 'Client'}">
            <form action="search-client" method="GET">
        </c:when>
        <c:when test="${searchFor == 'Staff'}">
            <form action="search-staff" method="GET">
        </c:when>
    </c:choose>

        <label for="searchTerm">Search</label>
        <input type="text" id="searchTerm" name="searchTerm" autofocus>
        &nbsp;
        <button type="submit" value="byLastname" name="searchType" class="btn btn-primary">By LastName</button>
        &nbsp;
        <button type="submit" value="viewAll" name="searchType" class="btn btn-primary">All</button>
    </form>

    <br>
    <p><a href="/aboveCareStaffManagement">Back to home page</a></p>
    <br>
</div>
<div class="col-md-4 text-right"></div>
