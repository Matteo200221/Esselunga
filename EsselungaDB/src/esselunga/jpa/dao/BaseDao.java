package esselunga.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import esselunga.jpa.connection.EntityManagerProvider;
import esselunga.jpa.eccezzioni.EsselungaException;

public abstract class BaseDao<T> {
	
	public abstract T insert(T model);
	
	public abstract T update(T model);
	
	public abstract void delete(T model);
	
	public abstract T findById(Integer id) throws NoResultException, EsselungaException;
	
	public abstract List<T> findAll() throws EsselungaException;
	
	protected EntityManager getEntityManager() {
		
		return EntityManagerProvider.getEntityManager();
	}
	
	protected void beginTransaction() throws Exception {
		
		EntityManagerProvider.beginTransaction();
	}
	
	protected void commitTransaction() {
		
		EntityManagerProvider.commitTransaction();
	}
	
	protected void rollbackTransaction() {
		
		EntityManagerProvider.rollbackTransaction();
	}
	
	protected void logInit(String method) {
		
		logInit(method, null);
	}
	
	protected void logInit(String method, Object object) {
		
		System.out.println("dentro " + this.getClass().getSimpleName() + " " + method + " " + (object != null ? object.toString() : ""));
	}

}
