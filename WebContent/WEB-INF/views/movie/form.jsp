<%@taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Cadastro de filmes</title>
</head>
<body>
	<c:url value="/movie" var="url"/>
	<form:form action="${spring:mvcUrl('saveMovie').build()}" method="post" commandName="movie">
		<div>
			<ul>
				<c:forEach var="error" items="${errors.allErrors}">
					<li><spring:message code="${error.code}" text="${error.defaultMessage}"/></li>
				</c:forEach>
			</ul>
		</div>
		<div>
			<label for = "title">Título</label>
			<form:input path="title" id="title"/>
			<form:errors path="title"/>
		</div>
		<div>
			<label for = "description">Descrição</label>
			<form:textarea rows="10" cols="20" path="description" id="description"/>
			<form:errors path="description"/>
		</div>
		<div>
			<label for = "length">Duração</label>
			<form:input path="length" id="length"/>
			<form:errors path="length"/>
		</div>
		<div>
			<label for = "releaseDate">Data de estreia</label>
			<input type="date" name="releaseDate" id="releaseDate"/>
			<form:errors path="releaseDate"/>
		</div>
		<div>
			<label for = "lastExhibitionDate">Data da última exibição</label>
			<input type="date" name="lastExhibitionDate" id="lastExhibitionDate"/>
			<form:errors path="lastExhibitionDate"/>
		</div>
		<c:forEach items="${types}" var="ticketType" varStatus="status">
			<div>
				<label for="price_${ticketType}">${ticketType}</label> 
				<input type="text" name="prices[${status.index}].value" id="price_${ticketType}" /> 
				<input type="hidden" name="prices[${status.index}].ticketType" value="${ticketType}" />
			</div>
		</c:forEach>
		<div>
			<input type="submit" value="Enviar"/>
		</div>
	</form:form>
</body>
</html>