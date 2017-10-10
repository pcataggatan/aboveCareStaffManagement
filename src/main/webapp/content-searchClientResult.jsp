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

        <c:forEach var="client" items="${clientList}">
            <tr>
                <td><a href="client-detail?idClient=${client.clientId}">${client.firstName} ${client.lastName}</a></td>
                <td>${client.birthDt}</td>
                <td>${client.stAddr1}</td>
                <td>${client.city}</td>
                <td>${client.zipcode}</td>
                <td><a href="update-client?idClient=${client.clientId}">Update</a></td>
                <td><a href="delete-client?idClient=${client.clientId}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>

    <br>
    <p><a href="/aboveCareStaffManagement">Back to home page</a></p>

</div>


