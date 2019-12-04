<!-- Imports -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>


<head>
<!-- Librerias -->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link href="<c:url value='/resources/css/index.css'/>" rel="stylesheet"></link>
<link href="https://fonts.googleapis.com/css?family=Lobster|Open+Sans&display=swap" rel="stylesheet">

<title><spring:message code="index.titulo" /></title>

</head>

<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/header.jsp" />
	</header>
	<div class="container">
		<div id="blank" class="row"></div>
		<div class="row">
			<div class="col-xs-12 col-sm-5 col-md-4 col-sm-offset-3 col-md-offset-4" id="login">
				<form:form modelAttribute="usuarioBean" action="usuario/login" method="post"> 
					<div class="form-group">
						<form:label path="usuario">Usuario:</form:label>
						<form:input id="user" class="form-control" value="${user}" placeholder="Escribe tu usuario" path="usuario" />
						<form:errors id="eUser" path="usuario" hidden="hidden" />
					</div>
					
					<div class="form-group">
						<form:label path="contrasena">Contrase&ntilde;a:</form:label>
						<form:password id="pass" class="form-control" value="" placeholder="Escribe tu contraseña" path="contrasena" />
						<form:errors id="ePass" path="contrasena" hidden="hidden" />
					</div>
						
					
					
					
					<input type="hidden" id="estado" value="${estado}"/>
					<input type="hidden" id="errNoCoincide" value="<spring:message code='mensaje.error.usuario' />"/>
					<input type="hidden" id="errNoEncontrado" value="<spring:message code='mensaje.error.usuarioNoEncontrado' />"/>				
					<input id="submit" type="submit" class="btn btn-primary" value="Entrar" />	
				</form:form>
			</div>
		</div>
	</div>
	
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	<script src="<c:url value='/resources/js/index.js'/>"></script>
</body>






</html>