<%@ include file="taglib.jsp" %>

<div class="col-sm-2 sidenav text-lef">
	<br>
	<c:if test="${userRole == 'Admin' || userRole == 'Owner' || userRole == 'OfficeStaff'}">
		<p><a href="search-staff-form">Search Staff</a></p>
		<p><a href="#">Add New Staff</a></p>
		<p><a href="#">Assign Client To Staff</a></p>
		<p><a href="search-client-form">Search Clients</a></p>
	</c:if>

	<c:if test="${userRole == 'Admin' || userRole == 'Owner'}">
		<p><a href="#">Client Staffing</a></p>
		<p><a href="#">Rate Maintenance</a></p>
	</c:if>
	<br>
</div>

