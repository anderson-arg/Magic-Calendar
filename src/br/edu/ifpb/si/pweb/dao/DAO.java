package br.edu.ifpb.si.pweb.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public abstract class DAO<T> implements DAOInterface<T> {
	protected static EntityManager manager ;
	private static EntityManagerFactory factory;
	
	public static void open(){
		if(manager==null){
			EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("calendar");
			manager = factory.createEntityManager();
		}
	}
	
	public static void close(){
		if(manager!=null && factory!= null) {
			manager.close();
			factory.close();
			manager = null;
			factory = null;
		}
	}
	
	public void create(T obj){
		manager.persist( obj );
	}
	
	public abstract T read(Object chave) throws Exception;
	
	public T update(T obj){
		manager.merge(obj);
		return obj;
	}
	
	public void delete(T obj) {
		manager.remove(obj);
	}
	
	public void refresh(T obj){
		manager.refresh(obj);
	}
	
	//--------transação---------------
	public static void begin(){
		if(!manager.getTransaction().isActive())  //evitar abrir duas transações
			manager.getTransaction().begin();
	}
	
	public static void commit(){
		if(manager.getTransaction().isActive()){
			manager.getTransaction().commit();
			//manager.clear();		// esvaziar o cache de objetos
		}
	}
	
	public static void flush(){	//commit intermediario
		manager.flush();
	}
	
	public static void rollback(){
		if(manager.getTransaction().isActive())
			manager.getTransaction().rollback();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> readAll(){
		//determinar o tipo (a classe) de T
		Class<T> type = (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		Query query = manager.createQuery("select x from " + type.getSimpleName() + " x");
		return (List<T>) query.getResultList();
	}
}
