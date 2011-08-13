package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.hibernate.Transaction;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entities.*;
import com.models.ModelContext;
import com.models.SessionContext;
import com.util.HashMD5;
public class ShowCinemaMoviesCommand implements Command {

	public ShowCinemaMoviesCommand() {
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stubString s = request.getParameter("id");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.write("<HTML><HEAD><TITLE>Cinema movies</TITLE></HEAD><BODY style=\"color:rgb(0,100,255)\">");
		out.write("<div class=\"SearchBar\">");
		
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
		String cinemaid = request.getParameter("id");
		System.out.println("---EditProfileCommand begin, cinemaid is " + cinemaid);
		ShowtimeDAO showtimeDAO = new ShowtimeDAO();
		List<Showtime> showtime = showtimeDAO.findByCinemaId(cinemaid);
		for(Showtime s : showtime){
			String movieid = s.getMovieId();
			MoviesDAO movieDAO = new MoviesDAO();
			Movies m = movieDAO.findById(movieid);
			out.write("<div class=\"searchItem\">");
			out.write("<div class=\"l\"><a href=\"" + sContext.BaseURL + com.entities.Constent.CONTROLLERSERVLET + "showdetail&id=" + m.getMovieId() + "\">" + m.getMovieTitle() + "</a> </div>");
			out.write("<div class=\"l\">" + m.getActors() + "</div>");
			out.write("<div class=\"l\">" + m.getReleaseDate() + "</div>");
			out.write("</div>");
		}
		out.write("</div");
		out.close();
		return null;
	}
}
