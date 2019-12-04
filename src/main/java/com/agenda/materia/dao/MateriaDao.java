package com.agenda.materia.dao;

import com.agenda.materia.bean.MateriaBean;
import com.agenda.materia.mapper.MateriaMapper;

import java.util.List;

import com.agenda.Author;
import com.agenda.PlantillaDao;

@Author(
	name = "Angel Celestino", 
	createDate = "15/07/2019",
	modifyDate = "19/07/2019"
)
public class MateriaDao extends PlantillaDao{
	
	public MateriaBean obtenerMateria(int materiaId) throws Exception{
		StringBuilder sql = new StringBuilder();
		sql.append("select * "); 
		sql.append("from Materia "); 
		sql.append("where nMateria_id = ?");
		
		return getJdbcTemplateObject().queryForObject(sql.toString(), new Object[] { materiaId }, 
				new MateriaMapper());
	}
	
	
	public List<MateriaBean> obtenerMaterias() throws Exception{
		StringBuilder sql = new StringBuilder();
		sql.append("select * "); 
		sql.append("from Materia");
		
		return getJdbcTemplateObject().query(sql.toString(), new MateriaMapper());
	}
	
	
	public int agregarMateria(MateriaBean materiaBean) throws Exception{
		StringBuilder sql = new StringBuilder();
		sql.append("insert into Materia (sAbrev, sColor, sNombre, nSemestre) ");
		sql.append("values (?, ? , ?, ?)");
		
		return getJdbcTemplateObject().update(sql.toString(), 
			materiaBean.getAbrev(), 
			materiaBean.getColor(), 
			materiaBean.getNombre(), 
			materiaBean.getSemestre()
		);
	}
	
	public int editarMateria(MateriaBean materiaBean) throws Exception{
		StringBuilder sql = new StringBuilder();
		sql.append("update Materia set ");
		sql.append("sColor = ? ");
		sql.append("sNombre = ?");
		sql.append("sAbrev = ?");
		sql.append("nSemestre = ?");
		sql.append("nProfesor_id = ?");
		
		return getJdbcTemplateObject().update(sql.toString(), 
				materiaBean.getColor(), 
				materiaBean.getNombre(), 
				materiaBean.getAbrev(), 
				materiaBean.getSemestre(), 
				materiaBean.getProfesorBean().getProfesorId()
		);
	}
	
	public int eliminarMateria(int materiaId) throws Exception{
		String sql = "delete from Materia where nMateria_id = ?";
		
		return getJdbcTemplateObject().update(sql, materiaId);		
	}
}
