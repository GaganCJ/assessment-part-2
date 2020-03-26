import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  title = 'Assessment Management | Choose Assessment';
  today: any = new Date();
  dd: any = this.today.getDate() + 1;
  mm: any = this.today.getMonth() + 1;
  yyyy: any = this.today.getFullYear();
  constructor() { }

  ngOnInit() {
    if (this.dd < 10) { this.dd = '0' + this.dd; }
    if (this.mm < 10) { this.mm = '0' + this.mm; }
    this.today = this.yyyy + '-' + this.mm + '-' + this.dd;
  }

}
