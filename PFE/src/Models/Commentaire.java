package Models;

import java.util.Date;

public class Commentaire {

	private int IdComm;
	private String text;
	private Date dateComm;
	private int idPoste;
	
	public Commentaire(int idComm, String text, Date dateComm, int idPoste) {

		IdComm = idComm;
		this.text = text;
		this.dateComm = dateComm;
		this.idPoste = idPoste;
	}

	public int getIdComm() {
		return IdComm;
	}

	public void setIdComm(int idComm) {
		IdComm = idComm;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDateComm() {
		return dateComm;
	}

	public void setDateComm(Date dateComm) {
		this.dateComm = dateComm;
	}

	public int getIdPoste() {
		return idPoste;
	}

	public void setIdPoste(int idPoste) {
		this.idPoste = idPoste;
	}
    
	
}