import { Component, OnInit, ViewChild, Renderer2, ElementRef} from '@angular/core';
import { Router, NavigationExtras } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Validador } from './../../../shared/app/validator/validator';
import { formatDate } from '@angular/common';
import { first } from 'rxjs/operators';
import { NgxSpinnerService } from 'ngx-spinner';
import { AlertService } from 'src/app/shared/service/alert.service';
import { TestlifecredencialService } from '../service/testlifecredencial.service';
import { AuthService } from 'src/app/core/service/auth.service';
import { ListatestlifecredencialComponent } from './listatestlifecredencial.component';

import { NAV } from 'src/app/global/navigation';


import { ModalService } from 'src/app/shared/service/modal.service';
import { Testlifecredencial } from '../model/testlifecredencial';


@Component({
	selector: 'app-testlifecredencial',
	templateUrl: './testlifecredencial.component.html',
	styleUrls: ['./testlifecredencial.component.css']
})
export class TestlifecredencialComponent   implements OnInit {

  constructor(
		private formBuilder: FormBuilder,
    private router: Router,
    private ngxSpinner: NgxSpinnerService,
    private testlifecredencialService: TestlifecredencialService,
		public alertService: AlertService,
    private modalService: ModalService,
    private renderer: Renderer2,
    private auth: AuthService,
	) {
    this.buildFormAdministraciontestlifecredencial();

  }

	formFiltroTestlifecredencialMovimientoLote!: FormGroup;

  formAdministraciontestlifecredencial!: FormGroup;
  nuevoShowModal: boolean=false;
  mensajeModal?: string;

  editShowModal: boolean=false;
  deleteShowModal: boolean=false;


  testlifecredencial=new Testlifecredencial();


  @ViewChild('closeBtnNuevo') closeBtnNuevo: ElementRef;
  @ViewChild('closeBtnDelete') closeBtnDelete: ElementRef;



  @ViewChild(ListatestlifecredencialComponent) listatestlifecredencialComponent!: ListatestlifecredencialComponent;

  get nav() { return NAV; }


  cveIdMedioTestlifecredencial: string="";

  isBuscar: boolean =false;
  isLimpiar: boolean =false;
  isEstructuraFechaInicioMovimientoValid: boolean =true;
  isEstructuraFechaFinalMovimientoValid: boolean =true;
  mensajeFechaInicioMovimiento: string="";
  mensajeFechaFinalMovimiento: string="";

  isfechaInicioMovimientoValid: boolean =false;
  isfechaFinalMovimientoValid: boolean =false;
  mensaje1: string="";
  mensaje2: string="";
  isValido: boolean =false;
  terminoValidacion: boolean =false;


  auditTrailImage: string="";
  cveIdUsuario: string="";
  rfc: string="";
  curp: string="";
  nombreUsuario: string="";
  ciz!: number | undefined;
  cveIdSubdelegacion!: number | undefined;

	oCveDelegacion?: string;
	oCveSubdelegacion?: string;
  oDelegacion: string | undefined;
  oSubdelegacion: string | undefined;
  oRolSaiia: string | undefined;
  oNombre?: string;
	oPaterno?: string;
	oMaterno?: string;

  isEmptyListTestlifecredencial: boolean =false;
  muestraLista:boolean=false;

  numLote: string="";
  fechaInicioMovimiento!: string;
  fechaFinalMovimiento!: string;


  private buildFormAdministraciontestlifecredencial(){
    this.formAdministraciontestlifecredencial=this.formBuilder.group({
      desCorreoElectronico: [{value: '', disabled: false, },[Validators.required, Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")] ]

    })

  }

 ngOnInit(): void {

  this.terminoValidacion=false;
  let script =document.createElement("script");
  script.src="https://framework-gb.cdn.gob.mx/gobmx.js";
  let body=document.getElementsByTagName("body")[0];
  body.appendChild(script);


console.log("ngOnInit inicio testlifecredencial")


const userSession = this.auth.getUserSession();
if(userSession != null){
this.cveIdUsuario=userSession!.cveIdUsuario;
this.rfc=userSession!.rfc;

this.curp =userSession!.curp;
this.nombreUsuario =userSession!.nombreUsuario;
console.log("this.cveIdUsuario: "+ this.cveIdUsuario);
console.log("this.curp: "+ this.curp);
console.log("this.nombreUsuario: "+ this.nombreUsuario);
console.log("this.rfc: "+ this.rfc);
}


const userSessionLife = this.auth.getUserSessionLlife();
if(userSessionLife != null){
this.auditTrailImage=userSessionLife!.auditTrailImage;
console.log("this.auditTrailImage: "+ this.auditTrailImage);

let testlifecredencial=new Testlifecredencial();
testlifecredencial.fotoPruebaVida=this.auditTrailImage;
testlifecredencial.curp=this.curp;
testlifecredencial.cveIdUsuario=this.cveIdUsuario;
testlifecredencial.nombreUsuario=this.nombreUsuario;
testlifecredencial.rfc=this.rfc;

testlifecredencial.resultado="Procesando";

this.testlifecredencialService.validarCredencial(testlifecredencial).subscribe({
  next: (data: any) => {
    console.log("ejecuto validarCredencial ");
    console.log("data.claveElector "+ data.claveElector);


    this.testlifecredencial=data;
    if(this.testlifecredencial.estado==0){
      this.isValido=true;
    }else{
      this.isValido=false;
    }
    this.terminoValidacion=true;

    console.log("this.testlifecredencial.claveElector: "+ this.testlifecredencial.claveElector);
    console.log("this.testlifecredencial.resultado: "+ this.testlifecredencial.resultado);

  },
  error: (err: Error) => {

  },
  complete:() => {
  }
});



}


}






get fechaInicioMovimientoField(){
	return this.formFiltroTestlifecredencialMovimientoLote?.get('fechaInicioMovimiento');
}


get fechaFinalMovimientoField(){
	return this.formFiltroTestlifecredencialMovimientoLote?.get('fechaFinalMovimiento');
}





onchangeNumLote(){
  this.muestraLista=false;
  console.log("onchangeNumLote muestraLista: "+ this.muestraLista);
}









onNuevoTestlifecredencial(){

  console.log("onNuevoTestlifecredencial");
  this.formAdministraciontestlifecredencial.controls['desCorreoElectronico'].enable();
  this.formAdministraciontestlifecredencial.controls['desCorreoElectronico'].setValue('');

  this.nuevoShowModal=true;
  this.mensajeModal="";
}


get desCorreoElectronicoField(){
	return this.formAdministraciontestlifecredencial?.get('desCorreoElectronico');
}
















}

