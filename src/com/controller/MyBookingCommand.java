package com.controller;

import java.io.IOException;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Date;
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

public class MyBookingCommand implements Command {

	public MyBookingCommand() {
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("---myBookingCommand begin");
		PrintWriter out = response.getWriter();
		out.write("<HTML><HEAD><TITLE>MyBooking</TITLE></HEAD><BODY style=\"color:rgb(0,100,255)\">");
		out.write("<div class=\"SearchBar\">");
		
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
//		String userId = sContext.CurrentUser.getUserId();
//		BookingDAO bookingDAO = new BookingDAO();
//		List<Booking> mybookings = bookingDAO.findByUserId(userId);
//		for(Booking b : mybookings){
//			String showid = b.getShowTimeId();
//			ShowtimeDAO showtime = new ShowtimeDAO();
//			Showtime s = showtime.findById(showid);
//			if(s.getShowtime().after(new Date())){
//				CinemaDAO cinemadao = new CinemaDAO();
//				Cinema c = cinemadao.findById(s.getCinemaId());
//				MoviesDAO moviedao = new MoviesDAO();
//				Movies m = moviedao.findById(s.getMovieId());
//				out.write("<div class=\"searchItem\">");
//				out.write("<div class=\"l\">" + c.getCinemaName() + "</div>");
//				out.write("<div class=\"l\">" + m.getMovieTitle() + "</div>");
//				out.write("<div class=\"l\">" + s.getShowtime() + "</div>");
//				out.write("<div class=\"l\">" + b.getNumOfTicket() + "</div>");
//				out.write("</div>");
//			}
//			out.write("</div>");
//		}
		request.getRequestDispatcher("/MyBookings.jsp").forward(request, response);
		return null;
	}
}
