package mx.gob.imss.biometricos.vo;

public class UsuarioAuthVO {

   private  Long cveIdUsuario;
   private String rfc;
   private String nombreRazonSocial;
   private boolean autenticado;
   private String curp;
   private Long cveIdRole;
   private String claveDelegacion;
   private String delegacion;
   
   private Integer cveIdSubdelegacion;
   private String claveSubdelegacion;
   private String desSubdelegacion;
   
   
	public boolean isAutenticado() {
	return autenticado;
}
public void setAutenticado(boolean autenticado) {
	this.autenticado = autenticado;
}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public String getNombreRazonSocial() {
		return nombreRazonSocial;
	}
	public void setNombreRazonSocial(String nombreRazonSocial) {
		this.nombreRazonSocial = nombreRazonSocial;
	}
	public Long getCveIdUsuario() {
		return cveIdUsuario;
	}
	public void setCveIdUsuario(Long cveIdUsuario) {
		this.cveIdUsuario = cveIdUsuario;
	}
	public Long getCveIdRole() {
		return cveIdRole;
	}
	public void setCveIdRole(Long cveIdRole) {
		this.cveIdRole = cveIdRole;
	}
	public String getClaveDelegacion() {
		return claveDelegacion;
	}
	public void setClaveDelegacion(String claveDelegacion) {
		this.claveDelegacion = claveDelegacion;
	}
	public String getDelegacion() {
		return delegacion;
	}
	public void setDelegacion(String delegacion) {
		this.delegacion = delegacion;
	}
	public Integer getCveIdSubdelegacion() {
		return cveIdSubdelegacion;
	}
	public void setCveIdSubdelegacion(Integer cveIdSubdelegacion) {
		this.cveIdSubdelegacion = cveIdSubdelegacion;
	}
	public String getClaveSubdelegacion() {
		return claveSubdelegacion;
	}
	public void setClaveSubdelegacion(String claveSubdelegacion) {
		this.claveSubdelegacion = claveSubdelegacion;
	}
	public String getDesSubdelegacion() {
		return desSubdelegacion;
	}
	public void setDesSubdelegacion(String desSubdelegacion) {
		this.desSubdelegacion = desSubdelegacion;
	}
	   
   
   
}
