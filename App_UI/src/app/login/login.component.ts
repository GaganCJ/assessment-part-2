import { Component, Input, Output, EventEmitter } from '@angular/core';
import { Users } from '../shared/users';
import { RESTAPIService } from '../shared/rest-api-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  @Input() title = 'Assessment Management | Login';

  @Output() errAlert = new EventEmitter<any>();

  userDetails: Users;
  userid: number;
  password: string;
  level: string;
   constructor(
       public restApi: RESTAPIService
   ) { }

  userValidate(): void {
    const errDetails = {eUserId: '', ePass: '', eLevel: ''};
    if (this.userid == null) {
        errDetails.eUserId = 'User ID should not be empty';
    } else if (this.password === '') {
        errDetails.ePass = 'Password should not be empty';
    } else if (this.level === 'Select a Level') {
        errDetails.eLevel = 'Select the access level';
    }
    this.errAlert.emit(errDetails);
    if (errDetails.eUserId === '' && errDetails.ePass === '' && errDetails.eLevel === '') {
        this.userDetails = {userId: this.userid, password: this.password, userAccess: this.level};
        this.restApi.loginFunc(this.userDetails).subscribe((data: {}) => {
            // redirect to register or admin page based on the response from server
        });
    }
  }

}
