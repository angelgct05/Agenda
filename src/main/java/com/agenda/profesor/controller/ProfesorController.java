package com.agenda.profesor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.agenda.profesor.bean.ProfesorBean;

@Controller
@RequestMapping("/profesor")
public class ProfesorController {
	
	@Autowired
	ProfesorBean profesorBean;
	
	
	
	@GetMapping("/")
	public String principal(ModelMap model) throws Exception{		
		try{
			List<ProfesorBean> lista = this.profesorBean.obtenerProfesores();			
			model.addAttribute("lista", lista);			
		}catch (EmptyResultDataAccessException ex){
			model.addAttribute("lista", ""); //error por excepcion
		}		
		
		return "profesor/profesor";
	}
	
	
	
	@GetMapping("/agregar")
	public String form(@ModelAttribute("profesorBean") ProfesorBean profesorBean, ModelMap model){
		model.addAttribute("msg", "");
		model.addAttribute("estado", "Agregar");
		model.addAttribute("action", "agregar/guardar");
		return "profesor/form";
	}
	
	
	
	@PostMapping("/agregar/guardar")
	public String guardar(@ModelAttribute @Validated({ ProfesorBean.Profesor.class }) ProfesorBean profesorBean, 
			BindingResult result, ModelMap model) throws Exception{
		
		if(result.hasErrors()){
			model.addAttribute("msg", "error");
			return "profesor/form";
		}
		
		this.profesorBean.agregarProfesor(profesorBean);
		model.addAttribute("redireccion", "/agenda/profesor/");
		model.addAttribute("msg", "profesor_agregado");
		return "redirect";
	}
	
	
	
	@GetMapping("/editar/{id}")
	public String edicion(@PathVariable("id") int id, 
			@ModelAttribute("profesorBean") ProfesorBean profesorBean, ModelMap model) throws Exception{
		
		profesorBean = this.profesorBean.obtenerProfesor(id);
		
		model.addAttribute("profesor", profesorBean);
		model.addAttribute("estado", "Editar");
		model.addAttribute("action", "guardar");
		return "profesor/form";
	}
	
	
	
	@PostMapping("/editar/guardar")
	public String editar(@ModelAttribute @Validated({ ProfesorBean.Profesor.class }) ProfesorBean profesorBean, 
			BindingResult result, ModelMap model) throws Exception{
		
		if(result.hasErrors()){
			model.addAttribute("msg", "error");
			return "profesor/form";
		}
		
		this.profesorBean.editarProfesor(profesorBean);
		model.addAttribute("redireccion", "/agenda/profesor/");
		model.addAttribute("msg", "profesor_editado");
		return "redirect";
	}
	
	
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") int id, ModelMap model) throws Exception{
		this.profesorBean.eliminarProfesor(id);
		model.addAttribute("redireccion", "/agenda/profesor/");
		model.addAttribute("msg", "profesor_eliminado");
		return "redirect";
	}
}
