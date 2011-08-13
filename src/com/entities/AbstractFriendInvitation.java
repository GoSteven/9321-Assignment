package com.entities;

/**
 * AbstractFriendInvitation entity provides the base persistence definition of
 * the FriendInvitation entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractFriendInvitation implements java.io.Serializable {

	// Fields

	private String invitationId;
	private String toUser;
	private String fromUser;
	private String message;
	private Short isConfirmed;

	// Constructors

	/** default constructor */
	public AbstractFriendInvitation() {
	}

	/** minimal constructor */
	public AbstractFriendInvitation(String invitationId, String toUser,
			String fromUser, Short isConfirmed) {
		this.invitationId = invitationId;
		this.toUser = toUser;
		this.fromUser = fromUser;
		this.isConfirmed = isConfirmed;
	}

	/** full constructor */
	public AbstractFriendInvitation(String invitationId, String toUser,
			String fromUser, String message, Short isConfirmed) {
		this.invitationId = invitationId;
		this.toUser = toUser;
		this.fromUser = fromUser;
		this.message = message;
		this.isConfirmed = isConfirmed;
	}

	// Property accessors

	public String getInvitationId() {
		return this.invitationId;
	}

	public void setInvitationId(String invitationId) {
		this.invitationId = invitationId;
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

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Short getIsConfirmed() {
		return this.isConfirmed;
	}

	public void setIsConfirmed(Short isConfirmed) {
		this.isConfirmed = isConfirmed;
	}

}