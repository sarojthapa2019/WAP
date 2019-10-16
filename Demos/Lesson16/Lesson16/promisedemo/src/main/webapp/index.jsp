<html>
<head>
    <script>

       /* var giveMePizza = function (flag) {
            return new Promise(function (resolve, reject) {
                if (flag) {
                    resolve("This is true"); // then() will be called
                } else {
                    reject("This is false"); // catch() will be called
                }
            })
        }
        giveMePizza(true) //Promise
            .then(data => console.log(data))
            .catch(err => alert(err));
        console.log('I will run immediately after calling giveMePizza() and before any  result arrives');*/


       const getsPromise = fetch('http://jsonplaceholder.typicode.com/users'); // return Promise
        console.log(getsPromise);

        getsPromise
            .then(data => data.json())
            .then(data => console.log(data))
            .catch(err => console.error(err));

    </script>
</head>
<body>
<h2>Hello World!</h2>
</body>
</html>
