package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entities.*;
import com.models.ModelContext;
import com.models.SessionContext;
import com.util.HashMD5;
public class LoginCommand implements Command {

	/**
	 * Constructor of the object.
	 */
	public LoginCommand() {
		
	}

	public String execute(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		System.out.println("---LoginCommand begin");
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
//		if logoff
		if (request.getParameter("logoff") != null) {
			sContext.IsLoggedIn = false;
			sContext.MyList = new ArrayList<Movies>();
			sContext.CurrentUser = null;
			response.sendRedirect(sContext.BaseURL + Constent.LOGINPAGE);
			return null;
		}//end logoff
		String RName = request.getParameter("UserName").trim();
		String RPassword = request.getParameter("PassWord").trim();
		
		if (RName.length()==0 || RPassword.length()==0) {
			sContext.LoginErrMsg = "fileds cannot be empty";
			response.sendRedirect(sContext.BaseURL + Constent.LOGINPAGE);
			return null;
		}
		RPassword = HashMD5.MD5(RPassword);
//		check if user name exist in database
		List<User> users = null;
		if((users = mContext.AllUsersM.getDAO().findByUserName(RName)).size() == 0){
			sContext.LoginErrMsg = "user not found";
			response.sendRedirect(sContext.BaseURL + Constent.LOGINPAGE);
			return null;
		} else {
			User user = users.get(0);
			if (!user.getPassword().equals(RPassword)) {
				sContext.LoginErrMsg = "password incorret";
				response.sendRedirect(sContext.BaseURL + Constent.LOGINPAGE);
				return null;
			} else {
				sContext.CurrentUser = user;
				sContext.IsLoggedIn = true;
				if (user.getRoleId().equals(Constent.OwnerId)) { // Owner
					response.sendRedirect(sContext.BaseURL + Constent.ADMINPAGE);
					return null;
				} else { // Viewer
					response.sendRedirect(sContext.BaseURL + Constent.INDEXPAGE);
					return null;
				}
			}
		}
	}
}

