package mx.gob.imss.biometricos.service;

import java.util.List;
import java.util.Date;
import javax.transaction.Transactional;

import mx.gob.imss.biometricos.model.BtcTipoMedioContacto;
import mx.gob.imss.biometricos.repository.BtcTipoMedioContactoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service("btcTipoMedioContactoService")
public class  BtcTipoMedioContactoServiceImpl implements BtcTipoMedioContactoService  { 

	@Autowired
	private BtcTipoMedioContactoRepository btcTipoMedioContactoRepository;

	/*
	 * Método de consulta por cveIdTipoMedioContacto
	*/
	@Override
	@Transactional
	public BtcTipoMedioContacto findBtcTipoMedioContactoByCveIdTipoMedioContacto(Long cveIdTipoMedioContacto){
		BtcTipoMedioContacto btcTipoMedioContacto=btcTipoMedioContactoRepository.findBtcTipoMedioContactoByCveIdTipoMedioContacto(cveIdTipoMedioContacto); 
		return btcTipoMedioContacto;
	}

	/*
	 * Método de consulta findAll
	*/
	@Override
	@Transactional
	public List<BtcTipoMedioContacto> findAllBtcTipoMedioContacto(){
		List<BtcTipoMedioContacto> btcTipoMedioContacto=btcTipoMedioContactoRepository.findAll(); 
		return btcTipoMedioContacto;
	}

	/*
	 * Método de consulta findAll
	*/
	@Override
	@Transactional
	public Page<BtcTipoMedioContacto> findAllBtcTipoMedioContacto(Pageable pageable){
		Page<BtcTipoMedioContacto> btcTipoMedioContacto=btcTipoMedioContactoRepository.findAll(pageable); 
		return btcTipoMedioContacto;
	}

	/*
	 * Método de consulta por desTipoMedioContacto
	*/
	@Override
	@Transactional
	public List<BtcTipoMedioContacto> findBtcTipoMedioContactoByDesTipoMedioContacto(String desTipoMedioContacto){
		List<BtcTipoMedioContacto> btcTipoMedioContacto=btcTipoMedioContactoRepository.findBtcTipoMedioContactoByDesTipoMedioContacto(desTipoMedioContacto); 
		return btcTipoMedioContacto;
	}

	/*
	 * Método para guardar BtcTipoMedioContacto
	*/
	@Override
	@Transactional
	public BtcTipoMedioContacto saveBtcTipoMedioContacto(BtcTipoMedioContacto btcTipoMedioContacto) {
		BtcTipoMedioContacto existingBtcTipoMedioContacto=btcTipoMedioContactoRepository.findBtcTipoMedioContactoByCveIdTipoMedioContacto(btcTipoMedioContacto.getCveIdTipoMedioContacto());


		if (existingBtcTipoMedioContacto != null){ 
			if (existingBtcTipoMedioContacto != btcTipoMedioContacto){ 
				existingBtcTipoMedioContacto.setCveIdTipoMedioContacto(btcTipoMedioContacto.getCveIdTipoMedioContacto());
				existingBtcTipoMedioContacto.setDesTipoMedioContacto(btcTipoMedioContacto.getDesTipoMedioContacto());
				
			}
			btcTipoMedioContacto = btcTipoMedioContactoRepository.save(btcTipoMedioContacto);
		} else {
		btcTipoMedioContacto = btcTipoMedioContactoRepository.save(btcTipoMedioContacto);
		}
	return btcTipoMedioContacto;
	}

	/*
	 * Método para eliminar BtcTipoMedioContacto existente
	*/
	@Override
	@Transactional
	public void deleteBtcTipoMedioContacto(BtcTipoMedioContacto btcTipoMedioContacto) {
			btcTipoMedioContactoRepository.delete(btcTipoMedioContacto);
	}

	}
