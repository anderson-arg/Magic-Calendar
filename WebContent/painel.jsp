<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>
	iframe{
		position:absolute;
		width:1000px;
		height: 880px;
		left: 50%;
		top: 50%;
		margin-left: -500px;
		margin-top: -200px;
	}
	
	body {
		margin: 0;
		padding: 0;
		font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
		font-size: 14px;
	}
	
	#topo{
		width: auto;
		height: 50px;
	}
	
	#menu{
		position:relative;
		float: right;
	}
	
	#menu ul li{
		list-style-type: none;
		display: inline-block;
		margin-right: 30px; 
	}
	
	#menu a{
		text-decoration: none;
	}
	
</style>

</head>
<body>
	<div id="topo">	
		<div id="menu">
			<ul>
			<c:if test="${not empty sessionScope }">
				<li><b>Seja Bem Vindo, ${logado.name }</b></li>
			</c:if>
				<li id="acceptUser"><b>Accept User</b></li>
				<li id="registerHoliday"><b>Register Holiday</b></li>
				<li id="logout"><b>Logout</b></li>
			</ul>
		</div>
	</div>
	<iframe src="/calendar/index.jsp"></iframe>
</body>
</html>