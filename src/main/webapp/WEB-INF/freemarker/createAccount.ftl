<html>
    <head>
        <title> IOU </title>
    </head>
    <body>

        <form name="account_form" action="checkFields" method="POST">

        <table>

            <tr>
            <td> <label for="email" id="email_label" name="email_label"> E-mail Address *: </label> </td>
            <td> <input type="text" id="email" name="email"/> </td>
            </tr>

            <tr>
                <td> <label for="username" id="name_label" name="name_label"> Name *: </label> </td>
                <td> <input type="text" id="username" name="username"/> </td>
            </tr>

            <tr>
                <td> <label for="password" id="password_label" name="password_label"> Password *: </label> </td>
                <td> <input type="password" id="password" name="password"/>  </td>
            </tr>

            <tr>
                <td> <label for="phoneNumber" id="phone_number_label" name="phone_number_label"> Phone Number: </label> </td>
                <td> <input type="text" id="phoneNumber" name="phoneNumber"/> </td>
            </tr>

            <tr>
                <td> <input type="submit" name="createAccountButton" id="createAccountButton" value="Create Account"/></td>
                <td> <input type="button" name="cancelButton" id="cancelButton" value="Cancel" onclick="javascript:window.location.href='http://localhost:9130/twu/login'"/> </td>
            </tr>
        </table>

        </form>

    </body>
</html>