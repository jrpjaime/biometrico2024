import { Component, OnInit } from '@angular/core';
import { NAV } from 'src/app/global/navigation';
import { AuthService } from 'src/app/core/service/auth.service';
import { ContactoService } from '../../contacto/service/contacto.service';
import { Router, NavigationExtras } from '@angular/router';
import { AlertService } from 'src/app/shared/service/alert.service';
import { NgxSpinnerService } from 'ngx-spinner';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private authService: AuthService,
    private contactoService :ContactoService,
    public alertService: AlertService,
    private ngxSpinner: NgxSpinnerService,
    private router:Router) { }

    pruebavida: string="";

    cveIdUsuario: string="";
    rfc: string="";
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


	ngOnInit() {

    let script =document.createElement("script");
    script.src="https://framework-gb.cdn.gob.mx/gobmx.js";
    let body=document.getElementsByTagName("body")[0];
    body.appendChild(script);

console.log("home ngOnInit" );

this.ngxSpinner.show();
const userSession = this.authService.getUserSession();
if(userSession != null){
this.cveIdUsuario=userSession!.cveIdUsuario;
this.rfc=userSession!.rfc;
console.log("this.cveIdUsuario: "+ this.cveIdUsuario);

console.log("this.rfc: "+ this.rfc);
}

/*
console.log("sessionStorage.getItem(life): "+ sessionStorage.getItem("life"));
const pruebavida = sessionStorage.getItem("life");

console.log("pruebavida: "+ pruebavida);

this.pruebavida=pruebavida;

this.cargarListContactoAutorizado(this.cveIdUsuario);
*/



  }





cargarListContactoAutorizado(cveIdUsuario:string): void {
  console.log("cargarListContacto");
  console.log("cveIdUsuario:" + cveIdUsuario);


    this.contactoService.listContactoAutorizado(this.page,this.size,this.order,this.asc, cveIdUsuario).subscribe({

      next: (data: any) => {


        this.isEmpty=data.empty;
        this.totalPages=new Array(data['totalPages']);
        this.numeroPaginas=data.totalPages;
        this.totalElements=data.totalElements;
        this.numberOfElements=data.numberOfElements;
        this.isLast=data.last;
        console.log("isEmpty:"+ this.isEmpty);

        if(this.isEmpty){
          this.alertService.info("Registre y valide mínimo un medio de contacto.");
          this.router.navigate([NAV.loadContacto]);
        }

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



  get nav() { return NAV; }

  get userSession() {
    const userSession = this.authService.getUserSession();

    if (userSession != null) {
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

    return this.authService.getUserSession();
  }

}
