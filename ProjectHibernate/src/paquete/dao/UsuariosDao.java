package paquete.dao;

import paquete.entity.Usuario;

public interface UsuariosDao {
	
	public void listar();
	
	public void extraerPorId(Usuario usr);
	
	public void insertarUsuario(Usuario usr);
	
	public void modificarUsuario(Usuario usr);
	
	public void eliminarUsuario(Usuario usr);
}
