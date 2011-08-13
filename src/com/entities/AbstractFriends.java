package com.entities;

/**
 * AbstractFriends entity provides the base persistence definition of the
 * Friends entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractFriends implements java.io.Serializable {

	// Fields

	private String friendsId;
	private String userA;
	private String userB;

	// Constructors

	/** default constructor */
	public AbstractFriends() {
	}

	/** full constructor */
	public AbstractFriends(String friendsId, String userA, String userB) {
		this.friendsId = friendsId;
		this.userA = userA;
		this.userB = userB;
	}

	// Property accessors

	public String getFriendsId() {
		return this.friendsId;
	}

	public void setFriendsId(String friendsId) {
		this.friendsId = friendsId;
	}

	public String getUserA() {
		return this.userA;
	}

	public void setUserA(String userA) {
		this.userA = userA;
	}

	public String getUserB() {
		return this.userB;
	}

	public void setUserB(String userB) {
		this.userB = userB;
	}

}