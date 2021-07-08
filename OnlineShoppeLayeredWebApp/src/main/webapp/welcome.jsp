<jsp:useBean id="ob" class="com.phoenix.web.models.LoginBean" scope="request">
</jsp:useBean>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<!-- <head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
-->
<%@include file="header.html" %>
<body bgcolor="cyan">
	<h3>Dear <jsp:getProperty property="username" name="ob"/>, Welcome to Phoenix</h3>
	<%
		String username = request.getParameter("username");
	
		//setting attribute
		session.setAttribute("user", username);
		
		//setting interval
		session.setMaxInactiveInterval(30);
		
		//debug session id
		System.out.println("Welcome Servlet Session ID: "+session.getId());
		
		//encoding product url
		String encodedProductUrl = response.encodeURL("ProductAllServlet");
	%>
	<p>Session time out is: <%=session.getMaxInactiveInterval() %> second</p>
	<p>To enjoy Shopping <a href="<%= encodedProductUrl %>">Click here</a>
</body>
<%@include file="footer.html" %>
</html>