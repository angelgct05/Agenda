<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
	<link href="https://fonts.googleapis.com/css?family=Lobster|Open+Sans&display=swap" rel="stylesheet">
	
	<title>Agenda - Profesores</title>

</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/header.jsp" />
	</header>
	<div id="navbar">
		<jsp:include page="/WEB-INF/jsp/navbar.jsp" />
	</div>
	
	<div class="container">
		<div class="row" style="height:20px;"></div>
		
		<div class="row">
			<div class="col-xs-12">
				<form:form modelAttribute="profesorBean" action="${ action }" method="post">				
					<div class="form-group">
						<form:label path="nombre">Nombre:</form:label>
						<form:input id="nombre" path="nombre" class="form-control" value="${ profesor.nombre }" />
						<form:errors path="nombre" hidden="hidden"></form:errors>
					</div>
					
					<div class="form-group">
						<form:label path="apPaterno">Apellido Paterno:</form:label>
						<form:input path="apPaterno" class="form-control" value="${ profesor.apPaterno }" />
						<form:errors path="apPaterno" hidden="hidden"></form:errors>
					</div>
					
					<div class="form-group">
						<form:label path="apMaterno">Apellido Materno:</form:label>
						<form:input path="apMaterno" class="form-control" value="${ profesor.apMaterno }" />
						<form:errors path="apMaterno" hidden="hidden"></form:errors>
					</div>
					
					<div class="form-group">
						<form:label path="correo">Correo:</form:label>
						<form:input path="correo" class="form-control" value="${ profesor.correo }" />
						<form:errors path="correo" hidden="hidden"></form:errors>
					</div>
					
					<div class="form-group">
						<form:label path="numTelefono">Tel&eacute;fono:</form:label>
						<form:input path="numTelefono" class="form-control" value="${ profesor.numTelefono }" />
						<form:errors path="numTelefono" hidden="hidden"></form:errors>
					</div>
					
					<form:hidden path="profesorId" class="form-control" value="${ profesor.profesorId }" />
					
					<input type="hidden" id="msg" value="${ msg }" />
					<input type="submit" class="btn btn-primary" value="${ estado }" />	
					<a href="/agenda/profesor/"><input type="button" class="btn btn-warning" value="Cancelar" /></a>				
				</form:form>
			</div>
		</div>
	</div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	<script>
		jQuery(document).ready(function($){
			$("#nombre").select();
			
			if($("#msg").val()!=""){
				alert("El formulario contiene errores");
				window.history.back();
			}
		});		
	</script>
</body>
</html>