$(function() {
 $("#exampleform").submit(checkData); 
}); 

function checkData(event) {
 if ($("#firstname").val() == "" || $("#lastname").val().length != 2) {
 		alert("Error, invalid firstname/lastname."); // show error message
 		event.preventDefault();
 } 
}
