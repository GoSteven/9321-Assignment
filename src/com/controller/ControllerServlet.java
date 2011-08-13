/*
 * ControllerServlet.java
 *
 * Created on 9 August 2003, 10:58
 */

package com.controller;

import java.io.*;

import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.entities.Constent;
import com.models.ModelContext;
import com.models.SessionContext;

/**
 * Controller Servlet that accepts all client requests and performs the
 * lookup required to process the request. This class uses the command
 * design pattern to find the required <i>Command</i> class that will
 * process the request.
 * 
 * @author $author
 * @version
 */
public class ControllerServlet extends HttpServlet {
	
	private Map commands;
	private ServletConfig _config = null;
	
	/** 
	 * Initializes the servlet.
	 */
	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		_config = config;

		commands = new HashMap();

		commands.put("login", new LoginCommand());
		commands.put("regist", new RegistCommand());
		commands.put("confirmreg", new ConfirmRegCommand());
		commands.put("addcinema", new AddCinemaCommand());
		commands.put("addmovie", new AddMovieCommand());
		commands.put("editprofile", new EditProfileCommand());
		commands.put("arrangeshowtime", new ArrangeShowTimeCommand());
		commands.put("dosearch", new DoSearchCommand());
		commands.put("showdetail", new ShowDetailCommand());
		commands.put("changepassword", new ChangePasswordCommand());
		commands.put("dobooking", new AddBookingCommand());
		commands.put("addtomylist", new AddToMyListCommand());
		commands.put("showcinemamovies", new ShowCinemaMoviesCommand());
		commands.put("mybookings", new MyBookingCommand());
		commands.put("findfriends", new FindFriendsCommand());
		commands.put("addfriendrequest", new AddFriendRequestCommand());
		commands.put(Constent.CONFIRMFRIEND_CMD, new ConfirmFriendCommand());
		commands.put(Constent.RECOMMONDTOFRIENDS_CMD, new RecommondToFriendsCommand());
		

	}

	/** 
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	 * @param request servlet request
	 * @param response servlet response
	 */
	protected void resolveCommand(
		HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		System.out.println("---Controller begin");
		
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
		
		if (sContext.ServletConfig == null) {
			sContext.ServletConfig = _config;
		}
		
		if (sContext.BaseURL == "") {
			sContext.BaseURL = request.getScheme()+"://"+request.getServerName()+":"+
			request.getServerPort()+request.getContextPath();
		}
		
		
		// TODO: find the command that was requested by 
		// the client and then call the execute method
		try {
			Command cmd = (Command) commands.get(request.getParameter("operation"));
			if (cmd == null) {
		        cmd = (Command) commands.get("PAGE_NOT_FOUND");
			}
			System.out.println("---Controller end");
			
			cmd.execute(request, response);
		} catch (Exception ex) {
			System.out.println("-------------------------------------");
			System.out.println("---------Excue Command Error---------");
			System.out.println(ex.toString());
			System.out.println("-------------------------------------");
			response.sendRedirect(sContext.BaseURL + Constent.FailPAGE);
			
//			TODO: in catch , history goback -1
		}

	}

	/** 
	 * Handles the HTTP <code>GET</code> method.
	 * @param request servlet request
	 * @param response servlet response
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

	    resolveCommand(request, response);
	}
	
	/** 
	 * Handles the HTTP <code>POST</code> method.
	 * @param request servlet request
	 * @param response servlet response
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

	    resolveCommand(request, response);
	}
	
	/** Returns a short description of the servlet.
	 */
	public String getServletInfo() {
		return "Controller for the application";
	}
}
