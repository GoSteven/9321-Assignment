package com.entities;

/**
 * RecommendMovie entity. @author MyEclipse Persistence Tools
 */
public class RecommendMovie extends AbstractRecommendMovie implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public RecommendMovie() {
	}

	/** full constructor */
	public RecommendMovie(String recommendId, String toUser, String fromUser,
			String movieId, Short isReaded) {
		super(recommendId, toUser, fromUser, movieId, isReaded);
	}

}
