package com.agenda.tarea.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.agenda.Author;
import com.agenda.tarea.bean.TareaBean;;

@Author(
	name = "Angel Celestino",
	createDate = "19/07/2019"
)
public class TareaMapper implements RowMapper<TareaBean>{
	
	public TareaBean mapRow(ResultSet rs, int numRow) throws SQLException{
		TareaBean tareaBean = new TareaBean();
		tareaBean.setCalificacion(rs.getInt("nCalificacion"));
		tareaBean.setDescripcion(rs.getString("sDescripcion"));
		tareaBean.setFechaEntrega(rs.getString("dFchEntrega"));
		tareaBean.getMateriaBean().setMateriaId(rs.getInt("nMateria_id"));
		tareaBean.setNombre(rs.getString("sNombre"));
		tareaBean.setPrioridad(rs.getString("sPrioridad"));
		tareaBean.setPuntaje(rs.getFloat("nPuntaje"));
		tareaBean.setPuntajeObtenido(rs.getFloat("nPuntajeObtenido"));
		tareaBean.setTareaId(rs.getInt("nTarea_id"));
		
		return tareaBean;				
	}
}
