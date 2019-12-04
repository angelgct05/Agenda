package com.agenda;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.agenda.usuario.bean.UsuarioBean;

@Controller
public class AgendaController {
	
	@RequestMapping("/")
	public String home(ModelMap model){
		model.addAttribute("usuarioBean", new UsuarioBean());
		return "index";
	}
}