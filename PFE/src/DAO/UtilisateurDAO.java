package DAO;
import java.sql.*;
import java.util.ArrayList;

import Models.Utilisateur;
import ConnectionDB.*;

public class UtilisateurDAO {

	//Declare a variable of Connection
	private Connexion connection;

	//Constructor of UtilisateurDAO to initialize the variable connection
	public UtilisateurDAO() {
		connection = Connexion.getInstance();
	}

	//This function to get the maximum id and incrementing by 1
	public int generateId() {
		try {
			ResultSet rs = connection.getResult("SELECT MAX(IDUtilisateur) AS newId FROM Utilisateur");
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

	//This function to insert an user in DataBase 
	public boolean InsertUser(Utilisateur User) {
		try {
			int newId = generateId(); //Calling the function in line 18
			//If there's an exception like i said before look at the line 28 it'll return false
			if (newId == -1)
				return false;
			//Create a request to insert into user (Utilisateur) table
			String requete = "INSERT INTO `Utilisateur``Utilisateur`(`idUtilisateur`, `nomUtilisateur`, `prenomUtilisateur`, `emailUtilisateur`, `passwordUtilisateur`, `cneUtilisateur`, `roleUtilisateur`, `idClasse`)" +
				"VALUES (" + User.getIdUtilisateur() + ",'" + User.getNomUtilisateur() + "','" + User.getPrenomUtilisateur() + "','" +
				User.getEmailUtilisateur() + "','" + User.getPasswordUtilisateur() + "','" + User.getCneUtilisateur() + "','" + User.getRoleUtilisateur() + "'," + User.getIdClasse() + ")";
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
	public ArrayList<Utilisateur> getUsers(int idUtilisateur) {
		ArrayList<Utilisateur> Users = new ArrayList<Utilisateur>();
		try {
			Utilisateur User;
			ResultSet rs = connection.getResult("SELECT * FROM Utilisateur WHERE idUtilisateur IN (SELECT IF(idEmetteur = "+ idUtilisateur +" , idRecepteur, idEmetteur) AS id FROM Amis A WHERE A.idEmetteur = "+ idUtilisateur +" OR A.idRecepteur = "+ idUtilisateur +" AND A.statutAmis = 'Confirm');");
			//If Table is empty in this case it'll return null
			if (rs.equals(null)) 
				return null;
			//while to jump row to another
			while (rs.next()) {
				User = new Utilisateur(rs.getInt("idUtilisateur"), rs.getString("nomUtilisateur"), rs.getString("prenomUtilisateur"),
				rs.getString("emailUtilisateur"), rs.getString("passwordUtilisateur"), rs.getString("cneUtilisateur"), 
				rs.getString("roleUtilisateur"), rs.getInt("idClasse"));
				Users.add(User);
			}
			return Users;
		} catch (Exception e) {
			e.printStackTrace();
			//If there's an exception return false
			return null;
		}
	}

	//This function to get one user from database 
	public Utilisateur getUserById(int idUtilisateur) {
		try {
			Utilisateur User = null;
			ResultSet rs = connection.getResult("SELECT * FROM Utilisateur WHERE idUtilisateur="+ idUtilisateur);
			//If Table is empty in this case it'll return null
			if (rs.equals(null)) 
				return null;
			while (rs.next()) {
				User = new Utilisateur(rs.getInt("idUtilisateur"), rs.getString("nomUtilisateur"), rs.getString("prenomUtilisateur"),
				rs.getString("emailUtilisateur"), rs.getString("passwordUtilisateur"), rs.getString("cneUtilisateur"), 
				rs.getString("roleUtilisateur"), rs.getInt("idClasse"));
			}
			return User;
		} catch (Exception e) {
			e.printStackTrace();
			//If there's an exception return false
			return null;
		}
	}

	//This function to get one user from database by email and it will return Utilisateur
	public Utilisateur getUserByEmail(String emailUtilisateur) {
		try {
			Utilisateur User = null;
			ResultSet rs = connection.getResult("SELECT * FROM Utilisateur WHERE emailUtilisateur='"+ emailUtilisateur +"'");
			//If Table is empty in this case it'll return null
			if (rs.equals(null)) 
				return null;
			while (rs.next()) {
				User = new Utilisateur(rs.getInt("idUtilisateur"), rs.getString("nomUtilisateur"), rs.getString("prenomUtilisateur"),
				rs.getString("emailUtilisateur"), rs.getString("passwordUtilisateur"), rs.getString("cneUtilisateur"), 
				rs.getString("roleUtilisateur"), rs.getInt("idClasse"));
			}
			return User;
		} catch (Exception e) {
			e.printStackTrace();
			//If there's an exception return false
			return null;
		}
	}
}