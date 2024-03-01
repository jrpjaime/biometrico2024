import { AbstractControl } from "@angular/forms";


export class Validador{


  static validaFecha(control: AbstractControl){

    const fecha = control.value;
    if(!esFechaValida(fecha)){
      return { estructuraFechaValida: true }
    }

    return null;

}


  static validaSalario(control: AbstractControl){
    const monSalarioDiario = control.value;


    if(monSalarioDiario!=null){
    if(!esNumeroValido(monSalarioDiario)){
      return { validaLongitud: true }
    }
  }

    return null;
}


  static validaRegistroPatronal(control: AbstractControl){
    const registroPatronal = control.value;
    if(registroPatronal.length!=11){
      return { validaLongitudRp: true }
    }

    if(rpValido(registroPatronal)){
      return null;
    }
      return { validaRp: true }
}





static validaNumNss(control: AbstractControl){
    const nss = control.value;
    if(nssPosicionInicial(nss)){
      return { nssPosicionInicial: true }

    }

    if(nssEstudiante(nss)){
      return { nssEstudiante: true }
    }

    if(nss.length>0){
      if(nss.length!=11 ){
        return { validaLongitud: true }
      }
    }else{
      return null;

    }


    if(nssValido(nss)){
      return null;

    }
      return { validaNumNss: true }
}

static validaFechaMovimiento(control: AbstractControl): any{
  return null;
}
}


function isDate(fecha:string){
  var date = new Date(fecha);
  if(isNaN(date.getTime())){
    return false;
  }
  return true;

}




function nssPosicionInicial(val:string){
  let result = val.substring(0, 2);
  if(result=='00'  ){
    return true;
  }
  return false;
}


function nssEstudiante(val:string){
  let result1 = val.substring(2, 3);
  let result = val.substring(0, 2);
  if(result1=='3' && ( result=='01'  || result=='02' || result=='03'  || result=='04'  || result=='05' || result=='06'  || result=='07'  || result=='08' || result=='09'  ||
  result=='10' || result=='11'  || result=='12'  || result=='13' || result=='14'  || result=='15'  || result=='16' || result=='17'  || result=='18'  || result=='19' ||
  result=='20' || result=='21'  || result=='22'  || result=='23' || result=='24'  || result=='25'  || result=='26' || result=='27'  || result=='28'  || result=='29' ||
  result=='30' || result=='31'  || result=='32'  || result=='33' || result=='34'  || result=='35'  || result=='36' || result=='37'  || result=='38'  || result=='39' ||
  result=='40')){
    return true;
  }
  return false;
}



function rpValido(val:string){


  return true;
}


function isNumber(val:string){
    return !isNaN(parseInt(val));
}


// Devuelve un booleano si es un NSS válido
// (deben ser 11 dígitos sin otro caracter en el medio)
function nssValido(nss:string) {
  const re       = /^(\d{2})(\d{2})(\d{2})\d{5}$/,
        validado = nss.match(re);

  if (!validado) {
    // 11 dígitos y subdelegación válida?
    return false;
  }
  return true;

}





function esNumeroValido(dato:string){

                var indices = [];
              for(var i = 0; i < dato.length; i++) {
                if (dato[i].toLowerCase() === ".") indices.push(i);
              }

              if(indices.length>1){
                return false;
              }

             /*Definición de los valores aceptados*/
             var valoresAceptados = /^[0-9]+$/;
             if(dato.indexOf!=null){
             if (dato.indexOf(".") === -1 ){
                if(dato.length<5){
                  if (dato.match(valoresAceptados)){
                    return true;
                 }else{
                    return false;
                 }
                }else{
                  return false;
                }

             }else{
                 //dividir la expresión por el punto en un array
                 var particion = dato.split(".");
                 //evaluamos la primera parte de la división (parte entera)
                 if (particion[0].match(valoresAceptados) || particion[0]==""){
                     if (particion[1].match(valoresAceptados)){
                         return true;
                     }else {
                         return false;
                     }
                 }else{
                     return false;
                 }
             }
            }
            return true;
}




function esFechaValida(dato:string){

  var indices = [];
for(var i = 0; i < dato.length; i++) {
  if (dato[i].toLowerCase() === "/") indices.push(i);
}

if(indices.length!=2){
  return false;
}

/*Definición de los valores aceptados*/
var valoresAceptados = /^\d{2}\/\d{2}\/\d{4}$/;

   if (dato.match(valoresAceptados)){
           return true;
   }else{
       return false;
   }

}
