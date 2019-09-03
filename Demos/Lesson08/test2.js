// "use strict";
function a() {
    console.log(this);
}

const b = {
    log: function() {
        console.log(this);
    }
}

console.log(this); // this generally is window object
a(); // a() is called by global window object
b.log(); // log() is called by a object

let mylog = b.log;
mylog(); //mylog() is called by global window object
