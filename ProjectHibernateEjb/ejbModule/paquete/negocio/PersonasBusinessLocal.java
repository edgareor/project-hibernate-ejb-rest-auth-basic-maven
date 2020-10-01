package paquete.negocio;

import java.util.List;

import javax.ejb.Local;

import paquete.entity.Persona;

@Local
public interface PersonasBusinessLocal {
	
	public String test();

	public List<Persona> listar();
	
	public int extraerMax();
	
	public int extraerMin();
	
	public long countPersonas();
	
	public Persona extraerPorId(Persona per);
	
	public void insertarPersona(Persona per);
	
	public void modificarPersona(Persona per);
	
	public void eliminarPersona(Persona per);
	
}
