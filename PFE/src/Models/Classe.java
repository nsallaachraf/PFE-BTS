package Models;
public class Classe {

	//Attributes
	private int idClasse;
	private String nomClasse;
	private String anneeClasse;
	
	//Constructor
	public Classe(int idClasse, String nomClasse, String anneeClasse) {
		super();
		this.idClasse = idClasse;
		this.nomClasse = nomClasse;
		this.anneeClasse = anneeClasse;
	}
	
	//Getter & Setters
	public String getAnneeClasse() {
		return anneeClasse;
	}

	public void setAnneeClasse(String anneeClasse) {
		this.anneeClasse = anneeClasse;
	}

	public int getIdClasse() {
		return idClasse;
	}

	public void setIdClasse(int idClasse) {
		this.idClasse = idClasse;
	}

	public String getNomClasse() {
		return nomClasse;
	}

	public void setNomClasse(String nomClasse) {
		this.nomClasse = nomClasse;
	}

	//toString Function
	@Override
	public String toString() {
		return "Classe [idClasse=" + idClasse + ", nomClasse=" + nomClasse + "]";
	}
}