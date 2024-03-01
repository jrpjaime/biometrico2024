import { Component } from '@angular/core';
import { NgxSpinnerService } from 'ngx-spinner';
import { AlertService } from './shared/service/alert.service';

@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: ['./app.component.css']
})
export class AppComponent {
	title = 'saiia-web';

	constructor(
		private alertService: AlertService,
		public spinner: NgxSpinnerService) { }

	ngOnInit() {
/*
    let script =document.createElement("script");
    script.src="https://framework-gb.cdn.gob.mx/gobmx.js";
    let body=document.getElementsByTagName("body")[0];
    body.appendChild(script);
*/

		this.spinner.show();
		setTimeout(() => {
			this.spinner.hide();
		}, 500);
	}



}
