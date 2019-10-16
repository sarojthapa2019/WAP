String.prototype.filter = function (bannedword) {
    let str = this;
    let n = str.search(bannedword);
    while(str.search(bannedword)>-1){
        n = str.search(bannedword);
        str = str.substring(0,n) + str.substring(n+ bannedword.length, str.length);

    }
    return str;

}
console.log("This house is not nice!".filter('not'));


Array.prototype.bubbleSort = function()
{
    var is_sorted = false;
    while (!is_sorted)
    {
        is_sorted = true;
        for (var n = 0; n < this.length - 1; n++)
        {
            if (this[n] > this[n+1]){
                var x = this[n+1];
                this[n+1] = this[n];
                this[n] = x;
                is_sorted = false;
            }
        }
    }
    return this;
};
console.log([6,4,0, 3,-2,1].bubbleSort());



//function constructor
var PersonF = function(name){
    this.name = name;
}

var teacher = new PersonF("Professor Xing");
PersonF.prototype.teach = function(subject){
    console.log( this.name + " is teaching "+ subject);
}
teacher.teach("WAP");

//prototype object

const PersonP = {
    name: "",
    teach: function(subject){
        console.log(this.name + " is teaching "+ subject);
    }
}
var teacherP = Object.create(PersonP);
teacherP.name = "Professor Kalu";
teacherP.teach("Software Engineering");



//Object Prototype
const Person = {
    name:'Enrique',
    age:40,
    greeting: function(){
        console.log("Greetings, my name is "+ this.name + " and I'm "+ this.age+
            " years old.");
    },
    salute: function(){
        console.log('Good morning!, and in case I dont see you, good afternoon, good evening and good night!');
    }
}

const Student = Object.create(Person);
Student.major = "Major";
Student.greeting = function(){
    console.log('Hey, my name is '+ this.name +" and I'm studying "+ this.major);
}
let Chris = Object.create(Student);
Chris.name = "Chris";
Chris.age = 20;
Chris.major = "ComPro";
Chris.greeting();
Chris.salute();

const Professor = Object.create(Person);
Professor.department = 'Department';
Professor.greeting = function(){
    console.log('Good day, my name is '+ this.name +' and I am in the ' + this.department+' department.');
}

let ema = Object.create(Professor);
ema.name = "Ema";
ema.department = "Management";
ema.greeting();
ema.salute();


//Function Constructor

const PersonFC = function(name, age){
    this.name = name;
    this.age = age;

}
PersonFC.prototype.greeting = function(){
    console.log("Greetings, my name is "+ this.name + " and I'm "+ this.age+
        " years old.");
}
PersonFC.prototype.salute = function(){
    console.log('Good morning!, and in case I dont see you, good afternoon, good evening and good night!');
}

const StudentFC = function(name, age){
    PersonFC.call(this, name, age);
}


StudentFC.prototype = Object.create(PersonFC.prototype);
StudentFC.prototype.major = "Major";
StudentFC.prototype.greeting = function(){
    console.log('Hey, my name is '+ this.name +" and I'm studying "+ this.major);
}
const cheryl = new StudentFC("Cheryl", 25);
cheryl.major = "Science";
cheryl.greeting();
cheryl.salute();

const ProfessorFC = function(name, age){
    PersonFC.call(this, name, age);
}
ProfessorFC.prototype = Object.create(PersonFC.prototype);
ProfessorFC.prototype.department = "department";
ProfessorFC.prototype.greeting = function(){
    console.log("Good Day, my name is "+ this.name + " and I'm in the "+ this.department+" department.")
}

const ram = new ProfessorFC("Ram", 36);
ram.department = "MBA";
ram.greeting();
ram.salute();





