import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { appRoutes } from './global/routes';

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
