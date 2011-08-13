package com.entities;

/**
 * AbstractRecommendMovie entity provides the base persistence definition of the
 * RecommendMovie entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractRecommendMovie implements java.io.Serializable {

	// Fields

	private String recommendId;
	private String toUser;
	private String fromUser;
	private String movieId;
	private Short isReaded;

	// Constructors

	/** default constructor */
	public AbstractRecommendMovie() {
	}

	/** full constructor */
	public AbstractRecommendMovie(String recommendId, String toUser,
			String fromUser, String movieId, Short isReaded) {
		this.recommendId = recommendId;
		this.toUser = toUser;
		this.fromUser = fromUser;
		this.movieId = movieId;
		this.isReaded = isReaded;
	}

	// Property accessors

	public String getRecommendId() {
		return this.recommendId;
	}

	public void setRecommendId(String recommendId) {
		this.recommendId = recommendId;
	}

	public String getToUser() {
		return this.toUser;
	}

	public void setToUser(String toUser) {
		this.toUser = toUser;
	}

	public String getFromUser() {
		return this.fromUser;
	}

	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}

	public String getMovieId() {
		return this.movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public Short getIsReaded() {
		return this.isReaded;
	}

	public void setIsReaded(Short isReaded) {
		this.isReaded = isReaded;
	}

}