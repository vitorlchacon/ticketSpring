<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Cadastro de filmes</title>
</head>
<body>
	<c:url value="/movie" var="url"/>
	<form action="${url}" method="post">
		<div>
			<label for = "title">T�tulo</label>
			<input type="text" name="title" id="title"/>
		</div>
		<div>
			<label for = "description">Descri��o</label>
			<textarea rows="10" cols="20" name="description" id="description"></textarea>
		</div>
		<div>
			<label for = "length">Dura��o</label>
			<input  type="text" name="length" id="length"/>
		</div>
		<div>
			<input type = "submit" value="Enviar"/>
		</div>
	</form>
</body>
</html>