import { Component, OnInit, ViewChild, Renderer2 } from '@angular/core';
import { Router, NavigationExtras } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Validador } from './../../../shared/app/validator/validator';
import { formatDate } from '@angular/common';
import { first } from 'rxjs/operators';
import { NgxSpinnerService } from 'ngx-spinner';
import { AlertService } from 'src/app/shared/service/alert.service';
import { ValidarcredencialService } from '../service/validarcredencial.service';
import { AuthService } from 'src/app/core/service/auth.service';
import { NAV } from 'src/app/global/navigation';


import { ModalService } from 'src/app/shared/service/modal.service';
import { Filtro } from 'src/app/core/model/filtro';
import { Validarcredencial } from '../model/validarcredencial';
import { LoginUsuario } from 'src/app/core/model/loginUsuario';


import {WebcamImage, WebcamInitError, WebcamUtil} from 'ngx-webcam';
import {Subject, Observable} from 'rxjs';
import { Testlifecredencial } from '../../testlifecredencial/model/testlifecredencial';

@Component({
	selector: 'app-validarcredencial',
	templateUrl: './validarcredencial.component.html',
	styleUrls: ['./validarcredencial.component.css']
})
export class ValidarcredencialComponent   implements OnInit {

  constructor(
		private formBuilder: FormBuilder,
    private router: Router,
    private ngxSpinner: NgxSpinnerService,
    private validarcredencialService: ValidarcredencialService,
		public alertService: AlertService,
    private modalService: ModalService,
    private renderer: Renderer2,
    private auth: AuthService
	) {



  }

	formFiltroValidarcredencialMov!: FormGroup;

  testlifecredencial= new Testlifecredencial() ;


  auditTrailImage: string="";

  isBuscar: boolean =false;
  isLimpiar: boolean =false;

  get nav() { return NAV; }

  cveIdDelegacion: number;

  isEstructurafecMovimientoIniValid: boolean =true;
  mensajeFecMovimientoIni: string;

  isEstructurafecMovimientoFinValid: boolean =true;
  mensajeFecMovimientoFin: string;


  isEstructurafecPresentacionIniValid: boolean =true;
  mensajeFecPresentacionIni: string;

  isEstructurafecPresentacionFinValid: boolean =true;
  mensajeFecPresentacionFin: string;

  imagenAnverso: string;
  imagenReverso: string;

  isfechaInicioMovimientoValid: boolean =false;
  isfechaFinalMovimientoValid: boolean =false;
  mensaje1: string="";
  mensaje2: string="";
  isValido: boolean =false;
  terminoCaptura: boolean =false;

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



  fecMovimientoIni!: string;
  fecMovimientoFin!: string;
  fecPresentacionIni!: string;
  fecPresentacionFin!: string;


  resultado?: string;


  capturoAnverso: boolean =false;
  capturoReverso: boolean =false;



   // toggle webcam on/off
   public showWebcam = true;
   public allowCameraSwitch = true;
   public multipleWebcamsAvailable = false;
   public deviceId: string;
   public videoOptions: MediaTrackConstraints = {
     // width: {ideal: 1024},
     // height: {ideal: 576}
   };
   public errors: WebcamInitError[] = [];

   // latest snapshot
   public webcamImage: WebcamImage = null;

   // webcam snapshot trigger
   private trigger: Subject<void> = new Subject<void>();
   // switch to next / previous / specific webcam; true/false: forward/backwards, string: deviceId
   private nextWebcam: Subject<boolean|string> = new Subject<boolean|string>();


   public triggerSnapshot(): void {
    this.trigger.next();





  }


  public triggerSnapshotFrente(): void {
    this.trigger.next();

      this.imagenAnverso=this.webcamImage.imageAsBase64;
      this.capturoAnverso=true;
      this.resultado="Captura el reverso de tu credencial de elector";
  }

  public eliminarFrente(): void {


      this.imagenAnverso="";
      this.capturoAnverso=false;
      this.resultado="Captura el frente de tu credencial de elector";
  }


  public triggerSnapshotReverso(): void {
    this.trigger.next();

      this.imagenReverso=this.webcamImage.imageAsBase64;
      this.capturoReverso=true;

      this.resultado="";

  }

