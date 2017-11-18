<%@include file="taglib.jsp"%>

<div class="col-md-6 text-right">
    <br>
    <h2>${errorMsg}</h2>
    <br>
    <form action="client-zipcode" method="GET">
            <label for="targetZipCode">Enter Client Zipcode: </label> &nbsp;
            <input type="text" value="${apiZipCode}" id="targetZipCode" maxlength="5"
                   name="targetZipCode" autofocus><br><br>
            <label for="targetRadius">Radius Distance</label> &nbsp;

            <select id="targetRadius" name="targetRadius">
                <option value="5">5</option>
                <option value="10">10</option>
                <option value="15">15</option>
                <option value="20">20</option>
                <option value="30">30</option>
                <option value="40">40</option>
                <option value="50">50</option>
            </select>
            <br><br>
            <button type="submit" class="btn btn-primary">Search Staff</button>
    </form>

    <br>
    <p><a href="search-person?searchTerm=&searchType=viewAll">Go to List of Clients</a></p>
    <br>
</div>

<div class="col-md-4 text-right"></div>