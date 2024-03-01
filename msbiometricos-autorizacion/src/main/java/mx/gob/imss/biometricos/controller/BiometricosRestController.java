package mx.gob.imss.biometricos.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.ModelAndView;

import com.nimbusds.jose.shaded.json.JSONObject;
import com.nimbusds.jose.shaded.json.parser.JSONParser;

import mx.gob.imss.biometricos.dto.Mensaje;
import mx.gob.imss.biometricos.model.BitUsuario;
import mx.gob.imss.biometricos.model.BttMedioContacto;
import mx.gob.imss.biometricos.security.controller.AuthController;
import mx.gob.imss.biometricos.security.dto.JwtDto;
import mx.gob.imss.biometricos.security.dto.LoginUsuarioDto;
import mx.gob.imss.biometricos.service.BiometricoService;
import mx.gob.imss.biometricos.service.BitUsuarioService;
import mx.gob.imss.biometricos.service.BttMedioContactoService;
import mx.gob.imss.biometricos.service.BttPatronMedioContactoService;
import mx.gob.imss.biometricos.service.TokenService;
import mx.gob.imss.biometricos.util.UtileriasService;
import mx.gob.imss.biometricos.vo.ContactoVO;
import mx.gob.imss.biometricos.vo.IneRostroParametro;
import mx.gob.imss.biometricos.vo.IneRostroVO;
import mx.gob.imss.biometricos.vo.Testlifecredencial;
import mx.gob.imss.biometricos.ws.wsbiometricos.WebService;
import mx.gob.imss.biometricos.ws.wsbiometricos.WebServiceSoap;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;

@RestController
@RequestMapping("/msbiometricos-autorizacion/v1")
@CrossOrigin // (origins = "*")
public class BiometricosRestController {
	private final static Logger logger = LoggerFactory.getLogger(BiometricosRestController.class);

	@Autowired
	private UtileriasService utileriasService;

	@Autowired
	private BttPatronMedioContactoService bttPatronMedioContactoService;

	@Autowired
	private BitUsuarioService bitUsuarioService;

	@Autowired
	private BttMedioContactoService bttMedioContactoService;
	
	@Autowired
	private BiometricoService biometricoService;

	@GetMapping("/lista")
	public ResponseEntity<List<String>> list() {
		List<String> list = new ArrayList<String>();
		list.add("Hola");
		list.add("como estas");
		list.add("hoy");
		return new ResponseEntity(list, HttpStatus.OK);
	}

