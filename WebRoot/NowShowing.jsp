<%@ include file="header.jsp" %>

     <!-- content START -->
    <div id="content"> 
      
      <!-- main START -->
      <div id="main">

	
        <div class="post">
          <h2>Recommond</h2>
                     <% for (com.entities.Movies movie : SContext.NowShowingMovies()) { %>
		<div class="post">
          
          <div class="content">
            <div>
              <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="34%" style="border-right: 1px dotted #CCC"><img src="<%="poster/"+ movie.getPoster() %>" alt="" width="181" height="234" /></td>
                  <td width="66%"><table width="100%" border="0" cellspacing="0" cellpadding="0" style="line-height: 11px; border: 0">
                    <tr>
                      <td width="48%" class="detailtable">Movie Title: </td>
                      <td width="52%" class="detailtable"><%=movie.getMovieTitle() %></td>
                    </tr>
                    <tr>
                      <td width="48%" class="detailtable">ReleaseDate: </td>
                      <td width="52%" class="detailtable"><%=movie.getReleaseDate() %></td>
                    </tr>
                    <tr>
                      <td width="48%" class="detailtable">Actors/actress: </td>
                      <td width="52%" class="detailtable"><%=movie.getActors() %></td>
                    </tr>
                    <tr>
                      <td class="detailtable">Director:</td>
                      <td class="detailtable"><%=movie.getDirector() %></td>
                    </tr>
                    <tr>
                      <td class="detailtable">Rating</td>
                      <td class="detailtable"><%=movie.getRating() %></td>
                    </tr>
                  </table>
                    <table width="100%" border="0" cellspacing="0" cellpadding="0" style="line-height: 11px; border: 0">
                      <tr>
                        <td colspan="2" class="detailtable">
                        <p><b>Synopsis</b></p>
                        <p><%=movie.getShortSynopsis() %></p>
                        </td>
                      </tr>
                  </table></td>
                </tr>
              </table>
              
            </div>
            <div class="fixed"></div>
          </div>
          <div class="under">
            <div style="float:left"><a href="<%=SContext.BaseURL + com.entities.Constent.CONTROLLERSERVLET + com.entities.Constent.SHOWDETAIL_CMD + "&id=" + movie.getMovieId()%>">Details </a> </div>
            <div style="float:right">
            	<% if (SContext.IsLoggedIn == true && SContext.CurrentUser!=null) { %>
              <form action="<%=SContext.BaseURL + com.entities.Constent.CONTROLLERSERVLET + com.entities.Constent.ADDTOMYLIST_CMD%>" method="post">
              	
                <input type="hidden" name="movieid" value="<%=movie.getMovieId()%>"/>
                <input type="submit" value="Add To My List"/>
              </form>
              <%} %>
            </div>
          </div>

        </div>
        <div class="fixed"></div>
        
        
    
        <div id="pagenavi">
          <p>&nbsp;</p>
          <div class="fixed"></div>
        </div>
        <div class="fixed"></div>
        <% }%>

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

 