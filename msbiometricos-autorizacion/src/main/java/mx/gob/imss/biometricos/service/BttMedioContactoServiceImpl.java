package mx.gob.imss.biometricos.service;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import mx.gob.imss.biometricos.exception.HttpStatusException;
import mx.gob.imss.biometricos.model.BitUsuario;
import mx.gob.imss.biometricos.model.BtcEstatusMedioContacto;
import mx.gob.imss.biometricos.model.BtcTipoMedioContacto; 
import mx.gob.imss.biometricos.model.BttMedioContacto;
import mx.gob.imss.biometricos.model.BttPatron;
import mx.gob.imss.biometricos.model.BttPatronMedioContacto; 
import mx.gob.imss.biometricos.repository.BttMedioContactoRepository; 
import mx.gob.imss.biometricos.util.Constantes;
import mx.gob.imss.biometricos.util.SessionConstants;
import mx.gob.imss.biometricos.util.UtileriasService;
import mx.gob.imss.biometricos.vo.ComunicadoVO;
import mx.gob.imss.biometricos.vo.MediosComunicacionVO;
import mx.gob.imss.biometricos.vo.UsuarioAuthVO;
import mx.gob.imss.biometricos.ws.wsfirmaelectronicaseg.FirmaElectronicaSegPortType;
import mx.gob.imss.biometricos.ws.wsfirmaelectronicaseg.FirmaElectronicaSegService;
import mx.gob.imss.biometricos.ws.wsfirmaelectronicaseg.FirmaSimpleRequestType;
import mx.gob.imss.biometricos.ws.wsfirmaelectronicaseg.FirmaSimpleResponseType;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
@Service("bttMedioContactoService")
public class  BttMedioContactoServiceImpl implements BttMedioContactoService  {

	private static final Logger logger = LogManager.getLogger(BttMedioContactoServiceImpl.class);

	
    @Autowired
    private ServletContext servletContext;
    
	
	@Autowired
	private BttMedioContactoRepository bttMedioContactoRepository;

	
	@Autowired
	private BtcEstatusMedioContactoService btcEstatusMedioContactoService;
	
	@Autowired
	private UtileriasService utileriasService;
	
 
	
	@Autowired
	private BitUsuarioService bitUsuarioService;
	
	@Autowired
	private BttMedioContactoService bttMedioContactoService;
	
	@Autowired
	private BttPatronMedioContactoService bttPatronMedioContactoService;
	
 
	
	@Autowired
	private BtcTipoMedioContactoService btcTipoMedioContactoService;
	
 
	/*
	 * Método de consulta por cveIdMedioContacto
	*/
	@Override
	@Transactional
	public BttMedioContacto findBttMedioContactoByCveIdMedioContacto(Long cveIdMedioContacto){
		BttMedioContacto bttMedioContacto=bttMedioContactoRepository.findBttMedioContactoByCveIdMedioContacto(cveIdMedioContacto); 
		return bttMedioContacto;
	}

	/*
	 * Método de consulta findAll
	*/
	@Override
	@Transactional
	public List<BttMedioContacto> findAllBttMedioContacto(){
		List<BttMedioContacto> bttMedioContacto=bttMedioContactoRepository.findAll(); 
		return bttMedioContacto;
	}

	/*
	 * Método de consulta findAll
	*/
	@Override
	@Transactional
	public Page<BttMedioContacto> findAllBttMedioContacto(Pageable pageable){
		Page<BttMedioContacto> bttMedioContacto=bttMedioContactoRepository.findAll(pageable); 
		return bttMedioContacto;
	}
	


	/*
	 * Método de consulta por desFolio
	*/
	@Override
	@Transactional
	public List<BttMedioContacto> findBttMedioContactoByDesFolio(String desFolio){
		List<BttMedioContacto> bttMedioContacto=bttMedioContactoRepository.findBttMedioContactoByDesFolio(desFolio); 
		return bttMedioContacto;
	}

	/*
	 * Método de consulta por fecRegistro
	*/
	@Override
	@Transactional
	public List<BttMedioContacto> findBttMedioContactoByFecRegistro(Date fecRegistro){
		List<BttMedioContacto> bttMedioContacto=bttMedioContactoRepository.findBttMedioContactoByFecRegistro(fecRegistro); 
		return bttMedioContacto;
	}

	/*
	 * Método de consulta por desCorreoElectronico
	*/
	@Override
	@Transactional
	public List<BttMedioContacto> findBttMedioContactoByDesCorreoElectronico(String desCorreoElectronico){
		List<BttMedioContacto> bttMedioContacto=bttMedioContactoRepository.findBttMedioContactoByDesCorreoElectronico(desCorreoElectronico); 
		return bttMedioContacto;
	}

	
	/*
	 * Método de consulta por desCorreoElectronico
	*/
	@Override
	@Transactional
	public List<BttMedioContacto> findBttMedioContactoByDesCorreoElectronicoAndCveIdUsuario(String desCorreoElectronico, Long cveIdUsuario){
		List<BttMedioContacto> bttMedioContacto=bttMedioContactoRepository.findBttMedioContactoByDesCorreoElectronicoAndCveIdUsuario(desCorreoElectronico,cveIdUsuario); 
		return bttMedioContacto;
	}
	
	
	/*
	 * Método de consulta por desCorreoElectronico
	*/
	@Override
	@Transactional
	public List<BttMedioContacto> findBttMedioContactoByDesCorreoElectronicoAndCveIdUsuarioOrderByFecRegistro(String desCorreoElectronico, Long cveIdUsuario){
		List<BttMedioContacto> bttMedioContacto=bttMedioContactoRepository.findBttMedioContactoByDesCorreoElectronicoAndCveIdUsuarioOrderByFecRegistro(desCorreoElectronico,cveIdUsuario); 
		return bttMedioContacto;
	}


	@Override
	@Transactional
	public List<BttMedioContacto> findBttMedioContactoCorreoByCveIdUsuarioAndFecBajaNull(Long cveIdUsuario){
		List<BttMedioContacto> bttMedioContacto=bttMedioContactoRepository.findBttMedioContactoCorreoByCveIdUsuarioAndFecBajaNull(cveIdUsuario);
		return bttMedioContacto;
	}

	
	@Override
	@Transactional
	public List<BttMedioContacto> findBttMedioContactoByDesCorreoElectronicoAndCveIdUsuarioAndFecBajaNull(String desCorreoElectronico, Long cveIdUsuario){
		List<BttMedioContacto> bttMedioContacto=bttMedioContactoRepository.findBttMedioContactoByDesCorreoElectronicoAndCveIdUsuarioAndFecBajaNull(desCorreoElectronico,cveIdUsuario); 
		return bttMedioContacto;
	}
	
	@Override
	@Transactional
	public List<BttMedioContacto> findBttMedioContactoByCveIdUsuarioAndFecBajaNull(Long cveIdUsuario){
		List<BttMedioContacto> bttMedioContacto=bttMedioContactoRepository.findBttMedioContactoByCveIdUsuarioAndFecBajaNull(cveIdUsuario); 
		return bttMedioContacto;
	}
	
	
	@Override
	@Transactional
	public List<BttMedioContacto> findBttMedioContactoByDesCorreoElectronicoAndCveIdUsuarioAndFecBajaNullRFC(String desCorreoElectronico, Long cveIdUsuario){
		List<BttMedioContacto> bttMedioContacto=bttMedioContactoRepository.findBttMedioContactoByDesCorreoElectronicoAndCveIdUsuarioAndFecBajaNullRFC(desCorreoElectronico,cveIdUsuario); 
		return bttMedioContacto;
	}
	
	
	
	
	/*
	 * Método de consulta por desTelefono
	*/
	@Override
	@Transactional
	public List<BttMedioContacto> findBttMedioContactoByDesTelefono(String desTelefono){
		List<BttMedioContacto> bttMedioContacto=bttMedioContactoRepository.findBttMedioContactoByDesTelefono(desTelefono); 
		return bttMedioContacto;
	}

	/*
	 * Método de consulta por btcEstatusMedioContacto
	*/
	@Override
	@Transactional
	public List<BttMedioContacto> findBttMedioContactoByBtcEstatusMedioContacto(BtcEstatusMedioContacto btcEstatusMedioContacto){
		List<BttMedioContacto> bttMedioContacto=bttMedioContactoRepository.findBttMedioContactoByBtcEstatusMedioContacto(btcEstatusMedioContacto); 
		return bttMedioContacto;
	}

	/*
	 * Método de consulta por fecConfirmacion
	*/
	@Override
	@Transactional
	public List<BttMedioContacto> findBttMedioContactoByFecConfirmacion(Date fecConfirmacion){
		List<BttMedioContacto> bttMedioContacto=bttMedioContactoRepository.findBttMedioContactoByFecConfirmacion(fecConfirmacion); 
		return bttMedioContacto;
	}

	/*
	 * Método de consulta por fecBaja
	*/
	@Override
	@Transactional
	public List<BttMedioContacto> findBttMedioContactoByFecBaja(Date fecBaja){
		List<BttMedioContacto> bttMedioContacto=bttMedioContactoRepository.findBttMedioContactoByFecBaja(fecBaja); 
		return bttMedioContacto;
	}

	/*
	 * Método de consulta por desAclaracion
	*/
	@Override
	@Transactional
	public List<BttMedioContacto> findBttMedioContactoByDesAclaracion(String desAclaracion){
		List<BttMedioContacto> bttMedioContacto=bttMedioContactoRepository.findBttMedioContactoByDesAclaracion(desAclaracion); 
		return bttMedioContacto;
	}

	/*
	 * Método de consulta por fecSolicitudAclaracion
	*/
	@Override
	@Transactional
	public List<BttMedioContacto> findBttMedioContactoByFecSolicitudAclaracion(Date fecSolicitudAclaracion){
		List<BttMedioContacto> bttMedioContacto=bttMedioContactoRepository.findBttMedioContactoByFecSolicitudAclaracion(fecSolicitudAclaracion); 
		return bttMedioContacto;
	}

