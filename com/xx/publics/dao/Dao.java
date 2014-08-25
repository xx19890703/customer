package com.xx.publics.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Dao<T, PK extends Serializable> {

	protected Configuration configuration = null;
	protected SessionFactory sessionFactory = null;
	protected ServiceRegistry serviceRegistry = null;
	protected Class<T> entityClass;
	
	
	/**
	 * 加一句
	 * @param entityClass
	 */
	@SuppressWarnings("deprecation")
	public Dao(Class<T> entityClass){
		configuration = new Configuration().configure();
		serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		this.entityClass = entityClass;
	}
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void save(T entity) {
		Session s = getSession();
		s.getTransaction().begin();
		s.saveOrUpdate(entity);
		s.getTransaction().commit();
	}
}
