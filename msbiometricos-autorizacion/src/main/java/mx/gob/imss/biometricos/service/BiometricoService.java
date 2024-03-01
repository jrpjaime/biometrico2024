package mx.gob.imss.biometricos.service;

import com.nimbusds.jose.shaded.json.parser.ParseException;

import mx.gob.imss.biometricos.model.BitUsuario;
import mx.gob.imss.biometricos.security.dto.LoginUsuarioDto;
import mx.gob.imss.biometricos.vo.Testlifecredencial;

public interface BiometricoService { 

	BitUsuario registraUsuario(String rfc, String curp);

	BitUsuario registraUsuarioCurp(String curp);

	Testlifecredencial registraCredencial(LoginUsuarioDto loginUsuario) throws ParseException, NullPointerException;
}
