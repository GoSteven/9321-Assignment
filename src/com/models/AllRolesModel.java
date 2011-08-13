package com.models;

import java.util.List;

import com.entities.*;

public class AllRolesModel implements ListBaseModel<Role> {
	private RoleDAO roleDAO = new RoleDAO();;
	public AllRolesModel() {
		super();
	}
	
	public List<Role> findAll() {
		return roleDAO.findAll();
	}
	
	public RoleDAO getDAO() {
		return roleDAO;
	}
	
}
