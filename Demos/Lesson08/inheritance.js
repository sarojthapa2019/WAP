const Mammal = function (name) {
    this.name = name;
}
Mammal.prototype.saySomething = function () {
    console.log(' my name is ' + this.name);
}
Mammal.prototype.doSomething = function() {
    console.log(this.name + ' is walking about.');
}

//create subclass—constructor function whose prototype //object has its __proto__ point to prototype object of the //Mammal constructor function
const Dog = function (name) {
    Mammal.call(this, name);
}
Dog.prototype = Object.create(Mammal.prototype);
Dog.prototype.saySomething = function () {
    console.log(‘Woof, my name is ' + this.name);
}
//create an object
const snoopy = new Dog(Snoopy ');
snoopy.saySomething();
snoopy.doSomething();


