describe("People Who Owe Me Table", function () {
    var input = $('<input type"text" id="newEmail">');
    var peopleWhoMeTable = $(

        '<div id="peopleWhoOweMe">' +
            '<table id="peopleWhoOweMeList" border="2">' +
            '<tr style="background-color: #87cefa;">' +
            '<th id="header">Friends</th><th>Amount(Rs)</th>' +
            '</tr>' +
            '<tr id="baseRow">' +
            ' <td id="friends"> &nbsp; </td><td id="amount"> &nbsp; </td>' +
            '</tr>' +
            '</table>' +
            '</div>');

    var headerForTheFriendsColumn;
    var firstPeopleWhoOweMe;
    var row2;

    beforeEach(function () {
        $(document.body).append(input);
        $(document.body).append(peopleWhoMeTable);
    });

    it("should be updated below Header when table empty", function () {
        var oweMe = ["renu","Mengqiu"];

        var table = document.getElementById('peopleWhoOweMeList');
        headerForTheFriendsColumn = table.rows[0][0].innerText;
        expect(headerForTheFriendsColumn).toMatch("friends");

       populateData(oweMe);

        firstPeopleWhoOweMe = table.rows[1][0].innerText;
        expect(headerForTheFriendsColumn).toMatch("friends");
        expect(firstPeopleWhoOweMe).toMatch("renu");
    });

});
