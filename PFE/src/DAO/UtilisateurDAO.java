package DAO;
import java.sql.*;
import java.util.ArrayList;

import Models.Utilisateur;
import tools.mysql;

public class UtilisateurDAO {
	   private mysql sql;
	   public UtilisateurDAO(){
		     sql  = mysql.getInstance();
	   }
	   public int generateId(){
		   try {
			  ResultSet rs = sql.getResult("SELECT max(id) as newId FROM Utilisateur");
			  while(rs.next())
			  {
			       return rs.getInt("newId") > 0 ? rs.getInt("newId")+1 : 1;
			  }
		   } catch (Exception e) {
			  e.printStackTrace();
		   }
		   return -1;
	   }
	   public boolean CreateUser(Utilisateur user){
		   try {
			   if(generateId() == -1) return false;
			   int newId = generateId();
			   String requete = "INSERT INTO Utilisateur(id,nom_de_compte,mot_de_pass,email,nom,prenom,role)"
			   		                                  +"VALUES('"+ newId                  +",'"
					                                             + user.getNom_de_compte()+"','"
                                                                 + user.getMot_de_pass()  +"','"
					                                             + user.getEmail()        +"','"
					                                             + user.getNom()          +"','"
					                                             + user.getPrenom()       +"',"
					                                             + user.getRole()         +")";
			   System.out.println(requete);
			   int rs = sql.execUpdate(requete);
			   return rs != 0 ? true : false;
		   } catch (Exception e) {
			   e.printStackTrace();
			   return false;
		   }
	   }
       public ArrayList<Utilisateur> getUsers(){
    	       ArrayList<Utilisateur> users = new ArrayList<Utilisateur>();
    	       try {
        	      Utilisateur user;
        	      ResultSet rs = sql.getResult("SELECT * from Utilisateur");
        	      if(rs.equals(null)) return null;
        	      while(rs.next()){
        		          user = new Utilisateur(rs.getInt("id"),
        				                  rs.getString("nom_de_compte"),
        				                  rs.getString("mot_de_pass"),
        				                  rs.getString("email"),
        				                  rs.getString("prenom"),
        				                  rs.getString("nom"),
        				                  rs.getInt("role"));
        		          users.add(user);
        	      }
        	      return users;
        	   
		       } catch (Exception e) {
			           e.printStackTrace();
			           return null;
		       }      
       }
       public Utilisateur getUserById(int id){
    	   ArrayList<Utilisateur> users = getUsers();
    	   for(Utilisateur u : users){
    		   if(u.getId() == id) return u;
    	   }
    	   return null;
       }
}
