package Models;

import java.util.*;

public class Poste {

	private int idPoste;
	private String text;
	private String File;
	private Date datePoste;
	private int Statut;
	private ArrayList<Commentaire> Commentaires;
	
	public Poste(int idPoste, String text, String file, Date datePoste,
			int statut) {

		this.idPoste = idPoste;
		this.text = text;
		File = file;
		this.datePoste = datePoste;
		Statut = statut;
		Commentaires = null;
	}

	public int getIdPoste() {
		return idPoste;
	}

	public void setIdPoste(int idPoste) {
		this.idPoste = idPoste;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getFile() {
		return File;
	}

	public void setFile(String file) {
		File = file;
	}

	public Date getDatePoste() {
		return datePoste;
	}

	public void setDatePoste(Date datePoste) {
		this.datePoste = datePoste;
	}

	public int getStatut() {
		return Statut;
	}

	public void setStatut(int statut) {
		Statut = statut;
	}

	public ArrayList<Commentaire> getCommentaires() {
		return Commentaires;
	}

	public void setCommentaires(ArrayList<Commentaire> commentaires) {
		Commentaires = commentaires;
	}
	
	
}