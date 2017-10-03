<!DOCTYPE html>
<%@include file="taglib.jsp"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<c:set var="title" value="Home Page" scope="session" />
<%@include file="headtag.jsp"%>

<body>

<div id="wrap">
    <%@include file="header.jsp"%>
    <%-- if userLoggedIn then display menu
         else display something like quote of the day on the sidebar
     --%>
    <%@include file="menu.jsp"%>
    <%@include file="content-home.jsp"%>
    <%@include file="footer.jsp"%>
</div>

</body>
</html>