  public eliminarReverso(): void {


    this.imagenReverso="";
    this.capturoReverso=false;
    if(this.capturoAnverso){
      this.resultado="Captura el reverso de tu credencial de elector";
    }else{
      this.resultado="Captura el frente de tu credencial de elector";
    }

}



  public toggleWebcam(): void {
    this.showWebcam = !this.showWebcam;
  }

  public handleInitError(error: WebcamInitError): void {
    this.errors.push(error);
  }

  public showNextWebcam(directionOrDeviceId: boolean|string): void {
    // true => move forward through devices
    // false => move backwards through devices
    // string => move to device with given deviceId
    this.nextWebcam.next(directionOrDeviceId);
  }

  public handleImage(webcamImage: WebcamImage): void {
    console.info('received webcam image', webcamImage);
    this.webcamImage = webcamImage;
  }

  public cameraWasSwitched(deviceId: string): void {
    console.log('active device: ' + deviceId);
    this.deviceId = deviceId;
  }

  public get triggerObservable(): Observable<void> {
    return this.trigger.asObservable();
  }

  public get nextWebcamObservable(): Observable<boolean|string> {
    return this.nextWebcam.asObservable();
  }




	onSubmit() {


    console.log("this.onSubmit: ");

    console.log("this.webcamImage: "+ this.webcamImage.imageAsBase64);

    let loginUsuario=new  LoginUsuario();





    loginUsuario.nombreUsuario=this.nombreUsuario;
    loginUsuario.password="";
    loginUsuario.rfc=this.rfc;

    loginUsuario.origen="3";
    loginUsuario.imagen=this.imagenAnverso;
    loginUsuario.imagenreverso=this.imagenReverso;

    this.validarcredencialService.registrarCredencial(loginUsuario).subscribe({
      next: (data: any) => {
        console.log("ejecuto registrarCredencial ");
        console.log("mensaje "+ data.mensaje);
        console.log("resultado "+ data.resultado);

        this.resultado= data.resultado;

        if(data.codigo==0){
          console.log("mensaje "+ data.mensaje);
          console.log("resultado "+ data.resultado);

          this.testlifecredencial=data;
          this.terminoCaptura=true;

          console.log("this.testlifecredencial.claveElector: "+this.testlifecredencial.claveElector);

        }else{
          console.log("mensaje "+ data.mensaje);
          console.log("resultado "+ data.resultado);
        }
      },
      error: (err: Error) => {

      },
      complete:() => {
      }
    });

  }


 ngOnInit(): void {



  this.resultado="Captura el frente de tu credencial de elector";




const userSession = this.auth.getUserSession();


console.log("ngOnInit ");


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

WebcamUtil.getAvailableVideoInputs()
.then((mediaDevices: MediaDeviceInfo[]) => {
  this.multipleWebcamsAvailable = mediaDevices && mediaDevices.length > 1;
});








}











ngAfterViewInit():void {
  let script = this.renderer.createElement('script');
  script.type = 'text/javascript';
  script.text = `
      $(function() {

		        $('#datepicker8').datepicker({
          dateFormat: "dd/mm/yy",
          monthNames: ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"],
          dayNamesMin: ["DOM", "LUN", "MAR", "MIE", "JUE", "VIE", "SÁB"]
        });
		        $('#datepicker9').datepicker({
          dateFormat: "dd/mm/yy",
          monthNames: ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"],
          dayNamesMin: ["DOM", "LUN", "MAR", "MIE", "JUE", "VIE", "SÁB"]
        });

        $('#datepicker10').datepicker({
          dateFormat: "dd/mm/yy",
          monthNames: ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"],
          dayNamesMin: ["DOM", "LUN", "MAR", "MIE", "JUE", "VIE", "SÁB"]
        });

        $('#datepicker11').datepicker({
          dateFormat: "dd/mm/yy",
          monthNames: ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"],
          dayNamesMin: ["DOM", "LUN", "MAR", "MIE", "JUE", "VIE", "SÁB"]
        });

      } );
    `;
  document.body.appendChild(script);
}





























}

