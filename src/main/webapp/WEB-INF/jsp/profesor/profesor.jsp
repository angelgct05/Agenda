<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
	<script src="<c:url value='/resources/js/profesor/profesor.js'/>"></script>
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
		
		<div class="row" style="height:55px;">
			<div class="col-xs-5 col-md-2 col-xs-offset-3 col-sm-offset-4 col-lg-offset-5">
				<a href="agregar"><button type="button" class="btn btn-default">Agregar un nuevo profesor</button></a>
			</div>
		</div>
		
		<div class="row">
			<div class="col-lg-12">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Nombre</th>
							<th>Correo</th>
							<th>Tel&eacute;fono</th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ lista }" var="profesor">
							<tr>
								<td>${ profesor.nombre } ${ profesor.apPaterno } ${ profesor.apMaterno }</td>
								<td>${ profesor.correo }</td>
								<td>${ profesor.numTelefono }</td>
								<td><a href="editar/${ profesor.profesorId }">
									<input type='button' class="btn btn-success" value='Editar' /></a></td>
								<td><a href="eliminar/${ profesor.profesorId }" onclick="eliminar('${ profesor.nombre }')">
									<input type='button' class="btn btn-danger" value='Eliminar'  /></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	
	<script>
		function eliminar(nombre){
			if((confirm("\u00BFEst\u00E1 seguro que desea eliminar a "+nombre+"?"))==false){
				event.preventDefault();
			}
		}
	</script>
</body>
</html>