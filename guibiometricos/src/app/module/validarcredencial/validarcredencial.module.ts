import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ValidarcredencialComponent } from './component/validarcredencial.component';
import { ValidarcredencialRoutingModule } from './validarcredencial-routing.module';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SharedModule } from 'src/app/shared/shared.module';
import { ValidarcredencialService } from './service/validarcredencial.service';
import {WebcamModule} from 'ngx-webcam';


@NgModule({
	declarations: [
		ValidarcredencialComponent

  	],
	imports: [
		CommonModule,
		FormsModule,
		ReactiveFormsModule,
		ValidarcredencialRoutingModule,
		SharedModule,
    WebcamModule
	],
	exports: [
	],
	providers: [
		ValidarcredencialService
	]
})
export class ValidarcredencialModule { }
