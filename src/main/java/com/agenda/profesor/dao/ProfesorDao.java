package com.agenda.profesor.dao;

import com.agenda.profesor.bean.ProfesorBean;
import com.agenda.profesor.mapper.ProfesorMapper;

import java.util.List;

import com.agenda.Author;
import com.agenda.PlantillaDao;

@Author(
	name = "Angel Celestino",
	createDate = "17/07/2019",
	modifyDate = "22/07/2019",
	lastChange = "agregue el delete que faltaba"
)
public class ProfesorDao extends PlantillaDao{
	
	public ProfesorBean obtenerProfesor(int profesorId) throws Exception{
		StringBuilder sql = new StringBuilder();
		
		sql.append("select * ");
		sql.append("from Profesor ");
		sql.append("where nProfesor_id = ?");
		
		return getJdbcTemplateObject().queryForObject(sql.toString(), new Object[] { profesorId }, 
				new ProfesorMapper());
	}
	
	public List<ProfesorBean> obtenerProfesores() throws Exception{
		StringBuilder sql = new StringBuilder();
		
		sql.append("select * ");
		sql.append("from Profesor");
		
		return  getJdbcTemplateObject().query(sql.toString(), new ProfesorMapper());
	}
	
	public int agregarProfesor(ProfesorBean profesorBean) throws Exception{
		StringBuilder sql = new StringBuilder();
		
		sql.append("insert into Profesor (sNombre, sApPaterno, sApMaterno, sCorreo, sNumTelefono) ");
		sql.append("values (?, ?, ?, ?, ?)");
		
		return getJdbcTemplateObject().update(sql.toString(), 
				profesorBean.getNombre(), 
				profesorBean.getApPaterno(), 
				profesorBean.getApMaterno(), 
				profesorBean.getCorreo(), 
				profesorBean.getNumTelefono()
		);
	}
	
	public int editarProfesor(ProfesorBean profesorBean) throws Exception{
		StringBuilder sql = new StringBuilder();
		
		sql.append("update Profesor set ");
		sql.append("sNombre = ?, ");
		sql.append("sApPaterno = ?, ");
		sql.append("sApMaterno = ?, ");
		sql.append("sCorreo = ?, ");
		sql.append("sNumTelefono = ? ");
		sql.append("where nProfesor_id = ?");
		
		return getJdbcTemplateObject().update(sql.toString(), 
				profesorBean.getNombre(), 
				profesorBean.getApPaterno(), 
				profesorBean.getApMaterno(), 
				profesorBean.getCorreo(), 
				profesorBean.getNumTelefono(), 
				profesorBean.getProfesorId()
		);
	}
	
	public int eliminarProfesor(int profesorId) throws Exception{
		String sql = "delete from Profesor where nProfesor_id =  ?";
		
		return getJdbcTemplateObject().update(sql, new Object[] { profesorId });
	}
}
