import { Component } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
  providers: [ HttpClient ]
})
export class RegisterComponent {
  constructor(private http: HttpClient, private router: Router){}
  public registerData = {
    username: '',
    password: '',
    firstName: '',
    lastName: ''
  };

  register() {
    this.http.post('http://localhost:8080/api/register', this.registerData).subscribe(res => this.router.navigate(['/']));
}
}
