package Models;
public class Annonce {
	
	//Attributes
	private Administrateur Aministrateur;
	private int idAnnonce;
	private String textAnnonce;
	private int statutAnnonce;
	
	//Constructor
	public Annonce(Administrateur aministrateur, int idAnnonce, String textAnnonce, int statutAnnonce) {
		Aministrateur = aministrateur;
		this.idAnnonce = idAnnonce;
		this.textAnnonce = textAnnonce;
		this.statutAnnonce = statutAnnonce;
	}

	//Getters & Setters
	public Administrateur getAministrateur() {
		return Aministrateur;
	}

	public void setAministrateur(Administrateur aministrateur) {
		Aministrateur = aministrateur;
	}

	public int getIdAnnonce() {
		return idAnnonce;
	}

	public void setIdAnnonce(int idAnnonce) {
		this.idAnnonce = idAnnonce;
	}

	public String getTextAnnonce() {
		return textAnnonce;
	}

	public void setTextAnnonce(String textAnnonce) {
		this.textAnnonce = textAnnonce;
	}

	public int getStatutAnnonce() {
		return statutAnnonce;
	}

	public void setStatutAnnonce(int statutAnnonce) {
		this.statutAnnonce = statutAnnonce;
	}
	
	//toString Function
	@Override
	public String toString() {
		return "Annonce [Aministrateur=" + Aministrateur + ", idAnnonce=" + idAnnonce + ", textAnnonce=" + textAnnonce
				+ ", statutAnnonce=" + statutAnnonce + "]";
	}
}