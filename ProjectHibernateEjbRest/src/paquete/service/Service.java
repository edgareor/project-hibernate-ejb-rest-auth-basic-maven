package paquete.service;

import java.text.DateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import paquete.entity.Persona;
import paquete.negocio.PersonasBusinessImpl;
import paquete.negocio.PersonasBusinessRemote;

@Path("")
public class Service {
	
	PersonasBusinessRemote ejb = new PersonasBusinessImpl();

	@GET
	@Path("/timenow")
	@Produces({ "application/json" })
	public JsonObject getStatus(@HeaderParam("Authorization") String authString) throws Exception {
		
		String token = authString.substring(6);
		
		byte[] decodedBytes = Base64.getDecoder().decode(token);
		String decodedString = new String(decodedBytes);
		
		String [] arr = decodedString.split(":");
		for (String cad : arr) {
			System.out.println(cad);
		}

		Date fecha = new Date();
		Locale currentLocale = new Locale("EN");
		DateFormat formato = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.MEDIUM, currentLocale);
		String output = formato.format(fecha);
		JsonObject object = Json.createObjectBuilder().add("getStatus", output).build();

		return object;
	}
	
	@GET
	@Path("/personas")
	@Produces({ "application/json" })
	public Response getAllPersonas() throws Exception {

		List<Persona> personas = ejb.listar();
		
		JsonObject object = Json.createObjectBuilder().add("data", Json.createObjectBuilder().add("personas", personas.toString())).build();
		
		return Response.status(200).entity(object).build();
	}
	
	@GET
	@Path("/max")
	@Produces({ "application/json" })
	public JsonObject getMax() throws Exception {

		int personas = ejb.extraerMax();
		JsonObject object = Json.createObjectBuilder().add("data", Json.createObjectBuilder().add("maximoId", personas)).build();
		return object;
	}
	
	@GET
	@Path("/min")
	@Produces({ "application/json" })
	public JsonObject getMin() throws Exception {

		int personas = ejb.extraerMin();
		
		JsonObject object = Json.createObjectBuilder().add("data", Json.createObjectBuilder().add("minimoId", personas)).build();
		return object;
	}
	
	@GET
	@Path("/count")
	@Produces({ "application/json" })
	public JsonObject getCount() throws Exception {

		long personas = ejb.countPersonas();
		
		JsonObject object = Json.createObjectBuilder().add("data", Json.createObjectBuilder().add("numeroPersonas", personas)).build();
		return object;
	}
	
	@GET
	@Path("/personas/{id}")
	@Produces({ "application/json" })
	public Response getPersonaById(@PathParam("id") int id ) throws Exception {

		Persona per = new Persona();
		per.setIdPersona(id);
		
		Persona perOut = ejb.extraerPorId(per);
		
		JsonObject object = Json.createObjectBuilder().add("data", Json.createObjectBuilder().add("message", perOut.toString())).build();
		return Response.ok().entity(object).build();
	}
	
	@POST
	@Path("/personas")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public Response ingresarPersona(Persona per) throws Exception {
		
		ejb.insertarPersona(per);
		
		JsonObject object = Json.createObjectBuilder().add("data", Json.createObjectBuilder().add("message", "Persona: "+per+ ", ingresada exitosamente")).build();
		return Response.ok().entity(object).build();
	}
	
	@PUT
	@Path("/personas")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public Response modificarPersona(Persona per) throws Exception {
		
		ejb.modificarPersona(per);
		
		JsonObject object = Json.createObjectBuilder().add("data", Json.createObjectBuilder().add("message", "Persona: "+per+ ", modificada exitosamente")).build();
		return Response.ok().entity(object).build();
	}
	
	@DELETE
	@Path("/personas/{id}")
	@Produces({ "application/json" })
	public Response deletePersona(@PathParam("id") int id ) throws Exception {

		Persona per = new Persona();
		per.setIdPersona(id);
		
		ejb.eliminarPersona(per);
		
		JsonObject object = Json.createObjectBuilder().add("data", Json.createObjectBuilder().add("message", "Persona con ID: "+id+ ", eliminada exitosamente")).build();
		return Response.ok().entity(object).build();
	}

}
