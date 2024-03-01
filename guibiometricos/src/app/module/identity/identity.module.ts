import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SharedModule } from 'src/app/shared/shared.module';
import { AuthService } from 'src/app/core/service/auth.service';
import { LoginComponent } from './login/login.component';
import { LoginfielComponent } from './loginfiel/loginfiel.component';
import { LogincurpComponent } from './logincurp/logincurp.component';
import { LogincredencialComponent } from './logincredencial/logincredencial.component';
import { BrowserModule } from '@angular/platform-browser';
import { WebcamModule } from 'ngx-webcam';
import { LoginpruebavidaComponent } from './loginpruebavida/loginpruebavida.component';

@NgModule({
	declarations: [
		LoginComponent,
		LoginfielComponent,
    LogincurpComponent,
		LogincredencialComponent,
    LoginpruebavidaComponent

	],
	imports: [
		CommonModule,
		//BrowserModule,
		FormsModule,
		ReactiveFormsModule,
		SharedModule,
    WebcamModule
	],
	exports: [
	],
	providers: [
//		AuthService
	]
})
export class IdentityModule { }
