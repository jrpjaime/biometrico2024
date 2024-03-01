import { NAV } from './navigation';
import { Routes } from '@angular/router';

import { LoginComponent } from '../module/identity/login/login.component';
import { LoginfielComponent } from '../module/identity/loginfiel/loginfiel.component';
import { LogincurpComponent } from '../module/identity/logincurp/logincurp.component';
import { LogincredencialComponent } from '../module/identity/logincredencial/logincredencial.component';
import { AuthGuard } from '../core/helper/auth.guard';
import { ValidarcontactoComponent } from '../module/validarcontacto/validarcontacto/validarcontacto.component';
import { LoginpruebavidaComponent } from '../module/identity/loginpruebavida/loginpruebavida.component';




export const appRoutes: Routes = [
    {
        path: NAV.login,
        pathMatch: 'full',
        component: LoginComponent
    },
    {
      path: NAV.loginfiel,
      pathMatch: 'full',
      component: LoginfielComponent
    },


    {
      path: NAV.loginpruebavida,
      pathMatch: 'full',
      component: LoginpruebavidaComponent
    },
    {
      path: NAV.logincurp,
      pathMatch: 'full',
      component: LogincurpComponent
    },
   {
    path: NAV.logincredencial,
    pathMatch: 'full',
    component: LogincredencialComponent
    },
     {
        path: '',
        pathMatch: 'full',
        redirectTo: NAV.login,
    }, {
      path: NAV.validarContacto,
      pathMatch: 'full',
      component: ValidarcontactoComponent
    }, {
        path: '',
        canActivate: [AuthGuard],
        children: [{
            path: NAV.home,
            loadChildren: () => import('src/app/module/home/home.module').then(m => m.HomeModule)
        },
        {
          path: NAV.contacto,
          loadChildren: () => import('src/app/module/contacto/contacto.module').then(m => m.ContactoModule)
        },

        {
          path: NAV.validacionCredencial,
          loadChildren: () => import('src/app/module/testlifecredencial/testlifecredencial.module').then(m => m.TestlifecredencialModule)
        },

        {
          path: NAV.validarcredencial,
          loadChildren: () => import('src/app/module/validarcredencial/validarcredencial.module').then(m => m.ValidarcredencialModule)
        },

        {
          path: NAV.test,
          loadChildren: () => import('src/app/module/testlife/testlife.module').then(m => m.TestlifeModule)
        }



      ]
    }, {
        path: '**',
        redirectTo: NAV.login
    }






];
