<!DOCTYPE html>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html" charset="UTF-8">
<html lang="en">
<head>
    <title> IOU </title>
    <link href="static/css/bootstrap.css" rel="stylesheet">
    <link href="static/css/default.css" rel="stylesheet">
    <link href="static/css/resizeHeader.css" media="screen and (max-device-width : 800px)" rel="stylesheet">
    <script type="text/javascript" src="javascript/my-friends-list.js"></script>
    <script type="text/javascript" src="javascript/jquery.js"></script>
    <script type="text/javascript">
        var user = "${user}";
    </script>

</head>

<body>
<header class="topbar">
    <h4 class="fill" align="right">
        <a>
            Here is your friends list.
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
        <h2>My-Friends-List</h2>
        Enter the person's e-mail who you want to add to your friends list.Make sure enter one e-mail at a
        time.
        <label>E-mail: </label>

        <div id="addEmail">
            <input id="newEmail" type="email"/>

            <button class="btn btn-primary" id="addToListButton" onclick="addToList()">Add To Friends List
            </button>
        </div>
        <div><p id="badEmailNotification" class="text-error"></p></div>


        <div id="emailListDiv">
            <table border="1" class="computers zebra-striped" id="emailList" border="2">
                <tr id="header" style="background-color: #87cefa;">
                    <th>Friends Added</th>
                </tr>
                <tr id="baseRow">
                    <td> &nbsp; </td>
                </tr>
            </table>
        </div>

        <button class="btn btn-primary" id="saveButton" onclick="save()">Save</button>
        <button class="btn btn-primary" onclick="location.href='dashboard'">Back to Dashboard</button>

    </div>
</div>
<!-- /container -->
</body>

</html>