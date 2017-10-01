<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Home Page" scope="session" />

<html>
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
