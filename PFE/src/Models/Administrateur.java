package Models;

public class Administrateur extends Utilisateur {

	//Constructor
	public Administrateur(int idUtilisateur, String nomUtilisateur, String prenomUtilisateur, String emailUtilisateur, String passwordUtilisateur, String cneUtilisateur, String roleUtilisateur, int idClasse) {
		super(idUtilisateur, nomUtilisateur, prenomUtilisateur, emailUtilisateur, passwordUtilisateur, cneUtilisateur, roleUtilisateur, idClasse);
	}

	//toString Function
	@Override
	public String toString() {
		return "Administrateur [idUtilisateur=" + idUtilisateur + ", nomUtilisateur=" + nomUtilisateur
				+ ", prenomUtilisateur=" + prenomUtilisateur + ", passwordUtilisateur=" + passwordUtilisateur
				+ ", emailUtilisateur=" + emailUtilisateur + ", cneUtilisateur=" + cneUtilisateur + ", roleUtilisateur="
				+ roleUtilisateur + ", idClasse=" + idClasse + "]";
	}
}