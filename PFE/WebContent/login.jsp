<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Login Page</title>
</head>
<body>
     <% 
     if(session.getAttribute("isLogged") != null){
	   response.sendRedirect("./chat.jsp");
     }
	 %>
     <div class="loginForm">
     <form method="POST" action="Login">
        <h5>
        <% 
        try{
           if(request.getAttribute("error") != null)
           out.write(request.getAttribute("error").toString());
        }catch(Exception e){
        	
        }
        %>
         </h5>
        <label for="username">Username: </label><input type="text" name="username"><br>
        <label for="password">Password: </label><input type="password" name="password"><br>
        <input type="submit" name="logIn" value="Log In">
     </form>
     </div>
</body>
</html>