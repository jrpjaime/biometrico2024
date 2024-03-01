import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ValidarcontactoComponent } from './validarcontacto/validarcontacto.component';
import { ValidarcontactoRoutingModule } from './validarcontacto-routing.module';
import { SharedModule } from 'src/app/shared/shared.module';
import { ValidarcontactoService } from './service/validarcontacto.service';

@NgModule({
	declarations: [
		ValidarcontactoComponent
  ],
	imports: [
		CommonModule,
		ValidarcontactoRoutingModule,
		SharedModule
	],
	exports: [
	],
	providers: [
		ValidarcontactoService
	]
})
export class ValidarcontactoModule { }
