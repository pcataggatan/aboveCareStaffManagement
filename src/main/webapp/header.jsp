<%@ include file="taglib.jsp" %>

	<div id="header">
		<div id="headerlinks">
		  <a href="/aboveCareStaffManagement" title="Home Page">Home</a>
		  <a href="#" title="About Us">About Us</a>
		  <a href="#" title="Contact">Contact Us</a>
		  <c:choose>
			  <c:when test="${loggedIn == 'Yes'}">
			  	  <a href="user-logout-page" title="Logout">Logout</a>
			  </c:when>
			  <c:otherwise>
				  <a href="user-home-page" title="Login">Login</a>
			  </c:otherwise>
		  </c:choose>

		</div>
		<h1><a href="#">Above Care Staff Management</a></h1>
		<h2>by Pablo Cataggatan</h2>
	</div>