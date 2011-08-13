package com.models;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.Timestamp;

import org.hibernate.Transaction;

import com.entities.*;

public class AllFriendsModel implements ListBaseModel<Friends> {

	private FriendsDAO friendsDAO = new FriendsDAO();

	public AllFriendsModel() {

	}

	public List<Friends> findAll() {
		return friendsDAO.findAll();
	}

	public FriendsDAO getDAO() {
		return friendsDAO;
	}

	public void AddFriends(String userA, String userB) {
		if (userA.equals(userB))
			return;
		List<String> us1 = friendsDAO.findByUserA(userA);
		if (us1.contains(userB))
			return;
		// List<String> us2 = friendsDAO.findByUserA(userA);
		// if (us2.contains(userB))
		// return;
		Friends friends1 = new Friends(com.util.Guid.GetGUID(), userA, userB);
//		Friends friends2 = new Friends(com.util.Guid.GetGUID(), userB, userA);
		Transaction tx = friendsDAO.getSession().beginTransaction();
		friendsDAO.save(friends1);
//		friendsDAO.save(friends2);
		tx.commit();
	}

	public void DeleteFriends(String userA, String userB) {
		if (userA.equals(userB))
			return;
//		List<Friends> us1 = friendsDAO.findByUserA(userA);
//		boolean badflag = true;
//		for (Friends f : us1) {
//			if (f.getUserB().equals(userB)) {
//				badflag = false;
//				break;
//			}
//		}
//		if (badflag) return;
		List<Friends> fl1 = friendsDAO.findByUserA(userA);
		Friends f1 = null;
		for (Friends f : fl1) {
			if (f.getUserB().equals(userB))
				f1 = f;
		}
		Transaction tx1 = friendsDAO.getSession().beginTransaction();
		if (f1 != null)
			friendsDAO.delete(f1);
		tx1.commit();
		
		List<Friends> fl2 = friendsDAO.findByUserB(userB);
		Friends f2 = null;
		for (Friends f : fl2) {
			if (f.getUserA().equals(userA))
				f2 = f;
		}
		Transaction tx2 = friendsDAO.getSession().beginTransaction();
		if (f2 != null)
			friendsDAO.delete(f2);
		tx2.commit();
	
	}

	// public FriendInvitation addFriendInvitation( String toUser,
	// String fromUser, String message) {
	// List<FriendInvitation> l = friendInvitationDAO.findByToUser(toUser);
	// if (l.size() > 0) {
	// for (FriendInvitation f : l) {
	// if (f.getFromUser().equals(fromUser)) {
	// return null;
	// }
	// }
	// }
	// FriendInvitation friendInvitation = new
	// FriendInvitation(com.util.Guid.GetGUID(), toUser, fromUser, message,
	// (short)0);
	// Transaction tx = friendInvitationDAO.getSession().beginTransaction();
	// friendInvitationDAO.save(friendInvitation);
	// tx.commit();
	// //refresh invitation repository
	//
	// return friendInvitation;
	// }

}
