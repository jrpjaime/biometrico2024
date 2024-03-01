


function respuestaCHFECyN(respuestaEvento) {

  console.log(":::: respuestaCHFECyN");
    var data = respuestaEvento.data;
    var resultadoJSON = $.parseJSON(data);
    if(resultadoJSON.resultado == 0){


        var nombreRazonSocial = resultadoJSON.nombreRazonSocial;
        var rfcRazonSocial;
        if(nombreRazonSocial){
            rfcRazonSocial = resultadoJSON.rfc+";"+resultadoJSON.rfc+";"+resultadoJSON.curp;
        }else{
             rfcRazonSocial =  resultadoJSON.rfc+"; ";
        }
        var curp = resultadoJSON.curp;
        if(curp){
            rfcRazonSocial = rfcRazonSocial +";"+resultadoJSON.curp;
        }
var cadena =  b64EncodeUnicode(rfcRazonSocial);
        $("#desUsuario").val(cadena);
        $("#desPassword").val(rfcRazonSocial);
        document.getElementById("loginForm").submit();
    }else{
        console.log("ERROR");
    }

}


function b64EncodeUnicode(str) {
    return btoa(encodeURIComponent(str).replace(/%([0-9A-F]{2})/g,
        function toSolidBytes(match, p1) {
            return String.fromCharCode('0x' + p1);
    }));
}






function openfirmaWidget(str) {
  document.getElementById("formWidget").submit();
  $("#firmaWidget").show();
  console.log("openfirmaWidget");
}

