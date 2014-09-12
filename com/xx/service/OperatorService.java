package com.xx.service;

import java.util.List;

import com.xx.modal.Operator;
import com.xx.publics.dao.Dao;

public class OperatorService {

	/**
	 * dao
	 */
	private Dao<Operator,Integer> dao;
	
	public OperatorService(){
		dao = new Dao<Operator,Integer>(Operator.class);
	}
	
	public void save(Operator c){
		dao.save(c);
	}
	
	@SuppressWarnings("unchecked")
	public List<Operator> findOperators(){
		String hql = "from Operator t where 1=1";
		return dao.find(hql);
	}
	
	public void delete(Operator c){
		dao.delete(c);
	}
	
	
}
