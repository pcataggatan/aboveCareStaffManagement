<%@include file="taglib.jsp"%>

<div class="col-sm-10 text-left">
    <h2>Search Results:</h2>

    <table class="table borderless">
        <tbody>
        <tr>
            <td class="col-sm-2">Full Name</td>
            <td class="col-sm-10">${staffDetail.firstName} ${staffDetail.lastName}</td>
        </tr>

        <tr><td>Birth Date</td>
            <td>${staffDetail.birthDt}</td>
        </tr>

        <%--
        <tr>
            <td>Street Address1</td>
            <td>${staffDetail.stAddr1}</td>
        </tr>

        <c:if test="${!(staffDetail.stAddr2 == null) && !(staffDetail.stAddr2 == '')}">
            <tr>
                <td>Street Address2</td>
                <td>${staffDetail.stAddr2}</td>
            </tr>
        </c:if>

        <tr>
            <td>City</td>
            <td>${staffDetail.city}</td>
        </tr>
        <tr>
            <td>State</td>
            <td>${staffDetail.state}</td>
        </tr>
        <tr>
            <td>Zipcode</td>
            <td>${staffDetail.zipcode}</td>
        </tr>
        --%>

        <tr>
            <td>Phone</td>
            <td>${staffDetail.phoneNr}</td>
        </tr>
        <tr>
            <td>Email</td>
            <td>${staffDetail.email}</td>
        </tr>
        <tr>
            <td>Job Title</td>
            <td>${staffDetail.jobTitle}</td>
        </tr>
        <tr>
            <td>Pay Rate Cd</td>
            <td>${staffDetail.payCd}</td>
        </tr>

        <%--
        <tr>
            <td>Hours Worked</td>
            <td>${staffDetail.hoursWorked}</td>
        </tr>
        --%>
        </tbody>
    </table>

    <p><a href="/aboveCareStaffManagement">Back to home page</a></p>

</div>


