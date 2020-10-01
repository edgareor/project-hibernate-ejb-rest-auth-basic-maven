package paquete.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import paquete.entity.Persona;

@Stateless
public class PersonasDaoImpl implements PersonasDao{
	
	private static Logger log = LogManager.getLogger(PersonasDaoImpl.class);

	private EntityManagerFactory emf;
	private EntityManager em;

	public PersonasDaoImpl() {
		this.emf = Persistence.createEntityManagerFactory("ProjectHibernate");
		this.em = emf.createEntityManager();
	}

	public List<Persona> listar() {

		Query query = em.createQuery("SELECT p FROM Persona p");
		@SuppressWarnings("unchecked")
		List<Persona> personas = (List<Persona>) query.getResultList();
		log.info("Listar Personas");
		return personas;
	}
	
	public int extraerMax() {
		Query query = em.createQuery("SELECT max(p.idPersona) FROM Persona p");
		int per = (int) query.getSingleResult();
		return per;
	}
	
	public int extraerMin() {
		Query query = em.createQuery("SELECT min(p.idPersona) FROM Persona p");
		int per = (int) query.getSingleResult();
		return per;
	}
	
	public long countPersonas() {
		Query query = em.createQuery("SELECT count(p.idPersona) FROM Persona p");
		long per = (long) query.getSingleResult();
		return per;
	}

	public Persona extraerPorId(Persona per) {
		Persona perOut = em.find(Persona.class, per.getIdPersona());
		return perOut;
	}

	public void insertarPersona(Persona per) {

		try {
			em.getTransaction().begin(); // Iniciar transacción, esto en caso que no se despliegue en un servidor de
											// aplicaciones.
			em.persist(per);
			em.getTransaction().commit();
			System.out.println("Persona ingresada exitosamente");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(e);
		}
	}

	public void modificarPersona(Persona per) {

		try {
			em.getTransaction().begin(); // Iniciar transacción, esto en caso que no se despliegue en un servidor de
											// aplicaciones.
			em.merge(per);
			em.getTransaction().commit();
			System.out.println("Persona modificada exitosamente");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(e);
		}
	}

	public void eliminarPersona(Persona per) {

		em.getTransaction().begin();
		Persona perDelete = em.find(Persona.class, per.getIdPersona());
		em.remove(perDelete);
		em.getTransaction().commit();
		System.out.println("Persona con ID : " + per.getIdPersona() + " eliminada exitosamente");
	}

}
