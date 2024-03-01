
package mx.gob.imss.biometricos.model;

import java.io.Serializable;

import java.lang.StringBuilder;


import java.util.List;

import javax.persistence.Id;



import javax.xml.bind.annotation.*;

import javax.persistence.*;

/**
*
* @author dev-IMSS
*/

@Entity
@Table(name = "BIOC_TIPO_PATRON")
public class BtcTipoPatron implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "CVE_ID_TIPO_PATRON", nullable = false)
	@Basic(fetch = FetchType.EAGER)

	@Id
    @SequenceGenerator(name = "inc_bioc_tipo_patron", sequenceName = "SEQ_BIOCTIPOPATRON", allocationSize = 1)    
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inc_bioc_tipo_patron")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlElement
	Long cveIdTipoPatron;
	/**
	 */

	@Column(name = "DES_TIPO_PATRON", length = 250)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String desTipoPatron;

	/**
	 */
	@OneToMany(mappedBy = "btcTipoPatron", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)

	@XmlElement(name = "", namespace = "")
	java.util.List<BttPatron> bttPatrons;
 

	/**
	 */
	public void setCveIdTipoPatron(Long cveIdTipoPatron) {
		this.cveIdTipoPatron = cveIdTipoPatron;
	}

	/**
	 */
	public Long getCveIdTipoPatron() {
		return this.cveIdTipoPatron;
	}

	/**
	 */
	public void setDesTipoPatron(String desTipoPatron) {
		this.desTipoPatron = desTipoPatron;
	}

	/**
	 */
	public String getDesTipoPatron() {
		return this.desTipoPatron;
	}

	/**
	 */
	public void setBttPatrons(List<BttPatron> bttPatrons) {
		this.bttPatrons = bttPatrons;
	}

	/**
	 */
	public List<BttPatron> getBttPatrons() {
		if (bttPatrons == null) {
			bttPatrons = new java.util.LinkedList<BttPatron>();
		}
		return bttPatrons;
	}

 
 

	/**
	 */
	public BtcTipoPatron() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(BtcTipoPatron that) {
		setCveIdTipoPatron(that.getCveIdTipoPatron());
		setDesTipoPatron(that.getDesTipoPatron());
		setBttPatrons(new java.util.LinkedList<BttPatron>(that.getBttPatrons())); 
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("cveIdTipoPatron=[").append(cveIdTipoPatron).append("] ");
		buffer.append("desTipoPatron=[").append(desTipoPatron).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((cveIdTipoPatron == null) ? 0 : cveIdTipoPatron.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof BtcTipoPatron))
			return false;
		BtcTipoPatron equalCheck = (BtcTipoPatron) obj;
		if ((cveIdTipoPatron == null && equalCheck.cveIdTipoPatron != null) || (cveIdTipoPatron != null && equalCheck.cveIdTipoPatron == null))
			return false;
		if (cveIdTipoPatron != null && !cveIdTipoPatron.equals(equalCheck.cveIdTipoPatron))
			return false;
		return true;
	}
}
