import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { config, Observable, of } from 'rxjs';
import { map } from 'rxjs/operators';
import { EPs } from '../../global/endPoint';
import { Config } from '../model/config';
import { UserInfo } from '../model/user-info.model';
import { UserSession } from '../model/user.session';
import {LoginUsuario} from '../model/loginUsuario';
// import { ConfigService } from './config.service';
import { HandleError, HttpErrorHandler } from './http-error-handler.service';
import { environment } from '../../../environments/environment';
import { AlertService } from 'src/app/shared/service/alert.service';
import { NAV } from 'src/app/global/navigation';
import { JwtDto } from '../model/jwtDto';
import { Userlife } from '../model/userlife';


@Injectable()
export class AuthService {

	private handleError: HandleError;
	private TOKEN = "_aUth_tOkEn_"
	private USER_SESSION = "_uSeR_sEssIoN_";



	constructor(
		private router: Router,
        private http: HttpClient,
		// private configService: ConfigService,
		httpErrorHandler: HttpErrorHandler,
    public alertService: AlertService,
	) {
		this.handleError = httpErrorHandler.createHandleError('AuthService');
	 }

	 public authenticate  (config: Config ) {

		let options: any = {};
		options.headers = {
		  'Content-Type': "application/x-www-form-urlencoded"
		};

		const _config = new HttpParams ( )
		.set ( 'username', config.username )
		.set ( 'password', config.password );

    console.log("authenticate  (config: Config )  ");
    console.log("config.username: "+config.username);
    console.log("config.password: "+config.password);


		return this.http.post<any>(  environment.apiBiometricosAutorizacion +  EPs.oauth.token, _config, options).pipe(map((token:any) => {

				sessionStorage.setItem ( this.TOKEN, encodeURIComponent ( JSON.stringify ( token.access_token ) ) );

				return token;
			}
		));

	}

