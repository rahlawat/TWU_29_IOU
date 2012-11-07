<html>
    <head>
        <title> IOU </title>
    </head>
    <body>
        <form action="add-bill" method=post>
            <h3>Bill</h3>
            <table>
                <tr>
                    <td><label>Description*: </label></td>
                    <td><input type="text" name="descriptionItem"/td>
                </tr>
                <tr>
                    <td><label>Amount*: </label></td>
                    <td><input type="number" name="amountItem"></td>
                    <td><label>  Rs</label></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Save" name="savebill"></td>
                    <td><button name="backToDashboard"><a href="http://localhost:9130/twu/dashboard">Go To Dashboard</a></button></td>
                </tr>
            </table>
        </form>
    </body>
</html>
