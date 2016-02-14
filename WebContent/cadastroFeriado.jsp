<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.*"%>
<%@page import="br.edu.ifpb.si.pweb.model.*"%>
<%@page import="br.edu.ifpb.si.pweb.util.*"%>
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
		Data a ser Substituida: 
		<select name="date">
			<% 
				Pessoa p = (Pessoa) request.getSession(false).getAttribute("logado");
				List<CalendarHoliday> holidays = ((Admin)p).getAllListHoliday();
				ArrayList<CalendarHoliday> fixedHolidays = new ArrayList<CalendarHoliday>();
				for(CalendarHoliday ch : holidays){
					if(ch.getType() == CalendarType.CALENDAR_FIXED){
						fixedHolidays.add(ch);
					}
				}
				pageContext.setAttribute("list", fixedHolidays);
			%>
			<c:forEach var="holiday" items="${list }">
				<option value=${holiday.start }>${holiday.start }</option>
			</c:forEach>
		</select>
		Data Substituto: <input type="date" name="subDate" /><br>
		<input type="submit" value="Cadastrar" /><br><br>
	</form>

</body>
</html>