	public getUserInfo (curp: string) {
    console.log("getUserInfo curp" +curp);
		return this.http.get<UserInfo>(  environment.apiBiometricosAutorizacion + EPs.oauth.userinfo)
			.pipe(map((userinfo:any) => {




					this.http.get(environment.apiBiometricosAutorizacion + EPs.sau.operador+  `/${curp}`)
					.subscribe({

            next: (usuario:any) => {

              console.log("usuario.codigo: "+usuario.codigo);
              if(usuario.codigo!=1){
                this.router.navigate([NAV.login]);
                this.alertService.error("iar la sesión. "+ usuario.mensaje);
              }

							let userSession : UserSession = {
								curp : curp,
                nombreUsuario: curp,
								username: userinfo.cn + " " + userinfo.sn + " " + userinfo.givenName,
								cveDelegacion: userinfo.businessCategory === undefined ? 0 : userinfo.businessCategory,
								cveSubDelegacion: userinfo.departmentNumber === undefined ? 0 : userinfo.departmentNumber,

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


							sessionStorage.setItem ( this.USER_SESSION, encodeURIComponent ( JSON.stringify ( userSession ) ) );
							return userSession;


					},
          error: (err: Error) => {
          	this.router.navigate([NAV.login]);
            this.alertService.error("Error al iniciar la sesión.");
            setTimeout(() => {
              window.location.reload();
            }, 5000);
          },
          complete:() => {

          }

        });


				}));

	}

	getAuthorizationToken() {
		const authToken = sessionStorage.getItem(this.TOKEN);

		return authToken && authToken.length > 0
			? JSON.parse(decodeURIComponent(authToken))
			: null
	};

	getUserSession() {
		const authToken = sessionStorage.getItem(this.USER_SESSION);

		return authToken && authToken.length > 0
			? JSON.parse(decodeURIComponent(authToken)) as UserSession
			: null
	};


  getUserSessionLlife() {
		const authTokenlife = sessionStorage.getItem("_uSeR_sEssIoN_liFe_");

		return authTokenlife && authTokenlife.length > 0
			? JSON.parse(decodeURIComponent(authTokenlife)) as Userlife
			: null
	};

	logout() {
		sessionStorage.clear ();
	}

  public getToken(): string {
    return sessionStorage.getItem(this.TOKEN);
  }

  public isLogged(): boolean {

    if (this.getToken()) {
      return true;
    }
    return false;
  }


    public autentica(config: Config): Observable<any> {
      return this.http.post<any>(environment.apiBiometricosAutorizacion + EPs.sau.autentica ,config);
    }





    public authenticacion  (loginUsuario:LoginUsuario) {


      console.log("loginUsuario.nombreUsuario: "+ loginUsuario.nombreUsuario);
      console.log("loginUsuario.password: "+ loginUsuario.password );
      console.log("loginUsuario.rfc: "+ loginUsuario.rfc);
      console.log("loginUsuario.origen: "+ loginUsuario.origen);

        this.http.post<any>(environment.apiBiometricosAutorizacion +  EPs.oauth.login,   loginUsuario)
        .subscribe({

          next: (usuario:any) => {
            console.log("usuario.codigo: "+ usuario.codigo);
            if(usuario.codigo!=1){
              this.router.navigate([NAV.login]);
              this.alertService.error("Error al iniciar la sesión. "+ usuario.mensaje);
              setTimeout(() => {
                window.location.reload();
              }, 5000);
            }


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

            return userSession;


        },
        error: (err: Error) => {
          this.router.navigate([NAV.login]);
          this.alertService.error("Error al iniciar la sesión.");
          setTimeout(() => {
            window.location.reload();
          }, 5000);
        },
        complete:() => {

        }

      });

    }





    public authenticar (username:string, password:string) {

      let options: any = {};
      options.headers = {
        'Content-Type': "application/x-www-form-urlencoded"
      };

      const _config = new HttpParams ( )
      .set ( 'rfc', username)
      .set ( 'username',  username )
      .set ( 'password', password );



        this.http.post( environment.apiBiometricosAutorizacion +  EPs.oauth.token, _config, options)
        .subscribe({

          next: (usuario:any) => {

            if(usuario.codigo!=1){
              this.router.navigate([NAV.login]);
              this.alertService.error("Error al iniciar la sesión. "+ usuario.mensaje);
              setTimeout(() => {
                window.location.reload();
              }, 5000);
            }


            console.log("nombreRazonSocial: "+ usuario.nombreRazonSocial);
            console.log("rfc: "+ usuario.rfc);
            console.log("cveIdUsuario: "+ usuario.cveIdUsuario);

            console.log("token: "+ usuario.token);

            let userSession : UserSession = {
              rfc:  usuario.rfc ,
              username:  usuario.nombreRazonSocial ,
              cveIdUsuario:  usuario.cveIdUsuario ,
              curp : "",

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

            return userSession;


        },
        error: (err: Error) => {
          this.router.navigate([NAV.login]);
          this.alertService.error("Error al iniciar la sesión.");
          setTimeout(() => {
            window.location.reload();
          }, 5000);
        },
        complete:() => {

        }

      });

    }



    public refresh (jwtDto:JwtDto): Observable<JwtDto> {
      console.log("refresh "  );
      console.log("jwtDto.token: "+ jwtDto.token );
      console.log("jwtDto.nombreUsuario: "+ jwtDto.nombreUsuario);
      console.log("jwtDto.curp: "+ jwtDto.curp );
      console.log("jwtDto.rfc: "+ jwtDto.rfc);
      return this.http.post<any>(environment.apiBiometricosAutorizacion +  EPs.oauth.refresh,   jwtDto);
    }




    public refreshA (jwtDto:JwtDto) {


      console.log("jwtDto.nombreUsuario: "+ jwtDto.nombreUsuario);
      console.log("jwtDto.curp: "+ jwtDto.curp );
      console.log("jwtDto.token: "+ jwtDto.token );
      console.log("jwtDto.rfc: "+ jwtDto.rfc);
      console.log("jwtDto.origen: "+ jwtDto.origen);

        this.http.post<any>(environment.apiBiometricosAutorizacion +  EPs.oauth.refresh,   jwtDto)
        .subscribe({

          next: (usuario:any) => {

            if(usuario.codigo!=1){
              this.router.navigate([NAV.login]);
              this.alertService.error("Error al iniciar la sesión. "+ usuario.mensaje);
              setTimeout(() => {
                window.location.reload();
              }, 5000);
            }


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

            return userSession;


        },
        error: (err: Error) => {
          this.router.navigate([NAV.login]);
          this.alertService.error("Error al iniciar la sesión.");
          setTimeout(() => {
            window.location.reload();
          }, 5000);
        },
        complete:() => {

        }

      });

    }


}
