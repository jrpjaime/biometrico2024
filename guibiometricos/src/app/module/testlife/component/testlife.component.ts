import { Component, OnInit, ViewChild, Renderer2, ElementRef} from '@angular/core';
import { Router, NavigationExtras } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Validador } from './../../../shared/app/validator/validator';
import { formatDate } from '@angular/common';
import { first } from 'rxjs/operators';
import { NgxSpinnerService } from 'ngx-spinner';
import { AlertService } from 'src/app/shared/service/alert.service';
import { TestlifeService } from '../service/testlife.service';
import { AuthService } from 'src/app/core/service/auth.service';

import { NAV } from 'src/app/global/navigation';
import { AngularSampleApp } from "../../../../assets/angular-sample-controller";

import { ModalService } from 'src/app/shared/service/modal.service';
import { LoginUsuario } from 'src/app/core/model/loginUsuario';




@Component({
	selector: 'app-contacto',
	templateUrl: './testlife.component.html',
	styleUrls: ['./testlife.component.css']
})
export class TestlifeComponent   implements OnInit {

  constructor(
		private formBuilder: FormBuilder,
    private router: Router,
    private ngxSpinner: NgxSpinnerService,
    private testlifeService: TestlifeService,
		public alertService: AlertService,
    private modalService: ModalService,
    private renderer: Renderer2,
    private auth: AuthService,
	) {


  }


  isValido: boolean =false;


  rfc: string="";
  curp: string="";
  nombreUsuario: string="";

  cveIdUsuario: string="";
  ciz!: number | undefined;
  cveIdSubdelegacionSesion!: number | undefined;
  cveIdDelegacionSesion!: number | undefined;

	oCveDelegacion?: string;
	oCveSubdelegacion?: string;
  oDelegacion: string | undefined;
  oSubdelegacion: string | undefined;
  oRolSaiia: string | undefined;
  oNombre?: string;
	oPaterno?: string;
	oMaterno?: string;

  isEmptyListValidarcredencial: boolean =false;

  numLote: number = 0;
  fechaInicioMovimiento!: string;
  fechaFinalMovimiento!: string;

  cveIdTipoUsuario!: number;
  refCurp!: string;
  cveRegpatron!: string;
  numNss!: string;
  fecMovimiento!: string;
  fecPresentacion!: string;
  //cveIdDelegacionFilter!: string;
  cveIdSubdelegacion!: number;






 ngOnInit(): void {
console.log("ngOnInit inicio  ")
const userSession = this.auth.getUserSession();
if(userSession != null){
  this.cveIdUsuario=userSession!.curp;

  this.rfc=userSession!.rfc;

  this.curp =userSession!.curp;
  this.nombreUsuario =userSession!.nombreUsuario;

  this.ciz=userSession!.oCiz;
  this.cveIdSubdelegacionSesion=userSession!.oIdSubdelegacion;
  this.cveIdDelegacionSesion=userSession!.oIdDelegacion;

  this.oDelegacion=userSession!.oDelegacion;
  this.oSubdelegacion=userSession!.oSubdelegacion;
  this.oRolSaiia=userSession!.oRolSaiia;
  console.log("this.oRolSaiia "+ this.oRolSaiia);
  console.log("this.cveIdSubdelegacionSesion "+ this.cveIdSubdelegacionSesion);



  this.oCveDelegacion=userSession!.oCveDelegacion;
  this.oCveSubdelegacion=userSession!.oCveSubdelegacion;

  this.oNombre=userSession!.oNombre;
  this.oPaterno=userSession!.oPaterno;
  this.oMaterno=userSession!.oMaterno;




  }





  let loginUsuario=new  LoginUsuario();





  loginUsuario.nombreUsuario=this.nombreUsuario;
  loginUsuario.password="";
  loginUsuario.rfc=this.rfc;

  loginUsuario.origen="3";


  this.testlifeService.verificaRegistroCredencial(loginUsuario).subscribe({
    next: (data: any) => {

    if(data.codigo==0){
      console.log("Resultado: "+ data.mensaje);
      this.isValido=true;
    }else{
      console.log("Resultado: "+ data.mensaje);
      this.isValido=false;
    }



    },
    error: (err: Error) => {

    },
    complete:() => {
    }
  });





/*

const userSessionLife = this.auth.getUserSessionLlife();
if(userSessionLife != null){

  console.log("userSessionLife!.isLive;"+ userSessionLife!.isLive);

  console.log("userSessionLife!.auditTrailImage;"+ userSessionLife!.auditTrailImage);








}else{
  console.log("debe realizar la prueba de vida;" );


}
*/



}



ngAfterViewInit(): void {
  console.log("ngAfterViewInit inicio  ")


  }






  // Perform Liveness Check.
  onLivenessCheckPressed() {

    AngularSampleApp.onLivenessCheckPressed();



  }



  get nav() { return NAV; }




  inicio(){



    // this.router.navigate(["/pruebavida"]);
    /// window.location.reload();

     window.location.replace("http://localhost:4200/home");
   }


}

