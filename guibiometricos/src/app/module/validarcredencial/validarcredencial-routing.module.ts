import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NAV } from 'src/app/global/navigation';
import { ValidarcredencialComponent } from './component/validarcredencial.component';
//import { AuthGuard } from '../../core/helper/auth.guard';
const routes: Routes = [{
    path: '',
  //  canActivate: [AuthGuard],
    children: [
      {
        path: NAV.validarcredencial,
        pathMatch: 'full',
        component: ValidarcredencialComponent
    },
      {
          path: NAV.validarcredencialLoad,
          pathMatch: 'full',
          component: ValidarcredencialComponent
      } ]
}];

@NgModule({
  imports: [RouterModule.forChild ( routes )],
  exports: [RouterModule]
})
export class ValidarcredencialRoutingModule { }
