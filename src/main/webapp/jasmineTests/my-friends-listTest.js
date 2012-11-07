describe("Email list table", function() {

    beforeEach(function () {
        var input = $('<input type"text" id="newEmail">');
        var emailTable = $(

            '<div id="emailListDiv">' +
                '<table id="emailList" border="2">' +
                '<tr style="background-color: #87cefa;">' +
                    '<th id="header">Friends Added</th>' +
                '</tr>' +
                '<tr>' +
                    '<td id="baseRow"> &nbsp; </td>' +
                '</tr>' +
            '</table>' +
            '</div>');

        $(document.body).append(input);
        $(document.body).append(emailTable);


    });

    afterEach(function() {
        $('#emailListDiv').remove();
        $('#newEmail').remove();
    });


    var row0;
    var row1;
    var row2;

    it("should be updated below Header when table empty", function () {
        document.getElementById('newEmail').value = "abc@gmail.com";

        var table = document.getElementById('emailList');
        row0 = table.rows[0].innerText;
        expect(row0).toMatch("Friends Added");

        addToList();

        row1 = table.rows[1].innerText;
        expect(row0).toMatch("Friends Added");
        expect(row1).toMatch("abc@gmail.com");
    });



    it("should be updated at the top", function() {
        document.getElementById('newEmail').value = "abc@gmail.com";

        addToList();

        document.getElementById('newEmail').value = "xyz@gmail.com";

        addToList();

        var table = document.getElementById('emailList');
        row0 = table.rows[0].innerText;
        row2 = table.rows[1].innerText;
        row1 = table.rows[2].innerText;

        expect(row0).toMatch("Friends Added");
        expect(row2).toMatch("xyz@gmail.com");
        expect(row1).toMatch("abc@gmail.com");

    });

    it("should clear the table when click save", function(){
        document.getElementById('newEmail').value = "abc@gmail.com";

        addToList();

        document.getElementById('newEmail').value = "xyz@gmail.com";

        addToList();

        save();

        var table = document.getElementById('emailList');
        row0 = table.rows[0].innerText;
        row2 = table.rows[1].innerText;
        //row1 = table.rows[2];

        expect(row0).toMatch("Friends Added");
        expect(row2).toMatch(String.fromCharCode(160));  //(&nbsp;)
        //expect(row1).toMatch(null);

    })
});