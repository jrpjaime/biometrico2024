package mx.gob.imss.biometricos.service;

import java.util.List;
import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mx.gob.imss.biometricos.model.BtcTipoMedioContacto;

public interface  BtcTipoMedioContactoService { 

	public BtcTipoMedioContacto findBtcTipoMedioContactoByCveIdTipoMedioContacto(Long cveIdTipoMedioContacto);

	public List<BtcTipoMedioContacto> findAllBtcTipoMedioContacto();

	public Page<BtcTipoMedioContacto> findAllBtcTipoMedioContacto(Pageable pageable);

	public List<BtcTipoMedioContacto> findBtcTipoMedioContactoByDesTipoMedioContacto(String desTipoMedioContacto);

	public BtcTipoMedioContacto saveBtcTipoMedioContacto(BtcTipoMedioContacto btcTipoMedioContacto);

	public void deleteBtcTipoMedioContacto(BtcTipoMedioContacto btcTipoMedioContacto);

}
