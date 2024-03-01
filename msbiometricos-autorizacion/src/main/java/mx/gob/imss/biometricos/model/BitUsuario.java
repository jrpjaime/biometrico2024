
package mx.gob.imss.biometricos.model;

import java.io.Serializable;

import java.lang.StringBuilder;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

/**
 */

@Entity
@Table( name = "BIOT_USUARIO")

public class BitUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "CVE_ID_USUARIO", nullable = false)
	@Basic(fetch = FetchType.EAGER)

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "inc_biot_usuario", sequenceName = "SEQ_BIOTUSUARIO", allocationSize = 1)    
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inc_biot_usuario")	
	@XmlElement
	Long cveIdUsuario;
	/**
	 */

	@Column(name = "DES_PASSWORD")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String desPassword;
	/**
	 */

	@Column(name = "DES_CIC")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String desCic;
	
	@Column(name = "DES_TIPO_CREDENCIAL")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String desTipoCredencial;
	
	
	@Column(name = "DES_SUBTIPO_CREDENCIAL")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String desSubtipoCredencial;
	
	
	@Column(name = "DES_SEXO_CREDENCIAL")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String desSexoCredencial;
	
	@Column(name = "FOTO_CREDENCIAL_REVERSO")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String fotoCredencialReverso;
	
	
 
	
	
	
	
	@Column(name = "DES_CURP_CREDENCIAL")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String desCurpCredencial;
	
	
	
	
	@Column(name = "DES_CLAVE_ELECTOR")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String desClaveElector;
	
	@Column(name = "DES_NUMERO_EMISION")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String desNumeroEmision;
	
	@Column(name = "DES_REGISTRO_CREDENCIAL")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String desRegistroCredencial;
	
	@Column(name = "DES_EMISION_CREDENCIAL")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String desEmisionCredencial;
	
	@Column(name = "DES_LATITUD_CREDENCIAL")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String desLatitudCredencial;
	
	@Column(name = "DES_LONGITUD_CREDENCIAL")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String desLongitudCredencial;
	 
	@Column(name = "DES_NOMBRE")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String desNombre;
	
	
	@Column(name = "FOTO_PRUEBA_VIDA")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String fotoPruebaVida;
	
	@Column(name = "FOTO_CREDENCIAL")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String fotoCredencial;
	
	
	@Column(name = "RESULTADO")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String resultado;
	
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FEC_PRUEBA_VIDA")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	Date fecPruebaVida;
	
	 
	
	@Column(name = "DES_CURP")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String desCurp;
	
	@Column(name = "FOLIO_ACEPTACION")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String folioAceptacion;
	
	
	
	@Column(name = "FOLIO_DESACTIVACION")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String folioDesactivacion;
	
	
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FEC_REGISTRO")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	Date fecRegistro;
	
	
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FEC_ACTUALIZACION")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	Date fecActualizacion;
	
	
	/**
	 */

	@Column(name = "DES_RFC")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String desRfc;
	/**
	 */

	@Column(name = "DES_PRIMER_APELLIDO")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String desPrimerApellido;
	/**
	 */

	@Column(name = "DES_SEGUNDO_APELLIDO")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String desSegundoApellido;
	/**
	 */

	@Column(name = "IND_ACTIVO")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	Integer indActivo;
	
	@Column(name = "IND_VALIDACION")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	Integer indValidacion;
	
	@Column(name = "IND_TIPO_ACTIVACION")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	Integer indTipoActivacion;
	
	
	
	@Column(name = "CLAVE_MUNICIPIO")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String claveMunicipio;
	
	
	@Column(name = "DES_MUNICIPIO")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String desMunicipio;
	
	@Column(name = "DES_COLONIA")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String desColonia;
	
	
	@Column(name = "DES_CODIGO_POSTAL")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String desCodigoPostal;
	
	 
 
	
 
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FEC_ACEPTACION")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	Date fecAceptacion;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FEC_CONFIRMA_MED_CONTACTO")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	Date fecConfirmaMedContacto;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FEC_DESACTIVACION")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	Date fecDesactivacion;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FEC_REACTIVACION")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	Date fecReactivacion;
	
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FEC_NO_ACEPTACION")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	Date fecNoAceptacion;
	
	/**
	 */

	@Column(name = "DES_PATH_ACUSE_HDFS" )
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String desPathAcuseHdfs;
	
	
	@Column(name = "DES_PATH_ACUSE_HDFS_DESACT" )
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String desPathAcuseHdfsDesact;


	@Column(name = "CLAVE_DELEGACION")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String claveDelegacion;

	@Column(name = "CLAVE_SUBDELEGACION")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String claveSubdelegacion;
	
	/**
	 */

	@Column(name = "DES_USUARIO")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String desUsuario;
	
	
	@Column(name = "CLAVE_ENT_FED")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String claveEntFed;
	
	
	@Column(name = "DES_ENT_FED")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String desEntFed;
	
	
	@Column(name = "IND_DESACTIVACION")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	Integer indDesactivacion;
	
	
	
	/**
	 */

	@Column(name = "DES_EMAIL")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String desEmail;

	/**
	 */
	@OneToMany(mappedBy = "bitUsuario", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)

	@XmlElement(name = "", namespace = "")
	@JsonBackReference
	java.util.List<BitUsuarioRole> bitUsuarioRoles;

	



	
	
	/**
	 */
	@OneToMany(mappedBy = "bitUsuario", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)

	@XmlElement(name = "", namespace = "")
	@JsonBackReference
	java.util.List<BttPatron> bttPatrons;
 
	
	
 
 
 
 
 

	public String getDesCic() {
		return desCic;
	}

	public void setDesCic(String desCic) {
		this.desCic = desCic;
	}

	public String getDesTipoCredencial() {
		return desTipoCredencial;
	}

	public void setDesTipoCredencial(String desTipoCredencial) {
		this.desTipoCredencial = desTipoCredencial;
	}

	public String getDesSubtipoCredencial() {
		return desSubtipoCredencial;
	}

	public void setDesSubtipoCredencial(String desSubtipoCredencial) {
		this.desSubtipoCredencial = desSubtipoCredencial;
	}

	public String getDesSexoCredencial() {
		return desSexoCredencial;
	}

	public void setDesSexoCredencial(String desSexoCredencial) {
		this.desSexoCredencial = desSexoCredencial;
	}

	public String getFotoCredencialReverso() {
		return fotoCredencialReverso;
	}

	public void setFotoCredencialReverso(String fotoCredencialReverso) {
		this.fotoCredencialReverso = fotoCredencialReverso;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public Date getFecPruebaVida() {
		return fecPruebaVida;
	}

	public void setFecPruebaVida(Date fecPruebaVida) {
		this.fecPruebaVida = fecPruebaVida;
	}

	public String getFotoPruebaVida() {
		return fotoPruebaVida;
	}

	public void setFotoPruebaVida(String fotoPruebaVida) {
		this.fotoPruebaVida = fotoPruebaVida;
	}

	public String getFotoCredencial() {
		return fotoCredencial;
	}

	public void setFotoCredencial(String fotoCredencial) {
		this.fotoCredencial = fotoCredencial;
	}

	public Date getFecActualizacion() {
		return fecActualizacion;
	}

	public void setFecActualizacion(Date fecActualizacion) {
		this.fecActualizacion = fecActualizacion;
	}

	public Integer getIndTipoActivacion() {
		return indTipoActivacion;
	}

	public void setIndTipoActivacion(Integer indTipoActivacion) {
		this.indTipoActivacion = indTipoActivacion;
	}

 

 

  

	public String getClaveMunicipio() {
		return claveMunicipio;
	}

	public void setClaveMunicipio(String claveMunicipio) {
		this.claveMunicipio = claveMunicipio;
	}

	public String getDesMunicipio() {
		return desMunicipio;
	}

	public void setDesMunicipio(String desMunicipio) {
		this.desMunicipio = desMunicipio;
	}

	public String getDesColonia() {
		return desColonia;
	}

	public void setDesColonia(String desColonia) {
		this.desColonia = desColonia;
	}

	public String getDesCodigoPostal() {
		return desCodigoPostal;
	}

	public void setDesCodigoPostal(String desCodigoPostal) {
		this.desCodigoPostal = desCodigoPostal;
	}






	public String getDesCurpCredencial() {
		return desCurpCredencial;
	}

	public void setDesCurpCredencial(String desCurpCredencial) {
		this.desCurpCredencial = desCurpCredencial;
	}

	public String getDesClaveElector() {
		return desClaveElector;
	}

	public void setDesClaveElector(String desClaveElector) {
		this.desClaveElector = desClaveElector;
	}

	public String getDesNumeroEmision() {
		return desNumeroEmision;
	}

	public void setDesNumeroEmision(String desNumeroEmision) {
		this.desNumeroEmision = desNumeroEmision;
	}

 

	public String getDesRegistroCredencial() {
		return desRegistroCredencial;
	}

	public void setDesRegistroCredencial(String desRegistroCredencial) {
		this.desRegistroCredencial = desRegistroCredencial;
	}

	public String getDesEmisionCredencial() {
		return desEmisionCredencial;
	}

	public void setDesEmisionCredencial(String desEmisionCredencial) {
		this.desEmisionCredencial = desEmisionCredencial;
	}

	public String getDesLatitudCredencial() {
		return desLatitudCredencial;
	}

	public void setDesLatitudCredencial(String desLatitudCredencial) {
		this.desLatitudCredencial = desLatitudCredencial;
	}

 

	public String getDesLongitudCredencial() {
		return desLongitudCredencial;
	}

	public void setDesLongitudCredencial(String desLongitudCredencial) {
		this.desLongitudCredencial = desLongitudCredencial;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getClaveEntFed() {
		return claveEntFed;
	}

	public void setClaveEntFed(String claveEntFed) {
		this.claveEntFed = claveEntFed;
	}

	public String getDesEntFed() {
		return desEntFed;
	}

	public void setDesEntFed(String desEntFed) {
		this.desEntFed = desEntFed;
	}

	public Integer getIndDesactivacion() {
		return indDesactivacion;
	}

	public void setIndDesactivacion(Integer indDesactivacion) {
		this.indDesactivacion = indDesactivacion;
	}

	public Date getFecRegistro() {
		return fecRegistro;
	}

	public void setFecRegistro(Date fecRegistro) {
		this.fecRegistro = fecRegistro;
	}

	public String getFolioDesactivacion() {
		return folioDesactivacion;
	}

	public void setFolioDesactivacion(String folioDesactivacion) {
		this.folioDesactivacion = folioDesactivacion;
	}

 

	public String getDesPathAcuseHdfsDesact() {
		return desPathAcuseHdfsDesact;
	}

	public void setDesPathAcuseHdfsDesact(String desPathAcuseHdfsDesact) {
		this.desPathAcuseHdfsDesact = desPathAcuseHdfsDesact;
	}

	public String getDesCurp() {
		return desCurp;
	}

	public void setDesCurp(String desCurp) {
		this.desCurp = desCurp;
	}

	public Date getFecConfirmaMedContacto() {
		return fecConfirmaMedContacto;
	}

	public void setFecConfirmaMedContacto(Date fecConfirmaMedContacto) {
		this.fecConfirmaMedContacto = fecConfirmaMedContacto;
	}

	public Date getFecDesactivacion() {
		return fecDesactivacion;
	}

	public void setFecDesactivacion(Date fecDesactivacion) {
		this.fecDesactivacion = fecDesactivacion;
	}

	public Date getFecReactivacion() {
		return fecReactivacion;
	}

	public void setFecReactivacion(Date fecReactivacion) {
		this.fecReactivacion = fecReactivacion;
	}

	public Date getFecNoAceptacion() {
		return fecNoAceptacion;
	}

	public void setFecNoAceptacion(Date fecNoAceptacion) {
		this.fecNoAceptacion = fecNoAceptacion;
	}

	public String getFolioAceptacion() {
		return folioAceptacion;
	}

	public void setFolioAceptacion(String folioAceptacion) {
		this.folioAceptacion = folioAceptacion;
	}

	public String getDesPathAcuseHdfs() {
		return desPathAcuseHdfs;
	}

	public void setDesPathAcuseHdfs(String desPathAcuseHdfs) {
		this.desPathAcuseHdfs = desPathAcuseHdfs;
	}

	public java.util.List<BttPatron> getBttPatrons() {
		return bttPatrons;
	}

	public void setBttPatrons(java.util.List<BttPatron> bttPatrons) {
		this.bttPatrons = bttPatrons;
	}

	public Date getFecAceptacion() {
		return fecAceptacion;
	}

	public void setFecAceptacion(Date fecAceptacion) {
		this.fecAceptacion = fecAceptacion;
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
	public void setDesPassword(String desPassword) {
		this.desPassword = desPassword;
	}

	/**
	 */
	public String getDesPassword() {
		return this.desPassword;
	}

	/**
	 */
	public void setDesNombre(String desNombre) {
		this.desNombre = desNombre;
	}

	/**
	 */
	public String getDesNombre() {
		return this.desNombre;
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
	public void setDesPrimerApellido(String desPrimerApellido) {
		this.desPrimerApellido = desPrimerApellido;
	}

	/**
	 */
	public String getDesPrimerApellido() {
		return this.desPrimerApellido;
	}

	/**
	 */
	public void setDesSegundoApellido(String desSegundoApellido) {
		this.desSegundoApellido = desSegundoApellido;
	}

	/**
	 */
	public String getDesSegundoApellido() {
		return this.desSegundoApellido;
	}

	/**
	 */
	public void setIndActivo(Integer indActivo) {
		this.indActivo = indActivo;
	}

	/**
	 */
	public Integer getIndActivo() {
		return this.indActivo;
	}

	/**
	 */
	public void setDesUsuario(String desUsuario) {
		this.desUsuario = desUsuario;
	}

	/**
	 */
	public String getDesUsuario() {
		return this.desUsuario;
	}

	/**
	 */
	public void setDesEmail(String desEmail) {
		this.desEmail = desEmail;
	}

	/**
	 */
	public String getDesEmail() {
		return this.desEmail;
	}

	/**
	 */
	public void setBitUsuarioRoles(List<BitUsuarioRole> bitUsuarioRoles) {
		this.bitUsuarioRoles = bitUsuarioRoles;
	}


    public String getClaveDelegacion() {
        return claveDelegacion;
    }

    public void setClaveDelegacion(String claveDelegacion) {
        this.claveDelegacion = claveDelegacion;
    }

    public String getClaveSubdelegacion() {
        return claveSubdelegacion;
    }

    public void setClaveSubdelegacion(String claveSubdelegacion) {
        this.claveSubdelegacion = claveSubdelegacion;
    }

    /**
	 */
	public List<BitUsuarioRole> getBitUsuarioRoles() {
		if (bitUsuarioRoles == null) {
			bitUsuarioRoles = new java.util.LinkedList<BitUsuarioRole>();
		}
		return bitUsuarioRoles;
	}



	public Integer getIndValidacion() {
		return indValidacion;
	}

	public void setIndValidacion(Integer indValidacion) {
		this.indValidacion = indValidacion;
	}

	/**
	 */
	public BitUsuario() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(BitUsuario that) {
		setCveIdUsuario(that.getCveIdUsuario());
		setDesPassword(that.getDesPassword());
		setDesNombre(that.getDesNombre());
		setDesRfc(that.getDesRfc());
		setDesPrimerApellido(that.getDesPrimerApellido());
		setDesSegundoApellido(that.getDesSegundoApellido());
		setIndActivo(that.getIndActivo());
		setDesUsuario(that.getDesUsuario());
		setDesEmail(that.getDesEmail());
		setClaveDelegacion(that.getClaveDelegacion());
		setClaveSubdelegacion(that.getClaveSubdelegacion());
		setBitUsuarioRoles(new java.util.LinkedList<BitUsuarioRole>(that.getBitUsuarioRoles()));
		
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("cveIdUsuario=[").append(cveIdUsuario).append("] ");
		buffer.append("desPassword=[").append(desPassword).append("] ");
		buffer.append("desNombre=[").append(desNombre).append("] ");
		buffer.append("desRfc=[").append(desRfc).append("] ");
		buffer.append("desPrimerApellido=[").append(desPrimerApellido).append("] ");
		buffer.append("desSegundoApellido=[").append(desSegundoApellido).append("] ");
		buffer.append("indActivo=[").append(indActivo).append("] ");
		buffer.append("desUsuario=[").append(desUsuario).append("] ");
		buffer.append("desEmail=[").append(desEmail).append("] "); 
        buffer.append("claveDelegacion=[").append(claveDelegacion).append("] ");
        buffer.append("claveSubdelegacion=[").append(claveSubdelegacion).append("] ");
		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((cveIdUsuario == null) ? 0 : cveIdUsuario.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof BitUsuario))
			return false;
		BitUsuario equalCheck = (BitUsuario) obj;
		if ((cveIdUsuario == null && equalCheck.cveIdUsuario != null) || (cveIdUsuario != null && equalCheck.cveIdUsuario == null))
			return false;
		if (cveIdUsuario != null && !cveIdUsuario.equals(equalCheck.cveIdUsuario))
			return false;
		return true;
	}
}
