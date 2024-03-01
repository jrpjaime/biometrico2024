import { NgModule, Optional, SkipSelf } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthService } from './service/auth.service';
import { HttpErrorHandler } from './service/http-error-handler.service';
import { httpInterceptorProviders } from './index';
import { MessageService } from './service/message.service';
// import { ConfigService } from './service/config.service';

@NgModule({
    declarations: [
    ],
    imports: [
        CommonModule,
        HttpClientModule
    ],
    providers: [
        AuthService,
        HttpErrorHandler,
        MessageService,
        // ConfigService
        //httpInterceptorProviders
    ]
})
export class CoreModule {
    /* make sure CoreModule is imported only by one NgModule the AppModule */
//    constructor(
//        @Optional() @SkipSelf() parentModule: CoreModule
//    ) {
//        if (parentModule) {
//            throw new Error('CoreModule is already loaded. Import only in AppModule');
 }
