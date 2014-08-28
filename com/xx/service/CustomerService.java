package com.xx.service;

import java.util.List;

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
	
	public void delete(Customer c){
		dao.delete(c);
	}
	
	public List<Customer> findAll(){
		String hql = "from Customer t where t.status=? order by t.id";
		return dao.find(hql, "0");
	}
	
}
