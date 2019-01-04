package Models;
public class Utilisateur {

	private int id;
	private String nom_de_compte;
	private String mot_de_pass;
	private String email;
	private String prenom;
	private String nom;
	private int role;
	
	
	public Utilisateur(int id, String nom_de_compte, String mot_de_pass,
			String email, String prenom, String nom, int role) {
		this.id = id;
		this.nom_de_compte = nom_de_compte;
		this.mot_de_pass = mot_de_pass;
		this.email = email;
		this.prenom = prenom;
		this.nom = nom;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom_de_compte() {
		return nom_de_compte;
	}

	public void setNom_de_compte(String nom_de_compte) {
		this.nom_de_compte = nom_de_compte;
	}

	public String getMot_de_pass() {
		return mot_de_pass;
	}

	public void setMot_de_pass(String mot_de_pass) {
		this.mot_de_pass = mot_de_pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom_de_compte=" + nom_de_compte
				+ ", mot_de_pass=" + mot_de_pass + ", email=" + email
				+ ", prenom=" + prenom + ", nom=" + nom + ", role=" + role
				+ "]";
	}
	
}