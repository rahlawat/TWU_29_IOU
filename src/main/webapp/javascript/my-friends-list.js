var emailsToAdd = new Array();  //TODO: used to store added emails to put in DB
var rowCounter = 1;

function addToList() {
    if(rowCounter == 1) {
        document.getElementById("baseRow").textContent = document.getElementById('newEmail').value;
        rowCounter += 1;
    }
    else {
        var newRow = document.getElementById('emailList').insertRow(1);
        var newCell = newRow.insertCell();
        newCell.textContent = document.getElementById('newEmail').value;
        rowCounter += 1;


    }

}

function save() {
    clearTable();
    //$('#emailList').rows[1].textContent = "&nbsp;";
    document.getElementById('newEmail').value == "";
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
//


}
