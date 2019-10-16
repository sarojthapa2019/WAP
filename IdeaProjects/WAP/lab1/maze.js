$(function(){
    var start =  $("#start");
    var end = $("#end");
    var gameStart = false;
   

    start.click(function f() {
        $('.boundary').css("background-color","#eeeeee");
        $("#status").text('Move mouse to End to win the game');
        gameStart = true;
        $('.boundary').mousemove(function () {
           loss();
        });
        $('#maze').mouseleave(function () {
            loss();
        })
    });

    function loss(){
        if(gameStart) {
            $('.boundary').css("background-color", "red");
            $('#status').text("You lost!!");
            gameStart = false;
        }
    }

    end.mouseenter(function () {
        if(gameStart) {
            $('#status').text("You Won!!");
            gameStart = false;
        }
    });
});