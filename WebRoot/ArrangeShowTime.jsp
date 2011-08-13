<%@page import="com.entities.*"%>

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
          <h2>Arrange Show Time</h2>
                  
          <form action="<%=SContext.BaseURL + com.entities.Constent.CONTROLLERSERVLET + com.entities.Constent.ARRENGESHOWTIME_CMD%>" method="post">
          <%
          if (SContext.ArrangeShowtimeErrMsg != "") {
           %>
           <div style="color: red">
           <%=SContext.ArrangeShowtimeErrMsg %>
           </div>
           <%
           }
            %>
              <div class="SearchBar">
                <div class="searchItem">
                  <div class="l"> Movies: <br/>
                  	<SELECT NAME="Movies" MULTIPLE SIZE=5>
	                  <%
	                  String selected = "";
	                  boolean ismoviechosed = false;
	                  String mvid = request.getParameter("id");
	                  if (mvid != null && !mvid.equals("")) {
	                  	ismoviechosed = true;
	                  } else {
	                     ismoviechosed = false;
	                  } 
	                  List<Movies> allMovie = MContext.AllMoviesM.findAll();
	                  for (Movies m: allMovie) {
	                	  Date today = new Date();
	                	  if(today.before(m.getReleaseDate())){
	                  %>
	                  
	                  <%if (ismoviechosed && m.getMovieId().equals(mvid)) { %>
					<OPTION VALUE="<%=m.getMovieId() %>" default><%=m.getMovieTitle() %>
					<%} else { %>
					<OPTION VALUE="<%=m.getMovieId() %>"><%=m.getMovieTitle() %>
					<%} %>
					
					
					<%}} %>
					</SELECT>
                  </div>
                  <div class="r"> Cinemas: <br/>
                  	<SELECT NAME="Cinemas" MULTIPLE SIZE=5>
					<%
	                  List<Cinema> allCinema = MContext.AllCinemasM.findAll();
	                  for (Cinema c: allCinema) {
	                  %>
					<OPTION VALUE="<%=c.getCinemaId() %>"><%=c.getCinemaName() %>
					<%} %>
					</SELECT>
                  </div>
                  <div class="fixed"></div>
                </div>
                <div class="searchItem">
                  <div class="l"> Showing Date: </div>
                  <div class="r"> 
                  <INPUT maxLength=24 size=30 name="sdate" readonly onclick="SelectDate(this,'yyyy-MM-dd')"  this.Txt_Date.Attributes["onclick"] = "SelectDate(this,'yyyy-MM-dd')";>               
                  </div>
                  <div class="fixed"></div>
                </div>
                <div class="searchItem">
                  <div class="l"> ShowTime: </div>
                  <div class="r"> 
                    <select name="HourofShowtime">
                    	<%
                    	for(int i = 0; i < 24; i++){
                    	%>
                    	<option value="<%=i%>">
                    	<%=i %></option>
                    	<%
                    	}
                    	%>
                    </select>
                    <select name="MinutesofShowtime">
                    	<%
                    	for(int i = 0; i <60; i++){
                    	%>
                    	<option value="<%=i %>"><%=i %></option>
                    	<%
                    	}
                    	%>
                    </select>
                  </div>
                  <div class="fixed"></div>
                </div>
                <div class="searchItem">
                  <div class="l"> Price <br/>
                  	<input type="text" name="Price" style="width:100px"/>
                  </div>
                </div>
                <div class="searchItem">
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
<%@ include file="footer.jsp" %>

