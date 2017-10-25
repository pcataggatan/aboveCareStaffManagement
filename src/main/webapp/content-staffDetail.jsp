<%@include file="taglib.jsp"%>

<div class="col-sm-10 text-left">
    <h2>Staff Search Results:</h2>

    <table class="table borderless">
        <tbody>
        <tr>
            <td class="col-sm-2">Full Name</td>
            <td class="col-sm-10">${staffDetail.firstName} ${staffDetail.lastName}</td>
        </tr>

        <tr>
            <td>Street Address</td>
            <td>${staffDetail.address.getStreet()}
                ${staffDetail.address.getCity()},
                ${staffDetail.address.getState()}
                ${staffDetail.address.getZipcode()}
            </td>
        </tr>

        <tr><td>Birth Date</td>
            <td>${staffDetail.birthDt}</td>
        </tr>
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
            <td>Pay Rate Code</td>
            <td>${staffDetail.payCd}</td>
        </tr>

        </tbody>
    </table>

    <c:if test="${staffDetail.getClients().size() == 0}">
        <p><strong>Clients : &nbsp;</strong>None</p>
    </c:if>

    <c:if test="${staffDetail.getClients().size() > 0}">
        <p><strong>Clients:</strong></p>
        <ul style="list-style-type: none;">
          <c:forEach var="client" items="${staffDetail.getClients()}">
              <li><a href="client-detail?idClient=${client.getClientId()}">
                      ${client.getFirstName()} ${client.getLastName()}</a></li>
          </c:forEach>
        </ul>
    </c:if>

    <br>
    <p><a href="/aboveCareStaffManagement">Back to home page</a></p>

</div>

