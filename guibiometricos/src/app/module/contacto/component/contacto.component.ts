import { Component, OnInit, ViewChild, Renderer2, ElementRef} from '@angular/core';
import { Router, NavigationExtras } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Validador } from './../../../shared/app/validator/validator';
import { formatDate } from '@angular/common';
import { first } from 'rxjs/operators';
import { NgxSpinnerService } from 'ngx-spinner';
import { AlertService } from 'src/app/shared/service/alert.service';
import { ContactoService } from '../service/contacto.service';
import { AuthService } from 'src/app/core/service/auth.service';
import { ListacontactoComponent } from './listacontacto.component';

import { NAV } from 'src/app/global/navigation';


import { ModalService } from 'src/app/shared/service/modal.service';
import { Contacto } from '../model/contacto';


@Component({
	selector: 'app-contacto',
	templateUrl: './contacto.component.html',
	styleUrls: ['./contacto.component.css']
})
export class ContactoComponent   implements OnInit {

  constructor(
		private formBuilder: FormBuilder,
    private router: Router,
    private ngxSpinner: NgxSpinnerService,
    private contactoService: ContactoService,
		public alertService: AlertService,
    private modalService: ModalService,
    private renderer: Renderer2,
    private auth: AuthService,
	) {
    this.buildFormAdministracioncontacto();

  }

	formFiltroContactoMovimientoLote!: FormGroup;

  formAdministracioncontacto!: FormGroup;
  nuevoShowModal: boolean=false;
  mensajeModal?: string;

  editShowModal: boolean=false;
  deleteShowModal: boolean=false;


  @ViewChild('closeBtnNuevo') closeBtnNuevo: ElementRef;
  @ViewChild('closeBtnDelete') closeBtnDelete: ElementRef;



  @ViewChild(ListacontactoComponent) listacontactoComponent!: ListacontactoComponent;

  get nav() { return NAV; }


  cveIdMedioContacto: string="";

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

  isEmptyListContacto: boolean =false;
  muestraLista:boolean=false;

  numLote: string="";
  fechaInicioMovimiento!: string;
  fechaFinalMovimiento!: string;


