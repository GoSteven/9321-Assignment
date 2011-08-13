<%@page import="com.entities.*"%>
      <!-- sidebar START -->
      <div id="sidebar"> 
        
        <!-- sidebar north START -->
        <div id="northsidebar" class="sidebar"> 
          
          <!-- feeds -->
          <div class="widget widget_feeds">
            <div class="content">
	            <ul>
	            <% if (SContext.IsLoggedIn && SContext.CurrentUser != null)  {%>
				    <li>Welcome:<%=SContext.CurrentUser.getUserName() %></li>
				    <li><a href="<%= SContext.BaseURL + com.entities.Constent.EDITPROFILEPAGE %>" title="Edit">Edit Profile</a></li>
				    <li><a href="<%= SContext.BaseURL + com.entities.Constent.CHANGEPASSWORDPAGE %>" title="ChangePassword">Change Password</a></li>
				    <li><a href="<%= SContext.BaseURL + com.entities.Constent.CONTROLLERSERVLET + com.entities.Constent.MYBOOKINGS_CMD%>" title="Bookings">My Bookings</a></li>
				    <li><a href="<%= SContext.BaseURL + com.entities.Constent.FINDFRIENDSPAGE %>" title="FindFriends">Find Friends</a></li>
				    <li><a href="<%= SContext.BaseURL + com.entities.Constent.MYFRIENDSPAGE %>" title="MyFriends">My Friends</a></li>
				    <li><a href="<%= SContext.BaseURL + com.entities.Constent.RECOMMENDEDMOVIESSPAGE %>" title="MyFriends">UnReaded Recommends</a></li>
				    <li><a href="<%= SContext.BaseURL + com.entities.Constent.READEDRECOMMENDEDMOVIESSPAGE %>" title="MyFriends">Readed Recommends</a></li>
				    <li><a href="<%= SContext.BaseURL + com.entities.Constent.CONTROLLERSERVLET + com.entities.Constent.LOGIN_CMD%>&logoff=true" title="Edit">LogOff</a></li>
				    
            	<% } else { %>
            		<li><a href="<%= SContext.BaseURL + com.entities.Constent.LOGINPAGE %>" title="Edit">Please login</a></li>
            		<li><a href="<%= SContext.BaseURL + com.entities.Constent.REGISTPAGE %>" title="Edit">Or regist</a></li>
           		<% } %>
	            </ul>
            </div>
          </div>
          
          <!-- showcase -->
          <% if (SContext.IsLoggedIn && SContext.CurrentUser != null)  {%>
          <div class="widget">
            <h3>My List</h3>
            
            <div class="content">
              <ul>
              <% for (Movies m : SContext.MyList) { %>
              <li><b><a href="<%=SContext.BaseURL + com.entities.Constent.CONTROLLERSERVLET + com.entities.Constent.SHOWDETAIL_CMD + "&id=" + m.getMovieId()%>"><%= m.getMovieTitle() %></a></b></li>
              <%} %>
              </ul>
            </div>
            
          </div>
          <%} %>
          <!-- showcase -->
          <% if (SContext.IsLoggedIn && SContext.CurrentUser != null)  {%>
          <div class="widget">
            <h3>Friend Invitations</h3>
            
            <div class="content">
              <ul>
              <% for (FriendInvitation f : SContext.getFriendInvitations()) { %>
              <li><b><a href="<%=SContext.BaseURL + com.entities.Constent.FRIENDINVITATIONDETAILPAGE + "?id=" + f.getInvitationId()%>"><%= f.getFromUserDetail().getUserName() %></a></b></li>
              <%} %>
              </ul>
            </div>
            
          </div>
          <%} %>
          <% int recMsSize = SContext.getUnReadRecommendMovies().size();
          if ( recMsSize > 0) { %>
          <div class="widget">
            <h4>You have <a href="<%=SContext.BaseURL + com.entities.Constent.RECOMMENDEDMOVIESSPAGE%>"><%= recMsSize %> unread recommends</a></h4>
            
          </div>
          <%} %>
          
          <div class="widget widget_recent_entries">
            <!--<form method="post">
                <div class="r" style="margin-top:5px">
                  <input type="hidden" name="ClearItinerary" value="ClearItinerary"/>
                  <input type="submit" value="Clear Mylist" />
                </div>
              </form>
              -->
              <!--<iframe src="http://www.facebook.com/plugins/facepile.php?href=http%3A%2F%2Flocalhost%3A8080%2Fmm_movie_4%2F&amp;width=200&amp;max_rows=1" scrolling="no" frameborder="0" style="border:none; overflow:hidden; width:200px;" allowTransparency="true"></iframe>
              --><div id="fb-root"></div><script src="http://connect.facebook.net/en_US/all.js#xfbml=1"></script><fb:facepile href="http://localhost:8080/mm_movie_4/" width="200" max_rows="1"></fb:facepile>
              <div class="fixed"></div>
          </div>
        </div>
        <!-- sidebar north END -->
        
        <div id="centersidebar"> 
          
          <!-- sidebar east START -->
          <div id="eastsidebar" class="sidebar">
            <div class="searchItem">
              
            </div>
          </div>
          <!-- sidebar east END --> 
          
          <!-- sidebar west START -->
          <div id="westsidebar" class="sidebar"> </div>
          <!-- sidebar west END -->
          <div class="fixed"></div>
        </div>
      </div>
      <!-- sidebar END -->