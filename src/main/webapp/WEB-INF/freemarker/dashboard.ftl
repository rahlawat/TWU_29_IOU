<!DOCTYPE html>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html" charset="UTF-8">
<html lang="en">
<head>
    <title> IOU </title>
    <link href="static/css/bootstrap.css" rel="stylesheet">
    <link href="static/css/default.css" rel="stylesheet">
    <link href="static/css/resizeHeader.css" media="screen and (max-width : 800px)" rel="stylesheet">

<#--<link href="static/css/bootstrap.min.css" rel="stylesheet">-->
<#--<link href="static/css/main.css" rel="stylesheet">-->
    <script type="text/javascript" src="javascript/who-owe-me.js"></script>
    <script type="text/javascript" src="javascript/jquery.js"></script>

</head>
<body >
<header class="topbar">
    <h4 class="fill" id="username" align="right">
        <a>
            Hi ${username}, welcome to IOU.
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
        <h2>Dashboard</h2>
        Here you can add bill and view your friends list.</br>
        <button class="btn btn-primary" name="addBill"
                onclick="location.href='/IOU/add-bill'">Add
            Bill
        </button>

        <button class="btn btn-primary" id="friendsListButton"
                onclick="location.href='/IOU/my-friends-list'">My Friends List
        </button>  <br/>
    </div>
    <div id="peopleWhoOweMeDiv">
        <div class="owe-me-title"> <h5 align="center"> Friends Who Owe Me </h5> </div>
        <table border="1" class="computers zebra-striped" id="peopleWhoOweMeList" border="2" align="center">
            <tr id="header" style="background-color: #87cefa;">
                <th>Friends</th>   <th>Amount(Rs)</th>
            </tr>
            <#if peopleWhoOweMe?? && peopleWhoOweMe?size != 0>
            <#list peopleWhoOweMe as oweMe>
            <tr id="baseRow">
                <td id="friends">
                   ${oweMe.getPersonName()}
                </td>
                <td id="amount">
                ${oweMe.getAmount()}
                </td>
            </tr>
            </#list>
            </#if>
        </table>
    </div>
</div>
</body>
</html>
