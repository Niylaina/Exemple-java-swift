package model.entity;

public class EnseignantEntite {
	private String nom, prenom, adresse;
	private int id, matricule;
	
	public String getNom() {
		return this.nom;
	}
	
	public String getPrenom() {
		return this.prenom;
	}
	
	public String getAdresse() {
		return this.adresse;
	}
	
	public int getId() {
		return this.id;
	}
	
	public int getMatricule() {
		return this.matricule;
	}
	
	public void setNom(String s) {
		this.nom = s;
	}
	
	public void setPrenom(String s) {
		this.prenom = s;
	}
	
	public void setAdresse(String s) {
		this.adresse = s;
	}
	
	public void setId(int n) {
		this.id = n;
	}
	
	public void setMatricule(int n) {
		this.matricule = n;
	}
}
