package fr.djoutsop.berangere.planner.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "rendezvous")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class RendezVous implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
    @Id
	@Temporal(TemporalType.DATE)
	@Column(name = "date")
	private Date date;

	@Size(max = 200)
	@Column(name = "note", length = 200, nullable = true)
	private String note;

	@Column(name = "duree", nullable = false)
	private long duree;
	
	@Column(name = "montant", nullable = false)
	private long montant;
	
	@ManyToOne(fetch = FetchType.EAGER, optional=false)
	@JoinColumn(name = "cliente_id_fk")
	private Cliente cliente = null;
	
	@ManyToOne(fetch = FetchType.EAGER, optional=false)
	@JoinColumn(name = "adresse_id_fk")
	private Adresse adresse = null;
	
	@ManyToOne(fetch = FetchType.EAGER, optional=false)
	@JoinColumn(name = "prestation_id_fk")
	private Prestation prestation = null;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fin")
	private Date fin;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public long getDuree() {
		return duree;
	}

	public void setDuree(long duree) {
		this.duree = duree;
	}

	public long getMontant() {
		return montant;
	}

	public void setMontant(long montant) {
		this.montant = montant;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Prestation getPrestation() {
		return prestation;
	}

	public void setPrestation(Prestation prestation) {
		this.prestation = prestation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		RendezVous other = (RendezVous) obj;
		if (date == null) {
			if (other.date != null) {
				return false;
			}
		} else if (!date.equals(other.date)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RendezVous [date=");
		builder.append(date);
		builder.append(", note=");
		builder.append(note);
		builder.append(", duree=");
		builder.append(duree);
		builder.append(", montant=");
		builder.append(montant);
		builder.append(", cliente=");
		builder.append(cliente);
		builder.append(", adresse=");
		builder.append(adresse);
		builder.append(", prestation=");
		builder.append(prestation);
		builder.append("]");
		return builder.toString();
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}
	
	

}
