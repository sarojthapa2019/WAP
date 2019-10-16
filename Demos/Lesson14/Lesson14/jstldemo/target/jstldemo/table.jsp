<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Weather Page</title>
</head>
<body>
	<%
		String[][] data = { { "Nov 6", "32", "26" }, { "Nov 7", "32", "26" }, { "Nov 8", "32", "26" } };
		request.setAttribute("temperatures", data);
	%>
	<table>
		<tr>
			<th>DATE</th>
			<th>HIGH</th>
			<th>LOW</th>
		</tr>
		<c:forEach var="daily" items="${temperatures}">
			<tr>
				<td>${daily[0]}</td>
				<td>${daily[1]}</td>
				<td>${daily[2]}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
