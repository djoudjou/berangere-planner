package fr.djoutsop.berangere.planner.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "prestation_rdv")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class PrestationRdv implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private java.lang.Integer id;

	@Column(name = "duree", nullable = false)
	private java.lang.Integer duree;

	@Column(name = "montant", nullable = false)
	private java.lang.Double montant;

	@ManyToOne
	@JoinColumn(name = "rendezvous_id_fk")
	private RendezVous rendezVous;

	@ManyToOne
	@JoinColumn(name = "prestation_id_fk")
	private Prestation prestation;

	public java.lang.Integer getId() {
		return id;
	}

	public void setId(java.lang.Integer id) {
		this.id = id;
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

	public Prestation getPrestation() {
		return prestation;
	}

	public void setPrestation(Prestation prestation) {
		this.prestation = prestation;
	}

	public RendezVous getRendezVous() {
		return rendezVous;
	}

	public void setRendezVous(RendezVous rendezVous) {
		this.rendezVous = rendezVous;
	}

}
