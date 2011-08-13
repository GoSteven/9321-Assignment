package com.models;

import java.util.*;
import java.lang.Math;

import com.entities.*;

import javax.servlet.*;

import org.omg.CORBA.Current;


/**
 * This is used for a Java Bean to keep tracking of user status
 * @author Steveny
 *
 */
public class SessionContext {
	
	public String BaseURL = "";
	public ServletConfig ServletConfig = null;
	public Boolean IsLoggedIn = false;// User Login Status
	public User CurrentUser;
	public Boolean IsOwner() {
		if (IsLoggedIn && CurrentUser != null && CurrentUser.getRoleId().equals(Constent.OwnerId))
			return true;
		else 
			return false;
	}
	public String DisplayUserName() {
		if (CurrentUser.getNickName()!=null && !CurrentUser.getNickName().equals(""))
			return CurrentUser.getNickName();
		else
			return CurrentUser.getUserName();
	}
	
	public String RegistErrMsg = "";
	public String LoginErrMsg = "";
	public String AddCinemaErrMsg = "";
	public String EditErrMsg = "";
	public String AddMovieErrMsg = "";
	public String DoSearchErrMsg = "";
	public String ArrangeShowtimeErrMsg = "";
	public String ChangePasswordErrMsg = "";
	public String AddBookingErrMsg = "";
	public String MyBookingErrMsg = "";
	
	public List<User> filteredUsers = null;
//	private List<FriendInvitation> _friendInvitation = null;
	public List<FriendInvitation> getFriendInvitations() {
		List<FriendInvitation> filf  = new ArrayList<FriendInvitation>();
		if (!IsLoggedIn)
			return filf;
//		if (_friendInvitation == null) {
//			_friendInvitation = ModelContext.AllFriendInvitationsM.getDAO().findByToUser(CurrentUser.getUserId());
//		}
		List<FriendInvitation> fil = ModelContext.AllFriendInvitationsM.getDAO().findByToUser(CurrentUser.getUserId());
		
		for (FriendInvitation f : fil) {
			if (f.getIsConfirmed() == 0) 
				filf.add(f);
		}
		return filf;
	}
	
	public boolean IsFriendWith(User uu) {
		for (User u : getMyFriends()) {
			if (u.getUserId().equals(uu.getUserId())) {
				return true;
			}
		}
		return false;
	}
	
	public List<RecommendMovie> getUnReadRecommendMovies() {
		List<RecommendMovie> ref = new ArrayList<RecommendMovie>();
		if (!IsLoggedIn)
			return ref;
		List<RecommendMovie> re = ModelContext.AllRecommendMoviesM.getDAO().findByToUser(CurrentUser.getUserId());
		for (RecommendMovie r : re) {
			if (r.getIsReaded() == 0)
				ref.add(r);
		}
		return ref;
	}
	
	public List<RecommendMovie> getReadedRecommendMovies() {
		List<RecommendMovie> ref = new ArrayList<RecommendMovie>();
		if (!IsLoggedIn)
			return ref;
		List<RecommendMovie> re = ModelContext.AllRecommendMoviesM.getDAO().findByToUser(CurrentUser.getUserId());
		for (RecommendMovie r : re) {
			if (r.getIsReaded() == 1)
				ref.add(r);
		}
		return ref;
	} 
	
	public List<User> getMyFriends() {
		List<User> friends = new ArrayList<User>();
		if (!IsLoggedIn)
			return friends;
		List<Friends> fil1 = ModelContext.AllFriendsM.getDAO().findByUserA(CurrentUser.getUserId());
		
		for (Friends f : fil1) {
			friends.add(ModelContext.AllUsersM.getDAO().findById(f.getUserB()));
		}
		List<Friends> fil2 = ModelContext.AllFriendsM.getDAO().findByUserB(CurrentUser.getUserId());
		for (Friends f : fil2) {
			friends.add(ModelContext.AllUsersM.getDAO().findById(f.getUserA()));
		}
		return friends;
	}
	
	public List<Movies> SearchedMovies = null;
	public List<Movies> MyList = new ArrayList<Movies>();
	public HashMap Tokens = new HashMap();
	public boolean IsTokenExist(String s) {
		if (Tokens.containsKey(s)) {
			return true;
		}
		return false;
	}
	public void AddToken(String s) {
		Tokens.put(s, "1");
	}
	
	public List<Movies> CommingSoonMovies() {
		List<Movies> all = ModelContext.AllMoviesM.findAll();
		List<Movies> comming = new ArrayList<Movies>();
		int count = 0;
		for (Movies m : all) {
			if (m.getReleaseDate().after(new Date())) {
				comming.add(m);
				count ++;
			}
		}
		Sort(comming);
		return comming;
	}
	
	public List<Movies> NowShowingMovies() {
		List<Movies> all = ModelContext.AllMoviesM.findAll();
		List<Movies> showing = new ArrayList<Movies>();
		int count = 0;
		for (Movies m : all) {
			if (m.getReleaseDate().before(new Date())) {
				showing.add(m);
				count ++;
			}
		}
		return showing;
	}
	
	public List<Movies> RecommendMovies() {
		List<Movies> all = ModelContext.AllMoviesM.findAll();
		List<Movies> rec = new ArrayList<Movies>();
		int targetGenres = 1;
		try {
		if (CurrentUser != null)
			targetGenres =  CurrentUser.getFavGenre();
		} catch (Exception ex) {
			targetGenres = 256 -1;
		}
		int count = 0;
        for (Movies m : all) {
        	int mFlag = 1;
        	
    		if ((m.getGenre() & targetGenres) == 0) {
    			mFlag = 0;
    		}
        	
        	//then 
        	if (mFlag == 1) {
        		rec.add(m);
        		count ++;
        	}
        }
		return rec;
	}
	
	public static void Sort(List<Movies> items) {
		Collections.sort(items, SENIORITY_ORDER);
	}
	static final Comparator<Movies> SENIORITY_ORDER =
        new Comparator<Movies>() {
			public int compare(Movies e1, Movies e2) {
				if (e1.getReleaseDate().after(e2.getReleaseDate()))
					return 1;
				else
					return -1;
				
			}
		};
	
	public String Login(String userName, String passWord){
		String errMsg = "";
		//TODO Login Validation , return error message
		return errMsg;
	}
	
}
