<!DOCTYPE html>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html" charset="UTF-8">
<html lang="en">
<title> IOU </title>
<head>
    <script type="text/javascript" language="JavaScript">
        window.onload=initReload;
        function initReload() {
            if( window.history.forward() == "http://localhost:9130/twu/dashboard" )
                window.location.href = "http://localhost:9130/twu/dashboard";
        }
    </script>
    <link href= "static/css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
            /* Override some defaults */
        html, body {
            background-color: #fdf5e6;
        }

        body {
            padding-top: 40px;
        }

        .container {
            width: 500px;
        }

            /* The white background content wrapper */
        .container > .content {
            background-color: #fff;
            padding: 20px;
            margin: 0 -20px;
            -webkit-border-radius: 10px 10px 10px 10px;
            -moz-border-radius: 10px 10px 10px 10px;
            border-radius: 10px 10px 10px 10px;
            -webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .15);
            -moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .15);
            box-shadow: 0 1px 2px rgba(0, 0, 0, .15);
        }

        .login-form {
            margin-left: 65px;
        }

        legend {
            margin-right: -50px;
            font-weight: bold;
            color: #404040;
        }

    </style>
</head>

<body>
<div class="container">
    <div class="content">
        <div class="row">
            <div class="login-form">
                <h2>Login</h2>

                <form action="checkLogin" method="post" id="loginForm">
                    <fieldset>
                        Please fill out the following form with your login credentials:
                        <label for="email"></label> <input type="text" placeholder="Email" id="email" name="email"/> <br/>
                        <label for="password"></label> <input type="password" placeholder="Password"id="password"
                                                                      name="password"/><br/>

                        <div class="clearfix">
                            <input class="btn btn-primary" type="submit" value="Login"> <br/>
                        </div>
                        Not have an account yet?
                        <div class="clearfix">
                            <input class="btn btn-primary" type="button" name="goToCreateAccountButton"
                                   id="goToCreateAccountButton"
                                   value="Create Account"
                                   onclick="javascript:window.location.href='http://localhost:9130/twu/createAccount'"/>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- /container -->
</body>

</html>
