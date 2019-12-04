package com.agenda.materia.bean;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;

import com.agenda.materia.dao.MateriaDao;
import com.agenda.profesor.bean.ProfesorBean;


public class MateriaBean{
	
	private int materiaId;
	
	
	@Size(max = 5, groups = { MateriaBean.Materia.class })
	@NotEmpty(groups = { MateriaBean.Materia.class })
	private String abrev;
	
	
	@Size(max = 30, groups = { MateriaBean.Materia.class })
	@NotEmpty(groups = { MateriaBean.Materia.class })
	private String nombre;
	
	
	private float calificacion;
	

	private byte semestre;
	
	
	@Size(max = 7, groups = { MateriaBean.Materia.class })
	private String color;	
	
	@Autowired
	@Valid
	private ProfesorBean profesorBean; //FK
	
	@Autowired
	private MateriaDao materiaDao;
	
	
	public interface Materia{}
	
	public int getMateriaId() {
		return materiaId;
	}

	public void setMateriaId(int materiaId) {
		this.materiaId = materiaId;
	}

	public String getAbrev() {
		return abrev;
	}

	public void setAbrev(String abrev) {
		this.abrev = abrev;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public float getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(float calificacion) {
		this.calificacion = calificacion;
	}

	public byte getSemestre() {
		return semestre;
	}

	public void setSemestre(byte semestre) {
		this.semestre = semestre;
	}

	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}

	public ProfesorBean getProfesorBean() {
		return profesorBean;
	}

	public void setProfesorBean(ProfesorBean profesorBean) {
		this.profesorBean = profesorBean;
	}	
	
	/* --------------------------------------------------------------------------------- */
	
	public MateriaBean obtenerMateria(int materiaId) throws Exception{
		return materiaDao.obtenerMateria(materiaId);
	}
	
	public List<MateriaBean> obtenerMaterias() throws Exception{
		return materiaDao.obtenerMaterias();
	}
	
	public int agregarMateria(MateriaBean materiaBean) throws Exception{
		return materiaDao.agregarMateria(materiaBean);
	}
	
	public int editarMateria(MateriaBean materiaBean) throws Exception{
		return materiaDao.editarMateria(materiaBean);
	}
	
	public int eliminarMateria(int materiaId) throws Exception{
		return materiaDao.eliminarMateria(materiaId);
	}
}
