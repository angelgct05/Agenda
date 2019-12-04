package com.agenda.usuario.dao;

import java.util.List;

import com.agenda.PlantillaDao;
import com.agenda.usuario.bean.UsuarioBean;
import com.agenda.usuario.mapper.UsuarioMapper;

public class UsuarioDao extends PlantillaDao{

	public UsuarioBean obtenerUsuarioPorId(int usuarioId) throws Exception{
		StringBuilder sql = new StringBuilder();
		sql.append("select * ");
		sql.append("from Usuario ");
		sql.append("where nUsuario_id = ?");
		
		return getJdbcTemplateObject().queryForObject(sql.toString(), new Object[] { usuarioId },
				new UsuarioMapper());
	}
	
	public UsuarioBean obtenerUsuario(String sUsuario) throws Exception{
		StringBuilder sql = new StringBuilder();
		sql.append("select * ");
		sql.append("from Usuario ");
		sql.append("where sUsuario = ?");
		
		return getJdbcTemplateObject().queryForObject(sql.toString(), new Object[] { sUsuario },
				new UsuarioMapper());
	}
	
	public List<UsuarioBean> obtenerUsuarios() throws Exception{
		StringBuilder sql = new StringBuilder();
		sql.append("select * ");
		sql.append("from Usuario");
		
		return getJdbcTemplateObject().query(sql.toString(), new UsuarioMapper());
	}
	
	public int agregarUsuario(UsuarioBean usuarioBean) throws Exception{
		StringBuilder sql = new StringBuilder();
		sql.append("insert into Usuario (sUsuario, sContrasena) ");
		sql.append("values (?, ?)");
		
		return getJdbcTemplateObject().update(sql.toString(), 
			usuarioBean.getUsuario(), 
			usuarioBean.getContrasena()
		);
	}
	
	public int editarUsuario(UsuarioBean usuarioBean) throws Exception{
		StringBuilder sql = new StringBuilder();
		sql.append("update Usuario set ");
		sql.append("sUsuario = ? ");
		sql.append("sContrasena = ?");
		
		return getJdbcTemplateObject().update(sql.toString(), 
				usuarioBean.getUsuario(), 
				usuarioBean.getContrasena()
		);
	}
	
	public int eliminarUsuario(int usuarioId) throws Exception{
		String sql = "delete from Usuario where nUsuario_id = ?";
		
		return getJdbcTemplateObject().update(sql, usuarioId);		
	}
}
