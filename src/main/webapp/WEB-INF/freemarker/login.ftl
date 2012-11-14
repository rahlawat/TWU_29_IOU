<!DOCTYPE html>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html" charset="UTF-8">
<html lang="en">
<head>
    <title> IOU </title>
    <script type="text/javascript" language="JavaScript">
        window.onload = initReload;
        function initReload() {
            if (window.history.forward() == "/dashboard" )
                window.location.href = "/twu/dashboard";
        }
    </script>
    <link href="static/css/bootstrap.css" rel="stylesheet">
    <link href="static/css/default.css" rel="stylesheet">
<#--<link href="static/css/bootstrap.min.css" rel="stylesheet">-->
<#--<link href="static/css/main.css" rel="stylesheet">-->

</head>

<body>
<header class="topbar">
    <h3 class="fill" align="middle">
        <a>
            Welcome to IOU! IOU is an innovative expenses sharing system,
            originally designed for use in TWU.

        </a>
    </h3>
</header>
<div class="container">
    <div class="login-form">
        <h2>Login</h2>

        <form action="/IOU/checkLogin" method="post" id="loginForm">
            <fieldset>
                Please fill out the following form with your login credentials:
                <label for="email"></label>
                <input type="text" placeholder="Email" id="email" name="email"/>
                <label for="password"></label>
                <input type="password" placeholder="Password" id="password"
                       name="password"/>

                <div class="clearfix">
                    <input class="btn btn-primary" type="submit" value="Login">
                </div>
                New to IOU?
                <div class="clearfix">
                    <input class="btn btn-primary" type="button" name="goToCreateAccountButton"
                           id="goToCreateAccountButton"
                           value="Create Account"
                           onclick="javascript:window.location.href='/IOU/createAccount'"/>
                </div>
            </fieldset>
        </form>
    </div>
</div>
<!-- /container -->
</body>

</html>
