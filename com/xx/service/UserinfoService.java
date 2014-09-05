package com.xx.service;

import com.xx.modal.Userinfo;
import com.xx.publics.dao.Dao;

public class UserinfoService {

	/**
	 * dao
	 */
	private Dao<Userinfo,String> dao;
	
	public UserinfoService(){
		dao = new Dao<Userinfo,String>(Userinfo.class);
	}
	
	public void save(Userinfo c){
		dao.save(c);
	}
	
	public Userinfo getUserinfo(String id){
		String hql = "from Userinfo t where t.id=?";
		return (Userinfo) dao.findUnique(hql, id);
	}
	
}
