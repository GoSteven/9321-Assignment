package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entities.*;
import com.models.ModelContext;
import com.models.SessionContext;
import com.util.Filter;
import com.util.HashMD5;

public class AddCinemaCommand implements Command {

	/**
	 * Constructor of the object.
	 */
	public AddCinemaCommand() {
	}
//TODO: String title = Filter.escapeHTMLTags(mySmartUpload.getRequest().getParameter("title").trim());
	// escapeHTMLTags!!!! in all command!!
	public String execute(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		System.out.println("---AddCinemaCommand begin");
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
		
		if (!sContext.IsOwner()) {
			response.sendRedirect(sContext.BaseURL + Constent.ACCESSDENIEDPAGE);
			return null;
		}
		
		//done
		
		String CinemaName = request.getParameter("CinemaName");
		if(!CinemaName.equals(null) && !CinemaName.equals("")){
			CinemaName = CinemaName.trim();
		}
		String Location = request.getParameter("Location");
		if(!Location.equals(null) && !Location.equals("")){
			Location = Location.trim();
		}
		String SeatingCapacity = request.getParameter("SeatingCapacity");
		if(!SeatingCapacity.equals(null) && !SeatingCapacity.equals("")){
			SeatingCapacity = SeatingCapacity.trim();
		}
		
		Boolean isInteger = true;
		String Amenities_ATMs = request.getParameter("Amenities_ATMs");
		String Amenities_Widescreen = request.getParameter("Amenities_Widescreen");
		String Amenities_SnackBar = request.getParameter("Amenities_SnackBar");
		String Amenities_Restaurant = request.getParameter("Amenities_Restaurant");
		Integer Amenities = 0;
		if(Amenities_ATMs != null){
			Amenities |= 1;
		}
		if(Amenities_Widescreen !=null){
			Amenities |= 2;
		}
		if(Amenities_SnackBar !=null){
			Amenities |= 4;
		}
		if(Amenities_Restaurant != null){
			Amenities |= 8;
		}
		if (CinemaName.length()==0 || Location.length()==0 || SeatingCapacity.length()==0) {
			sContext.AddCinemaErrMsg = "fileds cannot be empty";
			response.sendRedirect(sContext.BaseURL + Constent.ADDCINEMAPAGE);
			return null;
		}	
//		check if cinema name exist in database
		if(mContext.AllCinemasM.getDAO().findByCinemaName(CinemaName).size() != 0){
			sContext.AddCinemaErrMsg = "Cinema name exists";
			response.sendRedirect(sContext.BaseURL + Constent.ADDCINEMAPAGE);
			return null;
		}
//		check if cinema location exist in database
		if(mContext.AllCinemasM.getDAO().findByLocation(Location).size() != 0){
			sContext.AddCinemaErrMsg = "Location exists";
			response.sendRedirect(sContext.BaseURL + Constent.ADDCINEMAPAGE);
			return null;
		}
		try{
			Integer SeatCapacity = Integer.parseInt(SeatingCapacity);
			mContext.AllCinemasM.AddCinema(CinemaName, Location, SeatCapacity, Amenities);
			System.out.println("--Cinema Added: " + CinemaName + " " + Location + " " + SeatCapacity + " " + Amenities);
			
		}
		catch (NumberFormatException e){
			isInteger = false;
		}	
//		check if seat capacity is integer
		if(!isInteger){
			sContext.AddCinemaErrMsg = "seatCapacity should be an integer";
			response.sendRedirect(sContext.BaseURL + Constent.ADDCINEMAPAGE);
			return null;
		}
		
		//Finially
		
		System.out.println("---AddCinemaCommand end");
		response.sendRedirect(sContext.BaseURL + Constent.SUCCESSPAGE);
	
		return null;
	}

}
