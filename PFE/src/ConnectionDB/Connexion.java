
package ConnectionDB;
import java.sql.*;

public class Connexion {
	
	 public static Connexion instance;
     public Connection Con = null;
     
     private String Servername;
     private String Username;
     private String Password;
     private String dbname;
     
     public boolean isConnected = false;
     
     private Connexion(){
    	 Servername = "localhost";
    	 Username = "root";
    	 Password = "root";
    	 dbname = "Project";
    	 try {
			Class.forName("com.mysql.jdbc.Driver");
			Con = DriverManager.getConnection("jdbc:mysql://" + Servername + ":8889/" + dbname,Username,Password);
			isConnected = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
     }
     
     public static Connexion getInstance(){
    	 if(instance == null) 
    		 instance = new Connexion();
    	 return instance;
     }
     public ResultSet getResult(String requete){
    	 try {
    	  Statement stmt = Con.createStatement();
    	  ResultSet rs = stmt.executeQuery(requete);
    	  
    	  return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
     }
     public int execUpdate(String requete){
    	 try {
    	  Statement stmt = Con.createStatement();
    	  int rs = stmt.executeUpdate(requete);
    	  
    	  return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
     }
}