<%@include file="taglib.jsp"%>

<div class="col-md-10 text-left">
    <br>
    <h2>${deleteMsg}</h2>

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

