<%@ include file="header.jsp" %>
<%@page import="com.entities.Constent"%>
<%
String bookingSucessMsg = (String)request.getAttribute("bookingSucessMsg");
if (request.getAttribute("bookingSucessMsg") == null || request.getAttribute("bookingSucessMsg").equals("")) {
	response.sendRedirect(SContext.BaseURL + Constent.ACCESSDENIEDPAGE);
	return;
}
 %>
     <!-- content START -->
    <div id="content"> 
      
      <!-- main START -->
      <div id="main">

	
        <div class="post">
          <h2>BookingSuccess</h2>
            <p>
            <%=bookingSucessMsg %>
            
            </p>     
          
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

 