jQuery(document).ready(function($) {
	$("#user").focus();
	
	$("div.page-header").on({
		mouseenter: function(){
			$("div.page-header").css("cursor", "pointer");
		},
		mouseleaver: function(){
			$("div.page-header").css("cursor", "default");
		},
		click: function(){
			location.reload();
		}
	});
	
	if($("#estado").val()=="errValid"){
		alert("No se puede acceder debido a los siguientes errores:\n\n"+$("#eUser").text()+"\n"+$("#ePass").text());
		window.history.back();
	}else if($("#estado").val()=="errNoCoincide"){
		alert($("#errNoCoincide").val());
		window.history.back();
	}else if($("#estado").val()=="errNoEncontrado"){
		alert($("#errNoEncontrado").val());
		window.history.back();
	}
});