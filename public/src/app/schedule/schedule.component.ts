import { Component } from '@angular/core';
import { FormControl } from '@angular/forms';
import { ResourceService } from '../resource.service';
import { Router } from '@angular/router';
import { ScheduleService } from '../schedule.service';

@Component({
    selector: 'schedule',
    templateUrl: './schedule.component.html',
    providers: [ResourceService, ScheduleService]
})
export class ScheduleComponent {

    constructor(private scheduleService: ScheduleService, private resourceService: ResourceService, private router: Router) { }

    days = [
        { id: 1, name: 'Monday' },
        { id: 2, name: 'Tuesday' },
        { id: 3, name: 'Wednesday' },
        { id: 4, name: 'Thursday' },
        { id: 5, name: 'Friday' },
        { id: 6, name: 'Saturday' },
        { id: 7, name: 'Sunday' }];

    currentSchedule: any = {
        days: [],
        time: ''
    }

    private pickedDays = new FormControl();
    private time = '00:00';

    ngOnInit(): void {
        this.scheduleService.getData().subscribe((data:any) => {
            if (data!=null) {
                data.days.forEach(day => {
                    this.currentSchedule.days.push(this.days.filter(el => el.id === day).pop().name);
                });
                this.currentSchedule.time = data.time;
            }
        });
    }

    submit() {
        this.scheduleService.save({ days: this.pickedDays.value, time: this.time }).subscribe(
            res => this.router.navigate(['/']));
    }
}
