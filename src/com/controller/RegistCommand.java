package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entities.*;
import com.models.ModelContext;
import com.models.SessionContext;
import com.util.HashMD5;

public class RegistCommand implements Command {

	/**
	 * Constructor of the object.
	 */
	public RegistCommand() {
	}

	public String execute(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		System.out.println("---RegistCommand begin");
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
		
		String RName = request.getParameter("UserName").trim();
		String RPassword = request.getParameter("PassWord").trim();
		String REmail = request.getParameter("EmailAddr").trim();
		if (RName.length()==0 || RPassword.length()==0 || REmail.length()==0) {
			sContext.RegistErrMsg = "fileds cannot be empty";
			response.sendRedirect(sContext.BaseURL + Constent.REGISTPAGE);
			return null;
		}	
		RPassword = HashMD5.MD5(RPassword);
//		check if user name exist in database
		if(mContext.AllUsersM.getDAO().findByUserName(RName).size() != 0){
			sContext.RegistErrMsg = "username exists";
			response.sendRedirect(sContext.BaseURL + Constent.REGISTPAGE);
			return null;
		}
//		check whether the email format is valid
		if(mContext.AllUsersM.getDAO().findByEmailAddress(REmail).size() != 0){
			sContext.RegistErrMsg = "email exists";
			response.sendRedirect(sContext.BaseURL + Constent.REGISTPAGE);
			return null;
		}
		String expression = "^[\\w\\.-_+]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";  
		CharSequence inputStr = REmail; 
		//Make the comparison case-insensitive.  
		Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);  
		Matcher matcher = pattern.matcher(inputStr);  
		if(!matcher.matches()){    
			sContext.RegistErrMsg = "invalid email";
			response.sendRedirect(sContext.BaseURL + Constent.REGISTPAGE);
			return null;
		}  
		
		//Finially
		mContext.AllUsersM.AddUser(RName, RPassword, REmail, (short)0);
		System.out.println("--User Added: " + RName + " " + RPassword + " " + REmail);
		
		//Confirm Email
		com.util.MailSender ms = new com.util.MailSender();
		(RName + REmail).hashCode();
		String hashUserId = String.valueOf((RName + REmail).hashCode());
		String url = sContext.BaseURL + Constent.CONTROLLERSERVLET + Constent.CONFIRMREG_CMD + "&id=" +
			hashUserId;
		try
		{
			ms.send(REmail, "Wellcome to MM Movie", 
					"Click the link below to finish registrition:<br />" +
					"<a href=\"" +url + "\">" +url + "</a>");
		}
		catch (Exception e){
		}
		System.out.println("---RegistCommand end");
		response.sendRedirect(sContext.BaseURL + Constent.SUCCESSPAGE);
	
		return null;
	}

}
