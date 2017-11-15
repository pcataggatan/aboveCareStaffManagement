<%@include file="taglib.jsp"%>

<div class="col-md-6 text-right"">
    <br><br>

    <form action="search-person" method="GET">
        <c:choose>
            <c:when test="${personType == 'Staff'}">
                <label for="searchTerm">Search Staff: </label>  &nbsp;
            </c:when>
            <c:when test="${personType == 'Client'}">
                <label for="searchTerm">Search Client: </label>  &nbsp;
            </c:when>
        </c:choose>
        <input type="text" id="searchTerm" name="searchTerm" autofocus> &nbsp;
        <button type="submit" value="byLastname" name="searchType" class="btn btn-primary">By LastName</button> &nbsp;
        <button type="submit" value="viewAll" name="searchType" class="btn btn-primary">All</button>
    </form>
    <br>
</div>
<div class="col-md-4 text-right"></div>
