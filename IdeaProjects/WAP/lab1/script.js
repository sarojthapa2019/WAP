/* runs test to see if expected argument is === to value returned by function2test argument */
function myFunctionTest(expected, function2test) {
    let result = function2test();

    if(Array.isArray(expected)){
        expected = expected.toString();
    }
    if(Array.isArray(result)){
        result = result.toString();
    }
    if (expected === result) {
        return "TEST SUCCEEDED";
    } else {
        return "TEST FAILED.  Expected " + expected + " found " + function2test();
    }
}

function myarr(){
    return [1,1];
}
console.log("Expected output of myarr() is 40  " + myFunctionTest([1,1], function () {
    return myarr();
}));


//finding max between two numbers
 function max(num1, num2){
    return num1>num2?num1:num2;
 }
console.log("Expected output of max(10,5) is 10  " + myFunctionTest(10, function () {
    return max(10, 5);
}));


//finding max among three numbers
 var maxOfThree = function (num1, num2, num3) {
     var x = max(num1, num2);
     return x>num3?x:num3;
 }
 console.log("Expected output of maxOfThree(2,6,18) is 18" + myFunctionTest(18,function () {
     return maxOfThree(2,6,18);
 }));

//checks if a given character is vowel
 var isVowel = function (c) {
     if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
         return true;
     }

     // var vowelArr = ['a','e','i','o','u','A','E','I','O','U'];
     // return c.match(vowelArr);
 }
    console.log("Expected output of isVowel('e') is true" + myFunctionTest(true,function () {
    return isVowel('e');
}));

 //sum of elements in a given array
 var sum = function (arr) {
    var sum = 0;
     for(var i=0; i<arr.length;i++){
         sum += arr[i];
     }
     return sum;
 }

console.log("Expected output of sum([2,5,11]) is 18" + myFunctionTest(18,function () {
    return sum([2,5,11]);
}));


 //product of elements in a given array
 function multiply(arr) {
     var product = 1;
     for (var i = 0; i < arr.length; i++) {
         product *= arr[i];
     }
     return product;

 }
console.log("Expected output of multiply([2,5,10]) is 100 " + myFunctionTest(100,function () {
    return multiply([2,5,10]);
}));


     //computes reversal of a string
function reverse(string) {
    var rev='';
    for(var i=string.length; i>=0; i--){
        rev += string.charAt(i);
    }
    return rev;
}
console.log("Expected output of reverse(['hi there']) is ereht ih " + myFunctionTest('ereht ih',function () {
    return reverse('hi there');
}));

//finding lomgest word in a given array
function findLongestWord(arrayOfWords){
    var count = 0;
    var max = 0;
    var word;
    for(var i=0; i<arrayOfWords.length; i++){
        count = arrayOfWords[i].length;
        if(max<count){
            max = count;
            word = arrayOfWords[i];
        }
    }
    return word;
}
console.log("Expected output of findLongestWord(['hi','there','word','goodbye' ]) is goodbye " + myFunctionTest('goodbye',function () {
    return  findLongestWord(['hi','there','word','goodbye' ]);
}));


function filterLongWords(arrayOfWords, int){
    var newArr = [];
    for(var i=0; i<arrayOfWords.length; i++){
        if(arrayOfWords[i].length>int){
            newArr.push(arrayOfWords[i]);
        }
    }
    return newArr;
}
console.log("Expected output of filterLongWords(['hi','there','word','goodbye', ]) is ['there','word','goodbye'] " + myFunctionTest(['there','word','goodbye'],function () {
    return  filterLongWords(['hi','there','word','goodbye'],3);
}));
//map, filter and reduce

     const a = [1,3,5,3,3];
    //multiplying every element by 10
     const multiplyByTen = a.map(function (val,index,array) {
         return val * 10;
     });

console.log("Expected output of multiplyByTen is [10,30,50,30,30] " + myFunctionTest([10,30,50,30,30],function () {
    return multiplyByTen;
}));

     // return array with all elements equal to 3
     const arrayElementThree = a.filter(function (val, index, array) {
         return val===3;
     });

console.log("Expected output of arrayElementThree is [3,3,3] " + myFunctionTest([3,3,3],function () {
    return arrayElementThree;
}));

    //return the product of all elements
     const totalProduct = a.reduce(function (total,current,currentIndex, array) {
         return total * current;
     });
console.log("Expected output of totalProduct is 135 " + myFunctionTest( 135,function () {
    return totalProduct;
}));
