package mx.gob.imss.biometricos.service;

import java.util.List; 

import java.util.Date;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mx.gob.imss.biometricos.model.BitUsuario;
import mx.gob.imss.biometricos.model.BtcEstatusMedioContacto; 
import mx.gob.imss.biometricos.model.BttMedioContacto; 

public interface  BttMedioContactoService { 

	public BttMedioContacto findBttMedioContactoByCveIdMedioContacto(Long cveIdMedioContacto);

	public List<BttMedioContacto> findAllBttMedioContacto();

	public Page<BttMedioContacto> findAllBttMedioContacto(Pageable pageable);

	public List<BttMedioContacto> findBttMedioContactoByDesFolio(String desFolio);

	public List<BttMedioContacto> findBttMedioContactoByFecRegistro(Date fecRegistro);

	public List<BttMedioContacto> findBttMedioContactoByDesCorreoElectronico(String desCorreoElectronico);

	public List<BttMedioContacto> findBttMedioContactoByDesTelefono(String desTelefono);

	public List<BttMedioContacto> findBttMedioContactoByBtcEstatusMedioContacto(BtcEstatusMedioContacto btcEstatusMedioContacto);

	public List<BttMedioContacto> findBttMedioContactoByFecConfirmacion(Date fecConfirmacion);

	public List<BttMedioContacto> findBttMedioContactoByFecBaja(Date fecBaja);

	public List<BttMedioContacto> findBttMedioContactoByDesAclaracion(String desAclaracion);

	public List<BttMedioContacto> findBttMedioContactoByFecSolicitudAclaracion(Date fecSolicitudAclaracion);

	public List<BttMedioContacto> findBttMedioContactoByCveIdUsuario(Long cveIdUsuario);
	
	public Page<BttMedioContacto> findBttMedioContactoByCveIdUsuario(Long cveIdUsuario, Pageable pageable);

	public BttMedioContacto saveBttMedioContacto(BttMedioContacto bttMedioContacto);

	public void deleteBttMedioContacto(BttMedioContacto bttMedioContacto);

	List<BttMedioContacto> findBttMedioContactoByDesCorreoElectronicoAndCveIdUsuario(String desCorreoElectronico, Long cveIdUsuario);

	boolean cancelaMediosContacto(); 

	List<BttMedioContacto> findBttMedioContactoByDesCorreoElectronicoAndCveIdUsuarioAndFecBajaNull(String desCorreoElectronico, Long cveIdUsuario); 

	String acuseValidacionMedioContacto(String folio, String desRfc, String razonsocial, String curp, String registrosPatronales, BitUsuario bitUsuario, String correo, Date fechaActual) throws Exception;

	String acuseValidacionMedioContactoTelefono(String folio, String desRfc, String razonsocial, String curp, String registrosPatronales, BitUsuario bitUsuario, String telefono, Date fechaActual)throws Exception;

	List<BttMedioContacto> findBttMedioContactoCorreoByCveIdUsuarioAndFecBajaNull(Long cveIdUsuario); 
	
	List<BttMedioContacto> findBttMedioContactoByDesCorreoElectronicoAndCveIdUsuarioAndFecBajaNullRFC(String desCorreoElectronico, Long cveIdUsuario);

	List<BttMedioContacto> findBttMedioContactoByCveIdUsuarioAndFecBajaNull(Long cveIdUsuario);

	void eliminarBttMedioContacto(BttMedioContacto bttMedioContacto);

	Page<BttMedioContacto> findBttMedioContactoByCveIdUsuarioAll(Long cveIdUsuario, Pageable pageable);

	String acuseBajaMedioContacto(String folio, String desRfc, String razonsocial, String curp,	String registrosPatronales, BitUsuario bitUsuario, String correo, Date fechaActual);

	String acuseBajaMedioContactoTelefono(String folio, String desRfc, String razonsocial, String curp,	String registrosPatronales, BitUsuario bitUsuario, String telefono, Date fechaActual); 
	BttMedioContacto confirmaMedioContacto(BttMedioContacto bttMedioContacto) throws Exception; 

	boolean medioContactoRegistradoConRFC(BitUsuario bitUsuario, BttMedioContacto bttMedioContactoRP) throws Exception;

	List<BttMedioContacto> findBttMedioContactoByDesCorreoElectronicoAndCveIdUsuarioOrderByFecRegistro(String desCorreoElectronico, Long cveIdUsuario); 

	List<BttMedioContacto> getMediosComunicacionRFC(BitUsuario bitUsuario);
  
	BttMedioContacto createMedioContacto(Long cveIdTipoMedioContacto, BttMedioContacto bttmediocontacto, Long cveIdUsuario) throws Exception;

	Page<BttMedioContacto> findBttMedioContactoByCveIdUsuarioAllAutorizado(Long cveIdUsuario, Pageable pageable);
 
 
}
