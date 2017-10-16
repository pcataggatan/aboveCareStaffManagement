<%@include file="taglib.jsp"%>

<div class="col-sm-10 text-left">
    <br>
    <h1>${deleteMsg}</h1>
    <c:choose>
        <c:when test="${deletedPerson == 'Client'}">
            <h3>${deletedClient}</h3>
        </c:when>
        <c:when test="${deletedPerson == 'Staff'}">
            <h3>${deletedStaff}</h3>
        </c:when>
    </c:choose>
    <br>
    <p><a href="/aboveCareStaffManagement">Back to home page</a></p>

</div>

