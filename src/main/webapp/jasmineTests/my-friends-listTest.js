describe("Email list table", function() {
    beforeEach(function () {
        var input = $('<input type"text" id="newEmail">');
        var emailTable = $(

            '<table id="emailList" border="2">' +
                '<tr style="background-color: #87cefa;">' +
                    '<th id="header">Friends Added</th>' +
                '</tr>' +
                '<tr>' +
                    '<td id="baseRow"> &nbsp; </td>' +
                '</tr>' +
            '</table>"');

        $(document.body).append(input);
        $(document.body).append(emailTable);


    });


    var row0;
    var row1;

    it("should be updated below Header when table empty", function () {
        document.getElementById('newEmail').value = "abc@gmail.com";

        var table = document.getElementById('emailList');
        row0 = table.rows[0].innerText;
        expect(row0).toMatch("Friends Added");

        addToList();

        var table = document.getElementById('emailList');

        row1 = table.rows[1].innerText;
        expect(row0).toMatch("Friends Added");
        expect(row1).toMatch("abc@gmail.com");
    });


});