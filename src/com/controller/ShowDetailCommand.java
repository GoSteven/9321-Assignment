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


public class ShowDetailCommand implements Command {
	
	public ShowDetailCommand() {
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("---DoSearchCommand begin");
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
		
		
		String id = request.getParameter("id");
		Movies targetMovie = mContext.AllMoviesM.getDAO().findById(id);
		if (targetMovie == null) {//this shouldn't happen at all
			response.sendRedirect(sContext.BaseURL + Constent.INDEXPAGE);
			return null;
		}
		
//		add comment
		String comment = request.getParameter("comment");
		
		if (sContext.IsLoggedIn && comment != null && comment.trim() != "" && 
				request.getParameter("rate") != null && request.getParameter("rate") != "") {
			comment = Filter.escapeHTMLTags(comment);
			int rating = Integer.parseInt(request.getParameter("rate"));
			String userId = sContext.CurrentUser.getUserId();
			String movieId = id;
			mContext.AllCommentsM.AddComment(movieId, userId, rating, comment);
		}
		
		
		
		request.setAttribute("targetMovie", targetMovie);
        
        request.getRequestDispatcher(Constent.SHOWDETAILPAGE).forward(request, response);
		
		System.out.println("---DoSearchCommand end");
	
		return null;
	}


}
