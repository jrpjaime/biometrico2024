import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/core/helper/auth.guard';
import { NAV } from 'src/app/global/navigation';
import { ValidarcontactoComponent } from './validarcontacto/validarcontacto.component';

const routes: Routes = [{
    path: '',
    canActivate: [AuthGuard],
    children: [
    {
        path: 'validarContacto',
        pathMatch: 'full',
        component: ValidarcontactoComponent
    }]
}];

@NgModule({
  imports: [ RouterModule.forChild ( routes ) ],
  exports: [ RouterModule ]
})
export class ValidarcontactoRoutingModule { }
