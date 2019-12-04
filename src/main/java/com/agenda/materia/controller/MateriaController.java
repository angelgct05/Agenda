package com.agenda.materia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.agenda.materia.bean.MateriaBean;

@Controller
@RequestMapping("/materia")
public class MateriaController {
	
	@Autowired
	MateriaBean materiaBean;
	
	
	@GetMapping("/")
	public String principal(ModelMap model) throws Exception{
		try{
			List<MateriaBean> lista = this.materiaBean.obtenerMaterias();			
			model.addAttribute("lista", lista);			
		}catch (EmptyResultDataAccessException ex){
			model.addAttribute("lista", ""); //error por excepcion
		}		
		
		return "materia/materia";
	}
}
