package mx.gob.imss.biometricos.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList; 
import java.util.Base64;
import java.util.Calendar;
import java.util.Date; 
import java.util.List;
import java.util.Locale; 
import java.util.regex.Pattern;
import java.util.zip.ZipEntry; 
import java.util.zip.ZipInputStream;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest; 
 
 
import java.io.UnsupportedEncodingException; 
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream; 
import java.text.SimpleDateFormat;

import com.google.zxing.BarcodeFormat; 
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
 
 
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper; 
import org.springframework.stereotype.Service; 
import org.springframework.web.multipart.MultipartFile; 





@Service("utileriasService")
public class UtileriasServiceImpl implements UtileriasService {
 

	private static final Logger logger = LogManager.getLogger(UtileriasServiceImpl.class);
 
	  
    @Autowired
    private JavaMailSender sender;
    
 
    
    @Override
    public boolean validaCURP(String curp) {
        String regex = "[A-Z]{1}[AEIOU]{1}[A-Z]{2}[0-9]{2}" + "(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])" + "[HM]{1}"
				+ "(AS|BC|BS|CC|CS|CH|CL|CM|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|NE)"
				+ "[B-DF-HJ-NP-TV-Z]{3}" + "[0-9A-Z]{1}[0-9]{1}$";
        Pattern patron = Pattern.compile(regex);
        if (!patron.matcher(curp).matches()) {
                return false;
        } else {
                return true;      
        }
    }
    
    
    @Override
    public boolean validaRFC(String rfc) {
        //String regex = "([A-Z]{3,4})([0-9]{6})([A-Z,0-9]{3})$";
    	String regex ="^([A-Z,Ñ,&]{3,4}([0-9]{2})(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])[A-Z|\\d]{3})$";
        Pattern patron = Pattern.compile(regex);
        if (!patron.matcher(rfc).matches()) {
                return false;
        }else {
                return true;      
        }
    }
   
    
    
    @Override
    public boolean validaLlaveBuzonIMSS(String llaveBuzonIMSS) {
    	 logger.info("validaLlaveBuzonIMSS: " + llaveBuzonIMSS);
        String regex = "^[0-9,a-z,A-Z]{8,100}$";
        Pattern patron = Pattern.compile(regex);
        if (!patron.matcher(llaveBuzonIMSS).matches()) {
                return false;
        }else {
                return true;      
        }
    }

    
    @Override
    public String encriptar(String s) throws UnsupportedEncodingException {
    	
    	logger.info("sssss:" + s);
      return Base64.getEncoder().encodeToString(s.getBytes("utf-8"));
    }
    
    @Override
    public String encriptar(byte[] s) throws UnsupportedEncodingException {
    	
    	 
      return Base64.getEncoder().encodeToString(s);
    }
    @Override
    public String desencriptar(String s) throws UnsupportedEncodingException {
        byte[] decode = Base64.getDecoder().decode(s.getBytes());
    	
        return new String(decode, "utf-8");
    }

 
 
 
  
    
	@Override
	public String getNameFile(String nameFile) {
		String SEPARADOR = System.getProperty("file.separator");
		int posicionInicial = nameFile.lastIndexOf(SEPARADOR);
		if (posicionInicial > 0) {
			nameFile = nameFile.substring(posicionInicial + 1, nameFile.length());// identifica el nombre del archivo
		}
		return nameFile;
	}
    
	
	
	
	@Override
    public void sendEmailExterno(String email, String asunto,String cuerpo ) throws Exception {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8"); 
		
	 
 

		if (email != null) {
			helper.setTo(email.trim());
			helper.setSubject(asunto);
			
			helper.setText(cuerpo, true);

			sender.send(message);
			System.out.println("Envío el correo a : " + email);
		}
	}


 
	
	 

	    
	
    /**
     * This method converts the content of a source file into Base64 encoded data and saves that to a target file.
     * If isChunked parameter is set to true, there is a hard wrap of the output  encoded text.
     */
	@Override
    public  void encode(String sourceFile, String targetFile )   {
 try {
        byte[] base64EncodedData = Base64.getEncoder().encode(loadFileAsBytesArray(sourceFile));
 
        writeByteArraysToFile(targetFile, base64EncodedData);
 }catch (Exception e) {
	// TODO: handle exception
}
    }
 
