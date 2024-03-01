package esselunga.jpa.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import esselunga.jpa.eccezzioni.EsselungaException;
import esselunga.jpa.models.Prodotto;

public class ProdottoDao extends BaseDao<Prodotto>{

	@Override
	public Prodotto insert(Prodotto prodotto){
		
		logInit("insert", prodotto);
		try {
			beginTransaction();
			if(!getEntityManager().contains(prodotto)) {
				prodotto = getEntityManager().merge(prodotto);
			}
			getEntityManager().persist(prodotto);
			commitTransaction();
			
			return prodotto;
		} catch (Exception e) {
			e.printStackTrace();
			rollbackTransaction();
			
			return null;
		} finally {
			getEntityManager().close();
		}
	}

	@Override
	public Prodotto update(Prodotto prodotto) {
		
		logInit("update", prodotto);
		try {
			beginTransaction();
			if(!getEntityManager().contains(prodotto)) {
				prodotto = getEntityManager().merge(prodotto);
			}
			getEntityManager().persist(prodotto);
			commitTransaction();
			
			return prodotto;
		} catch(Exception e) {
			e.printStackTrace();
			rollbackTransaction();
			
			return null;
		} finally {
			getEntityManager().close();
		}
	}

	@Override
	public void delete(Prodotto prodotto) {
		
		logInit("delete", prodotto);
		try {
			beginTransaction();
			if(!getEntityManager().contains(prodotto)) {
				prodotto = getEntityManager().merge(prodotto);
			}
			getEntityManager().remove(prodotto);
			commitTransaction();
		} catch(Exception e) {
			e.printStackTrace();
			rollbackTransaction();
		} finally {
			getEntityManager().flush();
			getEntityManager().close();
		}
	}

	@Override
	public Prodotto findById(Integer id) throws NoResultException, EsselungaException{
		
		logInit("findById", id);
		
		try {
			beginTransaction();
			Prodotto prodottoTrovato = getEntityManager().find(Prodotto.class, id);
			if(prodottoTrovato == null) {
				System.out.println("findbyId di ProdottoDao");
				throw new EsselungaException("elemento non trovato");
			}
			return prodottoTrovato;
		} catch(EsselungaException ee) {
			ee.printStackTrace();
			
			throw new EsselungaException(ee.getMessage());
		} catch(Exception e) {
			e.printStackTrace();
			
			return null;
		} finally {
			getEntityManager().close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Prodotto> findAll() throws EsselungaException {
		
		logInit("findAll", null);
		
		try {
			beginTransaction();
			Query query = getEntityManager().createNativeQuery("SELECT * FROM PRODOTTO", Prodotto.class);
			List<Prodotto> prodottiTrovati = query.getResultList();
			
			return prodottiTrovati;
		} catch(NoResultException nre) {
			throw new EsselungaException("elementi non trovati");
		} catch(Exception e) {
			e.printStackTrace();
			
			return null;
		} finally {
			getEntityManager().close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Prodotto> findAllByUtenti() throws EsselungaException{
		
		logInit("findAllByUtenti", null);
		
		try {
			beginTransaction();
			Query query = getEntityManager().createNativeQuery("SELECT * FROM PRODOTTO P"
					+ " INNER JOIN CARRELLO C ON P.ID = C.ID_PRODOTTO"
					+ " INNER JOIN UTENTE U ON U.ID = C.ID_UTENTE", Prodotto.class);
			List<Prodotto> prodottiUtenti = query.getResultList();
			
			return prodottiUtenti;
		} catch(NoResultException nre) {
			nre.printStackTrace();
			throw new EsselungaException("elementi non trovati");
		} catch(Exception e) {
			e.printStackTrace();
			
			return null;
		} finally {
			getEntityManager().close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Prodotto> findAllByIdUtente(Integer idUtente) throws EsselungaException{
		
		logInit("findAllByIdUtente", idUtente);
		
		try {
			beginTransaction();
			Query query = getEntityManager().createNativeQuery("SELECT * FROM PRODOTTO P "
					+ "LEFT JOIN CARRELLO C ON P.ID = C.ID_PRODOTTO "
					+ "LEFT JOIN UTENTE U ON U.ID = C.ID_UTENTE "
					+ "WHERE U.ID = ?", Prodotto.class);
			query.setParameter(1, idUtente);
			List<Prodotto> prodottiUtente = query.getResultList();
			if(prodottiUtente.isEmpty()) {
				throw new EsselungaException("utente senza prodotti");
			}
			
			return prodottiUtente;
		} catch(EsselungaException ee) {
			ee.printStackTrace();
			throw new EsselungaException(ee.getMessage());
		} catch(Exception e) {
			e.printStackTrace();
			
			return null;
		} finally {
			getEntityManager().close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Prodotto> findAllDati () throws EsselungaException {
		
		logInit("findAllDati");
		
		try {
			beginTransaction();
			Query query = getEntityManager().createNativeQuery("select p.*, u.* from carrello c " + 
					"inner join utente u on u.ID = c.ID_UTENTE" + 
					" inner join prodotto p on p.ID = c.ID_PRODOTTO;", Prodotto.class);

			List<Prodotto> prodottiUtente = query.getResultList();
			
			return prodottiUtente;
		} catch(NoResultException nre) {
			nre.printStackTrace();
			throw new EsselungaException("elementi non trovati");
		}
		catch(Exception e) {
			e.printStackTrace();
			
			return null;
		} finally {
			getEntityManager().close();
		}
	}

}
