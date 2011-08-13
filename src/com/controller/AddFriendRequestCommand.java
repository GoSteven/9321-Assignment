package com.controller;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entities.*;
import com.models.ModelContext;
import com.models.SessionContext;

import com.util.*;

public class AddFriendRequestCommand implements Command {

	public AddFriendRequestCommand() {
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("---AddBookingCommand begin");
		HttpSession session = request.getSession();
		ModelContext mContext = (ModelContext) session.getAttribute("MContext");
		SessionContext sContext = (SessionContext) session
				.getAttribute("SContext");
		if (mContext == null) {
			mContext = new ModelContext();
			session.setAttribute("MContext", mContext);
		}
		if (sContext == null) {
			sContext = new SessionContext();
			session.setAttribute("SContext", sContext);
		}
		String id = request.getParameter("id");
		if (id == null || id.equals("") || !sContext.IsLoggedIn) {
			historyGoBack1(response);
			return null;
		}
		
		User targetUser = mContext.AllUsersM.getDAO().findById(id);
		if (targetUser == null) {// this shouldn't happen at all
			response.sendRedirect(sContext.BaseURL + Constent.INDEXPAGE);
			return null;
		}
		for (User u : sContext.getMyFriends()) {
			if (u.getUserId().equals(id)) {
				response.sendRedirect(sContext.BaseURL + Constent.UGUYSAREFRIENSPAGE);
				return null;
			}
		}

		String requestDetail = request.getParameter("requestDetail");
		
		ModelContext.AllFriendInvitationsM.addFriendInvitation(id, sContext.CurrentUser.getUserId(), requestDetail);
		
		// send email
		//Confirm Email
		com.util.MailSender ms = new com.util.MailSender();
		String url = sContext.BaseURL;
		try
		{
			ms.send(targetUser.getEmailAddress(), "New friend invitation -- From MM Movie", 
					"Click the link below to see:<br />" +
					"<a href=\"" +url + "\">" +url + "</a>");
		}
		catch (Exception e){
		}
		
		response.sendRedirect(sContext.BaseURL + Constent.SUCCESSPAGE);
		return null;
	}
	
	private void historyGoBack1(HttpServletResponse response)  throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<script language=\"javascript\" type=\"text/javascript\">");
		out.println("window.history.go(-1)");
		out.println("</script>");
		out.flush();
		out.close();
		
	}

}
