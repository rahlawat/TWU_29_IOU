describe("Email list table", function () {
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

    var hiddenField = $(
        '<input type="hidden" id="hiddenFriendList"/>'
    );

    var row0;
    var row1;
    var row2;

    beforeEach(function () {
        $(document.body).append(input);
        $(document.body).append(emailTable);
        $(document.body).append(hiddenField);

    });

    afterEach(function () {
        $('#emailListDiv').remove();
        $('#newEmail').remove();
        rowCounter = 1;
        emailsToAdd = "";
    });

    it("should be updated below Header when table empty", function () {
        document.getElementById('newEmail').value = "abc@gmail.com";

        var table = document.getElementById('emailList');
        row0 = table.rows[0].innerText;
        expect(row0).toMatch("Friendship Added");

        addToList();

        row1 = table.rows[1].innerText;
        expect(row0).toMatch("Friendship Added");
        expect(row1).toMatch("abc@gmail.com");
    });


    it("should be updated at the top", function () {
        document.getElementById('newEmail').value = "abc@gmail.com";

        addToList();

        document.getElementById('newEmail').value = "xyz@gmail.com";

        addToList();

        var table = document.getElementById('emailList');
        row0 = table.rows[0].innerText;
        row2 = table.rows[1].innerText;
        row1 = table.rows[2].innerText;

        expect(row0).toMatch("Friendship Added");
        expect(row2).toMatch("xyz@gmail.com");
        expect(row1).toMatch("abc@gmail.com");

    });

    it("should clear the table when click save", function () {
        document.getElementById('newEmail').value = "abc@gmail.com";

        addToList();

        document.getElementById('newEmail').value = "xyz@gmail.com";

        addToList();

        save();

        var table = document.getElementById('emailList');
        row0 = table.rows[0].innerText;
        row1 = table.rows[1].innerText;
        //row1 = table.rows[2];


        expect(row0).toMatch("Friends Added");
        expect(row1).toMatch(String.fromCharCode(160));  //(&nbsp;)

    });

    it("should clear input on save", function () {
        document.getElementById('newEmail').value = "abc@gmail.com";
        save();

        expect(document.getElementById('newEmail').value).toBe("");
    });

    it("should clear input on add to list", function () {
        document.getElementById('newEmail').value = "abc@gmail.com";
        addToList();

        expect(document.getElementById('newEmail').value).toBe("");
    });

    it("should reset the row counter on clearTable", function () {
        document.getElementById('newEmail').value = "abc@gmail.com";
        addToList();
        document.getElementById('newEmail').value = "xyz@gmail.com";
        addToList();

        expect(rowCounter).toEqual(3);

        clearTable();

        expect(rowCounter).toEqual(1);

    });

    it("should not add to table if input empty", function () {
        document.getElementById('newEmail').value = "";
        var tableBefore = document.getElementById('emailList');

        addToList();

        var tableAfter = document.getElementById('emailList');


        expect(tableAfter).toEqual(tableBefore);


    });

    it("should not increment rowCounter on add if input empty", function () {
        document.getElementById('newEmail').value = "";
        addToList();

        expect(rowCounter).toEqual(1);


    });

    it("should add the emails to the string", function () {
        document.getElementById('newEmail').value = "abc@gmail.com";
        addToList();
        console.log(emailsToAdd);
        document.getElementById('newEmail').value = "xyz@gmail.com";
        addToList();
        console.log(emailsToAdd);
        expect(emailsToAdd).toEqual("abc@gmail.com,xyz@gmail.com,");
    });

    it("should clear the string on save", function () {
        document.getElementById('newEmail').value = "abc@gmail.com";

        addToList();

        document.getElementById('newEmail').value = "xyz@gmail.com";

        addToList();

        save();
        expect(emailsToAdd).toEqual("");
    });

});