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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "cliente")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Cliente implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private java.lang.Integer id;

	@Size(max = 200)
	@Column(name = "nom", length = 200, nullable = true)
	private java.lang.String nom;

	@Size(max = 200)
	@Column(name = "prenom", length = 200, nullable = true)
	private java.lang.String prenom;

	@Temporal(TemporalType.DATE)
	@Column(name = "dateNaissance")
	private java.util.Date dateNaissance;

	@Size(max = 200)
	@Column(name = "email", length = 200, nullable = true)
	private java.lang.String email;

	@Size(max = 200)
	@Column(name = "telephone", length = 200, nullable = true)
	private java.lang.String telephone;

	@Column(name = "contactEmail")
	private boolean contactEmail;

	@Column(name = "contactSms")
	private boolean contactSms;

	@ManyToOne(fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "adresse_id_fk")
	private Adresse adresse;

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

	public void setDateNaissance(java.util.Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public java.util.Date getDateNaissance() {
		return this.dateNaissance;
	}

	public void setEmail(java.lang.String email) {
		this.email = email;
	}

	public java.lang.String getEmail() {
		return this.email;
	}

	public void setTelephone(java.lang.String telephone) {
		this.telephone = telephone;
	}

	public java.lang.String getTelephone() {
		return this.telephone;
	}

	public void setContactEmail(java.lang.Boolean contactEmail) {
		this.contactEmail = contactEmail;
	}

	public java.lang.Boolean getContactEmail() {
		return this.contactEmail;
	}

	public void setContactSms(java.lang.Boolean contactSms) {
		this.contactSms = contactSms;
	}

	public java.lang.Boolean getContactSms() {
		return this.contactSms;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Adresse getAdresse() {
		return this.adresse;
	}

	public void setGerante(Gerante gerante) {
		this.gerante = gerante;
	}

	public Gerante getGerante() {
		return this.gerante;
	}

}
