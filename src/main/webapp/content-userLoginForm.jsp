<%@include file="taglib.jsp"%>

<div class="col-md-7 text-right">
    <br><br><br>
    <form action="j_security_check" method="POST">
        User Name: <input type ="text" name ="j_username" placeholder="username" autofocus><br><br>
        Password: <input type="password" name="j_password" placeholder="password"><br><br>
        <input type="submit" value="Login">
    </form>
    <br>
    <p><a href="/aboveCareStaffManagement">Back to home page</a></p>
</div>
<div class="col-md-3 text-right"></div>