import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';


import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Constants } from 'src/app/global/constant';
import { EPs } from '../../../global/endPoint';

import { Testlifecredencial } from '../model/testlifecredencial';

import { environment } from './../../../../environments/environment';



@Injectable({
	providedIn: 'root'
})
export class TestlifecredencialService {

	constructor(
    private httpClient: HttpClient
	) { }







  public validarCredencial(testlifecredencial: Testlifecredencial): Observable<any> {
    console.log("validarCredencial");
    console.log("testlifecredencial.fotoPruebaVida: "+ testlifecredencial.curp);
    console.log("testlifecredencial.curp: "+ testlifecredencial.fotoPruebaVida);
    console.log("testlifecredencial.cveIdUsuario: "+ testlifecredencial.cveIdUsuario);
    console.log("testlifecredencial.nombreUsuario: "+ testlifecredencial.nombreUsuario);
    console.log("testlifecredencial.rfc: "+ testlifecredencial.rfc);

    console.log("EPs.usuario.seguimiento.validarCredencial: "+EPs.usuario.seguimiento.validarCredencial);

    return this.httpClient.post<any>(environment.apiBiometricosAutorizacion + EPs.usuario.seguimiento.validarCredencial ,testlifecredencial);
  }



}
