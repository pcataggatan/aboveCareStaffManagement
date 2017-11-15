<%@ include file="taglib.jsp" %>

<div class="col-md-2 sidenav text-center">
	<br><br><br>
	<c:if test="${userRole == 'Admin' || userRole == 'Owner' || userRole == 'OfficeStaff'}">
		<%-- <p><a href="search-staff-form">Search Staff</a></p> --%>
		<%-- <p><a href="add-staff-form">Add New Staff</a></p> --%>
		<p><a href="search-person-form?personType=Staff">Search Staff</a></p>
		<p><a href="add-person-form?personType=Staff">Add New Staff</a></p>

		<hr>

		<%-- <p><a href="search-client-form">Search Clients</a></p> --%>
		<%-- <p><a href="add-client-form">Add New Client</a></p> --%>
		<p><a href="search-person-form?personType=Client">Search Client</a></p>
		<p><a href="add-person-form?personType=Client">Add New Client</a></p>

	</c:if>

	<c:if test="${userRole == 'Admin' || userRole == 'Owner'}">
		<hr>
		<p><a href="client-zipcode-form">Possible Staff For<br> The Client</a></p>
		<!-- <p><a href="#">Rate Maintenance</a></p> -->
	</c:if>
	<br>
</div>

