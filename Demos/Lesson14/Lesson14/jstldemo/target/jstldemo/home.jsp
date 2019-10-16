<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Home Page</title>

<style>
table, th, td {
	border: 1px solid black;
}
</style>
</head>
<body>
	<%-- Using JSTL forEach and out to loop a list and display items in table --%>
	<table>
		<tbody>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Role</th>
			</tr>
			<c:forEach items="${empList}" var="dddd">
				<tr>
					<td><c:out value="${dddd.id}"></c:out></td>
					<td><c:out value="${dddd.name}"></c:out></td>
					<td><c:out value="${dddd.role}"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<br>
	<%-- simple c:if and c:out example with HTML escaping --%>
	<c:if test="${requestScope.htmlTagData ne null }">
		<c:out value="${requestScope.htmlTagData}" escapeXml="true"></c:out>
	</c:if>
	<br>
	<br>
	<%-- c:set example to set variable value --%>
	<c:set var="id" value="5" scope="request"></c:set>
	<c:out value="${requestScope.id }"></c:out>
	<br>
	<br>

	<%
		try{
			int x = 5 / 0;
		}catch(Exception exception){

		}

	%>
	<%-- c:catch example --%>
	<c:catch var="exception">
		<%
			int x = 5 / 0;
		%>
	</c:catch>

	<c:if test="${exception ne null}">
		<p>
			Exception is : ${exception} <br> Exception Message:
			${exception.message}
		</p>
	</c:if>
	<br>
	<br>
	<%-- c:url example --%>
	<a href="<c:url value="${requestScope.url }"></c:url>">Weather Page</a> <br/>
	<a href="/table.jsp">Weather Page</a>
	
	<br />
	
	<c:set var = "string1" value = "This is first String."/>	
    <c:set var = "string2" value = "${fn:substring(string1, 5, 15)}" />

    <p>Final sub string : ${string2}</p>
</body>
</html>

















