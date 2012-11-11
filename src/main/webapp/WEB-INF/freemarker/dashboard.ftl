<!DOCTYPE html>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html" charset="UTF-8">
<html lang="en">
<head>
    <title> IOU </title>
    <link href="static/css/bootstrap.css" rel="stylesheet">
    <link href="static/css/default.css" rel="stylesheet">
<#--<link href="static/css/bootstrap.min.css" rel="stylesheet">-->
<#--<link href="static/css/main.css" rel="stylesheet">-->

</head>
<body>
<header class="topbar">
    <h4 class="fill" id="username" align="right">
        <a>
            Hi ${username}, welcome to iOWEYOU.
        </a>
        <a>
            <button class="btn btn-primary" name="logoutButton"
                    onclick="location.href='http://localhost:9130/twu/j_spring_security_logout'">Logout
            </button>
        </a>
    </h4>
</header>
<div class="container">
    <div class="login-form">
        <h2>Dashboard</h2>
        Here you can add bill and view your friends list.</br>
        <button class="btn btn-primary" name="addBill"
                onclick="location.href='http://localhost:9130/twu/add-bill'">Add
            Bill
        </button>

        <button class="btn btn-primary" id="friendsListButton"
                onclick="location.href='http://localhost:9130/twu/my-friends-list'">My Friends List
        </button>
    </div>
</div>
</body>
</html>
