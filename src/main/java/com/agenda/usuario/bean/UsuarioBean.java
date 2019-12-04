package com.agenda.usuario.bean;

import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;

import com.agenda.usuario.dao.UsuarioDao;

public class UsuarioBean {
	
	//Alguna validacion, some
	private int id;
	
	@Size(max=20, message = "El usuario tiene un máximo de 20 caracteres.", groups = { UsuarioBean.Usuario.class })
	@NotEmpty(message = "El usuario no puede estar vacío.", groups = { UsuarioBean.Usuario.class })
	private String usuario;
	
	@Size(max=40, message = "La contraseña tiene un máximo de 40 caracteres.", groups = { UsuarioBean.Usuario.class })
	@NotEmpty(message = "La contraseña no puede estar vacía.", groups = { UsuarioBean.Usuario.class })
	private String contrasena;
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	public interface Usuario{}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getContrasena() {
		return contrasena;
	}
	
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}	
	
	
	/* --------------------------------------------------------------------------------------- */
	
	public UsuarioBean obtenerUsuarioPorId(Integer usuarioId) throws Exception{
		return usuarioDao.obtenerUsuarioPorId(usuarioId);
	}
	
	public UsuarioBean obtenerUsuario(String sUsuario) throws Exception{
		return usuarioDao.obtenerUsuario(sUsuario);
	}
	
	public List<UsuarioBean> obtenerUsuarios() throws Exception{
		return usuarioDao.obtenerUsuarios();
	}
	
	public int agregarUsuario(UsuarioBean usuarioBean) throws Exception{
		return usuarioDao.agregarUsuario(usuarioBean);
	}
	
	public int editarUsuario(UsuarioBean usuarioBean) throws Exception{
		return usuarioDao.editarUsuario(usuarioBean);
	}
	
	public int eliminarUsuario(Integer usuarioId) throws Exception{
		return usuarioDao.eliminarUsuario(usuarioId);
	}
}
