var running = false;
function pageLoad(){
    let button = document.getElementById("button");

    button.onclick = timer;
    let checkBox = document.getElementById("checkBox");
    let text = document.getElementById("textArea")
     document.getElementById("checkBox").onchange = function () {

        if(checkBox.checked){
            text.style.fontWeight ="bold";
            text.style.color = "red";
            text.style.textDecoration ="underline";
            document.body.style.backgroundImage = 'url("http://www.cs.washington.edu/education/courses/190m/CurrentQtr/labs/6/hundred-dollar-bill.jpg")';
        }
        else{
            text.style.fontWeight ="normal";
            text.style.color = "black";
            text.style.textDecoration = "none";
            document.body.style.backgroundImage = 'none';
        }
     }
}

function timer() {
      setInterval(changeStyle, 500);
}

function changeStyle(){

    const textArea = document.getElementById("textArea");
    let fontSize = parseInt(document.getElementById("textArea").style.fontSize);
    console.log(fontSize);
    if(Number.isNaN(fontSize)){
        fontSize = 10;
    }
    fontSize += 2;
    textArea.style.fontSize = fontSize + "pt";
}

window.onload = pageLoad;

function f() {
    
}




