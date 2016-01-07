<%-- 
    Document   : register
    Created on : 30-dic-2015, 14.56.55
    Author     : maurizio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <link rel="stylesheet" type="text/css" href="style.css" />
    </head>
        <%            
            session.removeAttribute("userId");
            session.removeAttribute("password");
            session.invalidate();
        %>
    <body>
		<div class="wrapper">
			<div class="content">
				<div id="form_wrapper" class="form_wrapper">
					
					<form class="login active" id="form" name="form" method="post" action="ProfileServlet">
						<h3>Login</h3>
						<div>
							<label>User ID:</label>
							<input type="text" name="userId" id="userId" />
						</div>
						<div>
							<label>Password: </label>
							<input type="password" name="password" id="password" />
						</div>
						<div class="bottom">
							<input type="submit" value="Login"/>
							<a href="register.jsp" class="linkform">You don't have an account yet? Register here</a>
							<div class="clear"></div>
						</div>
					</form>
				</div>
				<div class="clear"></div>
			</div>
		</div>
    </body>
</html>
