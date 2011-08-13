package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Transaction;

import com.entities.*;
import com.models.ModelContext;
import com.models.SessionContext;
import com.util.Filter;
import com.util.HashMD5;

public class ChangePasswordCommand implements Command {

	public ChangePasswordCommand() {
	}
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		String userName = request.getParameter("UserName");
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		String confirmnewPassword = request.getParameter("confirmnewPassword");
		if(oldPassword == null || newPassword == null || confirmnewPassword == null){
			sContext.ChangePasswordErrMsg = "Please enter password";
			response.sendRedirect(sContext.BaseURL + Constent.CHANGEPASSWORDPAGE);
			return null;
		}
		newPassword = newPassword.trim();
		confirmnewPassword = confirmnewPassword.trim();
		if(!newPassword.equals(confirmnewPassword)){
			sContext.ChangePasswordErrMsg = "New password do not match";
			response.sendRedirect(sContext.BaseURL + Constent.CHANGEPASSWORDPAGE);
			return null;
		}
		User u = sContext.CurrentUser;
		if(!HashMD5.MD5(newPassword).equals(u.getPassword())){
			sContext.ChangePasswordErrMsg = " Wrong password";
			response.sendRedirect(sContext.BaseURL + Constent.CHANGEPASSWORDPAGE);
			return null;
		}
		Transaction tx = mContext.AllUsersM.getDAO().getSession().beginTransaction();
		u.setPassword(HashMD5.MD5(newPassword));
		mContext.AllUsersM.getDAO().attachDirty(u);
		tx.commit();
		sContext.CurrentUser = u;
		sContext.IsLoggedIn = true;
		response.sendRedirect(sContext.BaseURL + Constent.SUCCESSPAGE);
	
	
		return null;
	}

}
