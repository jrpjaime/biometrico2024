package mx.gob.imss.biometricos.util;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File; 
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest; 
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest; 
  
import org.springframework.web.multipart.MultipartFile;
  


 

 

public interface UtileriasService {

	boolean validaCURP(String curp);

	boolean validaRFC(String rfc);

	boolean validaLlaveBuzonIMSS(String llaveBuzonIMSS);

	String encriptar(String s) throws UnsupportedEncodingException;

	String getNameFile(String nameFile);

	//void sendEmailExterno(String email, String asunto, String cuerpo) throws Exception;

	void encode(String sourceFile, String targetFile);

	void decode(String sourceFile, String targetFile);

	String getTokenBasic(HttpServletRequest request);

	String getTokenBearer(HttpServletRequest request);

	String desencriptar(String s) throws UnsupportedEncodingException;

	String encriptar(byte[] s) throws UnsupportedEncodingException;

	String getFolioPrefijo(String prefijo, Date fechaFolio);

	BufferedImage generaQRImage(String content) throws Exception;

	String getValorNotNull(Object valor);	
 
}

