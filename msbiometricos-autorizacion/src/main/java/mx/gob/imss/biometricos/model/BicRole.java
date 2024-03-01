
package mx.gob.imss.biometricos.model;

import java.io.Serializable;

import java.lang.StringBuilder;


import java.util.List;

import javax.xml.bind.annotation.*;

import javax.persistence.*;

/**
 */

@Entity
@Table( name = "BIOC_ROLE")

public class BicRole implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "CVE_ID_ROLE", nullable = false)
	@Basic(fetch = FetchType.EAGER)

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "inc_bioc_role", sequenceName = "SEQ_BIOCROLE", allocationSize = 1)    
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inc_bioc_role")
	@XmlElement
	Long cveIdRole;
	/**
	 */

	@Column(name = "DES_ROLE")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String desRole;

	/**
	 */
	@OneToMany(mappedBy = "bicRole", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)

	@XmlElement(name = "", namespace = "")
	java.util.List<BitUsuarioRole> bitUsuarioRoles;

	/**
	 */
	public void setCveIdRole(Long cveIdRole) {
		this.cveIdRole = cveIdRole;
	}

	/**
	 */
	public Long getCveIdRole() {
		return this.cveIdRole;
	}

	/**
	 */
	public void setDesRole(String desRole) {
		this.desRole = desRole;
	}

	/**
	 */
	public String getDesRole() {
		return this.desRole;
	}

	/**
	 */
	public void setBitUsuarioRoles(List<BitUsuarioRole> bitUsuarioRoles) {
		this.bitUsuarioRoles = bitUsuarioRoles;
	}

	/**
	 */
	public List<BitUsuarioRole> getBitUsuarioRoles() {
		if (bitUsuarioRoles == null) {
			bitUsuarioRoles = new java.util.LinkedList<BitUsuarioRole>();
		}
		return bitUsuarioRoles;
	}

	/**
	 */
	public BicRole() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(BicRole that) {
		setCveIdRole(that.getCveIdRole());
		setDesRole(that.getDesRole());
		setBitUsuarioRoles(new java.util.LinkedList<BitUsuarioRole>(that.getBitUsuarioRoles()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("cveIdRole=[").append(cveIdRole).append("] ");
		buffer.append("desRole=[").append(desRole).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((cveIdRole == null) ? 0 : cveIdRole.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof BicRole))
			return false;
		BicRole equalCheck = (BicRole) obj;
		if ((cveIdRole == null && equalCheck.cveIdRole != null) || (cveIdRole != null && equalCheck.cveIdRole == null))
			return false;
		if (cveIdRole != null && !cveIdRole.equals(equalCheck.cveIdRole))
			return false;
		return true;
	}
}
