import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  title = 'Assessment Management | Login';
  constructor() { }

  ngOnInit(): void {
  }

}

/* $("button[type='submit']")
		.click(
				function() {
					if ($("input[name='userid']").val() == null) {
						$("#alertMsg strong").text(
								"User ID should not be empty");
					} else if ($("input[name='password']").val() == null) {
						$("#alertMsg strong").text(
								"Password should not be empty");
					} else if ($("select[name='level'] option:selected").text() == "Select a Level") {
						$("#alertMsg strong").text("Select the access level");
					}
				}); */
