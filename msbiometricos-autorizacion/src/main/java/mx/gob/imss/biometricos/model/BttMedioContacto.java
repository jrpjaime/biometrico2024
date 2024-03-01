
package mx.gob.imss.biometricos.model;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.util.Date;
import java.util.Set;

import javax.xml.bind.annotation.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

/**
 */

@Entity 
@Table(name = "BIOT_MEDIO_CONTACTO") 
public class BttMedioContacto implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "cve_id_medio_contacto", nullable = false)
	@Basic(fetch = FetchType.EAGER)

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "inc_biot_medio_contacto", sequenceName = "SEQ_BIOTMEDIOCONTACTO", allocationSize = 1)    
 	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inc_biot_medio_contacto")
	@XmlElement
	Long cveIdMedioContacto;
	/**
	 */

	@Column(name = "des_folio" )
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String desFolio;
	

	@Column(name = "des_folio_validacion" )
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String desFolioValidacion;
	
	@Column(name = "des_folio_baja" )
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String desFolioBaja;
	
	@Column(name = "des_codigo_verificacion" )
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String desCodigoVerificacion;
	
	
	
	@Transient
    Integer countEmailValidadosRfc;
	@Transient
    Integer countCelularesValidadosRfc;
	
	
	@Transient
    Integer countEmailRegistradosRfc;
	@Transient
    Integer countCelularesRegistradosRfc;
	
	
	@Transient
	String mensaje;
	
	 
	
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat (pattern="dd/MM/yyyy HH:mm")
	@Column(name = "fec_registro")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	Date fecRegistro;
	/**
	 */

	@Column(name = "des_correo_electronico" )
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String desCorreoElectronico;
	/**
	 */

	@Column(name = "des_telefono" )
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String desTelefono;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat (pattern="dd/MM/yyyy HH:mm")
	@Column(name = "fec_confirmacion")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	Date fecConfirmacion;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat (pattern="dd/MM/yyyy HH:mm")
	@Column(name = "fec_baja")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	Date fecBaja;
	/**
	 */

	@Column(name = "des_aclaracion" )
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String desAclaracion;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "fec_solicitud_aclaracion")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	Date fecSolicitudAclaracion;
	/**
	 */

	@Column(name = "cve_id_usuario")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	Long cveIdUsuario;
	
 

	@Column(name = "DES_PATH_ACUSE_REGISTRO" )
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String desPathAcuseRegistro;
	
	@Column(name = "DES_PATH_ACUSE_VALIDACION" )
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String desPathAcuseValidacion;
	
	
	@Column(name = "DES_PATH_ACUSE_BAJA" )
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String desPathAcuseBaja;
	
	
	

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "cve_id_tipo_medio_contacto", referencedColumnName = "cve_id_tipo_medio_contacto") })
	@XmlTransient
	@JsonBackReference
	BtcTipoMedioContacto btcTipoMedioContacto;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "cve_id_estatus_medio_contacto", referencedColumnName = "cve_id_estatus_medio_contacto") })
	@XmlTransient
	@JsonBackReference
	BtcEstatusMedioContacto btcEstatusMedioContacto;
 
	
	/**
	 */
	@OneToMany(mappedBy = "bttMedioContacto", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)

	@XmlElement(name = "", namespace = "")
	@JsonBackReference
	java.util.List<BttPatronMedioContacto> bttPatronMedioContactos;
	
	
	
	
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getDesFolioBaja() {
		return desFolioBaja;
	}

	public void setDesFolioBaja(String desFolioBaja) {
		this.desFolioBaja = desFolioBaja;
	}

	public String getDesPathAcuseBaja() {
		return desPathAcuseBaja;
	}

	public void setDesPathAcuseBaja(String desPathAcuseBaja) {
		this.desPathAcuseBaja = desPathAcuseBaja;
	}

	public Integer getCountEmailRegistradosRfc() {
		return countEmailRegistradosRfc;
	}

	public void setCountEmailRegistradosRfc(Integer countEmailRegistradosRfc) {
		this.countEmailRegistradosRfc = countEmailRegistradosRfc;
	}

	public Integer getCountCelularesRegistradosRfc() {
		return countCelularesRegistradosRfc;
	}

	public void setCountCelularesRegistradosRfc(Integer countCelularesRegistradosRfc) {
		this.countCelularesRegistradosRfc = countCelularesRegistradosRfc;
	}

	public Integer getCountEmailValidadosRfc() {
		return countEmailValidadosRfc;
	}

	public void setCountEmailValidadosRfc(Integer countEmailValidadosRfc) {
		this.countEmailValidadosRfc = countEmailValidadosRfc;
	}

	public Integer getCountCelularesValidadosRfc() {
		return countCelularesValidadosRfc;
	}

	public void setCountCelularesValidadosRfc(Integer countCelularesValidadosRfc) {
		this.countCelularesValidadosRfc = countCelularesValidadosRfc;
	}

	public String getDesCodigoVerificacion() {
		return desCodigoVerificacion;
	}

	public void setDesCodigoVerificacion(String desCodigoVerificacion) {
		this.desCodigoVerificacion = desCodigoVerificacion;
	}

	public String getDesPathAcuseRegistro() {
		return desPathAcuseRegistro;
	}

	public void setDesPathAcuseRegistro(String desPathAcuseRegistro) {
		this.desPathAcuseRegistro = desPathAcuseRegistro;
	}

	public String getDesPathAcuseValidacion() {
		return desPathAcuseValidacion;
	}

	public void setDesPathAcuseValidacion(String desPathAcuseValidacion) {
		this.desPathAcuseValidacion = desPathAcuseValidacion;
	}

	public String getDesFolioValidacion() {
		return desFolioValidacion;
	}

	public void setDesFolioValidacion(String desFolioValidacion) {
		this.desFolioValidacion = desFolioValidacion;
	}

	public java.util.List<BttPatronMedioContacto> getBttPatronMedioContactos() {
		return bttPatronMedioContactos;
	}

	public void setBttPatronMedioContactos(java.util.List<BttPatronMedioContacto> bttPatronMedioContactos) {
		this.bttPatronMedioContactos = bttPatronMedioContactos;
	}

 

	/**
	 */
	public void setCveIdMedioContacto(Long cveIdMedioContacto) {
		this.cveIdMedioContacto = cveIdMedioContacto;
	}

	/**
	 */
	public Long getCveIdMedioContacto() {
		return this.cveIdMedioContacto;
	}

	/**
	 */
	public void setDesFolio(String desFolio) {
		this.desFolio = desFolio;
	}

	/**
	 */
	public String getDesFolio() {
		return this.desFolio;
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
	public void setDesCorreoElectronico(String desCorreoElectronico) {
		this.desCorreoElectronico = desCorreoElectronico;
	}

	/**
	 */
	public String getDesCorreoElectronico() {
		return this.desCorreoElectronico;
	}

	/**
	 */
	public void setDesTelefono(String desTelefono) {
		this.desTelefono = desTelefono;
	}

	/**
	 */
	public String getDesTelefono() {
		return this.desTelefono;
	}

	/**
	 */
	public void setFecConfirmacion(Date fecConfirmacion) {
		this.fecConfirmacion = fecConfirmacion;
	}

	/**
	 */
	public Date getFecConfirmacion() {
		return this.fecConfirmacion;
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
	public void setDesAclaracion(String desAclaracion) {
		this.desAclaracion = desAclaracion;
	}

	/**
	 */
	public String getDesAclaracion() {
		return this.desAclaracion;
	}

	/**
	 */
	public void setFecSolicitudAclaracion(Date fecSolicitudAclaracion) {
		this.fecSolicitudAclaracion = fecSolicitudAclaracion;
	}

	/**
	 */
	public Date getFecSolicitudAclaracion() {
		return this.fecSolicitudAclaracion;
	}

	/**
	 */
	public void setCveIdUsuario(Long cveIdUsuario) {
		this.cveIdUsuario = cveIdUsuario;
	}

	/**
	 */
	public Long getCveIdUsuario() {
		return this.cveIdUsuario;
	}

	/**
	 */
	public void setBtcTipoMedioContacto(BtcTipoMedioContacto btcTipoMedioContacto) {
		this.btcTipoMedioContacto = btcTipoMedioContacto;
	}

	/**
	 */
	public BtcTipoMedioContacto getBtcTipoMedioContacto() {
		return btcTipoMedioContacto;
	}

	/**
	 */
	public void setBtcEstatusMedioContacto(BtcEstatusMedioContacto btcEstatusMedioContacto) {
		this.btcEstatusMedioContacto = btcEstatusMedioContacto;
	}

	/**
	 */
	public BtcEstatusMedioContacto getBtcEstatusMedioContacto() {
		return btcEstatusMedioContacto;
	}

 
 

	/**
	 */
	public BttMedioContacto() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(BttMedioContacto that) {
		setCveIdMedioContacto(that.getCveIdMedioContacto());
		setDesFolio(that.getDesFolio());
		setFecRegistro(that.getFecRegistro());
		setDesCorreoElectronico(that.getDesCorreoElectronico());
		setDesTelefono(that.getDesTelefono());
		setFecConfirmacion(that.getFecConfirmacion());
		setFecBaja(that.getFecBaja());
		setDesAclaracion(that.getDesAclaracion());
		setFecSolicitudAclaracion(that.getFecSolicitudAclaracion());
		setCveIdUsuario(that.getCveIdUsuario());
		setBtcTipoMedioContacto(that.getBtcTipoMedioContacto());
		setBtcEstatusMedioContacto(that.getBtcEstatusMedioContacto()); 
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("cveIdMedioContacto=[").append(cveIdMedioContacto).append("] ");
		buffer.append("desFolio=[").append(desFolio).append("] ");
		buffer.append("fecRegistro=[").append(fecRegistro).append("] ");
		buffer.append("desCorreoElectronico=[").append(desCorreoElectronico).append("] ");
		buffer.append("desTelefono=[").append(desTelefono).append("] ");
		buffer.append("fecConfirmacion=[").append(fecConfirmacion).append("] ");
		buffer.append("fecBaja=[").append(fecBaja).append("] ");
		buffer.append("desAclaracion=[").append(desAclaracion).append("] ");
		buffer.append("fecSolicitudAclaracion=[").append(fecSolicitudAclaracion).append("] ");
		buffer.append("cveIdUsuario=[").append(cveIdUsuario).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((cveIdMedioContacto == null) ? 0 : cveIdMedioContacto.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof BttMedioContacto))
			return false;
		BttMedioContacto equalCheck = (BttMedioContacto) obj;
		if ((cveIdMedioContacto == null && equalCheck.cveIdMedioContacto != null) || (cveIdMedioContacto != null && equalCheck.cveIdMedioContacto == null))
			return false;
		if (cveIdMedioContacto != null && !cveIdMedioContacto.equals(equalCheck.cveIdMedioContacto))
			return false;
		return true;
	}
}
