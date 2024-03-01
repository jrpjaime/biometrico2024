import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NAV } from 'src/app/global/navigation';
import { TestlifeComponent } from './component/testlife.component';
//import { AuthGuard } from '../../core/helper/auth.guard';
const routes: Routes = [{
    path: '',
  //  canActivate: [AuthGuard],
    children: [
      {
        path: NAV.test,
        pathMatch: 'full',
        component: TestlifeComponent
    },
      {
          path: NAV.lifeLoad,
          pathMatch: 'full',
          component: TestlifeComponent
      } ]
}];

@NgModule({
  imports: [RouterModule.forChild ( routes )],
  exports: [RouterModule]
})
export class TestlifeRoutingModule { }
