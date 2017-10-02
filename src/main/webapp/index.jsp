<!DOCTYPE html>
<%@ include file="taglib.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<c:set var="title" value="Home Page" scope="session" />
<c:import url="headtag.jsp" />

<body>

<div id="wrap">
    <c:import url="header.jsp" />
    <%-- if userLoggedIn then display menu
         else display something like quote of the day on the sidebar
     --%>
    <c:import url="menu.jsp" />
    <c:import url="content-home.jsp" />
    <c:import url="footer.jsp" />
</div>

</body>
</html>
