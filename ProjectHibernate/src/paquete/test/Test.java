package paquete.test;

import paquete.dao.PersonasDaoImpl;
import paquete.dao.UsuariosDaoImpl;
import paquete.entity.Persona;
import paquete.entity.Usuario;

public class Test {

	public static void main(String[] args) {
		
		PersonasDaoImpl perDao = new PersonasDaoImpl();
		//perDao.listar();
		//System.out.println();
		
		UsuariosDaoImpl usrDao = new UsuariosDaoImpl();
		//usrDao.listar();
		//System.out.println();
		
		Usuario usr = new Usuario();
		usr.setCorreo("prueba2@mail.com");
		usr.setPassword("testing");
		
		usrDao.insertarUsuario(usr);
		//usrDao.listar();
		
		Persona per = new Persona();
		per.setIdPersona(1);
		per.setNombre("Jehova");
		per.setApellido("Dios");
		per.setRut("1");
		//per.setUsuario(usr);
		
		perDao.insertarPersona(per);
		
		//perDao.modificarPersona(per);
		
		//perDao.extraerPorId(per);
		
		//perDao.eliminarPersona(per);
		
		// perDao.extraerMax();
		
		//perDao.countPersonas();
		
		//perDao.extraerMin();
		 
	}

}
