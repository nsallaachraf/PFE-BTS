package Models;
public class Utilisateur {
	
	//Attributes
	protected int idUtilisateur;
	protected String nomUtilisateur;
	protected String prenomUtilisateur;
	protected String passwordUtilisateur;
	protected String emailUtilisateur;
	protected String cneUtilisateur;
	protected String roleUtilisateur;
	protected int idClasse;
	
	//Constructor 
	public Utilisateur(int idUtilisateur, String nomUtilisateur, String prenomUtilisateur, String emailUtilisateur, String passwordUtilisateur, String cneUtilisateur, String roleUtilisateur, int idClasse) {
		this.idUtilisateur = idUtilisateur;
		this.nomUtilisateur = nomUtilisateur;
		this.prenomUtilisateur = prenomUtilisateur;
		this.emailUtilisateur = emailUtilisateur;
		this.passwordUtilisateur = passwordUtilisateur;
		this.cneUtilisateur = cneUtilisateur;
		this.roleUtilisateur = roleUtilisateur;
		this.idClasse = idClasse;
	}
	
	//Getter and Setter
	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getPrenomUtilisateur() {
		return prenomUtilisateur;
	}

	public void setPrenomUtilisateur(String prenomUtilisateur) {
		this.prenomUtilisateur = prenomUtilisateur;
	}

	public String getPasswordUtilisateur() {
		return passwordUtilisateur;
	}

	public void setPasswordUtilisateur(String passwordUtilisateur) {
		this.passwordUtilisateur = passwordUtilisateur;
	}

	public String getEmailUtilisateur() {
		return emailUtilisateur;
	}

	public void setEmailUtilisateur(String emailUtilisateur) {
		this.emailUtilisateur = emailUtilisateur;
	}

	public String getRoleUtilisateur() {
		return roleUtilisateur;
	}

	public void setRoleUtilisateur(String roleUtilisateur) {
		this.roleUtilisateur = roleUtilisateur;
	}

	public String getCneUtilisateur() {
		return cneUtilisateur;
	}

	public void setCneUtilisateur(String cneUtilisateur) {
		this.cneUtilisateur = cneUtilisateur;
	}
	
	public int getIdClasse() {
		return idClasse;
	}

	public void setIdClasse(int idClasse) {
		this.idClasse = idClasse;
	}

	//toString Function
	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", nomUtilisateur=" + nomUtilisateur
				+ ", prenomUtilisateur=" + prenomUtilisateur + ", passwordUtilisateur=" + passwordUtilisateur
				+ ", emailUtilisateur=" + emailUtilisateur + ", cneUtilisateur=" + cneUtilisateur + ", roleUtilisateur="
				+ roleUtilisateur + ", idClasse=" + idClasse + "]";
	}
}