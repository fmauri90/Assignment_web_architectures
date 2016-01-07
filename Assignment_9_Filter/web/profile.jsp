<%-- 
    Document   : register
    Created on : 30-dic-2015, 14.56.55
    Author     : maurizio
--%>

<%@page import = "service.LoginService" %>
<%@page import = "model.User" %>
<%@page import = "javax.servlet.http.HttpSession" %>
<%@page import = "javax.servlet.http.HttpServletRequest" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Profile</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <link rel="stylesheet" type="text/css" href="style.css" />
    </head>
    <body>
		<div class="wrapper">
			<div class="content">
				<div id="form_wrapper" class="form_wrapper">
					<form class="register active"  id="form" name="form" method="post" action="login.jsp">
						<h3>My Profile</h3>
						<%
                                                HttpServletRequest req = (HttpServletRequest) request;

                                                session = req.getSession();
                                               
                                                User user = (User) session.getAttribute("user");
                                                if(user != null){
                                                %>
						<div class="column">
							<div>
                                                            <label><h4>First Name:</h4><%= user.getFirstName()%></label>
							</div>
							<div>
								<label><h4>Last Name:</h4><%= user.getLastName()%></label>
							</div>
						</div>
						<div class="column">
							<div>
								<label><h4>User ID:</h4><%= user.getUserId()%></label>
							</div>
							<div>
								<label><h4>Email:</h4><%= user.getEmail()%></label>
							</div>
						</div>
						<div class="clear"></div>
						<div class="bottom">
							<input type="submit" value="Logout"/>
							<div class="clear"></div>
						</div>
                                                <%}%>
					</form>
				</div>
				<div class="clear"></div>
			</div>
		</div>
		
    </body>
</html>
