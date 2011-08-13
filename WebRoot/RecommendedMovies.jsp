<%@ include file="header.jsp" %>
<%
String SearchFriendMsg = (String)request.getAttribute("SearchFriendMsg");
if (!SContext.IsLoggedIn) {
	response.sendRedirect(SContext.BaseURL + Constent.ACCESSDENIEDPAGE);
	return;
}
String id = request.getParameter("id");
if (id != null && !id.equals("")) {
	MContext.AllRecommendMoviesM.markAsReaded(id);
}
List<RecommendMovie> recMs = SContext.getUnReadRecommendMovies();
//List<RecommendMovie> alrecMs = SContext.getReadedRecommendMovies();
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
	<h2>Recommended movies form friends :</h2>
	<br>
	<hr>
	
        <div class="post" style="width: 80%; margin-left: 20px;">
           <table width="100%" border="0" cellspacing="0" cellpadding="0">
           		<tr>
           			<td>Movie Name</td>
           			<td>Recommended By</td>
           			<td></td>
       			</tr>
       			<% 
					for (RecommendMovie r : recMs) {
				%>
          		<tr>
           			<td><a href="<%=SContext.BaseURL + com.entities.Constent.CONTROLLERSERVLET + com.entities.Constent.SHOWDETAIL_CMD + "&id=" + r.getMovieId()%>"><%=MContext.AllMoviesM.getDAO().findById(r.getMovieId()).getMovieTitle() %></a></td>
           			<td><%=MContext.AllUsersM.getDAO().findById(r.getFromUser()).getUserName() %></td>
           			<td>
           			<form method="post">
           			<input type="hidden" name="id" value="<%=r.getRecommendId() %>"/>
           			<input type="submit" value="Mark as readed"/>
           			</form>
           			</td>
       			</tr>
          	
          		<%
       			 }
     			 %>
          </table>
          

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

