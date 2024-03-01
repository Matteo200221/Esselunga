package esselunga.rest;

import java.util.List;

import javax.persistence.NoResultException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import esselunga.ejb.interfaces.UtenteEjbInterface;
import esselunga.jpa.eccezzioni.EsselungaException;
import esselunga.jpa.models.Utente;
import esselunga.rest.config.EJBFactory;

@Path("utenteRest")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UtenteRest {

	private UtenteEjbInterface utenteEjbInterface;
	
	@GET
	@Path("/getListaUtenti")
	public Response findAll() {
		
		System.out.println("Stampo lista utenti");
		
		try {
			
			utenteEjbInterface = new EJBFactory<UtenteEjbInterface>(UtenteEjbInterface.class).getEJB();
			List<Utente> listaUtenti = utenteEjbInterface.findAll();
			
			return Response.ok().entity(listaUtenti).build();
			
		} catch (EsselungaException ee) {

			ee.printStackTrace();
			return Response.serverError().build();
		
		} catch (Exception e) {
			
			e.printStackTrace();	
			return Response.serverError().build();
		}
		
	}
	
	@GET
	@Path("/getListaUtentiByProdotti")
	public Response findAllByProdotti() {
		
		System.out.println("findAllByProdotti");
		try {
			
			utenteEjbInterface = new EJBFactory<UtenteEjbInterface>(UtenteEjbInterface.class).getEJB();
			List<Utente> listaUtenti = utenteEjbInterface.findAllByProdotti();
			
			return Response.ok().entity(listaUtenti).build();
			
		} catch (EsselungaException ee) {
			
			ee.printStackTrace();
			return Response.serverError().build();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return Response.serverError().build();
		}
		
	}
	
	@GET
	@Path("/getListaUtentiByProdottiId/{idProdotto}")
	public Response findUtentiByProdottoId(@PathParam("idProdotto") Integer id) {
		
		System.out.println("Stampo findUtentiByProdottoId");
		
		try {
			
			utenteEjbInterface = new EJBFactory<UtenteEjbInterface>(UtenteEjbInterface.class).getEJB();
			List<Utente> listaUtenti = utenteEjbInterface.findUtentiByProdottoId(id);
			
			return Response.ok().entity(listaUtenti).build();
			
		} catch (EsselungaException ee) {
		
			ee.printStackTrace();
			return Response.serverError().build();
		} catch (Exception e) {
			
			e.printStackTrace();
			return Response.serverError().build();
		}
		
		
	}
	
	@GET
	@Path("/getUtenteById/{idUtente}")
	public Response findById(@PathParam("idUtente") Integer id) {
		
		System.out.println("Stampo findById utente");
		
		try {
			
			utenteEjbInterface = new EJBFactory<UtenteEjbInterface>(UtenteEjbInterface.class).getEJB();
			Utente utente = utenteEjbInterface.findById(id);
			
			return Response.ok().entity(utente).build();
			
		} catch (EsselungaException ee) {

			ee.printStackTrace();
			return Response.serverError().build();
			
		} catch (Exception e) {

			e.printStackTrace();
			return Response.serverError().build();
		}
		
	}
	
	@POST
	@Path("/utenteInsert")
	public Response insert(Utente utente) {
		
		System.out.println("Insert utente");
		
		try {
			
			utenteEjbInterface = new EJBFactory<UtenteEjbInterface>(UtenteEjbInterface.class).getEJB();
			utenteEjbInterface.insert(utente);
			
			return Response.status(Status.CREATED).entity(utente).build();
			
		} catch (Exception e) {
			
			e.printStackTrace();	
		}
		
		return Response.serverError().build();
	}
	
	@PUT
	@Path("/utenteUpdate")
	public Response update(Utente utente) {
		
		System.out.println("update utente");
		
		try {
			
			utenteEjbInterface = new EJBFactory<UtenteEjbInterface>(UtenteEjbInterface.class).getEJB();
			utenteEjbInterface.update(utente);
			
			return Response.status(Status.CREATED).entity(utente).build();
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return Response.serverError().build();
	}
	
	@DELETE
	@Path("/utenteDelete")
	public Response delete(Utente utente) {
		
		System.out.println("Delete Utente");
		
		try {
			
			utenteEjbInterface = new EJBFactory<UtenteEjbInterface>(UtenteEjbInterface.class).getEJB();
			utenteEjbInterface.delete(utente);
			
			return Response.noContent().build();
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return Response.serverError().build();
	}
	
	@GET
	@Path("/getUtenteLogin/{email}/{password}")
	public Response login(@PathParam("email") String email, @PathParam("password") String password) throws NoResultException {
		
		System.out.println("login");
		
		try {
			
			utenteEjbInterface = new EJBFactory<UtenteEjbInterface>(UtenteEjbInterface.class).getEJB();
			Utente utente = utenteEjbInterface.login(email, password);
			
			return Response.ok().entity(utente).build();
			
		} catch (EsselungaException ee) {
			
			ee.printStackTrace();
			return Response.serverError().build();
		
		} catch (Exception e) {
			
			e.printStackTrace();
			return Response.serverError().build();
		}
		
	}
	
	@GET
	@Path("/getDatiUtenteProdotto")
	public Response findAllDatiUtenteProdotto() {
		
		System.out.println("findAllDatiUtenteProdotto di UtenteRest");
		try {
			utenteEjbInterface = new EJBFactory<UtenteEjbInterface>(UtenteEjbInterface.class).getEJB();
			List<Utente> datiTrovati = utenteEjbInterface.findAllDatiUtenteProdotto();
			
			return Response.ok(datiTrovati).build();
			
		} catch (EsselungaException ee) {
			
			System.out.println(ee.getMessaggio());
			ee.printStackTrace();
			return Response.serverError().build();
			
		} catch(Exception e) {
			
			e.printStackTrace();
			return Response.serverError().build();	
		}
		
	}
	
}
