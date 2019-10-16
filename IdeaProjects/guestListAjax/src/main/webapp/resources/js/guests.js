$(function() {
    $("#send").click(updateGuests);
});

function updateGuests() {
    var first = $("#first").val();
    var last = $("#last").val();
    
    $.post("guest.ajax", {
        	"first": first,
                "last": last
    }).done(function(data){
        $('#guestList').empty();
        console.log(data);
        let tableView = "<table><tr><th>First Name</th><th>Last Name</th></tr>";
        $.each(data, function(index, value){
            tableView += '<tr><td>'+value.first+'</td><td>'+value.last+'</td></tr>' ;
        });
        tableView += "</table>";
        $("#guestList").append(tableView);
    }).fail(function(err){
        console.log(err);
    });
    function displayGuests(data) {

    }
}

