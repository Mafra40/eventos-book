package br.com.eventosbook.hibernate.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.eventosbook.constante.ConstantesHibernate;


public class ConnectionFactory {
	
	
	private static ConnectionFactory aConnectionFactory = new ConnectionFactory();
	private static EntityManagerFactory factory  = Persistence.createEntityManagerFactory("eventosbook");
	private ThreadLocal<EntityManager> threadEntityManager = new ThreadLocal<EntityManager>();

	public static ConnectionFactory getInstace(){
		if(ConnectionFactory.aConnectionFactory == null){
			ConnectionFactory.aConnectionFactory = new  ConnectionFactory();
		}
		return ConnectionFactory.aConnectionFactory;
	}
	
	
	private static EntityManagerFactory getEnityManager(){
		
		if(factory == null || !factory.isOpen()){
			factory = Persistence.createEntityManagerFactory(ConstantesHibernate.NM_PERSISTENCE);
		}
		
		return factory;
	}
	

	public EntityManager getConnection(){
		EntityManager manager = threadEntityManager.get();
		
		if(manager == null || !manager.isOpen()){
			manager = getEnityManager().createEntityManager();
		}
		
		threadEntityManager.set(manager);
		
		return manager;
	}
	
	public void getCloseConnection(){
		
		EntityManager manager = threadEntityManager.get();
		
		if(manager != null){
			manager.close();
		}
	}
	
	
}
	