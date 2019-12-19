$(function(){
    $('input[name="animal"]').click(function (event) {
        let animal = "";
        if($('#puppies').checked){
            animal = "puppy;"
        }
        else{
            animal = "kitty";
        }
        $.get("http://mumstudents.org/cs472/2013-09/Sections/8/ajaxpets/ajaxpets.php", {
            "animal":animal}).done(function (data) {
                $("#pictures").innerHTML = data;
        }).fail(function(err){
            console.log(err);
        });
        } );
});