package DAO;

import java.sql.*;
import java.util.ArrayList;

import ConnectionDB.Connexion;
import Models.*;

/**
 * ClasseDAO
 */

public class ClasseDAO {

    //Declare a variable of Connection
	private Connexion connection;

	//Constructor of UtilisateurDAO to initialize the variable connection
	public ClasseDAO() {
		connection = Connexion.getInstance();
	}

	//This function to get the maximum id and incrementing by 1
	public int generateId() {
		try {
			ResultSet rs = connection.getResult("SELECT MAX(IDUtilisateur) AS newId FROM Classe");
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

	//This function to insert a Classe in DataBase 
	public boolean InsertClasse(Classe C) {
		try {
			int newId = generateId(); //Calling the function in line 18
			//If there's an exception like i said before look at the line 28 it'll return false
			if (newId == -1)
				return false;
			//Create a request to insert into Classroom (Classe) table
            String requete = "INSERT INTO `Classe`(`idClasse`, `nomClasse`, `anneeClasse`)"+
            " VALUES ("+ C.getIdClasse() +",'"+ C.getNomClasse() +"','"+ C.getAnneeClasse() +"')";
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

	//This function to get all users from database 
	public ArrayList<Classe> getClasses() {
		ArrayList<Classe> Classes = new ArrayList<Classe>();
		try {
			Classe classe;
			ResultSet rs = connection.getResult("SELECT * FROM Classe");
			//If Table is empty in this case it'll return null
			if (rs.equals(null)) 
				return null;
			//Using while to jump row to another
			while (rs.next()) {
				classe = new Classe(rs.getInt("idClasse"), rs.getString("nomClasse"), rs.getString("anneeClasse"));
				Classes.add(classe);
			}
			return Classes;
		} catch (Exception e) {
			e.printStackTrace();
			//If there's an exception return false
			return null;
		}
	}

	//This function to get one classroom from database 
	public Classe getClasseById(int idClasse) {
		try {
			Classe classe = null;
			ResultSet rs = connection.getResult("SELECT * FROM Classe WHERE idClasse="+ idClasse);
			//If Table is empty in this case it'll return null
			if (rs.equals(null)) 
				return null;
			while (rs.next()) {
				classe = new Classe(rs.getInt("idClasse"), rs.getString("nomClasse"), rs.getString("anneeClasse"));
			}
			return classe;
		} catch (Exception e) {
			e.printStackTrace();
			//If there's an exception return false
			return null;
		}
	}
}