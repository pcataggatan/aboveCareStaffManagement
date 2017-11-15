<!DOCTYPE html>
<%@include file="taglib.jsp"%>

<html lang="en">

<c:set var="title" value="Person Detail" scope="session" />
<%@include file="headtag.jsp"%>

<%@include file="header.jsp"%>

<div class="container-fluid text-center">
    <div class="row content">
        <c:choose>
            <c:when test="${personType == 'Client'}">
                <%@include file="content-clientDetail.jsp"%>
            </c:when>
            <c:when test="${personType == 'Staff'}">
                <%@include file="content-staffDetail.jsp"%>
            </c:when>
        </c:choose>
        <%@include file="menu.jsp"%>
    </div>
</div>

<%@include file="footer.jsp"%>

</body>
</html>
