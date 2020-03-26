import { Component, OnInit } from '@angular/core';
import { Assreg } from '../shared/assreg';
import { RESTAPIService } from '../shared/rest-api-service.service';

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
  userId: number;
  TechReg: Assreg;
  BehvReg: Assreg;
  constructor(
    public restApi: RESTAPIService
  ) { }

  ngOnInit() {
    if (this.dd < 10) { this.dd = '0' + this.dd; }
    if (this.mm < 10) { this.mm = '0' + this.mm; }
    this.today = this.yyyy + '-' + this.mm + '-' + this.dd;
    this.restApi.getUserId().subscribe((data: number) => {
      this.userId = data;
    });
    document.getElementById('dateof').setAttribute('min', this.today);
  }

  sendTechA() {
    this.TechReg.userId = this.userId;
    this.TechReg.assessmentType = 'TECH';
    this.restApi.postRegDetails(this.TechReg).subscribe((data: any) => {});
  }

  sendBehvA() {
    this.BehvReg.userId = this.userId;
    this.BehvReg.assessmentType = 'BEHV';
    this.restApi.postRegDetails(this.BehvReg).subscribe((data: any) => {});
  }

}
