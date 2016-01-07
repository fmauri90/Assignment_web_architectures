<%-- 
    Document   : profile
    Created on : 4-gen-2016, 14.56.09
    Author     : maurizio
--%>


<%@page import = "service.LoginService" %>
<%@page import = "model.User" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css"/>
        <title>Profile Page</title>
    </head>
    <body>
    <center>
        <div id="mystyle" class="myform">
            <form id="form" name="form" method="post" action="login.jsp">
            <h1>My Profile</h1>
            <%
                User user = (User) session.getAttribute("user");
            %>
            
            <label>First Name: <%= user.getFirstName()%></label><br/><br/>
            <label>Last Name: <%= user.getLastName()%></label><br/><br/>
            <label>User Name: <%= user.getUserId()%></label><br/><br/>
            <label>Password: <%= user.getPassword()%></label><br/><br/>
            <label>Email: <%= user.getEmail()%></label><br/><br/>
            <%--<a href="logout.jsp">Logout</a>--%>
            <button type="submit">Logout</button>
            <div class="spacer"></div>
            </form>
        </div> 
    </center>
    </body>
</html>
