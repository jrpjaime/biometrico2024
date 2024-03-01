package mx.gob.imss.biometricos.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.gob.imss.biometricos.model.BtcTipoMedioContacto;

@Repository("btcTipoMedioContactoRepository")
public interface  BtcTipoMedioContactoRepository extends JpaRepository<BtcTipoMedioContacto, Long>  { 

	public BtcTipoMedioContacto findBtcTipoMedioContactoByCveIdTipoMedioContacto(Long cveIdTipoMedioContacto);

	public List<BtcTipoMedioContacto> findBtcTipoMedioContactoByDesTipoMedioContacto(String desTipoMedioContacto);

}
