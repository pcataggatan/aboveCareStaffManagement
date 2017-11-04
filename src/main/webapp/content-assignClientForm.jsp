<%@include file="taglib.jsp"%>

<div class="col-md-10 text-left">
    <br>
    <h2>${assignClientMsg}</h2>
    <h3>Assign a client to ${assignToStaff}</h3>
    <br>
    <form action="assign-client" method="GET">
        <label for="assignClientId">Enter Client Id</label>
        <input type="text" id="assignClientId" name="assignClientId" autofocus>
        &nbsp;
        <button type="submit" class="btn btn-primary">Assign</button>
    </form>

    <br>
    <p><a href="/aboveCareStaffManagement">Back to home page</a> &emsp;&nbsp;
        <a href="search-staff?searchTerm=&searchType=viewAll">List of Staff</a>
    </p>
    <br>

</div>

