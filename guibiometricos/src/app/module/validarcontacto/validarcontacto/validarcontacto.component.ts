
import { Component, OnInit } from '@angular/core';
import { NAV } from 'src/app/global/navigation';
import { AuthService } from 'src/app/core/service/auth.service';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { NgxSpinnerService } from 'ngx-spinner';
import { AlertService } from 'src/app/shared/service/alert.service';
import { ValidarcontactoService } from '../service/validarcontacto.service';
import { Contacto } from 'src/app/module/contacto/model/contacto';

@Component({
  selector: 'app-validarcontacto',
  templateUrl: './validarcontacto.component.html',
  styleUrls: ['./validarcontacto.component.css']
})
export class ValidarcontactoComponent implements OnInit {
  code: string;
  constructor(
    private authService: AuthService,
    private ngxSpinner: NgxSpinnerService,
    public alertService: AlertService,
    public validarcontactoService:ValidarcontactoService,
    private router: Router

    ) {


      let urlTree = this.router.parseUrl(this.router.url);

      this.code = urlTree.queryParams['code'];
    }



  ngOnInit(): void {
console.log("validarcontacto ngOnInit code "+  this.code);
this.onValidarContacto();

  }

  get nav() { return NAV; }





  onValidarContacto(){
    //this.crearDatepicker();
    console.log("onValidarContacto");
    this.ngxSpinner.show();


    let contacto=new Contacto();

    console.log("this.code: "+ this.code);


    contacto.code=this.code;

    this.validarcontactoService.validarContacto(contacto).subscribe({

      next: (data: any) => {
        console.log("data.codigo: "+data.codigo);
        console.log("data.mensaje: "+data.mensaje);
        if(data.codigo==1){
          this.alertService.success("Medio de contacto agregado correctamente.");

          this.ngxSpinner.hide();
        }else{

          this.alertService.error(data.mensaje);
        //  this.mensajeModal=  data.mensaje;
          this.ngxSpinner.hide();
        }

      },
      error: (err: Error) => {

        this.ngxSpinner.hide();
        this.alertService.error("Error al regisrtrar el medio de contacto. " );
      },
      complete:() => {
        this.ngxSpinner.hide();
      }
    });


  }

	onExit() {

		this.authService.logout();
		this.router.navigate([NAV.login]);

	 }

}
