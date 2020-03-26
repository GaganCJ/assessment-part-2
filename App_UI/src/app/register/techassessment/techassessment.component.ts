import { Component, OnInit, Input } from '@angular/core';
import { RESTAPIService } from '../../shared/rest-api-service.service';
import { Assreg } from '../../shared/assreg';

@Component({
  selector: 'app-techassessment',
  templateUrl: './techassessment.component.html',
  styleUrls: ['./techassessment.component.css']
})
export class TechassessmentComponent implements OnInit {

  @Input() today: any;
  userId: number;
  TechReg: Assreg;
  constructor(
    public restApi: RESTAPIService
  ) { }

  ngOnInit(): void {
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

}
