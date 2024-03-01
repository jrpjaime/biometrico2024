package mx.gob.imss.biometricos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.gob.imss.biometricos.model.BtcEstatusMedioContacto;

@Repository("btcEstatusMedioContactoRepository")
public interface  BtcEstatusMedioContactoRepository extends JpaRepository<BtcEstatusMedioContacto, Long>  {

	public BtcEstatusMedioContacto findBtcEstatusMedioContactoByCveIdEstatusMedioContacto(Long cveIdEstatusMedioContacto);

	public List<BtcEstatusMedioContacto> findBtcEstatusMedioContactoByDesEstatusMedioContacto(String desEstatusMedioContacto);

}
