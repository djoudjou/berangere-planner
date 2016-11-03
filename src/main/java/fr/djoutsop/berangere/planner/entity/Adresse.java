package fr.djoutsop.berangere.planner.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "adresse")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Adresse implements Serializable {
	public Adresse() {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Size(max = 10)
	@Column(name = "code_postal", length = 10, nullable = false)
	private String codePostal;
	
	@Size(max = 200)
	@Column(name = "ville", length = 200, nullable = false)
	private String ville;

	@Size(max = 200)
	@Column(name = "rue", length = 200, nullable = false)
	private String rue;

	@Size(max = 10)
	@Column(name = "numero_rue", length = 10, nullable = false)
	private String numeroRue;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getNumeroRue() {
		return numeroRue;
	}

	public void setNumeroRue(String numeroRue) {
		this.numeroRue = numeroRue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codePostal == null) ? 0 : codePostal.hashCode());
		result = prime * result + ((numeroRue == null) ? 0 : numeroRue.hashCode());
		result = prime * result + ((rue == null) ? 0 : rue.hashCode());
		result = prime * result + ((ville == null) ? 0 : ville.hashCode());
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
		Adresse other = (Adresse) obj;
		if (codePostal == null) {
			if (other.codePostal != null) {
				return false;
			}
		} else if (!codePostal.equals(other.codePostal)) {
			return false;
		}
		if (numeroRue == null) {
			if (other.numeroRue != null) {
				return false;
			}
		} else if (!numeroRue.equals(other.numeroRue)) {
			return false;
		}
		if (rue == null) {
			if (other.rue != null) {
				return false;
			}
		} else if (!rue.equals(other.rue)) {
			return false;
		}
		if (ville == null) {
			if (other.ville != null) {
				return false;
			}
		} else if (!ville.equals(other.ville)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Adresse [id=");
		builder.append(id);
		builder.append(", codePostal=");
		builder.append(codePostal);
		builder.append(", ville=");
		builder.append(ville);
		builder.append(", rue=");
		builder.append(rue);
		builder.append(", numeroRue=");
		builder.append(numeroRue);
		builder.append("]");
		return builder.toString();
	}

	public Adresse(String numeroRue, String rue, String codePostal, String ville) {
		super();
		this.numeroRue = numeroRue;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

}
