<%@page import="com.entities.Constent"%>
<%@ include file="header.jsp" %>
<%
if (!SContext.IsLoggedIn) {
response.sendRedirect(SContext.BaseURL + Constent.ACCESSDENIEDPAGE);
return;
} else {
	User u = SContext.CurrentUser;
 %>
     <!-- content START -->
    <div id="content"> 
      
      <!-- main START -->
      <div id="main">

	
        <div class="post">
          <h2>Edit Profile</h2>
                  
          <form action="<%=SContext.BaseURL + com.entities.Constent.CONTROLLERSERVLET %>editprofile" method="post">
              <div class="SearchBar">
                <div class="searchItem">
                  <div class="l"> User Name: </div>
                  <div class="r"> <%=u.getUserName() %><input type="hidden", name="UserName", value="<%=u.getUserName() %>">
                  </div>
                  <div class="fixed"></div>
                </div>
                <div class="searchItem">
                  <div class="l"> Nickname: </div>
                  <div class="r"> 
                    <input type="text" name="NickName" value="<%=u.getNickName() %>" style="width:100px"/>
                  </div>
                  <div class="fixed"></div>
                </div>
                <div class="searchItem">
                  <div class="l"> FirstName: </div>
                  <div class="r"> 
                    <input type="text" name="FirstName" value="<%=u.getFirstName() %>" style="width:100px"/>
                    <INPUT TYPE=CHECKBOX NAME="FirstNameC" <%=u.getPublicFirstName() %>>is public
                  </div>
                  <div class="fixed"></div>
                </div>
                <div class="searchItem">
                  <div class="l"> LastName: </div>
                  <div class="r"> 
                    <input type="text" name="LastName" value="<%=u.getLastName() %>" style="width:100px"/>
                    <INPUT TYPE=CHECKBOX NAME="LastNameC" <%=u.getPublicLastName() %>>is public
                  </div>
                  <div class="fixed"></div>
                </div>
                <div class="searchItem">
                  <div class="l"> Email: </div>
                  <div class="r"> 
                    <input type="text" name="Email" value="<%=u.getEmailAddress() %>" style="width:100px"/>
                  </div>
                  <div class="fixed"></div>
                </div>
                <div class="searchItem">
                  <div class="l"> Year of Birth: </div>
                  <div class="r"> 
                    <input type="text" name="YearOfBirth" value="<%=u.getYearOfBirth() %>" style="width:100px"/>
                    <INPUT TYPE=CHECKBOX NAME="YearOfBirthC" <%=u.getPublicYearOfBirth() %>>is public
                  </div>
                  <div class="fixed"></div>
                </div>
                <div class="searchItem">
                  <div class="l"> Favorite genres </div>
                  <div class="r"> 
                    <input type="checkbox" name="FavGenres_Action" value="Action" style="width:20px">Action
                    <input type="checkbox" name="FavGenres_Adventure" value="Adventure" style="width:20px">Adventure
                    <input type="checkbox" name="FavGenres_Comedy" value="Comedy" style="width:20px">Comedy
                    <input type="checkbox" name="FavGenres_Horror" value="Horror" style="width:20px">Horror
                    <input type="checkbox" name="FavGenres_War" value="War" style="width:20px">War
                    <input type="checkbox" name="FavGenres_Drama" value="Drama" style="width:20px">Drama
                  </div>
                  <div class="fixed"></div>
                </div>
                <div class="searchItem">
                  <div class="l"> Favorite actors and actresses:(seperate by ',') </div>
                  <div class="r"> 
                    <input type="text" name="FavActors" value="<%=u.getFavActors() %>" style="width:100px"/>
                    <INPUT TYPE=CHECKBOX NAME="FavActorsC" <%=u.getPublicFavActors() %>>is public
                  </div>
                  <div class="fixed"></div>
                </div>
                <div class="searchItem">
                
                  <div class="l"> <INPUT TYPE=CHECKBOX NAME="CompletePrivateC" <%=u.getCheckedCompletePrivate() %>>Complete private</div>
                  <div class="r" style="margin-top:5px">
                    <input type="submit" value="submit" />
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
<%
} 
%>
<%@ include file="footer.jsp" %>

 