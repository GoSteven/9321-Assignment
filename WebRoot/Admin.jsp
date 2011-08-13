<%@ include file="header.jsp" %>
<%@page import="com.entities.Constent"%>
<%@page import="com.entities.*" %>
<%
if (!SContext.IsOwner()) {
response.sendRedirect(SContext.BaseURL + Constent.ACCESSDENIEDPAGE);
return;
} else {
 %>
    <!-- content START -->
    <div id="content"> 
      
      <!-- main START -->
      <div id="main">

	
        <div class="post">
          <h2>Manage</h2>
          <p>
          <a href="<%=SContext.BaseURL + com.entities.Constent.ADDCINEMAPAGE %>">Add Cinema</a>
          </p>
          <p>
          <a href="<%=SContext.BaseURL + com.entities.Constent.ADDMOVIEPAGE %>">Add Movies</a>
          </p>
          <p>
          <a href="<%=SContext.BaseURL + com.entities.Constent.ARRANGESHOWTIMEPAGE %>">Arrange Show Time</a>
          </p>     
          
        </div>
         <div class="SearchBar">
           
                  
        <%
        List<Cinema> allCinema = MContext.AllCinemasM.findAll();
		for(Cinema ac: allCinema){
			System.out.println(ac.getCinemaId());
        %>
        	<div class="searchItem">
       		 <div class="l">Cinema Name: <a href="<%=SContext.BaseURL + com.entities.Constent.CONTROLLERSERVLET%>showcinemamovies&id=<%= ac.getCinemaId() %>"><%= ac.getCinemaName() %> </a>&nbsp;  &nbsp; </div>
       		 <div class="l">Cinema Addr: <%= ac.getLocation() %>  &nbsp;  &nbsp;</div>
       		 <div class="l">Cinema Capa:<%= ac.getSeatingCapacity() %> &nbsp;  &nbsp; </div>
       		 <div class="fixed"></div>
       		</div>
       		
       	<%} %>
       		
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

