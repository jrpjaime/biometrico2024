
import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Router, NavigationExtras } from '@angular/router';
import { Testlifecredencial } from '../model/testlifecredencial';
import { TestlifecredencialService } from '../service/testlifecredencial.service';
import { TestlifecredencialComponent } from './testlifecredencial.component';
import { ModalService } from 'src/app/shared/service/modal.service';
import { NAV } from 'src/app/global/navigation';
import { AuthService } from 'src/app/core/service/auth.service';
import { AlertService } from 'src/app/shared/service/alert.service';
import { FormsModule } from '@angular/forms';
import { NgxSpinnerService } from 'ngx-spinner';


@Component({
  selector: 'app-listatestlifecredencial',
  templateUrl: './listatestlifecredencial.component.html',
  styleUrls: ['./listatestlifecredencial.component.css']
})
export class ListatestlifecredencialComponent implements OnInit {

  @Output() vacio = new EventEmitter<boolean>();
  @Output() deleteTestlifecredencialEventEmitter = new EventEmitter<Testlifecredencial>();

	get nav() { return NAV; }

  testlifecredencials: Array<Testlifecredencial> = [];



  @Input() cveIdUsuario!: string;



  isAdmin = false;
  page: number=0;
  seleccionapagina: number=1;
  size: number=10;
  order: string='cveIdMedioTestlifecredencial';
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
    private testlifecredencialService: TestlifecredencialService,
    private testlifecredencialComponent: TestlifecredencialComponent,
    private modalService: ModalService,
    private auth: AuthService,
    private  alertService: AlertService,
    private ngxSpinner: NgxSpinnerService,
  ) {

  }

  ngOnInit() {
    console.log("ListatestlifecredencialComponent ngOnInit");

    console.log("cveIdUsuario: "+this.cveIdUsuario);
       this.cargarListTestlifecredencial( this.cveIdUsuario );
  }


  ngAfterViewInit() {
   // this.cargarListTestlifecredencial(this.numLote, this.cveIdUsuario, this.cveIdSubdelegacion, this.fechaInicioMovimiento, this.fechaFinalMovimiento);
  }




cargarListTestlifecredencial(cveIdUsuario:string): void {
  console.log("cargarListTestlifecredencial");
  console.log("cveIdUsuario:" + cveIdUsuario);




  }



  sortPage(): void{
    this.asc=!this.asc;
    this.cargarListTestlifecredencial(this.cveIdUsuario);
  }

  rewindPage(): void{
    if(!this.isFirst){
      this.page--;
      this.cargarListTestlifecredencial(this.cveIdUsuario);
    }
  }

  forwardPage(): void{
    if(!this.isLast){
      this.page++;
      this.cargarListTestlifecredencial(this.cveIdUsuario);
    }
  }

  setPage(page: number){
    this.page=page;
    this.cargarListTestlifecredencial(this.cveIdUsuario);
  }

  setOrder(order: string){
    this.order=order;
    this.cargarListTestlifecredencial(this.cveIdUsuario);
  }

  setSize( ){
    this.size=this.sizeManual;
    this.cargarListTestlifecredencial(this.cveIdUsuario);
  }

  setSizeCombo( ){
    this.page=0;
    this.paginaAll=false;
    const checkbox = document.getElementById('paginaAll',) as HTMLInputElement | null;
    if (checkbox != null) {
      checkbox.checked = false;
    }


    this.cargarListTestlifecredencial(this.cveIdUsuario);
  }

  onCheckboxChange(event: any) {
    this.page=0;
    if (event.target.checked) {
      this.size=this.totalElements;
      this.cargarListTestlifecredencial(this.cveIdUsuario);
    } else {
      this.size=this.sizeManual
      this.cargarListTestlifecredencial(this.cveIdUsuario);
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




  }
