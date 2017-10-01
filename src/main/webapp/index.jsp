<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
--%>

<%@include file="taglib.jsp"%>
<c:set var="title" value="Home Page" scope="session" />
<%@include file="headtag.jsp"%>

<html><body>


<div id="wrap">
    <%@ include file="header.jsp" %>
    <%-- if userLoggedIn then display menu
         else display something like quote of the day on the sidebar
     --%>
    <%@ include file="menu.jsp" %>
    <%@ include file="content-home.jsp" %>
    <%@ include file="footer.jsp" %>
</div>


<!--
<div id="content">
    <form action="search-client" method="GET">
        <div>
            <label for="searchTerm">Search</label>
            <input type="text" id="searchTerm" name="searchTerm" autofocus><br/><br/>
        </div>

        <button type="submit" value="byLastname" name="searchType">By LastName</button>
        <button type="submit" value="viewAll" name="searchType">All</button>
    </form>
    <br>
    <p><a href="#">Back to home page</a></p>

</div>
-->


</body>
</html>
