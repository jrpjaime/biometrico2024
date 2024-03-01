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
import { MovimientoloteService } from '../../movimientolote/service/movimientolote.service';
import { environment } from '../../../../environments/environment';
import { CatalogosService } from '../../movimientoindividual/service/catalogos.service';



declare const openfirmaWidget: any;
declare const respuestaCHFECyN: any;


@Component({
	selector: 'app-login',
	templateUrl: './login.component.html',
	styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

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
		private ngxSpinner: NgxSpinnerService,
    private movimientoloteService: MovimientoloteService,
		private catalogosService: CatalogosService

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
  this.authService.authenticacion(credential.rfc);


  console.log(".......this.router.navigate([NAV.home]) "+NAV.home );

}

}




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







		this.authService.authenticate(config)
			.pipe(first())
			.subscribe({
				next: (response: any) => {

					// Obtener la información del usaurio
					this.authService.getUserInfo(config.username)
						.pipe(first())
						.subscribe({
							next: (response: any) => {

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
