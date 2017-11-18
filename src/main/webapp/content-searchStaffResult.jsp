<%@include file="taglib.jsp"%>

<div class="col-md-10 text-left">
    <h2>List of Staff</h2>
    <p align="right"><a href="add-person-form?personType=Staff">Add New Staff</a></p>

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
                <td><a href="person-detail?idPerson=${staff.staffId}&personType=Staff">
                        ${staff.firstName} ${staff.lastName}</a></td>
                <td>
                    <c:forEach var="client" items="${staff.clients}">
                        <a href="person-detail?idPerson=${client.clientId}&personType=Client">
                            ${client.firstName} ${client.lastName}</a><br>
                    </c:forEach>
                </td>
                <td><a href="update-person-form?idPerson=${staff.staffId}">Update Staff Info</a></td>
                <td><a href="confirm-delete-person?idPerson=${staff.staffId}">Delete Staff</a></td>
                <td><a href="assign-client-form?idStaff=${staff.staffId}">Assign Client(s)</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <script>
        $(document).ready(function(){
            $('#staffListTable').dataTable();
        });
    </script>

    <br>
</div>


