package com.entities;

/**
 * Booking entity. @author MyEclipse Persistence Tools
 */
public class Booking extends AbstractBooking implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Booking() {
	}

	/** full constructor */
	public Booking(String bookingId, String userId, String showTimeId,
			Integer numOfTicket) {
		super(bookingId, userId, showTimeId, numOfTicket);
	}

}
