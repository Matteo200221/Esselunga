package esselunga.ejb.controllers;

import java.io.Serializable;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

import esselunga.ejb.interfaces.ProdottoEjbInterface;
import esselunga.jpa.dao.ProdottoDao;
import esselunga.jpa.eccezzioni.EsselungaException;
import esselunga.jpa.models.Prodotto;

@Stateless(name="ProdottoEjbInterface")
@LocalBean
public class ProdottoEjb implements ProdottoEjbInterface, Serializable{

	private static final long serialVersionUID = -1777842390135702217L;

	@Override
	public Prodotto insert(Prodotto prodotto) {
		
		ProdottoDao prodottoDao = new ProdottoDao();
		
		return prodottoDao.insert(prodotto);
	}

	@Override
	public Prodotto update(Prodotto prodotto) {
		
		ProdottoDao prodottoDao = new ProdottoDao();
		
		return prodottoDao.update(prodotto);
	}

	@Override
	public void delete(Prodotto prodotto) {
		
		ProdottoDao prodottoDao = new ProdottoDao();
		prodottoDao.delete(prodotto);
	}

	@Override
	public Prodotto findById(Integer id) throws Exception {
		
		ProdottoDao prodottoDao = new ProdottoDao();
		
		try {
			return prodottoDao.findById(id);
		} catch (NoResultException e) {
			e.printStackTrace();
			throw new EsselungaException(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<Prodotto> findAll() throws Exception {
		
		ProdottoDao prodottoDao = new ProdottoDao();
		
		try {
			return prodottoDao.findAll();
		} catch (EsselungaException e) {
			e.printStackTrace();
			throw new EsselungaException(e.getMessage());
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("errore generico");
		}
	}

	@Override
	public List<Prodotto> findAllByUtenti() throws Exception {
		
		ProdottoDao prodottoDao = new ProdottoDao();
		
		try {
			return prodottoDao.findAllByUtenti();
		} catch (EsselungaException e) {
			e.printStackTrace();
			throw new EsselungaException(e.getMessage());
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("errore generico");
		}
	}

	@Override
	public List<Prodotto> findAllByIdUtente(Integer idUtente) throws Exception {
		
		ProdottoDao prodottoDao = new ProdottoDao();
		
		try {
			return prodottoDao.findAllByIdUtente(idUtente);
		} catch (EsselungaException e) {
			e.printStackTrace();
			throw new EsselungaException(e.getMessage());
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("errore generico");
		}
	}

	@Override
	public List<Prodotto> findAllDati() throws Exception {

		ProdottoDao prodottoDao = new ProdottoDao();
		
		try {
			return prodottoDao.findAllDati();
		} catch (EsselungaException e) {
			e.printStackTrace();
			throw new EsselungaException(e.getMessage());
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("errore generico");
		}

	}

}
