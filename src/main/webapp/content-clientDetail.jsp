<%@include file="taglib.jsp"%>

<div class="col-md-10 text-left">
    <h2>Client Detail</h2>
    <p align="right">
    <a href="update-client-form?idClient=${clientDetail.clientId}">Update Client Info</a> &nbsp; | &nbsp;
    <a href="confirm-delete-client?idClient=${clientDetail.clientId}">Delete Client</a> &nbsp; | &nbsp;
    <a href="search-client?searchTerm=&searchType=viewAll">Go to List of Clients</a>
    </p>

    <table class="table table-striped">
        <!--<tbody> -->
        <tr>
            <td>Client Id</td>
            <td>${clientDetail.clientId}</td>
        </tr>
        <tr>
            <td class="col-md-2">Full Name</td>
            <td class="col-md-8"><strong>${clientDetail.firstName} ${clientDetail.lastName}</strong></td>
        </tr>

        <tr>
            <td>Street Address</td>
            <td>${clientDetail.address.getStreet()}
                ${clientDetail.address.getCity()},
                ${clientDetail.address.getState()}
                ${clientDetail.address.getZipcode()}
            </td>
        </tr>

        <tr>
            <td>Birth Date</td>
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
            <c:choose>
                <c:when test="${userRole == 'Admin' || userRole == 'Owner'}">
                    <td>${clientDetail.billCd} <span style="color:red">($${clientDetail.hourlyRate})</span></td>
                </c:when>
                <c:otherwise>
                    <td>${clientDetail.billCd}</td>
                </c:otherwise>
            </c:choose>
        </tr>

        <!-- </tbody> -->
    </table>

    <c:if test="${clientDetail.staff == null}">
        <p><strong>Assigned Staff :</strong> &nbsp; &nbsp; None</p>
    </c:if>

    <c:if test="${clientDetail.staff != null}">
        <p><strong>Assigned Staff</strong></p>
        <ul style="list-style-type: none;">
            <li>(${clientDetail.staff.getStaffId()})
                <a href="staff-detail?idStaff=${clientDetail.staff.getStaffId()}">
                ${clientDetail.staff.getFirstName()} ${clientDetail.staff.getLastName()}</a>
            </li>
        </ul>
    </c:if>


    <p align="right">
    <%--<a href="/aboveCareStaffManagement">Back to home page</a> &emsp;&nbsp; --%>
    <a href="update-client-form?idClient=${clientDetail.clientId}">Update Client Info</a> &nbsp; | &nbsp;
    <a href="confirm-delete-client?idClient=${client.clientId}">Delete Client</a> &nbsp; | &nbsp;
    <a href="search-client?searchTerm=&searchType=viewAll">Go to List of Clients</a>
    </p>
    <br>
</div>


