<%@ include file="header.jsp" %>
<%@page import="com.entities.Constent"%>
<%
if (!SContext.IsLoggedIn) {
response.sendRedirect(SContext.BaseURL + Constent.ACCESSDENIEDPAGE);
return;
}
 %>
    <!-- content START -->
    <div id="content"> 
      
      <!-- main START -->
      <div id="main">

	
        <div class="post">
          <h2>ChangePassword</h2>
                  
          <form action="<%=SContext.BaseURL + com.entities.Constent.CONTROLLERSERVLET + com.entities.Constent.CHANGEPASSWORD_CMD %>" method="post">
          <%
          if (SContext.ChangePasswordErrMsg != "") {
           %>
           <div style="color: red">
           <%=SContext.ChangePasswordErrMsg %>
           </div>
           <%
           }
            %>
              <div class="SearchBar">
                <div class="searchItem">
                  <div class="l"> User Name: </div>
                  <div class="r"> <%=SContext.CurrentUser.getUserName() %><input type="hidden", name="UserName", value="SContext.CurrentUser.getUserName()">
                  </div>
                  <div class="fixed"></div>
                </div>
                <div class="searchItem">
                  <div class="l"> old Password: </div>
                  <div class="r"> 
                    <input type="password" name="oldPassword" style="width:100px"/>
                  </div>
                  <div class="fixed"></div>
                </div>
                <div class="searchItem">
                  <div class="l"> new Password: </div>
                  <div class="r"> 
                    <input type="password" name="newPassword" style="width:100px"/>
                  </div>
                  <div class="fixed"></div>
                </div>
                <div class="searchItem">
                  <div class="l"> confirm new Password: </div>
                  <div class="r"> 
                    <input type="password" name="confirmnewPassword" style="width:100px"/>
                  </div>
                  <div class="fixed"></div>
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

