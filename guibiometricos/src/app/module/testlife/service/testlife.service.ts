import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';


import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { LoginUsuario } from 'src/app/core/model/loginUsuario';
import { Constants } from 'src/app/global/constant';
import { EPs } from '../../../global/endPoint';



import { environment } from './../../../../environments/environment';



@Injectable({
	providedIn: 'root'
})
export class TestlifeService {

	constructor(
    private httpClient: HttpClient
	) { }









 public verificaRegistroCredencial(loginUsuario:LoginUsuario ): Observable<any> {

  console.log("registrarCredencial");
  console.log("loginUsuario:" + loginUsuario.imagen);



    return this.httpClient.post<any>(environment.apiSaiiaAfiliacion + EPs.usuario.seguimiento.verificaRegistroCredencial, loginUsuario );
  }



}
