<html>
    <head>
        <script type="text/javascript" src="javascript/my-friends-list.js"></script>

    </head>
    <body>
        <form>
            <b id="title">
                Enter The person's e-mail you want to add to your Friends List.<br> Enter 1 e-mail at the time.<br>
            </b>
            <label>E-mail: </label><input type="text" name="friendEmail">
            <input type="submit" value="Add To Friends List" name="addAFriend"> <br>

            <table id="emailList" border="2">
                <tr style="background-color: #87cefa;">
                    <th>Friends Added</th>
                </tr>
                <tr>
                    <td> &nbsp; </td>
                </tr>
            </table>
            <br>



            <input type="submit" value="Save" name="saveFriendToDB">
        </form>
        <button onclick="location.href='dashboard'">Back to Dashboard</button>
    </body>
</html>