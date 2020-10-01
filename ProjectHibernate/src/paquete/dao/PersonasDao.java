package paquete.dao;

import java.util.List;

import paquete.entity.Persona;

public interface PersonasDao {
	
	public List<Persona> listar();
	
	public int extraerMax();
	
	public int extraerMin();
	
	public long countPersonas();
	
	public Persona extraerPorId(Persona per);
	
	public void insertarPersona(Persona per);
	
	public void modificarPersona(Persona per);
	
	public void eliminarPersona(Persona per);

}
