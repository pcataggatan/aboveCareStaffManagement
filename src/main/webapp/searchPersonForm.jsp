<!DOCTYPE html>
<%@include file="taglib.jsp"%>

<html lang="en">

<c:choose>
    <c:when test="${personType == 'Client'}">
        <c:set var="title" value="Search Client" scope="session" />
    </c:when>
    <c:when test="${personType == 'Staff'}">
        <c:set var="title" value="Search Staff" scope="session" />
    </c:when>
</c:choose>

<%@include file="headtag.jsp"%>

<%@include file="header.jsp"%>

<div class="container-fluid text-center">
    <div class="row content">
        <%@include file="content-searchPersonForm.jsp"%>
        <%@include file="menu.jsp"%>
    </div>
</div>

<%@include file="footer.jsp"%>

</body>
</html>

