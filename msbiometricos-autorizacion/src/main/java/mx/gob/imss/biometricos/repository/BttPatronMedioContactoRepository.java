package mx.gob.imss.biometricos.repository;

import java.util.List;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.gob.imss.biometricos.model.BttMedioContacto;
import mx.gob.imss.biometricos.model.BttPatron;
import mx.gob.imss.biometricos.model.BttPatronMedioContacto;

@Repository("bttPatronMedioContactoRepository")
public interface  BttPatronMedioContactoRepository extends JpaRepository<BttPatronMedioContacto, Long>  { 

	public BttPatronMedioContacto findBttPatronMedioContactoByCveIdPatronMedioContacto(Long cveIdPatronMedioContacto);

	public List<BttPatronMedioContacto> findBttPatronMedioContactoByBttMedioContacto(BttMedioContacto bttMedioContacto);

	public List<BttPatronMedioContacto> findBttPatronMedioContactoByBttPatron(BttPatron bttPatron);
	
	public List<BttPatronMedioContacto> findBttPatronMedioContactoByBttPatronAndBttMedioContacto(BttPatron bttPatron, BttMedioContacto bttMedioContacto);

	public List<BttPatronMedioContacto> findBttPatronMedioContactoByFecRegistro(Date fecRegistro);

	public List<BttPatronMedioContacto> findBttPatronMedioContactoByFecBaja(Date fecBaja);

}
