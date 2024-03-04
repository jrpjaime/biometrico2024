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





@Component({
	selector: 'app-login',
	templateUrl: './logincurp.component.html',
	styleUrls: ['./logincurp.component.css']
})
export class LogincurpComponent implements OnInit {

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



    if (isDevMode()) {

    } else {

    }
    this.authService.logout();
    this.loginForm = this.formBuilder.group({
      curp: ['', [Validators.required ]],
      password: ['']
    });

  }



	get curp() { return this.loginForm.get('curp')!; }
	get password() { return this.loginForm.get('password')!; }

	onSubmit() {


     console.log("this.loginForm.value.curp: "+ this.loginForm.value.curp);
     console.log("this.loginForm.value.password: "+ this.loginForm.value.password);
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



    let loginUsuario=new  LoginUsuario();

    loginUsuario.nombreUsuario=this.loginForm.value.curp;
    loginUsuario.password=this.loginForm.value.password;
    loginUsuario.rfc="";
    loginUsuario.origen="2";


    this.authService.authenticacion(loginUsuario);

    //this.authService.authenticacion("",this.loginForm.value.curp, this.loginForm.value.password,"2");


	}






}
