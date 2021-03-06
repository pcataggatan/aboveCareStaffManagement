<%@include file="taglib.jsp"%>

<div class="col-md-10 text-left">
    <h2>Staff Detail</h2>
    <p align="right">
    <a href="update-person-form?idPerson=${staffDetail.staffId}">Update Staff Info</a> &nbsp; | &nbsp;
    <a href="confirm-delete-person?idPerson=${staffDetail.staffId}">Delete Staff</a> &nbsp; | &nbsp;
    <a href="assign-client-form?idStaff=${staffDetail.staffId}">Assign Client(s)</a> &nbsp; | &nbsp;
    <a href="search-person?searchTerm=&searchType=viewAll">Go to List of Staff</a>
    </p>

    <table class="table table-striped">
        <tbody>
        <tr>
            <td class="col-md-2">Staff Id</td>
            <td class="col-md-8">${staffDetail.staffId}</td>
        </tr>
        <tr>
            <td>Full Name</td>
            <td><strong>${staffDetail.firstName} ${staffDetail.lastName}</strong></td>
        </tr>

        <tr>
            <td>Street Address</td>
            <td>${staffDetail.address.getStreet()}
                ${staffDetail.address.getCity()},
                ${staffDetail.address.getState()}
                ${staffDetail.address.getZipcode()}
            </td>
        </tr>

        <tr>
            <td>Birth Date</td>
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
            <c:choose>
                <c:when test="${userRole == 'Admin' || userRole == 'Owner'}">
                    <td>${staffDetail.payCd} <span style="color:red">($${staffDetail.hourlyRate})</span></td>
                </c:when>
                <c:otherwise>
                    <td>${staffDetail.payCd}</td>
                </c:otherwise>
            </c:choose>
        </tr>

        <tr>
            <td>Schedule</td>
            <td>${staffDetail.schedule}</td>
        </tr>
        </tbody>
    </table>

    <c:if test="${staffDetail.getClients().size() == 0}">
        <p><strong>Clients :</strong> &nbsp; &nbsp; None</p>
    </c:if>

    <c:if test="${staffDetail.getClients().size() > 0}">
        <p><strong>Clients</strong></p>
        <ul style="list-style-type: none;">
          <c:forEach var="client" items="${staffDetail.getClients()}">
              <li>(${client.getClientId()})
                  <a href="person-detail?idPerson=${client.getClientId()}&personType=Client">
                      ${client.getFirstName()} ${client.getLastName()}</a></li>
          </c:forEach>
        </ul>
    </c:if>

    <p align="right">
    <a href="update-person-form?idPerson=${staffDetail.staffId}">Update Staff Info</a> &nbsp; | &nbsp;
    <a href="confirm-delete-person?idPerson=${staffDetail.staffId}">Delete Staff</a> &nbsp; | &nbsp;
    <a href="assign-client-form?idStaff=${staffDetail.staffId}">Assign Client(s)</a> &nbsp; | &nbsp;
    <a href="search-person?searchTerm=&searchType=viewAll">Go to List of Staff</a>
    </p>
    <br>

</div>


