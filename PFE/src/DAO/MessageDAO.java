package DAO;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import Models.Message;
import Models.Utilisateur;
import tools.mysql;

public class MessageDAO {
	   private mysql sql;
	   public MessageDAO(){
		     sql  = mysql.getInstance();
	   }
	   public int generateId(){
		   try {
			  ResultSet rs = sql.getResult("SELECT max(id) as newId FROM message");
			  while(rs.next())
			  {
			       return rs.getInt("newId") > 0 ? rs.getInt("newId")+1 : 1;
			  }
		   } catch (Exception e) {
			  e.printStackTrace();
		   }
		   return -1;
	   }
	   public ArrayList<Message> getMessage(int id_emetteur,int id_recepteur){
		   ArrayList<Message> Messages = new ArrayList<Message>();
	       try {
	    	  Message msg;
    	      ResultSet rs = sql.getResult("SELECT * FROM message WHERE id_emetteur="+ id_emetteur+" AND id_recepteur="+id_recepteur+" OR id_emetteur="+ id_recepteur+" AND id_recepteur="+id_emetteur);
    	      if(rs.equals(null)) return null;
    	      while(rs.next()){
    		          msg = new Message(rs.getInt("id"),
    				                  rs.getString("text"),
    				                  rs.getDate("dateCreation"),
    				                  rs.getInt("id_emetteur"),
    				                  rs.getInt("id_recepteur"),
    				                  rs.getString("statut"));
    		          Messages.add(msg);
    	      }
    	      return Messages;
    	   
	       } catch (Exception e) {
		           e.printStackTrace();
		           return null;
	       }
	   }
	   public boolean AddMessage(String message, int id_emetteur, int id_recepteur){
		   try {
			   if(generateId() == -1) return false;
			   int newId = generateId();
			   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			   Date date = new Date();
			   String requete = "INSERT INTO message(id,text,dateCreation,id_emetteur,id_recepteur,statut)"
			   		                                  +" VALUES("  + newId                   +",'"
			   		                                               + message                 +"','"
                                                                   + dateFormat.format(date) +"',"
                                                                   + id_emetteur             +","
                                                                   + id_recepteur            +",'"
					                                               + "pas encore"            +"')";
			   int rs = sql.execUpdate(requete);
			   return rs != 0 ? true : false;
		   } catch (Exception e) {
			   e.printStackTrace();
			   return true;
		   }
		   
	   }
	   public boolean SupprimerMessage(int messageId){
		   try {
			   String requete = "DELETE FROM message WHERE id="+ messageId;
			   int rs = sql.execUpdate(requete);
			   return rs != 0 ? true : false;
		   } catch (Exception e) {
			   e.printStackTrace();
			   return true;
		   }
	   }
}
