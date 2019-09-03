$(function(){
 $("#target").mouseover(showCoords); 
}); 

function showCoords(event) {
	// alert($(event.target).attr("id", "mytarget"));
 $("#target").html(
 	"page : (" + event.pageX + ", " + event.pageY + ")\n" +
 	"screen : (" + event.screenX + ", " + event.screenY + ")\n" +
 	"client : (" + event.clientX + ", " + event.clientY + ")"
 ); 
} 