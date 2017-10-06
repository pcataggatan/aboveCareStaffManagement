<%@ include file="taglib.jsp"%>

<div id="content">
    <form action="j_security_check" method="POST">
        <input type ="text" name ="j_username" placeholder="username"></br>
        <input type="password" name="j_password" placeholder="password"></br>
        <input type="submit" value="Login" name="loginBtn">
        <!--<input type="submit" value="Cancel" name="loginBtn"> -->
    </form>

</div>
