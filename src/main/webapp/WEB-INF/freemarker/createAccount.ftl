<!DOCTYPE html>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html" charset="UTF-8">
<html lang="en">
<title> IOU </title>
<head>
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
                <h2>Create Account</h2>

                <form name="account_form" action="createAccount" method="POST">
                    <fieldset>
                        <table>
                            Please enter some registration details below so that we can set you up with an IOU account. Once you've registered you'll be able to log in and get started.
                            <tr>
                                <td><label for="email" id="email_label" name="email_label"> E-mail Address *: </label>
                                </td>
                                <td><input type="text" id="email" name="email"/></td>
                            </tr>

                            <tr>
                                <td><label for="username" id="name_label" name="name_label"> Name *: </label></td>
                                <td><input type="text" id="username" name="username"/></td>
                            </tr>

                            <tr>
                                <td><label for="password" id="password_label" name="password_label"> Password
                                    *: </label></td>
                                <td><input type="password" id="password" name="password"/></td>
                            </tr>

                            <tr>
                                <td><label for="phoneNumber" id="phone_number_label" name="phone_number_label"> Phone
                                    Number: </label></td>
                                <td><input type="text" id="phoneNumber" name="phoneNumber"/></td>
                            </tr>

                            <tr>
                                <td><input class="btn btn-primary" type="submit" name="createAccountButton"
                                           id="createAccountButton" value="Create Account"/></td>
                                <td><input class="btn btn-primary" type="button" name="cancelButton" id="cancelButton"
                                           value="Cancel"
                                           onclick="javascript:window.location.href='http://localhost:9130/twu/login'"/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- /container -->
</body>

</html>