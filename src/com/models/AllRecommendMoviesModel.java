package com.models;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.Timestamp;

import org.hibernate.Transaction;

import com.entities.*;

public class AllRecommendMoviesModel implements ListBaseModel<RecommendMovie> {

	private RecommendMovieDAO recommendMovieDAO = new RecommendMovieDAO();

	public AllRecommendMoviesModel() {

	}

	public List<RecommendMovie> findAll() {
		return recommendMovieDAO.findAll();
	}

	public RecommendMovieDAO getDAO() {
		return recommendMovieDAO;
	}

	public void addRecommend(String movieId, String fromUser,
			List<String> toUsers) {
		Transaction tx = recommendMovieDAO.getSession().beginTransaction();
		for (String s : toUsers) {
			RecommendMovie recommendMovie = new RecommendMovie(
					com.util.Guid.GetGUID(), s, fromUser, movieId, (short) 0);
			recommendMovieDAO.save(recommendMovie);
		}
		tx.commit();
	}

	public void markAsReaded(String id) {
		RecommendMovie recommendMovie = recommendMovieDAO.findById(id);
		if (recommendMovie != null) {
			Transaction tx = recommendMovieDAO.getSession().beginTransaction();
			recommendMovie.setIsReaded((short) 1);
			recommendMovieDAO.attachDirty(recommendMovie);
			tx.commit();
		}
	}

}
