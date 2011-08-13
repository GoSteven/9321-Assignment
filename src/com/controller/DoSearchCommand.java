package com.controller;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
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


public class DoSearchCommand implements Command {
	
	public DoSearchCommand() {
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
		
		boolean isSearchTitle = false, isSearchActors = false, isSearchGenres = false;
		
		String title = request.getParameter("Title");
		if (title != null && title.trim() != "" && title.trim() != null) {
			isSearchTitle = true;
		}
		String actors = request.getParameter("actors");
		List <String> actorsList = new ArrayList<String>();
		if (actors != null && actors != "") {
			String[] actorsArray = actors.split(",");
			actorsList = Arrays.asList(actorsArray);
			isSearchActors = true;
		}
		
		
        String[] genresItems = request.getParameterValues("Genres");
        Integer targetGenres = 0;
        if (genresItems != null) {
        	isSearchGenres = true;
        	for (String s : Arrays.asList(genresItems)) {
        		targetGenres += Integer.parseInt(s);
        	}
        }

        
        
        
        List<Movies> filteredMovies = new ArrayList<Movies>();
        List<Movies> allMovies = mContext.AllMoviesM.findAll();
        for (Movies m : allMovies) {
        	int mFlag = 1;
        	if (isSearchTitle){
        		if (!m.getMovieTitle().toLowerCase().contains(title.toLowerCase())) {
        			mFlag = 0;
        		}
        	}
        	if (isSearchActors){
        		for (String targetAct : actorsList) {
        			if (!m.getActors().toLowerCase().contains(targetAct.toLowerCase()))
        				mFlag = 0;
        		}
        	}
        	if (isSearchGenres) {
        		if ((m.getGenre() & targetGenres) == 0) {
        			mFlag = 0;
        		}
        	}
        	//then 
        	if (mFlag == 1) {
        		filteredMovies.add(m);
        	}
        }
        
        
        sContext.SearchedMovies = filteredMovies;
        request.getRequestDispatcher(Constent.SEARCHRESULTPAGE).forward(request, response);
		
		System.out.println("---DoSearchCommand end");
	
		return null;
	}


}
