<%@ include file="header.jsp" %>

    <!-- content START -->
    <div id="content"> 
      
      <!-- main START -->
      <div id="main">

	
        <div class="post">
          <h2>Search Movie</h2>
                  
          <form action="<%=SContext.BaseURL + com.entities.Constent.CONTROLLERSERVLET + com.entities.Constent.DOSEARCH_CMD%>" method="post">
          <%
          if (SContext.DoSearchErrMsg != "") {
           %>
           <div style="color: red">
           <%=SContext.DoSearchErrMsg %>
           </div>
           <%
           }
            %>
              <div class="SearchBar">
                <div class="searchItem">
                  <div class="l"> Title: </div>
                  <div class="r"> 
                    <input type="text" name="Title" style="width:100px"/>
                  </div>
                  <div class="fixed"></div>
                </div>
                <div class="searchItem">
                  <div class="l"> actors/actresses: (seperate by ',') </div>
                  <div class="r"> 
                    <input type="password" name="actors" style="width:100px"/>
                  </div>
                  <div class="fixed"></div>
                </div>
                <div class="searchItem">
                  <div class="l"> Genres: </div>
                  <div class="r"> 
                    <SELECT NAME="Genres" MULTIPLE SIZE=5>
					<%
	                  ArrayList<String> Genres = new ArrayList<String>(MContext.AllGenres.keySet());
	                  for (String g: Genres) {
	                  %>
					<OPTION VALUE="<%=MContext.AllGenres.get(g) %>"><%=g %>
					<%} %>
					</SELECT>
                  </div>
                  <div class="fixed"></div>
                </div>
                <div class="searchItem">
                  <div class="r" style="margin-top:5px">
                    <input type="submit" value="DoSearch" />
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

