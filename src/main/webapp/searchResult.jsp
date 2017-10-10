<!DOCTYPE html>
<%@include file="taglib.jsp"%>

<html lang="en">

<c:set var="title" value="Search Result" scope="session" />
<%@include file="headtag.jsp"%>

<%@include file="header.jsp"%>

<div class="container-fluid text-center">
    <div class="row content">
        <c:choose>
            <c:when test="${searchFor == 'Client'}">
                <%@include file="content-searchClientResult.jsp"%>
            </c:when>
            <c:when test="${searchFor == 'Staff'}">
                <%@include file="content-searchStaffResult.jsp"%>
            </c:when>
        </c:choose>
        <%@include file="menu.jsp"%>
    </div>
</div>

<%@include file="footer.jsp"%>

</body>
</html>
