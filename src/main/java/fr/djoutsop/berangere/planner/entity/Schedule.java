package fr.djoutsop.berangere.planner.entity;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "schedule")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Schedule extends AbstractAuditingEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id = null;

	@Column(name = "start", nullable = false)
	private ZonedDateTime start = null;

	@Column(name = "end", nullable = false)
	private ZonedDateTime end = null;

	@ManyToOne(fetch = FetchType.EAGER, optional=false)
	@JoinColumn(name = "prestation_id_fk")
	private Prestation prestation = null;

	@ManyToOne(fetch = FetchType.EAGER, optional=false)
	@JoinColumn(name = "adresse_id_fk")
	private Adresse adresse = null;

	@ManyToOne(fetch = FetchType.EAGER, optional=false)
	@JoinColumn(name = "contact_id_fk")
	private Contact contact = null;

	public Schedule() {

	}

	public Schedule(ZonedDateTime start, Prestation prestation, Adresse adresse) {
		super();
		this.start = start;
		this.prestation = prestation;
		this.adresse = adresse;
		this.contact = adresse.getContact();
		this.end = start.plus(prestation.getDuration(), ChronoUnit.MINUTES);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ZonedDateTime getStart() {
		return start;
	}

	public void setStart(ZonedDateTime start) {
		this.start = start;
	}

	public ZonedDateTime getEnd() {
		return end;
	}

	public void setEnd(ZonedDateTime end) {
		this.end = end;
	}

	public Prestation getPrestation() {
		return prestation;
	}

	public void setPrestation(Prestation prestation) {
		this.prestation = prestation;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((contact == null) ? 0 : contact.hashCode());
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((prestation == null) ? 0 : prestation.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
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
		Schedule other = (Schedule) obj;
		if (adresse == null) {
			if (other.adresse != null) {
				return false;
			}
		} else if (!adresse.equals(other.adresse)) {
			return false;
		}
		if (contact == null) {
			if (other.contact != null) {
				return false;
			}
		} else if (!contact.equals(other.contact)) {
			return false;
		}
		if (end == null) {
			if (other.end != null) {
				return false;
			}
		} else if (!end.equals(other.end)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (prestation == null) {
			if (other.prestation != null) {
				return false;
			}
		} else if (!prestation.equals(other.prestation)) {
			return false;
		}
		if (start == null) {
			if (other.start != null) {
				return false;
			}
		} else if (!start.equals(other.start)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Schedule [id=");
		builder.append(id);
		builder.append(", start=");
		builder.append(start);
		builder.append(", end=");
		builder.append(end);
		builder.append(", prestation=");
		builder.append(prestation);
		builder.append(", adresse=");
		builder.append(adresse);
		builder.append(", contact=");
		builder.append(contact);
		builder.append("]");
		return builder.toString();
	}

}
