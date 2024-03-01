package mx.gob.imss.biometricos.service;
 
import java.security.PrivateKey;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.JWEObject;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.DirectDecrypter;
import com.nimbusds.jose.crypto.DirectEncrypter;

import mx.gob.imss.biometricos.vo.UsuarioTokenVO;
 
  

@Service("tokenServiceImpl")
public class  TokenServiceImpl implements TokenService  { 

	private static final Logger logger = LogManager.getLogger(TokenServiceImpl.class);
	
	
	
	
	

	  
	private final static byte[] key512 = { 
			(byte)177, (byte)119, (byte) 33, (byte) 13, (byte)164, (byte) 30, (byte)108, (byte)121, 
			(byte)207, (byte)136, (byte)107, (byte)242, (byte) 12, (byte)224, (byte) 19, (byte)226,
			(byte)198, (byte)134, (byte) 17, (byte) 71, (byte)173, (byte) 75, (byte) 42, (byte) 61, 
			(byte) 48, (byte)162, (byte)206, (byte)161, (byte) 97, (byte)108, (byte)185, (byte)234,
			(byte) 60, (byte)181, (byte) 90, (byte) 85, (byte) 51, (byte)123, (byte)  6, (byte)224, 
			(byte)  4, (byte)122, (byte) 29, (byte)230, (byte)151, (byte) 12, (byte)244, (byte)127, 
			(byte)121, (byte) 25, (byte)  4, (byte) 85, (byte)220, (byte)144, (byte)215, (byte)110, 
			(byte)130, (byte) 17, (byte) 68, (byte)228, (byte)129, (byte)138, (byte)  7, (byte)120 };
	
	
  
  public  String infoToken(String token) throws  Exception{
		JWEObject jweObject = JWEObject.parse(token);
		// Decrypt
		jweObject.decrypt(new DirectDecrypter(key512));
		// Get the plain text
		Payload payload = jweObject.getPayload();
		logger.info("payload.toString(): " +  payload.toString());
		return payload.toString();
	  }


  
  
  

	/*
	 * Método de consulta por cveIdTipoPrivilegio
	*/
	@Override
	@Transactional
	public UsuarioTokenVO getInfoToken(String token ) throws Exception{
		UsuarioTokenVO usuarioTokenVO=new UsuarioTokenVO();
		logger.info("token " +  token );
		 
		
		String infoToken= infoToken(token); 
		logger.info("infoToken " +  infoToken ); 
		StringTokenizer tokens=new StringTokenizer(infoToken, "|");
	        int nDatos=tokens.countTokens(); 
	       String[] datos=new String[nDatos];
	        Integer i=0;
	        while(tokens.hasMoreTokens()){
	            String str=tokens.nextToken();
	            datos[i]=str; 
	            i++; 
	        }
	        
	        logger.info("datos: " + datos); 
		usuarioTokenVO.setRfc(datos[0]);
		usuarioTokenVO.setNombreRazonSocial(datos[1]); 
		usuarioTokenVO.setCodigo(1);
		usuarioTokenVO.setMensaje("Éxito");
		
		
		return usuarioTokenVO;
	}

 

	
	@Override
	@Transactional
	  public  String createToken(String rfc, String razonSocial ) throws  Exception{
		    logger.info("createToken: ");
			SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyyMMddHHmmssSSS",new Locale("es", "MX"));  
			String fecha= formatoFecha.format(new Date()); 
		    logger.info("fecha: " + fecha);
			String identificador= rfc + "|" +razonSocial+ "|" + fecha;
			logger.info("identificador: " + identificador);

			// Create the header
			JWEHeader header = new JWEHeader(JWEAlgorithm.DIR, EncryptionMethod.A256CBC_HS512);
			Payload payload = new Payload(identificador);
			// Create the JWE object and encrypt it 
			JWEObject jweObject = new JWEObject(header, payload); 
			jweObject.encrypt(new DirectEncrypter(key512));
			// Serialise to compact JOSE form...
			String jweString = jweObject.serialize();
			logger.info("jweString: " + jweString);

			return jweString;
		  }
	
	
	
	
 
	
	
}
