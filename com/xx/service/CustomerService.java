package com.xx.service;

import com.xx.modal.Customer;
import com.xx.publics.dao.Dao;

public class CustomerService {

	/**
	 * dao
	 */
	private Dao<Customer,String> dao;
	
	public CustomerService(){
		dao = new Dao<Customer,String>(Customer.class);
	}
	
	public void save(Customer c){
		dao.save(c);
	}
}
