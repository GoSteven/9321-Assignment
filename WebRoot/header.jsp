<%@ page session="true" %>
<%@page import="java.util.*"%>
<%@page import="java.text.*" %>
<jsp:useBean id="MContext" class="com.models.ModelContext" scope="session"/>
	
<jsp:useBean id="SContext" class="com.models.SessionContext" scope="session"/>
	
<% 
	if (SContext.BaseURL == "") {
	 SContext.BaseURL = request.getScheme()+"://"+request.getServerName()+":"+
		request.getServerPort()+request.getContextPath();
		}
		
		%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:fb="http://www.facebook.com/2008/fbml">
<head>
<title>MM Movie!!</title>

<!-- style START -->
<!-- default style -->
<style type="text/css" media="screen">
@import url( files/style.css );
</style>
<!-- for translations -->
<!--[if IE]>
		<link rel="stylesheet" href="http://coolshell.cn/wp-content/themes/inove/ie.css" type="text/css" media="screen" />
	<![endif]-->
<!-- style END -->

<!-- script START -->
<script type="text/javascript" src="./files/base.js"></script>
<script type="text/javascript" src="./files/menu.js"></script>
<script type="text/javascript" src="http://connect.facebook.net/hi_IN/all.js"></script>

<SCRIPT language=JavaScript src="<%=SContext.BaseURL%>/files/calendar.js"></SCRIPT>
<!-- script END -->

<!-- /all in one seo pack -->
</head>

<body>
<!-- wrap START -->
<div id="wrap"> 
  
  <!-- container START -->
  <div id="container"> 
    
    <!-- header START -->
    <div id="header"> 
      
      <!-- banner START --> 
      <!--<div id="banner">
      <div id="fb-root"></div><script src="http://connect.facebook.net/en_US/all.js#appId=218504571507071&amp;xfbml=1"></script><fb:login-button show-faces="true" width="200" max-rows="1"></fb:login-button>
      </div>
      --><!-- banner END --> 
      
      <!--<div id="caption">
		<h1 id="title"><a href="index.jsp">Steven's Real Estate</a></h1>
		<div id="tagline">Better Life , Better tomorrow</div>
	</div>-->
      
      <div class="fixed"></div>
    </div>
    <!-- header END --> 
    
    <!-- navigation START -->
    <div id="navigation"> 
      <!-- menus START -->
      <ul id="menus">
        <li class="current_page_item"><a class="home" title="HOME" href="<%= SContext.BaseURL + com.entities.Constent.INDEXPAGE %>">HOME</a></li>
        <li class="page_item page-item-3839"><a href="<%= SContext.BaseURL + com.entities.Constent.DOSEARCHPAGE %>" title="Search">Search</a></li>
        <li class="page_item page-item-2"><a href="<%= SContext.BaseURL + "/NowShowing.jsp" %>" title="Now Showing">Now Showing</a></li>
        <li class="page_item page-item-368"><a href="<%= SContext.BaseURL + "/ComingSoon.jsp" %>" title="Comming Soon">Comming Soon</a></li>
        <% if (SContext.IsOwner())  {%>
        <li class="page_item page-item-368"><a href="<%= SContext.BaseURL + com.entities.Constent.ADMINPAGE %>" title="Manage">Manage</a></li>
        <% } %>
        <li><a class="lastmenu" href="javascript:void(0);"></a></li>
      </ul>
      <!-- menus END -->
      
      <div class="fixed"></div>
    </div>
    <!-- navigation END --> 