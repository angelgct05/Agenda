package com.agenda.materia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.agenda.materia.bean.MateriaBean;
import com.agenda.profesor.bean.ProfesorBean;

public class MateriaMapper implements RowMapper<MateriaBean>{
	public MateriaBean mapRow(ResultSet rs, int rowNum) throws SQLException{
		
		MateriaBean materiaBean = new MateriaBean();
		materiaBean.setProfesorBean(new ProfesorBean());
		materiaBean.setMateriaId(rs.getInt("nMateria_id"));
		materiaBean.setAbrev(rs.getString("sAbrev"));
		materiaBean.setCalificacion(rs.getByte("nCalificacion"));
		materiaBean.setColor(rs.getString("sColor"));
		materiaBean.getProfesorBean().setProfesorId(rs.getInt("nProfesor_id"));
		materiaBean.setNombre(rs.getString("sNombre"));
		materiaBean.setSemestre(rs.getByte("nSemestre"));
		
		return materiaBean;
	}
}
