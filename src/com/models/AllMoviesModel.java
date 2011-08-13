package com.models;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.Transaction;

import com.entities.*;

public class AllMoviesModel implements ListBaseModel<Movies> {
	private MoviesDAO moviesDAO = new MoviesDAO();
	public AllMoviesModel() {
		
	}
	
	public List<Movies> findAll() {
		return moviesDAO.findAll();
	}
	
	public MoviesDAO getDAO () {
		return moviesDAO;
	}
	
	public void Movie(String movietitle, String actorsandactresses,
			Integer genres, String director, String shortsynopsis, Integer AgeRate, Date ReleaseDate) {
		//TODO: use UserDAO add new user,  and validate the
//		User user = new User(com.util.Guid.GetGUID(), userName, password, emailAddress, isVaildate);
//		Transaction tx = userDAO.getSession().beginTransaction();
//		userDAO.save(user);
//		tx.commit();
	}
	public void AddMovie(String movieTitle, String Poster, String youtubelink, String actors, int genre, 
			String director, String synopsis, int agerating, Date rdate, Date edate) {
		Movies newMovie = new Movies(com.util.Guid.GetGUID(), movieTitle, Poster, youtubelink, actors, genre, director, synopsis, agerating, rdate, edate);
		Transaction tx = moviesDAO.getSession().beginTransaction();
		moviesDAO.save(newMovie);
		tx.commit();
	}
	
	
}
