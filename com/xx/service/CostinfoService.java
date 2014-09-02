package com.xx.service;

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
	
	public void delete(Costinfo c){
		dao.delete(c);
	}
	
}
