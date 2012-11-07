<html>
    <head>
        <script type="text/javascript" src="javascript/my-friends-list.js"></script>

    </head>
    <body>
            <b>
                Enter The person's e-mail you want to add to your Friends List.<br> Enter 1 e-mail at the time.<br>
            </b>
            <label>E-mail: </label><input type="text" id="newEmail">
            <button id="addToListButton" onclick="addToList()">Add To Friends List</button>

            <table id="emailList" border="2">
                <tr style="background-color: #87cefa;">
                    <th>Friends Added</th>
                </tr>
                <tr>
                    <td> &nbsp; </td>
                </tr>
            </table>
            <br>



            <button id="saveButton" onclick="">Save</button>
            <button onclick="location.href='dashboard'">Back to Dashboard</button>
    </body>
</html>