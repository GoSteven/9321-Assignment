<%@ include file="header.jsp" %>

<%
if (!SContext.IsOwner()) {
response.sendRedirect(SContext.BaseURL + Constent.ACCESSDENIEDPAGE);
return;
}
 %>
    <!-- content START -->
    <div id="content"> 
      
      <!-- main START -->
      <div id="main">

	
        <div class="post">
          <h2>Add Movie</h2>
                  
          <form action="<%=SContext.BaseURL + com.entities.Constent.CONTROLLERSERVLET + com.entities.Constent.ADDMOVIE_CMD %>"
           method="post"  enctype="multipart/form-data">
           
          <%
            if (SContext.AddMovieErrMsg != "") {
           %>
           <div style="color: red">
           <%=SContext.AddMovieErrMsg %>
           </div>
           <%
           }
            %>
              <div class="SearchBar">
                <div class="searchItem">
                  <div class="l"> Movie Title: </div>
                  <div class="r"> 
                    <input type="text" name="MovieTitle" style="width:100px"/>
                  </div>
                  <div class="fixed"></div>
                </div>
                <div class="searchItem">
                  <div class="l"> Poster: </div>
                  <div class="r"> 
                    <input type="file" name="Poster" accept="image/gif, image/jpeg, image/jpg, image/png" style="width:300px"/>
                  </div>
                  <div class="fixed"></div>
                </div>
                <div class="searchItem">
                  <div class="l"> actors and actresses: (separate by ,)</div>
                  <div class="r"> 
                    <input type="text" name="ActorsAndActresses" style="width:100px"/>
                  </div>
                  <div class="fixed"></div>
                </div><div class="searchItem">
                  <div class="l"> Youtube link: </div>
                  <div class="r"> 
                    <textarea name="youtubelink" rows="4" cols="30"></textarea>
                  </div>
                  <div class="fixed"></div>
                </div>
                
                <div class="searchItem">
                  <div class="l"> Genre(s): </div>
                  <div class="r"> 
                  <SELECT NAME="Genres" MULTIPLE SIZE=5>
					<%
	                  ArrayList<String> Genres = new ArrayList<String>(MContext.AllGenres.keySet());
	                  for (String g: Genres) {
	                  %>
					<OPTION VALUE="<%=MContext.AllGenres.get(g) %>"><%=g %>
					<%} %>
					</SELECT>
					<!--
                  
                    <input type="checkbox" name="Genres_Action" value="Action" style="width:20px">Action
                    <input type="checkbox" name="Genres_Adventure" value="Adventure" style="width:20px">Adventure
                    <input type="checkbox" name="Genres_Comedy" value="Comedy" style="width:20px">Comedy
                    <input type="checkbox" name="Genres_Horror" value="Horror" style="width:20px">Horror
                    <input type="checkbox" name="Genres_War" value="War" style="width:20px">War
                    <input type="checkbox" name="Genres_Drama" value="Drama" style="width:20px">Drama
                  	-->
                  	</div>
                  <div class="fixed"></div>
                </div>
                <div class="searchItem">
                  <div class="l"> Director: </div>
                  <div class="r"> 
                    <input type="text" name="Director" style="width:100px"/>
                  </div>
                  <div class="fixed"></div>
                </div>
                <div class="searchItem">
                  <div class="l"> Short Synopsis: </div>
                  <div class="r"> 
                  <textarea name="Synopsis" rows="10" cols="30" onpropertychange="if(value.length>100) value=value.substr(0,100)"></textarea>
                 </div>
                  <div class="fixed"></div>
                </div>
                <div class="searchItem">
                  <div class="l"> Age rating: </div>
                  <div class="r"> 
                    <input type="checkbox" name="AgeRating_G" value="G" style="width:20px" ><img alt="" src="files/Genres/G.png"  height="50" width="120">
                    <input type="checkbox" name="AgeRating_PG" value="PG" style="width:20px" ><img alt="" src="files/Genres/PG.png"  height="50" width="120">
                    <input type="checkbox" name="AgeRating_M" value="M" style="width:20px" ><img alt="" src="files/Genres/M.png" height="50" width="120"><br />
                    <input type="checkbox" name="AgeRating_MA" value="MA" style="width:20px" ><img alt="" src="files/Genres/MA.png" height="50" width="120">
                    <input type="checkbox" name="AgeRating_R" value="R" style="width:20px" ><img alt="" src="files/Genres/R.png" height="50" width="120">
                    <input type="checkbox" name="AgeRating_X" value="X" style="width:20px" ><img alt="" src="files/Genres/X.png" height="50" width="120">
                  </div>
                  <div class="fixed"></div>
                </div>
                <div class="searchItem">
                  <div class="l"> Release Date: </div>
                  <div class="r"> 
                  <INPUT maxLength=24 size=30 name="rdate" readonly onclick="SelectDate(this,'yyyy-MM-dd')"  this.Txt_Date.Attributes["onclick"] = "SelectDate(this,'yyyy-MM-dd')";>               
                  </div>
                  <div class="fixed"></div>
                </div>
                <div class="searchItem">
                  <div class="l"> Expired Date: </div>
                  <div class="r"> 
                  <INPUT maxLength=24 size=30 name="edate" readonly onclick="SelectDate(this,'yyyy-MM-dd')"  this.Txt_Date.Attributes["onclick"] = "SelectDate(this,'yyyy-MM-dd')";>               
                  </div>
                  <div class="fixed"></div>
                </div>
                
                <div class="searchItem">
                  <div class="r" style="margin-top:5px">
                    <input type="submit" value="Add" />
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

