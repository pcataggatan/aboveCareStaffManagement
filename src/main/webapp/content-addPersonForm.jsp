<%@include file="taglib.jsp"%>

<div class="col-sm-10 text-left">
    <br>

    <c:choose>
        <c:when test="${addPersonType == 'Client'}">
            <form action="add-client" method="POST">
        </c:when>
        <c:when test="${addPersonType == 'Staff'}">
            <form action="add-staff" method="POST">
        </c:when>
    </c:choose>

            <label for="firstName">First Name </label>
            <input type="text" id="firstName" name="firstName" autofocus><br>

            <label for="lastName">Last Name </label>
            <input type="text" id="lastName" name="lastName"><br>

            <label for="birthDate">Birth Date </label>
            <input type="text" id="birthDate" name="birthDate"><br>

            <label for="street">Street Address </label>
            <input type="text" id="street" name="street"><br>

            <label for="city">City </label>
            <input type="text" id="city" name="city"><br>

            <label for="state">State </label>
            <input type="text" id="state" name="state"><br>

            <label for="zipcode">Zip Code </label>
            <input type="text" id="zipcode" name="zipcode"><br>

            <label for="phoneNr">Phone No. </label>
            <input type="text" id="phoneNr" name="phoneNr"><br>

            <label for="email">Email Address </label>
            <input type="text" id="email" name="email"><br>

        <c:choose>
            <c:when test="${addPersonType == 'Client'}">
                <label for="billCd">Bill Code </label>
                <input type="text" id="billCd" name="billCd"><br>
                <button type="submit">Add Client</button>
            </c:when>
            <c:when test="${addPersonType == 'Staff'}">
                <label for="payCd">Pay Code </label>
                <input type="text" id="payCd" name="payCd"><br>
                <label for="jobTitle">Job Title </label>
                <input type="text" id="jobTitle" name="jobTitle"><br>
                <button type="submit">Add Staff</button>
            </c:when>
        </c:choose>
    </form>
    <br>
    <p><a href="/aboveCareStaffManagement">Back to home page</a></p>

</div>