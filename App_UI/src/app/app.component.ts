import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title: string;
  errAlert: any;

  setErrAlert(data: any) {
    this.errAlert = data;
  }
}
