<!DOCTYPE html>
<%@include file="taglib.jsp"%>

<html xmlns="http://www.w3.org/1999/xhtml">

<c:set var="title" value="User Login" scope="session" />
<%@include file="headtag.jsp"%>

<body>

<div id="wrap">
    <%@include file="header.jsp"%>

    <%@include file="content-userLoginForm.jsp"%>
    <%-- <form action="j_security_check" method="post">
        User Name: <input type="text" name="j_username"><br />
        Password:  <input type="password" name="j_password"><br />
        <input type="submit" value="login">
    </form>
    --%>

    <%@include file="footer.jsp"%>
</div>

</body>
</html>
