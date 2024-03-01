
import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Router, NavigationExtras } from '@angular/router';
import { Contacto } from '../model/contacto';
import { ContactoService } from '../service/contacto.service';
import { ContactoComponent } from './contacto.component';
import { ModalService } from 'src/app/shared/service/modal.service';
import { NAV } from 'src/app/global/navigation';
import { AuthService } from 'src/app/core/service/auth.service';
import { AlertService } from 'src/app/shared/service/alert.service';
import { FormsModule } from '@angular/forms';
import { NgxSpinnerService } from 'ngx-spinner';


@Component({
  selector: 'app-listacontacto',
  templateUrl: './listacontacto.component.html',
  styleUrls: ['./listacontacto.component.css']
})
export class ListacontactoComponent implements OnInit {

  @Output() vacio = new EventEmitter<boolean>();
  @Output() deleteContactoEventEmitter = new EventEmitter<Contacto>();

	get nav() { return NAV; }

  contactos: Array<Contacto> = [];



  @Input() cveIdUsuario!: string;



  isAdmin = false;
  page: number=0;
  seleccionapagina: number=1;
  size: number=10;
  order: string='cveIdMedioContacto';
  asc: boolean=true;
  paginaAll: boolean=false;

  numberOfElements!: number;



  isFirst=false;
  isLast=false;
  isEmpty=true;
  sizeManual: number=10;
  totalElements!:number;

  elementosPagina:number[]=[10,50,100,1000];

  totalPages: Array<number> = [];
  numeroPaginas: number=0;


  constructor(
    private router: Router,
    private contactoService: ContactoService,
    private contactoComponent: ContactoComponent,
    private modalService: ModalService,
    private auth: AuthService,
    private  alertService: AlertService,
    private ngxSpinner: NgxSpinnerService,
  ) {

  }

  ngOnInit() {
    console.log("ListacontactoComponent ngOnInit");

    console.log("cveIdUsuario: "+this.cveIdUsuario);
       this.cargarListContacto( this.cveIdUsuario );
  }


  ngAfterViewInit() {
   // this.cargarListContacto(this.numLote, this.cveIdUsuario, this.cveIdSubdelegacion, this.fechaInicioMovimiento, this.fechaFinalMovimiento);
  }




cargarListContacto(cveIdUsuario:string): void {
  console.log("cargarListContacto");
  console.log("cveIdUsuario:" + cveIdUsuario);


    this.contactoService.listContacto(this.page,this.size,this.order,this.asc, cveIdUsuario).subscribe({

      next: (data: any) => {
        console.log("this.contactoService.listContacto esVacio" + this.isEmpty);
        this.contactos = data.content;
        this.isFirst=data.first;
        this.isLast=data.last;
        this.isEmpty=data.empty;
        this.totalPages=new Array(data['totalPages']);
        this.numeroPaginas=data.totalPages;
        this.totalElements=data.totalElements;
        this.numberOfElements=data.numberOfElements;
        this.isLast=data.last;
        this.esVacio();
        this.ngxSpinner.hide();
      },
      error: (err: Error) => {
        this.ngxSpinner.hide();

      },
      complete:() => {
        this.ngxSpinner.hide();
      }
    });

  }



  sortPage(): void{
    this.asc=!this.asc;
    this.cargarListContacto(this.cveIdUsuario);
  }

  rewindPage(): void{
    if(!this.isFirst){
      this.page--;
      this.cargarListContacto(this.cveIdUsuario);
    }
  }

  forwardPage(): void{
    if(!this.isLast){
      this.page++;
      this.cargarListContacto(this.cveIdUsuario);
    }
  }

  setPage(page: number){
    this.page=page;
    this.cargarListContacto(this.cveIdUsuario);
  }

  setOrder(order: string){
    this.order=order;
    this.cargarListContacto(this.cveIdUsuario);
  }

  setSize( ){
    this.size=this.sizeManual;
    this.cargarListContacto(this.cveIdUsuario);
  }

  setSizeCombo( ){
    this.page=0;
    this.paginaAll=false;
    const checkbox = document.getElementById('paginaAll',) as HTMLInputElement | null;
    if (checkbox != null) {
      checkbox.checked = false;
    }


    this.cargarListContacto(this.cveIdUsuario);
  }

  onCheckboxChange(event: any) {
    this.page=0;
    if (event.target.checked) {
      this.size=this.totalElements;
      this.cargarListContacto(this.cveIdUsuario);
    } else {
      this.size=this.sizeManual
      this.cargarListContacto(this.cveIdUsuario);
    }
  }

  esVacio() {
    this.vacio.emit(this.isEmpty);
  }



  detalle(numLote:string) {
    const navigationExtras: NavigationExtras = {
      state: {
        numLote: numLote,
        cveIdUsuario: this.cveIdUsuario
      }
    };

  }


  deleteContacto(cveIdMedioContacto: string, desCorreoElectronico:string) {
    let contacto =new Contacto();
    contacto.cveIdMedioContacto=cveIdMedioContacto;
    contacto.desCorreoElectronico=desCorreoElectronico
    this.deleteContactoEventEmitter.emit(contacto);
  }

  }
