<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="addComment" method="get">
		
		<input type="hidden" name="data" value=${param.date} />
		Comentario: <input type="text" name="texto" /><br>
		<input type="submit" value="ADD" />
		
	</form>
	<a href="/calendar/index.jsp">Voltar</a>

</body>
</html>