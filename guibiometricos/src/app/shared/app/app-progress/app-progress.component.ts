import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-progress',
  templateUrl: './app-progress.component.html',
  styleUrls: ['./app-progress.component.css']
})
export class AppProgressComponent implements OnInit {

    @Input() progress = 0;

    constructor() { }

    ngOnInit(): void {
    }

}
