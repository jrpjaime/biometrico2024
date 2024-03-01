/* "Barrel" of Http Interceptors */
import { HTTP_INTERCEPTORS } from '@angular/common/http';

import { JwtInterceptor } from './http/jwt.interceptor';
import { CustomJsonInterceptor, CustomJsonParser, JsonParser } from './http/custom-json-interceptor';
import { EnsureHttpsInterceptor } from './http/ensure-https-interceptor';

/** Http interceptor providers in outside-in order */
export const httpInterceptorProviders = [
    { provide: HTTP_INTERCEPTORS, useClass: CustomJsonInterceptor, multi: true },
    { provide: JsonParser, useClass: CustomJsonParser },

    { provide: HTTP_INTERCEPTORS, useClass: EnsureHttpsInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },

];