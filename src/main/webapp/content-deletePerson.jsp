<%@include file="taglib.jsp"%>

<div class="col-md-10 text-left">
    <br>
    <h2>${deleteMsg}</h2>

    <br>
    <p>
    <%-- <a href="/aboveCareStaffManagement">Back to home page</a> &emsp;&nbsp; --%>
    <c:choose>
        <c:when test="${personType == 'Client'}">
            <a href="search-person?searchTerm=&searchType=viewAll">Go to List of Clients</a>
        </c:when>
        <c:when test="${personType == 'Staff'}">
            <a href="search-person?searchTerm=&searchType=viewAll">Go to List of Staff</a>
        </c:when>
    </c:choose>
    </p>
    <br>
</div>