	/*
	 * Método de consulta por cveIdUsuario
	*/
	@Override
	@Transactional
	public List<BttMedioContacto> findBttMedioContactoByCveIdUsuario(Long cveIdUsuario){
		List<BttMedioContacto> bttMedioContacto=bttMedioContactoRepository.findBttMedioContactoByCveIdUsuario(cveIdUsuario); 
		return bttMedioContacto;
	}
	
	
	/*
	 * Método de consulta por cveIdUsuario
	*/
	@Override
	@Transactional
	public Page<BttMedioContacto> findBttMedioContactoByCveIdUsuario(Long cveIdUsuario,Pageable pageable){
		Page<BttMedioContacto> bttMedioContacto=bttMedioContactoRepository.findBttMedioContactoByCveIdUsuario(cveIdUsuario,pageable); 
		return bttMedioContacto;
	}
	
	
	/*
	 * Método de consulta por cveIdUsuario incluidos los que estan en baja
	*/
	@Override
	@Transactional
	public Page<BttMedioContacto> findBttMedioContactoByCveIdUsuarioAll(Long cveIdUsuario,Pageable pageable){
		Page<BttMedioContacto> bttMedioContacto=bttMedioContactoRepository.findBttMedioContactoByCveIdUsuarioAll(cveIdUsuario,pageable); 
		return bttMedioContacto;
	}
	
	
	/*
	 * Método de consulta por cveIdUsuario incluidos los que estan en baja
	*/
	@Override
	@Transactional
	public Page<BttMedioContacto> findBttMedioContactoByCveIdUsuarioAllAutorizado(Long cveIdUsuario,Pageable pageable){
		Page<BttMedioContacto> bttMedioContacto=bttMedioContactoRepository.findBttMedioContactoByCveIdUsuarioAllAutorizado(cveIdUsuario,pageable); 
		return bttMedioContacto;
	}
	
	
	

	/*
	 * Método para guardar BttMedioContacto
	*/
	@Override
	@Transactional
	public BttMedioContacto saveBttMedioContacto(BttMedioContacto bttMedioContacto) {
		BttMedioContacto existingBttMedioContacto=bttMedioContactoRepository.findBttMedioContactoByCveIdMedioContacto(bttMedioContacto.getCveIdMedioContacto());


		if (existingBttMedioContacto != null){ 
			if (existingBttMedioContacto != bttMedioContacto){ 
				existingBttMedioContacto.setCveIdMedioContacto(bttMedioContacto.getCveIdMedioContacto());
				existingBttMedioContacto.setDesFolio(bttMedioContacto.getDesFolio());
				existingBttMedioContacto.setFecRegistro(bttMedioContacto.getFecRegistro());
				existingBttMedioContacto.setDesCorreoElectronico(bttMedioContacto.getDesCorreoElectronico());
				existingBttMedioContacto.setDesTelefono(bttMedioContacto.getDesTelefono());
				existingBttMedioContacto.setDesCodigoVerificacion(bttMedioContacto.getDesCodigoVerificacion());
				existingBttMedioContacto.setBtcEstatusMedioContacto(bttMedioContacto.getBtcEstatusMedioContacto());
				existingBttMedioContacto.setFecConfirmacion(bttMedioContacto.getFecConfirmacion());
				existingBttMedioContacto.setFecBaja(bttMedioContacto.getFecBaja());
				existingBttMedioContacto.setDesAclaracion(bttMedioContacto.getDesAclaracion());
				existingBttMedioContacto.setFecSolicitudAclaracion(bttMedioContacto.getFecSolicitudAclaracion());
				existingBttMedioContacto.setCveIdUsuario(bttMedioContacto.getCveIdUsuario());
				bttMedioContacto = bttMedioContactoRepository.save(existingBttMedioContacto);
			}
			
		} else {
		bttMedioContacto = bttMedioContactoRepository.save(bttMedioContacto);
		}
	return bttMedioContacto;
	}

	/*
	 * Método para eliminar BttMedioContacto existente
	*/
	@Override
	@Transactional
	public void deleteBttMedioContacto(BttMedioContacto bttMedioContacto) {
			bttMedioContactoRepository.delete(bttMedioContacto);
	}
	
	
	
	@Override
	@Transactional
	public void eliminarBttMedioContacto(BttMedioContacto bttMedioContacto) {
		logger.info("eliminarBttMedioContacto" );

		 
		//debe generar el acuse en este punto
		bttMedioContacto= bttMedioContactoService.findBttMedioContactoByCveIdMedioContacto(bttMedioContacto.getCveIdMedioContacto());
        if (bttMedioContacto != null) {
        	logger.info("encontro el medio de contacto" +bttMedioContacto.toString() );
        	if(bttMedioContacto.getFecBaja()==null &&  bttMedioContacto.getFecConfirmacion()!=null  ) {
        		logger.info("encontro el medio de contacto que ya estaba confirmado"   );
        		Date fechaActual=new Date();
        		bttMedioContacto.setFecBaja(fechaActual);
        		BtcEstatusMedioContacto btcEstatusMedioContacto=btcEstatusMedioContactoService.findBtcEstatusMedioContactoByCveIdEstatusMedioContacto(4L);//4=esatus eliminado
        		bttMedioContacto.setBtcEstatusMedioContacto(btcEstatusMedioContacto);
        		bttMedioContactoService.saveBttMedioContacto(bttMedioContacto);
        		 
        		 
        		String desFolio= utileriasService.getFolioPrefijo("BIO-", fechaActual);
        		bttMedioContacto.setDesFolioBaja(desFolio);
        		
        		//bttMedioContacto=bttMedioContactoService.saveBttMedioContacto(bttMedioContacto);
        		
        		String correo = bttMedioContacto.getDesCorreoElectronico() ;
        		String folio =bttMedioContacto.getDesFolio(); 
        		Map<String, String> parametrosCorreo = new HashMap<>();
        		parametrosCorreo.put("correo", correo);
        		parametrosCorreo.put("folio baja", folio);

        		 
        		
        		
        			
        			BitUsuario bitUsuario=bitUsuarioService.findBitUsuarioByCveIdUsuario(bttMedioContacto.getCveIdUsuario());
        			String desRfc=bitUsuario.getDesRfc();
        			String razonsocial=bitUsuario.getDesNombre();
        			//Nota de nonde se obtiene la curp
        			String curp=utileriasService.getValorNotNull(bitUsuario.getDesCurp()) ;
        			String registrosPatronales="";
        			
        			List<BttPatronMedioContacto> bttPatronMedioContactos=bttMedioContacto.getBttPatronMedioContactos();
        			for(BttPatronMedioContacto bttPatronMedioContacto:bttPatronMedioContactos) {
        				registrosPatronales=registrosPatronales+ bttPatronMedioContacto.getBttPatron().getRegistroPatronal() + ", ";
        				
        			}
        			
    		        if(registrosPatronales.length()>2) {
    		        	//elimina la ultima coma de la lista de RPs
    		           registrosPatronales=registrosPatronales.substring(0, registrosPatronales.length()-2);
    		        }
        			
    		        String desPathAcuseValidacion="";
    		        if(bttMedioContacto.getBtcTipoMedioContacto().getCveIdTipoMedioContacto().equals(1L)) {
    		        	//si es correo genera acuse
    		        	desPathAcuseValidacion=bttMedioContactoService.acuseBajaMedioContacto(folio, desRfc,razonsocial, curp, registrosPatronales,bitUsuario, bttMedioContacto.getDesCorreoElectronico(),fechaActual);
    		        	
    		        } else   if(bttMedioContacto.getBtcTipoMedioContacto().getCveIdTipoMedioContacto().equals(2L)) {
    		        	//si es teléfono genera acuse
    		        	desPathAcuseValidacion=bttMedioContactoService.acuseBajaMedioContactoTelefono(folio, desRfc,razonsocial, curp, registrosPatronales,bitUsuario, bttMedioContacto.getDesCorreoElectronico(),fechaActual);
    		        	
    		        }
        			

        			
        			
        			bttMedioContacto= bttMedioContactoService.findBttMedioContactoByCveIdMedioContacto(bttMedioContacto.getCveIdMedioContacto());
        			bttMedioContacto.setDesPathAcuseBaja(desPathAcuseValidacion);
        			//registra la referencia del acuse de validacion
        			bttMedioContacto=bttMedioContactoService.saveBttMedioContacto(bttMedioContacto);
            		
        			 
        			
        	
        		
        	}else {
        		logger.info("encontro el medio de contacto no esta confirmado lo elimina permanente mente"   );
        		//como no esta confirmado no genera ningun acuse lo elimina permanente mente
        		 
        		bttMedioContactoService.deleteBttMedioContacto(bttMedioContacto);
        		
        	}
        	
         
        	
        	
         
        }else {
        	logger.info("no encontro el medio de contacto para eliminar"  );
        }
		
	}
	
	

	

	/*
	 * Método de consulta findAll
	*/
	@Override
	
	public boolean cancelaMediosContacto(){
		//cancela los medios de contacto no confirmados en 72 horas
		logger.info("cancela los medios de contacto no confirmados en 72 horas");
		BtcEstatusMedioContacto btcEstatusMedioContactoAux=new BtcEstatusMedioContacto();
		
		btcEstatusMedioContactoAux=btcEstatusMedioContactoService.findBtcEstatusMedioContactoByCveIdEstatusMedioContacto(1L);//1=Pendientes
    	String patternFecha = "yyyy/MM/dd HH:mm";
		SimpleDateFormat simpleDateFormatFecha = new SimpleDateFormat(patternFecha,new Locale("es", "MX"));
		//consulta todos los medios de contacto pendientes de confirmar
		List<BttMedioContacto> bttMedioContactos=bttMedioContactoRepository.findBttMedioContactoByBtcEstatusMedioContacto(btcEstatusMedioContactoAux);
		for(BttMedioContacto bttMedioContacto:bttMedioContactos) {
			//verifica si el medio de contacto tiene fecha de confirmación null
			if(bttMedioContacto.getFecConfirmacion()==null) {
				 
				
				
 
        		Date FEC_REGISTRO=bttMedioContacto.getFecRegistro();
        		Date fecFinal=sumarRestarHorasFecha(FEC_REGISTRO, 72);//deben ser mayor a 72 horas
         
        		String des_correo_electronico=bttMedioContacto.getDesCorreoElectronico();  

        		if(fecFinal.compareTo(new Date())>0) {
        			// si la fecha final es menor a la actual no debe realizar la autorizacion automatica de la notificación
        			//logger.info("No cancela el medio de contacto");
        		}else {
        			logger.info("Si cancela el registro del medio de contacto medio de contacto");
            		logger.info(bttMedioContacto.getCveIdMedioContacto() + " des_correo_electronico: " + des_correo_electronico);
            		logger.info("FEC_REGISTRO: " + simpleDateFormatFecha.format(FEC_REGISTRO) + " fecFinal: " +  simpleDateFormatFecha.format(fecFinal));
        		    eliminarBttMedioContacto(bttMedioContacto);
        		 
        		}
				
				
			}
		}
		return true;
	}

	



    public Date sumarRestarHorasFecha(Date fecha, int horas){
	      Calendar calendar = Calendar.getInstance();
	      calendar.setTime(fecha); // Configuramos la fecha que se recibe
	      calendar.add(Calendar.HOUR, horas);  // numero de horas a añadir, o restar en caso de horas<0
	      return calendar.getTime(); // Devuelve el objeto Date con las nuevas horas añadidas
	 }


    
    
    
    
