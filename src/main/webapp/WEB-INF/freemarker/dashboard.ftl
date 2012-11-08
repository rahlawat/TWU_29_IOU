<META HTTP-EQUIV="Content-Type" CONTENT="text/html" charset="UTF-8">
<html>
    <head>
        <title> IOU </title>

    </head>
    <body>
        <h6 id="username" align="right"> Hi ${user.getUsername()} !!
        <br/>
        <button name="logoutButton" onclick="location.href='http://localhost:9130/twu/j_spring_security_logout'"> Logout</button>
        <button name="addBill"><a name="addBillLink" href="http://localhost:9130/twu/add-bill">Add Bill</a></button>

        <button id="friendsListButton" onclick="location.href='http://localhost:9130/twu/my-friends-list'">My Friends List</button>
    </body>
</html>
