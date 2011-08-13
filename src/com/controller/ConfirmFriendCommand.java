package com.controller;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entities.*;
import com.models.ModelContext;
import com.models.SessionContext;

import com.util.*;

public class ConfirmFriendCommand implements Command {

	public ConfirmFriendCommand() {
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("---AddBookingCommand begin");
		HttpSession session = request.getSession();
		ModelContext mContext = (ModelContext) session.getAttribute("MContext");
		SessionContext sContext = (SessionContext) session
				.getAttribute("SContext");
		if (mContext == null) {
			mContext = new ModelContext();
			session.setAttribute("MContext", mContext);
		}
		if (sContext == null) {
			sContext = new SessionContext();
			session.setAttribute("SContext", sContext);
		}

//		 if delete friend
		if (request.getParameter("delete") != null
				&& request.getParameter("delete").equals("true")) {
			String id = request.getParameter("id");
			if (id == null || id.equals("") || !sContext.IsLoggedIn
					|| sContext.CurrentUser == null) {
				historyGoBack1(response);
				return null;
			}
			User targetUser = mContext.AllUsersM.getDAO().findById(id);
			if (targetUser == null) {// this shouldn't happen at all
				response.sendRedirect(sContext.BaseURL + Constent.INDEXPAGE);
				return null;
			}
			//delete friend
			mContext.AllFriendsM.DeleteFriends(id, sContext.CurrentUser.getUserId());
			response.sendRedirect(sContext.BaseURL + Constent.MYFRIENDSPAGE);
		} else {
//		Add as frined
			boolean addFriend = false, ignore = false;
			if (request.getParameter("AddFriend") != null)
				addFriend = true;
			if (request.getParameter("Ignore") != null)
				ignore = true;
			String id = request.getParameter("userId");
			String invitationId = request.getParameter("InvitationId");
			if (id == null || id.equals("") || invitationId == null
					|| invitationId.equals("") || !sContext.IsLoggedIn
					|| sContext.CurrentUser == null || (!addFriend && !ignore)) {
				historyGoBack1(response);
				return null;
			}

			User targetUser = mContext.AllUsersM.getDAO().findById(id);
			if (targetUser == null) {// this shouldn't happen at all
				response.sendRedirect(sContext.BaseURL + Constent.INDEXPAGE);
				return null;
			}

			FriendInvitation fin = mContext.AllFriendInvitationsM.getDAO()
					.findById(invitationId);
			if (fin == null) {// this shouldn't happen at all
				response.sendRedirect(sContext.BaseURL + Constent.INDEXPAGE);
				return null;
			}

			// Add friend,mard as confirmed
			if (addFriend) {
				ModelContext.AllFriendsM.AddFriends(
						sContext.CurrentUser.getUserId(),
						targetUser.getUserId());
			}
			ModelContext.AllFriendInvitationsM.markAsConfirmed(invitationId);

			response.sendRedirect(sContext.BaseURL + Constent.MYFRIENDSPAGE);
		}
		return null;
	}

	private void historyGoBack1(HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<script language=\"javascript\" type=\"text/javascript\">");
		out.println("window.history.go(-1)");
		out.println("</script>");
		out.flush();
		out.close();

	}

}
