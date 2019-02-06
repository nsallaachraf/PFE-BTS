package DAO;
import java.sql.*;
import java.util.ArrayList;

import Models.*;
import ConnectionDB.*;

public class MessageDAO {

	//Declare a variable of Connection
	private Connexion connection;

	//Constructor of MessageDAO to initialize the variable connection
	public MessageDAO() {
		connection = Connexion.getInstance();
	}

	//This function to get the maximum id and incrementing by 1
	// public int generateId() {
	// 	try {
	// 		ResultSet rs = connection.getResult("SELECT MAX(idMessage) AS newId FROM Message");
	// 		while (rs.next()) {
	// 			//Inline if statement between ? and : is a true value and after : is a false value				
	// 			return rs.getInt("newId") > 0 ? rs.getInt("newId") + 1 : 1;
	// 		}
	// 	} catch (Exception e) {
	// 		e.printStackTrace();
	// 	}
	// 	//If there's an exception return -1 
	// 	return -1;
	// }

	//This function to insert an message in DataBase 
	public boolean insertMessage(Message message) {
		try {
			//int newId = generateId(); //Calling the function in line 18
			//If there's an exception like i said before look at the line 28 it'll return false
			// if (newId == -1)
			// 	return false;
			//Create a query to insert into message table
			String query = "INSERT INTO `Message`(`textMessage`, `idEmetteur`, `idRecepteur`, `statutMessage`)"+
			"VALUES ('"+ message.getTextMessage() +"', "+ message.getIdEmetteur() +", "+ message.getIdRecepteur() +", '"+ message.getStatutMessage() +"')";
			//End of Request
			int rs = connection.execUpdate(query);
			//If rs is different to 0, this mean the query has been executed and it returns number of rows
			return rs != 0 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			//If there's an exception return false
			return false;
		}
	}

	//This function to get all messages from database 
	public ArrayList<Message> getMessages(int idUtilisateur) {
		ArrayList<Message> Messages = new ArrayList<Message>();
		try {
			Message message;
			ResultSet rs = connection.getResult("SELECT * FROM Message M WHERE M.idEmetteur="+ idUtilisateur +" OR M.idRecepteur=" + idUtilisateur);
			//If Table is empty in this case it'll return null
			if (rs.equals(null)) 
				return null;
			//while to jump row to another
			while (rs.next()) {
				message = new Message(rs.getInt("idMessage"), rs.getDate("dateMessage"), rs.getString("textMessage"), rs.getInt("idEmetteur"), rs.getInt("idRecepteur"), rs.getString("statutMessage"));
				Messages.add(message);
			}
			return Messages;
		} catch (Exception e) {
			e.printStackTrace();
			//If there's an exception return false
			return null;
		}
	}

	//This function to get messages from database by text, in order way you can call it search function 
	public ArrayList<Message> getMessagesByText(int idUtilisateur, String textMessage) {
		ArrayList<Message> Messages = new ArrayList<Message>();
		try {
			Message message;
			ResultSet rs = connection.getResult("SELECT * FROM Message M WHERE (M.idEmetteur = "+ idUtilisateur +" OR M.idRecepteur = "+ idUtilisateur +") AND textMessage LIKE '%"+ textMessage +"%'");
			//If Table is empty in this case it'll return null
			if (rs.equals(null)) 
				return null;
			while (rs.next()) {
				message = new Message(rs.getInt("idMessage"), rs.getDate("dateMessage"), rs.getString("textMessage"), rs.getInt("idEmetteur"), rs.getInt("idRecepteur"), rs.getString("statutMessage"));
				Messages.add(message);
			}
			return Messages;
		} catch (Exception e) {
			e.printStackTrace();
			//If there's an exception return false
			return null;
		}
	}

	//This function to get messages from database by idEmetteur and idReceptteur, this function will return Utilisateur
	public ArrayList<Message> getMessagesById(int idEmetteur, int idReceptteur) {
		ArrayList<Message> Messages = new ArrayList<Message>();
		try {
			Message message;
			ResultSet rs = connection.getResult("SELECT * FROM Message M WHERE (M.idEmetteur="+ idEmetteur +" OR M.idRecepteur="+ idEmetteur +") AND (M.idEmetteur="+ idReceptteur +" OR M.idRecepteur="+ idReceptteur +")");
			//If Table is empty in this case it'll return null
			if (rs.equals(null)) 
				return null;
			while (rs.next()) {
				message = new Message(rs.getInt("idMessage"), rs.getDate("dateMessage"), rs.getString("textMessage"), rs.getInt("idEmetteur"), rs.getInt("idRecepteur"), rs.getString("statutMessage"));
				Messages.add(message);
			}
			return Messages;
		} catch (Exception e) {
			e.printStackTrace();
			//If there's an exception return false
			return null;
		}
	}

	//This function to get messages from database by idEmetteur and idReceptteur, this function will return Utilisateur
	public String getLastMessage(int idEmetteur, int idReceptteur) {
		try {
			String message = null;
			ResultSet rs = connection.getResult("SELECT textMessage FROM Message"+
			"WHERE (idEmetteur="+ idEmetteur +" OR idRecepteur="+ idEmetteur +") AND (idEmetteur="+
			idReceptteur +" OR idRecepteur="+ idReceptteur +") ORDER BY idMessage DESC LIMIT 1");
			//If Table is empty in this case it'll return null
			if (rs.equals(null)) 
				return null;
			while (rs.next()) {
				message = rs.getString("textMessage");
			}
			return message;
		} catch (Exception e) {
			e.printStackTrace();
			//If there's an exception return false
			return null;
		}
	}
}