<#-- @ftlvariable name="" type="java.util.List" -->
<META HTTP-EQUIV="Content-Type" CONTENT="text/html" charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=2, maximum-scale=2">

<html>
<head>
    <title> IOU </title>
    <link href="static/css/bootstrap.css" rel="stylesheet">
    <link href="static/css/default.css" rel="stylesheet">
    <link href="static/css/resizeHeader.css" media="screen and (max-width : 800px)" rel="stylesheet">

</head>
<body>
<header class="topbar">
    <h4 class="fill" align="right">
        <a>
            Here you can add a bill.
        </a>
        <a>
            <button class="btn btn-primary" name="logoutButton"
                    onclick="location.href='/IOU/j_spring_security_logout'">Logout
            </button>
        </a>
    </h4>
</header>

<div class="container">
    <div class="login-form">
        <form action="add-bill" method=post>
            <fieldset>
                <h3>Bill</h3>
            <#if descriptionMessage?? && amountMessage??>
                <div>${descriptionMessage}</div>
                <div>${amountMessage}</div>
            </#if>
            <div class="notification" id="notification">
            <#if notificationMessage??>
                ${notificationMessage}
            </#if>
            </div>
                <table>
                    <tr>
                        <td><label>Description *: </label></td>
                        <td><input type="text" name="descriptionItem" placeholder="What did you buy?"
                                   pattern="^[a-zA-Z][a-zA-Z ]+" required></td>
                    </tr>
                    <tr>
                        <td><label>Amount *: </label></td>
                        <td><input type="text" name="amountItem" placeholder="Enter a decimal (2 places)."
                                   pattern="^\d*(\.\d{2}$)?" required/></td>
                        <td><label> Rs</label></td>
                    </tr>
                </table>
            </fieldset>

            Select friends who owe me.</br>

        <#list userConnections as aConnection>
            <div>
                <input id=${aConnection} type="checkbox" /> ${aConnection}
            </div>
        </#list>
        </ul>

        <input type="submit" value="Save" class="btn btn-primary" id="saveBillButton"/> <br/> <br/>
        <button class="btn btn-primary" id="backToDashboardButton" onclick="location.href='dashboard'">Back To Dashboard
        </button>
        </form>

    </div>
</div>
</body>
</html>
