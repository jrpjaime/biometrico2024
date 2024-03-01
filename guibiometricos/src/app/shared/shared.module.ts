import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppMenuComponent } from './app/app-menu/app-menu.component';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { AppDndComponent } from './app/app-dnd/app-dnd.component';
import { AppProgressComponent } from './app/app-progress/app-progress.component';
import { AlertComponent } from './app/alert/alert.component';
import { FileSizePipe } from './directive/file-size.pipe';
import { AppHeaderComponent } from './app/app-header/app-header.component';
import { AppModalComponent } from './app/app-modal/app-modal.component';

@NgModule({
	declarations: [
		AlertComponent,
		AppDndComponent,
		AppProgressComponent,
		AppMenuComponent,
		FileSizePipe,
  		AppHeaderComponent,
		AppModalComponent
	],
	imports: [
		FormsModule,
		CommonModule,
		RouterModule
	],
	exports: [
		AlertComponent,
		AppDndComponent,
		AppProgressComponent,
		AppMenuComponent,
		AppHeaderComponent,
		AppModalComponent,
		FileSizePipe
	],
})
export class SharedModule { }
