package com.entities;

/**
 * Friends entity. @author MyEclipse Persistence Tools
 */
public class Friends extends AbstractFriends implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Friends() {
	}

	/** full constructor */
	public Friends(String friendsId, String userA, String userB) {
		super(friendsId, userA, userB);
	}

}
