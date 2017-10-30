<%@include file="taglib.jsp"%>

<div class="col-md-10 text-left">
    <br>
    <h2>${deleteMsg}</h2>
    <c:choose>
        <c:when test="${deletePersonType == 'Client'}">
            <h3>Name: ${deletedClient}</h3>
        </c:when>
        <c:when test="${deletePersonType == 'Staff'}">
            <h3>Name: ${deletedStaff}</h3>
            <c:if test="${clientsForDeletedStaff.size() > 0}">
                <br>
                <h4>${deletedStaff} worked for the following client(s). Make sure to re-assign them to another staff.</h4>
                <ul style="list-style-type: none;">
                    <c:forEach var="client" items="${clientsForDeletedStaff}">
                        <li><a href="client-detail?idClient=${client.getClientId()}">
                                ${client.getFirstName()} ${client.getLastName()}</a>
                        </li>
                    </c:forEach>
                </ul>
            </c:if>
            <h4></h4>
        </c:when>
    </c:choose>

    <br>
    <p><a href="/aboveCareStaffManagement">Back to home page</a> &emsp;
        <c:choose>
            <c:when test="${deletePersonType == 'Client'}">
                <a href="search-client?searchTerm=&searchType=viewAll">List of Cliens</a>
            </c:when>
            <c:when test="${deletePersonType == 'Staff'}">
                <a href="search-staff?searchTerm=&searchType=viewAll">List of Staff</a>
            </c:when>
        </c:choose>
    </p>
    <br>
</div>

