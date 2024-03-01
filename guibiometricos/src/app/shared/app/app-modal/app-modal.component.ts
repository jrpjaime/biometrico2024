import { Component, OnInit } from '@angular/core';
import { ModalType } from '../../model/modal-type.model';
import { ModalService } from '../../service/modal.service';

@Component({
   selector: 'app-modal',
   templateUrl: './app-modal.component.html',
   styleUrls: ['./app-modal.component.css']
})
export class AppModalComponent implements OnInit {

   modalType!: ModalType;

   constructor(private modalService : ModalService) { }

   ngOnInit(): void {
      this.modalService._listener.subscribe((modal:any) =>
         this.modalType = modal
      );
   }

}