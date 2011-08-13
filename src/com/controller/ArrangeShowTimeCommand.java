package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.*;
import java.text.*;
import java.util.*;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entities.*;
import com.models.ModelContext;
import com.models.SessionContext;
import com.util.Filter;
import com.util.HashMD5;

public class ArrangeShowTimeCommand implements Command {

	/**
	 * Constructor of the object.
	 */
	public ArrangeShowTimeCommand() {
	}
//TODO: String title = Filter.escapeHTMLTags(mySmartUpload.getRequest().getParameter("title").trim());
	// escapeHTMLTags!!!! in all command!!
	@SuppressWarnings("deprecation")
	public String execute(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		System.out.println("---ArrangeShowTimeCommand begin");
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
//		access control
		if (!sContext.IsOwner()) {
			response.sendRedirect(sContext.BaseURL + Constent.ACCESSDENIEDPAGE);
			return null;
		}
		
		//done
		String[] MoviesItems = request.getParameterValues("Movies");
		String[] CinemasItems = request.getParameterValues("Cinemas");
		String HourofShowtime = request.getParameter("HourofShowtime");
		String MinutesofShowtime = request.getParameter("MinutesofShowtime");
		String Price = request.getParameter("Price");
		if(Price != null){
			Price = Price.trim();
		}
		if(Price == null || Price == ""){
			sContext.ArrangeShowtimeErrMsg = "No Price";
			response.sendRedirect(sContext.BaseURL + Constent.ARRANGESHOWTIMEPAGE);
			return null;
		}
		String rdate = request.getParameter("sdate");
		
		Double price = 0.00;
		Boolean isInteger = true;
		try{
			price = Double.parseDouble(Price);
		}
		catch (NumberFormatException e){
			isInteger = false;
		}	
		if(!isInteger){
			sContext.AddCinemaErrMsg = "price should be a double value";
			response.sendRedirect(sContext.BaseURL + Constent.ARRANGESHOWTIMEPAGE);
			return null;
		}
		if (MoviesItems == null) {
			sContext.ArrangeShowtimeErrMsg = "No movie select";
			response.sendRedirect(sContext.BaseURL + Constent.ARRANGESHOWTIMEPAGE);
			return null;
		}
		if(CinemasItems == null) {
			sContext.ArrangeShowtimeErrMsg = "No cinema select";
			response.sendRedirect(sContext.BaseURL + Constent.ARRANGESHOWTIMEPAGE);
			return null;
		}
		if(MinutesofShowtime == null || HourofShowtime == null){
			sContext.ArrangeShowtimeErrMsg = "No showtime select";
			response.sendRedirect(sContext.BaseURL + Constent.ARRANGESHOWTIMEPAGE);
			return null;
		}
		for(int i = 0; i < MoviesItems.length; i++){
			MoviesDAO movieDAO = new MoviesDAO();
			Movies movie = movieDAO.findById(MoviesItems[i]);
			Date today = new Date();
			if(today.after(movie.getReleaseDate())){
				sContext.ArrangeShowtimeErrMsg = "Only added showtimes for movies that are releasing shortly";
				response.sendRedirect(sContext.BaseURL + Constent.ARRANGESHOWTIMEPAGE);
				return null;
			}
			SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			Date convertedRDate;
			try {
				convertedRDate = dateFormat1.parse(rdate);
			
				if(convertedRDate.before(movie.getReleaseDate())){
					sContext.ArrangeShowtimeErrMsg = "The showing date is before released date";
					response.sendRedirect(sContext.BaseURL + Constent.ARRANGESHOWTIMEPAGE);
					return null;
				}
				for(int j = 0; j < CinemasItems.length; j++){
					convertedRDate.setHours(Integer.parseInt(HourofShowtime));
					convertedRDate.setMinutes(Integer.parseInt( MinutesofShowtime));
					
//					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date convertedDate;
					convertedDate = convertedRDate;
					Timestamp timestamp = new Timestamp(convertedDate.getTime());
					CinemaDAO cinemaDAO = new CinemaDAO();
					Cinema cinema = cinemaDAO.findById(CinemasItems[j]);
					ShowtimeDAO showtimeDAO = new ShowtimeDAO();
					List<Showtime> existShowtimes = showtimeDAO.findAll();
					for(Showtime c: existShowtimes){
						if(c.getCinemaId().equals(cinema.getCinemaId()) && c.getMovieId().equals(movie.getMovieId()) && c.getShowtime().equals(timestamp)){
							sContext.ArrangeShowtimeErrMsg = "Showtime already added";
							response.sendRedirect(sContext.BaseURL + Constent.ARRANGESHOWTIMEPAGE);
							return null;
						}
					}
//					The cinema owner searches for a movie and adds the cinema(s) it will be showing in and the showtimes at each. 
					mContext.AllShowtimeM.AddShowtime(cinema.getCinemaId(), movie.getMovieId(), timestamp, price); 
					
				}
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		}
		//Finially
		
		System.out.println("---ArrangeShowTimeCommand end");
		response.sendRedirect(sContext.BaseURL + Constent.SUCCESSPAGE);
	
		return null;
	}

}
