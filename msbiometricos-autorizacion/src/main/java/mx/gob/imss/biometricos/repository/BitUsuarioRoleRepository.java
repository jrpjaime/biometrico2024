package mx.gob.imss.biometricos.repository;

import java.util.List; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.gob.imss.biometricos.model.BitUsuario;
import mx.gob.imss.biometricos.model.BitUsuarioRole;

@Repository("bitUsuarioRoleRepository")
public interface  BitUsuarioRoleRepository extends JpaRepository<BitUsuarioRole, Long>  { 

	public BitUsuarioRole findBitUsuarioRoleByCveIdUsuarioRole(Long cveIdUsuarioRole);

 	public List<BitUsuarioRole> findBitUsuarioRoleByBitUsuario(BitUsuario bitUsuario);

//	public List<BitUsuarioRole> findBitUsuarioRoleByCveIdRole(Long cveIdRole);

}
