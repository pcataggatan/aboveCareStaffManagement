<div id="content">
    Login As &nbsp;
    <select name="userRole" form="loginForm">
        <option name="role" value="Owner">Owner</option>
        <option name="role" value="Scheduler">Scheduler</option>
    </select> </br>

    <form action="user-login" id="loginForm" method="GET">
        <input type ="text" name ="username" placeholder="username"></br>
        <input type="password" name="password" placeholder="password"></br>
        <input type="submit" value="Login" name="loginBtn">
        <input type="submit" value="Cancel" name="loginBtn">
    </form>

    <br>
    <p><a href="/aboveCareStaffManagement">Back to home page</a></p>
</div>
