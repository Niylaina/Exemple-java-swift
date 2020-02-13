package model.entity;

public class MatiereEntite {
	private int id, hT, hP, enseignant;
	private String  intitule;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int gethT() {
		return hT;
	}
	public void sethT(int hT) {
		this.hT = hT;
	}
	public int gethP() {
		return hP;
	}
	public void sethP(int hP) {
		this.hP = hP;
	}
	public int getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(int enseignant) {
		this.enseignant = enseignant;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	
	
}

