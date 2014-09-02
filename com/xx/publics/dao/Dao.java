package com.xx.publics.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

@SuppressWarnings("deprecation")
public class Dao<T, PK extends Serializable> {

	protected Configuration configuration = null;
	protected SessionFactory sessionFactory = null;
	protected ServiceRegistry serviceRegistry = null;
	protected Class<T> entityClass;
	
	
	/**
	 * 加一句
	 * @param entityClass
	 */
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

	/**
	 * 保存
	 * @param entity
	 */
	public void save(T entity) {
		Session s = getSession();
		s.getTransaction().begin();
		s.saveOrUpdate(entity);
		s.getTransaction().commit();
	}
	
	/**
	 * 删除
	 * @param entity
	 */
	public void delete(T entity){
		Session s = getSession();
		s.getTransaction().begin();
		s.delete(entity);
		s.getTransaction().commit();
	}
	
	public void delete(PK id){
		Session s = getSession();
		s.getTransaction().begin();
		s.delete(s.load(entityClass, id));
		s.getTransaction().commit();
	}
	
	/**
	 * 按id获取对象.
	 */
	@SuppressWarnings("unchecked")
	public T get(final PK id) {
		return (T) getSession().load(entityClass, id);
	}
	
	/**
	 * 按HQL查询对象列表.
	 * 
	 * @param hql hql语句
	 * @param values 数量可变的参数


	 */
	@SuppressWarnings("rawtypes")
	public List find(String hql, Object... values) {
		Session s = getSession();
		s.getTransaction().begin();
		List list = createQuery(s,hql, values).list();
		s.getTransaction().commit();
		return list;
	}
	/**
	 * 按HQL查询唯一对象.
	 */
	public Object findUnique(String hql, Object... values) {
		Session s = getSession();
		s.getTransaction().begin();
		Object list = createQuery(s,hql, values).uniqueResult();
		s.getTransaction().commit();
		return list;
	}

	/**
	 * 按HQL查询Intger类形结果. 
	 */
	public Integer findInt(String hql, Object... values) {
		Session s = getSession();
		s.getTransaction().begin();
		Integer list = (Integer) findUnique(hql, values);
		s.getTransaction().commit();
		return list;
	}
	
	/**
	 * 根据查询函数与参数列表创建Query对象,后续可进行更多处理,辅助函数.
	 */
	public Query createQuery(Session s,String queryString, Object... values) {
		Query queryObject = s.createQuery(queryString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				queryObject.setParameter(i, values[i]);
			}
		}
		return queryObject;
	}
}
