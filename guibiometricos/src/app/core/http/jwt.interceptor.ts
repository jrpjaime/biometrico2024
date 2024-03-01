import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent, HTTP_INTERCEPTORS, HttpErrorResponse } from '@angular/common/http';
import { AuthService } from '../service/auth.service';
import { Observable, throwError } from 'rxjs';
import { catchError, concatMap } from 'rxjs/operators';
import { JwtDto } from '../model/jwtDto';
import { UserSession } from '../model/user.session';

@Injectable()
export class JwtInterceptor implements HttpInterceptor {

  constructor(
    private auth: AuthService
  ) { }


  private TOKEN = "_aUth_tOkEn_"
	private USER_SESSION = "_uSeR_sEssIoN_";


  cveIdUsuario: string="";
  rfc: string="";
  curp: string="";
  nombreUsuario: string="";
  nombreRazonSocial: string="";

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    if (!this.auth.isLogged()) {
      return next.handle(req);
    }

    const userSession = this.auth.getUserSession();
    if(userSession != null){
    this.cveIdUsuario=userSession!.cveIdUsuario;
    this.rfc=userSession!.rfc;

    this.curp =userSession!.curp;
    this.nombreUsuario =userSession!.nombreUsuario;
    this.nombreRazonSocial =userSession!.username;

    console.log("this.cveIdUsuario: "+ this.cveIdUsuario);
    console.log("this.curp: "+ this.curp);
    console.log("this.nombreUsuario: "+ this.nombreUsuario);
    console.log("this.rfc: "+ this.rfc);
    console.log("this.nombreRazonSocial: "+ this.nombreRazonSocial);
    }


    let intReq = req;
    let token = this.auth.getAuthorizationToken();
    console.log('Actual token '+ token);
    if (token != null) {
      intReq = req.clone({ headers: req.headers.set('Authorization', 'Bearer ' + token) });
    }

    // return next.handle(intReq);

