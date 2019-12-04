package com.agenda.tarea.bean;

import org.springframework.beans.factory.annotation.Autowired;

import com.agenda.Author;
import com.agenda.materia.bean.MateriaBean;
import com.agenda.tarea.dao.TareaDao;

@Author(
	name = "Angel Celestino", 
	createDate = "12/07/2019",
	modifyDate = "23/07/2019",
	lastChange = "edite el get de pjeObtenido"
)
//@SuppressWarnings("serial")
public class TareaBean {

	private int tareaId;
	@Autowired
	private MateriaBean materiaBean;
	private String nombre;
	private String descripcion;
	private String prioridad;
	private String fechaEntrega;
	private float calificacion;
	private float puntaje;
	private float puntajeObtenido;
	
	private TareaDao tareaDao;
	
	public int getTareaId() {
		return tareaId;
	}

	public void setTareaId(int tareaId) {
		this.tareaId = tareaId;
	}

	public MateriaBean getMateriaBean() {
		return materiaBean;
	}

	public void setMateriaBean(MateriaBean materiaBean) {
		this.materiaBean = materiaBean;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getPrioridad() {
		return prioridad;
	}
	
	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}
	
	public String getFechaEntrega() {
		return fechaEntrega;
	}
	
	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	
	public float getCalificacion() {
		return calificacion;
	}
	
	public void setCalificacion(float calificacion) {
		this.calificacion = calificacion;
	}
	
	public float getPuntaje() {
		return puntaje;
	}
	
	public void setPuntaje(float puntaje) {
		this.puntaje = puntaje;
	}
	
	public float getPuntajeObtenido() {
		puntajeObtenido = calificacion / (float)100 * puntaje; 
		return puntajeObtenido;
	}
	
	public void setPuntajeObtenido(float puntajeObtenido) {
		this.puntajeObtenido = puntajeObtenido;
	}
	
	/* --------------------------------------------------------------------------------- */
	
	public TareaBean obtenerTarea(int tareaId) throws Exception{
		return tareaDao.obtenerTarea(tareaId);
	}
	
	public int agregarTarea(TareaBean tareaBean) throws Exception{
		return tareaDao.agregarTarea(tareaBean);
	}
	
	public int editarTarea(TareaBean tareaBean) throws Exception{
		return tareaDao.editarTarea(tareaBean);
	}
	
	public int eliminarTarea(int tareaId) throws Exception{
		return tareaDao.eliminarTarea(tareaId);
	}
}

