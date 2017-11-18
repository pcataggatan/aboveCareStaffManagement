<%@ include file="taglib.jsp" %>

<nav class="navbar navbar-inverse">
	<div class="container-fluid">

		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/aboveCareStaffManagement"><img src="images/AboveCareLogo2.jpg"></a>


		</div>

		<div class="collapse navbar-collapse" id="myNavbar">
			<br>
			<ul class="nav navbar-nav">
				<li><a href="/aboveCareStaffManagement"><strong>Home</strong></a></li>
				<li><a href="aboutUs.jsp"><strong>About Us</strong></a></li>
				<li><a href="contactUs.jsp"><strong>Contact Us</strong></a></li>
				<c:choose>
					<c:when test="${loggedIn == 'Yes'}">
						<li><a href="user-logout-page"><strong>Logout </strong>
							<span class="glyphicon glyphicon-log-out"></span></a></li>
					</c:when>
					<c:otherwise>
						<li><a href="user-home-page"><span class="glyphicon glyphicon-log-in"></span>
							<strong> Login</strong></a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>

	</div>
</nav>