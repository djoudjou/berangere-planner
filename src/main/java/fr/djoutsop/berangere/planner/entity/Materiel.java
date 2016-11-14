package fr.djoutsop.berangere.planner.entity;

public class Materiel implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	private java.lang.String nom;

	private java.lang.Integer quantite;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setNom(java.lang.String nom) {
		this.nom = nom;
	}

	public java.lang.String getNom() {
		return this.nom;
	}

	public void setQuantite(java.lang.Integer quantite) {
		this.quantite = quantite;
	}

	public java.lang.Integer getQuantite() {
		return this.quantite;
	}

}
