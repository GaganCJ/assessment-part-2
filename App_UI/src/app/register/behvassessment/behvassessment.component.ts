import { Component, OnInit, Input } from '@angular/core';
import { RESTAPIService } from '../../shared/rest-api-service.service';
import { Assreg } from '../../shared/assreg';

@Component({
  selector: 'app-behvassessment',
  templateUrl: './behvassessment.component.html',
  styleUrls: ['./behvassessment.component.css']
})
export class BehvassessmentComponent implements OnInit {

  @Input() today: any;
  userId: number;
  BehvReg: Assreg;
  constructor(
    public restApi: RESTAPIService
  ) { }

  ngOnInit(): void {
    this.restApi.getUserId().subscribe((data: number) => {
      this.userId = data;
    });
    document.getElementById('dateof').setAttribute('min', this.today);
  }

  sendBehvA() {
    this.BehvReg.userId = this.userId;
    this.BehvReg.assessmentType = 'BEHV';
    this.restApi.postRegDetails(this.BehvReg).subscribe((data: any) => {});
  }

}
