import { Component, OnInit } from '@angular/core';
import { Assreg } from '../shared/assreg';
import { RESTAPIService } from '../shared/rest-api-service.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  title = 'Assessment Management | Assessment List';
  constructor(
    public restApi: RESTAPIService
  ) { }

  registeredDetails: Assreg[];

  ngOnInit(): void {
    this.restApi.findRegisters().subscribe((data: Assreg[]) => {
      this.registeredDetails = data;
    });
  }

}
