<%@ include file="header.jsp" %>

    <!-- content START -->
    <div id="content"> 
      
      <!-- main START -->
      <div id="main">

	
        <div class="post">
          <h2>Register</h2>
                  
          <form action="servlet/Register" method="post">
              <div class="SearchBar">
                <div class="searchItem">
                  <div class="l"> User Name: </div>
                  <div class="r"> 
                    <input type="text" name="UserName" style="width:100px"/>
                  </div>
                  <div class="fixed"></div>
                </div>
                <div class="searchItem">
                  <div class="l"> Pass Word: </div>
                  <div class="r"> 
                    <input type="password" name="PassWord" style="width:100px"/>
                  </div>
                  <div class="fixed"></div>
                </div>
                <div class="searchItem">
                  <div class="l"> Email Addr: </div>
                  <div class="r"> 
                    <input type="text" name="EmailAddr" style="width:100px"/>
                  </div>
                  <div class="fixed"></div>
                </div>
                <div class="searchItem">
                  <div class="r" style="margin-top:5px">
                    <input type="submit" value="Regist" />
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