	@Override 
	@Transactional
	public String acuseValidacionMedioContacto(String folio, String desRfc,String razonsocial,String curp, String registrosPatronales, BitUsuario bitUsuario, String correo, Date fechaActual ) throws Exception {
		
        logger.info("acuseValidacionMedioContacto");
		String referenciaAcuse="";
		//genera el acuse de aceptación del uso del buzon
		String path = this.getClass().getClassLoader().getResource("").getPath();
        path += "templates/reportes/medioContacto/";
        String sourceFileName = path + "acuse_validacion_medio_contacto.jrxml"; 
        Map<String, Object> parameters = new HashMap<String, Object>();
       // SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy",new Locale("es", "MX")); 
        parameters.put("path", path);
    	parameters.put("logo1", path + "logo1.png");
		parameters.put("logo2", path + "logo2.png"); 
		parameters.put("logo3", path + "logo3.png"); 

        
        razonsocial=bitUsuario.getDesNombre() + " " + (bitUsuario.getDesPrimerApellido()==null? "":bitUsuario.getDesPrimerApellido() )+ " " + (bitUsuario.getDesSegundoApellido()==null? "":bitUsuario.getDesSegundoApellido() );
 

        String parrafo1="Información del mecanismo de comunicación validado:\n" +
        		"\r\n" + 
        		"Correo electrónico registrado: {correo}\r\n" +
        		"Estatus de registro: Validado\r\n" + 
        		"\r\n" + 
        		"El particular se encuentra obligado a guardar absoluta y estricta confidencialidad de la información que conoce con motivo del uso del Buzón IMSS,  asimismo sabe las responsabilidades civiles y penales a las que se hará acreedor al quebrantar la citada reserva, así como al modificar, copiar, utilizar o sustraer información que vaya en perjuicio de la autoridad.\r\n" ; 
        		//"\r\n" + 
        		//"Sus datos personales son incorporados y protegidos en los sistemas del IMSS, los cuales constituyen información reservada  y confidencial en los términos del código fiscal de la federación vigente  y las leyes sobre su transparencia y acceso a la información pública, así como de protección de datos personales.\r\n" + 
        		//"";
     
        parrafo1=parrafo1.replace("{correo}", correo); 
        parameters.put("razonsocial", razonsocial); 
        parameters.put("parrafo1", parrafo1); 
        parameters.put("rfc", desRfc); 
        parameters.put("folio", folio); 
        

        
        parameters.put("registrosPatronales", registrosPatronales);
        
        logger.info("registrosPatronales: " + registrosPatronales);
        
        parameters.put("curp", curp);
        JSONObject jsonWidget = new JSONObject();
       // Date fechaActual = new Date();
       
        SimpleDateFormat formateador = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy HH:mm:ss 'hrs.'",new Locale("es", "MX")); 
        parameters.put("fechaRegistro", "Fecha: " + formateador.format(fechaActual)); 
       // try {

            FirmaElectronicaSegService service = new FirmaElectronicaSegService();
            FirmaElectronicaSegPortType portType = service.getFirmaElectronicaSegPortTypePort();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS",new Locale("es", "MX"));
            String fechafolio = sdf.format(fechaActual);

            String cadenaOriginal = "|Versión:2|Rfc:"+desRfc+"|Tipo+de+trámite:Medio+Contacto+Validado|Folio+del+trámite:"+folio+"|Fecha+de+elaboración:"+fechafolio+"|";

            jsonWidget.put("rfc",desRfc);
           // jsonWidget.put("aplicacion","AplPruebas");
            jsonWidget.put("aplicacion","AplBuzonIMSS");
            jsonWidget.put("id_llavefirma","IMSS_CSD_01");
            jsonWidget.put("cadenaoriginal",cadenaOriginal);

			System.out.println(jsonWidget.toString());

            //Se genera la imagen QR de la cadenaOriginal
            BufferedImage image = utileriasService.generaQRImage(cadenaOriginal);
            parameters.put("image",image);

            FirmaSimpleRequestType request = new FirmaSimpleRequestType();
            request.setJsonParms(jsonWidget.toString());
            FirmaSimpleResponseType response = portType.firmaSimple(request);

            String respuesta = response.getJsonSalida();

            logger.info("salida: "+respuesta);

            JSONObject objetoJson = new JSONObject(respuesta);

            parameters.put("cadenaOriginal", cadenaOriginal);
            parameters.put("selloDigital", objetoJson.get("sello"));


            JasperCompileManager.compileReportToFile(sourceFileName);
            sourceFileName = path + "acuse_validacion_medio_contacto.jasper";

            JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(sourceFileName);
            JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters,  new JREmptyDataSource());
            if (jasperPrint != null) {

            	
				    byte[] pdfReport = JasperExportManager.exportReportToPdf(jasperPrint);
				    //String contentType = "application/pdf"; 
					//SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyyMMddHHmmss",new Locale("es", "MX"));
					 
				    
					//Creala la ubicación del archivo en el hdfs para registrarlo para su consulta posterior
					SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyyMMddHHmmssSSS",new Locale("es", "MX"));
					SimpleDateFormat formatoAuxiliarnom = new SimpleDateFormat("ssSSS",new Locale("es", "MX"));
					String identificador=bitUsuario.getCveIdUsuario()+ formatoAuxiliarnom.format(new Date());
					
					String pathHdfs= "acuse/";
					String nombreArchivo = "acuse_validacion_medio_contacto_correo" + formatoFecha.format(fechaActual) + identificador +".pdf";
					//String nombreLink=utileriasService.encriptar(pathHdfs+ "/" + nombreArchivo);
				    
				    //	String nombreArchivo = "acuse_aceptacion" + formatoFecha.format(new Date()) + ".pdf";
					logger.info("nombreArchivo" + nombreArchivo);
					//pathHdfs= "/contenedor/acuse";
				//	utileriasService.saveDocumentoHdfs(pdfReport, pathHdfs,nombreArchivo); 
				//	BttContenedor bttcontenedor =bttContenedorService.guardarReferenciaArchivoContenedor(pathHdfs, nombreArchivo, desRfc,fechaActual); 
				//	referenciaAcuse= bttcontenedor.getDesUrl();
					

            }
    //    } catch (Exception e) {
     //       e.printStackTrace();
    //    }
        
