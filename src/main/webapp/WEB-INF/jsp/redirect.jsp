<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<input type="hidden" id="redireccion" value="${ redireccion }" />
<input type="hidden" id="msg" value="${ msg }" />

<script>
	jQuery(document).ready(function($){		
		var mensaje = "";
		
		switch($("#msg").val()){
			case "profesor_agregado":
				mensaje = "El profesor se ha agregado con \u00E9xito.";
			break;
			
			case "profesor_eliminado":
				mensaje = "El profesor se ha eliminado con \u00E9xito.";
			break;
			
			case "profesor_editado":
				mensaje = "El profesor se ha editado con \u00E9xito";
			break;
		}
		
		if(mensaje!=""){
			alert(mensaje);
		}
		
		window.location = $("#redireccion").val();
	});
</script>