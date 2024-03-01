package mx.gob.imss.biometricos.security.dto;

import javax.validation.constraints.NotBlank;

public class LoginUsuarioDto {
    @NotBlank
    private String nombreUsuario;
    @NotBlank
    private String password;
     
    private String rfc;
    
    private String imagen;
    
    private String imagenreverso;
    
    @NotBlank
    private String origen;
    
     
    public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	private String curp;
    
    
    
    

    public String getImagenreverso() {
		return imagenreverso;
	}

	public void setImagenreverso(String imagenreverso) {
		this.imagenreverso = imagenreverso;
	}

	public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
    
    
    
}
