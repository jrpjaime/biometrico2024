package mx.gob.imss.biometricos.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.nimbusds.jose.shaded.json.JSONObject;
import com.nimbusds.jose.shaded.json.parser.JSONParser;
import com.nimbusds.jose.shaded.json.parser.ParseException;

import mx.gob.imss.biometricos.model.BicRole;
import mx.gob.imss.biometricos.model.BitUsuario;
import mx.gob.imss.biometricos.model.BitUsuarioRole;
import mx.gob.imss.biometricos.security.dto.LoginUsuarioDto;
import mx.gob.imss.biometricos.vo.IneRostroParametro;
import mx.gob.imss.biometricos.vo.IneRostroVO;
import mx.gob.imss.biometricos.vo.Testlifecredencial;
import mx.gob.imss.biometricos.ws.wsbiometricos.WebService;
import mx.gob.imss.biometricos.ws.wsbiometricos.WebServiceSoap;
import mx.gob.imss.biometricos.ws.wsconsultasat.mx_gob_imss_didt_cia_interoper_sat_pojos.EntradaSAT;
import mx.gob.imss.biometricos.ws.wsconsultasat.mx_gob_imss_didt_cia_interoper_sat_pojos.Identificacion;
import mx.gob.imss.biometricos.ws.wsconsultasat.mx_gob_imss_didt_cia_interoper_sat_pojos.SalidaSAT;
import mx.gob.imss.biometricos.ws.wsconsultasat.mx_gob_imss_didt_cia_interoper_sat_pojos.Ubicacion;
import mx.gob.imss.biometricos.ws.wsconsultasat.service.SATPatrones;
import mx.gob.imss.biometricos.ws.wsconsultasat.service.SATPatronesService;

@Service("biometricoService")
public class BiometricoServiceImpl implements BiometricoService {
	
	

    private static final Logger logger = LogManager.getLogger(BiometricoServiceImpl.class);
    
    @Autowired
    private BitUsuarioService bitUsuarioService;
    
    @Autowired
    private BicRoleService bicRoleService;
    
    @Autowired
    private BitUsuarioRoleService bitUsuarioRoleService;
    
	
    private static final String PERSONA_MORAL = "M";
    private static final String PERSONA_FISICA = "F";
    private static final String SIN_SOCIEDAD = "SIN TIPO DE SOCIEDAD";
	
