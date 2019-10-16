// window.onload = load;
// $(document).ready(function(){
//
//     load();
// });

$(function(){
    load();
});
function load(){
    $('#head').click(function(){
            alert("Hello");
    });

   console.log( $('#head')[0] === document.getElementById('head'));

   var ele = document.getElementById('head');
   ele = $(ele);
   console.log(ele );
   console.log($('#head'));
}