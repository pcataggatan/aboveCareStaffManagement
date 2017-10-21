<%@include file="taglib.jsp"%>

<div class="col-sm-10 text-left">
    <h2>Search Results: </h2>

    <table class="table borderless">
        <tbody>
        <tr>
            <td class="col-sm-2">Full Name</td>
            <td class="col-sm-10">${clientDetail.firstName} ${clientDetail.lastName}</td>
        </tr>

        <tr>
            <td>Street Address</td>
            <td>${clientDetail.address.getStreet()}
                ${clientDetail.address.getCity()},
                ${clientDetail.address.getState()}
                ${clientDetail.address.getZipcode()}
            </td>
        </tr>

        <tr><td>Birth Date</td>
            <td>${clientDetail.birthDt}</td>
        </tr>
        <tr>
            <td>Phone</td>
            <td>${clientDetail.phoneNr}</td>
        </tr>
        <tr>
            <td>Email</td>
            <td>${clientDetail.email}</td>
        </tr>
        <tr>
            <td>Bill Rate Code</td>
            <td>${clientDetail.billCd}</td>
        </tr>

        </tbody>
    </table>

    <%--
    <p><strong>Staff: </strong><a href="staff-detail?idStaff=${clientDetail.staff.getStaffId()}">
        ${clientDetail.staff.getFirstName()} ${clientDetail.staff.getLastName()}</a>
    </p>
    --%>

    <p><a href="/aboveCareStaffManagement">Back to home page</a></p>

</div>