	/*
	 *  Registro de usuarios
	*/
	@Override
	@Transactional
	public BitUsuario registraUsuario(String  rfc,String curp) {
		
		logger.info("registraUsuario: rfc "+ rfc);
		logger.info("registraUsuario: curp "+ curp);
		
        boolean consultoServicioSat=false;
        String cveEntidadFederativa = "";
        String descEntidadFederativa = "";
        
        String claveMunicipio = "";
        String desMunicipio = "";
        String desColonia = "";
        String desCodigoPostal = "";
        Date fecActual=new Date();
        
        String nombreRazonSocial="";
       // String curp="";
        
        
        //Si el valor de RFC no es null se verifica el nombre o razon social
        if( (rfc!= null) ){
    


            SATPatronesService servicio = new SATPatronesService();
            SATPatrones portTypeSAT = servicio.getSATPatronesSoapPort();
            EntradaSAT datosEntrada = new EntradaSAT();
            datosEntrada.setRfc(rfc);
            logger.info("Consulta el WS del SAT "  + rfc);
            SalidaSAT datosSalida = portTypeSAT.getPatron(datosEntrada);
            logger.info("datosSalida: " + datosSalida.toString());

            if(datosSalida!=null){
                List<Identificacion> listResultado = datosSalida.getIdentificacion();
                logger.info("listResultado: " + listResultado);
                Identificacion identificacion = null;
                //Se busca el objeto identificacion que tenga elementos
                for(Identificacion idenTemp: listResultado ){
                	 logger.info("idenTemp.getNombre(): " + idenTemp.getNombre());
                    if(idenTemp!=null){
                        if(idenTemp.getNombre()!=null || idenTemp.getRazonSoc()!=null){
                            if(!idenTemp.getNombre().trim().equals("") || !idenTemp.getRazonSoc().trim().equals("")){
                                identificacion = idenTemp;
                            }
                        }
                    }
                }

//                logger.info("identificacion: " + identificacion);

                if(identificacion!=null){
                	
                    if(identificacion.getTPersona().equals(PERSONA_MORAL)){
                    	
                    	if (identificacion.getTSociedad().toUpperCase().equals(SIN_SOCIEDAD)){
                            nombreRazonSocial = identificacion.getRazonSoc()+"";
                        }else{
                            nombreRazonSocial = identificacion.getRazonSoc()+" "+identificacion.getTSociedad();
                        }
                    	
                    	//nombreRazonSocial = identificacion.getRazonSoc()+" "+identificacion.getTSociedad();
                    	
                        logger.info("RazonSocial ServicioRFC: " + identificacion.getRazonSoc());
                        consultoServicioSat=true;
                    }  else if(identificacion.getTPersona().equals(PERSONA_FISICA)){
                        nombreRazonSocial = identificacion.getNombre()+" "+identificacion.getApPaterno()+" "+identificacion.getApMaterno();
                      //  curp= identificacion.getCURP();
                        logger.info("identificacion: " + identificacion.getCURP());
                        logger.info("Nombre completo ServicioRFC: " + nombreRazonSocial);
                        consultoServicioSat=true;
                    }else{
                        logger.error("1 NO SE RECIBIO persona Física ni Moral DEL WS SAT " + rfc);
                    }

                }else{
                    logger.error("2 NO SE RECIBIO RESPUESTA DEL WS SAT " + rfc);
                }

                List<Ubicacion> listUbicacion = datosSalida.getUbicacion();

                if(listUbicacion!=null && !listUbicacion.isEmpty()){
                    Ubicacion ubicacion = listUbicacion.get(0);

                    cveEntidadFederativa = (ubicacion.getCEntFed()==null? "":ubicacion.getCEntFed());
                    descEntidadFederativa= (ubicacion.getDEntFed()==null? "":ubicacion.getDEntFed());
                    
                    claveMunicipio = (ubicacion.getCMunicipio()==null? "":ubicacion.getCMunicipio());
                    desMunicipio = (ubicacion.getDMunicipio()==null? "":ubicacion.getDMunicipio());
                    desColonia = (ubicacion.getDColonia()==null? "":ubicacion.getDColonia());
                    desCodigoPostal = (ubicacion.getCp()==null? "":ubicacion.getCp());
                     
                  
                    logger.info("CveEntidadFederativa: "+cveEntidadFederativa);
                    logger.info("DescEntidadFederativa: "+descEntidadFederativa);
                    logger.info("claveMunicipio: "+claveMunicipio);
                    logger.info("desMunicipio: "+desMunicipio);
                    logger.info("desColonia: "+desColonia);
                    logger.info("desCodigoPostal: "+desCodigoPostal);
                }

            }else{
                logger.error("3 NO SE RECIBIO RESPUESTA DEL WS SAT " + rfc);
            }
        }



        if(!consultoServicioSat) {
        	 logger.error("NO SE RECIBIO RESPUESTA DEL WS SAT rfc: " + rfc);
        	
    	    
	          return new BitUsuario();
        }else {
        	 logger.info("RECIBIO RESPUESTA DEL WS SAT rfc: " + rfc + " nombreRazonSocial:" + nombreRazonSocial);
        	 
        }
 
         
        BitUsuario bitUsuario= bitUsuarioService.findBitUsuarioByDesUsuarioUnico(curp);
         
        if(bitUsuario==null) {
        	logger.info("usuario nuevo "  );
        	BitUsuario bitUsuarioNuevo=new BitUsuario();
        	bitUsuarioNuevo.setDesNombre(nombreRazonSocial.trim());
        	bitUsuarioNuevo.setDesCurp(curp);
        	bitUsuarioNuevo.setDesRfc(rfc);
        	bitUsuarioNuevo.setIndActivo(1);  
        	bitUsuarioNuevo.setDesUsuario(curp); 
        	bitUsuarioNuevo.setFecRegistro(fecActual); 
        	bitUsuarioNuevo.setClaveEntFed(cveEntidadFederativa);
        	bitUsuarioNuevo.setDesEntFed(descEntidadFederativa);  
            bitUsuarioNuevo.setClaveMunicipio(claveMunicipio);
            bitUsuarioNuevo.setDesMunicipio(desMunicipio);
            bitUsuarioNuevo.setDesColonia(desColonia);
            bitUsuarioNuevo.setDesCodigoPostal(desCodigoPostal); 
            //registra la fecha en que se esta actualizando
            bitUsuarioNuevo.setFecActualizacion(fecActual);
            //bitUsuarioNuevo.setDesPassword(bCryptPasswordEncoder.encode("admin1234"));

        	logger.info("bitUsuarioNuevo: " + bitUsuarioNuevo);
        	
        	
        	List<BitUsuarioRole> bitUsuarioRoles =new ArrayList<>();
            //agrega el usuario ya que no existe preregistro se inserta por la respuesta del widget
        	bitUsuarioNuevo=bitUsuarioService.saveBitUsuario(bitUsuarioNuevo);
        	logger.info("Registro el usuario con RFC: " + rfc);
        	
        	BitUsuarioRole bitUsuarioRole=new BitUsuarioRole();
        	bitUsuarioRole.setBitUsuario(bitUsuarioNuevo);
        	
        	BicRole bicRole= new BicRole();
        	bicRole=bicRoleService.findBicRoleByCveIdRole(2L); //se registran con rol de operador
        	bitUsuarioRole.setBicRole(bicRole);
        	
        	//asigna el rol
        	bitUsuarioRoleService.saveBitUsuarioRole(bitUsuarioRole);
        	
 
        	 
        	return bitUsuarioNuevo;
        	
        }else {
        	logger.info("usuario existe va a actualizar "  );
         	bitUsuario.setDesNombre(nombreRazonSocial);
        	
        	bitUsuario.setClaveEntFed(cveEntidadFederativa);
        	bitUsuario.setDesEntFed(descEntidadFederativa); 
            
        	bitUsuario.setClaveMunicipio(claveMunicipio);
        	bitUsuario.setDesMunicipio(desMunicipio);
        	bitUsuario.setDesColonia(desColonia);
        	bitUsuario.setDesCodigoPostal(desCodigoPostal); 
        	bitUsuario.setFecActualizacion(fecActual);
            
        	bitUsuario=bitUsuarioService.saveBitUsuario(bitUsuario);
        	logger.info("Actualizo los datos de ubicación del RFC: " + rfc);
        }
        logger.info("termina registraUsuario "  );
	   return bitUsuario;
}
	
 
	
	
	/*
	 *  Registro de usuarios
	*/
	@Override
	@Transactional
	public BitUsuario registraUsuarioCurp(String curp) {
		
	 
		logger.info("registraUsuario: curp "+ curp);
		
        boolean consultoServicioSat=false;
        String cveEntidadFederativa = "";
        String descEntidadFederativa = "";
        
        String claveMunicipio = "";
        String desMunicipio = "";
        String desColonia = "";
        String desCodigoPostal = "";
        Date fecActual=new Date();
        
        String nombreRazonSocial="";
       // String curp="";
        
        
        //Si el valor de RFC no es null se verifica el nombre o razon social
 

 
 
         
        BitUsuario bitUsuario= bitUsuarioService.findBitUsuarioByDesUsuarioUnico(curp);
         
        if(bitUsuario==null) {
        	logger.info("usuario nuevo "  );
        	BitUsuario bitUsuarioNuevo=new BitUsuario();
        //	bitUsuarioNuevo.setDesNombre(nombreRazonSocial.trim());
        	bitUsuarioNuevo.setDesCurp(curp);
        	//bitUsuarioNuevo.setDesRfc(rfc);
        	bitUsuarioNuevo.setIndActivo(1);  
        	bitUsuarioNuevo.setDesUsuario(curp); 
        	bitUsuarioNuevo.setFecRegistro(fecActual); 
        	//bitUsuarioNuevo.setClaveEntFed(cveEntidadFederativa);
        	//bitUsuarioNuevo.setDesEntFed(descEntidadFederativa);  
            //bitUsuarioNuevo.setClaveMunicipio(claveMunicipio);
            //bitUsuarioNuevo.setDesMunicipio(desMunicipio);
            //bitUsuarioNuevo.setDesColonia(desColonia);
           // bitUsuarioNuevo.setDesCodigoPostal(desCodigoPostal); 
            //registra la fecha en que se esta actualizando
            bitUsuarioNuevo.setFecActualizacion(fecActual);
            //bitUsuarioNuevo.setDesPassword(bCryptPasswordEncoder.encode("admin1234"));

        	logger.info("bitUsuarioNuevo: " + bitUsuarioNuevo);
        	
        	
        	List<BitUsuarioRole> bitUsuarioRoles =new ArrayList<>();
            //agrega el usuario ya que no existe preregistro se inserta por la respuesta del widget
        	bitUsuarioNuevo=bitUsuarioService.saveBitUsuario(bitUsuarioNuevo);
        	logger.info("Registro el usuario con curp: " );
        	
        	BitUsuarioRole bitUsuarioRole=new BitUsuarioRole();
        	bitUsuarioRole.setBitUsuario(bitUsuarioNuevo);
        	
        	BicRole bicRole= new BicRole();
        	bicRole=bicRoleService.findBicRoleByCveIdRole(2L); //se registran con rol de operador
        	bitUsuarioRole.setBicRole(bicRole);
        	
        	//asigna el rol
        	bitUsuarioRoleService.saveBitUsuarioRole(bitUsuarioRole);
        	
 
        	 
        	return bitUsuarioNuevo;
        	
        }else {
        	/*
        	logger.info("usuario existe va a actualizar "  );
         	bitUsuario.setDesNombre(nombreRazonSocial);
        	
        	bitUsuario.setClaveEntFed(cveEntidadFederativa);
        	bitUsuario.setDesEntFed(descEntidadFederativa); 
            
        	bitUsuario.setClaveMunicipio(claveMunicipio);
        	bitUsuario.setDesMunicipio(desMunicipio);
        	bitUsuario.setDesColonia(desColonia);
        	bitUsuario.setDesCodigoPostal(desCodigoPostal); 
        	bitUsuario.setFecActualizacion(fecActual);
            
        	bitUsuario=bitUsuarioService.saveBitUsuario(bitUsuario);
        	logger.info("Actualizo los datos de ubicación del RFC: " + rfc);
        	*/
        }
        logger.info("termina registraUsuario curp "+curp  );
	   return bitUsuario;
}
	
	
	
