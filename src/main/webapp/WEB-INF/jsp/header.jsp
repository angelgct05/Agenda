<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>		

<style>
#header.container-fluid .row{
  overflow: hidden;
  background-color: #83CB5A;
  font-family: 'Lobster', cursive;
}
#header.container-fluid .row a.logo{
	text-decoration: none;
	font-size: 25px;
	color: #000000;
	float: left;
}
#header.container-fluid .row a.logo:hover{
	color: #C3EFE0;
}

#header.container-fluid .row p.float{
	float: right;
	font-family: 'Open Sans', sans-serif;
	padding: 5px;
}
</style>

<div id="header" class="container-fluid">
	<div class="row">
		<div class="col-xs-12">
			<a href="/agenda/index" class="logo"><spring:message code="index.texto.principal" /></a>
			<p class="float"><spring:message code="index.texto.descripcion" /></p>
		</div>
	</div>
</div>