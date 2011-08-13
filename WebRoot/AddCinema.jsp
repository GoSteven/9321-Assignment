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
          <h2>AddCinema</h2>
                  
          <form action="<%=SContext.BaseURL + com.entities.Constent.CONTROLLERSERVLET %>addcinema" method="post">
          <%
          if (SContext.AddCinemaErrMsg != "") {
           %>
           <div style="color: red">
           <%=SContext.AddCinemaErrMsg %>
           </div>
           <%
           }
            %>
              <div class="SearchBar">
                <div class="searchItem">
                  <div class="l"> Cinema Name: </div>
                  <div class="r"> 
                    <input type="text" name="CinemaName" style="width:100px"/>
                  </div>
                  <div class="fixed"></div>
                </div>
                <div class="searchItem">
                  <div class="l"> Location: </div>
                  <div class="r"> 
                    <input type="text" name="Location" style="width:100px"/>
                  </div>
                  <div class="fixed"></div>
                </div>
                <div class="searchItem">
                  <div class="l"> Seating Capacity: </div>
                  <div class="r"> 
                    <input type="text" name="SeatingCapacity" style="width:100px"/>
                  </div>
                  <div class="fixed"></div>
                </div>
                <div class="searchItem">
                  <div class="l"> Amenities: </div>
                  <div class="r"> 
                    <input type="checkbox" name="Amenities_ATMs"  value="ATMs" style="width:60px"/>ATMs
                    <input type="checkbox" name="Amenities_Widescreen"  value="Widescreen" style="width:60px"/>Widescreen
                    <input type="checkbox" name="Amenities_SnackBar"  value="Snack Bar" style="width:60px"/>Snack Bar
                    <input type="checkbox" name="Amenities_Restaurant"  value="Restaurant" style="width:60px"/>Restaurant
                  </div>
                  <div class="fixed"></div>
                </div>
                
                <div class="searchItem">
                  <div class="r" style="margin-top:5px">
                    <input type="submit" value="add" />
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

