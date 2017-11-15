<%@include file="taglib.jsp"%>

<div class="col-md-6 text-right">
    <br><br><br>
    <form action="j_security_check" method="POST">
        <label for="usename">User Name:</label> &nbsp;
        <input id="usename" type ="text" name ="j_username" placeholder="username" autofocus><br><br>
        <label for="usename">Password:</label> &nbsp;
        <input id="password" type="password" name="j_password" placeholder="password"><br><br>
        <button type="submit" class="btn btn-primary">Login</button>
    </form>
    <br>
</div>
<div class="col-md-4 text-right"></div>