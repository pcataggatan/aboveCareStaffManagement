<%@include file="taglib.jsp"%>

<div class="col-sm-10 text-left">
    <h2>Search Results: </h2>
    <p align="right"><a href="add-new-staff">Add new staff</a></piv><br>

    <table class="table table-bordered">
        <tr>
            <th>Staff Name</th>
            <%--
            <th>Birth Date</th>
            <th>Street ClientDetail</th>
            <th>City</th>
            <th>Zipcode</th>
            --%>
        </tr>

        <c:forEach var="staff" items="${staffList}">
            <tr>
                <td><a href="staff-detail?idStaff=${staff.staffId}">${staff.firstName} ${staff.lastName}</a></td>
                <%--
                <td>${staff.birthDt}</td>
                <td>${staff.stAddr1}</td>
                <td>${staff.city}</td>
                <td>${staff.zipcode}</td>
                --%>
                <td><a href="update-staff?idStaff=${staff.staffId}">Update</a></td>
                <td><a href="delete-staff?idStaff=${staff.staffId}">Delete</a></td>
                <td><a href="assign-clienttoStaff?idStaff=${staff.staffId}">Assign Client</a></td>
                <td><a href="enter-timeSheet?idStaff=${staff.staffId}">Timesheet</a></td>
            </tr>
        </c:forEach>
    </table>

    <p><a href="/aboveCareStaffManagement">Back to home page</a></p>

</div>


