package com.agenda.usuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.dao.EmptyResultDataAccessException;

import com.agenda.usuario.bean.UsuarioBean;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioBean usuarioBean;
	
	@PostMapping("/login")
	public String verificar(@ModelAttribute @Validated({ UsuarioBean.Usuario.class }) UsuarioBean usuarioBean, 
			BindingResult result, ModelMap model) throws Exception{
		
		//Primero se valida si cumple con los requisitos mínimos dados por el Bean y la base de datos
		if(result.hasErrors()){
			model.addAttribute("estado", "errValid");
			return "index";
		}
		
		//Después, verifica si el usuario dado correctamente existe en la base de datos
		UsuarioBean ub;
		try{
			ub = this.usuarioBean.obtenerUsuario(usuarioBean.getUsuario());
		}catch (EmptyResultDataAccessException ex){
			model.addAttribute("estado", "errNoEncontrado");
			model.addAttribute("user", usuarioBean.getUsuario());
			return "index";
		}
		
		//Por último, de ser un usuario existente, verifica si la contraseña coincide
		if(ub.getContrasena().equals(usuarioBean.getContrasena())){
			model.addAttribute("redireccion", "/agenda/index");
			return "redirect";
		}else{
			model.addAttribute("estado", "errNoCoincide");
			model.addAttribute("user", usuarioBean.getUsuario());
			return "index";
		}
	}
}
