<%@include file="taglib.jsp"%>

<div class="col-md-10 text-left">
    <br>
    <h2>${deleteMsg}</h2>
    <c:choose>
        <c:when test="${deletePersonType == 'Client'}">
            <h3>${deletedClient}</h3>
        </c:when>
        <c:when test="${deletePersonType == 'Staff'}">
            <h3>${deletedStaff}</h3>
        </c:when>
    </c:choose>

    <br>
    <p><a href="/aboveCareStaffManagement">Back to home page</a> &emsp;
        <c:choose>
            <c:when test="${deletePersonType == 'Client'}">
                <a href="search-client?searchTerm=&searchType=viewAll">Back to search results</a>
            </c:when>
            <c:when test="${deletePersonType == 'Staff'}">
                <a href="search-staff?searchTerm=&searchType=viewAll">Back to search results</a>
            </c:when>
        </c:choose>
    </p>
    <br>
</div>

