<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/signin.css">
<title>Login Page</title>
</head>
<body class="text-center">
     <% 
     if(session.getAttribute("isLogged") != null){
	   response.sendRedirect("./chat.jsp");
     }
	 %>
     <form method="POST" class="form-signin" action="./Login">
        <h5>
        <% 
        try{
           if(request.getAttribute("error") != null)
           out.write(request.getAttribute("error").toString());
        }catch(Exception e){
        	System.out.println("Error");
        }
        %>
         </h5>
        <input type="text" class="form-control" name="Email" id="inputEmail" placeholder="Email">
        <input type="password" class="form-control" name="Password" id="inputPassword" placeholder="Password">
        <input type="submit" name="logIn" class="btn btn-lg btn-primary btn-block" value="Log In">
     </form>
</body>
</html>