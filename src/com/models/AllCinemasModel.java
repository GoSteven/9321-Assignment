package com.models;

import java.util.List;

import org.hibernate.Transaction;

import com.entities.*;

public class AllCinemasModel implements ListBaseModel<Cinema> {
	CinemaDAO cinemaDAO = new CinemaDAO();
	public List<Cinema> findAll() {
		return cinemaDAO.findAll();
	}
	
	public CinemaDAO getDAO() {
		return cinemaDAO;
	}
	
	public void AddCinema(String cinemaName, String location,
			Integer seatingCapacity, Integer amenities) {
		Cinema newCinema = new Cinema(com.util.Guid.GetGUID(), cinemaName, location, seatingCapacity, amenities);
		Transaction tx = cinemaDAO.getSession().beginTransaction();
		cinemaDAO.save(newCinema);
		tx.commit();
	}
}
