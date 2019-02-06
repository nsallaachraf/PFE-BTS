<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="DAO.*" %>
<%@ page import="Models.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/chat.css">
<title>Insert title here</title>

</head>
<body>
   <%-- si l'utilisateur n'est pas connecter va fait un redirection vers page login.jsp --%>
   <% 
//    if(session == null || session.getAttribute("isLogging") == null){
// 	   response.sendRedirect("./login.jsp");
// 	   return;
//    }
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
                   
                   int idUtilisateur = (Integer)session.getAttribute("idUtilisateur");
                   int idRecepteur = -1;
                   if(request.getParameterMap().containsKey("id"))
                   {
                	   idRecepteur = Integer.parseInt(request.getParameter("id"));
                   }
                   
                   for(Utilisateur u : users){
                	   if(u.getIdUtilisateur() != idUtilisateur){
                	   		out.write("<div class='friendCadre'>");
                	   		out.write("<li><a href='chat.jsp?id="+u.getIdUtilisateur()+"'>"+u.getNomUtilisateur()+" "+u.getPrenomUtilisateur()+"</a>");
                	   		out.write("</div>");
                	   }
                   }
                   %>
            </div>
       </div>
       <div class="rightCadre">
            <div class="topCadre">
                 <h2>
                 <%
                      if(request.getParameterMap().containsKey("id"))
                      {
                    	  try{
	                    	  int idUtilisateur2 = idRecepteur;
	                    	  for(Utilisateur u : users){
	                    		  if(u.getIdUtilisateur() == idUtilisateur2) 
	                    			  out.write(u.getNomUtilisateur() + " " + u.getPrenomUtilisateur());
	                    	  }
                    	  } catch(Exception e){
                    		  out.write("NULL"); 
							}
         		      }
                 %>
                 </h2>
            </div>
            <div class="bottomCadre">
                  <div id="chatView">
                     <%
                            ArrayList<Message> messages = mdao.getMessagesById(idUtilisateur, idRecepteur);
                            if(messages != null){
                            for(Message m : messages){
                            		out.write("<p>"+ udao.getUserById(m.getIdEmetteur()).getNomUtilisateur() +": "+ m.getTextMessage() +"</p>");
                            	}
                            }
                     %>
                  </div>
                  <div class="msgTools">
                      <form method="POST" action="#">
                           <input type="text" name="msgBox">
                           <input type="submit" id="submit" name="sendMsg" value="send">
                      </form>
                      <form method="POST" action="Login">
                         <input type="submit" name="logOut" value="log out">
                      </form>
                      <%
                      if(request.getParameterMap().containsKey("sendMsg")) {
                    	  try{
                    		  String txtMessage = (String)request.getParameter("msgBox");
                    		  int idEmetteur = idUtilisateur;

                    		  if(!txtMessage.equals("") && idUtilisateur != 0){
                    			  Message message = new Message(txtMessage, idEmetteur, idRecepteur, "Confirm");
                    			  mdao.insertMessage(message);
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
   
   <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.0/jquery.min.js"></script> 
	<script type="text/javascript"> 
	$("#submit").click(function(){
		//$("html").load(location.href + "#chatView");
	});
	</script> 
</body>
</html>