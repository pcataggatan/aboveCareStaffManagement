<%@include file="taglib.jsp"%>

<div class="col-sm-10 text-center">
    <br>
    <span style="text-align:right;">
    <form  action="j_security_check" method="POST">
        User Name: <input type ="text" name ="j_username" placeholder="username" autofocus><br><br>
        Password: <input type="password" name="j_password" placeholder="password"><br><br>
        <input type="submit" value="Login">
    </form>
    </span>
</div>