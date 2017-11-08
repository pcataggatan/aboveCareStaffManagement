<%@include file="taglib.jsp"%>

<div class="col-md-10 text-left">
    <h2>List of Staff</h2>
    <p align="right"><a href="add-staff-form">Add new staff</a></p>

    <table id="staffListTable" class="table table-striped">
        <thead>
        <tr>
            <th>Staff Id</th>
            <th>Staff Name</th>
            <th>Client Name</th>
            <th></th>
            <th></th>
            <th></th>
        </tr>
        </thead>

        <tbody>
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
                <td><a href="update-staff-form?idStaff=${staff.staffId}">Update Staff Info</a></td>
                <td><a href="confirm-delete-staff?idStaff=${staff.staffId}">Delete Staff</a></td>
                <td><a href="assign-client-form?idStaff=${staff.staffId}">Assign Client(s)</a></td>
                <%-- <td><a href="#">Update Sched</a></td> --%>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <script>
        $(document).ready(function(){
            $('#staffListTable').dataTable();
        });
    </script>

    <%--
    <br>
    <p><a href="/aboveCareStaffManagement">Back to home page</a></p>
    <br>
    --%>
</div>


