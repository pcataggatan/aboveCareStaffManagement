<%@include file="taglib.jsp"%>

<div class="col-md-10 text-left">
    <h2>Staff within ${apiRadius} miles of Client's zipcode ${apiZipCode}</h2>
    <p align="right"><a href="search-person?searchTerm=&searchType=viewAll">Go to List of Clients</a></p>

    <table id="staffListTable" class="table table-striped">
        <thead>
        <tr>
            <th>Staff Id</th>
            <th>Staff Name</th>
            <th>Client Name(s)</th>
            <th>Schedule</th>
            <th>Staff Address</th>
            <th>Distance</th>
            <th>Pay Rate</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="staff" items="${possibleStaff}">
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

                <td>${staff.schedule}</td>

                <td>${staff.address.getStreet()}
                    ${staff.address.getCity()},
                    ${staff.address.getState()}
                    ${staff.address.getZipcode()}
                </td>
                <td>${staff.getDistance()} mi.</td>
                <td style="color:red">$${staff.getHourlyRate()}</td>

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
    <p align="right"><a href="search-person?searchTerm=&searchType=viewAll">Go to List of Clients</a></p>
    <br>
</div>

