package fr.djoutsop.berangere.planner.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "prestation")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Prestation implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private java.lang.Integer id;

	@Size(max = 200)
	@Column(name = "nom", length = 200, nullable = true)
	private java.lang.String nom;

	@Column(name = "duree", nullable = false)
	private java.lang.Integer duree;

	@Column(name = "montant", nullable = false)
	private java.lang.Double montant;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "gerante_id_fk")
	private Gerante gerante;

	public java.lang.Integer getId() {
		return id;
	}

	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.String getNom() {
		return nom;
	}

	public void setNom(java.lang.String nom) {
		this.nom = nom;
	}

	public java.lang.Integer getDuree() {
		return duree;
	}

	public void setDuree(java.lang.Integer duree) {
		this.duree = duree;
	}

	public java.lang.Double getMontant() {
		return montant;
	}

	public void setMontant(java.lang.Double montant) {
		this.montant = montant;
	}

	public Gerante getGerante() {
		return gerante;
	}

	public void setGerante(Gerante gerante) {
		this.gerante = gerante;
	}

}
