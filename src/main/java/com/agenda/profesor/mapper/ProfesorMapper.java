package com.agenda.profesor.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.agenda.Author;
import com.agenda.profesor.bean.ProfesorBean;

@Author(
	name = "Angel Celestino",
	createDate = "19/07/2019"
)
public class ProfesorMapper implements RowMapper<ProfesorBean>{
	
	public ProfesorBean mapRow(ResultSet rs, int rowNum) throws SQLException{
		ProfesorBean profesorBean = new ProfesorBean();
		profesorBean.setApMaterno(rs.getString("sApMaterno"));
		profesorBean.setApPaterno(rs.getString("sApPaterno"));
		profesorBean.setCorreo(rs.getString("sCorreo"));
		profesorBean.setNombre(rs.getString("sNombre"));
		profesorBean.setNumTelefono(rs.getString("sNumTelefono"));
		profesorBean.setProfesorId(rs.getInt("nProfesor_id"));
		
		return profesorBean;
	}
}
