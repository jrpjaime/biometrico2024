package mx.gob.imss.biometricos.util;
/**
*
* @author dev-IMSS
*/
public class Constantes {
	
	
    public static final Long BUTTONS_TO_SHOW = 5L;
    public static final Long INITIAL_PAGE = 0L;
    public static final Long INITIAL_PAGE_SIZE = 5L;
    public static final int[] PAGE_SIZES = {5, 10, 20};
    
    
    public static final int BUTTONS_TO_SHOW_I = 5;
    public static final int INITIAL_PAGE_I = 0;
    public static final int INITIAL_PAGE_SIZE_I = 5;
    public static final int[] PAGE_SIZES_I = {5, 10, 20};
    
    
    public static final int IND_TIPO_SECCION_INDEX = 1;
    public static final int IND_TIPO_SECCION_ANEXO = 2;
    public static final int IND_TIPO_SECCION_REFERENCIA = 3;
    public static final int IND_TIPO_SECCION_IMAGENES = 4;
    
   public static final int INT_NUM_ELEMENTOS_LAYOUT_DOCUMENTOS = 12;
    public static final int INT_NUM_ELEMENTOS_LAYOUT_COMUNICADOS = 2;
    
    public static final String FIELD_FECHA_CARGA="mgdata_fecha_carga";

    public static final String LBL_ERROR="ERROR: ";
    public static final String LBL_INFO="INFO: "; 
    public static final String LBL_SISTEMA="APP: "; 
    
    public static final String ACTIVIDAD_CONSULTAR="Consultar"; 
    public static final String ACTIVIDAD_GUARDAR="Guardar"; 
    public static final String ACTIVIDAD_ELIMINAR="Eliminar"; 
    public static final String ACTIVIDAD_DESCARGAR="Descargar"; 
    public static final String ACTIVIDAD_SMS="Enviar SMS"; 
    public static final String ACTIVIDAD_EMAIL="Enviar Correo Electrónico"; 
    public static final String ACTIVIDAD_LOGIN="Ingresar"; 
    public static final String ACTIVIDAD_PROMOCION_ELECTRONICA="Promoción Electrónica"; 
    
    public static final String TIPO_DOCUMENTO_ACTIVACION="Activación"; // Activación de Buzón IMSS
    public static final String TIPO_DOCUMENTO_AUTORIZACION_TERCERO_AUTORIZADO = "Autorización de Tercero Autorizado";
    public static final String TIPO_DOCUMENTO_BAJA_TERCERO_AUTORIZADO = "Baja de Tercero Autorizado";
    public static final String AUTORIZACION_TERCERO_AUTORIZADO = "Autorización Tercero Autorizado";
    public static final String TIPO_DOCUMENT_TERCERO_AUTORIZADO="Activación Tercero Autorizado";
    public static final String TIPO_DOCUMENTO_DESACTIVACION="Desactivación"; // Desactivación de Buzón IMSS
    public static final String TIPO_DOCUMENTO_PROMOCIONES_ELECTRONICAS="Promociones Electrónicas"; // Activación de Buzón IMSS
    public static final String DES_TEMA_COMUNICADO_CONTRATANTE_AUTORIZADO = "Autorización como Tercero para la consulta de la Opinión del Cumplimiento IMSS";
    public static final String PREFIJO_ELEMENTO_ACLARACION="elementoAdd"; // prefijo de elementos dinamicos de aclaraciones
    public static final String DES_TEMA_COMUNICADO_CONTRATANTE_AUTORIZADO_BAJA = "Baja como Tercero Autorizado para la Consulta de la Opinión del Cumplimiento IMSS";

    public static final String TIPO_ACEPTACION_OP="Autorización de la Opinión Pública";
    public static final String TIPO_CANCELACION_OP="Cancelación de la Opinión Pública";

    public static final String PROMOCION_ELECTRONICA_ROLE_NIVEL_1 = "ind_menu_role_nivel1";
    
