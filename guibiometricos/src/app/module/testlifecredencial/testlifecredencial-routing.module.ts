import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NAV } from 'src/app/global/navigation';
import { TestlifecredencialComponent } from './component/testlifecredencial.component';
//import { AuthGuard } from '../../core/helper/auth.guard';
const routes: Routes = [{
    path: '',
  //  canActivate: [AuthGuard],
    children: [
      {
        path: NAV.validacionCredencial,
        pathMatch: 'full',
        component: TestlifecredencialComponent
    },
      {
          path: NAV.validacionCredencialLoad,
          pathMatch: 'full',
          component: TestlifecredencialComponent
      } ]
}];

@NgModule({
  imports: [RouterModule.forChild ( routes )],
  exports: [RouterModule]
})
export class TestlifecredencialRoutingModule { }
