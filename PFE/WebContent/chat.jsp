<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="DAO.*" %>
<%@ page import="Models.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/chat.css">
<title>Insert title here</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/ 
libs/jquery/1.3.0/jquery.min.js"></script> 
<script type="text/javascript"> 
setInterval(function(){
    $('#chatView').load('./chat.jsp');
},1000);
</script> 
</head>
<body>
   <%-- si l'utilisateur n'est pas connecter va fait un redirection vers page login.jsp --%>
   <% 
   if(session == null || session.getAttribute("isLogged") == null){
	   response.sendRedirect("./login.jsp");
	   return;
   }
   %>
   <div class="cadreChat">
       <div class="leftCadre">
            <div class="topCadre">
                   <form method="GET" action="Chat">
                      <input type="text" name="friendName">
                      <input type="submit" name="searchFriend" value="Search">
                   </form>
            </div>
            <div class="bottomCadre">
                   <h3>Users</h3>
                   <%
                   UtilisateurDAO udao = new UtilisateurDAO();
                   MessageDAO mdao = new MessageDAO();
                   ArrayList<Utilisateur> users = udao.getUsers();
                   Utilisateur user = null;
                   
                   int userId = (Integer)session.getAttribute("UserId");
                   int id_recepteur = -1;
                   if(request.getParameterMap().containsKey("id"))
                   {
                   id_recepteur = Integer.parseInt(request.getParameter("id"));
                   }
                   
                   for(Utilisateur u : users){
                	   if(u.getId() != userId){
                	   out.write("<div class='friendCadre'>");
                	   out.write("<li><a href='chat.jsp?id="+u.getId()+"'>"+u.getNom()+" "+u.getPrenom()+"</a>");
                	   out.write("</div>");
                	   }
                   }
                   %>
            </div>
       </div>
       <div class="rightCadre">
            <div class="topCadre">
                 <h2><%
                      if(request.getParameterMap().containsKey("id"))
                      {
                    	  try{
                    	  int user2 = id_recepteur;

                    	  for(Utilisateur u : users){
                    		  if(u.getId() == user2) out.write(u.getNom() + " " + u.getPrenom());
                    	  }
                    	  }catch(Exception e){ out.write("NULL"); }
         		      }
                 %></h2>
            </div>
            <div class="bottomCadre">
                  <div id="chatView">
                     <%
                            ArrayList<Message> messages = mdao.getMessage(userId, id_recepteur);
                            if(messages != null){
                            for(Message m : messages){
                            	out.write("<p>"+ udao.getUserById(m.getId_emetteur()).getNom() +": "+m.getText()+"</p>");
                            }
                            }
                     %>
                  </div>
                  <div class="msgTools">
                      <form method="POST" action="#">
                           <input type="text" name="msgBox">
                           <input type="submit" name="sendMsg" value="send">
                      </form>
                      <form method="POST" action="Login">
                         <input type="submit" name="logOut" value="log out">
                      </form>
                      <%
                      if(request.getParameterMap().containsKey("sendMsg")) {
                    	  try{
                    		  String msg = (String)request.getParameter("msgBox");
                    		  int id_emetteur = userId;

                    		  if(!msg.equals("") && userId != 0){
                    			  mdao.AddMessage(msg, id_emetteur, id_recepteur);
                    		  }
                    		  response.setIntHeader("Refresh",1);
                    	  }catch(Exception e){
                    		  e.printStackTrace();
                    	  }
                      }
                      %>
                  </div>
            </div>
       </div>
   </div>
</body>
</html>