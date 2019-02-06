package Models;

import java.util.Date;

public class Commentaire {
	
	//Attributes
	private int idCommentaire;
	private String textCommentaire;
	private Date dateCommentaire;
	private int idPoste;
	private int idUtilisateur;
	
	//Constructor
	public Commentaire(int idCommentaire, String textCommentaire, Date dateCommentaire, int idPoste, int idUtilisateur) {
		this.idCommentaire = idCommentaire;
		this.textCommentaire = textCommentaire;
		this.dateCommentaire = dateCommentaire;
		this.idPoste = idPoste;
		this.setIdUtilisateur(idUtilisateur);
	}
	
	//Getter & Setters
	public int getIdCommentaire() {
		return idCommentaire;
	}
	public void setIdCommentaire(int idCommentaire) {
		this.idCommentaire = idCommentaire;
	}
	public String getTextCommentaire() {
		return textCommentaire;
	}
	public void setTextCommentaire(String textCommentaire) {
		this.textCommentaire = textCommentaire;
	}
	public Date getDateCommentaire() {
		return dateCommentaire;
	}
	public void setDateCommentaire(Date dateCommentaire) {
		this.dateCommentaire = dateCommentaire;
	}
	public int getIdPoste() {
		return idPoste;
	}
	public void setIdPoste(int idPoste) {
		this.idPoste = idPoste;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	//toString Function
	@Override
	public String toString() {
		return "Commentaire [idCommentaire=" + idCommentaire + ", textCommentaire=" + textCommentaire
				+ ", dateCommentaire=" + dateCommentaire + ", idPoste=" + idPoste + "]";
	}
}