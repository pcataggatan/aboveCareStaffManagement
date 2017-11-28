<!DOCTYPE html>
<%@include file="taglib.jsp"%>

<html lang="en">


<c:choose>
    <c:when test="${personType == 'Client'}">
        <c:set var="title" value="Client List" scope="session" />
    </c:when>
    <c:when test="${personType == 'Staff'}">
        <c:set var="title" value="Staff List" scope="session" />
    </c:when>
</c:choose>

<%@include file="headtag.jsp"%>

<%@include file="header.jsp"%>

<div class="container-fluid text-center">
    <div class="row content">
        <c:choose>
            <c:when test="${personType == 'Client'}">
                <%@include file="content-searchClientResult.jsp"%>
            </c:when>
            <c:when test="${personType == 'Staff'}">
                <%@include file="content-searchStaffResult.jsp"%>
            </c:when>
        </c:choose>
        <%@include file="menu.jsp"%>
    </div>
</div>

<%@include file="footer.jsp"%>

</body>
</html>
