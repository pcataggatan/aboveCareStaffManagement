<%@include file="taglib.jsp"%>

<div class="col-md-10 text-left">
    <h2>Staff Within ${targetRadius} miles of Client Zipcode ${targetZipCode}:</h2>
    <br>
    <table class="table table-striped">
        <tr>
            <th>Staff Name</th>
            <th>Client Name</th>
            <th>Address</th>
            <th>Distance</th>
            <th>Pay Rate</th>
        </tr>

        <c:forEach var="staff" items="${possibleStaff}">
            <tr>
                <td><a href="staff-detail?idStaff=${staff.staffId}">${staff.firstName} ${staff.lastName}</a></td>

                <td>
                    <c:forEach var="client" items="${staff.clients}">
                        ${client.firstName} ${client.lastName}<br>
                    </c:forEach>
                </td>

                <td>${staff.address.getStreet()}
                    ${staff.address.getCity()},
                    ${staff.address.getState()}
                    ${staff.address.getZipcode()}
                </td>
                <td></td>
                <td></td>

            </tr>
        </c:forEach>
    </table>

    <br>
    <p><a href="/aboveCareStaffManagement">Back to home page</a></p>
    <br>
</div>

