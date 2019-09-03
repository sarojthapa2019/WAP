$(function() {
 $("p").click(hello);
 $("div > p").click(anotherHandler); 
}); 

function hello(evt) {
    alert("You clicked on the " + this.nodeName);
    evt.stopImmediatePropagation(); 
} 

function anotherHandler() {
 alert("You clicked on the inner P tag");
} 
