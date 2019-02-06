package Models;

import java.util.*;

public class Poste {
	
	//Attributes
	private int idPoste;
	private String textPoste;
	private Date datePoste;
	private int statutPoste;
	private ArrayList<Commentaire> CommentairesPoste;
	private int idUtilisateur;
	
	//Constructor of 5 Arguments
	public Poste(int idPoste, String textPoste, Date datePoste, int statutPoste, int idUtilisateur) {
		this.idPoste = idPoste;
		this.textPoste = textPoste;
		this.datePoste = datePoste;
		this.statutPoste = statutPoste;
		this.CommentairesPoste = null;
		this.idUtilisateur = idUtilisateur;
	}
	
	//Constructor of 6 Arguments including the ArrayList
	public Poste(int idPoste, String textPoste, Date datePoste, int statutPoste, ArrayList<Commentaire> commentairesPoste, int idUtilisateur) {
		this.idPoste = idPoste;
		this.textPoste = textPoste;
		this.datePoste = datePoste;
		this.statutPoste = statutPoste;
		this.CommentairesPoste = commentairesPoste;
		this.idUtilisateur = idUtilisateur;
	}

	//Getters And Setters
	public int getIdPoste() {
		return idPoste;
	}

	public void setIdPoste(int idPoste) {
		this.idPoste = idPoste;
	}

	public String getTextPoste() {
		return textPoste;
	}

	public void setTextPoste(String textPoste) {
		this.textPoste = textPoste;
	}

	public Date getDatePoste() {
		return datePoste;
	}

	public void setDatePoste(Date datePoste) {
		this.datePoste = datePoste;
	}

	public int getStatutPoste() {
		return statutPoste;
	}

	public void setStatutPoste(int statutPoste) {
		this.statutPoste = statutPoste;
	}

	public ArrayList<Commentaire> getCommentairesPoste() {
		return CommentairesPoste;
	}

	public void setCommentairesPoste(ArrayList<Commentaire> commentairesPoste) {
		CommentairesPoste = commentairesPoste;
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
		return "Poste [idPoste=" + idPoste + ", textPoste=" + textPoste + ", datePoste=" + datePoste + ", statutPoste="
				+ statutPoste + ", CommentairesPoste=" + CommentairesPoste + ", idUtilisateur=" + idUtilisateur + "]";
	}
}