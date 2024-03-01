package esselunga.ejb.controllers;

import java.io.Serializable;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

import esselunga.ejb.interfaces.UtenteEjbInterface;
import esselunga.jpa.dao.UtenteDao;
import esselunga.jpa.eccezzioni.EsselungaException;
import esselunga.jpa.models.Utente;

@Stateless(name="UtenteEjbInterface")
@LocalBean
public class UtenteEjb implements Serializable, UtenteEjbInterface{

	private static final long serialVersionUID = -1449442866644241177L;

	@Override
	public List<Utente> findAll() throws Exception {
		
		UtenteDao utenteDao = new UtenteDao();
		
		try {
			
			List<Utente> listaUtenti = utenteDao.findAll();
			
			return listaUtenti;
			
		} catch (EsselungaException ee) {
			
			throw new EsselungaException(ee.getMessage());
			
		} catch (Exception e) {
			
			throw new Exception("Errore generico");
		}
	}

	@Override
	public Utente findById(Integer id) throws Exception {
		
		UtenteDao utenteDao = new UtenteDao();
		
		try {
			
			Utente utente = utenteDao.findById(id);
			
			return utente;
		
		} catch (EsselungaException ee) {
			
			throw new EsselungaException(ee.getMessage());
			
		} catch (Exception e) {
			
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Utente insert(Utente model) {

		UtenteDao utenteDao = new UtenteDao();
		
		Utente utente = utenteDao.insert(model);
		
		return utente;
	}

	@Override
	public Utente update(Utente model) {

		UtenteDao utenteDao = new UtenteDao();
		
		Utente utente = utenteDao.update(model);
		
		return utente;
	}

	@Override
	public void delete(Utente model) {

		UtenteDao utenteDao = new UtenteDao();
		utenteDao.delete(model);
	}

	@Override
	public List<Utente> findAllByProdotti() throws Exception {
		
		UtenteDao utenteDao = new UtenteDao();
		
		try {
			
			List<Utente> listaUtenti = utenteDao.findAllByProdotti();
			return listaUtenti;
		
		} catch (EsselungaException ee) {

			throw new EsselungaException(ee.getMessage());
			
		} catch (Exception e) {
			
			throw new Exception(e.getMessage());
		}
			
	}

	@Override
	public List<Utente> findUtentiByProdottoId(Integer id) throws Exception {

		UtenteDao utenteDao = new UtenteDao();
		
		try {
			
			List<Utente> listaUtenti = utenteDao.findUtentiByProdottoId(id);
			return listaUtenti;
			
		} catch (EsselungaException ee) {

			throw new EsselungaException(ee.getMessage());
			
		} catch (Exception e) {

			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Utente login(String email, String password) throws Exception {

		UtenteDao utenteDao = new UtenteDao();
		try {
			Utente utente = utenteDao.login(email, password);
			
			return utente;
			
		} catch(EsselungaException ee) {
			
			throw new NoResultException(ee.getMessage());
		}
		catch (Exception e) {
			throw new Exception("errore generico");
		}
		
		
	}

	@Override
	public List<Utente> findAllDatiUtenteProdotto() throws Exception {
		
		UtenteDao utenteDao = new UtenteDao();
		
		try {
			
			return utenteDao.findAllDatiUtenteProdotto();
			
		} catch (EsselungaException ee) {

			throw new EsselungaException(ee.getMessage());
			
		} catch (Exception e) {
			
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public String findEmail(String email) throws Exception {
		
		UtenteDao utenteDao = new UtenteDao();
		
		try {
			
			return utenteDao.findEmail(email);
			
		} catch (EsselungaException ee) {

			throw new EsselungaException(ee.getMessage());
			
		} catch (Exception e) {

			throw new Exception(e.getMessage());
		}
	}

}
