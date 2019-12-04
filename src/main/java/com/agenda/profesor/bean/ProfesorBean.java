package com.agenda.profesor.bean;

import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;

import com.agenda.profesor.dao.ProfesorDao;

//@SuppressWarnings("serial")
public class ProfesorBean {
	
	//x2
	private int profesorId;
	
	@Size(max = 35, groups = { ProfesorBean.Profesor.class })
	@NotEmpty(groups = { ProfesorBean.Profesor.class })
	private String nombre;
	
	@Size(max = 20, groups = { ProfesorBean.Profesor.class })
	@NotEmpty(groups = { ProfesorBean.Profesor.class })
	private String apPaterno;
	
	@Size(max = 20, groups = { ProfesorBean.Profesor.class })
	private String apMaterno;
	
	@Size(max = 50, groups = { ProfesorBean.Profesor.class })
	@Email(groups = { ProfesorBean.Profesor.class })
	private String correo;
	
	//Algo debe estar aqui
	private String numTelefono;
	
	@Autowired
	private ProfesorDao profesorDao;
	
	public interface Profesor{}
	
	public int getProfesorId() {
		return profesorId;
	}
	
	public void setProfesorId(int profesorId) {
		this.profesorId = profesorId;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApPaterno() {
		return apPaterno;
	}
	
	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}
	
	public String getApMaterno() {
		return apMaterno;
	}
	
	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String getNumTelefono() {
		return numTelefono;
	}
	
	public void setNumTelefono(String numTelefono) {
		this.numTelefono = numTelefono;
	}	
	
	/* --------------------------------------------------------------------------------- */
	
	public ProfesorBean obtenerProfesor(int profesorId) throws Exception{
		return profesorDao.obtenerProfesor(profesorId);
	}
	
	public List<ProfesorBean> obtenerProfesores() throws Exception{
		return profesorDao.obtenerProfesores();
	}
	
	public int agregarProfesor(ProfesorBean profesorBean) throws Exception{
		return profesorDao.agregarProfesor(profesorBean);
	}
	
	public int editarProfesor(ProfesorBean profesorBean) throws Exception{
		return profesorDao.editarProfesor(profesorBean);
	}
	
	public int eliminarProfesor(int profesorId) throws Exception{
		return profesorDao.eliminarProfesor(profesorId);
	}
}
