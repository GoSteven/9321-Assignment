package com.entities;

/**
 * FriendInvitation entity. @author MyEclipse Persistence Tools
 */
public class FriendInvitation extends AbstractFriendInvitation implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public FriendInvitation() {
	}

	/** minimal constructor */
	public FriendInvitation(String invitationId, String toUser,
			String fromUser, Short isConfirmed) {
		super(invitationId, toUser, fromUser, isConfirmed);
	}

	/** full constructor */
	public FriendInvitation(String invitationId, String toUser,
			String fromUser, String message, Short isConfirmed) {
		super(invitationId, toUser, fromUser, message, isConfirmed);
	}
	
	public User getFromUserDetail() {
		UserDAO ud = new UserDAO();
		User u = ud.findById(this.getFromUser());
		return u;
	}

}