        return referenciaAcuse;
	}
	
	

	@Override 
	public String acuseBajaMedioContacto(String folio, String desRfc,String razonsocial,String curp, String registrosPatronales, BitUsuario bitUsuario, String correo, Date fechaActual ) {
		
        logger.info("acuseBajaMedioContacto");
		String referenciaAcuse="";
		//genera el acuse de aceptación del uso del buzon
		String path = this.getClass().getClassLoader().getResource("").getPath();
        path += "templates/reportes/medioContacto/";
        String sourceFileName = path + "acuse_baja_medio_contacto.jrxml"; 
        Map<String, Object> parameters = new HashMap<String, Object>();
       // SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy",new Locale("es", "MX")); 
        parameters.put("path", path);
    	parameters.put("logo1", path + "logo1.png");
		parameters.put("logo2", path + "logo2.png"); 
		parameters.put("logo3", path + "logo3.png"); 

        
        razonsocial=bitUsuario.getDesNombre() + " " + (bitUsuario.getDesPrimerApellido()==null? "":bitUsuario.getDesPrimerApellido() )+ " " + (bitUsuario.getDesSegundoApellido()==null? "":bitUsuario.getDesSegundoApellido() );
 
 
        String parrafo1="Información sobre el mecanismo de comunicación registrado y/o actualizado \r\n" +
        		"\r\n" + 
        		"Correo electrónico registrado: {correo}\r\n" + 
        		"Estatus de registro: Baja.\r\n" + 
        		"\r\n" + 
        		"El usuario se encuentra obligado a guardar absoluta y estricta confidencialidad de la información que conozco con motivo del uso del buzón IMSS, así de como las responsabilidades civiles y penales a las que me hare acreedor al quebrantar la citada reserva, así como al modificar, copiar, utilizar o sustraer información que vaya en el perjuicio de la autoridad.\r\n" ; 
        		//"\r\n" + 
        		//"Sus datos personales son incorporados y protegidos en los sistemas del IMSS, los cuales constituyen información reservada  y confidencial en los términos del código fiscal de la federación vigente  y las leyes sobre su transparencia y acceso a la información pública, así como de protección de datos personales.\r\n" + 
        		//"";
     
        parrafo1=parrafo1.replace("{correo}", correo); 
        parameters.put("razonsocial", razonsocial); 
        parameters.put("parrafo1", parrafo1); 
        parameters.put("rfc", desRfc); 
        parameters.put("folio", folio); 
        

        
        parameters.put("registrosPatronales", registrosPatronales);
        
        logger.info("registrosPatronales: " + registrosPatronales);
        
        parameters.put("curp", curp);
        JSONObject jsonWidget = new JSONObject();
       // Date fechaActual = new Date();
       
        SimpleDateFormat formateador = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy HH:mm:ss 'hrs.'",new Locale("es", "MX")); 
        parameters.put("fechaRegistro", "Fecha: " + formateador.format(fechaActual)); 
        try {

            FirmaElectronicaSegService service = new FirmaElectronicaSegService();
            FirmaElectronicaSegPortType portType = service.getFirmaElectronicaSegPortTypePort();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS",new Locale("es", "MX"));
            String fechafolio = sdf.format(fechaActual);

            String cadenaOriginal = "|Versión:2|Rfc:"+desRfc+"|Tipo+de+trámite:Medio+Contacto+Baja|Folio+del+trámite:"+folio+"|Fecha+de+elaboración:"+fechafolio+"|";

            jsonWidget.put("rfc",desRfc);
           // jsonWidget.put("aplicacion","AplPruebas");
            jsonWidget.put("aplicacion","AplBuzonIMSS");
            jsonWidget.put("id_llavefirma","IMSS_CSD_01");
            jsonWidget.put("cadenaoriginal",cadenaOriginal);

            //Se genera la imagen QR de la cadenaOriginal
            BufferedImage image = utileriasService.generaQRImage(cadenaOriginal);
            parameters.put("image",image);

            FirmaSimpleRequestType request = new FirmaSimpleRequestType();
            request.setJsonParms(jsonWidget.toString());
            FirmaSimpleResponseType response = portType.firmaSimple(request);

            String respuesta = response.getJsonSalida();

            logger.info("salida: "+respuesta);

            JSONObject objetoJson = new JSONObject(respuesta);

            parameters.put("cadenaOriginal", cadenaOriginal);
            parameters.put("selloDigital", objetoJson.get("sello"));


            JasperCompileManager.compileReportToFile(sourceFileName);
            sourceFileName = path + "acuse_baja_medio_contacto.jasper";

            JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(sourceFileName);
            JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters,  new JREmptyDataSource(1));
            if (jasperPrint != null) {

            	
				    byte[] pdfReport = JasperExportManager.exportReportToPdf(jasperPrint);
				    //String contentType = "application/pdf"; 
					//SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyyMMddHHmmss",new Locale("es", "MX"));
					 
				    
					//Creala la ubicación del archivo en el hdfs para registrarlo para su consulta posterior
					SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyyMMddHHmmssSSS",new Locale("es", "MX"));
					SimpleDateFormat formatoAuxiliarnom = new SimpleDateFormat("ssSSS",new Locale("es", "MX"));
					String identificador=bitUsuario.getCveIdUsuario()+ formatoAuxiliarnom.format(new Date());
					String pathHdfs= "acuse/";
					String nombreArchivo = "acuse_baja_medio_contacto" + formatoFecha.format(fechaActual) + identificador + ".pdf";
					//String nombreLink=utileriasService.encriptar(pathHdfs+ "/" + nombreArchivo);
				    
				    //	String nombreArchivo = "acuse_aceptacion" + formatoFecha.format(new Date()) + ".pdf";
					logger.info("nombreArchivo" + nombreArchivo);
					//pathHdfs= "/contenedor/acuse";
				//	utileriasService.saveDocumentoHdfs(pdfReport, pathHdfs,nombreArchivo); 
					//BttContenedor bttcontenedor =bttContenedorService.guardarReferenciaArchivoContenedor(pathHdfs, nombreArchivo, desRfc,fechaActual); 
				//	referenciaAcuse= bttcontenedor.getDesUrl();
					

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return referenciaAcuse;
	}
	
	
	
	
	

	@Override 
	public String acuseValidacionMedioContactoTelefono(String folio, String desRfc,String razonsocial,String curp, String registrosPatronales, BitUsuario bitUsuario, String telefono, Date fechaActual) throws Exception{
		
        logger.info("acuseValidacionMedioContactoTelefono telefono");
		String referenciaAcuse="";
		//genera el acuse de aceptación del uso del buzon
		String path = this.getClass().getClassLoader().getResource("").getPath();
        path += "templates/reportes/medioContacto/";
        String sourceFileName = path + "acuse_validacion_medio_contacto.jrxml"; 
        Map<String, Object> parameters = new HashMap<String, Object>();
       
        parameters.put("path", path);
    	parameters.put("logo1", path + "logo1.png");
		parameters.put("logo2", path + "logo2.png"); 
		parameters.put("logo3", path + "logo3.png"); 

        
        razonsocial=bitUsuario.getDesNombre() + " " + (bitUsuario.getDesPrimerApellido()==null? "":bitUsuario.getDesPrimerApellido() )+ " " + (bitUsuario.getDesSegundoApellido()==null? "":bitUsuario.getDesSegundoApellido() );
 
 
        String parrafo1="Información del mecanismo de comunicación validado:\n" +
        		"\r\n" + 
        		"Número de teléfono celular: {telefono}\r\n" +
        		"Estatus de registro: Validado\r\n" + 
        		"\r\n" + 
        		"El particular se encuentra obligado a guardar absoluta y estricta confidencialidad de la información que conoce con motivo del uso del Buzón IMSS,  asimismo sabe las responsabilidades civiles y penales a las que se hará acreedor al quebrantar la citada reserva, así como al modificar, copiar, utilizar o sustraer información que vaya en perjuicio de la autoridad.\r\n" ; 
          		//"\r\n" + 
        		//"Sus datos personales son incorporados y protegidos en los sistemas del IMSS, los cuales constituyen información reservada  y confidencial en los términos del código fiscal de la federación vigente  y las leyes sobre su transparencia y acceso a la información pública, así como de protección de datos personales.\r\n" + 
        		//"";
     
        
        parrafo1=parrafo1.replace("{telefono}", telefono); 
        parameters.put("razonsocial", razonsocial); 
        parameters.put("parrafo1", parrafo1); 
        parameters.put("rfc", desRfc); 
        parameters.put("folio", folio); 
         
        SimpleDateFormat formateador = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy HH:mm:ss 'hrs.'",new Locale("es", "MX")); 
        parameters.put("fechaRegistro", "Fecha: " + formateador.format(fechaActual)); 
        

        
        parameters.put("registrosPatronales", registrosPatronales);
        
        logger.info("registrosPatronales: " + registrosPatronales);
        
        parameters.put("curp", curp);
        JSONObject jsonWidget = new JSONObject();
       // Date fechaActual = new Date();
       

     //   try {

            FirmaElectronicaSegService service = new FirmaElectronicaSegService();
            FirmaElectronicaSegPortType portType = service.getFirmaElectronicaSegPortTypePort();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS",new Locale("es", "MX"));
            String fechafolio = sdf.format(fechaActual);

            String cadenaOriginal = "|Versión:2|Rfc:"+desRfc+"|Tipo+de+trámite:Medio+Contacto+Validado|Folio+del+trámite:"+folio+"|Fecha+de+elaboración:"+fechafolio+"|";

            jsonWidget.put("rfc",desRfc);
          //  jsonWidget.put("aplicacion","AplPruebas");
            jsonWidget.put("aplicacion","AplBuzonIMSS");
            jsonWidget.put("id_llavefirma","IMSS_CSD_01");
            jsonWidget.put("cadenaoriginal",cadenaOriginal);

            //Se genera la imagen QR de la cadenaOriginal
            BufferedImage image = utileriasService.generaQRImage(cadenaOriginal);
            parameters.put("image",image);

            FirmaSimpleRequestType request = new FirmaSimpleRequestType();
            request.setJsonParms(jsonWidget.toString());
            FirmaSimpleResponseType response = portType.firmaSimple(request);

            String respuesta = response.getJsonSalida();

            logger.info("salida: "+respuesta);

            JSONObject objetoJson = new JSONObject(respuesta);

            parameters.put("cadenaOriginal", cadenaOriginal);
            parameters.put("selloDigital", objetoJson.get("sello"));


            JasperCompileManager.compileReportToFile(sourceFileName);
            sourceFileName = path + "acuse_validacion_medio_contacto.jasper";

            JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(sourceFileName);
            JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters,  new JREmptyDataSource(1));
            if (jasperPrint != null) {

            	
				    byte[] pdfReport = JasperExportManager.exportReportToPdf(jasperPrint);
				    //String contentType = "application/pdf"; 
					//SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyyMMddHHmmss",new Locale("es", "MX"));
					 
				    
					//Creala la ubicación del archivo en el hdfs para registrarlo para su consulta posterior
					SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyyMMddHHmmssSSS",new Locale("es", "MX"));
					SimpleDateFormat formatoAuxiliarnom = new SimpleDateFormat("ssSSS",new Locale("es", "MX"));
					String identificador=bitUsuario.getCveIdUsuario()+ formatoAuxiliarnom.format(new Date());
					String pathHdfs= "acuse/";
					String nombreArchivo = "acuse_validacion_medio_contacto_tel" + formatoFecha.format(fechaActual) + identificador + ".pdf";
					//String nombreLink=utileriasService.encriptar(pathHdfs+ "/" + nombreArchivo);
				    
				    //	String nombreArchivo = "acuse_aceptacion" + formatoFecha.format(new Date()) + ".pdf";
					logger.info("nombreArchivo" + nombreArchivo);
					//pathHdfs= "/contenedor/acuse";
					//utileriasService.saveDocumentoHdfs(pdfReport, pathHdfs,nombreArchivo); 
					//BttContenedor bttcontenedor =bttContenedorService.guardarReferenciaArchivoContenedor(pathHdfs, nombreArchivo, desRfc,fechaActual); 
					//referenciaAcuse= bttcontenedor.getDesUrl();
					

            }
     //   } catch (Exception e) {
     //       e.printStackTrace();
    //    }
        
        return referenciaAcuse;
	}
	
	
    


	@Override 
	public String acuseBajaMedioContactoTelefono(String folio, String desRfc,String razonsocial,String curp, String registrosPatronales, BitUsuario bitUsuario, String telefono, Date fechaActual) {
		
        logger.info("acuseBajaMedioContactoTelefono telefono");
		String referenciaAcuse="";
		//genera el acuse de aceptación del uso del buzon
		String path = this.getClass().getClassLoader().getResource("").getPath();
        path += "templates/reportes/medioContacto/";
        String sourceFileName = path + "acuse_baja_medio_contacto.jrxml"; 
        Map<String, Object> parameters = new HashMap<String, Object>();
       
        parameters.put("path", path);
    	parameters.put("logo1", path + "logo1.png");
		parameters.put("logo2", path + "logo2.png"); 
		parameters.put("logo3", path + "logo3.png"); 

        
        razonsocial=bitUsuario.getDesNombre() + " " + (bitUsuario.getDesPrimerApellido()==null? "":bitUsuario.getDesPrimerApellido() )+ " " + (bitUsuario.getDesSegundoApellido()==null? "":bitUsuario.getDesSegundoApellido() );
 
 
        String parrafo1="Información sobre el mecanismo de comunicación registrado y/o actualizado \r\n" +
        		"\r\n" + 
        		"Número telefónico registrado: {telefono}\r\n" + 
        		"Estatus de registro: Baja.\r\n" + 
        		"\r\n" + 
        		"El usuario se encuentra obligado a guardar absoluta y estricta confidencialidad de la información que conozco con motivo del uso del buzón IMSS, así de como las responsabilidades civiles y penales a las que me hare acreedor al quebrantar la citada reserva, así como al modificar, copiar, utilizar o sustraer información que vaya en el perjuicio de la autoridad.\r\n"; 
        		//"\r\n" + 
        		//"Sus datos personales son incorporados y protegidos en los sistemas del IMSS, los cuales constituyen información reservada  y confidencial en los términos del código fiscal de la federación vigente  y las leyes sobre su transparencia y acceso a la información pública, así como de protección de datos personales.\r\n" + 
        		//"";
     
        
        parrafo1=parrafo1.replace("{telefono}", telefono); 
        parameters.put("razonsocial", razonsocial); 
        parameters.put("parrafo1", parrafo1); 
        parameters.put("rfc", desRfc); 
        parameters.put("folio", folio); 
         
        SimpleDateFormat formateador = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy HH:mm:ss 'hrs.'",new Locale("es", "MX")); 
        parameters.put("fechaRegistro", "Fecha: " + formateador.format(fechaActual)); 
        

        
        parameters.put("registrosPatronales", registrosPatronales);
        
        logger.info("registrosPatronales: " + registrosPatronales);
        
        parameters.put("curp", curp);
        JSONObject jsonWidget = new JSONObject();
       // Date fechaActual = new Date();
       

        try {

            FirmaElectronicaSegService service = new FirmaElectronicaSegService();
            FirmaElectronicaSegPortType portType = service.getFirmaElectronicaSegPortTypePort();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS",new Locale("es", "MX"));
            String fechafolio = sdf.format(fechaActual);

            String cadenaOriginal = "|Versión:2|Rfc:"+desRfc+"|Tipo+de+trámite:Medio+Contacto+Baja|Folio+del+trámite:"+folio+"|Fecha+de+elaboración:"+fechafolio+"|";

            jsonWidget.put("rfc",desRfc);
            //jsonWidget.put("aplicacion","AplPruebas");
            jsonWidget.put("aplicacion","AplBuzonIMSS");
            jsonWidget.put("id_llavefirma","IMSS_CSD_01");
            jsonWidget.put("cadenaoriginal",cadenaOriginal);

            //Se genera la imagen QR de la cadenaOriginal
            BufferedImage image = utileriasService.generaQRImage(cadenaOriginal);
            parameters.put("image",image);

            FirmaSimpleRequestType request = new FirmaSimpleRequestType();
            request.setJsonParms(jsonWidget.toString());
            FirmaSimpleResponseType response = portType.firmaSimple(request);

            String respuesta = response.getJsonSalida();

            logger.info("salida: "+respuesta);

            JSONObject objetoJson = new JSONObject(respuesta);

            parameters.put("cadenaOriginal", cadenaOriginal);
            parameters.put("selloDigital", objetoJson.get("sello"));


            JasperCompileManager.compileReportToFile(sourceFileName);
            sourceFileName = path + "acuse_baja_medio_contacto.jasper";

            JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(sourceFileName);
            JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters,  new JREmptyDataSource(1));
            if (jasperPrint != null) {

            	
				    byte[] pdfReport = JasperExportManager.exportReportToPdf(jasperPrint);
				    //String contentType = "application/pdf"; 
					//SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyyMMddHHmmss",new Locale("es", "MX"));
					 
				    
					//Creala la ubicación del archivo en el hdfs para registrarlo para su consulta posterior
					SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyyMMddHHmmssSSS",new Locale("es", "MX"));
					SimpleDateFormat formatoAuxiliarnom = new SimpleDateFormat("ssSSS",new Locale("es", "MX"));
					String identificador=bitUsuario.getCveIdUsuario()+ formatoAuxiliarnom.format(new Date());
					String pathHdfs= "acuse/";
					String nombreArchivo = "acuse_validacion_medio_contacto" + formatoFecha.format(fechaActual) + identificador + ".pdf";
					//String nombreLink=utileriasService.encriptar(pathHdfs+ "/" + nombreArchivo);
				    
				    //	String nombreArchivo = "acuse_aceptacion" + formatoFecha.format(new Date()) + ".pdf";
					logger.info("nombreArchivo" + nombreArchivo);
					//pathHdfs= "/contenedor/acuse";
				//	utileriasService.saveDocumentoHdfs(pdfReport, pathHdfs,nombreArchivo); 
				//	BttContenedor bttcontenedor =bttContenedorService.guardarReferenciaArchivoContenedor(pathHdfs, nombreArchivo, desRfc,fechaActual); 
				//	referenciaAcuse= bttcontenedor.getDesUrl();
					

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return referenciaAcuse;
	}
	
	
	
 
	
	
 
 
	

	@Override 
	public boolean medioContactoRegistradoConRFC(BitUsuario bitUsuario,  BttMedioContacto bttMedioContactoRP  ) throws Exception{
		//valida si el medio de contacto esta registrado con el RFC
		boolean estaRegistradoconRFC=false;
		MediosComunicacionVO mediosComunicacionVO=new MediosComunicacionVO(); 
	logger.info("valida si el medio de contacto esta registrado con el RFC");
	logger.info("usuario CveIdUsuario: " + bitUsuario.getCveIdUsuario());
	 List<BttMedioContacto> bttMedioContactos=	bttMedioContactoService.findBttMedioContactoByCveIdUsuario(bitUsuario.getCveIdUsuario());
 
	 for(BttMedioContacto bttMedioContacto: bttMedioContactos) {
		if( bttMedioContacto.getFecBaja()==null && bttMedioContacto.getFecConfirmacion()!=null  ) {
			logger.info("bttMedioContacto: " + bttMedioContacto);
		 
       		
			boolean mediosContactoRFC= bttPatronMedioContactoService.isMedioContactoRfc(bttMedioContacto);
       		logger.info("mediosContactoRFC: " + mediosContactoRFC);
    		
    		if(mediosContactoRFC && bttMedioContacto.getFecBaja() ==null && bttMedioContacto.getFecConfirmacion() !=null) {

				 if(bttMedioContacto.getDesCorreoElectronico().trim().toUpperCase().equals(bttMedioContactoRP.getDesCorreoElectronico().trim().toUpperCase())) {
					 logger.info("el medio de contacto esta registrado con el RFC");
					 estaRegistradoconRFC=true;
				 }
    		  
    		}
    		 
		}
			
	 }
	
	return estaRegistradoconRFC;
	
}
	
	
 
	
 
	
	
	
	

 
 
 
	
	
	
	 
	
	


	@Transactional
	private String acuseRegistroMedioContacto(String folio, String desRfc,String razonsocial, String registrosPatronales, BitUsuario bitUsuario, String correo,Date fechaActual) throws Exception{
		
		logger.info("acuseRegistroMedioContacto");
		String referenciaAcuse="";
		//genera el acuse de aceptación del uso del buzon
		String path = this.getClass().getClassLoader().getResource("").getPath();
        path += "templates/reportes/medioContacto/";
        String sourceFileName = path + "acuse_registro_medio_contacto.jrxml"; 
        Map<String, Object> parameters = new HashMap<String, Object>();
       // SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy",new Locale("es", "MX")); 
        parameters.put("path", path);
		parameters.put("logo1", path + "logo1.png");
		parameters.put("logo2", path + "logo2.png"); 
		parameters.put("logo3", path + "logo3.png"); 

        
        razonsocial=bitUsuario.getDesNombre() + " " + (bitUsuario.getDesPrimerApellido()==null? "":bitUsuario.getDesPrimerApellido() )+ " " + (bitUsuario.getDesSegundoApellido()==null? "":bitUsuario.getDesSegundoApellido() );
 
        String parrafo1="Información del mecanismo de comunicación registrado y/o actualizado\r\n" +
        		"\r\n" + 
        		"Correo electrónico: {correo}\r\n" +
        		"Estatus de registro: En proceso\r\n" + 
        		"\r\n" + 
        		"El particular se encuentra obligado a guardar absoluta y estricta confidencialidad de la información que conoce con motivo del uso del Buzón IMSS,  asimismo sabe las responsabilidades civiles y penales a las que se hará acreedor al quebrantar la citada reserva, así como al modificar, copiar, utilizar o sustraer información que vaya en perjuicio de la autoridad.\r\n";
 
        		//"\r\n" + 
        		//"Sus datos personales son incorporados y protegidos en los sistemas del IMSS, los cuales constituyen información reservada  y confidencial en los términos del código fiscal de la federación vigente  y las leyes sobre su transparencia y acceso a la información pública, así como de protección de datos personales.\r\n" + 
        		//"";
     
        parrafo1=parrafo1.replace("{correo}", correo); 
        parameters.put("razonsocial", razonsocial); 
        parameters.put("parrafo1", parrafo1); 
        parameters.put("rfc", desRfc); 
        parameters.put("folio", folio);

        parameters.put("registrosPatronales", registrosPatronales);
        
        logger.info("registrosPatronales: " + registrosPatronales);
        
        parameters.put("curp", utileriasService.getValorNotNull(bitUsuario.getDesCurp()));
     
//        JSONObject jsonWidget = new JSONObject();
        //se obtiene la fecha de registro del medio de contacto para registrar el folio y enel contenedor la fecha igual
      //  Date fechaActual =bttmediocontacto.getFecRegistro();
        SimpleDateFormat formateador = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy HH:mm:ss 'hrs.'",new Locale("es", "MX")); 
        parameters.put("fechaRegistro", "Fecha: " + formateador.format(fechaActual)); 

     //   try {

        	JSONObject jsonWidget = new JSONObject();
            FirmaElectronicaSegService service = new FirmaElectronicaSegService();
            FirmaElectronicaSegPortType portType = service.getFirmaElectronicaSegPortTypePort();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS",new Locale("es", "MX"));
            String fechafolio = sdf.format(fechaActual);

            String cadenaOriginal = "|Versión:2|Rfc:"+desRfc+"|Tipo+de+trámite:Registro+Medio+Contacto|Folio+del+trámite:"+folio+"|Fecha+de+elaboración:"+fechafolio+"|";

            jsonWidget.put("rfc",desRfc);
           // jsonWidget.put("aplicacion","AplPruebas");
            jsonWidget.put("aplicacion","AplBuzonIMSS");
            jsonWidget.put("id_llavefirma","IMSS_CSD_01");
            jsonWidget.put("cadenaoriginal",cadenaOriginal);

            FirmaSimpleRequestType request = new FirmaSimpleRequestType();
            request.setJsonParms(jsonWidget.toString());
            FirmaSimpleResponseType response = portType.firmaSimple(request);

            String respuesta = response.getJsonSalida();

            logger.info("salida: "+respuesta);

            JSONObject objetoJson = new JSONObject(respuesta);

            parameters.put("cadenaOriginal", cadenaOriginal);
            parameters.put("selloDigital", objetoJson.get("sello"));

            //Se genera la imagen QR de la cadenaOriginal
            BufferedImage image = utileriasService.generaQRImage(cadenaOriginal);
            parameters.put("image",image);
           
            JasperCompileManager.compileReportToFile(sourceFileName);
            sourceFileName = path + "acuse_registro_medio_contacto.jasper";

            JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(sourceFileName);
            JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters,  new JREmptyDataSource(1));
            if (jasperPrint != null) {

            	
				    byte[] pdfReport = JasperExportManager.exportReportToPdf(jasperPrint);
				    //String contentType = "application/pdf"; 
					//SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyyMMddHHmmss",new Locale("es", "MX"));
					 
				    
					//Creala la ubicación del archivo en el hdfs para registrarlo para su consulta posterior
					SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyyMMddHHmmssSSS",new Locale("es", "MX"));
					SimpleDateFormat formatoAuxiliarnom = new SimpleDateFormat("ssSSS",new Locale("es", "MX"));
					String identificador=bitUsuario.getCveIdUsuario()+ formatoAuxiliarnom.format(new Date());
					String pathHdfs= "acuse/";
					String nombreArchivo = "acuse_registro_medio_contacto_correo"+  formatoFecha.format(fechaActual)+ identificador + ".pdf";
					//String nombreLink=utileriasService.encriptar(pathHdfs+ "/" + nombreArchivo);
				    
				    //	String nombreArchivo = "acuse_aceptacion" + formatoFecha.format(new Date()) + ".pdf";
					logger.info("nombreArchivo" + nombreArchivo);
					//pathHdfs= "/contenedor/acuse";
				//	utileriasService.saveDocumentoHdfs(pdfReport, pathHdfs,nombreArchivo); 
				//	BttContenedor bttcontenedor =bttContenedorService.guardarReferenciaArchivoContenedor(pathHdfs, nombreArchivo, desRfc,fechaActual); 
				//	referenciaAcuse= bttcontenedor.getDesUrl();
					
				//	expedientesService.savePgMinitracion(Constantes.IND_EXP_NOTA_PAGO, pgMinistracion, pdfReport, nombreArchivo, contentType);

            }
      //  } catch (Exception e) {
      //      e.printStackTrace();
     //   }
        
        return referenciaAcuse;
	}
	
	
	

	@Transactional
	private String acuseRegistroMedioContactoTelefono(String folio, String desRfc,String razonsocial, String registrosPatronales, BitUsuario bitUsuario, String correo, Date fechaActual) throws Exception{
		
		logger.info("acuseRegistroMedioContactoTelefono");
		String referenciaAcuse="";
		//genera el acuse de aceptación del uso del buzon
		String path = this.getClass().getClassLoader().getResource("").getPath();
        path += "templates/reportes/medioContacto/";
        String sourceFileName = path + "acuse_registro_medio_contacto_telefono.jrxml"; 
        Map<String, Object> parameters = new HashMap<String, Object>();
       // SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy",new Locale("es", "MX")); 
        parameters.put("path", path);
		parameters.put("logo1", path + "logo1.png");
		parameters.put("logo2", path + "logo2.png"); 
		parameters.put("logo3", path + "logo3.png"); 

        


        razonsocial=bitUsuario.getDesNombre() + " " + (bitUsuario.getDesPrimerApellido()==null? "":bitUsuario.getDesPrimerApellido() )+ " " + (bitUsuario.getDesSegundoApellido()==null? "":bitUsuario.getDesSegundoApellido() );
 
        String parrafo1="Información del mecanismo de comunicación registrado y/o actualizado\r\n" +
        		  
        		"\r\n" + 
        		"Número de teléfono celular: {telefono}\r\n" + 
        		"Estatus de registro: En proceso\r\n" + 
        		"\r\n" + 
        		"El particular se encuentra obligado a guardar absoluta y estricta confidencialidad de la información que conoce con motivo del uso del Buzón IMSS,  asimismo sabe las responsabilidades civiles y penales a las que se hará acreedor al quebrantar la citada reserva, así como al modificar, copiar, utilizar o sustraer información que vaya en perjuicio de la autoridad.\r\n"; 
        		//"\r\n" + 
        		//"Sus datos personales son incorporados y protegidos en los sistemas del IMSS, los cuales constituyen información reservada  y confidencial en los términos del código fiscal de la federación vigente  y las leyes sobre su transparencia y acceso a la información pública, así como de protección de datos personales.\r\n" + 
        		//"";
     
        parrafo1=parrafo1.replace("{telefono}", correo); 
        parameters.put("razonsocial", razonsocial); 
        parameters.put("parrafo1", parrafo1); 
        parameters.put("rfc", desRfc); 
        parameters.put("folio", folio);

        parameters.put("registrosPatronales", registrosPatronales);
        
        logger.info("registrosPatronales: " + registrosPatronales);
        
        parameters.put("curp",utileriasService.getValorNotNull(bitUsuario.getDesCurp()));
        JSONObject jsonWidget = new JSONObject();
      //  Date fechaActual =bttmediocontacto.getFecRegistro();
        SimpleDateFormat formateador = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy HH:mm:ss 'hrs.'",new Locale("es", "MX")); 
        parameters.put("fechaRegistro", "Fecha: " + formateador.format(fechaActual)); 
     //   try {

            FirmaElectronicaSegService service = new FirmaElectronicaSegService();
            FirmaElectronicaSegPortType portType = service.getFirmaElectronicaSegPortTypePort();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS",new Locale("es", "MX"));
            String fechafolio = sdf.format(fechaActual);

            String cadenaOriginal = "|Versión:2|Rfc:"+desRfc+"|Tipo+de+trámite:Registro+Medio+Contacto|Folio+del+trámite:"+folio+"|Fecha+de+elaboración:"+fechafolio+"|";

            jsonWidget.put("rfc",desRfc);
            //jsonWidget.put("aplicacion","AplPruebas");
            jsonWidget.put("aplicacion","AplBuzonIMSS");
            jsonWidget.put("id_llavefirma","IMSS_CSD_01");
            jsonWidget.put("cadenaoriginal",cadenaOriginal);

            //Se genera la imagen QR de la cadenaOriginal
            BufferedImage image = utileriasService.generaQRImage(cadenaOriginal);
            parameters.put("image",image);

            FirmaSimpleRequestType request = new FirmaSimpleRequestType();
            request.setJsonParms(jsonWidget.toString());
            FirmaSimpleResponseType response = portType.firmaSimple(request);

            String respuesta = response.getJsonSalida();

            logger.info("salida: "+respuesta);

            JSONObject objetoJson = new JSONObject(respuesta);

            parameters.put("cadenaOriginal", cadenaOriginal);
            parameters.put("selloDigital", objetoJson.get("sello"));

           

            JasperCompileManager.compileReportToFile(sourceFileName);
            sourceFileName = path + "acuse_registro_medio_contacto_telefono.jasper";

            JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(sourceFileName);
            JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters,  new JREmptyDataSource(1));
            if (jasperPrint != null) {

            	
				    byte[] pdfReport = JasperExportManager.exportReportToPdf(jasperPrint);
				    //String contentType = "application/pdf"; 
					//SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyyMMddHHmmss",new Locale("es", "MX"));
					 
				    
					//Creala la ubicación del archivo en el hdfs para registrarlo para su consulta posterior
					SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyyMMddHHmmssSSS",new Locale("es", "MX"));
					SimpleDateFormat formatoAuxiliarnom = new SimpleDateFormat("ssSSS",new Locale("es", "MX"));
					String identificador=bitUsuario.getCveIdUsuario()+ formatoAuxiliarnom.format(new Date());
					String pathHdfs= "acuse/";
					String nombreArchivo = "acuse_registro_medio_contacto_tel" + formatoFecha.format(fechaActual) + identificador + ".pdf";
					//String nombreLink=utileriasService.encriptar(pathHdfs+ "/" + nombreArchivo);
				    
				    //	String nombreArchivo = "acuse_aceptacion" + formatoFecha.format(new Date()) + ".pdf";
					logger.info("nombreArchivo" + nombreArchivo);
					//pathHdfs= "/contenedor/acuse";
				//	utileriasService.saveDocumentoHdfs(pdfReport, pathHdfs,nombreArchivo); 
				//	BttContenedor bttcontenedor =bttContenedorService.guardarReferenciaArchivoContenedor(pathHdfs, nombreArchivo, desRfc, fechaActual); 
				//	referenciaAcuse= bttcontenedor.getDesUrl();
					
				//	expedientesService.savePgMinitracion(Constantes.IND_EXP_NOTA_PAGO, pgMinistracion, pdfReport, nombreArchivo, contentType);

            }
      //  } catch (Exception e) {
       //     e.printStackTrace();
    //    }
        
        return referenciaAcuse;
	}
	
	
 
	

	@Override
	@Transactional
	public BttMedioContacto createMedioContacto (Long  cveIdTipoMedioContacto, @ModelAttribute  BttMedioContacto bttmediocontacto, Long cveIdUsuario)throws Exception {
		 logger.info("createMedioContacto");
		//registro de medios de contacto de RFC
		 
		Integer countEmailValidadosRfc=0;
		Integer countCelularesValidadosRfc=0;
		
		Integer countEmailRegistradosRfc=0;
		Integer countCelularesRegistradosRfc=0;
		
		BitUsuario bitUsuario= bitUsuarioService.findBitUsuarioByCveIdUsuario(cveIdUsuario);
 
 
        
        //List<BitUsuario> bitUsuarios= bitUsuarioService.findBitUsuarioByDesUsuario(rfc);
        
        
        
        boolean medioContactoRegistrado=false;
      //  boolean indAceptarBuzon=false;
      //  boolean indConfirmoMediosContacto=false;
     //   Long idRole=0L;
     //   String userName="";
        String desRfc="";
    
        String razonsocial="";
        String registrosPatronales="";
        //BitUsuario bitUsuario=new BitUsuario();
       // if(!bitUsuarios.isEmpty()) { 
        	
            // Obtiene el nombre del usuario logueado
        	//bitUsuario=bitUsuarios.iterator().next();
        	
        	desRfc=bitUsuario.getDesRfc();
        	cveIdUsuario=bitUsuario.getCveIdUsuario();
        	//Nota: verificar si el nombre o razon social esta en el campo nombre o es un campo adicional
        	razonsocial=bitUsuario.getDesNombre();
      //  }
        
        
 
         
		
		BtcEstatusMedioContacto btcEstatusMedioContacto=new BtcEstatusMedioContacto();
		Date fechaActual=new Date();
		btcEstatusMedioContacto=btcEstatusMedioContactoService.findBtcEstatusMedioContactoByCveIdEstatusMedioContacto(1L); //1= Pendiente de confirmar
		bttmediocontacto.setBtcEstatusMedioContacto(btcEstatusMedioContacto);
		bttmediocontacto.setFecRegistro(fechaActual);
		
		 
		BtcTipoMedioContacto btcTipoMedioContacto=new BtcTipoMedioContacto();
		btcTipoMedioContacto=btcTipoMedioContactoService.findBtcTipoMedioContactoByCveIdTipoMedioContacto(cveIdTipoMedioContacto);
		bttmediocontacto.setBtcTipoMedioContacto(btcTipoMedioContacto);
		bttmediocontacto.setCveIdUsuario(bitUsuario.getCveIdUsuario());
		 
		
	 
		String desFolio= utileriasService.getFolioPrefijo("BIO", fechaActual);
		bttmediocontacto.setDesFolio(desFolio);

	 
			// registra siempre el medio de contacto derivado de que el acuse tendra la lista de RP que ampara
			bttmediocontacto=bttMedioContactoService.saveBttMedioContacto(bttmediocontacto);
			medioContactoRegistrado=true;
		
 
		
		if(cveIdTipoMedioContacto.equals(1L) && medioContactoRegistrado) {
			//solo para el registro de correo electronico
		      //  try {



                    String nombre=bitUsuario.getDesNombre() + " " + (bitUsuario.getDesPrimerApellido()==null? "":bitUsuario.getDesPrimerApellido() )+ " " + (bitUsuario.getDesSegundoApellido()==null? "":bitUsuario.getDesSegundoApellido() );
		            String codigocifrado = utileriasService.encriptar(""+bttmediocontacto.getCveIdMedioContacto());
		            logger.info("para descifrar code registro: " + codigocifrado);
		           
		            Long parametroContexto=1L;
		            String contexto=Constantes.CONTEXTO_APP; //CONTEXTO
		            logger.info("contexto: " + contexto);
		            //String url =contexto +   servletContext.getContextPath() + "/confirmacionMedioComunicacion?code=" + codigocifrado;
		            String url =contexto +   servletContext.getContextPath() + "/validarContacto?code=" + codigocifrado;
		            
		            logger.info("url: " + url);
		            logger.info("nombre: " + nombre);
		            logger.info("bttmediocontacto.getDesCorreoElectronico(): " + bttmediocontacto.getDesCorreoElectronico());

                    nombre = nombre==null? "":nombre;

		            //utileriasService.sendEmail(bttmediocontacto.getDesCorreoElectronico(), nombre, url);
		            String cuerpo="<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\" width=\"560px\" style=\"font-family:Helvetica,Arial;font-size:16px;color:#ffffff;background:#005044\" class=\"m_759146103478688362header\">\r\n" + 
		            		"	<tbody>\r\n" + 
		            		"		<tr>\r\n" + 
		            		"		<td height=\"76px\" valign=\"middle\" style=\"padding-left:27px\">\r\n" +  
		            		"		</td>\r\n" + 
		            		"		<td height=\"76px\" valign=\"middle\" align=\"right\" style=\"padding-right:27px\">\r\n" + 
		            		"		<span style=\"color:#ffffff;font:normal 16px Helvetica,Arial;margin:0px;padding:0px;line-height:16px\">IMSS</span>\r\n" + 
		            		"		</td>\r\n" + 
		            		"		</tr>\r\n" + 
		            		"	</tbody>\r\n" + 
		            		"</table>\r\n" + 
		            		"<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\" width=\"560px\" style=\"font-family:Helvetica,Arial;background:#ffffff\" bgcolor=\"#ffffff\">\r\n" + 
		            		"<tbody>\r\n" + 
		            		"	<tr>\r\n" + 
		            		"		<td width=\"560px;\" valign=\"top\" align=\"left\" bgcolor=\"#ffffff\" style=\"font-family:Helvetica,Arial;font-size:16px;color:#5a5a5a;background:#fff;padding:38px 27px 76px\">\r\n" + 
		            		"			<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"color:#717171;font:normal 16px Helvetica,Arial;margin:0px;padding:0\" width=\"100%\" class=\"m_759146103478688362content\">\r\n" + 
		            		"				<tbody>\r\n" + 
		            		"					<tr>\r\n" + 
		            		"						<td align=\"center\" style=\"padding:15px 0px\"><h5 style=\"color:#5a5a5a;margin:0px;padding:0px;line-height:30px;font-size:18px;font-family:Helvetica,Arial\">Validación de medio de contacto</h5></td>\r\n" + 
		            		"					</tr>\r\n" + 
		            		"					<tr>\r\n" + 
		            		"						<td align=\"justify\" style=\"padding:15px 0px;text-align:justify\" valign=\"top\">\r\n" + 
		            		"							<p style=\"color:#5a5a5a;font-weight:normal;margin:0px;padding:0px;line-height:23px;font-size:16px;font-family:Helvetica,Arial\">\r\n" + 
		            		"									Estimado(a): <strong>{nombre}  </strong>\r\n" + 
		            		"							</p>\r\n" + 
		            		"							<br><br>\r\n" + 
		            		"							<p style=\"color:#5a5a5a;font-weight:normal;margin:0px;padding:0px;line-height:23px;font-size:16px;font-family:Helvetica,Arial\">\r\n" + 
		            		"								Para validar tu correo da clic <a href=\"{url}\" target=\"_blank\" >aquí</a> y posteriormente recibirás un correo que te informará la conclusión del proceso.\r\n" + 
		            		"							</p>\r\n" + 
		            		"						 \r\n" + 
		            		"							<p>\r\n" + 
		            		"								¡El IMSS se moderniza para ti!\r\n" + 
		            		"							</p>\r\n" + 
		            		"						</td>\r\n" + 
		            		"					</tr>\r\n" + 
		            		"					<tr>\r\n" + 
		            		"						<td align=\"justify\" style=\"padding:15px 0px;text-align:justify\" class=\"m_759146103478688362note\">\r\n" + 
		            		"							<p style=\"color:#5a5a5a;font-weight:normal;margin:0px;padding:0px;font-style:italic;line-height:20px;font-size:12px;font-family:Helvetica,Arial\">\r\n" + 
		            		"							<strong>AVISO IMPORTANTE:</strong> Este correo electrónico y/o el material adjunto es para uso exclusivo de la persona o la entidad a la que expresamente se le ha enviado, el cual contiene información confidencial. Si no es el destinatario legítimo del mismo, por favor repórtelo inmediatamente a la cuenta del remitente y elimínelo. Cualquier revisión, almacenamiento, retransmisión, difusión o cualquier otro uso de este correo, por personas o entidades distintas a las del destinatario legítimo, queda expresamente prohibida. Este correo electrónico no pretende ni debe ser considerado como constitutivo de ninguna relación legal, contractual o de otra índole similar.\r\n" + 
		            		"							</p>\r\n" + 
		            		"						</td>\r\n" + 
		            		"					</tr>\r\n" + 
		            		"				</tbody>\r\n" + 
		            		"			</table>\r\n" + 
		            		"		</td>\r\n" + 
		            		"	</tr>\r\n" + 
		            		"</tbody>\r\n" + 
		            		"</table>\r\n" + 
		            		"<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\" width=\"560px\" style=\"font-family:Helvetica,Arial;font-size:16px;color:#ffffff;background:#005044\">\r\n" + 
		            		"	<tbody>\r\n" + 
		            		"		<tr>\r\n" + 
		            		"			<td align=\"left\" height=\"76px\" valign=\"middle\" style=\"padding-left:27px\">\r\n" +  
		            		"			</td>\r\n" + 
		            		"		</tr>\r\n" + 
		            		"	</tbody>\r\n" + 
		            		"</table>";
		            
		            
		            cuerpo=cuerpo.replace("{nombre}", nombre).replace("{url}", url); 
		         //   utileriasService.sendEmailExterno(bttmediocontacto.getDesCorreoElectronico(), "Medio de Contacto", cuerpo );
		
		      //  } catch (Exception e) {
		       //       e.printStackTrace();
		         //   modelAndView.addObject("errorMessage", "Ocurrio un error inesperado, favor de notificarlo al administrador del sistema");
		         //   modelAndView.addObject("bitUsuario", new BitUsuario());
		         //   modelAndView.setViewName("registration");
		         //   return modelAndView;
		      //  }
		}else 		if(cveIdTipoMedioContacto.equals(2L) && medioContactoRegistrado) {
							//solo para el registro de telefono
					      //  try {
		

					    		SimpleDateFormat formatoFecha = new SimpleDateFormat("ssSSS",new Locale("es", "MX")); 
					    		String codigoValidacion =   formatoFecha.format(new Date()) ; 
					    		
					    		logger.info("codigoValidacion: " + codigoValidacion);
					    		
					    		bttmediocontacto.setDesCodigoVerificacion(codigoValidacion);
					    		bttmediocontacto=bttMedioContactoService.saveBttMedioContacto(bttmediocontacto);
					        	//envia sms de registro
					    		String mensajeSms=(Constantes.MSG_SMS_VERIFICACION).replace("{codigo_verificacion}", codigoValidacion);
					        //	utileriasService.sendSms(Constantes.MSG_SMS_FROM, Constantes.MSG_SMS_CODIGO_PAIS+ bttmediocontacto.getDesCorreoElectronico().trim() , mensajeSms);
				                 
					
					    //    } catch (Exception e) {
					     //         e.printStackTrace();
					
					    //    }
					}
		
		

		countEmailRegistradosRfc=0;
    	List<BttMedioContacto> bttMedioContactos=  bttMedioContactoService.findBttMedioContactoByCveIdUsuario(cveIdUsuario);
        
    	//cuenta los medios de contacto registrados para el RFC los contabiliza par evitar el registro cuando son mas de 1 telefono o 5 correos
    	//cuenta a un que no esten confirmados
    	for(BttMedioContacto bttMedioContacto:bttMedioContactos) {
    		//cuenta solo si  estan confirmados
/*
    		boolean mediosContactoRFC=false;
    		
    		//verifica si no tiene relacionados patrones es un medio de contacto del RFC
    		if(bttMedioContacto.getBttPatronMedioContactos()==null) {
    			mediosContactoRFC=true;
    		}else if(bttMedioContacto.getBttPatronMedioContactos().isEmpty()) {
    			mediosContactoRFC=true;
    		}*/
    		boolean mediosContactoRFC= bttPatronMedioContactoService.isMedioContactoRfc(bttMedioContacto);
    		if(mediosContactoRFC && bttMedioContacto.getFecBaja() ==null && bttMedioContacto.getFecConfirmacion() !=null) {
		        	if(	bttMedioContacto.getBtcTipoMedioContacto().getCveIdTipoMedioContacto()==1L) {
		        		countEmailValidadosRfc ++;
		        	}else if(bttMedioContacto.getBtcTipoMedioContacto().getCveIdTipoMedioContacto()==2L) {
		        		countCelularesValidadosRfc ++;
		        	} 
    		
    		}
    		
      
            
    		//cuenta todos los medios de contacto registrados y que no esten en baja
    		if(mediosContactoRFC && bttMedioContacto.getFecBaja() ==null ) {
	        	if(	bttMedioContacto.getBtcTipoMedioContacto().getCveIdTipoMedioContacto()==1L) { 
	        		countEmailRegistradosRfc ++; 
	        	}else if(bttMedioContacto.getBtcTipoMedioContacto().getCveIdTipoMedioContacto()==2L) {
	        		countCelularesRegistradosRfc ++;
	        	} 
		
    		}
    		
    	}
		
    	bttmediocontacto.setCountCelularesValidadosRfc(countCelularesValidadosRfc);
    	bttmediocontacto.setCountEmailValidadosRfc(countEmailValidadosRfc);
    	bttmediocontacto.setCountCelularesRegistradosRfc(countCelularesRegistradosRfc);
    	bttmediocontacto.setCountEmailRegistradosRfc(countEmailRegistradosRfc);
    	
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm",new Locale("es", "MX"));
        String fechaRegistroMensaje = sdf.format(bttmediocontacto.getFecRegistro());
        
        
		if(cveIdTipoMedioContacto.equals(1L) && medioContactoRegistrado) {
			//solo para el registro de correo electronico
			bttmediocontacto.setMensaje("Se registró la información correctamente con el número de folio: " + bttmediocontacto.getDesFolio() + ", fecha: "  +  fechaRegistroMensaje + ".<br/> Para continuar, ingresa a tu cuenta de correo electrónico para validarlo. Tienes 72 horas como máximo para realizar dicha validación, en caso contrario se cancelará y tendrás que realizar el registro nuevamente.  "+ "</label>"+ "<br/><label class='alert alert-warning'> Nota: Si no recibes el correo electrónico, registra una aclaración en un lapso de 24 horas a partir de este momento para poder ayudarte.");
    	
		}else if(cveIdTipoMedioContacto.equals(2L) && medioContactoRegistrado) {
			//solo para el registro de telefono 
	    
				bttmediocontacto.setMensaje(Constantes.MSG_TELEFONO_REGISTRADO); 

			 
	    
		}
    	
    	

    	
    	
    	
		return bttmediocontacto;
	} 
	
	
	

 

	@Override
	@Transactional
	public BttMedioContacto confirmaMedioContacto (BttMedioContacto bttMedioContacto)throws Exception {
	
	
		Date fechaActual=new Date();
		bttMedioContacto.setFecConfirmacion(fechaActual);
		//al realizar la confirmación cambia el estatus del registro de medio de contacto a confirmado
		BtcEstatusMedioContacto btcEstatusMedioContacto=new BtcEstatusMedioContacto();
		btcEstatusMedioContacto=btcEstatusMedioContactoService.findBtcEstatusMedioContactoByCveIdEstatusMedioContacto(2L);
		bttMedioContacto.setBtcEstatusMedioContacto(btcEstatusMedioContacto);
		 
		String desFolio= utileriasService.getFolioPrefijo("BIO-", fechaActual);
		bttMedioContacto.setDesFolioValidacion(desFolio);
		
		//bttMedioContacto=bttMedioContactoService.saveBttMedioContacto(bttMedioContacto);
		
		String correo = bttMedioContacto.getDesCorreoElectronico() ;
		String folio =bttMedioContacto.getDesFolio(); 
		Map<String, String> parametrosCorreo = new HashMap<>();
		parametrosCorreo.put("correo", correo);
		parametrosCorreo.put("folio", folio);

		 
		
		//try {
			
			BitUsuario bitUsuario=bitUsuarioService.findBitUsuarioByCveIdUsuario(bttMedioContacto.getCveIdUsuario());
			String desRfc=bitUsuario.getDesRfc();
			String razonsocial=bitUsuario.getDesNombre();
			//Nota de nonde se obtiene la curp
			String curp=utileriasService.getValorNotNull(bitUsuario.getDesCurp()) ;
			String registrosPatronales="";
			
			List<BttPatronMedioContacto> bttPatronMedioContactos=bttMedioContacto.getBttPatronMedioContactos();
			for(BttPatronMedioContacto bttPatronMedioContacto:bttPatronMedioContactos) {
				registrosPatronales=registrosPatronales+ bttPatronMedioContacto.getBttPatron().getRegistroPatronal() + ", ";
				
			}
			
	        if(registrosPatronales.length()>2) {
	        	//elimina la ultima coma de la lista de RPs
	           registrosPatronales=registrosPatronales.substring(0, registrosPatronales.length()-2);
	        }
			
		//	String desPathAcuseValidacion=bttMedioContactoService.acuseValidacionMedioContacto(folio, desRfc,razonsocial, curp, registrosPatronales,bitUsuario, bttMedioContacto.getDesCorreoElectronico(),fechaActual);

			bttMedioContacto= bttMedioContactoService.findBttMedioContactoByCveIdMedioContacto(bttMedioContacto.getCveIdMedioContacto());
		//	bttMedioContacto.setDesPathAcuseValidacion(desPathAcuseValidacion);
			//registra la referencia del acuse de validacion
			bttMedioContacto=bttMedioContactoService.saveBttMedioContacto(bttMedioContacto);

            StringBuilder nombreCompleto = new StringBuilder();
            nombreCompleto.append(bitUsuario.getDesNombre()==null? "": bitUsuario.getDesNombre())
                    .append(bitUsuario.getDesPrimerApellido()==null? "":bitUsuario.getDesPrimerApellido())
                    .append(bitUsuario.getDesSegundoApellido()==null? "":bitUsuario.getDesSegundoApellido());

            parametrosCorreo.put("nombreCompleto",nombreCompleto.toString());

			//envia correo de la aceptación
		//	utileriasService.sendEmail(bttMedioContacto.getDesCorreoElectronico(),parametrosCorreo, 2L);//2L corresponde a la plantilla de correo que se utiliza
            
            
            String cuerpo="<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\" width=\"560px\" style=\"font-family:Helvetica,Arial;font-size:16px;color:#ffffff;background:#005044\" class=\"m_759146103478688362header\">\r\n" + 
            		"	<tbody>\r\n" + 
            		"		<tr>\r\n" + 
            		"		<td height=\"76px\" valign=\"middle\" style=\"padding-left:27px\">\r\n" + 
        
            		"		</td>\r\n" + 
            		"		<td height=\"76px\" valign=\"middle\" align=\"right\" style=\"padding-right:27px\">\r\n" + 
            		"		<span style=\"color:#ffffff;font:normal 16px Helvetica,Arial;margin:0px;padding:0px;line-height:16px\">IMSS</span>\r\n" + 
            		"		</td>\r\n" + 
            		"		</tr>\r\n" + 
            		"	</tbody>\r\n" + 
            		"</table>\r\n" + 
            		"<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\" width=\"560px\" style=\"font-family:Helvetica,Arial;background:#ffffff\" bgcolor=\"#ffffff\">\r\n" + 
            		"<tbody>\r\n" + 
            		"	<tr>\r\n" + 
            		"		<td width=\"560px;\" valign=\"top\" align=\"left\" bgcolor=\"#ffffff\" style=\"font-family:Helvetica,Arial;font-size:16px;color:#5a5a5a;background:#fff;padding:38px 27px 76px\">\r\n" + 
            		"			<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"color:#717171;font:normal 16px Helvetica,Arial;margin:0px;padding:0\" width=\"100%\" class=\"m_759146103478688362content\">\r\n" + 
            		"				<tbody>\r\n" + 
            		"					<tr>\r\n" + 
            		"						<td align=\"center\" style=\"padding:15px 0px\"><h5 style=\"color:#5a5a5a;margin:0px;padding:0px;line-height:30px;font-size:18px;font-family:Helvetica,Arial\">Validación de medio de contacto</h5></td>\r\n" + 
            		"					</tr>\r\n" + 
            		"					<tr>\r\n" + 
            		"						<td align=\"justify\" style=\"padding:15px 0px;text-align:justify\" valign=\"top\">\r\n" + 
            		"							<p style=\"color:#5a5a5a;font-weight:normal;margin:0px;padding:0px;line-height:23px;font-size:16px;font-family:Helvetica,Arial\">\r\n" + 
            		"									Estimado(a): <strong>{nombre}  </strong>\r\n" + 
            		"							</p>\r\n" + 
            		"							<br><br>\r\n" + 
            		"							<p style=\"color:#5a5a5a;font-weight:normal;margin:0px;padding:0px;line-height:23px;font-size:16px;font-family:Helvetica,Arial\">\r\n" + 
            		"								La validación de tu correo electrónico concluyó existosamente.\r\n" + 
            		"							</p>\r\n" + 
            		"						 \r\n" + 
            		"							<p>\r\n" + 
            		"								¡El IMSS se moderniza para ti!\r\n" + 
            		"							</p>\r\n" + 
            		"						</td>\r\n" + 
            		"					</tr>\r\n" + 
            		"					<tr>\r\n" + 
            		"						<td align=\"justify\" style=\"padding:15px 0px;text-align:justify\" class=\"m_759146103478688362note\">\r\n" + 
            		"							<p style=\"color:#5a5a5a;font-weight:normal;margin:0px;padding:0px;font-style:italic;line-height:20px;font-size:12px;font-family:Helvetica,Arial\">\r\n" + 
            		"							<strong>AVISO IMPORTANTE:</strong> Este correo electrónico y/o el material adjunto es para uso exclusivo de la persona o la entidad a la que expresamente se le ha enviado, el cual contiene información confidencial. Si no es el destinatario legítimo del mismo, por favor repórtelo inmediatamente a la cuenta del remitente y elimínelo. Cualquier revisión, almacenamiento, retransmisión, difusión o cualquier otro uso de este correo, por personas o entidades distintas a las del destinatario legítimo, queda expresamente prohibida. Este correo electrónico no pretende ni debe ser considerado como constitutivo de ninguna relación legal, contractual o de otra índole similar.\r\n" + 
            		"							</p>\r\n" + 
            		"						</td>\r\n" + 
            		"					</tr>\r\n" + 
            		"				</tbody>\r\n" + 
            		"			</table>\r\n" + 
            		"		</td>\r\n" + 
            		"	</tr>\r\n" + 
            		"</tbody>\r\n" + 
            		"</table>\r\n" + 
            		"<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\" width=\"560px\" style=\"font-family:Helvetica,Arial;font-size:16px;color:#ffffff;background:#005044\">\r\n" + 
            		"	<tbody>\r\n" + 
            		"		<tr>\r\n" + 
            		"			<td align=\"left\" height=\"76px\" valign=\"middle\" style=\"padding-left:27px\">\r\n" + 
            	 
            		"			</td>\r\n" + 
            		"		</tr>\r\n" + 
            		"	</tbody>\r\n" + 
            		"</table>";
            		
            
            cuerpo=cuerpo.replace("{nombre}", nombreCompleto) ; 
    //        utileriasService.sendEmailExterno(bttMedioContacto.getDesCorreoElectronico(), "Medio de Contacto verificado", cuerpo );
			
			//verifica si el RFC tiene almenos un correo electrónio y un teléfono validado  
			
	//	}catch (Exception e) {
       //     logger.info("Error al enviar el correo electronico de confirmacion de medio de contacto pero la confirmación la puede ver en la opción de medios de contacto");
			//error al enviar el correo electronico de confirmacion de medio de contacto
	//		e.printStackTrace();
			// TODO: handle exception
	//	}
		
		
	return bttMedioContacto;
	
}

	
	
 
 
	
	
    @Override
	public List<BttMedioContacto> getMediosComunicacionRFC(BitUsuario bitUsuario) {
    	logger.info("Inicia getMediosComunicacionRFC  ");
    	List<BttMedioContacto> bttMedioContactoRFCs=new ArrayList<BttMedioContacto>(); 
        List<BttMedioContacto> bttMedioContactos = bttMedioContactoService.findBttMedioContactoByCveIdUsuario(bitUsuario.getCveIdUsuario());

        if(bttMedioContactos!= null || !bttMedioContactos.isEmpty()){  
            for (BttMedioContacto bttMedioContacto : bttMedioContactos) { 
                if (bttMedioContacto.getFecBaja() == null && bttMedioContacto.getFecConfirmacion() != null) { 
                    boolean mediosContactoRFC = bttPatronMedioContactoService.isMedioContactoRfc(bttMedioContacto); 
                    if (mediosContactoRFC && bttMedioContacto.getFecBaja() == null && bttMedioContacto.getFecConfirmacion() != null) { 
                    	bttMedioContactoRFCs.add(bttMedioContacto); 
                    }
                }
            }
        } 
        logger.info("Termina getMediosComunicacionRFC  ");
		return bttMedioContactoRFCs;
	}
	
	
	}
