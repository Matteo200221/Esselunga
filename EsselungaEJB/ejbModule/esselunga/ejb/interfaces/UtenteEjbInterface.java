package esselunga.ejb.interfaces;

import java.util.List;

import javax.ejb.Local;

import esselunga.jpa.models.Utente;

@Local
public interface UtenteEjbInterface {

	List<Utente> findAll() throws Exception;
	
	Utente findById(Integer id) throws Exception;
	
	Utente insert(Utente model);
	
	Utente update(Utente model);
	
	void delete(Utente model);
	
	List<Utente> findAllByProdotti() throws Exception;
	
	List<Utente> findUtentiByProdottoId(Integer id) throws Exception;
	
	Utente login(String email, String password) throws Exception;
	
	List<Utente> findAllDatiUtenteProdotto() throws Exception;
	
	String findEmail(String email) throws Exception;
}
