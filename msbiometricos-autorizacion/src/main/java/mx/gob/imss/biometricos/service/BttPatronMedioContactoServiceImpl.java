package mx.gob.imss.biometricos.service;

import java.util.List;
import java.util.Date;
import javax.transaction.Transactional;

import mx.gob.imss.biometricos.model.BttMedioContacto;
import mx.gob.imss.biometricos.model.BttPatron;
import mx.gob.imss.biometricos.model.BttPatronMedioContacto;
import mx.gob.imss.biometricos.repository.BttPatronMedioContactoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service("bttPatronMedioContactoService")
public class  BttPatronMedioContactoServiceImpl implements BttPatronMedioContactoService  { 

	@Autowired
	private BttPatronMedioContactoRepository bttPatronMedioContactoRepository;

	/*
	 * Método de consulta por cveIdPatronMedioContacto
	*/
	@Override
	@Transactional
	public BttPatronMedioContacto findBttPatronMedioContactoByCveIdPatronMedioContacto(Long cveIdPatronMedioContacto){
		BttPatronMedioContacto bttPatronMedioContacto=bttPatronMedioContactoRepository.findBttPatronMedioContactoByCveIdPatronMedioContacto(cveIdPatronMedioContacto); 
		return bttPatronMedioContacto;
	}

	/*
	 * Método de consulta findAll
	*/
	@Override
	@Transactional
	public List<BttPatronMedioContacto> findAllBttPatronMedioContacto(){
		List<BttPatronMedioContacto> bttPatronMedioContacto=bttPatronMedioContactoRepository.findAll(); 
		return bttPatronMedioContacto;
	}

	/*
	 * Método de consulta findAll
	*/
	@Override
	@Transactional
	public Page<BttPatronMedioContacto> findAllBttPatronMedioContacto(Pageable pageable){
		Page<BttPatronMedioContacto> bttPatronMedioContacto=bttPatronMedioContactoRepository.findAll(pageable); 
		return bttPatronMedioContacto;
	}

	/*
	 * Método de consulta por bttMedioContacto
	*/
	@Override
	@Transactional
	public List<BttPatronMedioContacto> findBttPatronMedioContactoByBttMedioContacto(BttMedioContacto bttMedioContacto){
		List<BttPatronMedioContacto> bttPatronMedioContacto=bttPatronMedioContactoRepository.findBttPatronMedioContactoByBttMedioContacto(bttMedioContacto); 
		return bttPatronMedioContacto;
	}

	/*
	 * Método de consulta por bttPatron
	*/
	@Override
	@Transactional
	public List<BttPatronMedioContacto> findBttPatronMedioContactoByBttPatron(BttPatron bttPatron){
		List<BttPatronMedioContacto> bttPatronMedioContacto=bttPatronMedioContactoRepository.findBttPatronMedioContactoByBttPatron(bttPatron); 
		return bttPatronMedioContacto;
	}
	
	
	/*
	 * Método de consulta por bttPatron
	*/
	@Override
	@Transactional
	public List<BttPatronMedioContacto> findBttPatronMedioContactoByBttPatronAndBttMedioContacto(BttPatron bttPatron, BttMedioContacto bttMedioContacto){
		List<BttPatronMedioContacto> bttPatronMedioContacto=bttPatronMedioContactoRepository.findBttPatronMedioContactoByBttPatronAndBttMedioContacto(bttPatron, bttMedioContacto); 
		return bttPatronMedioContacto;
	}

	/*
	 * Método de consulta por fecRegistro
	*/
	@Override
	@Transactional
	public List<BttPatronMedioContacto> findBttPatronMedioContactoByFecRegistro(Date fecRegistro){
		List<BttPatronMedioContacto> bttPatronMedioContacto=bttPatronMedioContactoRepository.findBttPatronMedioContactoByFecRegistro(fecRegistro); 
		return bttPatronMedioContacto;
	}

	/*
	 * Método de consulta por fecBaja
	*/
	@Override
	@Transactional
	public List<BttPatronMedioContacto> findBttPatronMedioContactoByFecBaja(Date fecBaja){
		List<BttPatronMedioContacto> bttPatronMedioContacto=bttPatronMedioContactoRepository.findBttPatronMedioContactoByFecBaja(fecBaja); 
		return bttPatronMedioContacto;
	}

	/*
	 * Método para guardar BttPatronMedioContacto
	*/
	@Override
	@Transactional
	public BttPatronMedioContacto saveBttPatronMedioContacto(BttPatronMedioContacto bttPatronMedioContacto) {
		BttPatronMedioContacto existingBttPatronMedioContacto=bttPatronMedioContactoRepository.findBttPatronMedioContactoByCveIdPatronMedioContacto(bttPatronMedioContacto.getCveIdPatronMedioContacto());


		if (existingBttPatronMedioContacto != null){ 
			if (existingBttPatronMedioContacto != bttPatronMedioContacto){ 
				existingBttPatronMedioContacto.setCveIdPatronMedioContacto(bttPatronMedioContacto.getCveIdPatronMedioContacto());
				existingBttPatronMedioContacto.setBttMedioContacto(bttPatronMedioContacto.getBttMedioContacto());
				existingBttPatronMedioContacto.setBttPatron(bttPatronMedioContacto.getBttPatron());
				existingBttPatronMedioContacto.setFecRegistro(bttPatronMedioContacto.getFecRegistro());
				existingBttPatronMedioContacto.setFecBaja(bttPatronMedioContacto.getFecBaja());
				bttPatronMedioContacto = bttPatronMedioContactoRepository.save(bttPatronMedioContacto);
			}
			
		} else {
		bttPatronMedioContacto = bttPatronMedioContactoRepository.save(bttPatronMedioContacto);
		}
	return bttPatronMedioContacto;
	}

	/*
	 * Método para eliminar BttPatronMedioContacto existente
	*/
	@Override
	@Transactional
	public void deleteBttPatronMedioContacto(BttPatronMedioContacto bttPatronMedioContacto) {
			bttPatronMedioContactoRepository.delete(bttPatronMedioContacto);
	}
	
	
	
	
	@Override
	@Transactional
	public boolean isMedioContactoRfc(BttMedioContacto bttMedioContacto) {
		List<BttPatronMedioContacto> bttPatronMedioContactos= bttPatronMedioContactoRepository.findBttPatronMedioContactoByBttMedioContacto(bttMedioContacto);
		//verifica si no tiene relacionados patrones es un medio de contacto del RFC
		boolean mediosContactoRFC=false;
		if(bttPatronMedioContactos==null) {
			mediosContactoRFC=true;
		}else if(bttPatronMedioContactos.isEmpty()) {
				mediosContactoRFC=true;
				}else if(bttPatronMedioContactos.size()==0) {
							mediosContactoRFC=true;
						}
		return mediosContactoRFC;
	}
	

}
