//import { Rol } from './rol';

export interface UserSession {

    curp : string;
    username ?: string;
    nombreUsuario?: string;
    rfc ?: string;
    cveIdUsuario?: string;
    //token? : string;
    //refreshToken? : string;
    cveDelegacion ? : number;
    descDelegacion? : string;
    cveSubDelegacion ?: number;
    descSubdelegacion? : string;
    oRolSaiia? : string;
    //rol? : Rol;


    oRolAdministrador? : string;
    oNombre? : string;
	oPaterno? : string;
	oMaterno? : string;
	oCveDelegacion ? : string;
	oCveSubdelegacion ? : string;
	oDelegacion? : string;
	oSubdelegacion? : string;
	oCiz ? : number;
	oIdDelegacion ? : number;
	oIdSubdelegacion ? : number;


    movimientoIndividual: boolean;
	movimientoLote: boolean;
	movimientoRetroalimentacion: boolean;
	autorizacion: boolean;
	consultaLote: boolean;
	consultaDiasInhabiles: boolean;
	consultaProcesados: boolean;
	consultaAdministracionInhabiles: boolean;
	consultaBitacoraPersonal: boolean;


}
