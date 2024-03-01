package mx.gob.imss.biometricos.vo;

import java.util.HashMap;
import java.util.Map;

public class MediosComunicacionVO {
	private String correo;
	private String telefono;
	private  Map<String, String> parametrosCorreo;
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Map<String, String> getParametrosCorreo() {
		return parametrosCorreo;
	}
	public void setParametrosCorreo(Map<String, String> parametrosCorreo) {
		this.parametrosCorreo = parametrosCorreo;
	}
 
	
	

}
