package mx.gob.imss.biometricos.service;

import java.util.List;
import java.util.Date;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mx.gob.imss.biometricos.model.BitUsuario;
import mx.gob.imss.biometricos.model.BitUsuarioRole;

public interface  BitUsuarioRoleService { 

	public BitUsuarioRole findBitUsuarioRoleByCveIdUsuarioRole(Long cveIdUsuarioRole);

	public List<BitUsuarioRole> findAllBitUsuarioRole();

	public Page<BitUsuarioRole> findAllBitUsuarioRole(Pageable pageable);

//	public List<BitUsuarioRole> findBitUsuarioRoleByCveIdUsuario(Long cveIdUsuario);

//	public List<BitUsuarioRole> findBitUsuarioRoleByCveIdRole(Long cveIdRole);

	public BitUsuarioRole saveBitUsuarioRole(BitUsuarioRole bitUsuarioRole);

	public void deleteBitUsuarioRole(BitUsuarioRole bitUsuarioRole);

//	List<BitUsuarioRole> findBitUsuarioRoleByCveIdUsuario(Long cveIdUsuario);

	List<BitUsuarioRole> findBitUsuarioRoleByBitUsuario(BitUsuario bitUsuario);

}
