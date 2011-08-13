package com.models;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.Timestamp;

import org.hibernate.Transaction;

import com.entities.*;
public class AllFriendInvitationsModel implements ListBaseModel<FriendInvitation> {

	private FriendInvitationDAO friendInvitationDAO = new FriendInvitationDAO();
	public AllFriendInvitationsModel() {
		
	}
	
	public List<FriendInvitation> findAll() {
		return friendInvitationDAO.findAll();
	}
	
	public FriendInvitationDAO getDAO () {
		return friendInvitationDAO;
	}
	
	public FriendInvitation addFriendInvitation( String toUser,
			String fromUser, String message) {
		List<FriendInvitation> l = friendInvitationDAO.findByToUser(toUser);
		if (l.size() > 0) {
			for (FriendInvitation f : l) {
				if (f.getIsConfirmed() == 0 && f.getFromUser().equals(fromUser)) {
					return null;
				}
			}
		}
		FriendInvitation friendInvitation = new FriendInvitation(com.util.Guid.GetGUID(), toUser, fromUser, message, (short)0);
		Transaction tx = friendInvitationDAO.getSession().beginTransaction();
		friendInvitationDAO.save(friendInvitation);
		tx.commit();
		//refresh invitation repository
		
		return friendInvitation;
	}
	
	public void markAsConfirmed( String id) {
		Transaction tx = friendInvitationDAO.getSession().beginTransaction();
		FriendInvitation friendInvitation = friendInvitationDAO.findById(id);
		friendInvitation.setIsConfirmed((short)1);
		friendInvitationDAO.attachDirty(friendInvitation);
		tx.commit();
	}
	
}
