package paquete.test;

import java.util.List;

import paquete.entity.Persona;
import paquete.negocio.PersonasBusinessImpl;
import paquete.negocio.PersonasBusinessRemote;

public class Test {

	public static void main(String[] args) {
		
		PersonasBusinessRemote perBus = new PersonasBusinessImpl();
		//List<Persona> personas = perBus.listar();
		
		//for (Persona p : personas) {
		//	System.out.println(p);
		//}
		//System.out.println();
		
		//long count = perBus.countPersonas();
		//System.out.println(count);
		
		Persona per = new Persona();
		per.setIdPersona(18);
		per.setNombre("Prueba");
		per.setApellido("Prueba");
		per.setRut("Prueba");
		
		perBus.insertarPersona(per);
	}

}
