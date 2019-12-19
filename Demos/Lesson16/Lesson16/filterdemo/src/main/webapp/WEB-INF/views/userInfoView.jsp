<%--
  Created by IntelliJ IDEA.
  User: rXing
  Date: 4/19/2019
  Time: 9:16 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Info</title>
</head>
<body>

<jsp:include page="_menu.jsp"></jsp:include>

<h3>Hello: ${loginedUser.userName}</h3>

User Name: <b>${loginedUser.userName}</b>
<br />
Gender: ${loginedUser.gender } <br />


</body>
</html>
