import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';


import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Constants } from 'src/app/global/constant';
import { EPs } from '../../../global/endPoint';

import { Contacto } from '../model/contacto';

import { environment } from './../../../../environments/environment';



@Injectable({
	providedIn: 'root'
})
export class ContactoService {

	constructor(
    private httpClient: HttpClient
	) { }






  public listContactoAutorizado(page: number, size: number, order: string, asc: boolean, cveIdUsuario: string): Observable<any> {
    console.log("listContacto");
    console.log("cveIdUsuario:" + cveIdUsuario);
    console.log("url:" + environment.apiBiometricosAutorizacion + EPs.usuario.seguimiento.listContactoAutorizado);
    return this.httpClient.get<any>(environment.apiBiometricosAutorizacion + EPs.usuario.seguimiento.listContactoAutorizado + `?page=${page}&size=${size}&order=${order}&asc=${asc}&cveIdUsuario=${cveIdUsuario}` );
  }

  public listContacto(page: number, size: number, order: string, asc: boolean, cveIdUsuario: string): Observable<any> {
    console.log("listContacto");
    console.log("cveIdUsuario:" + cveIdUsuario);
    console.log("url:" + environment.apiBiometricosAutorizacion + EPs.usuario.seguimiento.listContacto);
    return this.httpClient.get<any>(environment.apiBiometricosAutorizacion + EPs.usuario.seguimiento.listContacto + `?page=${page}&size=${size}&order=${order}&asc=${asc}&cveIdUsuario=${cveIdUsuario}` );
  }

  public createContacto(contacto: Contacto): Observable<any> {
    console.log("createContacto");
    console.log("rfc"+ contacto.rfc);
    console.log("cveIdUsuario"+ contacto.cveIdUsuario);
    console.log("desCorreoElectronico"+ contacto.desCorreoElectronico);
    return this.httpClient.post<any>(environment.apiBiometricosAutorizacion + EPs.usuario.seguimiento.createContacto ,contacto);
  }


  public deleteContacto(contacto: Contacto): Observable<any> {
    console.log("createContacto");
    console.log("rfc"+ contacto.rfc);
    console.log("cveIdUsuario"+ contacto.cveIdUsuario);
    console.log("cveIdMedioContacto"+ contacto.cveIdMedioContacto);
    return this.httpClient.post<any>(environment.apiBiometricosAutorizacion + EPs.usuario.seguimiento.deleteContacto ,contacto);
  }



}
