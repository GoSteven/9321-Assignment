package com.models;

import java.sql.Timestamp;
import java.util.*;

import org.hibernate.Transaction;

import com.entities.*;

public class AllCommentsModel implements ListBaseModel<Comment> {
	private CommentDAO commentDAO = new CommentDAO();
	public AllCommentsModel() {
		super();
	}
	
	public List<Comment> findAll() {
		return commentDAO.findAll();
	}
	
	public CommentDAO getDAO() {
		return commentDAO;
	}
	
	public void AddComment(String movieId, String userId,
			Integer rating, String commentContent) {
		java.util.Date today = new java.util.Date();
		Comment comment = new Comment(com.util.Guid.GetGUID(), movieId, userId, rating, commentContent, new java.sql.Timestamp(today.getTime()));
		Transaction tx = commentDAO.getSession().beginTransaction();
		commentDAO.save(comment);
		tx.commit();
	}
	
	public List<Comment> getMovieRelatedComments(Movies movie) {
		List<Comment> comments = commentDAO.findByMovieId(movie.getMovieId());
		//TODO: sort comments
		
		return comments;
	}
	
}
