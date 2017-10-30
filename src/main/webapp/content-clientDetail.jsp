<%@include file="taglib.jsp"%>

<div class="col-md-10 text-left">
    <h2>Client Detail</h2>
    <br>
    <table class="table table-striped">
        <!--<tbody> -->
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
            <td>${clientDetail.billCd}</td>
        </tr>

        <!-- </tbody> -->
    </table>

    <c:if test="${clientDetail.staff == null}">
        <p><strong>Assigned Staff : &nbsp;</strong>None</p>
    </c:if>

    <c:if test="${clientDetail.staff != null}">
        <p><strong>Assigned Staff : &nbsp;</strong><a href="staff-detail?idStaff=${clientDetail.staff.getStaffId()}">
            ${clientDetail.staff.getFirstName()} ${clientDetail.staff.getLastName()}</a>
        </p>
    </c:if>

    <br>
    <p><a href="/aboveCareStaffManagement">Back to home page</a> &emsp;
        <a href="search-client?searchTerm=&searchType=viewAll">List of Clients</a>
    </p>
    <br>
</div>


