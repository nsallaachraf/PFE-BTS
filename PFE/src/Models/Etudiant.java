package Models;
public class Etudiant extends Utilisateur {

	private String CNE;
	private String Branche;
	private String Cycle;
	
	public Etudiant(int id, String nom_de_compte, String mot_de_pass,
			String email, String prenom, String nom,String cNE, String branche, String cycle) {
		super(id, nom_de_compte, mot_de_pass, email, prenom, nom, 1); // ROLE 1 (ETUDIANT)
		CNE = cNE;
		Branche = branche;
		Cycle = cycle;
	}

	public String getCNE() {
		return CNE;
	}

	public void setCNE(String cNE) {
		CNE = cNE;
	}

	public String getBranche() {
		return Branche;
	}

	public void setBranche(String branche) {
		Branche = branche;
	}

	public String getCycle() {
		return Cycle;
	}

	public void setCycle(String cycle) {
		Cycle = cycle;
	}
	
	
}