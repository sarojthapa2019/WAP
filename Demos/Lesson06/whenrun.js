var x = 3;
function f(n) { return n + 1; }
function g(n) { return n - 1; }
x = f(x);
alert(x);

function btnHandler() {
    alert("Button click!");
}
var btn = document.getElementById("btn");
btn.onclick = btnHandler;

// document.getElementById("output").value = "Hello";