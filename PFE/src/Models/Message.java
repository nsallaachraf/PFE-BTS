package Models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Message {
	
	//Attributes
    private int idMessage;
	private String textMessage;
	private Date dateMessage;
	private int idEmetteur; //Supposed that idUtilisateur 1 is idEmetteur 
	private int idRecepteur; //Supposed that idUtilisateur 2 is idRecepteur 
	private String statutMessage;
	
	//Constructor
	public Message(int idMessage, Date dateMessage, String textMessage,  int idEmetteur, int idRecepteur, String statutMessage) {
		this.idMessage = idMessage;
		this.dateMessage = dateMessage;
		this.textMessage = textMessage;
		this.idEmetteur = idEmetteur;
		this.idRecepteur = idRecepteur;
		this.statutMessage = statutMessage;
	}

	//Constructor
	public Message(String textMessage, int idEmetteur, int idRecepteur, String statutMessage) {
		this.textMessage = textMessage;
		this.idEmetteur = idEmetteur;
		this.idRecepteur = idRecepteur;
		this.statutMessage = statutMessage;
	}
	
	//Getters & Setters
	public int getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(int idMessage) {
		this.idMessage = idMessage;
	}

	public String getTextMessage() {
		return textMessage;
	}

	public void setTextMessage(String textMessage) {
		this.textMessage = textMessage;
	}

	public Date getDateMessage() {
		return dateMessage;
	}

	public void setDateMessage(Date dateMessage) {
		this.dateMessage = dateMessage;
	}

	public int getIdEmetteur() {
		return idEmetteur;
	}

	public void setIdEmetteur(int idEmetteur) {
		this.idEmetteur = idEmetteur;
	}

	public int getIdRecepteur() {
		return idRecepteur;
	}

	public void setIdRecepteur(int idRecepteur) {
		this.idRecepteur = idRecepteur;
	}

	public String getStatutMessage() {
		return statutMessage;
	}

	public void setStatutMessage(String statutMessage) {
		this.statutMessage = statutMessage;
	}
	
	public String getDateMessageFormat() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}

	//toString Function
	@Override
	public String toString() {
		return "Message [idMessage=" + idMessage + ", textMessage=" + textMessage + ", DateMessage=" + dateMessage
				+ ", idEmetteur=" + idEmetteur + ", idRecepteur=" + idRecepteur + ", statutMessage=" + statutMessage
				+ "]";
	}
	
	
	
}