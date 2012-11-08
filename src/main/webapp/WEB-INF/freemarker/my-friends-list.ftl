<META HTTP-EQUIV="Content-Type" CONTENT="text/html" charset="UTF-8">
<html>
    <head>
        <script type="text/javascript" src="javascript/my-friends-list.js"></script>
        <script type="text/javascript" src="javascript/jquery.js"></script>
    </head>
    <body>
    <button name="logoutButton" onclick="location.href='http://localhost:9130/twu/j_spring_security_logout'"> Logout</button>
            <b>
                Enter The person's e-mail you want to add to your Friends List.<br> Enter 1 e-mail at the time.<br>
            </b>
            <label>E-mail: </label><input type="text" id="newEmail">
            <button id="addToListButton" onclick="addToList()">Add To Friends List</button>

            <div id="emailListDiv">
                <table id="emailList" border="2">
                    <tr id="header" style="background-color: #87cefa;">
                        <th>Friends Added</th>
                    </tr>
                    <tr id="baseRow" >
                        <td> &nbsp; </td>
                    </tr>
                </table>
               </div>
            <br>



            <button id="saveButton" onclick="save()">Save</button>
            <button onclick="location.href='dashboard'">Back to Dashboard</button>
    </body>
</html>