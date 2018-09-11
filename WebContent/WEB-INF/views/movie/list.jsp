<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ticketSpring</title>
</head>
<body>
	<h3>${sucesso}</h3>
	<table>
		<tr>
			<th>Título</th>
			<th>Preços</th>
			<th>Detalhes</th>
		</tr>
		<c:forEach items="${movies}" var="movie">
			<tr>
				<td>${movie.title}</td>
				<td>| <c:forEach items="${movie.prices}" var="price">
						${price.ticketType} - ${price.value} |
					</c:forEach>
				</td>
				<td><c:url value="/movie/${movie.id}" var="linkDetalhar" />
					<a href="${linkDetalhar}"> Detalhes </a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>