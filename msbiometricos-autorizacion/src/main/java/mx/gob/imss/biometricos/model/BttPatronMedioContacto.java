
package mx.gob.imss.biometricos.model;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.util.Date;

import javax.xml.bind.annotation.*;

import javax.persistence.*;

/**
 */

@Entity
@Table(name = "BIOT_PATRON_MEDIO_CONTACTO")
public class BttPatronMedioContacto implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "cve_id_patron_medio_contacto", nullable = false)
	@Basic(fetch = FetchType.EAGER)

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "inc_biot_patron_medio_contacto", sequenceName = "SEQ_BIOTPATRONMEDIOCONTACTO", allocationSize = 1)    
 	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inc_biot_patron_medio_contacto")	
	@XmlElement
	Long cveIdPatronMedioContacto;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "fec_registro")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	Date fecRegistro;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "fec_baja")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	Date fecBaja;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "cve_id_patron", referencedColumnName = "CVE_ID_PATRON") })
	@XmlTransient
	BttPatron bttPatron;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "cve_id_medio_contacto", referencedColumnName = "cve_id_medio_contacto") })
	@XmlTransient
	BttMedioContacto bttMedioContacto;

	
	/**
	 */
	public void setCveIdPatronMedioContacto(Long cveIdPatronMedioContacto) {
		this.cveIdPatronMedioContacto = cveIdPatronMedioContacto;
	}

	/**
	 */
	public Long getCveIdPatronMedioContacto() {
		return this.cveIdPatronMedioContacto;
	}

	/**
	 */
	public void setFecRegistro(Date fecRegistro) {
		this.fecRegistro = fecRegistro;
	}

	/**
	 */
	public Date getFecRegistro() {
		return this.fecRegistro;
	}

	/**
	 */
	public void setFecBaja(Date fecBaja) {
		this.fecBaja = fecBaja;
	}

	/**
	 */
	public Date getFecBaja() {
		return this.fecBaja;
	}

	/**
	 */
	public void setBttPatron(BttPatron bttPatron) {
		this.bttPatron = bttPatron;
	}

	/**
	 */
	public BttPatron getBttPatron() {
		return bttPatron;
	}

	/**
	 */
	public void setBttMedioContacto(BttMedioContacto bttMedioContacto) {
		this.bttMedioContacto = bttMedioContacto;
	}

	/**
	 */
	public BttMedioContacto getBttMedioContacto() {
		return bttMedioContacto;
	}

	/**
	 */
	public BttPatronMedioContacto() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(BttPatronMedioContacto that) {
		setCveIdPatronMedioContacto(that.getCveIdPatronMedioContacto());
		setFecRegistro(that.getFecRegistro());
		setFecBaja(that.getFecBaja());
		setBttPatron(that.getBttPatron());
		setBttMedioContacto(that.getBttMedioContacto());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("cveIdPatronMedioContacto=[").append(cveIdPatronMedioContacto).append("] ");
		buffer.append("fecRegistro=[").append(fecRegistro).append("] ");
		buffer.append("fecBaja=[").append(fecBaja).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((cveIdPatronMedioContacto == null) ? 0 : cveIdPatronMedioContacto.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof BttPatronMedioContacto))
			return false;
		BttPatronMedioContacto equalCheck = (BttPatronMedioContacto) obj;
		if ((cveIdPatronMedioContacto == null && equalCheck.cveIdPatronMedioContacto != null) || (cveIdPatronMedioContacto != null && equalCheck.cveIdPatronMedioContacto == null))
			return false;
		if (cveIdPatronMedioContacto != null && !cveIdPatronMedioContacto.equals(equalCheck.cveIdPatronMedioContacto))
			return false;
		return true;
	}
}
