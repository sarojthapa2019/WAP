<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Time JSP</h1>

	<%
		//the parameter "zone" shall be equal to a number between 0 and 24 (inclusive)
		TimeZone timeZone = TimeZone.getDefault(); //returns the default TimeZone  if (request.getParameterValues("zone") != null)
		/*
		since we're basing our time from GMT, we'll set our Locale to
		Brittania, and get a Calendar.
		*/
		Calendar myCalendar = Calendar.getInstance(timeZone, Locale.UK);
	%>

	The current time is:
	<%=myCalendar.get(Calendar.HOUR_OF_DAY)%>:
	<%=myCalendar.get(Calendar.MINUTE)%>:
	<%=myCalendar.get(Calendar.SECOND)%>



</body>
</html>