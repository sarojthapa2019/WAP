<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='mytag' uri='/WEB-INF/tlds/loop'%>
<%@ page import="java.util.*, com.wap.customertag.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	List<Movie> movies = new ArrayList<Movie>();
	movies.add(new Movie("movie1", "romance"));
	movies.add(new Movie("movie2", "sci-fiction"));
	movies.add(new Movie("movie3", "comedy"));
	pageContext.setAttribute("movies", movies);
%>

	<table>
		<mytag:simple var="movie" items="${movies}" >
			<tr>
				<td>${movie.name}</td>
				<td>${movie.genre}</td>
			</tr>
		</mytag:simple>
	</table>
</body>
</html>