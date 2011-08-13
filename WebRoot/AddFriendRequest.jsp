<%@ include file="header.jsp" %>
<%
		String id = request.getParameter("id");
		if (id == null || id.equals("") || !SContext.IsLoggedIn) {
			response.sendRedirect(SContext.BaseURL + Constent.INDEXPAGE);
		}

		User targetUser = MContext.AllUsersM.getDAO().findById(id);
		if (targetUser == null) {
			response.sendRedirect(SContext.BaseURL + Constent.INDEXPAGE);
		}
 %>
    <!-- content START -->
    <div id="content"> 
      
      <!-- main START -->
      <div id="main">

	
        <div class="post">
          <h2>Frind Friends</h2>
                  
          <form action="<%=SContext.BaseURL + com.entities.Constent.CONTROLLERSERVLET + com.entities.Constent.ADDFRIENDREQUEST_CMD%>" method="post">
              <div class="SearchBar">
                <div class="searchItem">
                  <p>Add <%= targetUser.getUserName() %> as Friends, send a message to him/her: </p>
                  <input type="hidden" name="id" value="<%=id %>" />
                  <textarea name="requestDetail" rows="4" cols="30"></textarea>
                </div>
                <div class="searchItem">
                  <div class="r" style="margin-top:5px">
                    <input type="submit" value="SendRequest" />
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

