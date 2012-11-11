<!DOCTYPE html>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html" charset="UTF-8">
<html lang="en">
<head>
    <title> IOU </title>
    <link href="static/css/bootstrap.css" rel="stylesheet">
    <link href="static/css/default.css" rel="stylesheet">
    <script type="text/javascript" src="javascript/my-friends-list.js"></script>
    <script type="text/javascript" src="javascript/jquery.js"></script>

</head>

<body>
<header class="topbar">
    <h3 class="fill" align="middle">
        <a>
            Here is your friends list.
        </a>

    </h3>
</header>
<div class="container">
    <div class="login-form">
        <h2>My-Friends-List</h2>
        Enter the person's e-mail who you want to add to your friends list.Make sure enter one e-mail at one
        time.
        <label>E-mail: </label>

        <div id="addEmail">
            <input type="text" id="newEmail">

            <button class="btn btn-primary" id="addToListButton" onclick="addToList()">Add To Friends List
            </button>
        </div>


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