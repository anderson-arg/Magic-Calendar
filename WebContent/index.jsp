<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="typeUser" value="${sessionScope.logado }"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<meta name="viewport" content="width=device-width, initial-scale=1">
 
<link href='bootstrap/css/bootstrap.min.css' rel='stylesheet' />
<link href='fullcalendar/css/fullcalendar.css' rel='stylesheet' />
<link href='fullcalendar/css/fullcalendar.print.css' rel='stylesheet' media='print' />
<script src='fullcalendar/js/jquery.min.js'></script>
<script src='bootstrap/js/bootstrap.min.js'></script>
<script src='fullcalendar/js/moment.min.js'></script>
<script src='fullcalendar/js/fullcalendar.min.js'></script>

<script>

	$(document).ready(function() {
		var CALENDAR_FIXED = 1;
		var CALENDAR_MOVEMENT = 2;
		var CALENDAR_SUBSTITUTE = 3;
		var CALENDAR_COMMENT = 4;
		var typeUser = "${typeUser.getClass().name }";
		
		$('#calendar').fullCalendar({
			header: {
				left: 'prev,next today',
				center: 'title',
				right: ''
			},
			//defaultDate: '2016-02-08',
			//theme: true,
			editable: false,
			eventLimit:true,
			events: "/calendar/json.do",

			
			eventClick: function(calEvent, jsEvent, view) {
				//$("#commentModal").modal();
				
				if(typeUser == 'br.edu.ifpb.si.pweb.model.Admin'){
					window.location.href = "/calendar/altHoliday.jsp?id='"+calEvent.id+"'&title='"+calEvent.title+"' ";
				}
				
				if(typeUser == 'br.edu.ifpb.si.pweb.model.Usuario' && calEvent.type == CALENDAR_COMMENT){
					window.location.href = "/calendar/altComentario.jsp?id='"+calEvent.id+"'&title='"+calEvent.title+"' ";
				}

			},
			
			dayClick: function(date, jsEvent, view) {
				if(typeUser == 'br.edu.ifpb.si.pweb.model.Usuario'){
		       		window.location.href = "/calendar/comentario.jsp?date='"+date.format()+"' ";
				}
				
				/*if(typeUser == 'br.edu.ifpb.si.pweb.model.Admin'){
		       		window.location.href = "/calendar/cadastroFeriado.jsp ";
				}*/
		    },
		    
		    eventMouseover: function( event, jsEvent, view ) { 
		    	if(event.type == CALENDAR_COMMENT && typeUser == 'br.edu.ifpb.si.pweb.model.Usuario' )
		    		$(this).css('cursor', 'pointer');
		    	if(typeUser == 'br.edu.ifpb.si.pweb.model.Admin' )
		    		$(this).css('cursor', 'pointer');
		    }
			
		});
		
		$(".fc-prev-button, .fc-next-button, .fc-today-button").click(function(){
			var moment = $('#calendar').fullCalendar('getDate').format();
			$.ajax({
	            url: "/calendar/allFixedDate.do?date='"+moment+"' ",
	            type: "POST"
	            /*error:function(){
	                alert("ERRO MENU");
	            },
	            success:function(data){
	            	alert("OK");
	            }*/
	        });
	    });
		
		$("#login").click(function(){
	        $("#loginModal").modal();
	    });
		
		$("#login").mouseover(function() {
			$(this).css('cursor', 'pointer');
		});
		
	});
</script>
<style>

	body {
		margin: 0;
		padding: 0;
		font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
		font-size: 14px;
	}

	#calendar {
		max-width: 900px;
		margin: 50px auto;
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
		margin-top: 20px;
	}
	
	.modal-header, h4, .close {
      background-color: #5cb85c;
      color:white !important;
      text-align: center;
      font-size: 30px;
  	}
 	.modal-footer {
      background-color: #f9f9f9;
  	}
  	
  	#msg{
  		position: absolute;
  		top:20px;
  		left: 20%;
  		color:#f00;
  		font-size: 20px;
  	}
  	
  	#help{
  		position: absolute;
  		left: 5%;
  		top: 30%;
  	}
  	
  	#red{
  		width: 20px;
  		height: 10px; 
  		background-color: #f00;
  		
  	}
  	#green{
  		width: 20px;
  		height: 10px; 
  		background-color: #0f0;
  	}
  	#blue{
  		width: 20px;
  		height: 10px; 
  		background-color: #00f;
  	}

</style>

</head>
<body>
	
	<div id="topo">
		<div id="msg">${requestScope.msg }</div>
		<div id="menu">
			<ul>
			<c:if test="${sessionScope.logado.getClass().name == 'br.edu.ifpb.si.pweb.model.Admin' }">
				<li><b>Welcome, ${sessionScope.logado.name }</b></li>
				<li id="acceptUser"><a href="/calendar/acceptUser.jsp">Accept User</a></b></li>
				<li id="registerHoliday"><a href="/calendar/cadastroFeriado.jsp">Register Holiday</a></li>
				<li id="passwordChange"><a href="/calendar/passwordChange.jsp">Password Change</a></li>
			</c:if>
			<c:if test="${sessionScope.logado.getClass().name == 'br.edu.ifpb.si.pweb.model.Usuario' }">
				<li><b>Welcome, ${sessionScope.logado.name }</b></li>
				<li id="accountDelete"><a href="/calendar/delAccount.do">AccountDelete</a></li>
			</c:if>
			<c:if test="${not empty sessionScope }">
				<li id="logout"><a href="/calendar/logout.do"><b>Logout</b></a></li>
			</c:if>
			<c:if test="${empty sessionScope }">
				<li><b id="login">Login</b></li>
			</c:if>
			</ul>
		</div>
	</div>
	<div id="help">
		<table>
			<tr>
				<td><div id="red"></div></td>
				<td><b>Fixed</b></td>
			</tr>
			<tr>
				<td><div id="green"></div></td>
				<td><b>Movement</b></td>
			</tr>
			<tr>
				<td><div id="blue"></div></td>
				<td><b>Substitute</b></td>
			</tr>
		</table>
	</div>
	<div id='calendar'></div>

<!-- Tela Modal Login -->	
<div class="container">

  <!-- Modal -->
  <div class="modal fade" id="loginModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header" style="padding:35px 50px;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4><span class="glyphicon glyphicon-lock"></span> Login</h4>
        </div>
        <div class="modal-body" style="padding:40px 50px;">
          <form action="login.do" method="post" role="form">
            <div class="form-group">
              <label for="name"><span class="glyphicon glyphicon-user"></span> Username</label>
              <input type="text" name="name" class="form-control" id="name" placeholder="Enter name" required="required">
            </div>
            <div class="form-group">
              <label for="password"><span class="glyphicon glyphicon-eye-open"></span> Password</label>
              <input type="password" name="password" class="form-control" id="password" placeholder="Enter password" required="required">
            </div>
              <button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span> Login</button>
          </form>
        </div>
        <div class="modal-footer">
          <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
          <p>Not a member? <a href="/calendar/cadastro.jsp">Sign Up</a></p>
        </div>
      </div>
      
    </div>
  </div> 
</div>

</body>



</html>