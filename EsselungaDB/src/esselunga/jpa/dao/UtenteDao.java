package esselunga.jpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import esselunga.jpa.connection.EntityManagerProvider;
import esselunga.jpa.eccezzioni.EsselungaException;
import esselunga.jpa.models.Utente;

public class UtenteDao extends BaseDao<Utente> {

	@Override
	public Utente insert(Utente model) {
		
		logInit("insert", model);
		try {
			
			EntityManagerProvider.beginTransaction();
			
			if(!getEntityManager().contains(model)) {
				
				model = getEntityManager().merge(model);
				
			}
			
			getEntityManager().persist(model);
			EntityManagerProvider.commitTransaction();
			
			return model;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			EntityManagerProvider.rollbackTransaction();
			
		} finally {
			
			getEntityManager().close();
		}
		return null;
	}

	@Override
	public Utente update(Utente model) {
		
		logInit("update", model);
		try {
			
			EntityManagerProvider.beginTransaction();
			getEntityManager().merge(model);
			EntityManagerProvider.commitTransaction();
			
			return model;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			EntityManagerProvider.rollbackTransaction();
			
		} finally {
			
			getEntityManager().close();
		}
		return null;
	}

	@Override
	public void delete(Utente model) {
		
		logInit("delete", model);

		try {
			
			EntityManagerProvider.beginTransaction();

			if(!getEntityManager().contains(model)) {
				
				model = getEntityManager().merge(model);
			}
			
			getEntityManager().remove(model);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			EntityManagerProvider.rollbackTransaction();
			
		} finally {
			
			getEntityManager().flush();
			getEntityManager().close();
			
		}
		  
	}

