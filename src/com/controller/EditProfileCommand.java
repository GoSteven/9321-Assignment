package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.hibernate.Transaction;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entities.Constent;
import com.entities.User;
import com.models.ModelContext;
import com.models.SessionContext;
import com.util.HashMD5;

public class EditProfileCommand implements Command {

	/**
	 * Constructor of the object.
	 */
	public EditProfileCommand() {
	}

	public String execute(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		System.out.println("---EditProfileCommand begin");
		try {
			HttpSession session = request.getSession();
			ModelContext mContext = (ModelContext)session.getAttribute("MContext");
			SessionContext sContext = (SessionContext)session.getAttribute("SContext");
			if (mContext == null) {
				mContext = new ModelContext();
				session.setAttribute("MContext", mContext);
			}
			if (sContext == null) {
				sContext = new SessionContext();
				session.setAttribute("SContext", sContext);
			}
			String UUserName = request.getParameter("UserName");
			if(UUserName != null && !UUserName.equals("")){
				UUserName = UUserName.trim();
			}
			String UNickName = request.getParameter("NickName");
			if(UNickName != null && !UNickName.equals("")){
				UNickName = UNickName.trim();
			}
			String UFirstName = request.getParameter("FirstName");
			if(UFirstName != null && !UFirstName.equals("")){
				UFirstName = UFirstName.trim();
			}
			String ULastName = request.getParameter("LastName");
			if(ULastName != null && !ULastName.equals("")){
				ULastName = ULastName.trim();
			}
			String UEmail = request.getParameter("Email");
			if(UEmail != null && !UEmail.equals("")){
				UEmail = UEmail.trim();
			}
			String UYearOfBirth = request.getParameter("YearOfBirth");
			if(UYearOfBirth != null && !UYearOfBirth.equals("")){
				UYearOfBirth = UYearOfBirth.trim();
			}
			String UFavGenres_Action = request.getParameter("FavGenres_Action");
			String UFavGenres_Adventure = request.getParameter("FavGenres_Adventure");
			String UFavGenres_Comedy = request.getParameter("FavGenres_Comedy");
			String UFavGenres_Horror = request.getParameter("FavGenres_Horror");
			String UFavGenres_War = request.getParameter("FavGenres_War");
			String UFavGenres_Drama = request.getParameter("FavGenres_Drama");
			int UFavGenres = 0;
			if(UFavGenres_Action != null){
				UFavGenres |= 1;
			}
			if(UFavGenres_Adventure != null){
				UFavGenres |= 2;
			}
			if(UFavGenres_Comedy != null){
				UFavGenres |= 4;
			}
			if(UFavGenres_Horror != null){
				UFavGenres |= 8;
			}
			if(UFavGenres_War != null){
				UFavGenres |= 16;
			}
			if(UFavGenres_Drama != null){
				UFavGenres |= 32;
			}
			String UFavActors = request.getParameter("FavActors");
			if(!UFavActors.equals(null) && !UFavActors.equals("")){
				UFavActors = UFavActors.trim();
			}
			String expression = "^[\\w\\.-_+]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";  
			CharSequence inputStr = UEmail; 
			//Make the comparison case-insensitive.  
			Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);  
			Matcher matcher = pattern.matcher(inputStr);  
			if(!matcher.matches()){    
				sContext.EditErrMsg = "invalid email";
				response.sendRedirect(sContext.BaseURL + Constent.EDITPROFILEPAGE);
			}  
//			check whether the year format is valid
			String year = "^[0-9]{4}$";
			CharSequence inputStr2 = UYearOfBirth;
			Pattern yearPattern = Pattern.compile(year, Pattern.CASE_INSENSITIVE);  
			Matcher yMacher = yearPattern.matcher(inputStr2);
			if(!yMacher.matches()){
				sContext.EditErrMsg = "invalid year of birth";
				response.sendRedirect(sContext.BaseURL + Constent.EDITPROFILEPAGE);
//				response.sendRedirect(Constent.EDITPROFILEPAGE);
			}
			
			/** 
			 * Profile Privacy
			 */
			
			short isFirstNamePublic = request.getParameter("FirstNameC") == null? (short)0 : (short)1;
			short isLastNamePublic = request.getParameter("LastNameC") == null? (short)0 : (short)1;
			short isYearOfBirthPublic = request.getParameter("YearOfBirthC") == null? (short)0 : (short)1;
			short isFavGenrePublic = request.getParameter("FirstNameC") == null? (short)0 : (short)1;
			short isFavActorsPublic = request.getParameter("FavActorsC") == null? (short)0 : (short)1;
			short isCompletePrivate = request.getParameter("CompletePrivateC") == null? (short)0 : (short)1;
			
			User c = sContext.CurrentUser;
			if (c != null) {
				Transaction tx = mContext.AllUsersM.getDAO().getSession().beginTransaction();
				User cu = mContext.AllUsersM.getDAO().findById(c.getUserId());
				cu.setNickName(UNickName);
				cu.setFirstName(UFirstName);
				cu.setLastName(ULastName);
				cu.setEmailAddress(UEmail);
				cu.setYearOfBirth(UYearOfBirth);
				cu.setFavActors(UFavActors);
				cu.setFavGenre(UFavGenres);
				cu.setIsVaildate((short)1);
				
				/**
				 * Profile Privacy
				 */
				cu.setIsFirstNamePublic(isFirstNamePublic);
				cu.setIsLastNamePublic(isLastNamePublic);
				cu.setIsYearOfBirthPublic(isYearOfBirthPublic);
				cu.setIsFavGenrePublic(isFavGenrePublic);
				cu.setIsFavActorsPublic(isFavActorsPublic);
				cu.setIsCompletePrivate(isCompletePrivate);
				mContext.AllUsersM.getDAO().attachDirty(cu);
				tx.commit();
				sContext.IsLoggedIn = true;
				response.sendRedirect(sContext.BaseURL + Constent.SUCCESSPAGE);
			}
			//Finially
		//	mContext.AllUsersM.AddUser(RName, RPassword, REmail, (short)0);
		//	System.out.println("--User Added: " + RName + " " + RPassword + " " + REmail);
			
			
			System.out.println("---EditProfileCommand end");
			response.sendRedirect(sContext.BaseURL + Constent.SUCCESSPAGE);
		} catch (Exception e) {
			System.out.print(e.toString());
		}
		return null;
	}

}
