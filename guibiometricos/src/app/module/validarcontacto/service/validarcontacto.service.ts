import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';


import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Constants } from 'src/app/global/constant';
import { EPs } from '../../../global/endPoint';
import { Filtro } from '../../../core/model/filtro';


import { environment } from './../../../../environments/environment';
import { Contacto } from 'src/app/module/contacto/model/contacto';


@Injectable({
	providedIn: 'root'
})
export class ValidarcontactoService {

	constructor(
    private httpClient: HttpClient
	) { }




  public validarContacto(contacto: Contacto): Observable<any> {
    console.log("createContacto");
    console.log("rfc"+ contacto.rfc);
    console.log("cveIdUsuario"+ contacto.cveIdUsuario);
    console.log("desCorreoElectronico"+ contacto.code);
    return this.httpClient.post<any>(environment.apiBiometricosAutorizacion + EPs.usuario.seguimiento.validarContacto ,contacto);
  }



}
