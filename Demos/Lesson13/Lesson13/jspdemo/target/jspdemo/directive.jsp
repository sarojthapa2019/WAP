<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Directive - page, include, taglib</title>
</head>
<body>
	<%
		System.out.println("Evaluating date now");
		Date date = new Date();
	%>
	Hello! The time is now
	<%=date%>

	<%@ include file="WEB-INF/hello.jsp"%>

	<c:forEach var="i" begin="1" end="5">
         Item <c:out value="${i}" />
		<p>
	</c:forEach>

</body>
</html>