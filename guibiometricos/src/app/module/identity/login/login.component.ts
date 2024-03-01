import { Component, OnInit, isDevMode } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {  ActivatedRoute, Route, Router } from '@angular/router';
import { NgxSpinnerService } from 'ngx-spinner';
import { first } from 'rxjs/operators';
import { Config } from 'src/app/core/model/config';
import { AuthService } from 'src/app/core/service/auth.service';
import { PATTERN } from 'src/app/global/constant';
import { NAV } from 'src/app/global/navigation';
import { AlertService } from 'src/app/shared/service/alert.service';
import { Credential } from '../model/credential.model';
import { environment } from '../../../../environments/environment';



@Component({
	selector: 'app-login',
	templateUrl: './login.component.html',
	styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {



	constructor(
    public router: Router,
		private actRoute: ActivatedRoute,
		private formBuilder: FormBuilder,
		private authService: AuthService,
		private alertService: AlertService,
		private ngxSpinner: NgxSpinnerService

	) {

  }

	get nav() { return NAV; }

	ngOnInit() {

        let script =document.createElement("script");
        script.src="https://framework-gb.cdn.gob.mx/gobmx.js";
        let body=document.getElementsByTagName("body")[0];
        body.appendChild(script);
}


loginfiel(){
  this.router.navigate([NAV.loginfiel]);
}


logincurp(){
  this.router.navigate([NAV.logincurp]);
}


logincredencial(){
  this.router.navigate([NAV.logincredencial]);
}


loginpruebavida(){
  this.router.navigate([NAV.loginpruebavida]);
}



}
