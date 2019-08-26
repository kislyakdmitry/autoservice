import { Component } from '@angular/core';
import { ResourceService } from '../resource.service';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [ ResourceService ]
})
export class LoginComponent {
  constructor(private resourceService: ResourceService){}
  public loginData = {
    username: '',
    password: ''
  };

  login() {
    this.resourceService.obtainAccessToken(this.loginData);
}
}
