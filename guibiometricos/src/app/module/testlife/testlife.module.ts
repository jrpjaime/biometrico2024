import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TestlifeComponent } from './component/testlife.component';
import { TestlifeRoutingModule } from './testlife-routing.module';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SharedModule } from 'src/app/shared/shared.module';
import { TestlifeService } from './service/testlife.service';



@NgModule({
	declarations: [
		TestlifeComponent

  	],
	imports: [
		CommonModule,
		FormsModule,
		ReactiveFormsModule,
		TestlifeRoutingModule,
		SharedModule
	],
	exports: [
	],
	providers: [
		TestlifeService
	]
})
export class TestlifeModule { }
