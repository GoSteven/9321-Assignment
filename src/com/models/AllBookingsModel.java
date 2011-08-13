package com.models;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.Timestamp;

import org.hibernate.Transaction;

import com.entities.*;
public class AllBookingsModel implements ListBaseModel<Booking> {

	private BookingDAO bookingDAO = new BookingDAO();
	public AllBookingsModel() {
		
	}
	
	public List<Booking> findAll() {
		return bookingDAO.findAll();
	}
	
	public BookingDAO getDAO () {
		return bookingDAO;
	}
	public Booking AddBooking(String userId, String showTimeId,
			Integer numOfTicket) {
		Booking newbooking = new Booking(com.util.Guid.GetGUID(), userId, showTimeId, numOfTicket);
		Transaction tx = bookingDAO.getSession().beginTransaction();
		bookingDAO.save(newbooking);
		tx.commit();
		return newbooking;
	}
}
