<%@ include file="taglib.jsp" %>

<div class="col-sm-2 sidenav text-lef">
	<c:if test="${userRole == 'Admin' || userRole == 'Owner' || userRole == 'OfficeStaff'}">
		<p><a href="search-client-form">Search Clients</a></p>
		<p><a href="#">Add New Client</a></p>
		<p><a href="#">Search Staff</a></p>
		<p><a href="#">Add New Staff</a></p>
	</c:if>

	<c:if test="${userRole == 'Admin' || userRole == 'Owner'}">
		<p><a href="#">Client Staffing</a></p>
		<p><a href="#">Rate Maintenance</a></p>
	</c:if>
</div>

