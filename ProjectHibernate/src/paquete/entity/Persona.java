package paquete.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="persona")
public class Persona implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8120410650816460561L;
	
	@Column(name="id_persona")	// Se agrega si existe diferencia entre el nombre de la columna y el nombre del atributo en Java.
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)	// Indica que la BD es la encargada de generar los IDs.
	private int idPersona;
	
	private String nombre;
	private String apellido;
	private String rut;
	
	@JoinColumn(name="id_usuario", referencedColumnName = "id_usuario")	// Primero se hace referencia al nombre de la columna de la tabla personas, y luego a la de la tabla usuario.
	@ManyToOne(cascade = CascadeType.ALL)
	private Usuario usuario;	// Debe ser de tipo entidad, en este caso "Usuario".
	
	public Persona() {}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getRut() {
		return rut;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido + ", rut=" + rut
				+ ", usuario=" + usuario + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idPersona;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (idPersona != other.idPersona)
			return false;
		return true;
	}
}
