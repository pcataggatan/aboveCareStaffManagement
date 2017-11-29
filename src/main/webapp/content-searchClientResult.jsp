<%@include file="taglib.jsp"%>

<div class="col-md-10 text-left">
    <h2>List of Clients</h2>
    <br>
    <%-- <p align="right"><a href="add-person-form?personType=Client">Add New Client</a></p> --%>

    <table id="clientListTable" class="table table-striped">
        <thead>
        <tr>
            <th>Client Id</th>
            <th>Client Name</th>
            <th>Staff Name</th>
            <th></th>
            <th></th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="client" items="${clientList}">
            <tr>
                <td>${client.clientId}</td>
                <td><a href="person-detail?idPerson=${client.clientId}&personType=Client">
                        ${client.firstName} ${client.lastName}</a>
                </td>
                <td><a href="person-detail?idPerson=${client.staff.staffId}&personType=Staff">
                        ${client.staff.firstName} ${client.staff.lastName}</a>
                </td>
                <td><a href="update-person-form?idPerson=${client.clientId}">Update Client Info</a></td>
                <td><a href="confirm-delete-person?idPerson=${client.clientId}">Delete Client</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <script>
        $(document).ready(function(){
            $('#clientListTable').dataTable();
        });
    </script>

    <br>
</div>


