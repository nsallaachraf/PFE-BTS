package Models;
public class Classe {

	private String Filliere;
	private String Id_Classe;
	
	public Classe(String filliere, String id_Classe) {
		Filliere = filliere;
		Id_Classe = id_Classe;
	}
	
	public String getFilliere() {
		return Filliere;
	}
	public void setFilliere(String filliere) {
		Filliere = filliere;
	}
	public String getId_Classe() {
		return Id_Classe;
	}
	public void setId_Classe(String id_Classe) {
		Id_Classe = id_Classe;
	}
	
	
}