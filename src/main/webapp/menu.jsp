<%@ include file="taglib.jsp" %>

	<div id="sidebar">
		 <div class="box">
		  <ul>

			<%-- if userRole = 'Owner' then display these links --%>

		    <c:choose>
			  <c:when test="${userRole == 'Owner'}" >
				<li><a href="search-client-form">Search Client</a></li>
				<%-- <li><a href="search-staff-form">Search Staff</a></li> --%>
			  	<li>Search Staff</li>
			 	<li>Staffing</li>
				<li>Wages and Profits</li>
				<li>Rate Table</li>
			  </c:when>

			  <c:when test="${userRole == 'Assistant'}" >
				<li>Client Management</li>
				<li>Staff Management</li>
				<li>Schedules</li>
				<li>Time Entry</li>
			  </c:when>
			</c:choose>

		  <%--
			<li><a href="staff-for-client-display">Staffing</a></li>
			<li><a href="wages-profits-display">Wages and Profits</a></li>
			<li><a href="search-rate-table-display">Rate Table</a></li>
			<%-- Rate Table includes search, add, update and delete
			- -%>
		  --%>

		  	<%-- if userRole = 'Assistant' then display these links --%>
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
		  </ul>
		 </div>

	</div>