  private buildFormAdministracioncontacto(){
    this.formAdministracioncontacto=this.formBuilder.group({
      desCorreoElectronico: [{value: '', disabled: false, },[Validators.required, Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")] ]

    })

  }

 ngOnInit(): void {

  let script =document.createElement("script");
  script.src="https://framework-gb.cdn.gob.mx/gobmx.js";
  let body=document.getElementsByTagName("body")[0];
  body.appendChild(script);

console.log("ngOnInit inicio contacto")


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

}






get fechaInicioMovimientoField(){
	return this.formFiltroContactoMovimientoLote?.get('fechaInicioMovimiento');
}


get fechaFinalMovimientoField(){
	return this.formFiltroContactoMovimientoLote?.get('fechaFinalMovimiento');
}





onchangeNumLote(){
  this.muestraLista=false;
  console.log("onchangeNumLote muestraLista: "+ this.muestraLista);
}


openDeleteContacto(contacto: Contacto){

  console.log("onDeleteContacto "+ contacto.cveIdMedioContacto);
  this.cveIdMedioContacto=contacto.cveIdMedioContacto;
  this.formAdministracioncontacto.controls['desCorreoElectronico'].setValue(contacto.desCorreoElectronico);
  this.formAdministracioncontacto.controls['desCorreoElectronico'].disable();
  this.deleteShowModal=true;
  this.mensajeModal="";
}



onDeleteContacto(){
    //this.crearDatepicker();
    console.log("onCreateContacto");
    this.ngxSpinner.show();

    let contacto=new Contacto();
    console.log("this.cveIdUsuario: "+ this.cveIdUsuario);
    console.log("this.rfc: "+ this.rfc);
    console.log("this.cveIdMedioContacto: "+ this.cveIdMedioContacto);
    contacto.cveIdMedioContacto= this.cveIdMedioContacto;

    contacto.cveIdUsuario=this.cveIdUsuario;
    contacto.rfc=this.rfc;
    this.nuevoShowModal=true;

    this.contactoService.deleteContacto(contacto).subscribe({

      next: (data: any) => {
        console.log("data.codigo: "+data.codigo);
        console.log("data.mensaje: "+data.mensaje);
        if(data.codigo==1){
          this.alertService.success("Medio de contacto eliminado correctamente.");
          this.closeBtnDelete.nativeElement.click();
          this.nuevoShowModal=false;
          this.listacontactoComponent.cargarListContacto(this.cveIdUsuario);
          this.ngxSpinner.hide();
        }else{
          //this.alertService.error("Error al agregar el día inhábil. " + data.mensaje);
          this.closeBtnDelete.nativeElement.click();
          this.nuevoShowModal=false;
          this.alertService.error(data.mensaje);
        //  this.mensajeModal=  data.mensaje;
          this.ngxSpinner.hide();
        }

      },
      error: (err: Error) => {
        this.closeBtnNuevo.nativeElement.click();
        this.nuevoShowModal=false;
        this.ngxSpinner.hide();
        this.alertService.error("Error al regisrtrar el medio de contacto. " );
      },
      complete:() => {
        this.ngxSpinner.hide();
      }
    });


  }

onEditContacto(){

  console.log("onEditContacto");

  this.formAdministracioncontacto.controls['desCorreoElectronico'].setValue('');

  this.editShowModal=true;
  this.mensajeModal="";
}




onNuevoContacto(){

  console.log("onNuevoContacto");
  this.formAdministracioncontacto.controls['desCorreoElectronico'].enable();
  this.formAdministracioncontacto.controls['desCorreoElectronico'].setValue('');

  this.nuevoShowModal=true;
  this.mensajeModal="";
}


get desCorreoElectronicoField(){
	return this.formAdministracioncontacto?.get('desCorreoElectronico');
}

onCreateContacto(){
  //this.crearDatepicker();
  console.log("onCreateContacto");
  this.ngxSpinner.show();
 let desCorreoElectronico=  this.desCorreoElectronicoField.value;
 console.log("desCorreoElectronico: "+desCorreoElectronico);
  let contacto=new Contacto();

  console.log("this.cveIdUsuario: "+ this.cveIdUsuario);

console.log("this.rfc: "+ this.rfc);

  contacto.desCorreoElectronico=desCorreoElectronico;
  contacto.cveIdUsuario=this.cveIdUsuario;
  contacto.rfc=this.rfc;
  contacto.nombreUsuario=this.nombreUsuario;
  contacto.curp=this.curp;
  this.nuevoShowModal=true;

  console.log("this.curp: "+this.curp);
  console.log("this.nombreUsuario: "+this.nombreUsuario);
  console.log("this.rfc: "+this.rfc);

  this.contactoService.createContacto(contacto).subscribe({

    next: (data: any) => {
      console.log("data.codigo: "+data.codigo);
      console.log("data.mensaje: "+data.mensaje);
      if(data.codigo==1){
        this.alertService.success("Medio de contacto agregado correctamente.");
        this.closeBtnNuevo.nativeElement.click();
        this.nuevoShowModal=false;
        this.listacontactoComponent.cargarListContacto(this.cveIdUsuario);
        this.ngxSpinner.hide();
      }else{
        //this.alertService.error("Error al agregar el día inhábil. " + data.mensaje);
        this.closeBtnNuevo.nativeElement.click();
        this.nuevoShowModal=false;
        this.alertService.error(data.mensaje);
      //  this.mensajeModal=  data.mensaje;
        this.ngxSpinner.hide();
      }

    },
    error: (err: Error) => {
      this.closeBtnNuevo.nativeElement.click();
      this.nuevoShowModal=false;
      this.ngxSpinner.hide();
      this.alertService.error("Error al regisrtrar el medio de contacto. " );
    },
    complete:() => {
      this.ngxSpinner.hide();
    }
  });


}



 tieneContacto(isEmpty :boolean){
  this.isEmptyListContacto=isEmpty;
  if(isEmpty && !this.isLimpiar){
    this.isBuscar=true;
  }else{
    this.isBuscar=false;
  }
}











}

