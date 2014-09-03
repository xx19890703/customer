package com.xx.service;

import com.xx.modal.Cardinfo;
import com.xx.modal.Recharge;
import com.xx.publics.dao.Dao;

public class RechargeService {

	/**
	 * dao
	 */
	private Dao<Recharge,Integer> dao;
	private Dao<Cardinfo,Integer> cdao;
	
	public RechargeService(){
		dao = new Dao<Recharge,Integer>(Recharge.class);
		cdao = new Dao<Cardinfo,Integer>(Cardinfo.class);
	}
	
	public void save(Recharge c){
		dao.save(c);
		Cardinfo ci = c.getCard();
		ci.setAmount(ci.getAmount().add(c.getMoney()));
		cdao.save(ci);
	}
	
	public void delete(Recharge c){
		dao.delete(c);
	}
	
}
