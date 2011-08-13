package com.controller;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.*;
import java.text.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.entities.*;
import com.models.ModelContext;
import com.models.SessionContext;

import com.util.*;

public class AddMovieCommand implements Command {
	
	public AddMovieCommand() {
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		System.out.println("---AddMovieCommand begin");
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
		
		if (!sContext.IsOwner()) {
			response.sendRedirect(sContext.BaseURL + Constent.ACCESSDENIEDPAGE);
			return null;
		}
//		
//		String MovieTitle = request.getParameter("MovieTitle").trim();
////		poster
//		String ActorsAndActresses = request.getParameter("ActorsAndActresses").trim();
////		genre is integer
//		String Genres = request.getParameter("Genres").trim();
//		String Director = request.getParameter("Director").trim();
//		String ShortSynopsis = request.getParameter("ShortSynopsis").trim();
//		String AgeRating = request.getParameter("AgeRating").trim();
//		String ReleaseDate = request.getParameter("ReleaseDate").trim();
//		
//		Boolean isInteger = true;
//		if (MovieTitle.length()==0 || Genres.length()==0) {
//			sContext.AddMovieErrMsg = "fileds cannot be empty";
//			response.sendRedirect(sContext.BaseURL + Constent.ADDMOVIEPAGE);
//			return null;
//		}	
		
		
//		check if movie title exist in database
//		if(mContext.AllMoviesM.getDAO().findByMovieTitle(MovieTitle).size() != 0){
//			sContext.AddMovieErrMsg = "Movie title exists";
//			response.sendRedirect(sContext.BaseURL + Constent.ADDCINEMAPAGE);
//			return null;
//		}
		
		//TODO: check all the fields is validate before upload
		SmartUpload mySmartUpload = new SmartUpload();
		mySmartUpload.initialize(sContext.ServletConfig,request,response);
		try
		{
	        mySmartUpload.upload();		
	        String MovieTitle = Filter.escapeHTMLTags(mySmartUpload.getRequest().getParameter("MovieTitle"));
	        if(MovieTitle != null){
	        	MovieTitle = MovieTitle.trim();
	        }
	        if(MovieTitle.equals("") || MovieTitle == null){
	        	sContext.AddMovieErrMsg = "Movie title is empty";
				response.sendRedirect(sContext.BaseURL + Constent.ADDMOVIEPAGE);
				return null;
	        }
			String ActorsAndActresses = Filter.escapeHTMLTags(mySmartUpload.getRequest().getParameter("ActorsAndActresses"));
			if(ActorsAndActresses != null){
				ActorsAndActresses = ActorsAndActresses.trim();
			}
			String[] genresItems = mySmartUpload.getRequest().getParameterValues("Genres");
			Integer Genres = 0;
	        if (genresItems != null) {
	        	for (String s : Arrays.asList(genresItems)) 
	        		Genres += Integer.parseInt(s);
	        }
//			String Genres_Action = Filter.escapeHTMLTags(mySmartUpload.getRequest().getParameter("Genres_Action"));
//			String Genres_Adventure = Filter.escapeHTMLTags(mySmartUpload.getRequest().getParameter("Genres_Adventure"));
//			String Genres_Comedy = Filter.escapeHTMLTags(mySmartUpload.getRequest().getParameter("Genres_Comedy"));
//			String Genres_Horror = Filter.escapeHTMLTags(mySmartUpload.getRequest().getParameter("Genres_Horror"));
//			String Genres_War = Filter.escapeHTMLTags(mySmartUpload.getRequest().getParameter("Genres_War"));		
//			String Genres_Drama = Filter.escapeHTMLTags(mySmartUpload.getRequest().getParameter("Genres_Drama"));
//			
//			if(Genres_Action != null){
//				Genres |= 1;
//			}
//			if(Genres_Adventure != null){
//				Genres |= 2;
//			}
//			if(Genres_Comedy != null){
//				Genres |= 4;
//			}
//			if(Genres_Horror != null){
//				Genres |= 8;
//			}
//			if(Genres_War != null){
//				Genres |= 16;
//			}
//			if(Genres_Drama != null){
//				Genres |= 32;
//			}
			String Director = Filter.escapeHTMLTags(mySmartUpload.getRequest().getParameter("Director"));
			if(Director != null){
				Director = Director.trim();
			}
			String Synopsis = Filter.escapeHTMLTags(mySmartUpload.getRequest().getParameter("Synopsis"));		
			if(Synopsis != null){
				Synopsis = Synopsis.trim();
			}
			String Youtubelink = mySmartUpload.getRequest().getParameter("youtubelink");
			if(Youtubelink != null){
				Youtubelink = Youtubelink.trim();
			}
			String AgeRating_G = Filter.escapeHTMLTags(mySmartUpload.getRequest().getParameter("AgeRating_G"));
			String AgeRating_PG = Filter.escapeHTMLTags(mySmartUpload.getRequest().getParameter("AgeRating_PG"));
			String AgeRating_M = Filter.escapeHTMLTags(mySmartUpload.getRequest().getParameter("AgeRating_M"));
			String AgeRating_MA = Filter.escapeHTMLTags(mySmartUpload.getRequest().getParameter("AgeRating_MA"));
			String AgeRating_R = Filter.escapeHTMLTags(mySmartUpload.getRequest().getParameter("AgeRating_R"));
			String AgeRating_X = Filter.escapeHTMLTags(mySmartUpload.getRequest().getParameter("AgeRating_X"));
			Integer AgeRating = 0;
			if(AgeRating_G != null){
				AgeRating |= 1;
			}
			if(AgeRating_PG != null){
				AgeRating |= 2;
			}
			if(AgeRating_M != null){
				AgeRating |= 4;
			}
			if(AgeRating_MA != null){
				AgeRating |= 8;
			}
			if(AgeRating_R != null){
				AgeRating |= 16;
			}
			if(AgeRating_X != null){
				AgeRating |= 32;
			}
			String rdate = Filter.escapeHTMLTags(mySmartUpload.getRequest().getParameter("rdate"));
			String edate = Filter.escapeHTMLTags(mySmartUpload.getRequest().getParameter("edate"));
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date convertedRDate = dateFormat.parse(rdate); 
			Date convertedEDate = dateFormat.parse(edate); 
			if(convertedRDate.before(new Date())){
				sContext.AddMovieErrMsg = "The release date is before today";
				response.sendRedirect(sContext.BaseURL + Constent.ADDMOVIEPAGE);
				return null;
			}
			if(convertedEDate.before(convertedRDate)){
				sContext.AddMovieErrMsg = "The expired date is before release date";
				response.sendRedirect(sContext.BaseURL + Constent.ADDMOVIEPAGE);
				return null;
			}
	        SmartFile file = mySmartUpload.getFiles().getFile(0);
	    	String fileExt=file.getFileExt();
	    	if(!file.getFilePathName().trim().equals("")&&!fileExt.equalsIgnoreCase("jpg")&&
	    			!fileExt.equalsIgnoreCase("png") && !fileExt.equalsIgnoreCase("gif")){
	    		sContext.AddMovieErrMsg = "Only jpg, gif and png are accepted!";
	    		response.sendRedirect(sContext.BaseURL + Constent.ADDMOVIEPAGE);
				return null;
	    	}
	    	else if(rdate.equals("")){
	    		sContext.AddMovieErrMsg = "For unrealsed movie must provide expected time!";
	    		response.sendRedirect(sContext.BaseURL + Constent.ADDMOVIEPAGE);
				return null;
        	}
	    	else {
	        	String path="/poster";
	            int count = mySmartUpload.save(path);
	        	String poster;
	        	if(file.getFilePathName().trim().equals(""))
	        		poster=null;
	        	else poster=file.getFileName();		
	        	System.out.println("---File Saved: " + poster);
	        	mContext.AllMoviesM.AddMovie(MovieTitle, poster, Youtubelink, ActorsAndActresses, Genres, Director, Synopsis, AgeRating, convertedRDate, convertedEDate);
				System.out.println("---Movie Added: " + MovieTitle + " " + convertedRDate);
				
				
	    	}
		} catch (SmartUploadException e) {
			PrintStream ps = null;
			e.printStackTrace(ps);
			System.out.print(ps.toString());
			
			System.out.println("---File Upload failed: " + e.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//Finially
		
		System.out.println("---AddCinemaCommand end");
		response.sendRedirect(sContext.BaseURL + Constent.SUCCESSPAGE);
	
		return null;
	}


}
