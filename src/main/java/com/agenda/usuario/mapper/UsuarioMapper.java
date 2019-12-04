package com.agenda.usuario.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.agenda.usuario.bean.UsuarioBean;

public class UsuarioMapper implements RowMapper<UsuarioBean>{

	@Override
	public UsuarioBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		UsuarioBean usuarioBean = new UsuarioBean();
		usuarioBean.setId(rs.getInt("nUsuario_id"));
		usuarioBean.setUsuario(rs.getString("sUsuario"));
		usuarioBean.setContrasena(rs.getString("sContrasena"));
		return usuarioBean;
	}		
}
