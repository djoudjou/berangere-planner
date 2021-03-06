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
@Table(name = "gerante")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Gerante implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private java.lang.Integer id;

	@Size(max = 200)
	@Column(name = "nom", length = 200, nullable = false)
	private java.lang.String nom;

	@Size(max = 200)
	@Column(name = "prenom", length = 200, nullable = false)
	private java.lang.String prenom;

	@ManyToOne(fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "objectifs_id_fk")
	private Objectifs objectifs;

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

	public void setPrenom(java.lang.String prenom) {
		this.prenom = prenom;
	}

	public java.lang.String getPrenom() {
		return this.prenom;
	}

	public void setObjectifs(Objectifs objectifs) {
		this.objectifs = objectifs;
	}

	public Objectifs getObjectifs() {
		return this.objectifs;
	}

}
