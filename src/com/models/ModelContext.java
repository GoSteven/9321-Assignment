package com.models;

import java.util.HashMap;
import com.entities.*;

public class ModelContext {
	
	public static AllUsersModel AllUsersM = null;
	public static AllRolesModel AllRolesM = null;
	public static AllMoviesModel AllMoviesM = null;
	public static AllCinemasModel AllCinemasM = null;
	public static AllShowtimeModel AllShowtimeM = null;
	public static AllCommentsModel AllCommentsM = null;
	public static AllBookingsModel AllBookingsM = null; 
	public static AllFriendInvitationsModel AllFriendInvitationsM = null;
	public static AllFriendsModel AllFriendsM = null;
	public static AllRecommendMoviesModel AllRecommendMoviesM = null; 
	
	public static HashMap AllGenres = new HashMap(); 
	
	public ModelContext() {
		if (AllUsersM == null) {
			AllUsersM = new AllUsersModel();
		}
		if (AllRolesM == null) {
			AllRolesM = new AllRolesModel();
		}
		if (AllMoviesM == null) {
			AllMoviesM = new AllMoviesModel();
		}
		if (AllCinemasM == null) {
			AllCinemasM = new AllCinemasModel();
		}
		if (AllShowtimeM == null){
			AllShowtimeM = new AllShowtimeModel();
		}
		if (AllCommentsM == null) {
			AllCommentsM = new AllCommentsModel();
		}
		if (AllBookingsM == null) {
			AllBookingsM = new AllBookingsModel();
		}
		if (AllFriendInvitationsM == null) {
			AllFriendInvitationsM = new AllFriendInvitationsModel();
		}
		if (AllFriendsM == null) {
			AllFriendsM = new AllFriendsModel();
		}
		if (AllRecommendMoviesM == null) {
			AllRecommendMoviesM = new AllRecommendMoviesModel();
		}
		
		AllGenres.put(Constent.Genres.ACTION, 1);
		AllGenres.put(Constent.Genres.ADVENTURE, 2);
		AllGenres.put(Constent.Genres.COMEDY, 4);
		AllGenres.put(Constent.Genres.CRIME, 8);
		AllGenres.put(Constent.Genres.DRAMA, 16);
		AllGenres.put(Constent.Genres.FAMILY, 32);
		AllGenres.put(Constent.Genres.MUSICAL, 64);
		AllGenres.put(Constent.Genres.ROMANCE, 128);
		AllGenres.put(Constent.Genres.SPORT, 256);
		AllGenres.put(Constent.Genres.WAR, 512);
		
	}
	
}
