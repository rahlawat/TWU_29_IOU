<META HTTP-EQUIV="Content-Type" CONTENT="text/html" charset="UTF-8">
<html>
<head>
    <title> IOU </title>
    <link href="static/css/bootstrap.css" rel="stylesheet">
    <link href="static/css/default.css" rel="stylesheet">
</head>
<body>
<header class="topbar">
    <h3 class="fill" align="right">
        <a>
            Here you can add bill, and save the details.

        </a>
        <button class="btn btn-primary" name="logoutButton"
                onclick="location.href='/IOU/j_spring_security_logout'"> Logout
        </button>
    </h3>
</header>
<div class="container">
    <div class="login-form">
        <form action="add-bill" method=post>
            <fieldset>
                <h3>Bill</h3>
                <table>
                    <tr>
                        <td> <#if notification??>
                            <h5>${notification} </h5>
                        </#if> </td>
                    </tr>
                    <tr>
                        <td><label>Description *: </label></td>
                        <td><input type="text" name="descriptionItem" placeholder="What did you buy?" pattern="[a-zA-Z]+" required></td>
                    </tr>
                    <tr>
                        <td><label>Amount *: </label></td>
                        <td><input type="text" name="amountItem" placeholder="Enter a decimal (2 places)." pattern="^\d*(\.\d{2}$)?" required/></td>
                        <td><label> Rs</label></td>
                    </tr>
                </table>
            </fieldset>
            Select friends who owe me.</br>
            <div class="checkbox">
                <input type="checkbox" id="" value="Car">Test1</br>
                <input type="checkbox" id="" value="">Test2

            </div>

        <#--<#list allConnections as aConnection>-->
            <#--<li class="allConnections">-->
                <#--<a href="/IOU/add-bill" class="add-bill">-->
                    <#--<div class="connections-checkboxes">-->
                        <#--<h3 class="aConnection-checkbox">${aConnection}</h3>-->
                    <#--</div>-->
                <#--</a>-->
            <#--</li>-->
        <#--</#list>-->



        <input type="submit" value="Save" class="btn btn-primary" id="saveBillButton"/>
        <button class="btn btn-primary" id="backToDashboardButton" onclick="location.href='dashboard'">Back To Dashboard
        </button>
        </form>
    </div>
</div>
</body>
</html>
