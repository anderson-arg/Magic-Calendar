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

<style type="text/css">

.form-signin
{
    max-width: 330px;
    padding: 15px;
    margin: 0 auto;
}
.form-signin .form-signin-heading, .form-signin .checkbox
{
    margin-bottom: 10px;
}
.form-signin .checkbox
{
    font-weight: normal;
}
.form-signin .form-control
{
    position: relative;
    font-size: 16px;
    height: auto;
    padding: 10px;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
}
.form-signin .form-control:focus
{
    z-index: 2;
}
.form-signin input[type="text"]
{
    margin-bottom: -1px;
    border-bottom-left-radius: 0;
    border-bottom-right-radius: 0;
}
.form-signin input[type="password"]
{
    margin-bottom: 10px;
    border-top-left-radius: 0;
    border-top-right-radius: 0;
}
.account-wall
{
    margin-top: 20px;
    padding: 40px 0px 20px 0px;
    background-color: #f7f7f7;
    -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
}
.login-title
{
    color: #555;
    font-size: 18px;
    font-weight: 400;
    display: block;
}
.profile-img
{
    width: 96px;
    height: 96px;
    margin: 0 auto 10px;
    display: block;
    -moz-border-radius: 50%;
    -webkit-border-radius: 50%;
    border-radius: 50%;
}
.need-help
{
    margin-top: 10px;
}
.new-account
{
    display: block;
    margin-top: 10px;
}

</style>

</head>
<body>

	<form class="form-group" action="altHoliday.do" method="get">
	  
  
  <div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <h1 class="text-center login-title">Alter Holiday</h1>
            <div class="account-wall">
                	<form class="form-signin">
                <input type="hidden" name="id" value=${param.id } class="form-control">
                <input type="text" name="texto" value=${param.title } class="form-control" required="required">
                <input type="submit" name="submit" value="Update" class="btn btn-lg btn-primary btn-block">
            	</button>
                <input type="submit" name="submit" value="Delete" class="btn btn-lg btn-primary btn-block">
                </button>
				<a href="/calendar/index.jsp" class="btn btn-lg btn-primary btn-block">Back</a>
				                
        </div>
    </div>
</div>

	</form>
</body>
</html>
<!--  		
		<input type="hidden" name="id" value=${param.id } />
		title: <input type="text" name="texto" value=${param.title }/><br>
		<input type="submit" name="submit" value="Update" /> - <input type="submit" name="submit" value="Delete" />
-->
		