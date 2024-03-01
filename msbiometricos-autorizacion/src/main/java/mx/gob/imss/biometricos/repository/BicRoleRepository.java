package mx.gob.imss.biometricos.repository;

import java.util.List; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mx.gob.imss.biometricos.model.BicRole;

@Repository("bicRoleRepository")
public interface  BicRoleRepository extends JpaRepository<BicRole, Long>  { 

	public BicRole findBicRoleByCveIdRole(Long cveIdRole);

	public List<BicRole> findBicRoleByDesRole(String desRole);


    @Query("select myBicRole from BicRole myBicRole JOIN BitUsuarioRole myBitUsuarioRole ON myBitUsuarioRole.bicRole=myBicRole " +
            "JOIN BitUsuario myBitUsuario ON myBitUsuarioRole.bitUsuario=myBitUsuario " +
            "WHERE  myBitUsuario.cveIdUsuario = :cveIdUsuario order by myBicRole.cveIdRole")
    public List<BicRole> findBicRoleByCveIdUsuario(@Param("cveIdUsuario")  Long cveIdUsuario);

	
	@Query("select myBicRole from BicRole myBicRole  order by myBicRole.desRole")
	public List<BicRole> findAllBicRoleOrderByDesRole();
	

}
