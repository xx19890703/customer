package com.xx.service;

import java.util.List;

import com.xx.modal.Costinfo;
import com.xx.publics.dao.Dao;

public class CostinfoService {

	/**
	 * dao
	 */
	private Dao<Costinfo,Integer> dao;
	
	public CostinfoService(){
		dao = new Dao<Costinfo,Integer>(Costinfo.class);
	}
	
	public void save(Costinfo c){
		dao.save(c);
	}
	
	@SuppressWarnings("unchecked")
	public List<Costinfo> findCostinfosByCusId(String cusId){
		String hql = "from Costinfo t where t.customer.id=? order by t.time desc";
		return dao.find(hql, cusId);
	}
	
	public void delete(Costinfo c){
		dao.delete(c);
	}
	
}
