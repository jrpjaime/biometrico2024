import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ContactoComponent } from './component/contacto.component';
import { ListacontactoComponent } from './component/listacontacto.component';
import { ContactoRoutingModule } from './contacto-routing.module';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SharedModule } from 'src/app/shared/shared.module';
import { ContactoService } from './service/contacto.service';



@NgModule({
	declarations: [
		ContactoComponent,
    ListacontactoComponent

  	],
	imports: [
		CommonModule,
		FormsModule,
		ReactiveFormsModule,
		ContactoRoutingModule,
		SharedModule
	],
	exports: [
	],
	providers: [
		ContactoService
	]
})
export class ContactoModule { }
