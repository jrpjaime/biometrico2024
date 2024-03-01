package mx.gob.imss.biometricos.repository;

import java.util.List;
import java.util.Date;
 
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mx.gob.imss.biometricos.model.BtcEstatusMedioContacto;
import mx.gob.imss.biometricos.model.BttMedioContacto;

import org.springframework.data.domain.Page;

@Repository("bttMedioContactoRepository")
public interface  BttMedioContactoRepository extends JpaRepository<BttMedioContacto, Long>  { 

	public BttMedioContacto findBttMedioContactoByCveIdMedioContacto(Long cveIdMedioContacto);

	public List<BttMedioContacto> findBttMedioContactoByDesFolio(String desFolio);

	public List<BttMedioContacto> findBttMedioContactoByFecRegistro(Date fecRegistro);

	public List<BttMedioContacto> findBttMedioContactoByDesCorreoElectronico(String desCorreoElectronico);
	
	public List<BttMedioContacto> findBttMedioContactoByDesCorreoElectronicoAndCveIdUsuario(String desCorreoElectronico, Long cveIdUsuario);

	public List<BttMedioContacto> findBttMedioContactoByDesTelefono(String desTelefono);

	public List<BttMedioContacto> findBttMedioContactoByBtcEstatusMedioContacto(BtcEstatusMedioContacto btcEstatusMedioContacto);

	public List<BttMedioContacto> findBttMedioContactoByFecConfirmacion(Date fecConfirmacion);

	public List<BttMedioContacto> findBttMedioContactoByFecBaja(Date fecBaja);

	public List<BttMedioContacto> findBttMedioContactoByDesAclaracion(String desAclaracion);

	public List<BttMedioContacto> findBttMedioContactoByFecSolicitudAclaracion(Date fecSolicitudAclaracion);

	public List<BttMedioContacto> findBttMedioContactoByCveIdUsuario(Long cveIdUsuario);
	
	@Query("select myBttMedioContacto from BttMedioContacto myBttMedioContacto where myBttMedioContacto.cveIdUsuario = :cveIdUsuario and myBttMedioContacto.fecBaja is null order by myBttMedioContacto.fecRegistro desc")
	public Page<BttMedioContacto> findBttMedioContactoByCveIdUsuario(@Param("cveIdUsuario")Long cveIdUsuario, Pageable pageable);
	
	@Query("select myBttMedioContacto from BttMedioContacto myBttMedioContacto where myBttMedioContacto.cveIdUsuario = :cveIdUsuario  order by myBttMedioContacto.fecBaja desc,  myBttMedioContacto.fecRegistro desc ")
	public Page<BttMedioContacto> findBttMedioContactoByCveIdUsuarioAll(@Param("cveIdUsuario")Long cveIdUsuario, Pageable pageable);
	
	
	@Query("select myBttMedioContacto from BttMedioContacto myBttMedioContacto where myBttMedioContacto.desCorreoElectronico = :desCorreoElectronico and myBttMedioContacto.cveIdUsuario = :cveIdUsuario and myBttMedioContacto.fecBaja is null order by myBttMedioContacto.fecRegistro")
	public List<BttMedioContacto> findBttMedioContactoByDesCorreoElectronicoAndCveIdUsuarioAndFecBajaNull(@Param("desCorreoElectronico") String  desCorreoElectronico, @Param("cveIdUsuario")Long cveIdUsuario );
	
	@Query("select myBttMedioContacto from BttMedioContacto myBttMedioContacto where myBttMedioContacto.desCorreoElectronico = :desCorreoElectronico and myBttMedioContacto.cveIdUsuario = :cveIdUsuario and myBttMedioContacto.fecBaja is null  order by myBttMedioContacto.fecRegistro")
	public List<BttMedioContacto> findBttMedioContactoByDesCorreoElectronicoAndCveIdUsuarioAndFecBajaNullRFC(@Param("desCorreoElectronico") String  desCorreoElectronico, @Param("cveIdUsuario")Long cveIdUsuario );
	
	
	
	@Query("select myBttMedioContacto from BttMedioContacto myBttMedioContacto where myBttMedioContacto.cveIdUsuario = :cveIdUsuario and myBttMedioContacto.fecBaja is null order by myBttMedioContacto.fecRegistro")
	public List<BttMedioContacto> findBttMedioContactoByCveIdUsuarioAndFecBajaNull(@Param("cveIdUsuario")Long cveIdUsuario );


	@Query("select myBttMedioContacto from BttMedioContacto myBttMedioContacto where myBttMedioContacto.cveIdUsuario = :cveIdUsuario " +
            "and myBttMedioContacto.btcTipoMedioContacto.cveIdTipoMedioContacto = 1 and myBttMedioContacto.fecBaja is null order by myBttMedioContacto.fecRegistro")
	public List<BttMedioContacto> findBttMedioContactoCorreoByCveIdUsuarioAndFecBajaNull(@Param("cveIdUsuario")Long cveIdUsuario );
	
	@Query("select myBttMedioContacto from BttMedioContacto myBttMedioContacto where myBttMedioContacto.desCorreoElectronico = :desCorreoElectronico and myBttMedioContacto.cveIdUsuario = :cveIdUsuario   order by myBttMedioContacto.fecRegistro desc")
	public List<BttMedioContacto> findBttMedioContactoByDesCorreoElectronicoAndCveIdUsuarioOrderByFecRegistro(@Param("desCorreoElectronico") String  desCorreoElectronico, @Param("cveIdUsuario")Long cveIdUsuario );
	
	@Query("select myBttMedioContacto from BttMedioContacto myBttMedioContacto where myBttMedioContacto.cveIdUsuario = :cveIdUsuario and myBttMedioContacto.fecConfirmacion is not null  order by myBttMedioContacto.fecBaja desc,  myBttMedioContacto.fecRegistro desc ")
	public Page<BttMedioContacto> findBttMedioContactoByCveIdUsuarioAllAutorizado(@Param("cveIdUsuario")Long cveIdUsuario, Pageable pageable);
	

}
