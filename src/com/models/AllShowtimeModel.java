package com.models;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.Timestamp;

import org.hibernate.Transaction;

import com.entities.*;
public class AllShowtimeModel implements ListBaseModel<Showtime> {

	private ShowtimeDAO showtimeDAO = new ShowtimeDAO();
	public AllShowtimeModel() {
		
	}
	
	public List<Showtime> findAll() {
		return showtimeDAO.findAll();
	}
	
	public ShowtimeDAO getDAO () {
		return showtimeDAO;
	}
	public void AddShowtime(String cinemaid, String movieid, Timestamp showtime, Double price) {
		Showtime newShowtime = new Showtime(com.util.Guid.GetGUID(), cinemaid, movieid, showtime, price);
		Transaction tx = showtimeDAO.getSession().beginTransaction();
		showtimeDAO.save(newShowtime);
		tx.commit();
	}
}
