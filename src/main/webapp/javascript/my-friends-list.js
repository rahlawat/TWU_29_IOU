var emailsToAdd = "";  //TODO: used to store added emails to put in DB
var rowCounter = 1;

function addToList() {
    if (document.getElementById('newEmail').value == "") return;
    if (rowCounter > 1) {
        var newRow = document.getElementById('emailList').insertRow(1);
        newRow.insertCell();

    }
    var newEmail = document.getElementById('newEmail').value;

    emailsToAdd +=  newEmail + ",";
    document.getElementById("emailList").rows[1].cells[0].textContent = newEmail;
    rowCounter += 1;
    document.getElementById('newEmail').value = "";


}

function save() {
    if (rowCounter == 1) return;

    sendEmailsToController();
    document.getElementById('newEmail').value = "";
    clearTable();

}


function clearTable() {
    document.getElementById('emailListDiv').innerHTML =
        '<table id="emailList" border="2">' +
            '<tr style="background-color: #87cefa;">' +
            '<th id="header">Friends Added</th>' +
            '</tr>' +
            '<tr>' +
            '<td id="baseRow"> &nbsp; </td>' +
            '</tr>' +
            '</table>';

    rowCounter = 1;
    emailsToAdd = "";
}

function sendEmailsToController() {
    var emailString = emailsToAdd.substring(0, emailsToAdd.length - 1);
    $.ajax({
        type:"POST",
        url:"storeConnections",
        data:"emails=" + emailString,
        success:function () {
            console.log("success");
        },
        failure:function () {
            console.log("failure");
        }
    });

}
