package mx.gob.imss.biometricos.service;

import java.util.List;
import java.util.Date;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mx.gob.imss.biometricos.model.BicRole;
import mx.gob.imss.biometricos.repository.BicRoleRepository;

@Service("bicRoleService")
public class  BicRoleServiceImpl implements BicRoleService  { 

	@Autowired
	private BicRoleRepository bicRoleRepository;

	/*
	 * Método de consulta por cveIdRole
	*/
	@Override
	@Transactional
	public BicRole findBicRoleByCveIdRole(Long cveIdRole){
		BicRole bicRole=bicRoleRepository.findBicRoleByCveIdRole(cveIdRole); 
		return bicRole;
	}

	@Override
	@Transactional
	public List findBicRoleByCveIdUsuario(Long cveIdUsuario){
		List<BicRole> bicRoles=bicRoleRepository.findBicRoleByCveIdUsuario(cveIdUsuario);
		return bicRoles;
	}

	/*
	 * Método de consulta findAll
	*/
	@Override
	@Transactional
	public List<BicRole> findAllBicRole(){
		List<BicRole> bicRole=bicRoleRepository.findAll(); 
		return bicRole;
	}
	
	
	@Override
	@Transactional
	public List<BicRole> findAllBicRoleOrderByDesRole(){
		List<BicRole> bicRole=bicRoleRepository.findAllBicRoleOrderByDesRole(); 
		return bicRole;
	}

	/*
	 * Método de consulta findAll
	*/
	@Override
	@Transactional
	public Page<BicRole> findAllBicRole(Pageable pageable){
		Page<BicRole> bicRole=bicRoleRepository.findAll(pageable); 
		return bicRole;
	}

	/*
	 * Método de consulta por desRole
	*/
	@Override
	@Transactional
	public List<BicRole> findBicRoleByDesRole(String desRole){
		List<BicRole> bicRole=bicRoleRepository.findBicRoleByDesRole(desRole); 
		return bicRole;
	}

	/*
	 * Método para guardar BicRole
	*/
	@Override
	@Transactional
	public BicRole saveBicRole(BicRole bicRole) {
		BicRole existingBicRole=bicRoleRepository.findBicRoleByCveIdRole(bicRole.getCveIdRole());


		if (existingBicRole != null){ 
			if (existingBicRole != bicRole){ 
				existingBicRole.setDesRole(bicRole.getDesRole());
				existingBicRole.setCveIdRole(bicRole.getCveIdRole());
				
			}
			bicRole = bicRoleRepository.save(bicRole);
		} else {
		bicRole = bicRoleRepository.save(bicRole);
		}
	return bicRole;
	}

	/*
	 * Método para eliminar BicRole existente
	*/
	@Override
	@Transactional
	public void deleteBicRole(BicRole bicRole) {
			bicRoleRepository.delete(bicRole);
	}

	}
