package mx.gob.imss.biometricos.service;

import java.util.List;
import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mx.gob.imss.biometricos.model.BttMedioContacto;
import mx.gob.imss.biometricos.model.BttPatron;
import mx.gob.imss.biometricos.model.BttPatronMedioContacto;

public interface  BttPatronMedioContactoService { 

	public BttPatronMedioContacto findBttPatronMedioContactoByCveIdPatronMedioContacto(Long cveIdPatronMedioContacto);

	public List<BttPatronMedioContacto> findAllBttPatronMedioContacto();

	public Page<BttPatronMedioContacto> findAllBttPatronMedioContacto(Pageable pageable);

	public List<BttPatronMedioContacto> findBttPatronMedioContactoByBttMedioContacto(BttMedioContacto bttMedioContacto);

	public List<BttPatronMedioContacto> findBttPatronMedioContactoByBttPatron(BttPatron bttPatron);

	public List<BttPatronMedioContacto> findBttPatronMedioContactoByFecRegistro(Date fecRegistro);

	public List<BttPatronMedioContacto> findBttPatronMedioContactoByFecBaja(Date fecBaja);

	public BttPatronMedioContacto saveBttPatronMedioContacto(BttPatronMedioContacto bttPatronMedioContacto);

	public void deleteBttPatronMedioContacto(BttPatronMedioContacto bttPatronMedioContacto);


	List<BttPatronMedioContacto> findBttPatronMedioContactoByBttPatronAndBttMedioContacto(BttPatron bttPatron,	BttMedioContacto bttMedioContacto);

	boolean isMedioContactoRfc(BttMedioContacto bttMedioContacto);

}
