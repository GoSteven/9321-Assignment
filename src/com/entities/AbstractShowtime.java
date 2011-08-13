package com.entities;

import java.sql.Timestamp;

/**
 * AbstractShowtime entity provides the base persistence definition of the
 * Showtime entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractShowtime implements java.io.Serializable {

	// Fields

	private String showtimeId;
	private String cinemaId;
	private String movieId;
	private Timestamp showtime;
	private Double price;

	// Constructors

	/** default constructor */
	public AbstractShowtime() {
	}

	/** full constructor */
	public AbstractShowtime(String showtimeId, String cinemaId, String movieId,
			Timestamp showtime, Double price) {
		this.showtimeId = showtimeId;
		this.cinemaId = cinemaId;
		this.movieId = movieId;
		this.showtime = showtime;
		this.price = price;
	}

	// Property accessors

	public String getShowtimeId() {
		return this.showtimeId;
	}

	public void setShowtimeId(String showtimeId) {
		this.showtimeId = showtimeId;
	}

	public String getCinemaId() {
		return this.cinemaId;
	}

	public void setCinemaId(String cinemaId) {
		this.cinemaId = cinemaId;
	}

	public String getMovieId() {
		return this.movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public Timestamp getShowtime() {
		return this.showtime;
	}

	public void setShowtime(Timestamp showtime) {
		this.showtime = showtime;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}