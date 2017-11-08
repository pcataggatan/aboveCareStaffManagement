<%@ include file="taglib.jsp" %>

<nav class="navbar navbar-inverse">
	<div class="container-fluid">

		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/aboveCareStaffManagement"><strong>Above Care Staff Management</strong></a>
		</div>

		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li><a href="/aboveCareStaffManagement">Home</a></li>
				<li><a href="aboutUs.jsp">About Us</a></li>
				<li><a href="contactUs.jsp">Contact Us</a></li>
			<!--</ul> -->
			<!--<ul class="nav navbar-nav navbar-right"> -->
				<c:choose>
					<c:when test="${loggedIn == 'Yes'}">
						<li><a href="user-logout-page">Logout <span class="glyphicon glyphicon-log-out"></span></a></li>
					</c:when>
					<c:otherwise>
						<li><a href="user-home-page"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>

	</div>
</nav>