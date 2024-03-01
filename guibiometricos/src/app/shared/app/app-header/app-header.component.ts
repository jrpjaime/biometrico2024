import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserSession } from 'src/app/core/model/user.session';
import { AuthService } from 'src/app/core/service/auth.service';
import { NAV } from 'src/app/global/navigation';
import { AlertService } from '../../service/alert.service';

@Component({
	selector: 'app-header',
	templateUrl: './app-header.component.html',
	styleUrls: ['./app-header.component.css']
})
export class AppHeaderComponent implements OnInit {

	//userSession!: UserSession;
	@Input() title!: string;

	constructor(
		public router: Router,
		private actRoute: ActivatedRoute,
		private authService: AuthService,
		private alertService: AlertService
	) { }

	ngOnInit(): void {
	}

	get userSession() {
		return this.authService.getUserSession();
	}

	onExit() {

		this.authService.logout();
		this.router.navigate([NAV.login]);
		//this.alertService.success ( "Su sesión ha finalizado satisfactoriamente" );

	 }

}
