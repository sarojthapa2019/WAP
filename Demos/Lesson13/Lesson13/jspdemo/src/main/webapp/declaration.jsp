<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Declaration</title>
</head>
<body>
	<%!int count = 0;

	int getCount() {
		System.out.println("In getCount() method");
		return count;
	}%>

	Page Count is:
	<%
		out.println(getCount());
	%>
</body>
</html>