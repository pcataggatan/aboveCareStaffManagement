<%@include file="taglib.jsp"%>

<div class="col-md-10 text-left">
    <h2>List of Clients</h2>
    <p align="right"><a href="add-client-form">Add New Client</a></p><br>

    <table class="table table-striped">
        <tr>
            <th>Client Id</th>
            <th>Client Name</th>
            <th>Staff Name</th>
            <th></th>
            <th></th>
        </tr>

        <c:forEach var="client" items="${clientList}">
            <tr>
                <td>${client.clientId}</td>
                <td><a href="client-detail?idClient=${client.clientId}">
                        ${client.firstName} ${client.lastName}</a>
                </td>
                <td><a href="staff-detail?idStaff=${client.staff.staffId}">
                        ${client.staff.firstName} ${client.staff.lastName}</a>
                </td>
                <td><a href="update-client-form?idClient=${client.clientId}">Update</a></td>
                <td><a href="confirm-delete-client?idClient=${client.clientId}">Delete</a></td>
            </tr>
        </c:forEach>

    </table>

    <%--
    <br>
    <p><a href="/aboveCareStaffManagement">Back to home page</a></p>
    <br>
    --%>
</div>


