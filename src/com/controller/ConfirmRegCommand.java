package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Transaction;

import com.models.AllUsersModel;
import com.models.ModelContext;
import com.models.SessionContext;
import com.entities.*;

public class ConfirmRegCommand implements Command{

	/**
	 * Constructor of the object.
	 */
	public ConfirmRegCommand() {
	}

	public String execute(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {

		String id = request.getParameter("id").toString().trim();
		if (id == null) {
			response.sendRedirect(Constent.LOGINPAGE);
		}
		
		HttpSession session = request.getSession();
		ModelContext mContext = (ModelContext)session.getAttribute("MContext");
		SessionContext sContext = (SessionContext)session.getAttribute("SContext");
		if (mContext == null) {
			mContext = new ModelContext();
			session.setAttribute("MContext", mContext);
		}
		if (sContext == null) {
			sContext = new SessionContext();
			session.setAttribute("SContext", sContext);
		}
		
		List<User> userList = mContext.AllUsersM.findAll();
		User cu = null;
		for (User um :userList) {
//			System.out.println(um.getUserName() + " " 
//					+ String.valueOf((um.getUserName() + um.getEmailAddress()).hashCode()));
//			System.out.println("--- " 
//					+ String.valueOf(("admin" + "yousilin@gmail.com").hashCode()));
//			System.out.println("id= " + id);
			if (um.getIsVaildate() == 0 &&
				id.equals( String.valueOf((um.getUserName() + um.getEmailAddress()).hashCode()))) {
				cu = um;
				break;
			}
		}
		if (cu != null) {
			Transaction tx = mContext.AllUsersM.getDAO().getSession().beginTransaction();
			cu.setIsVaildate((short)1);
			mContext.AllUsersM.getDAO().attachDirty(cu);
			tx.commit();
			sContext.CurrentUser = cu;
			sContext.IsLoggedIn = true;
			response.sendRedirect(sContext.BaseURL + Constent.EDITPROFILEPAGE);
		}
	
		return null;
	}
	
}
