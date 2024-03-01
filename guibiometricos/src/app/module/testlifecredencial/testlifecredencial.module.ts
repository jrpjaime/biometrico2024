import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TestlifecredencialComponent } from './component/testlifecredencial.component';
import { ListatestlifecredencialComponent } from './component/listatestlifecredencial.component';
import { TestlifecredencialRoutingModule } from './testlifecredencial-routing.module';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SharedModule } from 'src/app/shared/shared.module';
import { TestlifecredencialService } from './service/testlifecredencial.service';



@NgModule({
	declarations: [
		TestlifecredencialComponent,
    ListatestlifecredencialComponent

  	],
	imports: [
		CommonModule,
		FormsModule,
		ReactiveFormsModule,
		TestlifecredencialRoutingModule,
		SharedModule
	],
	exports: [
	],
	providers: [
		TestlifecredencialService
	]
})
export class TestlifecredencialModule { }
