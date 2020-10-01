package paquete.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import paquete.entity.Usuario;

public class UsuariosDaoImpl implements UsuariosDao{
	
	private static Logger log = LogManager.getLogger(PersonasDaoImpl.class);

	private EntityManagerFactory emf;
	private EntityManager em;

	public UsuariosDaoImpl() {
		this.emf = Persistence.createEntityManagerFactory("ProjectHibernate");
		this.em = emf.createEntityManager();
	}

	public void listar() {

		Query query = em.createQuery("SELECT u FROM Usuario u");
		@SuppressWarnings("unchecked")
		List<Usuario> usuarios = query.getResultList();
		for (Usuario u : usuarios) {
			log.info(u);
		}
		System.out.println();
	}

	public void extraerPorId(Usuario usr) {
		Usuario usrOut = em.find(Usuario.class, usr.getIdUsuario());
		System.out.println(usrOut);
		System.out.println();
	}

	public void insertarUsuario(Usuario usr) {

		try {
			em.getTransaction().begin(); // Iniciar transacción, esto en caso que no se despliegue en un servidor de
											// aplicaciones.
			em.persist(usr);
			em.getTransaction().commit();
			System.out.println("Usuario ingresado exitosamente");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(e);
		}
	}

	public void modificarUsuario(Usuario usr) {

		try {
			em.getTransaction().begin(); // Iniciar transacción, esto en caso que no se despliegue en un servidor de
											// aplicaciones.
			em.merge(usr);
			em.getTransaction().commit();
			System.out.println("Usuario modificado exitosamente");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(e);
		}
	}

	public void eliminarUsuario(Usuario usr) {

		em.getTransaction().begin();
		Usuario usrDelete = em.find(Usuario.class, usr.getIdUsuario());
		em.remove(usrDelete);
		em.getTransaction().commit();
		System.out.println("Usuario con ID : " + usr.getIdUsuario() + " eliminada exitosamente");
	}

}
