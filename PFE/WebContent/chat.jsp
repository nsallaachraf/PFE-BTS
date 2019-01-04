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
</head>
<body>
   <%-- si l'utilisateur n'est pas connecter va fait un redirection vers page login.jsp --%>
   <%-- if(session.getAttribute("isLogged") == null){
	   response.sendRedirect("/login.jsp");
   }--%>
   
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
                   
                   int userId = 0;
                   
                   for(Utilisateur u : users){
                	   out.write("<div class='friendCadre'>");
                	   out.write("<li><a href='chat.jsp?id="+u.getId()+"'>"+u.getNom()+" "+u.getPrenom()+"</a>");
                	   out.write("</div>");
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
                    	  userId = Integer.parseInt(request.getParameter("id"));
                    	  for(Utilisateur u : users){
                    		  if(u.getId() == userId) out.write(u.getNom() + " " + u.getPrenom());
                    	  }
                    	  }catch(Exception e){ out.write("NULL"); }
         		      }
                 %></h2>
            </div>
            <div class="bottomCadre">
                  <div class="chatView">
                     <%
                            ArrayList<Message> messages = mdao.getMessage(userId);
                            for(Message m : messages){
                            	out.write("<p>"+m.getId_emetteur()+": "+m.getText());
                            }
                     %>
                  </div>
                  <div class="msgTools">
                      <form method="POST" action="#">
                           <input type="text" name="msgBox">
                           <input type="submit" name="sendMsg" value="send">
                      </form>
                      <%
                      if(request.getParameterMap().containsKey("sendMsg")) {
                    	  try{
                    		  String msg = (String)request.getParameter("msgBox");
                    		  int id_emetteur = (Integer)session.getAttribute("id");
                    		  if(!msg.equals("") && userId != 0){
                    			  mdao.AddMessage(msg, id_emetteur, userId);
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