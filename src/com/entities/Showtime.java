package com.entities;

import java.sql.Timestamp;

/**
 * Showtime entity. @author MyEclipse Persistence Tools
 */
public class Showtime extends AbstractShowtime implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Showtime() {
	}

	/** full constructor */
	public Showtime(String showtimeId, String cinemaId, String movieId,
			Timestamp showtime, Double price) {
		super(showtimeId, cinemaId, movieId, showtime, price);
	}
	
	public String getCinemaName() {
		CinemaDAO cinemaDAO = new CinemaDAO();
		return cinemaDAO.findById(getCinemaId()).getCinemaName();
	}

}
