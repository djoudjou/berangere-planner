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
@Table(name = "materiel")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Materiel implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private java.lang.Integer id;

	@Size(max = 200)
	@Column(name = "nom", length = 200, nullable = false)
	private java.lang.String nom;

	@Column(name = "quantite", nullable = false)
	private java.lang.Integer quantite;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "gerante_id_fk")
	private Gerante gerante;

	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.Integer getId() {
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

	public void setGerante(Gerante gerante) {
		this.gerante = gerante;
	}

	public Gerante getGerante() {
		return this.gerante;
	}

}
