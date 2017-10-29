<%@include file="taglib.jsp"%>

<div class="col-md-10 text-left">
    <br>
    <h2>${addMsg}</h2>
    <c:choose>
        <c:when test="${addPersonType == 'Client'}">
            <h3>Name: ${addedClient}</h3>
        </c:when>
        <c:when test="${addPersonType == 'Staff'}">
            <h3>Name: ${addedStaff}</h3>
        </c:when>
    </c:choose>

    <br>
    <p><a href="/aboveCareStaffManagement">Back to home page</a> &emsp;
        <c:choose>
            <c:when test="${addPersonType == 'Client'}">
                <a href="search-client?searchTerm=&searchType=viewAll">List of clients</a>
            </c:when>
            <c:when test="${addPersonType == 'Staff'}">
                <a href="search-staff?searchTerm=&searchType=viewAll">List of staff</a>
            </c:when>
        </c:choose>
    </p>
    <br>
</div>