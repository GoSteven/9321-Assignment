package com.entities;

/**
 * Cinema entity. @author MyEclipse Persistence Tools
 */
public class Cinema extends AbstractCinema implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Cinema() {
	}

	/** full constructor */
	public Cinema(String cinemaId, String cinemaName, String location,
			Integer seatingCapacity, Integer amenities) {
		super(cinemaId, cinemaName, location, seatingCapacity, amenities);
	}

}