	@GetMapping(value = "/listContacto")
	public ResponseEntity<Page<BttMedioContacto>> listContacto(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "fecRegistro") String orders,
			@RequestParam(defaultValue = "true") boolean asc, @RequestParam(defaultValue = "") String cveIdUsuario) {

		logger.info("/listContacto");
		Page<BttMedioContacto> listPaginada = null;

		BitUsuario bitUsuario = bitUsuarioService.findBitUsuarioByCveIdUsuario(Long.parseLong(cveIdUsuario));
		logger.info("bitUsuario.getCveIdUsuario(): " + bitUsuario.getCveIdUsuario());
		logger.info("bitUsuario.getDesNombre(): " + bitUsuario.getDesNombre());
		listPaginada = bttMedioContactoService.findBttMedioContactoByCveIdUsuarioAll(bitUsuario.getCveIdUsuario(),
				PageRequest.of(page, size, org.springframework.data.domain.Sort.by(orders)));

		return new ResponseEntity(listPaginada, HttpStatus.OK);
	}

	@GetMapping(value = "/listContactoAutorizado")
	public ResponseEntity<Page<BttMedioContacto>> listContactoAutorizado(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "fecRegistro") String orders,
			@RequestParam(defaultValue = "true") boolean asc, @RequestParam(defaultValue = "") String cveIdUsuario) {

		logger.info("/listContacto");
		Page<BttMedioContacto> listPaginada = null;

		BitUsuario bitUsuario = bitUsuarioService.findBitUsuarioByCveIdUsuario(Long.parseLong(cveIdUsuario));
		logger.info("bitUsuario.getCveIdUsuario(): " + bitUsuario.getCveIdUsuario());
		logger.info("bitUsuario.getDesNombre(): " + bitUsuario.getDesNombre());
		listPaginada = bttMedioContactoService.findBttMedioContactoByCveIdUsuarioAllAutorizado(
				bitUsuario.getCveIdUsuario(),
				PageRequest.of(page, size, org.springframework.data.domain.Sort.by(orders)));

		return new ResponseEntity(listPaginada, HttpStatus.OK);
	}

	@PostMapping("/createContacto")
	public ContactoVO createContacto(@RequestBody ContactoVO contactoVO) {
		// registro de medios de contacto de RFC

		logger.info("/createContacto");
		logger.info("getRfc: " + contactoVO.getRfc());
		logger.info("getCveIdUsuario: " + contactoVO.getCveIdUsuario());
		logger.info("getDesCorreoElectronico: " + contactoVO.getDesCorreoElectronico());

		Long cveIdTipoMedioContacto = 1L;

		Integer countEmailRegistradosRfc = 0;
		Integer countCelularesRegistradosRfc = 0;

		String rfc = contactoVO.getRfc();
		String nombreUsuario = contactoVO.getNombreUsuario();

		boolean medioContactoRegistrado = false;
		boolean indAceptarBuzon = false;
		boolean indConfirmoMediosContacto = false;
		Long idRole = 0L;
		String userName = "";
		String desRfc = "";
		Long cveIdUsuario = null;
		String razonsocial = "";
		String registrosPatronales = "";
		// BitUsuario bitUsuario=new BitUsuario();
		// if(!bitUsuarios.isEmpty()) {

		// Obtiene el nombre del usuario logueado
		// bitUsuario=bitUsuarios.iterator().next();
		logger.info("nombreUsuario: " + nombreUsuario);
		BitUsuario bitUsuario = bitUsuarioService.findBitUsuarioByDesUsuarioUnico(nombreUsuario);
		desRfc = bitUsuario.getDesRfc();
		cveIdUsuario = bitUsuario.getCveIdUsuario();
		// Nota: verificar si el nombre o razon social esta en el campo nombre o es un
		// campo adicional
		razonsocial = bitUsuario.getDesNombre();
		// }

		// verifica que el medio de contacto no se encuentre registrado con el RFC

		logger.info("cveIdUsuario: " + cveIdUsuario);

		List<BttMedioContacto> bttMedioContactosExistentes = bttMedioContactoService
				.findBttMedioContactoCorreoByCveIdUsuarioAndFecBajaNull(cveIdUsuario);

		logger.info("bttMedioContactosExistentes.isEmpty(): " + bttMedioContactosExistentes.isEmpty());

		for (BttMedioContacto bttMedioContacto : bttMedioContactosExistentes) {

			logger.info("bttMedioContacto.getCveIdMedioContacto(): " + bttMedioContacto.getCveIdMedioContacto());
			logger.info("bttMedioContacto.getDesCorreoElectronico(): " + bttMedioContacto.getDesCorreoElectronico());
			logger.info("contactoVO.getDesCorreoElectronico(): " + contactoVO.getDesCorreoElectronico());
			logger.info("bttMedioContacto.getBttPatronMedioContactos().isEmpty(): "
					+ bttMedioContacto.getBttPatronMedioContactos().isEmpty());
			if (bttMedioContacto.getDesCorreoElectronico().trim().toUpperCase()
					.equals(contactoVO.getDesCorreoElectronico().trim().toUpperCase())
					&& bttMedioContacto.getBttPatronMedioContactos().isEmpty()) {
				// si se cumple la condicion es un medio de contacto registrado para el RFC

				contactoVO.setCodigo(2);
				contactoVO.setMensaje("Ya tiene registrado el medio de contacto.");
				return contactoVO;

			}

		}

		List<BttMedioContacto> bttMedioContactosValidacion = bttMedioContactoService
				.findBttMedioContactoByCveIdUsuario(cveIdUsuario);

		// cuenta los medios de contacto registrados para el RFC los contabiliza par
		// evitar el registro cuando son mas de 1 telefono o 5 correos
		// cuenta a un que no esten confirmados
		for (BttMedioContacto bttMedioContacto : bttMedioContactosValidacion) {
			// cuenta solo si estan confirmados

			boolean mediosContactoRFC = bttPatronMedioContactoService.isMedioContactoRfc(bttMedioContacto);

			// cuenta todos los registrados y que no esten en baja
			if (mediosContactoRFC && bttMedioContacto.getFecBaja() == null) {
				if (contactoVO.getDesCorreoElectronico().trim().toUpperCase()
						.equals(bttMedioContacto.getDesCorreoElectronico().trim().toUpperCase())) {
					// si encuentra el medio de contacto previamente registrado manda error

					contactoVO.setCodigo(2);
					contactoVO.setMensaje("Ya tiene registrado el medio de contacto.");
					return contactoVO;
				}

				if (bttMedioContacto.getBtcTipoMedioContacto().getCveIdTipoMedioContacto() == 1L) {
					countEmailRegistradosRfc++;
				} else if (bttMedioContacto.getBtcTipoMedioContacto().getCveIdTipoMedioContacto() == 2L) {
					countCelularesRegistradosRfc++;
				}

			}

		}

		logger.info("countEmailRegistradosRfc: " + countEmailRegistradosRfc);

		if (countEmailRegistradosRfc >= 5) {
			contactoVO.setCodigo(2);
			contactoVO.setMensaje("Solo puede registrar hasta 5 correos electrónicos");
			return contactoVO;
		}

		if (countCelularesRegistradosRfc > 1) {
			contactoVO.setCodigo(2);
			contactoVO.setMensaje("Solo puede registrar un teléfono celular");
			return contactoVO;
		}

		if (contactoVO.getDesCorreoElectronico().trim().equals("")) {
			contactoVO.setCodigo(2);
			contactoVO.setMensaje("Proporcione el medio de contacto");
			return contactoVO;
		}

		BttMedioContacto bttmediocontacto = new BttMedioContacto();
		try {
			logger.info("bttMedioContactoService.createMedioContacto");
			bttmediocontacto.setDesCorreoElectronico(contactoVO.getDesCorreoElectronico());
			bttmediocontacto = bttMedioContactoService.createMedioContacto(cveIdTipoMedioContacto, bttmediocontacto,
					cveIdUsuario);
		} catch (Exception e) {
			e.printStackTrace();
			contactoVO.setMensaje("Error al registrar el medio de contacto");
			// TODO: handle exception
		}
		contactoVO.setCodigo(1);
		contactoVO.setMensaje("Éxito");
		return contactoVO;
	}

	@PostMapping("/deleteContacto")
	public ContactoVO deleteContacto(@RequestBody ContactoVO contactoVO) {
		// eliminación de medios de contacto de RFC

		logger.info("/deleteContacto");
		logger.info("getRfc: " + contactoVO.getRfc());
		logger.info("getCveIdUsuario: " + contactoVO.getCveIdUsuario());
		logger.info("getCveIdMedioContacto: " + contactoVO.getCveIdMedioContacto());

		BttMedioContacto bttMedioContacto = bttMedioContactoService
				.findBttMedioContactoByCveIdMedioContacto(contactoVO.getCveIdMedioContacto());
		bttMedioContactoService.deleteBttMedioContacto(bttMedioContacto);

		contactoVO.setCodigo(1);
		contactoVO.setMensaje("Éxito");
		return contactoVO;

	}

	@PostMapping("/validarContacto")
	public ContactoVO validarContacto(@RequestBody ContactoVO contactoVO) {
		// confirmacion de medios de contacto correo

		logger.info("/validarContacto");

		Long cveIdMedioContacto = null;
		try {
			cveIdMedioContacto = Long.valueOf(utileriasService.desencriptar(contactoVO.getCode()));
			logger.info("cveIdMedioContacto: " + cveIdMedioContacto);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		BttMedioContacto bttMedioContacto = bttMedioContactoService
				.findBttMedioContactoByCveIdMedioContacto(cveIdMedioContacto);
		if (bttMedioContacto != null) {
			if (bttMedioContacto.getFecConfirmacion() == null
					&& bttMedioContacto.getBtcEstatusMedioContacto().getCveIdEstatusMedioContacto() == 1L
					&& bttMedioContacto.getFecBaja() == null) {

				try {
					bttMedioContacto = bttMedioContactoService.confirmaMedioContacto(bttMedioContacto);
				} catch (Exception e) {
					e.printStackTrace();
					bttMedioContacto = new BttMedioContacto();
					// TODO: handle exception
				}

			} else if (bttMedioContacto.getFecConfirmacion() != null
					&& bttMedioContacto.getBtcEstatusMedioContacto().getCveIdEstatusMedioContacto() == 2L
					&& bttMedioContacto.getFecBaja() == null) {
				// medio de contacto ya se encuentra confirmado
				contactoVO.setCodigo(2);
				contactoVO.setMensaje("El medio de contacto ya se encuentra confirmado");
				return contactoVO;

			} else if (bttMedioContacto.getFecConfirmacion() == null && bttMedioContacto.getFecBaja() != null
					&& bttMedioContacto.getBtcEstatusMedioContacto().getCveIdEstatusMedioContacto() == 3L) {
				// el medio de comunicacion esta dado de baja por vencimiento de 72
				bttMedioContacto = bttMedioContactoService
						.findBttMedioContactoByCveIdMedioContacto(bttMedioContacto.getCveIdMedioContacto());
				contactoVO.setCodigo(2);
				contactoVO.setMensaje("El medio de contacto ya está en baja");
				return contactoVO;
			} else if (bttMedioContacto.getFecBaja() != null
					&& bttMedioContacto.getBtcEstatusMedioContacto().getCveIdEstatusMedioContacto() == 4L) {
				// el medio de comunicacion esta dado de baja
				// bttMedioContacto=
				// bttMedioContactoService.findBttMedioContactoByCveIdMedioContacto(bttMedioContacto.getCveIdMedioContacto());
				// modelAndView.addObject("bttMedioContacto", bttMedioContacto);

				contactoVO.setCodigo(2);
				contactoVO.setMensaje("El medio de contacto ya está dado de baja");
				return contactoVO;

			}

		} else {
			contactoVO.setCodigo(2);
			contactoVO.setMensaje("El medio de contacto ya está dado de baja");
			return contactoVO;
		}

		contactoVO.setCodigo(1);
		contactoVO.setMensaje("Éxito");
		return contactoVO;
	}

	@PostMapping("/validarCredencial")
	public Testlifecredencial validarCredencial(@RequestBody Testlifecredencial testlifecredencial) {
		// a partir de que se realiza la prueba de vida se obtiene la imagen que se
		// envia al validador de INE rostro

		logger.info("/validarCredencial");
		logger.info("getFotoPruebaVida: " + testlifecredencial.getFotoPruebaVida());
		logger.info("curp: " + testlifecredencial.getCurp());
		logger.info("getUsername: " + testlifecredencial.getUsername());
		logger.info("getRfc: " + testlifecredencial.getRfc());
		logger.info("cveIdUsuario: " + testlifecredencial.getCveIdUsuario());

		String nombreUsuario = testlifecredencial.getNombreUsuario();
		BitUsuario bitUsuario = bitUsuarioService.findBitUsuarioByDesUsuarioUnico(nombreUsuario);
		testlifecredencial.setResultado("");

		// String
		// urlIneRostro="https://validmobile.iqsec.mx/WSValidateDummy/Handler.ashx";
		String urlIneRostro = "https://validmobile.iqsec.mx/WSCommerceFielValidateR/Handler.ashx";

		IneRostroParametro ineRostroParametro = new IneRostroParametro();
		ineRostroParametro.setOper("IneRostro");
		ineRostroParametro.setEntidad("imss");
		ineRostroParametro.setUsuario("user_imss_prueba");
		ineRostroParametro.setClaveUsuario("Lm55.tReA3H6q");
		ineRostroParametro.setCic(bitUsuario.getDesCic());
		ineRostroParametro.setNombre(bitUsuario.getDesNombre());
		ineRostroParametro.setPaterno(bitUsuario.getDesPrimerApellido());
		ineRostroParametro.setMaterno(bitUsuario.getDesSegundoApellido());
		ineRostroParametro.setClaveElector(bitUsuario.getDesClaveElector());
		ineRostroParametro.setNumeroEmision(bitUsuario.getDesNumeroEmision());
		ineRostroParametro.setCurp(bitUsuario.getDesCurpCredencial());
		ineRostroParametro.setAnioRegistro(bitUsuario.getDesRegistroCredencial());
		ineRostroParametro.setAnioEmision(bitUsuario.getDesEmisionCredencial());
		ineRostroParametro.setLatitud(0.78);
		ineRostroParametro.setLongitud(0.675);
		ineRostroParametro.setMapaFacial(testlifecredencial.getFotoPruebaVida());

		logger.info("envia a IneRostro: ");
		logger.info("bitUsuario.getDesNombre(): " + bitUsuario.getDesNombre());
		logger.info("bitUsuario.getDesPrimerApellido(): " + bitUsuario.getDesPrimerApellido());
		logger.info("bitUsuario.getDesSegundoApellido(): " + bitUsuario.getDesSegundoApellido());
		logger.info("bitUsuario.getDesCic() : " + bitUsuario.getDesCic());
		logger.info("bitUsuario.getDesClaveElector(): " + bitUsuario.getDesClaveElector());
		logger.info("bitUsuario.getDesNumeroEmision(): " + bitUsuario.getDesNumeroEmision());
		logger.info("bitUsuario.getDesCurpCredencial(): " + bitUsuario.getDesCurpCredencial());
		logger.info("bitUsuario.getDesRegistroCredencial(): " + bitUsuario.getDesRegistroCredencial());
		logger.info("bitUsuario.getDesEmisionCredencial(): " + bitUsuario.getDesEmisionCredencial());

		String resultado = null;

		WebClient webClient = WebClient.builder().baseUrl(urlIneRostro)
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE).build();

		IneRostroVO ineRostroVO = webClient.post().body(BodyInserters.fromObject(ineRostroParametro)).retrieve()
				.bodyToMono(IneRostroVO.class).block();

		logger.info("Respuesta de inerostro ::: ");

		logger.info("ineRostroVO.getEstado() ::: " + ineRostroVO.getEstado());
		logger.info("ineRostroVO.getDescripcion() ::: " + ineRostroVO.getDescripcion());

		resultado = ineRostroVO.getDescripcion();
		
		testlifecredencial.setEstado(ineRostroVO.getEstado());
		testlifecredencial.setResultado(resultado);

		if (ineRostroVO.getEstado().equals(0)) {

			logger.info("getDescripcion ::: " + ineRostroVO.getDescripcion());

			logger.info("isClaveElector ::: "
					+ ineRostroVO.getResponse().getDataResponse().getRespuestaComparacion().isClaveElector());

			logger.info(
					"isNombre ::: " + ineRostroVO.getResponse().getDataResponse().getRespuestaComparacion().isNombre());

			logger.info("isApellidoPaterno ::: "
					+ ineRostroVO.getResponse().getDataResponse().getRespuestaComparacion().isApellidoPaterno());

			logger.info("isOcr ::: " + ineRostroVO.getResponse().getDataResponse().getRespuestaComparacion().isOcr());

			logger.info("getSimilitud1 ::: " + ineRostroVO.getResponse().getFacialResponse().getSimilitud1());

			boolean claveElector = ineRostroVO.getResponse().getDataResponse().getRespuestaComparacion().isClaveElector();
			boolean anioRegistro = ineRostroVO.getResponse().getDataResponse().getRespuestaComparacion().isAnioRegistro();
			boolean apellidoPaterno = ineRostroVO.getResponse().getDataResponse().getRespuestaComparacion().isApellidoPaterno();
			boolean anioEmision = ineRostroVO.getResponse().getDataResponse().getRespuestaComparacion().isAnioEmision();
			boolean numeroEmisionCredencial = ineRostroVO.getResponse().getDataResponse().getRespuestaComparacion().isNumeroEmisionCredencial();
			boolean nombre = ineRostroVO.getResponse().getDataResponse().getRespuestaComparacion().isNombre();
			boolean curpvalida = ineRostroVO.getResponse().getDataResponse().getRespuestaComparacion().isCurp();
			boolean apellidoMaterno = ineRostroVO.getResponse().getDataResponse().getRespuestaComparacion().isApellidoMaterno();
			boolean ocr = ineRostroVO.getResponse().getDataResponse().getRespuestaComparacion().isOcr();
			String similitud1 = ineRostroVO.getResponse().getFacialResponse().getSimilitud1();
			
			System.out.println("similitud1: "+ similitud1);

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

			testlifecredencial.setDesCurpCredencial(bitUsuario.getDesCurpCredencial());
			testlifecredencial.setDesNombre(bitUsuario.getDesNombre());
			testlifecredencial.setDesPrimerApellido(bitUsuario.getDesPrimerApellido());
			testlifecredencial.setDesSegundoApellido(bitUsuario.getDesSegundoApellido());
			testlifecredencial.setDesClaveElector(bitUsuario.getDesClaveElector());

			testlifecredencial.setDesNumeroEmision(bitUsuario.getDesNumeroEmision());
			testlifecredencial.setDesAnioRegistro(bitUsuario.getDesRegistroCredencial());
			testlifecredencial.setDesAnioEmision(bitUsuario.getDesEmisionCredencial());

			testlifecredencial.setFotoPruebaVida(testlifecredencial.getFotoPruebaVida());
			testlifecredencial.setFotoCredencial(bitUsuario.getFotoCredencial());

			Double similitud = Double.parseDouble(similitud1.subSequence(0, 5).toString());
			//Double similitudminima = 98.92d;
			//Double similitudminima = 95.92d;
			Double similitudminima = 60.00d;
			
			System.out.println("similitudminima: "+ similitudminima);

			int retval = Double.compare(similitud, similitudminima);

			if (retval > 0) {
				System.out.println("similitud is greater than similitudminima");
				resultado = "Prueba de vida satisfactoria";
				testlifecredencial.setResultado(resultado);
				testlifecredencial.setCofirmavida(true);
			} else if (retval < 0) {
				System.out.println("similitud is less than similitudminima");
				resultado = "Realice nuevamente su prueba de vida";
				testlifecredencial.setResultado(resultado);
				testlifecredencial.setCofirmavida(false);
			} else {
				System.out.println("similitud is equal to similitudminima");
				resultado = "Prueba de vida satisfactoria";
				testlifecredencial.setResultado(resultado);
				testlifecredencial.setCofirmavida(true);
			}

		}

		bitUsuario.setFotoPruebaVida(testlifecredencial.getFotoPruebaVida());
		bitUsuario.setResultado(resultado);
		bitUsuario.setFecPruebaVida(new Date());

		bitUsuarioService.guardarBitUsuario(bitUsuario);
		logger.info("testlifecredencial.getResultado(): " + testlifecredencial.getResultado());

		return testlifecredencial;
	}

	@PostMapping("/registrarCredencial")
	public Testlifecredencial registrarCredencial(@RequestBody LoginUsuarioDto loginUsuario) {

		logger.info("...................registrarCredencial.............................");
		Testlifecredencial testlifecredencial = new Testlifecredencial();
		try {
		testlifecredencial=biometricoService.registraCredencial(loginUsuario);
		}catch (Exception e) {
			testlifecredencial.setCodigo(1);
			testlifecredencial.setMensaje("Error al registrar la credencial");
			// TODO: handle exception
		}

		logger.info("*************Termina registrarCredencial***********************");
		return testlifecredencial;
	}

	@PostMapping("/verificaRegistroCredencial")
	public Testlifecredencial verificaRegistroCredencial(@RequestBody LoginUsuarioDto loginUsuario) {
		// verifica que antes de hacer la prueba de vida tenga registrada la credencial

		logger.info("...................verificaRegistroCredencial.............................");
		Testlifecredencial testlifecredencial = new Testlifecredencial();

		logger.info("loginUsuario.getNombreUsuario(): " + loginUsuario.getNombreUsuario());
		logger.info("loginUsuario.getPassword(): " + loginUsuario.getPassword());
		logger.info("loginUsuario.getOrigen(): " + loginUsuario.getOrigen());

		String nombreUsuario = loginUsuario.getNombreUsuario();
		BitUsuario bitUsuario = bitUsuarioService.findBitUsuarioByDesUsuarioUnico(nombreUsuario);

		if (bitUsuario.getDesClaveElector() == null || bitUsuario.getDesCurpCredencial() == null
				|| bitUsuario.getDesNumeroEmision() == null || bitUsuario.getDesRegistroCredencial() == null
				|| bitUsuario.getDesEmisionCredencial() == null) {
			testlifecredencial.setCodigo(1);
			testlifecredencial.setMensaje("Registre su credencial");

		} else {
			testlifecredencial.setCodigo(0);
			testlifecredencial.setMensaje("Éxito");
		}

		logger.info("...................TERMINA verificaRegistroCredencial.............................");
		return testlifecredencial;
	}

}
