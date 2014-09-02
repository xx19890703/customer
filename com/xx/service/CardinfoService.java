package com.xx.service;

import com.xx.modal.Cardinfo;
import com.xx.publics.dao.Dao;

public class CardinfoService {

	/**
	 * dao
	 */
	private Dao<Cardinfo,Integer> dao;
	
	public CardinfoService(){
		dao = new Dao<Cardinfo,Integer>(Cardinfo.class);
	}
	
	public void save(Cardinfo c){
		dao.save(c);
	}
	
	public Cardinfo getCardinfoByCustomer(String cusId){
		String hql = "from Cardinfo t where t.customer.id=?";
		return (Cardinfo) dao.findUnique(hql, cusId);
	}
	
	public void delete(Cardinfo c){
		dao.delete(c);
	}
	
}
