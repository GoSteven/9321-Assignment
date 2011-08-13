package com.entities;

import java.sql.Timestamp;

/**
 * Comment entity. @author MyEclipse Persistence Tools
 */
public class Comment extends AbstractComment implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Comment() {
	}

	/** full constructor */
	public Comment(String commentId, String movieId, String userId,
			Integer rating, String commentContent, Timestamp commentTime) {
		super(commentId, movieId, userId, rating, commentContent, commentTime);
	}
	
	public String getUserName() {
		UserDAO userDAO = new UserDAO();
		User user = userDAO.findById(getUserId());
		if (user.getNickName() == null || user.getNickName() == "") {
			return user.getNickName();
		} else {
			return user.getUserName();
		}
	}

}
