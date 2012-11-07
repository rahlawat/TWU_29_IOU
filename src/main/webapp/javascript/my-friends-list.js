function addToList() {
    var newEmail = document.getElementById('newEmail').value;
    var emailList = document.getElementById('emailList');
    var newRow = emailList.insertRow();
    newRow.innerHTML = newEmail;
}