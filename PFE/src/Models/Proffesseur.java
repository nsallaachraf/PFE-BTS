package Models;
public class Proffesseur extends Utilisateur {
	
	//Constructor
	public Proffesseur(int idUtilisateur, String nomUtilisateur, String prenomUtilisateur, String emailUtilisateur, String passwordUtilisateur, String cneUtilisateur, String roleUtilisateur, int idClasse) {
		super(idUtilisateur, nomUtilisateur, prenomUtilisateur, emailUtilisateur, passwordUtilisateur, cneUtilisateur,roleUtilisateur, idClasse);	
	}

	//toString Function
	@Override
	public String toString() {
		return "Proffesseur [idUtilisateur=" + idUtilisateur + ", nomUtilisateur=" + nomUtilisateur
				+ ", prenomUtilisateur=" + prenomUtilisateur + ", passwordUtilisateur=" + passwordUtilisateur
				+ ", emailUtilisateur=" + emailUtilisateur + ", cneUtilisateur=" + cneUtilisateur + ", roleUtilisateur="
				+ roleUtilisateur + ", idClasse=" + idClasse + "]";
	}
}