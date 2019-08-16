import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Contract} from './contract';
import { Observable, throwError } from 'rxjs';
import { retry ,catchError, map, tap } from 'rxjs/operators';

@Injectable()
export class ContractsService{
    constructor(private http: HttpClient){}

    private contractsUrl = 'http://localhost:8080/api/contracts';

    getData(): Observable<Contract[]> {
        console.log(btoa("user1:pass"));
        return this.http.get<Contract[]>(this.contractsUrl);
    }

    handleError(error) {
        let errorMessage = '';
        if (error.error instanceof ErrorEvent) {
          // client-side error
          errorMessage = `Error: ${error.error.message}`;
        } else {
          // server-side error
          errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
        }
        window.alert(errorMessage);
        return throwError(errorMessage);
      }
}