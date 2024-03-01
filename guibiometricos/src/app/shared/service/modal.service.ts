import { Injectable, OnDestroy } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { ModalType } from '../model/modal-type.model';


@Injectable({
	providedIn: 'root'
})
export class ModalService {

	private listener$: Subject<any> = new Subject<void>();

	constructor() {
		this.listener$ = new Subject<ModalType>();
	}

	get _listener(): Observable<ModalType> {
		return this.listener$.asObservable();
	}

	showDialog(
		type: string = "info",
		title: string = "",
		message: string = "",
		callback: (any: boolean) => any = () => {},
		img: string = "",
		alerta: boolean = false
	) {
		let self = this;
		this.listener$.next({
			type: type, //info, confirm, tooltip
			title: title,
			text: message,
			imgSrc: img,
			confirm: function () {
				self.listener$.next(void 0);
				callback(true); },
			reject: function () {
				self.listener$.next(void 0);
				callback(false); },
			dismiss: function () {
				self.listener$.next(void 0);
			},
			alerta
		});
	}



}
