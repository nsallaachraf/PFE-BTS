package Models;
public class Proffesseur extends Utilisateur {
	public Proffesseur(int id, String nom_de_compte, String mot_de_pass,
			String email, String prenom, String nom){
		super(id, nom_de_compte, mot_de_pass, email, prenom, nom, 2); // ROLE 2 (PROFESSEUR)
	}
}