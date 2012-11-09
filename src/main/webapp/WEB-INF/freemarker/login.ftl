<META HTTP-EQUIV="Content-Type" CONTENT="text/html" charset="UTF-8">
<html>
    <head>
        <title> IOU </title>
        <script type="text/javascript" language="JavaScript">
            window.onload=initReload;
            function initReload() {
                if( window.history.forward() == "http://localhost:9130/twu/dashboard" )
                    window.location.href = "http://localhost:9130/twu/dashboard";
            }
        </script>
    </head>
    <body>
        <form action="checkLogin" method="post" id="loginForm">
            <label for="email">E-mail</label> <input type="text" id ="email" name="email"/> <br/>
            <label for="password">Password</label> <input type="password" id ="password" name="password"/>  <br/>
            <input type="submit" value="Login"> <br/>
            <input type="button" name="goToCreateAccountButton" id="goToCreateAccountButton" value="Create Account" onclick="javascript:window.location.href='http://localhost:9130/twu/createAccount'"/>
        </form>
    </body>
</html>