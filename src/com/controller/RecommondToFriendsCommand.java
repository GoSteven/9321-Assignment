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

public class RecommondToFriendsCommand implements Command {

	public RecommondToFriendsCommand() {
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
		///////////////////////////////////////////////////////\\\\\\\\\\\\\\\/////////
		String id = request.getParameter("id");
		if (id == null || id.equals("") || !sContext.IsLoggedIn
				|| sContext.CurrentUser == null) {
			historyGoBack1(response);
			return null;
		}
		
		Movies m = mContext.AllMoviesM.getDAO().findById(id);
		if (m == null) {
			historyGoBack1(response);
			return null;
		}
		
		List<String> friends = new ArrayList<String>();
		for (User u : sContext.getMyFriends()) {
			friends.add(u.getUserId());
		}
		
		// Send all recommends 
		mContext.AllRecommendMoviesM.addRecommend(id, sContext.CurrentUser.getUserId(), friends);
		response.sendRedirect(sContext.BaseURL + Constent.SUCCESSPAGE);
		

		return null;
	}

	private void historyGoBack1(HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<script language=\"javascript\" type=\"text/javascript\">");
		out.println("window.history.go(-1)");
		out.println("</script>");
		out.flush();
		out.close();

	}

}
