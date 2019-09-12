import { Customer } from './customer';

export class Contract {
    id: number;
    startDate: string;
    endDate: string;
    customer: Customer;
    carsVins: Array<string>;
}
