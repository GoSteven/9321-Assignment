package com.controller;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
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

public class FindFriendsCommand implements Command {

	public FindFriendsCommand() {
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("---DoSearchCommand begin");
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

		// //////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\////////////////
		List<User> filteredUsers = new ArrayList<User>();

		if (!sContext.IsLoggedIn) {
			request.setAttribute("SearchFriendMsg",
					"Access denied, please login");
		} else {

			boolean isSearchFriendName = false, isSearchYearOfBirth = false;

			String FriendName = request.getParameter("FriendName");
			if (FriendName != null && !FriendName.trim().equals("")) {
				FriendName = FriendName.trim();
				isSearchFriendName = true;
			}
			String YearOfBirthFrom = request.getParameter("YearOfBirthFrom");
			String YearOfBirthTo = request.getParameter("YearOfBirthTo");
			int from = 0, to = 0;
			List<String> actorsList = new ArrayList<String>();
			if (YearOfBirthFrom != null && YearOfBirthTo != null
					&& !YearOfBirthFrom.trim().equals("")
					&& !YearOfBirthTo.trim().equals("")) {
				try {
					from = Integer.parseInt(YearOfBirthFrom);
					to = Integer.parseInt(YearOfBirthTo);
					isSearchYearOfBirth = true;
				} catch (Exception ex) {
					request.setAttribute("SearchFriendMsg",
					"YearOfBirthFrom YearOfBirthTo Invalide");
				}

			}

			List<User> allUsers = mContext.AllUsersM.findAll();

			for (User u : allUsers) {
				boolean uFlag = true;
				if (u.getRoleId() == "1")
					uFlag = false;
				if (u.getIsVaildate()==0)
					uFlag = false;
				if (u.getIsCompletePrivate() == 1) // skip private user
					uFlag = false;
				if (isSearchFriendName) {
					String tmpname = u.getUserName() + u.getFirstName()
							+ u.getLastName() + u.getNickName();
					if (!u.getUserName().toLowerCase()
							.contains(FriendName.toLowerCase())) {
						uFlag = false;
					}
				}
				if (isSearchYearOfBirth) {
					int yob;
					try {
						yob = Integer.parseInt(u.getYearOfBirth());
					} catch (Exception ex) {
						yob = -1;
					}
					if (yob != -1 && yob >= from && yob <= to)
						uFlag = false;
				}
				if (uFlag) {
					filteredUsers.add(u);
				}
			}
		}

//		request.setAttribute("filteredUsers", filteredUsers);
		sContext.filteredUsers = filteredUsers;
		request.getRequestDispatcher(Constent.FINDFRIENDSRESULTPAGE).forward(
				request, response);

		System.out.println("---DoSearchCommand end");

		return null;
	}

}
