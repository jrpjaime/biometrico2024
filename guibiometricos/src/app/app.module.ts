import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
//import { MovimientoloteModule } from './module/movimientolote/movimientolote.module';

import { SharedModule } from './shared/shared.module';
import { HomeModule } from './module/home/home.module'
import { ValidarcontactoModule } from './module/validarcontacto/validarcontacto.module'
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { CoreModule } from './core/core.module';
import { GlobalModule } from './global/global.module';
import { NgxSpinnerModule } from 'ngx-spinner';
import { httpInterceptorProviders } from './core';
import { IdentityModule } from './module/identity/identity.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {WebcamModule} from 'ngx-webcam';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    CoreModule,
    AppRoutingModule,
    SharedModule,
    IdentityModule,
    ValidarcontactoModule,
    //MovimientoloteModule,
    HomeModule,
    GlobalModule,//.forRoot()
    NgxSpinnerModule,
    WebcamModule
  ],
  providers: [
    httpInterceptorProviders
  ],
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule { }


