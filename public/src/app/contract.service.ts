import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

import { Contract } from './contract';


@Injectable({ providedIn: 'root' })
export class ContractsService {

  private contractsUrl = 'api/contracts';  // URL to web api

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(
    private http: HttpClient) { }

  getContracts (): Observable<Contract[]> {
    return this.http.get<Contract[]>(this.contractsUrl)
      .pipe(
        tap(_ => console.log('fetched heroes')),
        catchError(console.log('get contracts error'))
      );
  }

  getContract(id: number): Observable<Contract> {
    const url = `${this.contractsUrl}/${id}`;
    return this.http.get<Contract>(url).pipe(
      tap(_ => console.log(`fetched hero id=${id}`)),
      catchError(console.log(`Error get contract id=${id}`))
    );
  }
}