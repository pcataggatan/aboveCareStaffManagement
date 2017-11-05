<%@include file="taglib.jsp"%>

<div class="col-md-10 text-left">
    <h2>Staff Detail</h2>
    <br>
    <table class="table table-striped">
        <!-- <tbody> -->
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

        <!-- </tbody> -->
    </table>

    <c:if test="${staffDetail.getClients().size() == 0}">
        <p><strong>Clients : &nbsp;</strong>None</p>
    </c:if>

    <c:if test="${staffDetail.getClients().size() > 0}">
        <p><strong>Clients</strong></p>
        <ul style="list-style-type: none;">
          <c:forEach var="client" items="${staffDetail.getClients()}">
              <li>(${client.getClientId()})
                  <a href="client-detail?idClient=${client.getClientId()}">
                      ${client.getFirstName()} ${client.getLastName()}</a></li>
          </c:forEach>
        </ul>
    </c:if>

    <br>
    <p><a href="/aboveCareStaffManagement">Back to home page</a> &emsp;&nbsp;
        <a href="search-staff?searchTerm=&searchType=viewAll">List of Staff</a>
    </p>
    <br>

</div>


