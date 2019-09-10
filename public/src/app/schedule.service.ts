import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ResourceService} from './resource.service';

@Injectable()
export class ScheduleService {
    constructor(private http: HttpClient, private resourceService: ResourceService) {
    }

    private scheduleUrl = 'http://localhost:8080/api/cars/schedule';

    getData(): Observable<any> {
        return this.resourceService.getResource(this.scheduleUrl);
    }

    save(object: any) {
        return this.resourceService.save(this.scheduleUrl, object);
    }
}