    public static final int MEDIOS_CONTACTO_MAIL =5;
    public static final int MEDIOS_CONTACTO_TELEFONO = 1;
    
    public static final String MSG_SIN_REGISTROS_PATRONALES="El Registro Federal de Contribuyentes registrado no tiene vinculados Registros Patronales ante el IMSS o presenta alguna inconsistencia. Por favor capture nuevamente, si persiste la situación, marque al 800 623 23 23, opción 5, luego opción 5 o presente una Aclaración en el apartado Aclaraciones Buzón IMSS.";
    public static final String MSG_SIN_REGISTROS_PATRONALES_CONVENIOS="Estimado usuario. Su RFC no tiene Registros Patronales registrados ante el IMSS. En caso de requerir aclaración, acuda a la Subdelegación que le corresponda.";
    public static final String MSG_SIN_VIGENCIA_STPS="Estimado Patrón. \n  Derivado de que su registro en el Padrón Público de Contratistas de Servicios Especializados u Obras Especializadas de la Secretaría del Trabajo y Previsión Social de la Secretaría del Trabajo y Previsión Social, se encuentra cancelado, la consulta de la opinión de cumplimiento IMSS por parte de sus Contratantes, así como la opción de realizar Autorización de los mismos, ha sido inhabilitada.";
    public static final String MSG_SMS_FROM="BUZON IMSS";
    public static final String MSG_SMS_CODIGO_PAIS="521";
    public static final String MSG_SMS_VERIFICACION="Buzón IMSS. Valida tu celular con el Código {codigo_verificacion}. Tienes máximo 72 horas para utilizarlo.";
    public static final String MSG_SMS_AVISO_TERCERO_AUTORIZADO="Fuiste autorizado para la consulta de Opinión del Cumplimiento de un Particular. Ingresa a www.imss.gob.mx/buzonimss";
    public static final String MSG_SMS_AVISO_TERCERO_BAJA="Tienes un nuevo mensaje en la bandeja de Comunicados de tu Buzón IMSS. Ingresa a www.imss.gob.mx/buzonimss";
    
    public static final String MSG_SMS_CONFIRMACION="Buzón IMSS. La validación de tu celular fue exitosa.";
    public static final String MSG_SMS_SIN_MEDIO_CONTACTO_TERCER_AUTORIZADO="Activa tu Buzón IMSS para que seas autorizado como Tercero y puedas consultar la Opinión de Cumplimiento de {nombreOtorgante}. Ingresa a www.imss.gob.mx/buzonimss";
    public static final String MSG_SMS_SIN_MEDIO_CONTACTO_OTORGANTE="El usuario {nombre} intentó consultar tu opinión de cumplimiento como tercero autorizado. Si deseas autorizarlo ingresa a www.imss.gob.mx/buzonimss";
    
    public static final String MSG_SMS_NOTIFICACION_FIRMADA="Firmo la consulta de su acto administrativo con el Folio de Firma Digital {folioFimaDigital} ";
    public static final String MSG_SMS_NOTIFICACION_AUTOMATICA="Tienes un acto administrativo con el Folio de Firma Digital {folioFimaDigital} para notificación, ingresa a www.imss.gob.mx/buzonimss";
    public static final String MSG_SMS_NOTIFICACION_AUTOMATICA_CONSTANCIA="Usted tiene una notificación realizada por vencimiento, por favor ingrese a su Buzón IMSS";
    
    public static final String MSG_SMS_DESACTIVAR_BUZON="Su Buzón IMSS se ha desactivado";

    public static final String MSG_SMS_COMUNICADO_ALERTA="Tienes un nuevo Comunicado con el asunto {asunto}. Ingresa a www.imss.gob.mx/buzonimss";
    public static final String MSG_SMS_DOCUMENTO_ALERTA="Tienes un nuevo Documento con el asunto {asunto}. Ingresa a www.imss.gob.mx/buzonimss";

    
    public static final String MSG_AUTORIZA_BUZON_MEDIOS_CONTACTO="Para utilizar tu Buzón IMSS primero debes registrar y validar al menos 1 correo electrónico y 1 número telefónico celular para tu RFC.";
    
