<%@include file="taglib.jsp"%>

<div class="col-sm-10 text-left">
    <h2>Search Results: </h2>

    <table class="table table-bordered">
        <tr>
            <th>Full Name</th>
            <th>Birth Date</th>
            <th>Street Address</th>
            <th>City</th>
            <th>Zipcode</th>
        </tr>

        <c:forEach var="staff" items="${staffList}">
            <tr>
                <td><a href="staff-detail?idStaff=${staff.staffId}">${staff.firstName} ${staff.lastName}</a></td>
                <td>${staff.birthDt}</td>
                <td>${staff.stAddr1}</td>
                <td>${staff.city}</td>
                <td>${staff.zipcode}</td>
                <td><a href="update-staff?idClient=${staff.staffId}">Update</a></td>
                <td><a href="delete-staff?idClient=${staff.staffId}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>

    <br>
    <p><a href="/aboveCareStaffManagement">Back to home page</a></p>

</div>


