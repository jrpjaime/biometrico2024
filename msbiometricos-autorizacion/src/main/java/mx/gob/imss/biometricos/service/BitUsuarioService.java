package mx.gob.imss.biometricos.service;

import java.util.List;
import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mx.gob.imss.biometricos.model.BitUsuario; 

public interface  BitUsuarioService { 

	public BitUsuario findBitUsuarioByCveIdUsuario(Long cveIdUsuario);

	public List<BitUsuario> findAllBitUsuario();

	public List<BitUsuario> findallBitUsuarioByCveEntFedIsNull();

	public Page<BitUsuario> findAllBitUsuario(Pageable pageable);

	public List<BitUsuario> findBitUsuarioByDesPassword(String desPassword);

	public List<BitUsuario> findBitUsuarioByDesNombre(String desNombre);

	public List<BitUsuario> findBitUsuarioByDesRfc(String desRfc);

	public List<BitUsuario> findBitUsuarioByDesPrimerApellido(String desPrimerApellido);

	public List<BitUsuario> findBitUsuarioByDesSegundoApellido(String desSegundoApellido);

	public List<BitUsuario> findBitUsuarioByIndActivo(Integer indActivo);

	public List<BitUsuario> findBitUsuarioByDesUsuario(String desUsuario);

	public List<BitUsuario> findBitUsuarioByDesEmail(String desEmail);

	public BitUsuario saveBitUsuario(BitUsuario bitUsuario);

	public void deleteBitUsuario(BitUsuario bitUsuario);

	BitUsuario findBitUsuarioByDesUsuarioUnico(String desUsuario);

	BitUsuario updateBitUsuario(BitUsuario bitUsuario);
  

	List<BitUsuario> findBitUsuarioByfecAceptacionNotNull();

	BitUsuario guardarBitUsuario(BitUsuario bitUsuario);

	List<BitUsuario> findAllBitUsuarioOrderByDesNombre();
 

	List<BitUsuario> findallBitUsuarioByClaveMunicipioIsNull();
 

	List<BitUsuario> findAllBitUsuarioOrderByFecActualizacion();
 

}
