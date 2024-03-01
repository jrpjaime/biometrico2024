
package mx.gob.imss.biometricos.model;

import java.io.Serializable;

import java.lang.StringBuilder;


import java.util.List;

import javax.xml.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

/**
*
* @author dev-IMSS
*/

@Entity
@Table(name = "BIOT_PATRON")
public class BttPatron implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "CVE_ID_PATRON", nullable = false)
	@Basic(fetch = FetchType.EAGER)

	@Id
    @SequenceGenerator(name = "inc_biot_patron", sequenceName = "SEQ_BIOTPATRON", allocationSize = 1)    
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inc_biot_patron")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlElement
	Long cveIdPatron;
	/**
	 */

	@Column(name = "REGISTRO_PATRONAL", length = 250)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String registroPatronal;
	/**
	 */

	@Column(name = "DES_NOMBRE_RAZON_SOCIAL", length = 250)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String desNombreRazonSocial;
	/**
	 */

	@Column(name = "DES_RFC", length = 15)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String desRfc;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "CVE_ID_TIPO_PATRON", referencedColumnName = "CVE_ID_TIPO_PATRON") })
	@XmlTransient
	BtcTipoPatron btcTipoPatron;
	
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "CVE_ID_USUARIO", referencedColumnName = "CVE_ID_USUARIO") })
	@XmlTransient
	BitUsuario bitUsuario;
	

	
	/**
	 */
	@OneToMany(mappedBy = "bttPatron", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)

	@XmlElement(name = "", namespace = "")
	@JsonBackReference
	java.util.List<BttPatronMedioContacto> bttPatronMedioContactos;

	@Transient
	Integer countEmailValidados;

    @Transient
    Integer countCelularesValidados;
	
	public BitUsuario getBitUsuario() {
		return bitUsuario;
	}

	public void setBitUsuario(BitUsuario bitUsuario) {
		this.bitUsuario = bitUsuario;
	}

	public java.util.List<BttPatronMedioContacto> getBttPatronMedioContactos() {
		return bttPatronMedioContactos;
	}

	public void setBttPatronMedioContactos(java.util.List<BttPatronMedioContacto> bttPatronMedioContactos) {
		this.bttPatronMedioContactos = bttPatronMedioContactos;
	}

	/**
	 */
	public void setCveIdPatron(Long cveIdPatron) {
		this.cveIdPatron = cveIdPatron;
	}

	/**
	 */
	public Long getCveIdPatron() {
		return this.cveIdPatron;
	}

	/**
	 */
	public void setRegistroPatronal(String registroPatronal) {
		this.registroPatronal = registroPatronal;
	}

	/**
	 */
	public String getRegistroPatronal() {
		return this.registroPatronal;
	}

	/**
	 */
	public void setDesNombreRazonSocial(String desNombreRazonSocial) {
		this.desNombreRazonSocial = desNombreRazonSocial;
	}

	/**
	 */
	public String getDesNombreRazonSocial() {
		return this.desNombreRazonSocial;
	}

	/**
	 */
	public void setDesRfc(String desRfc) {
		this.desRfc = desRfc;
	}

	/**
	 */
	public String getDesRfc() {
		return this.desRfc;
	}

	/**
	 */
	public void setBtcTipoPatron(BtcTipoPatron btcTipoPatron) {
		this.btcTipoPatron = btcTipoPatron;
	}

	/**
	 */
	public BtcTipoPatron getBtcTipoPatron() {
		return btcTipoPatron;
	}
 

 

	/**
	 */
	public BttPatron() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(BttPatron that) {
		setCveIdPatron(that.getCveIdPatron());
		setRegistroPatronal(that.getRegistroPatronal());
		setDesNombreRazonSocial(that.getDesNombreRazonSocial());
		setDesRfc(that.getDesRfc());
		setBtcTipoPatron(that.getBtcTipoPatron()); 
		
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("cveIdPatron=[").append(cveIdPatron).append("] ");
		buffer.append("registroPatronal=[").append(registroPatronal).append("] ");
		buffer.append("desNombreRazonSocial=[").append(desNombreRazonSocial).append("] ");
		buffer.append("desRfc=[").append(desRfc).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((cveIdPatron == null) ? 0 : cveIdPatron.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof BttPatron))
			return false;
		BttPatron equalCheck = (BttPatron) obj;
		if ((cveIdPatron == null && equalCheck.cveIdPatron != null) || (cveIdPatron != null && equalCheck.cveIdPatron == null))
			return false;
		if (cveIdPatron != null && !cveIdPatron.equals(equalCheck.cveIdPatron))
			return false;
		return true;
	}

    public Integer getCountEmailValidados() {
	    return countEmailValidados;
    }

    public void setCountEmailValidados(Integer countEmailValidados) {
        this.countEmailValidados = countEmailValidados;
    }

    public Integer getCountCelularesValidados() {
        return countCelularesValidados;
    }

    public void setCountCelularesValidados(Integer countCelularesValidados) {
        this.countCelularesValidados = countCelularesValidados;
    }
}
