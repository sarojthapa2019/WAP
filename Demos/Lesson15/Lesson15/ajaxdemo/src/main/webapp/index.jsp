<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html>
<head>
    <title>Ajax Demo</title>
    <script
            src="https://code.jquery.com/jquery-3.4.0.min.js"
            integrity="sha256-BJeo0qm959uMBGb65z40ejJYGSgR7REI4+CW1fNKwOg="
            crossorigin="anonymous"></script>
    <script src="<c:url value = "/js/main.js"/>"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value = "/css/main.css"/>">
</head>
<body>
<h2>Ajax Demo</h2>
<button id="xmlHttpBtn">XMLHttpRequest</button>
<div id="xmlHttpDiv"></div>

<button id="btn1">Ajax Always Loading</button>
<br/>

<img src="<c:url value = "/images/loading.gif"/>" id="loader"/>

<br/>
<br/>
<form>
    username: <input type="text" name="username" /><br />
    password: <input type="password" name="password" />
    <button id="signInBtn">Submit</button>
</form>

<div class="msg"></div>

</body>
</html>
