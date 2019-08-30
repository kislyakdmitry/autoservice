import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Cookie } from 'ng2-cookies';
import { Observable, throwError } from 'rxjs';
import { retry ,catchError, map, tap } from 'rxjs/operators';

@Injectable()
export class ResourceService {
    constructor(private http: HttpClient, private router: Router){}
  
  obtainAccessToken(loginData){
    let body = 'username=' + loginData.username + "&" + 'password=' + loginData.password + "&" + 'grant_type=password';

    const options = {
        headers: new HttpHeaders(
            {'Authorization': 'Basic ' + btoa('autoservice-client:autoservice-secret'),
            'Content-Type': 'application/x-www-form-urlencoded'}
        ),
    }
     
    this.http.post('http://localhost:8080/oauth/token', body, options)
    .pipe().subscribe(
        data => this.saveToken(data),
        err => alert('Invalid Credentials')); 
  }
  
  getResource(resourceUrl):Observable<any> {
    this.checkCredentials();
    return this.http.get(resourceUrl + "?access_token=" + Cookie.get('access_token'));
  }
 
  saveToken(token){
    var expireDate = new Date().getTime() + (1000 * token.expires_in);
    Cookie.set("access_token", token.access_token, expireDate);
    this.router.navigate(['/']);
  }

  checkCredentials(){
    if (!Cookie.check('access_token')){
        this.router.navigate(['/login']);
    }
  } 
 
  logout() {
    Cookie.delete('access_token');
    this.router.navigate(['/login']);
  }
}