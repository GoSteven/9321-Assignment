<%@ include file="header.jsp" %>

     <!-- content START -->
    <div id="content"> 
      
      <!-- main START -->
      <div id="main">

	
        <div class="post">
          <h2>My Bookings</h2>
              
              <%
              
              String userId = SContext.CurrentUser.getUserId();
		BookingDAO bookingDAO = new BookingDAO();
		List<Booking> mybookings = bookingDAO.findByUserId(userId);
		for(Booking b : mybookings){
			String showid = b.getShowTimeId();
			ShowtimeDAO showtime = new ShowtimeDAO();
			Showtime s = showtime.findById(showid);
			if(s.getShowtime().after(new Date())){
				CinemaDAO cinemadao = new CinemaDAO();
				Cinema c = cinemadao.findById(s.getCinemaId());
				MoviesDAO moviedao = new MoviesDAO();
				Movies m = moviedao.findById(s.getMovieId());
				%>
			<div class="searchItem">
				<div ><%=c.getCinemaName() %></div>
				<div><%=m.getMovieTitle() %></div>
				<div><%=s.getShowtime() %></div>
				<div><%=b.getNumOfTicket()  %></div>
				<div><%=b.getBookingId()  %></div>
			</div>
			<br /><br />
			<%}} %>
              
              
              
              
              
              
              
              
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

 