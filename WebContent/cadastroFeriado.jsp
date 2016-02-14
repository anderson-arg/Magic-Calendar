<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Cadastro data Fixo
	<form action="addFixedHoliday.do" method="get">
		Descrição: <input type="text" name="desc" /><br>
		Data Fixo: <input type="date" name="date" /><br>
		<input type="submit" value="Cadastrar" /><br><br>
	</form>
	
	Cadastro data Movel
	<form action="addMovementHoliday.do" method="get">
		Descrição: <input type="text" name="desc" /><br>
		Data Movel Inicio: <input type="date" name="startDate" /><br>
		Data Movel Fim(Opcional): <input type="date" name="endDate" /><br>
		<input type="submit" value="Cadastrar" /><br><br>
	</form>
	
	Cadastro data Substituto
	<form action="addSubstituteHoliday.do" method="get">
		Descrição: <input type="text" name="desc" /><br>
		Data a ser Substituida: <input type="date" name="date" /><br>
		Data Substituto: <input type="date" name="subDate" /><br>
		<input type="submit" value="Cadastrar" /><br><br>
	</form>

</body>
</html>