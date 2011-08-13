package com.models;

import java.util.*;

import org.hibernate.Transaction;

import com.entities.*;

public class AllUsersModel implements ListBaseModel<User> {
	private UserDAO userDAO = new UserDAO();;
	public AllUsersModel() {
		super();
	}
	
	public List<User> findAll() {
		return userDAO.findAll();
	}
	public List<User> findByUserName(Object UserName){
		return userDAO.findByUserName(UserName);
	}
	public UserDAO getDAO() {
		return userDAO;
	}
	
	public void AddUser(String userName, String password,
			String emailAddress, Short isVaildate) {
		//TODO: use UserDAO add new user,  and validate the info
		
		User user = new User(com.util.Guid.GetGUID(), userName, password, emailAddress, isVaildate);
		user.setRoleId(Constent.ViewerId);
		Transaction tx = userDAO.getSession().beginTransaction();
		userDAO.save(user);
		tx.commit();
	}
}
