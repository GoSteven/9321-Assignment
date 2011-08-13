package com.entities;

import java.sql.Timestamp;

/**
 * AbstractComment entity provides the base persistence definition of the
 * Comment entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractComment implements java.io.Serializable {

	// Fields

	private String commentId;
	private String movieId;
	private String userId;
	private Integer rating;
	private String commentContent;
	private Timestamp commentTime;

	// Constructors

	/** default constructor */
	public AbstractComment() {
	}

	/** full constructor */
	public AbstractComment(String commentId, String movieId, String userId,
			Integer rating, String commentContent, Timestamp commentTime) {
		this.commentId = commentId;
		this.movieId = movieId;
		this.userId = userId;
		this.rating = rating;
		this.commentContent = commentContent;
		this.commentTime = commentTime;
	}

	// Property accessors

	public String getCommentId() {
		return this.commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getMovieId() {
		return this.movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getRating() {
		return this.rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getCommentContent() {
		return this.commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Timestamp getCommentTime() {
		return this.commentTime;
	}

	public void setCommentTime(Timestamp commentTime) {
		this.commentTime = commentTime;
	}

}