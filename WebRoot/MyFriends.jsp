<%@ include file="header.jsp" %>
<%
String SearchFriendMsg = (String)request.getAttribute("SearchFriendMsg");
if (!SContext.IsLoggedIn) {
	response.sendRedirect(SContext.BaseURL + Constent.ACCESSDENIEDPAGE);
	return;
}
List<User> filteredUsers = SContext.getMyFriends();// (List<User>)request.getAttribute("filteredUsers");
 %>
    <!-- content START -->
    <div id="content"> 
      
      <!-- main START -->
      <div id="main">
<%
	    if (SearchFriendMsg != null && !SearchFriendMsg.equals("")) {
	     %>
	     <div style="color: red">
	     <%=SearchFriendMsg %>
	     </div>
	     <%
	     }
	      %>
	<h2>My friends :</h2>
	<br>
	<hr>
	<% 
	if (filteredUsers != null && filteredUsers.size() > 0) {
		for (User u : filteredUsers) {
	%>
        <div class="post" style="width: 80%; margin-left: 20px;">
          
          	
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
                <div class="searchItem">
                  <div class="l">  </div>
                  <div class="r"> 
                    <a href=""></a>
                    <a href="<%= SContext.BaseURL + com.entities.Constent.CONTROLLERSERVLET + com.entities.Constent.CONFIRMFRIEND_CMD %>&id=<%= u.getUserId() %>&delete=true" title="DeleteFriend">Delete friend</a>
                  </div>
                  <div class="fixed"></div>
                </div>
          	
          
          

        </div>
        <div class="fixed"></div>
        <hr>
        <%
        }
     } %>
    
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

