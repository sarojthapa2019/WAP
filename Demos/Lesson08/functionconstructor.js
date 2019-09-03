// a constructor function
function Foo(x) {
    this.y = x;
}

/*
__proto__ property of new objects point to prototype object of the constructor function so we may use it to define shared/inherited properties or methods "x" and "calculate"
*/
Foo.prototype.x = 10;
Foo.prototype.calculate = function (z) {
    return this.x + this.y + z;
};

// now create our "b" and "c" objects using "pattern" Foo
var b = new  Foo(20);
var c = new  Foo(30);

