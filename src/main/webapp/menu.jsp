<%@ include file="taglib.jsp" %>

	<div id="sidebar">
		 <div class="box">
		  <ul>
			    <c:if test="${userRole == 'Owner'}">
					<li><a href="search-client-form">Search Client</a></li>
					<li>Search Staff</li>
			 	    <li>Staffing</li>
					<li>Wages and Profits</li>
					<li>Rate Table</li>
			  	</c:if>

	 		  	<c:if test="${userRole == 'OfficeStaff'}">
					<li><a href="search-client-form">Search Client</a></li>
					<li>Search Staff</li>
					<li>Client Management</li>
					<li>Staff Management</li>
					<li>Schedules</li>
					<li>Time Entry</li>
				</c:if>

		  </ul>

		  <%--
			<li><a href="staff-for-client-display">Staffing</a></li>
			<li><a href="wages-profits-display">Wages and Profits</a></li>
			<li><a href="search-rate-table-display">Rate Table</a></li>
			  Rate Table includes search, add, update and delete
		  --%>

		  	<%-- if userRole = 'ofc_staff' then display these links --%>
		  <%--
		   	<li><a href="client-management-display">Client Management</a></li>
			<%-- Client Management includes search, add, update and delete
			- -%>
			<li><a href="staff-management-display">Staff Management</a></li>
			<%-- Staff Management includes search, add, update and delete
			- -%>
			<li><a href="schedules-display">Schedules</a></li>
			<%-- Scheules includes search, add, update and delete
			- -%>
			<li><a href="time-entry--display">Time Entry</a></li>
			<%-- Time Entry includes search and add (start and end dates)
			- -%>
		   --%>

		 </div>

	</div>