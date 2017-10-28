<%@include file="taglib.jsp"%>

<div class="col-md-10 text-left">
    <h2>Staff Search Results:</h2>
    <p align="right"><a href="add-staff-form">Add new staff</a></piv><br>

    <table class="table table-striped">
        <tr>
            <th>Staff Name</th>
            <th>Client Name(s)</th>
            <th></th>
            <th></th>
            <th></th>
            <%-- <th></th> --%>
        </tr>

        <c:forEach var="staff" items="${staffList}">
            <tr>
                <td><a href="staff-detail?idStaff=${staff.staffId}">${staff.firstName} ${staff.lastName}</a></td>

                <td>
                    <c:forEach var="client" items="${staff.clients}">
                        <a href="client-detail?idClient=${client.clientId}">
                            ${client.firstName} ${client.lastName}</a><br>
                    </c:forEach>
                </td>

                <td><a href="#">Update</a></td>
                <%-- <td><a href="update-staff?idStaff=${staff.staffId}">Update</a></td>
                --%>
                <td><a href="delete-staff?idStaff=${staff.staffId}">Delete</a></td>

                <td><a href="#">Assign Client</a></td>

                <%--
                <td><a href="#">Timesheet</a></td>
                <td><a href="assign-clienttoStaff?idStaff=${staff.staffId}">Assign Client</a></td>
                <td><a href="enter-timeSheet?idStaff=${staff.staffId}">Timesheet</a></td>
                --%>

            </tr>
        </c:forEach>
    </table>

    <br>
    <p><a href="/aboveCareStaffManagement">Back to home page</a></p>
    <br>
</div>


