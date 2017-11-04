<%@include file="taglib.jsp"%>

<div class="col-md-10 text-left">
    <h2>List of Staff</h2>
    <p align="right"><a href="add-staff-form">Add new staff</a></p><br>

    <table class="table table-striped">
        <tr>
            <th>Staff Id</th>
            <th>Staff Name</th>
            <th>Client Name</th>
            <th></th>
            <th></th>
            <th></th>
            <%-- <th style="display: none">Timesheet</th> --%>
        </tr>

        <c:forEach var="staff" items="${staffList}">
            <tr>
                <td>${staff.staffId}</td>
                <td><a href="staff-detail?idStaff=${staff.staffId}">
                        ${staff.firstName} ${staff.lastName}</a></td>
                <td>
                    <c:forEach var="client" items="${staff.clients}">
                        <a href="client-detail?idClient=${client.clientId}">
                            ${client.firstName} ${client.lastName}</a><br>
                    </c:forEach>
                </td>
                <td><a href="update-staff-form?idStaff=${staff.staffId}">Update</a></td>
                <td><a href="confirm-delete-staff?idStaff=${staff.staffId}">Delete</a></td>
                <td><a href="assign-client-form?idStaff=${staff.staffId}">Assign a client</a></td>
                <%-- <td><a href="assign-clienttoStaff?idStaff=${staff.staffId}">Assign Client</a></td>
                -->
                <%-- <td><a href="#">Timesheet</a></td>
                <td><a href="enter-timeSheet?idStaff=${staff.staffId}">Timesheet</a></td>
                --%>
            </tr>
        </c:forEach>
    </table>

    <br>
    <p><a href="/aboveCareStaffManagement">Back to home page</a></p>
    <br>
</div>


