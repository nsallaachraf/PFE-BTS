<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="DAO.*" %>
<%@ page import="Models.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

                  <!-- <div class="incoming_msg_img"> 
                    <img src="https://ptetutorials.com/images/user-profile.png" alt="sunil">
                  </div> -->

                  <!-- Need to load message from database -->
                  <%
                  MessageDAO mdao = new MessageDAO();
                  int idUtilisateur = Integer.parseInt(request.getParameter("idUtilisateur"));
                  int idRecepteur = Integer.parseInt(request.getParameter("idRecepteur"));
                    ArrayList<Message> messages = mdao.getMessagesById( idUtilisateur, idRecepteur);
                    if(messages != null){
                    for(Message m : messages){
                        if(idUtilisateur == m.getIdEmetteur()){
                  %>
                  <div class="outgoing_msg">
                      <div class="sent_msg">
                        <p><%= m.getTextMessage() %></p>
                            <span class="time_date"> <%= m.getDateMessageFormat() %> </span> 
                      </div>
                  </div>
                  <%
                        } else {
                  %>
                  <div class="incoming_msg">
                      <div class="received_msg">
                        <div class="received_withd_msg">
                            <p><%= m.getTextMessage() %></p>
                            <span class="time_date"> <%= m.getDateMessageFormat() %> </span> 
                        </div>
                      </div>
                  </div>
                  <%
                        }
                      }
                    }
                  %>
                  <!-- out.write("<p>"+ udao.getUserById(m.getIdEmetteur()).getNomUtilisateur() +": "+ m.getTextMessage() +"</p>"); -->
                  <!-- End of loading a messages from database -->
</body>
</html>