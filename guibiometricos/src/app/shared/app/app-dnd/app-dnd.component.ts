import { Component, ViewChild, ElementRef, Input, Output, EventEmitter } from '@angular/core';
//import { provideProtractorTestingSupport } from '@angular/platform-browser';

@Component({
  selector: 'app-dnd',
  templateUrl: './app-dnd.component.html',
  styleUrls: ['./app-dnd.component.css']
})
export class AppDndComponent {

    @ViewChild("fileDropRef", { static: false }) fileDropEl?: ElementRef;

    @Output() fileEventEmitter: EventEmitter<any[]> = new EventEmitter();
    @Output() fileEventEmitterDelete: EventEmitter<number> = new EventEmitter();
    @Output() finUpload = new EventEmitter<boolean>();
    @Input() fileType!: string;
    @Input() length!: number;
    @Input() size!: number;     // en bytes

    files: any[] = [];
    msg: string = '';



    /**
     * on file drop handler
     */
    onFileDropped($event: any) {
        this.prepareFilesList($event);
    }

    /**
     * handle file from browsing
     */
    fileBrowseHandler($event: any) {
 //       if ($event.target?.files) {
 //           this.prepareFilesList($event.target?.files);
 //       }
        this.prepareFilesList($event);
    }

    /**
     * Delete file from files list
     * @param index (File index)
     */
    deleteFile(index: number) {
        if (this.files[index].progress < 100) {
            return;
        }
        this.files.splice(index, 1);
        this.fileEventEmitterDelete.emit ( index );
    }

    /**
     * Simulate the upload process
     */
    uploadFilesSimulator(index: number) {
        setTimeout(() => {
            if (index === this.files.length) {
                return;
            } else {
                const progressInterval = setInterval(() => {
                  if (this.files[index].progress === 100) {
                      this.finUpload.emit(true);
                      clearInterval(progressInterval);
                      this.uploadFilesSimulator(index + 1);
                  } else {

                      this.files[index].progress += 10;
                  }
                }, 200);
            }
        }, 1000);
    }

    /**
     * Convert Files list to normal array list
     * @param files (Files List)
     */
    prepareFilesList(files: Array<any>) {
        this.msg = '';
        if ( this.files.length < this.length && files.length < this.length+1 ) {
            const lengBefore : number = this.files.length;
            for (const item of files) {
                 if ( item.name.toLowerCase().endsWith ( this.fileType ) ) {

                    if (item.size <= this.size) {
                        item.progress = 0;
                        this.files.push(item);
                    } else {
                        this.msg = "Tamaño excedente, el tamaño del archivo no puede exceder 8MB, el proceso se abortará.";
                    }
                 } else {
                    this.msg = "Archivo incorrecto, la extensión del archivo debe ser ‘.txt’, el proceso se abortará.";
                 }
            }
            if ( lengBefore < this.files.length ) {
                if ( this.fileDropEl !== undefined ) {
                    this.fileDropEl.nativeElement.value = "";
                }
                this.uploadFilesSimulator(0);
                this.fileEventEmitter.emit ( this.files );
            }
        }
    }

    /**
     * format bytes
     * @param bytes (File size in bytes)
     * @param decimals (Decimals point)
     */
    formatBytes(bytes: number, decimals = 2) {
        if (bytes === 0) {
            return "0 Bytes";
        }
        const k = 1024;
        const dm = decimals <= 0 ? 0 : decimals;
        const sizes = ["Bytes", "KB", "MB", "GB", "TB", "PB", "EB", "ZB", "YB"];
        const i = Math.floor(Math.log(bytes) / Math.log(k));
        return parseFloat((bytes / Math.pow(k, i)).toFixed(dm)) + " " + sizes[i];
    }
}
