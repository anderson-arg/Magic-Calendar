<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.*"%>
<%@page import="br.edu.ifpb.si.pweb.model.*"%>
<%@page import="br.edu.ifpb.si.pweb.dao.*"%>
<%@page import="br.edu.ifpb.si.pweb.util.*"%>

<c:if test="${empty sessionScope }">
	<jsp:include page="index.jsp"></jsp:include>
</c:if>
<c:if test="${sessionScope.logado.getClass().name == 'br.edu.ifpb.si.pweb.model.Usuario' }">
	<jsp:include page="index.jsp"></jsp:include>
</c:if>

<html>
<head>
<link href='bootstrap/css/bootstrap.min.css' rel='stylesheet' />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">

	#view{
		position:absolute;
		width: 500px;
		height: 500px; 
		left: 50%;
		top: 10%;
		margin-left: -250px;
	}
	
	#view h1{
		text-align: center;
	}

</style>

</head>
<body>
	<%
		DAO.open();
			UsuarioDAO uDAO = new UsuarioDAO();
			List<Usuario> listUser = uDAO.readAllUserInactive();
			pageContext.setAttribute("list", listUser);
		DAO.close();
	%>
	
	<c:if test="${list.size() > 0 }">
		<div id="view">
		<form action="acceptUser.do" method="get" >
			<h1>Accept User</h1>
			<table class="table table-striped">
				<tr>
					<th>Accept</th>
					<th>Name</th>
				<tr>
					<c:forEach var="user" items="${list }">
						<tr>
							<td><input type="checkbox" name="id[]" value=${user.id } /></td>
							<td>${user.name }</td>
						</tr>
					</c:forEach>
			</table>
			<input type="submit" value="Accept" class="btn btn-lg btn-primary btn-block"/>
			<a href="/calendar/index.jsp"><b class="btn btn-lg btn-primary btn-block">Back</b></a>
		</form>
		</div>
	</c:if>
	<c:if test="${list.size() == 0 }">
		<div class="alert alert-danger">
  			<strong>Danger!</strong> Sem Cadastro Pendente!
		</div>
		
	</c:if>
</body>
</html>