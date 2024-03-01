
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
@Table(name = "BIOC_TIPO_MEDIO_CONTACTO") 
public class BtcTipoMedioContacto implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "cve_id_tipo_medio_contacto", nullable = false)
	@Basic(fetch = FetchType.EAGER)

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "inc_bioc_tipo_medio_contacto", sequenceName = "SEQ_BIOCTIPOMEDIOCONTACTO", allocationSize = 1)    
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inc_bioc_tipo_medio_contacto")
	@XmlElement
	Long cveIdTipoMedioContacto;
	/**
	 */

	@Column(name = "des_tipo_medio_contacto", length = 20)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String desTipoMedioContacto;

	/**
	 */
	@OneToMany(mappedBy = "btcTipoMedioContacto", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)

	@XmlElement(name = "", namespace = "")
	@JsonBackReference
	java.util.Set<BttMedioContacto> bttMedioContactos;

	/**
	 */
	public void setCveIdTipoMedioContacto(Long cveIdTipoMedioContacto) {
		this.cveIdTipoMedioContacto = cveIdTipoMedioContacto;
	}

	/**
	 */
	public Long getCveIdTipoMedioContacto() {
		return this.cveIdTipoMedioContacto;
	}

	/**
	 */
	public void setDesTipoMedioContacto(String desTipoMedioContacto) {
		this.desTipoMedioContacto = desTipoMedioContacto;
	}

	/**
	 */
	public String getDesTipoMedioContacto() {
		return this.desTipoMedioContacto;
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
	public BtcTipoMedioContacto() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(BtcTipoMedioContacto that) {
		setCveIdTipoMedioContacto(that.getCveIdTipoMedioContacto());
		setDesTipoMedioContacto(that.getDesTipoMedioContacto());
		setBttMedioContactos(new java.util.LinkedHashSet<BttMedioContacto>(that.getBttMedioContactos()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("cveIdTipoMedioContacto=[").append(cveIdTipoMedioContacto).append("] ");
		buffer.append("desTipoMedioContacto=[").append(desTipoMedioContacto).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((cveIdTipoMedioContacto == null) ? 0 : cveIdTipoMedioContacto.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof BtcTipoMedioContacto))
			return false;
		BtcTipoMedioContacto equalCheck = (BtcTipoMedioContacto) obj;
		if ((cveIdTipoMedioContacto == null && equalCheck.cveIdTipoMedioContacto != null) || (cveIdTipoMedioContacto != null && equalCheck.cveIdTipoMedioContacto == null))
			return false;
		if (cveIdTipoMedioContacto != null && !cveIdTipoMedioContacto.equals(equalCheck.cveIdTipoMedioContacto))
			return false;
		return true;
	}
}
