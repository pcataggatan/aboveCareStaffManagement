<%@include file="taglib.jsp"%>

<div class="col-md-10 text-left">
    <br>
    <h2>${assignClientMsg}</h2>
    <h3>Assign a client to ${assignToStaff}</h3>
    <br>
    <form action="assign-client" method="GET">
        <label for="assignClientId">Select a Client &nbsp;</label>
        <select id="assignClientId" name="assignClientId">
            <c:forEach var="client" items="${clientList}">
                <option value="${client.getKey()}">${client.getKey()} - ${client.getValue()}</option>
            </c:forEach>
        </select>

        <%--<input type="text" id="assignClientId" name="assignClientId" autofocus> --%>

        &nbsp;
        <button type="submit" class="btn btn-primary">Assign</button>
    </form>

    <br>
    <%-- <p><a href="/aboveCareStaffManagement">Back to home page</a> &emsp;&nbsp; --%>
    <p><a href="search-staff?searchTerm=&searchType=viewAll">Go to List of Staff</a></p>
    <br>
</div>

