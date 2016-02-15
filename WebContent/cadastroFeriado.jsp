<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.*"%>
<%@page import="br.edu.ifpb.si.pweb.model.*"%>
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

<script type="text/javascript">

function mostraFeriadoFixo() {
	document.getElementById('fixo').style.display = 'block';
}

function mostraMovel() {
	document.getElementById('movel').style.display = 'block';
}

function mostraSubstituto() {
	document.getElementById('substituto').style.display = 'block';
}

</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar Feriado</title>
</head>
<body>

  <div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <div class="account-wall">
				<a href="#" onclick="javascript:mostraFeriadoFixo();"  class="btn btn-lg btn-primary btn-block">Cadastro Feriado Fixo</a><br>				                
        </div>
    </div>
	</div>
  </div>
  
  <div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <div class="account-wall">
				<a href="#" onclick="javascript:mostraMovel();" class="btn btn-lg btn-primary btn-block">Cadastro Feriado Móvel</a>				                
        </div>
    </div>
	</div>
  </div><br>
  
  <div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <div class="account-wall">
				<a href="#" onclick="javascript:mostraSubstituto();" class="btn btn-lg btn-primary btn-block">Cadastro Feriado Substituto</a>				                
        </div>
    </div>
	</div>
  </div><br><br>
  
<div id="fixo" style="display:none;">  
  <form action="addFixedHoliday.do" method="get">
   <div class="container"> 
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <h1 class="text-center login-title">Cadastro Feriado Fixo</h1>
            <div class="account-wall">
                <form class="form-signin">
                <input type="hidden" name="id" value=${param.id } class="form-control">
                Descrição<input  type="text" name="desc"class="form-control" required="required">
                Data Fixo<input type="date" name="date" class="form-control" required="required">
            	</button>
                <input type="submit" value="Cadastrar" name="submit" class="btn btn-lg btn-primary btn-block">
                </button>
				<a href="/calendar/index.jsp" class="btn btn-lg btn-primary btn-block">Back</a>				                
        </div>
        </div>
    </div>
    </div>
</form>
</div>

  <div id="movel" style="display:none;">
  <form action="addMovementHoliday.do" method="get">
  <div class="container" >
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <h1 class="text-center login-title">Cadastro Feriado Móvel</h1>
            <div class="account-wall">
                <form class="form-signin">
                Descrição<input  type="text" name="desc"class="form-control" required="required">
                Data Movel Inicio<input type="date" name="startDate" class="form-control" required="required">
                Data Movel Fim(opcional)<input type="date" name="endDate" class="form-control" required="required" >
            	</button>
                <input type="submit" value="Cadastrar" class="btn btn-lg btn-primary btn-block">
                </button>
				<a href="/calendar/index.jsp" class="btn btn-lg btn-primary btn-block">Back</a>				                
        </div>
    </div>
</div>
</div>
</form>
</div>
  
  <div id="substituto" style="display:none;">	
	<form action="addSubstituteHoliday.do" method="get" >
	<div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <h1 class="text-center login-title">Cadastro Feriado Substituto</h1>
            <div class="account-wall">
                <!-- Descrição<input  type="text" name="desc"class="form-control"> -->
                Data a ser substituída<select name="date" class="form-control" >
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
			Data substituta<input type="date" name="subDate" class="form-control" required="required">    
			<input type="submit" value="Cadastrar" class="btn btn-lg btn-primary btn-block">
            </button>
			<a href="/calendar/index.jsp" class="btn btn-lg btn-primary btn-block">Back</a>				                
        </div>
    </div>
</div>
</div>
</form>	
</div>


</body>
</html>