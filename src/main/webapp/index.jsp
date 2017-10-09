<!DOCTYPE html>
<%@include file="taglib.jsp"%>

<html lang="en">

<c:set var="title" value="Home Page" scope="session" />
<%@include file="headtag.jsp"%>

<%@include file="header.jsp"%>

<div class="container-fluid text-center">
    <div class="row content">
        <%@include file="content-home.jsp"%>
        <%@include file="menu.jsp"%>
    </div>
</div>

<%@include file="footer.jsp"%>

</body>
</html>
