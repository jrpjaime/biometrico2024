package mx.gob.imss.biometricos.vo;

import java.util.Date;

 

public class ComunicadoVO {
	private Long cveIdContenedor;
	private String comunicado;
	
	private Long cveIdArea;
	private String desRfc;
	private String desTema; 
	private String desContenido;
	private Date fecAviso; 
	private String cveRegistroPatronal;
	private String actoAdministrativo;

	private String numLote;
	private String folioActo;
	private boolean indNotificacion; //0= a un no leido por el patron
	private String identificador;
	private Date fecInicioDisponibilidad;
	private Date fecTerminoDisponibilidad;
	
	private boolean sendCorreo;
	private boolean sendSMS;
	
 
 
 
 
	public boolean isSendCorreo() {
		return sendCorreo;
	}
	public void setSendCorreo(boolean sendCorreo) {
		this.sendCorreo = sendCorreo;
	}
	public boolean isSendSMS() {
		return sendSMS;
	}
	public void setSendSMS(boolean sendSMS) {
		this.sendSMS = sendSMS;
	}
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public Long getCveIdContenedor() {
		return cveIdContenedor;
	}
	public void setCveIdContenedor(Long cveIdContenedor) {
		this.cveIdContenedor = cveIdContenedor;
	}
	public String getComunicado() {
		return comunicado;
	}
	public void setComunicado(String comunicado) {
		this.comunicado = comunicado;
	}
	public Long getCveIdArea() {
		return cveIdArea;
	}
	public void setCveIdArea(Long cveIdArea) {
		this.cveIdArea = cveIdArea;
	}
	public String getDesRfc() {
		return desRfc;
	}
	public void setDesRfc(String desRfc) {
		this.desRfc = desRfc;
	}
	public String getDesTema() {
		return desTema;
	}
	public void setDesTema(String desTema) {
		this.desTema = desTema;
	}
	public String getDesContenido() {
		return desContenido;
	}
	public void setDesContenido(String desContenido) {
		this.desContenido = desContenido;
	}
	public Date getFecAviso() {
		return fecAviso;
	}
	public void setFecAviso(Date fecAviso) {
		this.fecAviso = fecAviso;
	}
	public String getCveRegistroPatronal() {
		return cveRegistroPatronal;
	}
	public void setCveRegistroPatronal(String cveRegistroPatronal) {
		this.cveRegistroPatronal = cveRegistroPatronal;
	}
	public String getActoAdministrativo() {
		return actoAdministrativo;
	}
	public void setActoAdministrativo(String actoAdministrativo) {
		this.actoAdministrativo = actoAdministrativo;
	}
 
 
	public String getNumLote() {
		return numLote;
	}
	public void setNumLote(String numLote) {
		this.numLote = numLote;
	}
	public String getFolioActo() {
		return folioActo;
	}
	public void setFolioActo(String folioActo) {
		this.folioActo = folioActo;
	}
	public boolean isIndNotificacion() {
		return indNotificacion;
	}
	public void setIndNotificacion(boolean indNotificacion) {
		this.indNotificacion = indNotificacion;
	}
	public Date getFecInicioDisponibilidad() {
		return fecInicioDisponibilidad;
	}
	public void setFecInicioDisponibilidad(Date fecInicioDisponibilidad) {
		this.fecInicioDisponibilidad = fecInicioDisponibilidad;
	}
	public Date getFecTerminoDisponibilidad() {
		return fecTerminoDisponibilidad;
	}
	public void setFecTerminoDisponibilidad(Date fecTerminoDisponibilidad) {
		this.fecTerminoDisponibilidad = fecTerminoDisponibilidad;
	}
 
 
 
 
	
	

}