    public static final String MSG_AUTORIZA_BUZON_ACEPTACION="Para concluir con la habilitación de tu Buzón realiza la solicitud y manifestación de conformidad en la sección Activar Buzón IMSS.<br><a href='/buzonimss/portal/aceptacionBI'><img  src='/buzonimss/images/aceptacionbuzonimssMensaje.png' style='width: 60px;' ></a>";
    
    
    public static final String MSG_TELEFONO_REGISTRADO="Número de celular registrado, recibirás un mensaje de texto vía SMS con un código de verificación para validar el medio de contacto.";
    public static final String MSG_NOTAS_TRANSFERIR_ACLARACION="Para trasferir el caso, debe registrar las notas internas y dar clic en el botón \"Guardar\"";

    public static final String MSG_NOTAS_TRANSFERIR_PRORROGA="Para Activar la Prórroga, es necesario registrar las Notas internas.";

    public static final String MSG_SMS_PRORROGA_ACLARACION="La fecha de respuesta fue prorrogada para su planteamiento con folio ";

    public static final String MSG_SMS_CANALIZACION_ACLARACION="Su planteamiento con folio {folioCanalizacion} fue canalizado al área correspondiente para su atención.";

    public static final String MSG_NOTAS_CANALIZAR_ACLARACION="Para canalizar el caso, debe registrar las notas internas y dar clic en el botón \"Guardar\"";

    public static final String MSG_CANALIZAR_ACLARACION_TRAMITE="Para canalizar el caso, el servicio y el asunto deben ser diferentes al servicio y asunto actual";

    public static final String MSG_VALIDACION_ACLARACION="Para poder continuar, es necesario registrar la Respuesta.";
    
    public static final String MSG_VALIDACION_ANEXO_RESPUESTA="Para poder enviar la respuesta, es necesario registrar el documento anexo.";
    
    

    public static final String MSG_DESCRIPCION_ACLARACION="Para enviar su planteamiento, es necesario que registre el campo Descripción.";
    
    public static final String MSG_FALTA_PERSONAL="<div class='alert alert-danger' role='alert'>Falta asignar personal</div>";
    
    public static final String MSG_PROPORCIONAR_INFORMACION="Debe proporcionar la información solicitada para continuar con su proceso de aclaración antes del día: ";
    public static final String MSG_PROPORCIONAR_INFORMACION_PATRON="El patrón debe proporcionar la información solicitada para continuar con su proceso de aclaración antes del día: ";
    public static final String MSG_FEC_PROPORCIONA_INFO_VENCIDA_PATRON="El patrón no proporcionó la información solicitada antes de la fecha máxima: ";
    public static final String MSG_SOLICITAR_INFORMACION_PATRON="Si requiere que el patrón proporcione información, deberá solicitarla antes del día: ";
    public static final String MSG_SOLICITAR_DILIGENCIA_PATRON="Si requiere realizar una diligencia al patrón, deberá realizarla antes del día: ";
    public static final String MSG_DESAHOGO_DILIGENCIA_PATRON="Debe realizar el desahogo de la diligencia antes del día: ";

    
    public static final int TIPO_DOCUMENTO_INFO_ADICIONAL = 1;
    public static final int TIPO_DOCUMENTO_ACUSE_RECEPCION_INFO_ADICIONAL = 2;
    public static final int TIPO_DOCUMENTO_ACUSE_RECEPCION_PRORROGA_INFO_ADICIONAL = 3;
    
