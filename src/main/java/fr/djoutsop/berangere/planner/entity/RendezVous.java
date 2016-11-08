package fr.djoutsop.berangere.planner.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "rendez_vous")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class RendezVous implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private java.lang.Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name = "date")
	private Date date;

	@Column(name = "realise")
	private boolean realise;

	@Size(max = 200)
	@Column(name = "commentaires", length = 200, nullable = true)
	private java.lang.String commentaires;

	@OneToMany(mappedBy = "rendezVous", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<RappelRdvMail> rappelsMail = new ArrayList<>();

	@OneToMany(mappedBy = "rendezVous", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<RappelRdvSms> rappelsSms = new ArrayList<>();

	@OneToMany(mappedBy = "rendezVous", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PrestationRdv> prestationRdvs = new ArrayList<>();

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "gerante_id_fk")
	private Gerante gerante;

	public java.lang.Integer getId() {
		return id;
	}

	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isRealise() {
		return realise;
	}

	public void setRealise(boolean realise) {
		this.realise = realise;
	}

	public java.lang.String getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(java.lang.String commentaires) {
		this.commentaires = commentaires;
	}

	public List<RappelRdvMail> getRappelsMail() {
		return rappelsMail;
	}

	public void setRappelsMail(List<RappelRdvMail> rappelsMail) {
		this.rappelsMail = rappelsMail;
	}

	public List<RappelRdvSms> getRappelsSms() {
		return rappelsSms;
	}

	public void setRappelsSms(List<RappelRdvSms> rappelsSms) {
		this.rappelsSms = rappelsSms;
	}

	public Gerante getGerante() {
		return gerante;
	}

	public void setGerante(Gerante gerante) {
		this.gerante = gerante;
	}

	public List<PrestationRdv> getPrestationRdvs() {
		return prestationRdvs;
	}

	public void setPrestationRdvs(List<PrestationRdv> prestationRdvs) {
		this.prestationRdvs = prestationRdvs;
	}

}
