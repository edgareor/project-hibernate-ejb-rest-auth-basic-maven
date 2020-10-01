package paquete.negocio;

import java.util.List;

import javax.ejb.Stateless;

import paquete.dao.PersonasDao;
import paquete.dao.PersonasDaoImpl;
import paquete.entity.Persona;

@Stateless(name="EjbHibernateImpl", mappedName="EjbHibernate")
public class PersonasBusinessImpl implements PersonasBusinessRemote, PersonasBusinessLocal{
	
	//@Inject
	PersonasDao perDao = new PersonasDaoImpl();
	
	public String test() {
		String out = "Hola desde Weblogic con JNDI";
		return out;
	}
	
	public List<Persona> listar() {
		return perDao.listar();
	}
	
	public int extraerMax() {
		return perDao.extraerMax();
	}
	
	public int extraerMin() {
		return perDao.extraerMin();
	}
	
	public long countPersonas() {
		return perDao.countPersonas();
	}

	public Persona extraerPorId(Persona per) {
		return perDao.extraerPorId(per);
	}

	public void insertarPersona(Persona per) {
		perDao.insertarPersona(per);
	}

	public void modificarPersona(Persona per) {
		perDao.modificarPersona(per);
	}

	public void eliminarPersona(Persona per) {
		perDao.eliminarPersona(per);
	}
}
