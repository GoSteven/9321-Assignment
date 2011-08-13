package com.entities;

import java.util.Date;

/**
 * AbstractMovies entity provides the base persistence definition of the Movies
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractMovies implements java.io.Serializable {

	// Fields

	private String movieId;
	private String movieTitle;
	private String poster;
	private String youtubeLink;
	private String actors;
	private Integer genre;
	private String director;
	private String shortSynopsis;
	private Integer ageRating;
	private Date releaseDate;
	private Date expireDate;

	// Constructors

	/** default constructor */
	public AbstractMovies() {
	}

	/** minimal constructor */
	public AbstractMovies(String movieId, String movieTitle) {
		this.movieId = movieId;
		this.movieTitle = movieTitle;
	}

	/** full constructor */
	public AbstractMovies(String movieId, String movieTitle, String poster,
			String youtubeLink, String actors, Integer genre, String director,
			String shortSynopsis, Integer ageRating, Date releaseDate,
			Date expireDate) {
		this.movieId = movieId;
		this.movieTitle = movieTitle;
		this.poster = poster;
		this.youtubeLink = youtubeLink;
		this.actors = actors;
		this.genre = genre;
		this.director = director;
		this.shortSynopsis = shortSynopsis;
		this.ageRating = ageRating;
		this.releaseDate = releaseDate;
		this.expireDate = expireDate;
	}

	// Property accessors

	public String getMovieId() {
		return this.movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getMovieTitle() {
		return this.movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public String getPoster() {
		return this.poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getYoutubeLink() {
		return this.youtubeLink;
	}

	public void setYoutubeLink(String youtubeLink) {
		this.youtubeLink = youtubeLink;
	}

	public String getActors() {
		return this.actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public Integer getGenre() {
		return this.genre;
	}

	public void setGenre(Integer genre) {
		this.genre = genre;
	}

	public String getDirector() {
		return this.director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getShortSynopsis() {
		return this.shortSynopsis;
	}

	public void setShortSynopsis(String shortSynopsis) {
		this.shortSynopsis = shortSynopsis;
	}

	public Integer getAgeRating() {
		return this.ageRating;
	}

	public void setAgeRating(Integer ageRating) {
		this.ageRating = ageRating;
	}

	public Date getReleaseDate() {
		return this.releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Date getExpireDate() {
		return this.expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

}