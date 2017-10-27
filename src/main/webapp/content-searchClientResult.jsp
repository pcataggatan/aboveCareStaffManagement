<%@include file="taglib.jsp"%>

<div class="col-md-10 text-left">
    <h2>Client Search Results:</h2>
    <p align="right"><a href="add-client-form">Add New Client</a></piv><br>

    <table class="table table-striped">
        <tr>
            <th>Client Name</th>
            <th></th>
            <th></th>
            <%-- <th>Staff Name</th> --%>
        </tr>

        <c:forEach var="client" items="${clientList}">
            <tr>
                <td><a href="client-detail?idClient=${client.clientId}">${client.firstName} ${client.lastName}</a></td>

                <%--
                <td><a href="staff-detail?idStaff=${client.staff.staffId}">${client.staff.firstName} ${client.staff.lastName}</a></td>
                --%>

                <td><a href="#">Update</a></td>
                <%--<td><a href="update-client?idClient=${client.clientId}">Update</a></td>
                --%>
                <td><a href="delete-client?idClient=${client.clientId}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>

    <p><a href="/aboveCareStaffManagement">Back to home page</a></p>

</div>


