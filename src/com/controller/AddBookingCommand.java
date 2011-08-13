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

public class AddBookingCommand implements Command {

	public AddBookingCommand() {
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
//      movie id
		String id = request.getParameter("id");
		if (id == null || id.equals("")) {
			historyGoBack1(response);
			return null;
		}

		Movies targetMovie = mContext.AllMoviesM.getDAO().findById(id);
		if (targetMovie == null) {// this shouldn't happen at all
			response.sendRedirect(sContext.BaseURL + Constent.INDEXPAGE);
			return null;
		}

		// if submit book
		String book = request.getParameter("book");
		String NumOfTickets = request.getParameter("NumOfTickets");
		String token = request.getParameter("token");
		if (book != null && book.equals("true")) {
			String[] ShowtimesItems = request.getParameterValues("Showtimes");
			
			try {
//				if not choosen show time
				if (ShowtimesItems == null || ShowtimesItems.length == 0) {
					sContext.AddBookingErrMsg = "Please choose a cinema";
					historyGoBack1(response);
					return null;
				}
				String bookingSucessMsg = "You have booked:<br /><br />";
				if (sContext.IsTokenExist(token)) {
					bookingSucessMsg = "You submit booking twice, the booking already exist in ur bookings list!";
				} else {
					int numOfTikets = Integer.parseInt(NumOfTickets);
					for(int i = 0; i < ShowtimesItems.length; i++){
						Showtime st = mContext.AllShowtimeM.getDAO().findById(ShowtimesItems[i]);
						CinemaDAO cinemadao = new CinemaDAO();
						Cinema cinema = cinemadao.findById(st.getCinemaId());
						Integer seatcapacity = cinema.getSeatingCapacity();
						BookingDAO Bbooking = new BookingDAO();
						List<Booking> Bbook = Bbooking.findByShowTimeId(st.getShowtimeId());
						Integer hasBooked = 0;
						for(Booking b: Bbook){
							Integer num = b.getNumOfTicket();
							hasBooked += num;
						}
						Integer leftticket = seatcapacity - hasBooked - numOfTikets;
						if(leftticket < 0){
							sContext.AddBookingErrMsg = "No enough tickets";
							historyGoBack1(response);
							return null;
						}
						double totalPrice = st.getPrice() * numOfTikets;
						Booking booking = mContext.AllBookingsM.AddBooking(sContext.CurrentUser.getUserId(), st.getShowtimeId(), numOfTikets);
						bookingSucessMsg += "Movie: " + targetMovie.getMovieTitle() + "<br />";
						bookingSucessMsg += "Cinema: " + st.getCinemaName() + "<br />";
						bookingSucessMsg += "Number of tickets: " + numOfTikets + "<br />";
						bookingSucessMsg += "Total price: " + totalPrice + "<br />";
						bookingSucessMsg += "Booking reference Number: "  + booking.getBookingId() + "<br /><br />";
						sContext.AddToken(token);
					}
				}
				request.setAttribute("bookingSucessMsg", bookingSucessMsg);
				request.getRequestDispatcher(Constent.BOOKINGSUCCESSPAGE).forward(request, response);
				return null;
				
			} catch (NumberFormatException ex) {
				sContext.AddBookingErrMsg = "The number of tickets must be integer";
				historyGoBack1(response);
			}
			return null;
		} else { // show booking page

			request.setAttribute("targetMovie", targetMovie);

			// show time for this movie
			List<Showtime> targetShowtimes = mContext.AllShowtimeM.getDAO()
					.findByMovieId(id);
			request.setAttribute("targetShowtimes", targetShowtimes);
			request.getRequestDispatcher(Constent.ADDBOOKINGPAGE).forward(
					request, response);


			System.out.println("---AddBookingCommand end");

			return null;
		}
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
