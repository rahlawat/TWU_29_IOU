<META HTTP-EQUIV="Content-Type" CONTENT="text/html" charset="UTF-8">
<html>
    <head>
        <title> IOU </title>
    </head>
    <body>
        <button name="logoutButton" onclick="location.href='http://localhost:9130/twu/j_spring_security_logout'"> Logout</button>
        <form action="add-bill" method=post>
            <h3>Bill</h3>
            <table>
                <tr>
                    <td> <#if notification??>
                        <h5>${notification} </h5>
                    </#if> </td>
                </tr>
                <tr>
                    <td><label>Description*: </label></td>
                    <td><input type="text" name="descriptionItem"/td>
                </tr>
                <tr>
                    <td><label>Amount*: </label></td>
                    <td><input type="text" name="amountItem"></td>
                    <td><label>  Rs</label></td>
                </tr>
            </table>
        </form>
        <button id="backToDashboardButton" onclick="location.href='dashboard'">back To Dashboard</button>
        <button id="saveBillButton" onclick="">Save</button>
    </body>
</html>
