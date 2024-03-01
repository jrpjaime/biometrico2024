import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';


import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Constants } from 'src/app/global/constant';
import { EPs } from '../../../global/endPoint';
import { Filtro } from '../../../core/model/filtro';


import { environment } from './../../../../environments/environment';
import { Validarcredencial } from '../model/validarcredencial';
import { LoginUsuario } from 'src/app/core/model/loginUsuario';



@Injectable({
	providedIn: 'root'
})
export class ValidarcredencialService {

	constructor(
    private httpClient: HttpClient
	) { }



/*

  public validarCredencial(testlifecredencial: Validarcredencial): Observable<any> {
    console.log("validarCredencial");
    console.log("testlifecredencial.fotoPruebaVida: "+ testlifecredencial.curp);
    console.log("testlifecredencial.curp: "+ testlifecredencial.fotoPruebaVida);
    console.log("testlifecredencial.cveIdUsuario: "+ testlifecredencial.cveIdUsuario);
    console.log("testlifecredencial.nombreUsuario: "+ testlifecredencial.nombreUsuario);
    console.log("testlifecredencial.rfc: "+ testlifecredencial.rfc);

    console.log("EPs.usuario.seguimiento.validarCredencial: "+EPs.usuario.seguimiento.validarCredencial);

    return this.httpClient.post<any>(environment.apiBiometricosAutorizacion + EPs.usuario.seguimiento.validarCredencial ,testlifecredencial);
  }
*/


  public validarCredencial( ): Observable<any> {
    return this.httpClient.post<any>(environment.apiSaiiaAfiliacion + EPs.usuario.seguimiento.validarCredencial, null );
 }


 public registrarCredencial(loginUsuario:LoginUsuario ): Observable<any> {

console.log("registrarCredencial");
console.log("loginUsuario:" + loginUsuario.imagen);



  return this.httpClient.post<any>(environment.apiSaiiaAfiliacion + EPs.usuario.seguimiento.registrarCredencial, loginUsuario );
}


}
