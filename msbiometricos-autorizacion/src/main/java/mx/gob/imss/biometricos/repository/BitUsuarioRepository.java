package mx.gob.imss.biometricos.repository;

import java.util.List; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mx.gob.imss.biometricos.model.BitUsuario;

@Repository("bitUsuarioRepository")
public interface  BitUsuarioRepository extends JpaRepository<BitUsuario, Long>  { 

	public BitUsuario findBitUsuarioByCveIdUsuario(Long cveIdUsuario);

	public List<BitUsuario> findBitUsuarioByDesPassword(String desPassword);

	public List<BitUsuario> findBitUsuarioByDesNombre(String desNombre);

	public List<BitUsuario> findBitUsuarioByDesRfc(String desRfc);

	public List<BitUsuario> findBitUsuarioByDesPrimerApellido(String desPrimerApellido);

	public List<BitUsuario> findBitUsuarioByDesSegundoApellido(String desSegundoApellido);

	public List<BitUsuario> findBitUsuarioByIndActivo(Integer indActivo);

	public List<BitUsuario> findBitUsuarioByDesUsuario(String desUsuario);

	public List<BitUsuario> findBitUsuarioByDesEmail(String desEmail);
	
	@Query("select myBitUsuario from BitUsuario myBitUsuario where myBitUsuario.desUsuario = :desUsuario ")
	public BitUsuario findBitUsuarioByDesUsuarioUnico(@Param("desUsuario") String desUsuario);
	
	
	
	@Query("select myBitUsuario from BitUsuario myBitUsuario where myBitUsuario.fecAceptacion is not null ")
	public List<BitUsuario> findBitUsuarioByfecAceptacionNotNull();
	
	
	
	@Query("select myBitUsuario from BitUsuario myBitUsuario order by desNombre  ")
	public List<BitUsuario> findAllBitUsuarioOrderByDesNombre();


	@Query("SELECT myBitUsuario FROM BitUsuario myBitUsuario WHERE myBitUsuario.claveEntFed IS NULL AND myBitUsuario.desEntFed IS NULL")
	public List<BitUsuario> findBitUsuarioByCveEntFedIsNull();
	
	
	@Query("SELECT myBitUsuario FROM BitUsuario myBitUsuario WHERE myBitUsuario.claveMunicipio IS NULL ")
	public List<BitUsuario> findallBitUsuarioByClaveMunicipioIsNull();
	
	@Query("SELECT myBitUsuario FROM BitUsuario myBitUsuario order by myBitUsuario.fecActualizacion ")
	public List<BitUsuario> findAllBitUsuarioOrderByFecActualizacion();
	
	
	
	
	
}
