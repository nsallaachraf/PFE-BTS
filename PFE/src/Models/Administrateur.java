package Models;

import java.util.*;

public class Administrateur extends Utilisateur {

	public Administrateur(int id, String nom_de_compte, String mot_de_pass,
			String email, String prenom, String nom, int role,
			ArrayList<Annonce> annonce) {
		super(id, nom_de_compte, mot_de_pass, email, prenom, nom, 3); // ROLE 3  (ADMINISTRATEUR)
	}
	
}