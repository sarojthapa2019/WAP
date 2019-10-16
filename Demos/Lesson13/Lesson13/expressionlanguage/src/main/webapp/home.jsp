<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII" import="java.util.*"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>JSP EL Example Home</title>
</head>
<body>
<p>
	EL evaluation is enabled by default if the Servlet version specified in the web deployment descriptor file (web.xml) is 2.4 or later
</p>
<p>
	EL expressions are ignored if the Servlet version is 2.3 or lower
</p>

<pre>
	Enable EL:
	&lt;%@ page isELIgnored="false" %&gt;
</pre>
	<%
		List<String> names = new ArrayList<String>();
		names.add("Tom");
		names.add("John");
		names.add("Jerry");
		pageContext.setAttribute("names", names);
	%>
	<strong>Simple . EL Example:</strong> ${requestScope.person}
	<br>
	<br>
	<strong>Simple . EL Example without scope:</strong> ${person}
	<br>
	<br>
	<strong>Simple [] Example:</strong> ${applicationScope["User.Cookie"]}
	<br>
	<br>
	<strong>Multiples . EL Example:</strong>
	${sessionScope.person2.address.address}
	<br>
	<br>
	<strong>List EL Example:</strong> ${names[1]}
	<br>
	<br>
	<strong>Header information EL Example:</strong>
		${header["Accept-Encoding"]}
	<br>
	<br>
	<strong>Cookie EL Example:</strong> ${cookie["User.Cookie"].value}
	<br>
	<br>
	<strong>pageContext EL Example:</strong> HTTP Method is
	${pageContext.request.method}
	<br>
	<br>
	<strong>Context param EL Example:</strong> ${initParam.AppID}
	<br>
	<br>
	<strong>Arithmetic Operator EL Example:</strong> ${initParam.AppID + 200}
	<br>
	<br>
	<strong>Relational Operator EL Example:</strong> ${initParam.AppID < 200}
	<br>
	<br>

</body>
</html>