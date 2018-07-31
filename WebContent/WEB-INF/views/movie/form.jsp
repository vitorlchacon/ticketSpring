<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Cadastro de filmes</title>
</head>
<body>
	<c:url value="/movie" var="url"/>
	<form method="post" action="${url}">
		<div>
			<label for = "title">Título</label>
			<input type="text" name="title" id="title"/>
		</div>
		<div>
			<label for = "description">Descrição</label>
			<textarea rows="10" cols="20" name="description" id="description"></textarea>
		</div>
		<div>
			<label for = "length">Duração</label>
			<input  type="text" name="length" id="length"/>
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
	</form>
</body>
</html>