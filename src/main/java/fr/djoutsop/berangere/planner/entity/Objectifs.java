package fr.djoutsop.berangere.planner.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "objectifs")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Objectifs implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private java.lang.Integer id;

	@Column(name = "caQuotiden", nullable = false)
	private java.lang.Double caQuotiden;

	@Column(name = "caHebdomadaire", nullable = false)
	private java.lang.Double caHebdomadaire;

	@Column(name = "caMensuel", nullable = false)
	private java.lang.Double caMensuel;

	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.Integer getId() {
		return this.id;
	}

	public void setCaQuotiden(java.lang.Double caQuotiden) {
		this.caQuotiden = caQuotiden;
	}

	public java.lang.Double getCaQuotiden() {
		return this.caQuotiden;
	}

	public void setCaHebdomadaire(java.lang.Double caHebdomadaire) {
		this.caHebdomadaire = caHebdomadaire;
	}

	public java.lang.Double getCaHebdomadaire() {
		return this.caHebdomadaire;
	}

	public void setCaMensuel(java.lang.Double caMensuel) {
		this.caMensuel = caMensuel;
	}

	public java.lang.Double getCaMensuel() {
		return this.caMensuel;
	}

}
