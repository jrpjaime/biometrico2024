import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/core/helper/auth.guard';
import { NAV } from 'src/app/global/navigation';
import { HomeComponent } from './home/home.component';

const routes: Routes = [{
    path: '',
    canActivate: [AuthGuard],
    children: [
    {
        path: '',
        pathMatch: 'full',
        component: HomeComponent
    }]
}];

@NgModule({
  imports: [ RouterModule.forChild ( routes ) ],
  exports: [ RouterModule ]
})
export class HomeRoutingModule { }
