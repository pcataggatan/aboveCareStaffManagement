<%@include file="taglib.jsp"%>

<div class="col-md-10 text-left">
    <h2>Staff within ${targetRadius} miles of Client's zipcode ${targetZipCode}</h2>
    <br>
    <table class="table table-striped">
        <tr>
            <th>Staff Name</th>
            <th>Client Name</th>
            <th>Staff Address</th>
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
                <td>ToDo</td>
                <td>ToDo</td>

            </tr>
        </c:forEach>
    </table>

    <br>
    <p><a href="/aboveCareStaffManagement">Back to home page</a>  &emsp;&nbsp;
        <a href="search-staff?searchTerm=&searchType=viewAll">List of Staff</a> &emsp;&nbsp;
        <a href="search-client?searchTerm=&searchType=viewAll">List of Clients</a>
    </p>
    <br>
</div>

