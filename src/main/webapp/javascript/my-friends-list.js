var emailsToAdd = new Array();  //TODO: used to store added emails to put in DB
var rowCounter = 1;

function addToList() {
    if (document.getElementById('newEmail').value == "") return;
    if (rowCounter > 1) {
        var newRow = document.getElementById('emailList').insertRow(1);
        newRow.insertCell();

    }
    document.getElementById("emailList").rows[1].cells[0].textContent = document.getElementById('newEmail').value;
    rowCounter += 1;
    document.getElementById('newEmail').value = "";


}

function save() {
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
}
