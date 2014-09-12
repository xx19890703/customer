package com.xx.service;

import java.util.List;

import com.xx.modal.Project;
import com.xx.publics.dao.Dao;

public class ProjectService {

	/**
	 * dao
	 */
	private Dao<Project,Integer> dao;
	
	public ProjectService(){
		dao = new Dao<Project,Integer>(Project.class);
	}
	
	public void save(Project c){
		dao.save(c);
	}
	
	@SuppressWarnings("unchecked")
	public List<Project> findProjects(){
		String hql = "from Project t where 1=1";
		return dao.find(hql);
	}
	
	public void delete(Project c){
		dao.delete(c);
	}
	
	
}
