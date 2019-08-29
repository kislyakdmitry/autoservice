import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Contract} from './contract';
import { Observable, throwError } from 'rxjs';
import { ResourceService } from './resource.service';
import { retry ,catchError, map, tap } from 'rxjs/operators';

@Injectable()
export class ContractsService{
    constructor(private http: HttpClient, private resourceService: ResourceService){}

    private contractsUrl = 'http://localhost:8080/api/contracts';

    getData(): Observable<Contract[]> {
        return this.resourceService.getResource(this.contractsUrl);
    }
}