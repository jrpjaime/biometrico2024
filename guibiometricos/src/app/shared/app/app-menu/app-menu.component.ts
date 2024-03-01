import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { AuthService } from 'src/app/core/service/auth.service';
import { NAV } from 'src/app/global/navigation';



@Component({
	selector: 'app-menu',
	templateUrl: './app-menu.component.html',
	styleUrls: ['./app-menu.component.css']
})
export class AppMenuComponent implements OnInit {

	constructor(
		public router: Router,
		private actRoute: ActivatedRoute,
		private authService: AuthService,
		private auth: AuthService
	) {
	 }


	 cveIdUsuario: string="";
	 ciz!: number | undefined;
	 cveIdSubdelegacion!: number | undefined;

	 movimientoIndividual!: boolean;
	 movimientoLote!: boolean;
	 movimientoRetroalimentacion!: boolean;
	 autorizacion!: boolean;
	 consultaLote!: boolean;
	 consultaDiasInhabiles!: boolean;
	 consultaProcesados!: boolean;
	 consultaAdministracionInhabiles!: boolean;
	 consultaBitacoraPersonal!: boolean;


	ngOnInit() {
		const userSession = this.auth.getUserSession();

		if (userSession) {
			this.cveIdUsuario = userSession!.curp;
			this.ciz = userSession!.oCiz;
			this.cveIdSubdelegacion = userSession!.oIdSubdelegacion;

			this.movimientoIndividual = userSession!.movimientoIndividual;
			this.movimientoLote = userSession!.movimientoLote;
			this.movimientoRetroalimentacion = userSession!.movimientoRetroalimentacion;
			this.autorizacion = userSession!.autorizacion;
			this.consultaLote = userSession!.consultaLote;
			this.consultaDiasInhabiles = userSession!.consultaDiasInhabiles;
			this.consultaProcesados = userSession!.consultaProcesados;
			this.consultaAdministracionInhabiles = userSession!.consultaAdministracionInhabiles;
			this.consultaBitacoraPersonal = userSession!.consultaBitacoraPersonal;
		}
	}

	get userSession() {
		return this.authService.getUserSession();
	}


	get movimientoIndividualMenu() {
		return this.authService.getUserSession()?.movimientoIndividual;
	}

	get movimientoLoteMenu() {
		return this.authService.getUserSession()?.movimientoLote;
	}
	get movimientoRetroalimentacionMenu() {
		return this.authService.getUserSession()?.movimientoRetroalimentacion;
	}
	get autorizacionMenu() {
		return this.authService.getUserSession()?.autorizacion;
	}
	get consultaLoteMenu() {
		return this.authService.getUserSession()?.consultaLote;
	}
	get consultaDiasInhabilesMenu() {
		return this.authService.getUserSession()?.consultaDiasInhabiles;
	}
	get consultaProcesadosMenu() {
		return this.authService.getUserSession()?.consultaProcesados;
	}
	get consultaAdministracionInhabilesMenu() {
		return this.authService.getUserSession()?.consultaAdministracionInhabiles;
	}
	get consultaBitacoraPersonalMenu() {
		return this.authService.getUserSession()?.consultaBitacoraPersonal;
	}

	get nav() { return NAV; }


	/* onExit() {

		this.authService.logout();
		this.router.navigate([NAV.login]);
		this.alertService.success ( "Su sesión ha finalizado satisfactoriamente" );

	} */


  lifeTests(){

   // this.router.navigate(["/pruebavida"]);
   /// window.location.reload();

    window.location.replace("http://localhost:4200/test/life");
  }




  lifeTests2(){

    // this.router.navigate(["/pruebavida"]);
    /// window.location.reload();

     window.location.replace("http://localhost/sample-apps/sample-app-js");
   }




   validaCredencial(){

    this.router.navigate(["/validacredencial"]);
    window.location.reload();

   }



}
