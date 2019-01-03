package Models;

import java.util.Date;

public class Message {
	
    private int id;
	private String text;
	private Date DateCreation;
	private int id_emetteur;
	private int id_recepteur;
	private String statut;
	
	public Message(int id, String text, Date dateCreation,int id_emetteur, int id_recepteur, String statut) {

		this.id = id;
		this.text = text;
		DateCreation = dateCreation;
		this.statut = statut;
		this.id_emetteur = id_emetteur;
		this.id_recepteur = id_recepteur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_emetteur() {
		return id_emetteur;
	}

	public void setId_emetteur(int id_emetteur) {
		this.id_emetteur = id_emetteur;
	}

	public int getId_recepteur() {
		return id_recepteur;
	}

	public void setId_recepteur(int id_recepteur) {
		this.id_recepteur = id_recepteur;
	}

	public int getIdMessage() {
		return id;
	}

	public void setIdMessage(int idMessage) {
		id = idMessage;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDateCreation() {
		return DateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		DateCreation = dateCreation;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		statut = statut;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", text=" + text + ", DateCreation="
				+ DateCreation + ", id_emetteur=" + id_emetteur
				+ ", id_recepteur=" + id_recepteur + ", statut=" + statut + "]";
	}
	
	
}