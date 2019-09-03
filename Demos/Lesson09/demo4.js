$(function() {
 $("body, div, p, em").click(hello); 
}); 

function hello(evt) {
 alert("You clicked on the " + $(this).html()); 
//  evt.stopPropagation();
    return false;
} 
