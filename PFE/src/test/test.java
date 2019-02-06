package test;

import DAO.*;
import Models.*;

public class test {

	public static void main(String[] args) {
		// Classe C = new Classe(1, "2eme DSI", "2eme Année");
		// Utilisateur U = new Utilisateur(1, "Youssef", "Fatihi", "Youssef@gmail.com", "123qwerty", "G123543", "Student", 1);
		UtilisateurDAO userDAO = new UtilisateurDAO();
		Utilisateur user = userDAO.getUserByEmail("Youssef@gmail.com");
		System.out.println(user);
		if(user.getEmailUtilisateur().equals("Youssef@gmail.com") && user.getPasswordUtilisateur().equals("qwerty123")) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
	}
}