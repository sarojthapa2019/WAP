<%--
  Created by IntelliJ IDEA.
  User: rXing
  Date: 4/17/2019
  Time: 8:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<b>With C:OUT Ignores Script:</b><br/>
Your Search Results for : <c:out value="${inputTest }"></c:out>  <br/>

<p>
    <b> WITHOUT  C:OUT -- [HACKED!! Executes javascript!!!]:</b><br/>
    Your Search Results for : ${inputTest }
</p>

</body>
</html>