	@Override
	public Utente findById(Integer id) throws EsselungaException {
		
		logInit("findById", id);

		try {
			
			EntityManagerProvider.beginTransaction();
			Utente utenteTrovato = getEntityManager().find(Utente.class, id);
			
			if (utenteTrovato == null) {
				
				throw new EsselungaException("Elemento non trovato");
			}
			
			
			EntityManagerProvider.commitTransaction();
			
			return utenteTrovato;
			
		} catch (EsselungaException ee) {
			
			throw new EsselungaException(ee.getMessage());
			
		} catch (Exception e) {
			
			e.printStackTrace();
			EntityManagerProvider.rollbackTransaction();
			
		} finally {
			
			getEntityManager().close();
		}
		
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Utente> findAll() throws EsselungaException {
		
		logInit("findAll");

		try {
			
			EntityManagerProvider.beginTransaction();
			List<Utente> listaUtenti = new ArrayList<Utente>();
			
			//native query - SQL
			Query query = EntityManagerProvider.getEntityManager().createNativeQuery("SELECT * FROM utente", Utente.class);
			
			listaUtenti = query.getResultList();
			
			if (listaUtenti == null) {
				
				throw new EsselungaException("Elementi non trovati");
			}
			
			EntityManagerProvider.commitTransaction();
			
			return listaUtenti;
			
		} catch (EsselungaException ee) {
			
			throw new EsselungaException(ee.getMessage());
			
		} catch (Exception e) {
			
			e.printStackTrace();
			EntityManagerProvider.rollbackTransaction();
			
		} finally {
			
			getEntityManager().close();
			
		}
		return null;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Utente> findAllByProdotti() throws EsselungaException {
		
		logInit("findAllByProdotti");
		
		try {
			
			EntityManagerProvider.beginTransaction();
			List<Utente> listaUtenti = new ArrayList<Utente>();
			
			Query query = EntityManagerProvider.getEntityManager().createNativeQuery("select * from utente u " + 
																					"inner join carrello c on u.ID = c.ID_UTENTE" + 
																					" inner join prodotto p on p.ID = c.ID_PRODOTTO",
																					Utente.class);
			listaUtenti = query.getResultList();
			
			if (listaUtenti == null) {
			
				throw new EsselungaException("Elementi non trovati");
			}
			
			EntityManagerProvider.commitTransaction();
			
			return listaUtenti;
			
		} catch (EsselungaException ee) {
			
			throw new EsselungaException(ee.getMessage());

		} catch (Exception e) {
			
			e.printStackTrace();
			EntityManagerProvider.rollbackTransaction();
		} finally {
			
			getEntityManager().close();
		}
		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Utente> findUtentiByProdottoId(Integer id) throws EsselungaException {
		
		logInit("findUtentiByProdottoId");
		
		try {
			
			EntityManagerProvider.beginTransaction();
			List<Utente> listaUtenti = new ArrayList<Utente>();
			
			Query query = EntityManagerProvider.getEntityManager().createNativeQuery("select * from utente u " + 
																					"inner join carrello c on u.ID = c.ID_UTENTE" + 
																					" inner join prodotto p on p.ID = c.ID_PRODOTTO" + 
																					" where p.ID = " + id, Utente.class);
			listaUtenti = query.getResultList();
			
			if (listaUtenti.isEmpty()) {
				
				throw new EsselungaException("Elementi non trovati");
			}
			
			EntityManagerProvider.commitTransaction();
			
			return listaUtenti;
			
		} catch (EsselungaException ee) {

			throw new EsselungaException(ee.getMessage());
			
		} catch (Exception e) {
			
			e.printStackTrace();
			EntityManagerProvider.rollbackTransaction();
			
		} finally {
			
			getEntityManager().close();
		}
		
		return null;
	}
	
	public Utente login (String email, String password) throws NoResultException, EsselungaException {
		
		logInit("login");
		
		try {
			
			EntityManagerProvider.beginTransaction();
			Utente utente = new Utente();
			
			Query query = EntityManagerProvider.getEntityManager().createNativeQuery("select * from utente u "
																					+ "where u.EMAIL = ? "
																					+ "and PASSWORD = ?;", Utente.class);
			query.setParameter(1, email);
			query.setParameter(2, password);
			
			utente = (Utente) query.getSingleResult();
			
			EntityManagerProvider.commitTransaction();
			
			return utente;
			
		} catch(NoResultException nre) {
			
			throw new EsselungaException("Elemento non trovato");
			
		} catch (Exception e) {

			e.printStackTrace();
			EntityManagerProvider.rollbackTransaction();
			
		} finally {
			
			getEntityManager().close();
		}
		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Utente> findAllDatiUtenteProdotto() throws EsselungaException{
		
		logInit("findAllDatiUtenteProdotto");
		
		try {
			beginTransaction();
			Query query = getEntityManager().createNativeQuery("SELECT U.*, P.* FROM CARRELLO C "
					+ "INNER JOIN UTENTE U ON U.ID = C.ID_UTENTE "
					+ "INNER JOIN PRODOTTO P ON P.ID = C.ID_PRODOTTO", Utente.class);
			List<Utente> datiTrovati = query.getResultList();
			
			return datiTrovati;
			
		} catch (NoResultException nre) {

			throw new EsselungaException("Elementi non trovati");
			
		} catch(Exception e) {
			e.printStackTrace();
			
			return null;
		} finally {
			getEntityManager().close();
		}
	}
	
	public String findEmail(String email) throws EsselungaException{
		
		logInit("findEmail");
		
		String emailTrovata = null;
		try {
			beginTransaction();
			Query query = getEntityManager().createNativeQuery("SELECT EMAIL FROM UTENTE WHERE EMAIL = ?", Utente.class);
			query.setParameter(1, email);
			emailTrovata = (String) query.getSingleResult();
			
			return emailTrovata;
			
		} catch (NoResultException nre) {

			throw new EsselungaException("Elemento non trovato");
			
		} catch(Exception e) {
			e.printStackTrace();
			
			return null;
		} finally {
			getEntityManager().close();
		}
	}

}
