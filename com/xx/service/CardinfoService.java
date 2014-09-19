package com.xx.service;

import java.util.List;

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
	
	@SuppressWarnings("unchecked")
	public List<Cardinfo> findAll(String id){
		if(id!=null&&!"".equals(id)){
			String hql = "from Cardinfo t where 1=1 and (t.customer.id like ? or t.customer.username like ? ) order by t.id";
			List<Cardinfo> list = dao.find(hql,"%"+id+"%","%"+id+"%");
			return list;
		}else{
			String hql = "from Cardinfo t order by t.id";
			return dao.find(hql);
		}
		
	}
	
	public void delete(Cardinfo c){
		dao.delete(c);
	}
	
}
