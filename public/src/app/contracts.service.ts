import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class ContractsService{
    constructor(private http: HttpClient){}

    private contractsUrl = 'http://localhost:8080/api/contracts';

    getData() {
        return this.http.get(this.contractsUrl);
    }
}