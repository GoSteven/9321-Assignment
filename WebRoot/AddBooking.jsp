<%@page import="com.entities.*"%>
<%@page import="com.util.*"%>
<%@ include file="header.jsp" %>
    <!-- content START -->
    <div id="content"> 
      
      <!-- main START -->
      <div id="main">
      
      <%
      	List<Showtime> targetShowtimes = null;
      	if (request.getAttribute("targetShowtimes") != null) 
      		targetShowtimes = (List<Showtime>)request.getAttribute("targetShowtimes");
      	if (request.getAttribute("targetMovie") != null) { 
      		Movies targetMovie = (Movies)request.getAttribute("targetMovie");
      
      %>
		<div class="post">
          <h2><a class="title" href="#" rel="bookmark">Booking Ticket: <%= targetMovie.getMovieTitle() %></a></h2>
          <div class="info"> <span class="date"><%= targetMovie.getReleaseDate() %></span> 
          <!--<span class="author">the</span> <span class="bathrooms"></span> 
          <span class="bedrooms">   &nbsp;  &nbsp;</span>
            --><div class="fixed"></div>
          </div>
          <div class="content">
            
            </div>
            <div class="fixed"></div>
          </div>
          <div class="under">
	          <%
	          if (SContext.AddBookingErrMsg != "") {
	           %>
	           <div style="color: red">
	           <%=SContext.AddBookingErrMsg %>
	           </div>
	           <%
	           }
            	%>
          	<form action="<%=SContext.BaseURL + com.entities.Constent.CONTROLLERSERVLET + com.entities.Constent.DOBOOKING_CMD + "&id=" + targetMovie.getMovieId() + "&book=true"%>" method="post">
	            <div style="float:left">
	            	 Cinemas: <br/>
	               	<SELECT NAME="Showtimes" MULTIPLE SIZE=5 style="width:280px">
						<%for (Showtime s: targetShowtimes) { %>
						<OPTION VALUE="<%=s.getShowtimeId() %>"><%=s.getCinemaName() + "\t\t" + s.getShowtime().toString() + "\t$" + s.getPrice()%>
						
						<%} %>
					</SELECT>
	            </div>
	            <div style="float:right">
	              
	                <input type="hidden" name="token" value="<%=com.util.Guid.GetGUID()%>"/><br />
	                Num of tickets:<input type="text" name="NumOfTickets" style="width:100px"/><br />
	                Credit Cardn:<input type="text" name="CreditCardNum" style="width:100px"/><br />
	                Validate Num:<input type="text" name="ValidateNum" style="width:100px"/><br />
	                <input type="submit" value="Book!"/>
	              
	            </div>
            </form>
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
      <!-- main END --> 
      <%@ include file="sidebar.jsp" %>
      <div class="fixed"></div>
    </div>
    <!-- content END --> 
<%@ include file="footer.jsp" %>

