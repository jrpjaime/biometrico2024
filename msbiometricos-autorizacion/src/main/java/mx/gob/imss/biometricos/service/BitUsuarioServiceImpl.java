package mx.gob.imss.biometricos.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mx.gob.imss.biometricos.model.BitUsuario;
import mx.gob.imss.biometricos.model.BitUsuarioRole; 
import mx.gob.imss.biometricos.model.BttMedioContacto;
import mx.gob.imss.biometricos.model.BttPatron;
import mx.gob.imss.biometricos.model.BttPatronMedioContacto; 
import mx.gob.imss.biometricos.repository.BitUsuarioRepository;
import mx.gob.imss.biometricos.util.Constantes;
import mx.gob.imss.biometricos.util.SessionConstants;
import mx.gob.imss.biometricos.util.UtileriasService;

@Service("bitUsuarioService")
public class  BitUsuarioServiceImpl implements BitUsuarioService  { 
	
	private static final Logger logger = LogManager.getLogger(BitUsuarioServiceImpl.class);

	@Autowired
	private BitUsuarioRepository bitUsuarioRepository;
	
 
	
	@Autowired
	private  BitUsuarioService bitUsuarioService;
 
	
	@Autowired
	private BitUsuarioRoleService bitUsuarioRoleService;
	
 

	@Autowired
	private DataSource datasource;

	/*
	 * Método de consulta por cveIdUsuario
	*/
	@Override
	@Transactional
	public BitUsuario findBitUsuarioByCveIdUsuario(Long cveIdUsuario){
		BitUsuario bitUsuario=bitUsuarioRepository.findBitUsuarioByCveIdUsuario(cveIdUsuario); 
		return bitUsuario;
	}

	/*
	 * Método de consulta findAll
	*/
	@Override
	@Transactional
	public List<BitUsuario> findAllBitUsuario(){
		List<BitUsuario> bitUsuario=bitUsuarioRepository.findAll(); 
		return bitUsuario;
	}

	/*
	 * Método de consulta findAll order by Fecha actualizacion
	*/
	@Override
	@Transactional
	public List<BitUsuario> findAllBitUsuarioOrderByFecActualizacion(){
		List<BitUsuario> bitUsuario=bitUsuarioRepository.findAllBitUsuarioOrderByFecActualizacion(); 
		return bitUsuario;
	}

	/*
	 * Método de consulta findAll
	*/
	@Override
	@Transactional
	public List<BitUsuario> findallBitUsuarioByCveEntFedIsNull(){
		List<BitUsuario> bitUsuario=bitUsuarioRepository.findBitUsuarioByCveEntFedIsNull();
		return bitUsuario;
	}

	@Override
	@Transactional
	public List<BitUsuario> findAllBitUsuarioOrderByDesNombre(){
		List<BitUsuario> bitUsuario=bitUsuarioRepository.findAllBitUsuarioOrderByDesNombre(); 
		return bitUsuario;
	}


	/*
	 * Método de consulta findAll
	*/
	@Override
	@Transactional
	public Page<BitUsuario> findAllBitUsuario(Pageable pageable){
		Page<BitUsuario> bitUsuario=bitUsuarioRepository.findAll(pageable); 
		return bitUsuario;
	}

	/*
	 * Método de consulta por desPassword
	*/
	@Override
	@Transactional
	public List<BitUsuario> findBitUsuarioByDesPassword(String desPassword){
		List<BitUsuario> bitUsuario=bitUsuarioRepository.findBitUsuarioByDesPassword(desPassword); 
		return bitUsuario;
	}

	/*
	 * Método de consulta por desNombre
	*/
	@Override
	@Transactional
	public List<BitUsuario> findBitUsuarioByDesNombre(String desNombre){
		List<BitUsuario> bitUsuario=bitUsuarioRepository.findBitUsuarioByDesNombre(desNombre); 
		return bitUsuario;
	}

	/*
	 * Método de consulta por desRfc
	*/
	@Override
	@Transactional
	public List<BitUsuario> findBitUsuarioByDesRfc(String desRfc){
		List<BitUsuario> bitUsuario=bitUsuarioRepository.findBitUsuarioByDesRfc(desRfc); 
		return bitUsuario;
	}

	/*
	 * Método de consulta por desPrimerApellido
	*/
	@Override
	@Transactional
	public List<BitUsuario> findBitUsuarioByDesPrimerApellido(String desPrimerApellido){
		List<BitUsuario> bitUsuario=bitUsuarioRepository.findBitUsuarioByDesPrimerApellido(desPrimerApellido); 
		return bitUsuario;
	}

	/*
	 * Método de consulta por desSegundoApellido
	*/
	@Override
	@Transactional
	public List<BitUsuario> findBitUsuarioByDesSegundoApellido(String desSegundoApellido){
		List<BitUsuario> bitUsuario=bitUsuarioRepository.findBitUsuarioByDesSegundoApellido(desSegundoApellido); 
		return bitUsuario;
	}

