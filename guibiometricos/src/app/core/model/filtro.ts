export class  Filtro  {
  cveIdUsuario?: string;
  cveIdTipoUsuario?: number;
  refCurp?: string;
  cveRegpatron?: string;
  numNss?: string;
  fecMovimientoIni?: string;
  fecMovimientoFin?: string;
  fecPresentacionIni?: string;
  fecPresentacionFin?: string;
  cveIdDelegacion?: number;
  cveIdSubdelegacion?: number;
  rfcPatron?: string;
  oDelegacion?: string;
  oSubdelegacion?: string;
  nomequipo?: string;
  macAddress?: string;
  refIp?: string;
  oRolSaiia?: string;
  oNombre?: string;
  oPaterno?: string;
  oMaterno?: string;
  oCveDelegacion?: string;
  oCveSubdelegacion?: string;
  cveIdArgumento?: string;
  ciz?: number;
  numLote?: string;
  nombre?: string;
  primerApellido?: string;
  segundoApellido?: string;
  cveTipoMovimiento?: number;

  numGuiaCve?: string;
	numGuia?: string;
  cveIdUsuarioAutorizador?: string;
  cveIdUsuarioOperador?: string;

  cveIdTipoMovimiento?: string;
  cveIdEstadoMovimiento?: string;
  criterios?: string;
  cveIdTipoError?: string;
  anio?: string;
  mes?: string;

  page: number=0;
  size: number=10;
  order: string='numNss';
  asc: boolean=true;

  constructor(){

  }

}
