$(function(){
    $('#loading').hide();
    $(document).ajaxStart(function(){
        $('#loading').show();
    });
    $(document).ajaxStop(function(){
        $('#loading').hide();
    });
    $('#load').click(function(event){
       $.get("http://mumstudents.org/cs472/2016-03-AS-KL/Sections/8/bootloader/loader.php")
           .done(function(data){
               $('#boot').innerHTML = data;
        }).fail(function(data){
            console.log(data);
        });
    });
});