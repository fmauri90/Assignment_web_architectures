<%-- 
    Document   : register
    Created on : 30-dic-2015, 14.56.55
    Author     : maurizio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Registration form</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <link rel="stylesheet" type="text/css" href="style.css" />
    </head>
    <body>
		<div class="wrapper">
			<div class="content">
				<div id="form_wrapper" class="form_wrapper">
					<form class="register active"  id="form" name="form" method="post" action="RegisterServlet">
						<h3>Register</h3>
						<div class="column">
							<div>
								<label>First Name:</label>
								<input type="text" name="firstName" id="firstName" />
							</div>
							<div>
								<label>Last Name:</label>
								<input type="text" name="lastName" id="lastName" />
							</div>
							<div>
								<label>Password: min 6...</label>
								<input type="password" name="password" id="password" />
							</div>
						</div>
						<div class="column">
							<div>
								<label>User ID:</label>
								<input type="text" name="userId" id="userId" />
							</div>
							<div>
								<label>Email:</label>
								<input type="text" name="email" id="email" />
							</div>
						</div>
						<div class="clear"></div>
						<div class="bottom">
							<input type="submit" value="Register" />
							<a href="login.jsp" rel="login" class="linkform">You have an account already? Log in here</a>
							<div class="clear"></div>
						</div>
					</form>
				</div>
				<div class="clear"></div>
			</div>
		</div>
		

		
    </body>
</html>
