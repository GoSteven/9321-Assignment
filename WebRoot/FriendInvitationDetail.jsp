<%@ include file="header.jsp" %>
<%
		String id = request.getParameter("id");
		if (id == null || id.equals("") || !SContext.IsLoggedIn) {
			response.sendRedirect(SContext.BaseURL + Constent.INDEXPAGE);
		}

		FriendInvitation targetInvitation = MContext.AllFriendInvitationsM.getDAO().findById(id);
		if (targetInvitation == null) {
			response.sendRedirect(SContext.BaseURL + Constent.INDEXPAGE);
		}
		User u = targetInvitation.getFromUserDetail();
 %>
    <!-- content START -->
    <div id="content"> 
      
      <!-- main START -->
      <div id="main">

	
        <div class="post">
          <h3>Invitation from: <%= targetInvitation.getFromUserDetail().getUserName() %><h3>
          <br/>
          <h4>Message:</h4>
          <br/>
          <p><%=targetInvitation.getMessage() %></p>
          <br/>
          <h4>Personal detail:</h4>
          <br/>
          <div style="width: 300px">
                <div class="searchItem">
                  <div class="l"> Name: </div>
                  <div class="r"> 
                    <%= u.getUserName() %>
                  </div>
                  <div class="fixed"></div>
                </div>
          		<div class="searchItem">
                  <div class="l"> Nick Name: </div>
                  <div class="r"> 
                    <%= u.getNickName() %>
                  </div>
                  <div class="fixed"></div>
                </div>
                <% if (u.getIsFirstNamePublic() == 1) { %>
          		<div class="searchItem">
                  <div class="l"> First name: </div>
                  <div class="r"> 
                    <%= u.getFirstName() %>
                  </div>
                  <div class="fixed"></div>
                </div>
                <%} %>
                <% if (u.getIsLastNamePublic() == 1) { %>
          		<div class="searchItem">
                  <div class="l"> Last name: </div>
                  <div class="r"> 
                    <%= u.getLastName() %>
                  </div>
                  <div class="fixed"></div>
                </div>
                <%} %>
                <% if (u.getIsYearOfBirthPublic() == 1) { %>
          		<div class="searchItem">
                  <div class="l"> Year of birth: </div>
                  <div class="r"> 
                    <%= u.getYearOfBirth() %>
                  </div>
                  <div class="fixed"></div>
                </div>
                <%} %>
                <% if (u.getIsFavActorsPublic() == 1) { %>
          		<div class="searchItem">
                  <div class="l"> Favorite Actors: </div>
                  <div class="r"> 
                    <%= u.getFavActors() %>
                  </div>
                  <div class="fixed"></div>
                </div>
                <%} %>
          </div>
          
                  
          <form action="<%=SContext.BaseURL + com.entities.Constent.CONTROLLERSERVLET + com.entities.Constent.CONFIRMFRIEND_CMD%>" method="post">
              <div class="SearchBar">
                <div class="searchItem">
                  <div class="r" style="margin-top:5px">
                  	<input type="hidden" name="InvitationId" value="<%=id%>" />
                  	<input type="hidden" name="userId" value="<%=u.getUserId()%>" />
                  	<input type="submit" name="Ignore" value="Ignore" />
                    <input type="submit" name="AddFriend" value="AddFriend" />
                  </div>
                  <div class="fixed"></div>
                </div>
              </div>
            </form>

        </div>
        <div class="fixed"></div>
    
        <div id="pagenavi">
          <p>&nbsp;</p>
          <div class="fixed"></div>
        </div>
        <div class="fixed"></div>
      </div>
      <!-- main END --> 
      <%@ include file="sidebar.jsp" %>
      <div class="fixed"></div>
    </div>
    <!-- content END --> 
<%@ include file="footer.jsp" %>

