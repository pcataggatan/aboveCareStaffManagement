<%@include file="taglib.jsp" %>

<div class="container-fluid">
    <h2>Search Results: </h2>

    <%-- ${users} --%>
    <table border="1">
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Street Address</th>
            <th>City</th>
            <th>Zipcode</th>
            <th>Phone</th>
            <th>Email<th>
        </tr>

        <c:forEach var="client" items="${clients}">
            <tr>
                <td>${client.firstName}</td>
                <td>${client.lastName}</td>
                <td>${client.addrLine1}</td>
                <td>${client.city}</td>
                <td>${client.zipCd}</td>
                <td>${client.phoneNr}</td>
                <td>${client.email}</td>
            </tr>
        </c:forEach>
    </table>

    <br>
    <p><a href="/aboveCareStaffManagement">Back to home page</a></p>

</div>


