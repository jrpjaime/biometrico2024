export const EPs = {

  // ********** OAUTH ******************
  // config: "assets/config.json",

  oauth: {
    token: "/v1/token",
    userinfo: "/v1/userinfo",
    login: "/v1/login",
    refresh: "/v1/refresh",
  },


   usuario: {
    seguimiento: {
      listContactoAutorizado: "/v1/listContactoAutorizado",
      listContacto: "/v1/listContacto",
      createContacto:"/v1/createContacto",
      deleteContacto:"/v1/deleteContacto",
      validarContacto:"/v1/validarContacto",
      validarCredencial:"/v1/validarCredencial",
      registrarCredencial:"/v1/registrarCredencial",
      verificaRegistroCredencial:"/v1/verificaRegistroCredencial",


    }

  },



  // ********** AFILIACIÓN /mssaiia-afiliacion**********
  afiliacion: {
    movimientoindividual: {
      list: "/v1/list",
      detail: "/v1/detail",
      detailretroalimentacion: "/v1/detailretroalimentacion",
      delete: "/v1/delete",
      create: "/v1/create",
      update: "/v1/update",
      movimientosIndividualesTempLista: "/v1/movimientosIndividualesTempLista",
      getLoteMovimientoIndividual: "/v1/getLoteMovimientoIndividual",
      validacionNssRp: "/v1/validacionNssRp",
      validacionFecRecepcion: "/v1/validarFechaRecepcion",
      validacionFecFin: "/v1/validarFechaFin",
      validacionFecFiltro: "/v1/validarFechaFiltro",
      listAutorizacion: "/v1/listAutorizacion",
      autorizar: "/v1/autorizar",
      listDetalleAutorizacion: "/v1/listDetalleAutorizacion",
      listBitacora: "/v1/listBitacora",
      listDetalleBitacora: "/v1/listDetalleBitacora",
      listConsultalote: "/v1/listConsultalote",
      listDetalleConsultalote: "/v1/listDetalleConsultalote",
      listReportemovimientos: "/v1/listReportemovimientos",
      listRetroalimentacion: "/v1/listRetroalimentacion",
      listDetalleRetroalimentacion: "/v1/listDetalleRetroalimentacion",
      listAdministraciondiainhabil:"/v1/listAdministraciondiainhabil",
      createDiaInhabil:"/v1/createDiaInhabil",
      actualizarDiaInhabil:"/v1/actualizarDiaInhabil",
      deleteDiaInhabil:"/v1/deleteDiaInhabil",

    }

  },
  // ********** CATALOGOS /mssaiia-catalogos**********
  catalogo: {
    guia: "/v1/guia",
    tipoTrabajador: "/v1/tipoTrabajador",
    tipoSalario: "/v1/tipoSalario",
    jornadaSemana: "/v1/jornadaSemana",
    tipoPago: "/v1/tipoPago",
    argumento: "/v1/argumento",
    argumentoretroalimentacion: "/v1/argumentoretroalimentacion",
    argumentos: "/v1/argumentos",
    causaBaja: "/v1/causaBaja",
    tipoUsuario: "/v1/tipoUsuario",
    delegacion: "/v1/delegacion",
    subdelegacion: "/v1/subdelegacion",
    tipoMovimiento: "/v1/tipoMovimiento",
    estadoMovimiento: "/v1/estadoMovimiento",
    anio: "/v1/anio",
    mes: "/v1/mes",
    createDiaInhabil: "/v1/createDiaInhabil",
    infoNssRp: "/v1/infoNssRp",

  },
  //************* SAU  /mssaiia-sau */
  sau: {
    operador: "/v1/usuario",
    autentica: "/v1/usuario/autentica",

  },
  //************* REPORTES /mssaiia-reportes */
  reportes: {
    acusemovimientos: "/v1/acuseMovimientos",
    acusemovimientoslote: "/v1/acuseMovimientoslote",
    acuselote: "/v1/acuselote",
    constancialote: "/v1/constancialote",
    bitacora: "/v1/bitacora",
    reporteMovimientos: "/v1/reporteMovimientos",
    reporteLotes: "/v1/reporteLotes",
    acusemovimientosretroalimentacion: "/v1/acusemovimientosretroalimentacion",

  },
  //************* MOVIMIENTOS INDIVIDUALES  */
  asegurado: {
    movimiento: "/ObtieneDtsUltimoMovtoAsegxRegPat",

  },
  // ********** ARCHIVO DISPMAG /mssaiia-archivos **********
  carga: {
    dispmag: "/v1/cargadispmag"

  },
  // ********** CLIENT  **********
  client: {
    connection: "/v1/client"

  }


}
