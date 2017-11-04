<%@include file="taglib.jsp"%>

<div class="col-md-6 text-right">
    <br><br><br>
    <form action="j_security_check" method="POST">
        User Name: <input type ="text" name ="j_username" placeholder="username" autofocus><br><br>
        Password: <input type="password" name="j_password" placeholder="password"><br><br>
        <%-- <input type="submit" value="Login">
        --%>
        <button type="submit" class="btn btn-primary">Login</button>
    </form>
    <br>
    <p><a href="/aboveCareStaffManagement">Back to home page</a></p>
</div>
<div class="col-md-4 text-right"></div>