package com.entities;

import java.util.Date;
import java.util.List;

/**
 * Movies entity. @author MyEclipse Persistence Tools
 */
public class Movies extends AbstractMovies implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Movies() {
	}

	/** minimal constructor */
	public Movies(String movieId, String movieTitle) {
		super(movieId, movieTitle);
	}

	/** full constructor */
	public Movies(String movieId, String movieTitle, String poster,
			String youtubeLink, String actors, Integer genre, String director,
			String shortSynopsis, Integer ageRating, Date releaseDate,
			Date expireDate) {
		super(movieId, movieTitle, poster, youtubeLink, actors, genre,
				director, shortSynopsis, ageRating, releaseDate, expireDate);
	}
	
	
	public int getRating() {
		CommentDAO commentDAO = new CommentDAO();
		List<Comment> clist = commentDAO.findByMovieId(getMovieId());
		int rating = 0;
		for (Comment c : clist) {
			rating += c.getRating();
		}
		return rating;
	}
	
	public boolean isReleased() {
		if (getReleaseDate().before(new Date())) {
			return true;
		}
		return false;
	}

}