	/*
	 * Método de consulta por indActivo
	*/
	@Override
	@Transactional
	public List<BitUsuario> findBitUsuarioByIndActivo(Integer indActivo){
		List<BitUsuario> bitUsuario=bitUsuarioRepository.findBitUsuarioByIndActivo(indActivo); 
		return bitUsuario;
	}
	
	
	@Override
	@Transactional
	public List<BitUsuario> findBitUsuarioByfecAceptacionNotNull(){
		List<BitUsuario> bitUsuario=bitUsuarioRepository.findBitUsuarioByfecAceptacionNotNull(); 
		return bitUsuario;
	}

	/*
	 * Método de consulta por desUsuario
	*/
	@Override
	@Transactional
	public List<BitUsuario> findBitUsuarioByDesUsuario(String desUsuario){
		List<BitUsuario> bitUsuario=bitUsuarioRepository.findBitUsuarioByDesUsuario(desUsuario); 
		return bitUsuario;
	}
	
	
	@Override
	@Transactional
	public  BitUsuario  findBitUsuarioByDesUsuarioUnico(String desUsuario){
		 BitUsuario  bitUsuario=bitUsuarioRepository.findBitUsuarioByDesUsuarioUnico(desUsuario); 
		return bitUsuario;
	}

	/*
	 * Método de consulta por desEmail
	*/
	@Override
	@Transactional
	public List<BitUsuario> findBitUsuarioByDesEmail(String desEmail){
		List<BitUsuario> bitUsuario=bitUsuarioRepository.findBitUsuarioByDesEmail(desEmail); 
		return bitUsuario;
	}

	/*
	 * Método para guardar BitUsuario
	*/
	@Override
	@Transactional
	public BitUsuario saveBitUsuario(BitUsuario bitUsuario) {
		BitUsuario existingBitUsuario=bitUsuarioRepository.findBitUsuarioByCveIdUsuario(bitUsuario.getCveIdUsuario());


		if (existingBitUsuario != null){ 
			if (existingBitUsuario != bitUsuario){ 
				existingBitUsuario.setDesPassword(bitUsuario.getDesPassword());
				existingBitUsuario.setDesNombre(bitUsuario.getDesNombre());
				existingBitUsuario.setDesRfc(bitUsuario.getDesRfc());
				existingBitUsuario.setDesPrimerApellido(bitUsuario.getDesPrimerApellido());
				existingBitUsuario.setDesSegundoApellido(bitUsuario.getDesSegundoApellido());
				existingBitUsuario.setCveIdUsuario(bitUsuario.getCveIdUsuario());
				existingBitUsuario.setIndActivo(bitUsuario.getIndActivo());
				existingBitUsuario.setDesUsuario(bitUsuario.getDesUsuario());
				existingBitUsuario.setDesEmail(bitUsuario.getDesEmail());
				existingBitUsuario.setFecConfirmaMedContacto(bitUsuario.getFecConfirmaMedContacto()); 
				existingBitUsuario.setFecAceptacion(bitUsuario.getFecAceptacion());
				existingBitUsuario.setDesPathAcuseHdfs(bitUsuario.getDesPathAcuseHdfs());
				existingBitUsuario.setFolioAceptacion(bitUsuario.getFolioAceptacion()); 
				existingBitUsuario.setFecRegistro(bitUsuario.getFecRegistro());
			//	existingBitUsuario.setBitUsuarioRoles(bitUsuario.getBitUsuarioRoles());
				bitUsuario = bitUsuarioRepository.saveAndFlush(bitUsuario);
			}
			 
		} else {
		bitUsuario = bitUsuarioRepository.saveAndFlush(bitUsuario);
		}
		
		 
	return bitUsuario;
	}
	
	
	
	@Override
	@Transactional
	public BitUsuario guardarBitUsuario(BitUsuario bitUsuario) { 
		bitUsuario = bitUsuarioRepository.saveAndFlush(bitUsuario);
		  
	return bitUsuario;
	}
	
	
	
	@Override
	@Transactional
	public BitUsuario updateBitUsuario(BitUsuario bitUsuario) {
 
		bitUsuario = bitUsuarioRepository.saveAndFlush(bitUsuario);
		  
		
		 
	    return bitUsuario;
	}
	

	/*
	 * Método para eliminar BitUsuario existente
	*/
	@Override
	@Transactional
	public void deleteBitUsuario(BitUsuario bitUsuario) {
			bitUsuarioRepository.delete(bitUsuario);
	}
	
	 
	
	 
	
	
	
	@Override
	@Transactional
	public List<BitUsuario> findallBitUsuarioByClaveMunicipioIsNull(){
		List<BitUsuario> bitUsuario=bitUsuarioRepository.findallBitUsuarioByClaveMunicipioIsNull();
		return bitUsuario;
	}

	 
	
 

 

	}
