<%@ include file="header.jsp" %>

    <!-- content START -->
    <div id="content"> 
      
      <!-- main START -->
      <div id="main">

	
        <div class="post">
          <h2>Frind Friends</h2>
                  
          <form action="<%=SContext.BaseURL + com.entities.Constent.CONTROLLERSERVLET + com.entities.Constent.FINDFRIENDS_CMD%>" method="post">
              <div class="SearchBar">
                <div class="searchItem">
                  <div class="l"> Friend Name: </div>
                  <div class="r"> 
                    <input type="text" name="FriendName" style="width:100px"/>
                  </div>
                  <div class="fixed"></div>
                </div>
                <div class="searchItem">
                  <div class="l"> Year of birth: </div>
                  <div class="r"> 
                    From:<input type="text" name="YearOfBirthFrom" style="width:100px"/>
                    To:<input type="text" name="YearOfBirthTo" style="width:100px"/>
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

