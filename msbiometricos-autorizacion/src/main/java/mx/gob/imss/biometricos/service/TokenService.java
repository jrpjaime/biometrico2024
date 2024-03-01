package mx.gob.imss.biometricos.service;

 
import mx.gob.imss.biometricos.vo.UsuarioTokenVO;
 

public interface  TokenService { 
 
 
	public UsuarioTokenVO getInfoToken(String token) throws Exception;

	String createToken(String rfc, String razonSocial) throws Exception;

}
