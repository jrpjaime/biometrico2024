import { Component, OnInit, isDevMode } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NgxSpinnerService } from 'ngx-spinner';
import { first } from 'rxjs/operators';
import { Config } from 'src/app/core/model/config';
import { AuthService } from 'src/app/core/service/auth.service';
import { PATTERN } from 'src/app/global/constant';
import { NAV } from 'src/app/global/navigation';
import { AlertService } from 'src/app/shared/service/alert.service';
import { Credential } from '../model/credential.model';
import { environment } from '../../../../environments/environment';
import { LoginUsuario } from 'src/app/core/model/loginUsuario';



declare const openfirmaWidget: any;
declare const respuestaCHFECyN: any;


@Component({
	selector: 'app-login',
	templateUrl: './loginfiel.component.html',
	styleUrls: ['./loginfiel.component.css']
})
export class LoginfielComponent implements OnInit {

	loginForm!: FormGroup;
	error!: boolean;

  ip?: string;
  macAddress?: string;
  hostname?: string;

  //isSesion!: boolean;


	constructor(
		private router: Router,
		private formBuilder: FormBuilder,
		private authService: AuthService,
		private alertService: AlertService,
		private ngxSpinner: NgxSpinnerService

	) {


    if (window.addEventListener) {
      window.addEventListener("message", this.receiveMessage.bind(this), false);
    } else {
       (<any>window).attachEvent("onmessage", this.receiveMessage.bind(this));
    }

  }

  receiveMessage: any = (event: any) =>  {
console.log(":::::::::::::::::::::::::::***receiveMessage"+event.data);


if(event.data.length >0){

  const parsedJSON = JSON.parse(event.data);
  const credential: Credential = parsedJSON as Credential;


  console.log("credential.resultado: "+credential.resultado);
  console.log("credential.texto: "+credential.texto);
if(credential.resultado===0){
  console.log(".....................home credential.resultado: "+credential.resultado);
  console.log("credential.rfc: "+credential.rfc);

  console.log("credential.curp: "+credential.curp);
  let loginUsuario=new  LoginUsuario();

  loginUsuario.nombreUsuario=credential.curp;
  loginUsuario.password="";
  loginUsuario.rfc=credential.rfc;
  loginUsuario.origen="1";


  this.authService.authenticacion(loginUsuario);

  console.log(".......this.router.navigate([NAV.home]) "+NAV.home );

}

}




  }



  login(){
    this.router.navigate([NAV.login]);
  }


  ngAfterViewChecked(){

  if(this.userSession!=null){
    this.router.navigate([NAV.home]);
  }

  }



	get userSession() {
		return this.authService.getUserSession();
	}

  ngOnInit(): void {
    let script =document.createElement("script");
    script.src="https://framework-gb.cdn.gob.mx/gobmx.js";
    let body=document.getElementsByTagName("body")[0];
    body.appendChild(script);

    openfirmaWidget();


    if (isDevMode()) {

    } else {

    }
    this.authService.logout();





  }



	get curp() { return this.loginForm.get('curp')!; }
	get password() { return this.loginForm.get('password')!; }

	onSubmit() {
    this.error=false;
		this.ngxSpinner.show();

		const config: Config = {
			grant_type: '',
			client_id: '',
			client_secret: '',
			scope: '',
			username: this.loginForm.value.curp,
			password: this.loginForm.value.password
		};





console.log("this.authService.authenticate(config)");

		this.authService.authenticate(config)
			.pipe(first())
			.subscribe({
				next: (response: any) => {

					// Obtener la información del usaurio
					this.authService.getUserInfo(config.username)
						.pipe(first())
						.subscribe({
							next: (response: any) => {
                console.log("this.router.navigate([NAV.home])");
								this.router.navigate([NAV.home]);

							},
							error: (err: any) => {
                this.ngxSpinner.hide();
								this.alertService.error(JSON.parse(err.error).error_description);

							},
							complete: () => {

							}
						})

				},
				error: (err: any) => {
					//this.alertService.error ( err?.message );
					// this.alertService.error ("Usuario y/o Contraseña incorrecta. Favor de verifica");
					//console.log("authenticate err: " + JSON.parse(err.error).error_description);

					this.error = true;
					//this.alertService.error ( JSON.parse(err.error).error_description );
					this.ngxSpinner.hide();
				}
			})



	}






}
