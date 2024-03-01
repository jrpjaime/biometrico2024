import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NAV } from 'src/app/global/navigation';
import { ContactoComponent } from './component/contacto.component';
//import { AuthGuard } from '../../core/helper/auth.guard';
const routes: Routes = [{
    path: '',
  //  canActivate: [AuthGuard],
    children: [
      {
        path: NAV.autorizar,
        pathMatch: 'full',
        component: ContactoComponent
    },
      {
          path: NAV.contactoLoad,
          pathMatch: 'full',
          component: ContactoComponent
      } ]
}];

@NgModule({
  imports: [RouterModule.forChild ( routes )],
  exports: [RouterModule]
})
export class ContactoRoutingModule { }