    public static final int BUFFER_SIZE = 4096;
     
    
//    public static final String URL_FIRMA_DIGITAL="http://firmadigitalqa.imss.gob.mx"; ////QA UNICO no lo utilizo
    public static final String URL_FIRMA_DIGITAL="http://172.16.23.224"; //DESARROLLO UNICO 
    public static final String URL_GESTION_PATRONAL="http://172.16.5.180:8001"; //QA UNICO    //SendEmailServiceProxy
    
//    public static final String URL_FIRMA_DIGITAL="https://firmadigitalssl.imss.gob.mx"; //PRODUCCION UNICO 
//    public static final String URL_GESTION_PATRONAL="http://172.16.23.201"; //PRODUCCION UNICO nota no lleva puerto
    
    
    public static final String MSG_TERCERO_AUTORIZADO_ALTA = "Autorización Tercero Autorizado";
    public static final String MSG_TERCERO_AUTORIZADO_BAJA = "Baja Tercero Autorizado";
//	public static final String URL_CONSULTA_CARTA_OPINION_PERSONA_FISICA = "/1/{rfc}/XEXX010101HNEXXXA4";
//	public static final String URL_CONSULTA_CARTA_OPINION_PERSONA_MORAL = "/2/{rfc}/XEXX010101HNEXXXA4";

    
//	public static final String URL_CONSULTA_CARTA_OPINION = "https://serviciosdigitales.imss.gob.mx/gestionCobranza-web/wizard/cartaNoAdeudo/";
//    public static final String CODIGO_CARTA_OPINION = "XEXX010101HNEXXXA4";

//    public static final String URL_DESCARGA_CARTA_OPINION = "https://serviciosdigitales.imss.gob.mx/gestionCobranza-web/wizard/cartaNoAdeudo/generar";

    public static final String AUTORIDAD_EMISORA="Buzón IMSS";
    public static final String AUTORIDAD_EMISORA_TEMA="Aviso Buzón IMSS";


    public static final String MSG_SIN_REGISTRO_BDTU_PERSONA_MORAL_FISICA=
    		"<p>No existe información para generar su opinión de cumplimiento, por lo que sus Terceros<br />Autorizados no podrán consultar su información.</p>\r\n" + 
    		"<p>Es importante señalar, que las opiniones de cumplimiento son en los siguientes sentidos:</p>\r\n" + 
    		"<ul>\r\n" + 
    		"<li>Positiva: Se encuentra al corriente en sus obligaciones fiscales en materia de Seguridad<br />Social a la fecha de la consulta.</li>\r\n" + 
    		"<li>Negativa: Tengan a su cargo créditos fiscales determinados, firmes o no, que no se encuentren pagados o garantizados en alguna de las formas permitidas por Código Fiscal de la Federación.</li>\r\n" + 
    		"<li>Sin Opinión:\r\n" + 
    		"<ul>\r\n" + 
    		"<li>No se encuentra registrado como patrón.</li>\r\n" + 
    		"<li>Sus registros patronales se encuentran dados de baja.</li>\r\n" + 
    		"<li>No cuenta con trabajadores vigentes.</li>\r\n" + 
    		"</ul>\r\n" + 
    		"</li>\r\n" + 
    		"</ul>\r\n" + 
    		"<p>Para mayor información, puedes acudir a la Subdelegación que le corresponda, o bien, remitir tu planteamiento a través del correo <a href=\"mailto:constancia32d.aclara@imss.gob.mx\">constancia32d.aclara@imss.gob.mx</a></p>\r\n" + 
    		"<p>¡Buzón IMSS… más fácil, más rápido!</p>";
    
    public static final String NOTIFICACION_CLEM_27="CLEM 27";
    public static final String NOTIFICACION_CLEM_08="CLEM 08";// requerimiento de notificacion marzo 2022
    public static final String NOTIFICACION_CLEM_23="CLEM 23";// requerimiento de notificacion marzo 2022
    public static final String NOTIFICACION_CLEM_26="CLEM 26";// requerimiento de notificacion marzo 2022
    public static final String NOTIFICACION_OFICIO_15A="Of_ICSOE";
    public static final String NOTIFICACION_INFORMATIVA_15A="Req_15A";
    
    public static final String CONTEXTO_APP="http://localhost:4200";
}
