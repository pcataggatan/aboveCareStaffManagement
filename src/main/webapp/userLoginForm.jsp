<!DOCTYPE html>
<%@include file="taglib.jsp"%>

<html xmlns="http://www.w3.org/1999/xhtml">

<c:set var="title" value="User Login" scope="session" />
<%@include file="headtag.jsp"%>

<body>

<div id="wrap">
    <%@include file="header.jsp"%>
    <%-- <%@include file="menu.jsp"%> --%>
    <%@include file="content-userLoginForm.jsp"%>
    <%@include file="footer.jsp"%>
</div>

</body>
</html>
