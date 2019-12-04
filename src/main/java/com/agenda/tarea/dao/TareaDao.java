package com.agenda.tarea.dao;

import com.agenda.Author;
import com.agenda.PlantillaDao;
import com.agenda.tarea.bean.TareaBean;
import com.agenda.tarea.mapper.TareaMapper;

@Author(
	name = "Angel Celestino",
	createDate = "19/07/2019"
)
public class TareaDao extends PlantillaDao{

	public TareaBean obtenerTarea(int tareaId) throws Exception{
		StringBuilder sql = new StringBuilder();		
		sql.append("select * ");
		sql.append("from Tarea ");
		sql.append("where nTarea_id = ?");
		
		return getJdbcTemplateObject().queryForObject(sql.toString(), new Object[] { tareaId }, 
				new TareaMapper());
	}
	
	public int agregarTarea(TareaBean tareaBean) throws Exception{
		StringBuilder sql = new StringBuilder();		
		sql.append("insert into Tarea ");
		sql.append("(nCalificacion, sDescripcion, dFchEntrega, ");
		sql.append("nMateria_id, sNombre, sPrioridad, nPuntaje, ");
		sql.append("nPuntajeObtenido) values ");
		sql.append("(?, ?, ?, ?, ?, ?, ?, ?)");
		
		return getJdbcTemplateObject().update(sql.toString(), tareaBean.getCalificacion(), 
				tareaBean.getDescripcion(), tareaBean.getFechaEntrega(), 
				tareaBean.getMateriaBean().getMateriaId(), tareaBean.getNombre(),
				tareaBean.getPrioridad(), tareaBean.getPuntaje(),
				tareaBean.getPuntajeObtenido());
	}
	
	public int editarTarea(TareaBean tareaBean) throws Exception{
		StringBuilder sql = new StringBuilder();
		sql.append("update Tarea set ");
		sql.append("nCalificacion = ?, ");
		sql.append("sDescripcion = ?, ");
		sql.append("dFchEntrega = ?, ");
		sql.append("nMateria_id = ?, ");
		sql.append("sNombre = ?, ");
		sql.append("sPrioridad = ?, ");
		sql.append("nPuntaje = ?, ");
		sql.append("nPuntajeObtenido = ?");
		
		return getJdbcTemplateObject().update(sql.toString(), tareaBean.getCalificacion(), 
				tareaBean.getDescripcion(), tareaBean.getFechaEntrega(), 
				tareaBean.getMateriaBean().getMateriaId(), tareaBean.getNombre(),
				tareaBean.getPrioridad(), tareaBean.getPuntaje(),
				tareaBean.getPuntajeObtenido());	
	}
	
	public int eliminarTarea(int tareaId) throws Exception{
		String sql = "delete from Tarea where nTarea_id = ?";
		
		return getJdbcTemplateObject().update(sql, new Object[] { tareaId });
	}
}
