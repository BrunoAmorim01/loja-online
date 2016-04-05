package br.com.lojaonline.util.jpa;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityManagerProducer {
	
	EntityManagerFactory factory;
	
	public EntityManagerProducer() {
	factory=Persistence.createEntityManagerFactory("lojaonline");
	}
	
	@Produces
	public EntityManager create(){
		return factory.createEntityManager();
	}
	
	public void close(@Disposes EntityManager manager){
		manager.close();
	}

}
