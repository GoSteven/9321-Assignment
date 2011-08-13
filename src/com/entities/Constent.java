package com.entities;

public final class Constent {
	static public final String OwnerId = "1";
	static public final String ViewerId = "0";
	
	//: Edit Profile Privacy settings
	//: Find Friends user detail display by privacy settings
	//: Friend Invitation user detail
	//: Confirm Friend
	//TODO: Recommend to Friends
	//: My Friends List
	
//	pages
	static public final String INDEXPAGE = "/index.jsp";
	static public final String SUCCESSPAGE = "/Success.jsp";
	static public final String FailPAGE = "/Fail.jsp";
	static public final String ACCESSDENIEDPAGE = "/AccessDenied.jsp";
	static public final String CONTROLLERSERVLET = "/dispatcher?operation=";
	
//	user related
	static public final String LOGINPAGE = "/Login.jsp";
	static public final String REGISTPAGE = "/Regist.jsp";
	static public final String EDITPROFILEPAGE = "/EditProfile.jsp";
	static public final String CHANGEPASSWORDPAGE = "/ChangePassword.jsp";
	static public final String FINDFRIENDSPAGE = "/FindFriends.jsp";
	static public final String FINDFRIENDSRESULTPAGE = "/FindFriendsResult.jsp";
	static public final String ADDFRIENDREQUESTPAGE = "/AddFriendRequest.jsp";
	static public final String FRIENDINVITATIONDETAILPAGE = "/FriendInvitationDetail.jsp";
	static public final String MYFRIENDSPAGE = "/MyFriends.jsp";
	static public final String RECOMMENDEDMOVIESSPAGE = "/RecommendedMovies.jsp";
	static public final String READEDRECOMMENDEDMOVIESSPAGE = "/ReadedRecommendedMovies.jsp";
	static public final String UGUYSAREFRIENSPAGE = "/UGugsAreFriends.jsp";
	
	
	

//	admin
	static public final String ADDCINEMAPAGE = "/AddCinema.jsp";
	static public final String ADDMOVIEPAGE = "/AddMovie.jsp";
	static public final String ARRANGESHOWTIMEPAGE = "/ArrangeShowTime.jsp";
	static public final String ADMINPAGE = "/Admin.jsp";
	
//	movie
	static public final String DOSEARCHPAGE = "/DoSearch.jsp";
	static public final String SEARCHRESULTPAGE = "/SearchResult.jsp";
	static public final String SHOWDETAILPAGE = "/ShowDetail.jsp";
	static public final String ADDBOOKINGPAGE = "/AddBooking.jsp";
	static public final String BOOKINGSUCCESSPAGE = "/BookingSuccess.jsp";
	
	
	
//	commands
	static public final String LOGIN_CMD = "login";
	static public final String REGIST_CMD = "regist";
	static public final String CONFIRMREG_CMD = "confirmreg";
	static public final String ADDMOVIE_CMD = "addmovie";
	static public final String ARRENGESHOWTIME_CMD = "arrangeshowtime";
	static public final String DOSEARCH_CMD = "dosearch";
	static public final String SHOWDETAIL_CMD = "showdetail";
	static public final String CHANGEPASSWORD_CMD = "changepassword";
	static public final String DOBOOKING_CMD = "dobooking";
	static public final String ADDTOMYLIST_CMD = "addtomylist";
	static public final String MYBOOKINGS_CMD = "mybookings";
	static public final String FINDFRIENDS_CMD = "findfriends";
	static public final String ADDFRIENDREQUEST_CMD = "addfriendrequest";
	static public final String CONFIRMFRIEND_CMD = "confirmfriend";
	static public final String RECOMMONDTOFRIENDS_CMD = "recommendtofriends";
	
//	genres
	public final class Genres {
		static public final String ACTION = "action";
		static public final String ADVENTURE = "adventure";
		static public final String COMEDY = "comedy";
		static public final String CRIME = "crime";
		static public final String DRAMA = "drama";
		static public final String FAMILY = "family";
		static public final String MUSICAL = "musical";
		static public final String SPORT = "sport";
		static public final String WAR = "war";
		static public final String ROMANCE = "romance";
	}
	
	
}