	@Override
    public   void decode(String sourceFile, String targetFile)   {
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(loadFileAsBytesArray(sourceFile));
            
            writeByteArraysToFile(targetFile, decodedBytes);
	     }catch (Exception e) {
	    	// TODO: handle exception
	    }
    }
    
 
 
 
    /**
     * This method loads a file from file system and returns the byte array of the content.
     * 
     * @param fileName
     * @return
     * @throws Exception
     */
    public static byte[] loadFileAsBytesArray(String fileName) throws Exception {
 
        File file = new File(fileName);
        int length = (int) file.length();
        BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file));
        byte[] bytes = new byte[length];
        reader.read(bytes, 0, length);
        reader.close();
        return bytes;
 
    }
 
    /**
     * This method writes byte array content into a file.
     * 
     * @param fileName
     * @param content
     * @throws IOException
     */
    public static void writeByteArraysToFile(String fileName, byte[] content) throws IOException {
 
        File file = new File(fileName);
        BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(file));
        writer.write(content);
        writer.flush();
        writer.close();
 
    }
	
 
 
	
	
 
 
    
	
	@Override
	public String getValorNotNull(Object valor) {
		
		String valorResultado="";
		if(valor!=null) {
			 valorResultado=valor.toString().trim();
		} 
		return valorResultado;
	}
	
 
 
 
    
    
 
    
     
 
 
 
 

 

    
    @Override
    public String getFolioPrefijo(String prefijo, Date fechaFolio) {      
        String pattern = "yyyyMMdd-HHmmssSSS";
        SimpleDateFormat formatofecha = new SimpleDateFormat(pattern,new Locale("es", "MX"));
        String desFolio=prefijo+"-" + formatofecha.format(fechaFolio);
        
        logger.info("getFolioPrefijo: "+ desFolio);
        return desFolio;
    }
    
    
    

 
 
 
 
 

  	@Override
	public BufferedImage generaQRImage(String content)  throws Exception{
		BufferedImage image = null;
		 

			int size = 220;
			QRCodeWriter qrcode = new QRCodeWriter();
			BitMatrix matrix = qrcode.encode(content, BarcodeFormat.QR_CODE, size, size);
			int matrixWidth = matrix.getWidth();
			image = new BufferedImage(matrixWidth, matrixWidth, BufferedImage.TYPE_INT_RGB);
			image.createGraphics();

			Graphics2D graphics = (Graphics2D) image.getGraphics();
			graphics.setColor(Color.WHITE);
			graphics.fillRect(0, 0, matrixWidth, matrixWidth);
			graphics.setColor(Color.BLACK);

			for (int b = 0; b < matrixWidth; b++) {
				for (int j = 0; j < matrixWidth; j++) {
					if (matrix.get(b, j)) {
						graphics.fillRect(b, j, 1, 1);
					}
				}
			}
			logger.info("Imagen QR: "+image.toString());

 
		return image;
	}
  	 
  	
  	 
    
    
 
    
      
    
    
    
 
 
 

    public boolean isFechaInicialMenorQueFechaFinal(Date fechaInicial, Date fechaFinal){
    //    logger.info("fecha inicial: " + fechaInicial + "fecha final: " + fechaFinal);

        Calendar fechaActual = Calendar.getInstance();
        Calendar fechaMaxima = Calendar.getInstance();
        fechaActual.setTime(fechaInicial);
        fechaMaxima.setTime(fechaFinal);

        //Si la fecha inicial es antes (menor) que la fecha maxima o es el mismo dia.
        if(fechaActual.before(fechaMaxima)){
         //   logger.info("fecha inicial "+fechaActual+ " es menor que la fecha final: "+fechaMaxima);
            return true;
        }else{
          //  logger.info("fecha inicial "+fechaActual+ " es mayor o igual que la fecha final: "+fechaMaxima);
            return false;
        }
    }

    public boolean isFechaInicialMayorQueFechaFinal(Date fechaInicial, Date fechaFinal){
    //    logger.info("fecha inicial: " + fechaInicial + "fecha final: " + fechaFinal);

        try {
            Calendar fechaActual = Calendar.getInstance();
            Calendar fechaMaxima = Calendar.getInstance();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            fechaInicial = sdf.parse(sdf.format(fechaInicial));
            fechaFinal = sdf.parse(sdf.format(fechaFinal));

//            logger.info("fechas1: "+fechaInicial);
//            logger.info("fechas2: "+fechaFinal);


            fechaActual.setTime(fechaInicial);
            fechaMaxima.setTime(fechaFinal);

//            logger.info("fechas1: "+fechaActual);
//            logger.info("fechas2: "+fechaMaxima);

            //Si la fecha inicial es mayor (después) que la fecha final o es el mismo dia.
            if (fechaActual.after(fechaMaxima)) {
            //   logger.info("TRUE: fecha inicial " + fechaActual + " es mayor que la fecha final: " + fechaMaxima);
                return true;
            } else {
            //    logger.info("ES FALSE: fecha inicial " + fechaActual + " es menor o igual que la fecha final: " + fechaMaxima);
                return false;
            }
        }catch (Exception e){
            logger.error("Error: hubo un error con las fechas: "+e.getMessage());
            return false;
        }
    }

 

  


    public boolean leerZIP(String archivoZip, String rutaSalida)
            throws IOException {
        byte[] buffer = new byte[1024];
        try {
            File folder = new File(rutaSalida);
            if (!folder.exists()) {
                folder.mkdir();
            }
            ZipInputStream zis = new ZipInputStream(new FileInputStream(
                    archivoZip));
            ZipEntry ze = zis.getNextEntry();
            while (ze != null) {
                String nombreArchivo = ze.getName();
                File archivoNuevo = new File(rutaSalida + File.separator
                        + nombreArchivo);
                new File(archivoNuevo.getParent()).mkdirs();
                FileOutputStream fos = new FileOutputStream(archivoNuevo);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
                ze = zis.getNextEntry();
            }
            zis.closeEntry();
            zis.close();
        } catch (IOException ex) {
            logger.error(ex);
        }

        return true;
    }

    public boolean buscarNombreEnZIP(String nombreArchivo,String archivoZip) throws IOException {

        FileInputStream fis = null;
        ZipInputStream zipIs = null;
        ZipEntry zEntry = null;
        try {
            fis = new FileInputStream(archivoZip);
            zipIs = new ZipInputStream(new BufferedInputStream(fis));
            while((zEntry = zipIs.getNextEntry()) != null){
//                System.out.println(zEntry.getName());
                if(zEntry.getName().trim().toUpperCase().equals(nombreArchivo.trim().toUpperCase())){
                    logger.info("se encontro el nombre");
                    return true;
                }

            }
            zipIs.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        logger.info("NO se encontro el nombre");
        return false;
    }

    public List<String> recuperaNombresZIP(MultipartFile archivoZip) throws IOException{

        FileInputStream fis = null;
        ZipInputStream zipIs = null;
        ZipEntry zEntry = null;
        List<String> nombreArchivos = new ArrayList<>();
        try {
            zipIs = new ZipInputStream(new BufferedInputStream(archivoZip.getInputStream()));
            while((zEntry = zipIs.getNextEntry()) != null){
                nombreArchivos.add(zEntry.getName());
            }
            zipIs.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        logger.info("NO se encontro el nombre");
        return nombreArchivos;
    }

    public boolean descomprimeZIP(MultipartFile archivoZip, String rutaSalida)
            throws IOException {
        byte[] buffer = new byte[1024];
        try {
            File folder = new File(rutaSalida);
            if (!folder.exists()) {
                folder.mkdir();
            }

//            ZipInputStream zis = new ZipInputStream(new FileInputStream(archivoZip));
            ZipInputStream zis = new ZipInputStream(archivoZip.getInputStream());
            ZipEntry ze = zis.getNextEntry();
            while (ze != null) {
                String nombreArchivo = ze.getName();
                logger.info("nombre archivo: "+nombreArchivo);
                File archivoNuevo = new File(rutaSalida + File.separator
                        + nombreArchivo);
                logger.info("pah completo: "+ archivoNuevo);
                new File(archivoNuevo.getParent()).mkdirs();
                FileOutputStream fos = new FileOutputStream(archivoNuevo);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
                ze = zis.getNextEntry();
            }
            zis.closeEntry();
            zis.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            logger.error(ex);
            return false;
        }

        return true;
    }

    public boolean isMismaFecha(Date fechaInicial, Date fechaFinal){
        try {
            Calendar fechaActual = Calendar.getInstance();
            Calendar fechaMaxima = Calendar.getInstance();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            fechaInicial = sdf.parse(sdf.format(fechaInicial));
            fechaFinal = sdf.parse(sdf.format(fechaFinal));
            fechaActual.setTime(fechaInicial);
            fechaMaxima.setTime(fechaFinal);

            //Si la fecha inicial es mayor (después) que la fecha final o es el mismo dia.
            if (fechaActual.equals(fechaMaxima)) {
//                logger.info("TRUE: las fechas son iguales");
                return true;
            } else {
//                logger.info("FALSE: Las fechas son distintas");
                return false;
            }
        }catch (Exception e){
            logger.error("Error: hubo un error con las fechas: "+e.getMessage());
            return false;
        }
    }

    public List<String> get5YearsBefore(){
        Calendar fechaAcutal = Calendar.getInstance();

        ArrayList<String> resultado = new ArrayList<>();

        Integer actualYear = fechaAcutal.get(Calendar.YEAR);
//        Integer initYear = actualYear-6;
        resultado.add("TODOS");
//        resultado.add(Integer.toString(actualYear));
        for(int i=0; i<=6;i++){
            resultado.add( Integer.toString(actualYear-i) );
//            resultado.add( Integer.toString(initYear+i) );
        }


        return resultado;
    }
    
   
     
    
    
    
    @Override
    public String getTokenBasic(HttpServletRequest request){ 
        String header = request.getHeader("Authorization");
        if(header != null && header.startsWith("Basic")) {
            return header.replace("Basic ", "");
        }
        return null;
    }
    
    
    
    @Override
    public String getTokenBearer(HttpServletRequest request){ 
        String header = request.getHeader("Authorization");
        if(header != null && header.startsWith("Bearer")) {
            return header.replace("Bearer ", "");
        }
        return null;
    }
    
    
    
    
}
