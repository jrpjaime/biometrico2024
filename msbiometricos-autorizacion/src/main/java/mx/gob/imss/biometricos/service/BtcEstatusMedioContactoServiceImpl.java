package mx.gob.imss.biometricos.service;

import java.util.List;
import java.util.Date;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mx.gob.imss.biometricos.model.BtcEstatusMedioContacto;
import mx.gob.imss.biometricos.repository.BtcEstatusMedioContactoRepository;

@Service("btcEstatusMedioContactoService")
public class  BtcEstatusMedioContactoServiceImpl implements BtcEstatusMedioContactoService  { 

	@Autowired
	private BtcEstatusMedioContactoRepository btcEstatusMedioContactoRepository;

	/*
	 * Método de consulta por cveIdEstatusMedioContacto
	*/
	@Override
	@Transactional
	public BtcEstatusMedioContacto findBtcEstatusMedioContactoByCveIdEstatusMedioContacto(Long cveIdEstatusMedioContacto){
		BtcEstatusMedioContacto btcEstatusMedioContacto=btcEstatusMedioContactoRepository.findBtcEstatusMedioContactoByCveIdEstatusMedioContacto(cveIdEstatusMedioContacto); 
		return btcEstatusMedioContacto;
	}

	/*
	 * Método de consulta findAll
	*/
	@Override
	@Transactional
	public List<BtcEstatusMedioContacto> findAllBtcEstatusMedioContacto(){
		List<BtcEstatusMedioContacto> btcEstatusMedioContacto=btcEstatusMedioContactoRepository.findAll(); 
		return btcEstatusMedioContacto;
	}

	/*
	 * Método de consulta findAll
	*/
	@Override
	@Transactional
	public Page<BtcEstatusMedioContacto> findAllBtcEstatusMedioContacto(Pageable pageable){
		Page<BtcEstatusMedioContacto> btcEstatusMedioContacto=btcEstatusMedioContactoRepository.findAll(pageable); 
		return btcEstatusMedioContacto;
	}

	/*
	 * Método de consulta por desEstatusMedioContacto
	*/
	@Override
	@Transactional
	public List<BtcEstatusMedioContacto> findBtcEstatusMedioContactoByDesEstatusMedioContacto(String desEstatusMedioContacto){
		List<BtcEstatusMedioContacto> btcEstatusMedioContacto=btcEstatusMedioContactoRepository.findBtcEstatusMedioContactoByDesEstatusMedioContacto(desEstatusMedioContacto); 
		return btcEstatusMedioContacto;
	}

	/*
	 * Método para guardar BtcEstatusMedioContacto
	*/
	@Override
	@Transactional
	public BtcEstatusMedioContacto saveBtcEstatusMedioContacto(BtcEstatusMedioContacto btcEstatusMedioContacto) {
		BtcEstatusMedioContacto existingBtcEstatusMedioContacto=btcEstatusMedioContactoRepository.findBtcEstatusMedioContactoByCveIdEstatusMedioContacto(btcEstatusMedioContacto.getCveIdEstatusMedioContacto());


		if (existingBtcEstatusMedioContacto != null){ 
			if (existingBtcEstatusMedioContacto != btcEstatusMedioContacto){ 
				existingBtcEstatusMedioContacto.setCveIdEstatusMedioContacto(btcEstatusMedioContacto.getCveIdEstatusMedioContacto());
				existingBtcEstatusMedioContacto.setDesEstatusMedioContacto(btcEstatusMedioContacto.getDesEstatusMedioContacto());
				
			}
			btcEstatusMedioContacto = btcEstatusMedioContactoRepository.save(btcEstatusMedioContacto);
		} else {
		btcEstatusMedioContacto = btcEstatusMedioContactoRepository.save(btcEstatusMedioContacto);
		}
	return btcEstatusMedioContacto;
	}

	/*
	 * Método para eliminar BtcEstatusMedioContacto existente
	*/
	@Override
	@Transactional
	public void deleteBtcEstatusMedioContacto(BtcEstatusMedioContacto btcEstatusMedioContacto) {
			btcEstatusMedioContactoRepository.delete(btcEstatusMedioContacto);
	}

	}
