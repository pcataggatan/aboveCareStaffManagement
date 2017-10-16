<%@include file="taglib.jsp"%>

<div class="col-sm-10 text-left">
    <h2>Search Results: </h2>

    <table class="table borderless">
        <tbody>
        <tr>
            <td class="col-sm-2">Full Name</td>
            <td class="col-sm-10">${clientDetail.firstName} ${clientDetail.lastName}</td>
        </tr>

        <tr><td>Birth Date</td>
            <td>${clientDetail.birthDt}</td>
        </tr>
        <tr>
            <td>Street Address1</td>
            <td>${clientDetail.stAddr1}</td>
        </tr>

        <c:if test="${!(clientDetail.stAddr2 == null) && !(clientDetail.stAddr2 == '')}">
            <tr>
                <td>Street Address2</td>
                <td>${clientDetail.stAddr2}</td>
            </tr>
        </c:if>

        <tr>
            <td>City</td>
            <td>${clientDetail.city}</td>
        </tr>
        <tr>
            <td>Zipcode</td>
            <td>${clientDetail.zipcode}</td>
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
            <td>Bill Rate Cd</td>
            <td>${clientDetail.billCd}</td>
        </tr>

        <tr>
            <td>Sched1</td>
            <td>${clientDetail.sched1}</td>
        </tr>

        <c:if test="${!(clientDetail.sched2 == null) && !(clientDetail.sched2 == '')}">
            <tr>
                <td>Sched3</td>
                <td>${clientDetail.sched2}</td>
            </tr>
        </c:if>
        <c:if test="${!(clientDetail.sched3 == null) && !(clientDetail.sched3 == '')}">
            <tr>
                <td>Sched3</td>
                <td>${clientDetail.sched3}</td>
            </tr>
        </c:if>

        </tbody>
    </table>

    <p><a href="/aboveCareStaffManagement">Back to home page</a></p>

</div>


