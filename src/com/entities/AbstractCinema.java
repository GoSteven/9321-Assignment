package com.entities;

/**
 * AbstractCinema entity provides the base persistence definition of the Cinema
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractCinema implements java.io.Serializable {

	// Fields

	private String cinemaId;
	private String cinemaName;
	private String location;
	private Integer seatingCapacity;
	private Integer amenities;

	// Constructors

	/** default constructor */
	public AbstractCinema() {
	}

	/** full constructor */
	public AbstractCinema(String cinemaId, String cinemaName, String location,
			Integer seatingCapacity, Integer amenities) {
		this.cinemaId = cinemaId;
		this.cinemaName = cinemaName;
		this.location = location;
		this.seatingCapacity = seatingCapacity;
		this.amenities = amenities;
	}

	// Property accessors

	public String getCinemaId() {
		return this.cinemaId;
	}

	public void setCinemaId(String cinemaId) {
		this.cinemaId = cinemaId;
	}

	public String getCinemaName() {
		return this.cinemaName;
	}

	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getSeatingCapacity() {
		return this.seatingCapacity;
	}

	public void setSeatingCapacity(Integer seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	public Integer getAmenities() {
		return this.amenities;
	}

	public void setAmenities(Integer amenities) {
		this.amenities = amenities;
	}

}