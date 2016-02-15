<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
</head>
<body>
	<form action="passChange.do" method="post" class="form-group" >
  	<div class="container">
   	<div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
        <h1 class="text-center login-title">Password Change</h1>
        <div class="account-wall">
		<form class="form-signin">
		
		<form>
		Senha:<input type="password" name="pass" class="form-control" required="required"/><br>
		Senha Nova:<input type="password" name="newPass" class="form-control" required="required"/><br>
		Re-Senha Nova:<input type="password" name="reNewPass" class="form-control" required="required"/><br>
		<input type="submit" value="Enviar" class="btn btn-lg btn-primary btn-block"/><br>
		</form>
	
	        </div>
    </div>
</div>
</div>

	</form>
	
</body>
</html>