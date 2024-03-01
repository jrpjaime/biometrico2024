
package mx.gob.imss.biometricos.model;

import java.io.Serializable;

import java.lang.StringBuilder;

import javax.xml.bind.annotation.*;

import javax.persistence.*;

/**
 */

@Entity
@Table( name = "BIOT_USUARIO_ROLE")
 

public class BitUsuarioRole implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "CVE_ID_USUARIO_ROLE", nullable = false)
	@Basic(fetch = FetchType.EAGER)

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "inc_biot_usuario_role", sequenceName = "SEQ_BIOTUSUARIOROLE", allocationSize = 1)    
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inc_biot_usuario_role")	
	@XmlElement
	Long cveIdUsuarioRole;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "CVE_ID_ROLE", referencedColumnName = "CVE_ID_ROLE") })
	@XmlTransient
	BicRole bicRole;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "CVE_ID_USUARIO", referencedColumnName = "CVE_ID_USUARIO") })
	@XmlTransient
	BitUsuario bitUsuario;

	/**
	 */
	public void setCveIdUsuarioRole(Long cveIdUsuarioRole) {
		this.cveIdUsuarioRole = cveIdUsuarioRole;
	}

	/**
	 */
	public Long getCveIdUsuarioRole() {
		return this.cveIdUsuarioRole;
	}

	/**
	 */
	public void setBicRole(BicRole bicRole) {
		this.bicRole = bicRole;
	}

	/**
	 */
	public BicRole getBicRole() {
		return bicRole;
	}

	/**
	 */
	public void setBitUsuario(BitUsuario bitUsuario) {
		this.bitUsuario = bitUsuario;
	}

	/**
	 */
	public BitUsuario getBitUsuario() {
		return bitUsuario;
	}

	/**
	 */
	public BitUsuarioRole() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(BitUsuarioRole that) {
		setCveIdUsuarioRole(that.getCveIdUsuarioRole());
		setBicRole(that.getBicRole());
		setBitUsuario(that.getBitUsuario());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("cveIdUsuarioRole=[").append(cveIdUsuarioRole).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((cveIdUsuarioRole == null) ? 0 : cveIdUsuarioRole.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof BitUsuarioRole))
			return false;
		BitUsuarioRole equalCheck = (BitUsuarioRole) obj;
		if ((cveIdUsuarioRole == null && equalCheck.cveIdUsuarioRole != null) || (cveIdUsuarioRole != null && equalCheck.cveIdUsuarioRole == null))
			return false;
		if (cveIdUsuarioRole != null && !cveIdUsuarioRole.equals(equalCheck.cveIdUsuarioRole))
			return false;
		return true;
	}
}