	@Override
	@Transactional
	public Testlifecredencial registraCredencial(LoginUsuarioDto loginUsuario) throws ParseException,  NullPointerException { 
		
		Testlifecredencial testlifecredencial = new Testlifecredencial();
		logger.info("INICIA registraCredencial "  );
		logger.info("loginUsuario.getNombreUsuario(): " + loginUsuario.getNombreUsuario());
		logger.info("loginUsuario.getPassword(): " + loginUsuario.getPassword());
		logger.info("loginUsuario.getOrigen(): " + loginUsuario.getOrigen());

		String nombreUsuario = loginUsuario.getNombreUsuario();
		BitUsuario bitUsuario = null;

		WebService webService = new WebService();
		WebServiceSoap webServiceSoap = webService.getWebServiceSoap();

		logger.info("loginUsuario.getImagen(): " + loginUsuario.getImagen());
		logger.info("loginUsuario.getImagenreverso(): " + loginUsuario.getImagenreverso());
	
		
		String imagenAnverso =loginUsuario.getImagen();
		String imagenReverso =loginUsuario.getImagenreverso();

 
		String respuesta = webServiceSoap.todo(
				"{ \"oper\": \"DatosIne\", \"entidad\": \"imss\", \"usuario\": \"user_imss_prueba\", \"claveUsuario\": \"Lm55.tReA3H6q\","
						+ "\"imagenAnverso\":\"" + imagenAnverso + "\", " + "\"imagenReverso\":\"" + imagenReverso
						+ "\", " + "\"referencia\":\"Pruebas_IQSEC\" }");
		logger.info("respuesta DatosIne: " + respuesta);

		logger.info("::::::::::::::::: "  );
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(respuesta);

			logger.info("json: " + json.toJSONString());

			String desCurpCredencial = json.get("curp").toString();
			String desNombre = json.get("nombres").toString();
			String desPrimerApellido = json.get("primerApellido").toString();
			String desSegundoApellido = json.get("segundoApellido").toString();
			String desClaveElector = json.get("claveElector").toString();

			String desNumeroEmision = json.get("registro").toString().substring(5, 7); // setNumeroEmision "registro":
																						// "1996 03"
			String desAnioRegistro = json.get("registro").toString().substring(0, 5); // setAnioRegistro
			String desAnioEmision = json.get("emision").toString(); // setAnioEmision
			String cic = json.get("cic").toString(); // setAnioEmision
			String tipo = json.get("tipo").toString();
			String subTipo = json.get("subTipo").toString();
			// String entidadFederativa=json.get("entidadFederativa").toString();
			// String localidad=json.get("localidad").toString();
			String sexo = json.get("sexo").toString();
			String latitud = "0.78";
			String longitud = "0.675";
			
			logger.info("DATOS registraCredencial "  );

			logger.info("desCurpCredencial" + desCurpCredencial);
			logger.info("desNombre: " + desNombre);
			logger.info("cic: " + cic);
			logger.info("tipo: " + cic);
			logger.info("subTipo: " + cic);

			logger.info("primerApellido: " + desPrimerApellido);
			logger.info("desSegundoApellido: " + desSegundoApellido);
			logger.info("desClaveElector: " + desClaveElector);
			logger.info("desNumeroEmision: " + desNumeroEmision);
			logger.info("desAnioRegistro: " + desAnioRegistro);
			logger.info("desAnioEmision: " + desAnioEmision);

			// nombreUsuario="AABA740918MCLYCL08";
			bitUsuario = bitUsuarioService.findBitUsuarioByDesUsuarioUnico(nombreUsuario);

			logger.info("consulto usuario: " + bitUsuario.getCveIdUsuario());

			logger.info("desCurpCredencial ::: " + desCurpCredencial);
			logger.info("bitUsuario.getDesCurp() ::: " + bitUsuario.getDesCurp());

			if (desCurpCredencial.trim().equals(bitUsuario.getDesCurp())) {

				logger.info("CURP login y Credencia coinciden: ");
				testlifecredencial.setResultado("Credencial valida");

				// String
				// urlIneRostro="https://validmobile.iqsec.mx/WSValidateDummy/Handler.ashx";
				String urlIneRostro = "https://validmobile.iqsec.mx/WSCommerceFielValidateR/Handler.ashx";

				IneRostroParametro ineRostroParametro = new IneRostroParametro();
				ineRostroParametro.setOper("IneRostro");
				ineRostroParametro.setEntidad("imss");
				ineRostroParametro.setUsuario("user_imss_prueba");
				ineRostroParametro.setClaveUsuario("Lm55.tReA3H6q");
				ineRostroParametro.setCic(cic);
				ineRostroParametro.setNombre(desNombre.toUpperCase());
				ineRostroParametro.setPaterno(desPrimerApellido.toUpperCase());
				ineRostroParametro.setMaterno(desSegundoApellido.toUpperCase());
				ineRostroParametro.setClaveElector(desClaveElector.toUpperCase());
				ineRostroParametro.setNumeroEmision(desNumeroEmision.toUpperCase());
				ineRostroParametro.setCurp(desCurpCredencial.toUpperCase());
				ineRostroParametro.setAnioRegistro(desAnioRegistro);
				ineRostroParametro.setAnioEmision(desAnioEmision);
				ineRostroParametro.setLatitud(0.78);
				ineRostroParametro.setLongitud(0.675);
				ineRostroParametro.setMapaFacial(imagenAnverso);

				ineRostroParametro.setSexo(sexo);
				ineRostroParametro.setTipo(tipo);
				ineRostroParametro.setSubTipo(subTipo);

				WebClient webClient = WebClient.builder().baseUrl(urlIneRostro)
						.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
						.defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE).build();

				IneRostroVO ineRostroVO = webClient.post().body(BodyInserters.fromObject(ineRostroParametro)).retrieve()
						.bodyToMono(IneRostroVO.class).block();
				logger.info("ineRostroVO.getEstado() ::: " + ineRostroVO.getEstado());
				logger.info("ineRostroVO.getDescripcion() ::: " + ineRostroVO.getDescripcion());

				if (ineRostroVO.getEstado().equals(0)) {

					logger.info("getDescripcion ::: " + ineRostroVO.getDescripcion());
					logger.info("isClaveElector ::: " + ineRostroVO.getResponse().getDataResponse().getRespuestaComparacion().isClaveElector());
					logger.info("isNombre ::: "+ ineRostroVO.getResponse().getDataResponse().getRespuestaComparacion().isNombre());
					logger.info("isApellidoPaterno ::: " + ineRostroVO.getResponse().getDataResponse().getRespuestaComparacion().isApellidoPaterno());
					logger.info("isOcr ::: "+ ineRostroVO.getResponse().getDataResponse().getRespuestaComparacion().isOcr());
					logger.info("getSimilitudA ::: " + ineRostroVO.getResponse().getFacialResponse().getSimilitud1());

					boolean claveElector = ineRostroVO.getResponse().getDataResponse().getRespuestaComparacion().isClaveElector();
					logger.info("claveElector " + claveElector);
					boolean anioRegistro = ineRostroVO.getResponse().getDataResponse().getRespuestaComparacion().isAnioRegistro();
					logger.info("anioRegistro " + anioRegistro);
					boolean apellidoPaterno = ineRostroVO.getResponse().getDataResponse().getRespuestaComparacion().isApellidoPaterno();
					logger.info("apellidoPaterno " + apellidoPaterno);
					boolean anioEmision = ineRostroVO.getResponse().getDataResponse().getRespuestaComparacion().isAnioEmision();
					logger.info("anioEmision " + anioEmision);
					boolean numeroEmisionCredencial = ineRostroVO.getResponse().getDataResponse().getRespuestaComparacion().isNumeroEmisionCredencial();
					logger.info("numeroEmisionCredencial " + numeroEmisionCredencial);
					boolean nombre = ineRostroVO.getResponse().getDataResponse().getRespuestaComparacion().isNombre();
					logger.info("nombre " + nombre);
					boolean curpvalida = ineRostroVO.getResponse().getDataResponse().getRespuestaComparacion().isCurp();
					logger.info("curpvalida " + curpvalida);
					boolean apellidoMaterno = ineRostroVO.getResponse().getDataResponse().getRespuestaComparacion().isApellidoMaterno();
					logger.info("apellidoMaterno" + apellidoMaterno);
					boolean ocr = ineRostroVO.getResponse().getDataResponse().getRespuestaComparacion().isOcr();
					logger.info("ocr" + ocr);
					String similitud1 = ineRostroVO.getResponse().getFacialResponse().getSimilitud1();
					logger.info("similitud1" + similitud1);

					testlifecredencial.setClaveElector(claveElector);
					testlifecredencial.setAnioRegistro(anioRegistro);
					testlifecredencial.setApellidoPaterno(apellidoPaterno);
					testlifecredencial.setAnioEmision(anioEmision);
					testlifecredencial.setNumeroEmisionCredencial(numeroEmisionCredencial);
					testlifecredencial.setNombre(nombre);
					testlifecredencial.setCurpvalida(curpvalida);
					testlifecredencial.setApellidoMaterno(apellidoMaterno);
					testlifecredencial.setOcr(ocr);
					testlifecredencial.setSimilitud1(similitud1);

					testlifecredencial.setDesCurpCredencial(desCurpCredencial);
					testlifecredencial.setDesNombre(desNombre);
					testlifecredencial.setDesPrimerApellido(desPrimerApellido);
					testlifecredencial.setDesSegundoApellido(desSegundoApellido);
					testlifecredencial.setDesClaveElector(desClaveElector);

					testlifecredencial.setDesNumeroEmision(desNumeroEmision);
					testlifecredencial.setDesAnioRegistro(desAnioRegistro);
					testlifecredencial.setDesAnioEmision(desAnioEmision);
					testlifecredencial.setLatitud(latitud);
					testlifecredencial.setLongitud(longitud);

					testlifecredencial.setCodigo(1);
					try {
					logger.info("curpvalida::: " + curpvalida);
					if (!curpvalida) {
						testlifecredencial.setResultado("Verifique la CURP proporcionada");
						testlifecredencial.setCodigo(1);
						testlifecredencial.setMensaje("Error ");
					} else if (!claveElector) {
						testlifecredencial.setResultado("Verifique la Clave de elector proporcionada");
						testlifecredencial.setCodigo(1);
						testlifecredencial.setMensaje("Error ");
					} else if (!anioRegistro) {
						testlifecredencial.setResultado("Verifique el año de registro proporcionado");
						testlifecredencial.setCodigo(1);
						testlifecredencial.setMensaje("Error ");
					} else if (!nombre) {
						testlifecredencial.setResultado("Verifique el nombre proporcionado");
						testlifecredencial.setCodigo(1);
						testlifecredencial.setMensaje("Error ");
					} else if (!apellidoPaterno) {
						testlifecredencial.setResultado("Verifique el apellido paterno proporcionado");
						testlifecredencial.setCodigo(1);
						testlifecredencial.setMensaje("Error ");
					} else if (!apellidoMaterno) {
						testlifecredencial.setResultado("Verifique el apellido materno proporcionado");
						testlifecredencial.setCodigo(1);
						testlifecredencial.setMensaje("Error ");
					} else if (!anioEmision) {
						testlifecredencial.setResultado("Verifique el año de emisión proporcionado");
						testlifecredencial.setCodigo(1);
						testlifecredencial.setMensaje("Error ");
					} else if (!numeroEmisionCredencial) {
						testlifecredencial.setResultado("Verifique el numero de emision proporcionado");
						testlifecredencial.setCodigo(1);
						testlifecredencial.setMensaje("Error ");
					} else {
						testlifecredencial.setResultado("Credencial correcta");
						testlifecredencial.setCodigo(0);
						testlifecredencial.setMensaje("Éxito");
						testlifecredencial.setFotoCredencial(loginUsuario.getImagen());
						
						logger.info(":::::::::::::::::::::Credencial correcta::: ");

						bitUsuario.setDesClaveElector(desClaveElector);
						bitUsuario.setDesCurpCredencial(desCurpCredencial);

						bitUsuario.setDesNombre(desNombre);
						bitUsuario.setDesPrimerApellido(desPrimerApellido);
						bitUsuario.setDesSegundoApellido(desSegundoApellido);
						bitUsuario.setDesNumeroEmision(desNumeroEmision);
						bitUsuario.setDesRegistroCredencial(desAnioRegistro);
						bitUsuario.setDesEmisionCredencial(desAnioEmision);
						
						logger.info(":::loginUsuario.getImagen():: "+ loginUsuario.getImagen());
					 	bitUsuario.setFotoCredencial(loginUsuario.getImagen());
					 	bitUsuario.setFotoCredencialReverso(loginUsuario.getImagenreverso());

						bitUsuario.setDesCic(cic);
						bitUsuario.setDesSexoCredencial(sexo);
						bitUsuario.setDesTipoCredencial(tipo);
						bitUsuario.setDesSubtipoCredencial(subTipo);
						logger.info("antes de guardar:: ");
						bitUsuarioService.guardarBitUsuario(bitUsuario);
						logger.info("despues de guardar:: ");
			 
					}
				}catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}

					logger.info(">>>>>>>>>>>getResultado ::: " + testlifecredencial.getResultado());

				} else {
					logger.info("descripcion de respuesta  " + ineRostroVO.getDescripcion());
					testlifecredencial.setResultado(ineRostroVO.getDescripcion());

				}
			} else {
				logger.info(
						"Verifique la credencial proporcionada la CURP de la fiel y la CURP de la credencial son diferentes  ");
				testlifecredencial.setResultado("Verifique la credencial proporcionada");
			}

 
		
		logger.info("TERMINA registraCredencial "  );
		return testlifecredencial;

	
}
	
	
}
