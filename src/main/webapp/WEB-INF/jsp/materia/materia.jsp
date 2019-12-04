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
	
	<title>Agenda - Materias</title>

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
				<a href="agregar"><button type="button" class="btn btn-default">Agregar una nueva materia</button></a>
			</div>
		</div>
		
		<div class="row">
			<div class="col-lg-12">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Abreviatura</th>
							<th>Nombre</th>
							<th>Calificaci&oacute;n</th>
							<th>Color</th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ lista }" var="materia">
							<tr>
								<td>${ materia.abrev }</td>
								<td>${ materia.nombre }</td>
								<td>${ materia.calificacion }</td>
								<td>${ materia.profesorBean.nombre }</td> <!-- revisar si al final se debe enviar por json o asi se puede -->
								<td><a href="editar/${ materia.materiaId }">
									<input type='button' class="btn btn-success" value='Editar' /></a></td>
								<td><a href="eliminar/${ materia.materiaId }" onclick="eliminar('${ materia.nombre }')">
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