package Models;
public class Annonce {

	private Administrateur Utilisateur;
	private int idAnnonce;
	private String text;
	private int Statut;
	
	
	public Annonce(Administrateur utilisateur, int idAnnonce, String text,
			int statut) {
		
		Utilisateur = utilisateur;
		this.idAnnonce = idAnnonce;
		this.text = text;
		Statut = statut;
	}
	public Administrateur getUtilisateur() {
		return Utilisateur;
	}
	public void setUtilisateur(Administrateur utilisateur) {
		Utilisateur = utilisateur;
	}
	public int getIdAnnonce() {
		return idAnnonce;
	}
	public void setIdAnnonce(int idAnnonce) {
		this.idAnnonce = idAnnonce;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getStatut() {
		return Statut;
	}
	public void setStatut(int statut) {
		Statut = statut;
	}
	
	
}