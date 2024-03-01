package mx.gob.imss.biometricos.service;

import java.util.List;
import java.util.Date;
import javax.transaction.Transactional;

import mx.gob.imss.biometricos.model.BitUsuario;
import mx.gob.imss.biometricos.model.BitUsuarioRole;
import mx.gob.imss.biometricos.repository.BitUsuarioRoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service("bitUsuarioRoleService")
public class  BitUsuarioRoleServiceImpl implements BitUsuarioRoleService  { 

	@Autowired
	private BitUsuarioRoleRepository bitUsuarioRoleRepository;

	/*
	 * Método de consulta por cveIdUsuarioRole
	*/
	@Override
	@Transactional
	public BitUsuarioRole findBitUsuarioRoleByCveIdUsuarioRole(Long cveIdUsuarioRole){
		BitUsuarioRole bitUsuarioRole=bitUsuarioRoleRepository.findBitUsuarioRoleByCveIdUsuarioRole(cveIdUsuarioRole); 
		return bitUsuarioRole;
	}

	/*
	 * Método de consulta findAll
	*/
	@Override
	@Transactional
	public List<BitUsuarioRole> findAllBitUsuarioRole(){
		List<BitUsuarioRole> bitUsuarioRole=bitUsuarioRoleRepository.findAll(); 
		return bitUsuarioRole;
	}

	/*
	 * Método de consulta findAll
	*/
	@Override
	@Transactional
	public Page<BitUsuarioRole> findAllBitUsuarioRole(Pageable pageable){
		Page<BitUsuarioRole> bitUsuarioRole=bitUsuarioRoleRepository.findAll(pageable); 
		return bitUsuarioRole;
	}

	/*
	 * Método de consulta por cveIdUsuario
	*/
	/* 
	@Override
	@Transactional
	public List<BitUsuarioRole> findBitUsuarioRoleByCveIdUsuario(Long cveIdUsuario){
		List<BitUsuarioRole> bitUsuarioRole=bitUsuarioRoleRepository.findBitUsuarioRoleByCveIdUsuario(cveIdUsuario); 
		return bitUsuarioRole;
	}
*/
	@Override
	@Transactional
	public List<BitUsuarioRole> findBitUsuarioRoleByBitUsuario(BitUsuario bitUsuario){
		List<BitUsuarioRole> bitUsuarioRole=bitUsuarioRoleRepository.findBitUsuarioRoleByBitUsuario(bitUsuario); 
		return bitUsuarioRole;
	}

	 
	
	
	
	/*
	 * Método de consulta por cveIdRole
	*/
	/*
	@Override
	@Transactional
	public List<BitUsuarioRole> findBitUsuarioRoleByCveIdRole(Long cveIdRole){
		List<BitUsuarioRole> bitUsuarioRole=bitUsuarioRoleRepository.findBitUsuarioRoleByCveIdRole(cveIdRole); 
		return bitUsuarioRole;
	}
*/
	/*
	 * Método para guardar BitUsuarioRole
	*/
	@Override
	@Transactional
	public BitUsuarioRole saveBitUsuarioRole(BitUsuarioRole bitUsuarioRole) {
		BitUsuarioRole existingBitUsuarioRole=bitUsuarioRoleRepository.findBitUsuarioRoleByCveIdUsuarioRole(bitUsuarioRole.getCveIdUsuarioRole());


		if (existingBitUsuarioRole != null){ 
			if (existingBitUsuarioRole != bitUsuarioRole){ 
				existingBitUsuarioRole.setCveIdUsuarioRole(bitUsuarioRole.getCveIdUsuarioRole());
			//	existingBitUsuarioRole.setCveIdUsuario(bitUsuarioRole.getCveIdUsuario());
			//	existingBitUsuarioRole.setCveIdRole(bitUsuarioRole.getCveIdRole());
				
			}
			bitUsuarioRole = bitUsuarioRoleRepository.saveAndFlush(bitUsuarioRole);
		} else {
		bitUsuarioRole = bitUsuarioRoleRepository.saveAndFlush(bitUsuarioRole);
		}
	 
	return bitUsuarioRole;
	}

	/*
	 * Método para eliminar BitUsuarioRole existente
	*/
	@Override
	@Transactional
	public void deleteBitUsuarioRole(BitUsuarioRole bitUsuarioRole) {
			bitUsuarioRoleRepository.delete(bitUsuarioRole);
	}

	}
