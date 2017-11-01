<%@include file="taglib.jsp"%>

<div class="col-md-10 text-left">
    <br>
    <h2>${updateMsg}</h2>
    <c:choose>
        <c:when test="${updatePersonType == 'Client'}">
            <h3>Name: ${updatedClient}</h3>
        </c:when>
        <c:when test="${updatePersonType == 'Staff'}">
            <h3>Name: ${updatedStaff}</h3>
        </c:when>
    </c:choose>

    <br>
    <p><a href="/aboveCareStaffManagement">Back to home page</a> &emsp;
        <c:choose>
            <c:when test="${updatePersonType == 'Client'}">
                <a href="search-client?searchTerm=&searchType=viewAll">List of Clients</a>
            </c:when>
            <c:when test="${updatePersonType == 'Staff'}">
                <a href="search-staff?searchTerm=&searchType=viewAll">List of Staff</a>
            </c:when>
        </c:choose>
    </p>
    <br>
</div>
