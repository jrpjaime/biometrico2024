
package mx.gob.imss.biometricos.model;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.util.Set;

import javax.xml.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

/**
 */

@Entity
@Table(name = "BIOC_ESTATUS_MEDIO_CONTACTO") 
public class BtcEstatusMedioContacto implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "cve_id_estatus_medio_contacto", nullable = false)
	@Basic(fetch = FetchType.EAGER)

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "inc_bioc_estatus_medio_contacto", sequenceName = "SEQ_BIOCESTATUSMEDIOCONTACTO", allocationSize = 1)    
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inc_bioc_estatus_medio_contacto")
	@XmlElement
	Long cveIdEstatusMedioContacto;
	/**
	 */

	@Column(name = "des_estatus_medio_contacto", length = 20)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String desEstatusMedioContacto;

	/**
	 */
	@OneToMany(mappedBy = "btcEstatusMedioContacto", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)

	@XmlElement(name = "", namespace = "")
	@JsonBackReference
	java.util.Set<BttMedioContacto> bttMedioContactos;

	/**
	 */
	public void setCveIdEstatusMedioContacto(Long cveIdEstatusMedioContacto) {
		this.cveIdEstatusMedioContacto = cveIdEstatusMedioContacto;
	}

	/**
	 */
	public Long getCveIdEstatusMedioContacto() {
		return this.cveIdEstatusMedioContacto;
	}

	/**
	 */
	public void setDesEstatusMedioContacto(String desEstatusMedioContacto) {
		this.desEstatusMedioContacto = desEstatusMedioContacto;
	}

	/**
	 */
	public String getDesEstatusMedioContacto() {
		return this.desEstatusMedioContacto;
	}

	/**
	 */
	public void setBttMedioContactos(Set<BttMedioContacto> bttMedioContactos) {
		this.bttMedioContactos = bttMedioContactos;
	}

	/**
	 */
	public Set<BttMedioContacto> getBttMedioContactos() {
		if (bttMedioContactos == null) {
			bttMedioContactos = new java.util.LinkedHashSet<BttMedioContacto>();
		}
		return bttMedioContactos;
	}

	/**
	 */
	public BtcEstatusMedioContacto() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(BtcEstatusMedioContacto that) {
		setCveIdEstatusMedioContacto(that.getCveIdEstatusMedioContacto());
		setDesEstatusMedioContacto(that.getDesEstatusMedioContacto());
		setBttMedioContactos(new java.util.LinkedHashSet<BttMedioContacto>(that.getBttMedioContactos()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("cveIdEstatusMedioContacto=[").append(cveIdEstatusMedioContacto).append("] ");
		buffer.append("desEstatusMedioContacto=[").append(desEstatusMedioContacto).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((cveIdEstatusMedioContacto == null) ? 0 : cveIdEstatusMedioContacto.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof BtcEstatusMedioContacto))
			return false;
		BtcEstatusMedioContacto equalCheck = (BtcEstatusMedioContacto) obj;
		if ((cveIdEstatusMedioContacto == null && equalCheck.cveIdEstatusMedioContacto != null) || (cveIdEstatusMedioContacto != null && equalCheck.cveIdEstatusMedioContacto == null))
			return false;
		if (cveIdEstatusMedioContacto != null && !cveIdEstatusMedioContacto.equals(equalCheck.cveIdEstatusMedioContacto))
			return false;
		return true;
	}
}
