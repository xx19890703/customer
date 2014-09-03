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
	
	public Customer getCustomer(String id){
		String hql = "from Customer t where t.id=?";
		return (Customer) dao.findUnique(hql, id);
	}
	
	public void delete(Customer c){
		dao.delete(c);
	}
	
	@SuppressWarnings("unchecked")
	public List<Customer> findAll(String id){
		if(id!=null&&!"".equals(id)){
			String hql = "from Customer t where t.status=? and t.id like ? order by t.id";
			return dao.find(hql, "0","%"+id+"%");
		}else{
			String hql = "from Customer t where t.status=? order by t.id";
			return dao.find(hql, "0");
		}
		
	}
	
}
