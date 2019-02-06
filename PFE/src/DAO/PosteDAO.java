package DAO;
import java.sql.*;
import java.util.ArrayList;

import Models.*;
import ConnectionDB.*;

public class PosteDAO {

	//Declare a variable of Connection
	private Connexion connection;

	//Constructor of PosteDAO to initialize the variable connection
	public PosteDAO() {
		connection = Connexion.getInstance();
	}

	//This function to get the maximum id and incrementing by 1
	public int generateId() {
		try {
			ResultSet rs = connection.getResult("SELECT MAX(idPoste) AS newId FROM Poste");
			while (rs.next()) {
				//Inline if statement between ? and : is a true value and after : is a false value				
				return rs.getInt("newId") > 0 ? rs.getInt("newId") + 1 : 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//If there's an exception return -1 
		return -1;
	}

	//This function to insert an post in DataBase 
	public boolean insertPoste(Poste poste) {
		try {
			int newId = generateId(); //Calling the function in line 18
			//If there's an exception like i said before look at the line 28 it'll return false
			if (newId == -1)
				return false;
			//Create a request to insert into poste (Poste) table
            String requete = "INSERT INTO `Poste`(`idPoste`, `textPoste`, `datePoste`, `statutPoste`, `idUtilisateur`)"+
            " VALUES ("+ poste.getIdPoste() +",'"+ poste.getTextPoste() +"','"+ poste.getDatePoste() +"',"
            + poste.getStatutPoste() +","+ poste.getIdUtilisateur() +")";
			//End of Request
			int rs = connection.execUpdate(requete);
			//Inline if statement between ? and : is a true value and after : is a false value				
			return rs != 0 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			//If there's an exception return false
			return false;
		}
	}

	//This function to get all postes from database 
	public ArrayList<Poste> getPostes() {
		ArrayList<Poste> postes = new ArrayList<Poste>();
		try {
			Poste poste;
			ResultSet rs = connection.getResult("SELECT * FROM Poste");
			//If Table is empty in this case it'll return null
			if (rs.equals(null)) 
				return null;
			//while to jump row to another
			while (rs.next()) {
				poste = new Poste(rs.getInt("idPoste"), rs.getString("textPoste"), rs.getDate("datePoste"), rs.getInt("statutPoste"), rs.getInt("idUtilisateur"));
				postes.add(poste);
			}
			return postes;
		} catch (Exception e) {
			e.printStackTrace();
			//If there's an exception return false
			return null;
		}
	}

	//This function to get one post from database 
	public Poste getUserById(int idPoste) {
		try {
			Poste poste = null;
			ResultSet rs = connection.getResult("SELECT * FROM Poste WHERE idPoste="+ idPoste);
			//If Table is empty in this case it'll return null
			if (rs.equals(null)) 
				return null;
			while (rs.next()) {
				poste = new Poste(rs.getInt("idPoste"), rs.getString("textPoste"), rs.getDate("datePoste"), rs.getInt("statutPoste"), rs.getInt("idUtilisateur"));
			}
			return poste;
		} catch (Exception e) {
			e.printStackTrace();
			//If there's an exception return false
			return null;
		}
	}
}