package mx.gob.imss.biometricos.service;

import java.util.List;
import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mx.gob.imss.biometricos.model.BtcEstatusMedioContacto;

public interface  BtcEstatusMedioContactoService { 

	public BtcEstatusMedioContacto findBtcEstatusMedioContactoByCveIdEstatusMedioContacto(Long cveIdEstatusMedioContacto);

	public List<BtcEstatusMedioContacto> findAllBtcEstatusMedioContacto();

	public Page<BtcEstatusMedioContacto> findAllBtcEstatusMedioContacto(Pageable pageable);

	public List<BtcEstatusMedioContacto> findBtcEstatusMedioContactoByDesEstatusMedioContacto(String desEstatusMedioContacto);

	public BtcEstatusMedioContacto saveBtcEstatusMedioContacto(BtcEstatusMedioContacto btcEstatusMedioContacto);

	public void deleteBtcEstatusMedioContacto(BtcEstatusMedioContacto btcEstatusMedioContacto);

}
