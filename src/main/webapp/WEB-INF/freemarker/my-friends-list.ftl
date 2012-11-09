<!DOCTYPE html>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html" charset="UTF-8">
<html lang="en">
<title> IOU </title>
<head>
    <link href="static/css/bootstrap.css" rel="stylesheet">
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

    <script type="text/javascript" src="javascript/my-friends-list.js"></script>
    <script type="text/javascript" src="javascript/jquery.js"></script>

</head>

<body>
<div class="container">
    <div class="content">
        <div class="row">
            <div class="login-form">
                <h2>My-Friends-List</h2>
                Enter the person's e-mail who you want to add to your friends list.Make sure enter one e-mail at one
                time.
                <label>E-mail: </label>

                <div>
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
                <br>

                <button class="btn btn-primary" id="saveButton" onclick="save()">Save</button>
                <button class="btn btn-primary" onclick="location.href='dashboard'">Back to Dashboard</button>

            </div>
        </div>
    </div>
</div>
<!-- /container -->
</body>

</html>