<%@include file="taglib.jsp"%>

<div class="col-sm-10 text-left">
    <h2>Search Results: </h2>

    <table border="1">
        <%--<tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Birth Date</th>
            <th>Street Address</th>
            <th>City</th>
            <th>Zipcode</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Bill Cd</th>
            <th>Sched1</th>
            <th>Sched2</th>
            <th>Sched3</th>
        </tr>--%>

        <c:forEach var="client" items="${clients}">
            <tr>
                <td>${client.firstName}</td>
                <td>${client.lastName}</td>
                <td>${client.birthDt}</td>
                <td>${client.stAddr1}</td>
                <td>${client.city}</td>
                <td>${client.zipcode}</td>
                <td>${client.phoneNr}</td>
                <td><a href="#">${client.clientId}</td>
                <%--
                <td>${client.email}</td>
                <td>${client.billCd}</td>
                <td>${client.sched1}</td>
                <td>${client.sched2}</td>
                <td>${client.sched3}</td>
                --%>

            </tr>
        </c:forEach>
    </table>

    <br>
    <p><a href="/aboveCareStaffManagement">Back to home page</a></p>

</div>


