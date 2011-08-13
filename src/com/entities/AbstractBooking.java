package com.entities;

/**
 * AbstractBooking entity provides the base persistence definition of the
 * Booking entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractBooking implements java.io.Serializable {

	// Fields

	private String bookingId;
	private String userId;
	private String showTimeId;
	private Integer numOfTicket;

	// Constructors

	/** default constructor */
	public AbstractBooking() {
	}

	/** full constructor */
	public AbstractBooking(String bookingId, String userId, String showTimeId,
			Integer numOfTicket) {
		this.bookingId = bookingId;
		this.userId = userId;
		this.showTimeId = showTimeId;
		this.numOfTicket = numOfTicket;
	}

	// Property accessors

	public String getBookingId() {
		return this.bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getShowTimeId() {
		return this.showTimeId;
	}

	public void setShowTimeId(String showTimeId) {
		this.showTimeId = showTimeId;
	}

	public Integer getNumOfTicket() {
		return this.numOfTicket;
	}

	public void setNumOfTicket(Integer numOfTicket) {
		this.numOfTicket = numOfTicket;
	}

}