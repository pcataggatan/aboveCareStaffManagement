	<div id="sidebar">
		 <div class="box">
		  <ul>
		  	<li><a href="user-login-form">Login</a></li>
        	<li><a href="search-client-form">Search Client</a></li>
			<li><a href="search-staff-form">Search Staff</a></li>
			<%-- if userRole = 'Owner' then display these links --%>

			<li><a href="staff-for-client-display">Staffing</a></li>
			<li><a href="wages-profits-display">Wages and Profits</a></li>
			<li><a href="search-rate-table-display">Rate Table</a></li>
			<%-- Rate Table includes search, add, update and delete --%>

		  	<%-- if userRole = 'Scheduler' then display these links --%>
			<li><a href="client-management-display">Client Management</a></li>
			<%-- Client Management includes search, add, update and delete --%>
			<li><a href="staff-management-display">Staff Management</a></li>
			<%-- Staff Management includes search, add, update and delete --%>
			<li><a href="schedules-display">Schedules</a></li>
			<%-- Scheules includes search, add, update and delete --%>
			<li><a href="time-entry--display">Time Entry</a></li>
			<%-- Time Entry includes search and add (start and end dates)--%>
		  </ul>
		 </div>

	</div>