    return next.handle(intReq).pipe(catchError((err: HttpErrorResponse) => {
      console.log('Error: ' + err.status);
      if (err.status === 401) {
        console.log('Sesión expirada');
        let jwtDTO=new  JwtDto();
        jwtDTO.token=token;
        jwtDTO.rfc=this.rfc;
        jwtDTO.cveIdUsuario=this.cveIdUsuario;
        jwtDTO.nombreRazonSocial =this.nombreRazonSocial;
        jwtDTO.nombreUsuario =this.nombreUsuario;
        jwtDTO.curp =this.curp;
        return this.auth.refresh(jwtDTO).pipe(concatMap((data: any) => {
          console.log('refreshing.............');
          console.log('data.token');
          sessionStorage.setItem (this.TOKEN, encodeURIComponent (JSON.stringify (data.token )));

          intReq = this.addToken(req, data.token);
          return next.handle(intReq);
        }));

        /*
        .subscribe({

          next: (usuario:any) => {

            console.log("nombreRazonSocial: "+ usuario.nombreRazonSocial);
            console.log("rfc: "+ usuario.rfc);
            console.log("cveIdUsuario: "+ usuario.cveIdUsuario);

            console.log("token: "+ usuario.token);

            console.log("usuario.curp: "+usuario.curp);
            console.log("usuario.nombreUsuario: "+usuario.nombreUsuario);
            console.log("token: "+ usuario.token);

            let userSession : UserSession = {
              rfc:  usuario.rfc ,
              nombreUsuario: usuario.nombreUsuario,
              username:  usuario.nombreRazonSocial ,
              cveIdUsuario:  usuario.cveIdUsuario ,
              curp : usuario.curp,

              cveDelegacion: 0,
              cveSubDelegacion: 0,

              oRolSaiia: usuario.oRolSaiia === undefined ? "" : usuario.oRolSaiia,
              oRolAdministrador: usuario.oRolAdministrador === undefined ? "" : usuario.oRolAdministrador,
              oNombre: usuario.oNombre === undefined ? "" : usuario.oNombre,
              oPaterno: usuario.oPaterno === undefined ? "" : usuario.oPaterno,
              oMaterno: usuario.oMaterno === undefined ? "" : usuario.oMaterno,
              oCveDelegacion: usuario.oCveDelegacion === undefined ? 0: usuario.oCveDelegacion,
              oCveSubdelegacion: usuario.oCveSubdelegacion === undefined ? 0 : usuario.oCveSubdelegacion,
              oDelegacion: usuario.oDelegacion === undefined ? "" : usuario.oDelegacion,
              oSubdelegacion: usuario.oSubdelegacion === undefined ? "" : usuario.oSubdelegacion,
              oCiz: usuario.oCiz === undefined ? 0 : usuario.oCiz,
              oIdDelegacion: usuario.oIdDelegacion === undefined ? 0 : usuario.oIdDelegacion,
              oIdSubdelegacion: usuario.oIdSubdelegacion === undefined ? 0 : usuario.oIdSubdelegacion,


              movimientoIndividual: usuario.movimientoIndividual === undefined ? false : usuario.movimientoIndividual,
              movimientoLote: usuario.movimientoLote === undefined ? false: usuario.movimientoLote,
              movimientoRetroalimentacion: usuario.movimientoRetroalimentacion === undefined ? false : usuario.movimientoRetroalimentacion,
              autorizacion: usuario.autorizacion === undefined ? false : usuario.autorizacion,
              consultaLote: usuario.consultaLote === undefined ? false : usuario.consultaLote,
              consultaDiasInhabiles: usuario.consultaDiasInhabiles === undefined ? false : usuario.consultaDiasInhabiles,
              consultaProcesados: usuario.consultaProcesados === undefined ? false : usuario.consultaProcesados,
              consultaAdministracionInhabiles: usuario.consultaAdministracionInhabiles === undefined ? false : usuario.consultaAdministracionInhabiles,
              consultaBitacoraPersonal: usuario.consultaBitacoraPersonal === undefined ? false : usuario.consultaBitacoraPersonal,

              //descDelegacion : null,
              //descSubdelegacion: null,
            };

            sessionStorage.setItem ( this.TOKEN, encodeURIComponent ( JSON.stringify ( usuario.token ) ) );
            sessionStorage.setItem ( this.USER_SESSION, encodeURIComponent ( JSON.stringify ( userSession ) ) );

            token = this.auth.getAuthorizationToken();
            console.log('nuevo token '+ token);
            intReq = req.clone({ headers: req.headers.set('Authorization', 'Bearer ' + token) });


        },
        error: (err: Error) => {

        },
        complete:() => {

        }

      });
*/

      return next.handle(intReq);

      }else{
        this.auth.logout();
        return throwError(err);
      }




    }));

    /*


    intReq = this.addToken(req, token);

    return next.handle(intReq).pipe(catchError((err: HttpErrorResponse) => {
      if (err.status === 401) {
        const dto: JwtDTO = new JwtDTO(this.tokenService.getToken());
        return this.authService.refresh(dto).pipe(concatMap((data: any) => {
          console.log('refreshing....');
          this.tokenService.setToken(data.token);
          intReq = this.addToken(req, data.token);
          return next.handle(intReq);
        }));
      } else {
        this.tokenService.logOut();
        return throwError(err);
      }
    }));

    */
  }

  private addToken(req: HttpRequest<any>, token: string): HttpRequest<any> {
    return req.clone({ headers: req.headers.set('Authorization', 'Bearer ' + token) });
  }


  /*
    intercept(req: HttpRequest<any>, next: HttpHandler) {
      // Get the auth token from the service.
      console.log("intercept ");
      const authToken = this.auth.getAuthorizationToken();
      //const userSession = this.auth.getUserSession();
       console.log("authToken:: " + authToken);
      // Clone the request and set the new header in one step.
      if (authToken != null) {
        req = req.clone({
                  setHeaders: {
                      //'Content-Type': 'application/json; charset=utf-8',
                      Authorization: `Bearer ${authToken}`
                  }
              });
      }

      // send cloned request with header to the next handler.
      return next.handle(req);
    }

    */
}

export const interceptorProvider = [{ provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true }];
