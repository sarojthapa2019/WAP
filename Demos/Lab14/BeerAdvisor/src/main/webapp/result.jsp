<%@ page import="java.util.*" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<body>
<h1 align="center">Beer Recommendations JSP</h1>
<p>
<%--<%
List styles = (List)request.getAttribute("styles");
Iterator it = styles.iterator();
while(it.hasNext()) {
out.print("<br>try: " + it.next());
}
%>--%>

<core:forEach var="beer" items="${styles}">

    <br>Try: <core:out value="${beer}"></core:out>
    </core:forEach>


</body>
</html>