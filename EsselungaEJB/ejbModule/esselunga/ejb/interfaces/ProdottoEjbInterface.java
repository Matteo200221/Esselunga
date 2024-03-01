package esselunga.ejb.interfaces;

import java.util.List;

import javax.ejb.Local;

import esselunga.jpa.eccezzioni.EsselungaException;
import esselunga.jpa.models.Prodotto;

@Local
public interface ProdottoEjbInterface {

	Prodotto insert(Prodotto prodotto);
	
	Prodotto update(Prodotto prodotto);
	
	void delete(Prodotto prodotto);
	
	Prodotto findById(Integer id) throws EsselungaException, Exception;
	
	List<Prodotto> findAll() throws EsselungaException, Exception;
	
	List<Prodotto> findAllByUtenti() throws EsselungaException, Exception;
	
	List<Prodotto> findAllByIdUtente(Integer idUtente) throws EsselungaException, Exception;
	
	List<Prodotto> findAllDati() throws EsselungaException, Exception;
	
	
	
}
