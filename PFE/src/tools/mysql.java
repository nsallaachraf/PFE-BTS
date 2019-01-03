package tools;
import java.sql.*;

public class mysql {
	 public static mysql instance;
     public Connection conn = null;
     
     private String Servername;
     private String Username;
     private String Password;
     private String dbname;
     private mysql(){
    	 Servername = "localhost";
    	 Username = "root";
    	 Password = "";
    	 dbname = "PFE";
    	 try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://" + Servername + ":3306/" + dbname,Username,Password);
		} catch (Exception e) {
			e.printStackTrace();
		}
     }
     public static mysql getInstance(){
    	 if(instance == null) instance = new mysql();
    	 return instance;
     }
     public ResultSet getResult(String requete){
    	 try {
    	  Statement stmt = conn.createStatement();
    	  ResultSet rs = stmt.executeQuery(requete);
    	  
    	  return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
     }
     public int execUpdate(String requete){
    	 try {
    	  Statement stmt = conn.createStatement();
    	  int rs = stmt.executeUpdate(requete);
    	  
    	  return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
     }
}
