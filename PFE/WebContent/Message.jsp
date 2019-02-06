<%@ page import="ConnectionDB.Connexion"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="DAO.*" %>
<%@ page import="Models.*" %>
<%@ page import="java.util.*" %>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->


<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" type="text/css" rel="stylesheet">
<link href="css/Message.css" type="text/css" rel="stylesheet">

</head>
<body>
  <div class="container">
    <h3 class=" text-center">Messaging</h3>
    <div class="messaging">
          <div class="inbox_msg">
            <div class="inbox_people">
              <div class="headind_srch">
                <div class="recent_heading">
                  <h4>Recent</h4>
                </div>
                <div class="srch_bar">
                  <div class="stylish-input-group">
                    <input type="text" class="search-bar"  placeholder="Search" >
                    <span class="input-group-addon">
                    <button type="button">
                      <i class="fa fa-search" aria-hidden="true"></i>
                    </button>
                    </span> </div>
                </div>
              </div>
              <div class="inbox_chat">
                <!-- Need a for loop to list a users from database -->
                <%
                      int idUtilisateur = (Integer)session.getAttribute("idUtilisateur");
                      UtilisateurDAO udao = new UtilisateurDAO();
                      MessageDAO mDAO = new MessageDAO();
                      ArrayList<Utilisateur> users = udao.getUsers(idUtilisateur);
                      Utilisateur user = null;
                      int idRecepteur = -1;
                      if(request.getParameterMap().containsKey("id"))
                      {
                        idRecepteur = Integer.parseInt(request.getParameter("id"));
                      }
                      

                      for(Utilisateur u : users){
                        if(u.getIdUtilisateur() != idUtilisateur){
                %>
                <div class="chat_list active_chat">
                    <div class="chat_people">
                      <div class="chat_img"> 
                        <img src="https://ptetutorials.com/images/user-profile.png" alt="sunil">
                      </div>
                      <div class="chat_ib">
                        <h5><a href='Message.jsp?id=<%= u.getIdUtilisateur() %>'> <%= u.getNomUtilisateur()+" "+u.getPrenomUtilisateur() %></a> <span class="chat_date">Dec 25</span></h5>
                        <p>Lorem ipsum is placeholder text commonly used in the graphic</p>
                      </div>
                    </div>
                </div>
                <%
                        }
                      }
                %>
                <!-- End of listing a users -->
              </div>
            </div>
            <div class="mesgs">
            	<div class="msg_history" id="msg_history">
		             <jsp:include page="test.jsp">
				        <jsp:param name="idUtilisateur" value="<%= idUtilisateur %>" />
				        <jsp:param name="idRecepteur" value="<%= idRecepteur %>" />
				    </jsp:include>
			    </div>
			      <!-- BEGIN -->
            <div class="type_msg">
                <div class="input_msg_write">
                    <form method="POST" action="#">
                      <input type="text" class="write_msg" name="textMessage" placeholder="Type a message" />
                      <button class="msg_send_btn" type="submit" id="submit" name="sendMsg" value="send">
                        <i class="fa fa-paper-plane-o" aria-hidden="true"></i>
                      </button>
                  </form>
                  <%
                    if(request.getParameterMap().containsKey("sendMsg")) {
                      try{
                        String txtMessage = (String)request.getParameter("textMessage");
                        int idEmetteur = idUtilisateur;

                        if(!txtMessage.equals("") && idUtilisateur != 0){
                          Message message = new Message(txtMessage, idEmetteur, idRecepteur, "Confirm");
                          mDAO.insertMessage(message);
                        }
                        response.setIntHeader("Refresh",1);
                      }catch(Exception e){
                        e.printStackTrace();
                      }
                    }
                  %>
                </div>
              </div>
              <!-- END -->
			</div>
          </div>      
    </div>
  </div>
  <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
  <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script type="text/javascript"> 
    $("#submit").click(function(){
    	$("#msg_history").load(location.href + " #msg_history");
    });
  </script>
</body>

</html>