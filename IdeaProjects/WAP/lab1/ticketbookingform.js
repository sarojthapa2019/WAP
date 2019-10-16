// $(function(){
//
//     $('#ticketbook').on('submit', checkData);
//
// });
//
// function checkData(event) {
//     $('#error').css("color","red");
//     event.preventDefault();
//     const letters = /^[A-Za-z]+$/;
//     const number =/^[0-9]+$/;
//     submitFlag = true;
//
//     if($('#name').val()=='' || $('#name').val().length < 1 ){
//         event.preventDefault();
//     }
//     if( !$('#name').val().match(new RegExp(letters))){
//         $('#error').append('<span id="text">Name must be letters only</span>');
//     }
//
//     if($('#zip').val().length != 5){
//         event.preventDefault();
//     }
//     if($('#seat').val()<0 || $('#seat').val()>200 ){
//         $('#error').append("<br/>"+"Seat cannot be less than 0 or more than 200!!");
//         event.preventDefault();
//     }
//     if( !$('#seat').val().match(new RegExp(number))){
//         $('#error').append("<br/>"+ "Seat must be number only!!");
//     }
//     if($('[name="taxi"]:checked').length<1){
//         $('#error').append("<br/>"+"You must select taxi type!!");
//         event.preventDefault();
//
//     }
//     if($('[name="extras"]:checked').length<1){
//         $('#error').append("<br/>"+"You must check one extra!!");
//         event.preventDefault();
//
//     }
// function clearErrors(){
//         // setInterval($('#errors').empty,5000);
//     // if($('#error').text().length>0){
//     //    $('#error').text = '';
//     // }
//     if($('#text')){
//         $('#text').remove();
//     }
// }
// }

$(function(){
    $('#ticketbook').submit(function(event){
        event.preventDefault();
        $('#error').css("color", "red");
        submitFlag = true;
        const lettet = /^[a-zA-Z]+$/;
        $('#error').empty();

        if($('#name').val()==='' || $('#name').val().length <1){
            $('#error').append('Name cannot be empty!! <br/>');
            submitFlag = false;
        }
        if(!$('#name').val().match(new RegExp(lettet))){
            $('#error').append('Name must be letter only <br/>');
            submitFlag = false;
        }
        if($('#street').val()===''){
            $('#error').append('Street cannot be empty <br/>');
            submitFlag = false;
        }
        if($('#select').val()===''){
            $('#error').append('Please slelect one state <br/>');
            submitFlag = false;
        }
        if($('#zip').val==''){
            $('#error').append('Zip Code cannot be null');
            submitFlag = false;
        }
        if($('input[name="seat"]').val()<=0 || $('input[name="seat"]').val()>200){
            $('#error').append('Seat cannot be more than 200. <br/> ');
            submitFlag = false;
        }
        if($('input[name="taxi"]:checked').val()===undefined){
            $('#error').append('You must select taxi type. <br/>');
            submitFlag = false;
        }
        if($('input[name="extras"]:checked').val()===undefined){
            $('#error').append('You must select one extra. <br/>');
            submitFlag = false;
        }
        if(submitFlag){
            this.submit();
        }

    });
});


