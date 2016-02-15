<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href='bootstrap/css/bootstrap.min.css' rel='stylesheet' />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form action="cadPessoa.do" method="post" class="form-group" >
  	<div class="container">
   	<div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
        <h1 class="text-center login-title">Cadastro</h1>
        <div class="account-wall">
		<form class="form-signin">

	<form>
		Nome: <input type="text" name="name" class="form-control" required="required"/><br>
		Senha: <input type="password" name="password" class="form-control" required="required"/><br>
		<input type="submit" value="Cadastrar" class="btn btn-lg btn-primary btn-block"/>
	</form>
	
	</div>
    </div>
</div>
</div>

	</form>
	
</body>
</html>