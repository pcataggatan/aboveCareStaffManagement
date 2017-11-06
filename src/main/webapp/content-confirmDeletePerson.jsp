<%@include file="taglib.jsp"%>

<div class="col-md-10 text-left">
    <br><br>
    <c:choose>
        <c:when test="${deletePersonType == 'Client'}">
            <span class="h3">Are you sure you want to delete client ${deletedClient}?</span> &emsp;
            <a href="delete-client" class="btn btn-primary">Yes</a> &nbsp;
            <a href="search-client?searchTerm=&searchType=viewAll" class="btn btn-primary">No</a>
            <br><br>
        </c:when>

        <c:when test="${deletePersonType == 'Staff'}">
            <span class="h3">Are you sure you want to delete staff ${deletedStaff}?</span> &emsp;
            <a href="delete-staff" class="btn btn-primary">Yes</a> &nbsp;
            <a href="search-client?searchTerm=&searchType=viewAll" class="btn btn-primary">No</a>
            <br><br>

            <c:if test="${clientsForDeletedStaff.size() > 0}">
                <h4>${deletedStaff} worked for the following client(s).<br>
                    Make sure to re-assign them to another staff if you wish to delete ${deletedStaff}.</h4>
                <ul style="list-style-type: none;">
                    <c:forEach var="client" items="${clientsForDeletedStaff}">
                        <li>(${client.getClientId()}) &nbsp;
                            <a href="client-detail?idClient=${client.getClientId()}">
                                ${client.getFirstName()} ${client.getLastName()}</a>
                        </li>
                    </c:forEach>
                </ul>
            </c:if>
        </c:when>
    </c:choose>

    <br>
    <p>
        <%-- <a href="/aboveCareStaffManagement">Back to home page</a> &emsp;&nbsp; --%>
        <c:choose>
            <c:when test="${deletePersonType == 'Client'}">
                <a href="search-client?searchTerm=&searchType=viewAll">Go to List of Clients</a>
            </c:when>
            <c:when test="${deletePersonType == 'Staff'}">
                <a href="search-staff?searchTerm=&searchType=viewAll">Go to List of Staff</a>
            </c:when>
        </c:choose>
    </p>
    <br>
</div>

