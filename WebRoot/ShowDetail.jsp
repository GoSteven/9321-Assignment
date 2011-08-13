<%@page import="com.entities.*"%>
<%@page import="com.util.*"%>
<%@ include file="header.jsp" %>
    <!-- content START -->
    <div id="content"> 
      
      <!-- main START -->
      <div id="main">
      <% if (request.getAttribute("targetMovie") != null) { 
      		Movies targetMovie = (Movies)request.getAttribute("targetMovie");
      
      %>
		<div class="post">
          <h2><a class="title" href="#" rel="bookmark"><%= targetMovie.getMovieTitle() %></a></h2>
          <div class="info"> <span class="date"><%= targetMovie.getReleaseDate() %></span> 
          <!--<span class="author">the</span> <span class="bathrooms"></span> 
          <span class="bedrooms">   &nbsp;  &nbsp;</span>
            --><div class="fixed"></div>
          </div>
          <div class="content">
          	<%if ( com.util.Filter.IsYoutubeLinkValidate( targetMovie.getYoutubeLink())) { %>
          	<div>
          	 <%= targetMovie.getYoutubeLink() %>
          	</div>
          	<%} %>
            <div>
              <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="34%" style="border-right: 1px dotted #CCC"><img src="<%="poster/"+ targetMovie.getPoster() %>" alt="" width="181" height="234" /></td>
                  <td width="66%"><table width="100%" border="0" cellspacing="0" cellpadding="0" style="line-height: 11px; border: 0">
                    <tr>
                      <td width="48%" class="detailtable">Actors/actress: </td>
                      <td width="52%" class="detailtable"><%=targetMovie.getActors() %></td>
                    </tr>
                    <tr>
                      <td class="detailtable">Director:</td>
                      <td class="detailtable"><%=targetMovie.getDirector() %></td>
                    </tr>
                    <tr>
                      <td class="detailtable">Rating</td>
                      <td class="detailtable"><%=targetMovie.getRating() %></td>
                    </tr>
                  </table>
                    <table width="100%" border="0" cellspacing="0" cellpadding="0" style="line-height: 11px; border: 0">
                      <tr>
                        <td colspan="2" class="detailtable">
                        <p><b>Synopsis</b></p>
                        <p><%=targetMovie.getShortSynopsis() %></p>
                        </td>
                      </tr>
                  </table></td>
                </tr>
              </table>
              
            </div>
            <div class="fixed"></div>
          </div>
          <div class="under">
            <div style="float:left"><script src="http://platform.twitter.com/widgets.js" type="text/javascript"></script>
<div>
   <a href="http://twitter.com/share" class="twitter-share-button"
      
      data-via="steven_you"
      data-text="I found a terrific movie in MM Movie Word, Check this out!!"
      data-related="anywhere:The Javascript API"
      data-count="horizontal">Tweet This Movie</a>
      
      
      </div> </div>
            <div style="float:right">
              <form method="post">
              	<%if (SContext.IsOwner()) { %>
              	<a href="<%=SContext.BaseURL + com.entities.Constent.ARRANGESHOWTIMEPAGE + "?id=" + targetMovie.getMovieId()%>">Add Show Time</a>
              	<%} else if (SContext.IsLoggedIn) { %>
              	<a href="<%=SContext.BaseURL + com.entities.Constent.CONTROLLERSERVLET + com.entities.Constent.RECOMMONDTOFRIENDS_CMD + "&id=" + targetMovie.getMovieId()%>">Recommond to Friends</a>
              	<a href="<%=SContext.BaseURL + com.entities.Constent.CONTROLLERSERVLET + com.entities.Constent.DOBOOKING_CMD + "&id=" + targetMovie.getMovieId()%>">Book Ticket</a>
                
                <input type="hidden" name="propertyName" value="the id of this moive proberly"/>
                <input type="submit" value="Add To List"/>
                <%} %>
              </form>
            </div>
          </div>

        </div>
        <div class="fixed"></div>
        <div id="fb-root"></div><script src="http://connect.facebook.net/en_US/all.js#appId=218504571507071&amp;xfbml=1"></script><fb:like href="http://localhost:8080/mm_movie_4/" send="true" width="450" show_faces="true" font=""></fb:like>
        <script>
  window.fbAsyncInit = function() {
    FB.init({appId: 'your app id', status: true, cookie: true,
             xfbml: true});
  };
  (function() {
    var e = document.createElement('script'); e.async = true;
    e.src = document.location.protocol +
      '//connect.facebook.net/en_US/all.js';
    document.getElementById('fb-root').appendChild(e);
  }());
</script>
        
        
        <div id="fb-root"></div><script src="http://connect.facebook.net/en_US/all.js#xfbml=1"></script><fb:comments href="http://localhost:8080/mm_movie_4/<%=targetMovie.getMovieId()%>" num_posts="2" width="500"></fb:comments>
        
        <%if (targetMovie.isReleased()) { %>
	        
	        
	<div id="commentlist">
		<!-- comments START -->
		<ol id="thecomments">
			<% 
			List<Comment> comments = MContext.AllCommentsM.getMovieRelatedComments(targetMovie);
			for (Comment comment : comments) {  
			%>
			<li class="comment regularcomment" id="comment-50193">
			<div class="author">
				<div class="pic">
					<img alt="" src="files/img/userIcon.png" class="avatar avatar-32 photo" height="32" width="32">			</div>
				<div class="name">
										<span id="commentauthor-50193">
					
					<%=comment.getUserName()%>
										</span>
								</div>
			</div>
	
			<div class="info">
				<div class="date">
					<%=comment.getCommentTime() %>					 | 
				</div>
				<div class="act">
								</div>
				<div class="fixed"></div>
				<div class="content">
					
					<div id="commentbody-50193">
						<p><%=comment.getCommentContent()%></p>
					</div>
				</div>
			</div>
			<div class="fixed"></div>
	
			</li>
			<% } %>
	
		</ol>
		<!-- comments END -->
	
	
	
	</div>
	

<% if (SContext.IsLoggedIn == true && SContext.CurrentUser!=null) { %>
	<form action="<%=SContext.BaseURL + com.entities.Constent.CONTROLLERSERVLET + com.entities.Constent.SHOWDETAIL_CMD + "&id=" + targetMovie.getMovieId()%>" method="post" id="commentform">
	<div id="respond">			
		
		<!-- comment input -->
		<div class="row">
			<textarea name="comment" id="comment" tabindex="4" rows="8" cols="50"></textarea>
		</div>

		<!-- comment submit and rss -->
		<div id="submitbox">
			<div class="feed"> Rating: 
				<input type="radio" name="rate" value="-2">-2
				<input type="radio" name="rate" value="-1">-1
				<input type="radio" name="rate" value="0" checked>0
				<input type="radio" name="rate" value="1">1
				<input type="radio" name="rate" value="2">2
			</div>
			<div class="submitbutton">
				<input name="submit" type="submit" id="submit" class="button" tabindex="5" value="submit">
			</div>
						<input type="hidden" name="comment_post_ID" value="4671">
			<div class="fixed"></div>
		</div>

	</div>
	</form>
<%} %>


<%} %>




        
    
        <div id="pagenavi">
          <p>&nbsp;</p>
          <div class="fixed"></div>
        </div>
        <div class="fixed"></div>
        <% }%>
        
      </div>
      <!-- main END --> 
      <%@ include file="sidebar.jsp" %>
      <div class="fixed"></div>
    </div>
    <!-- content END --> 
<%@ include file="footer.jsp" %>

