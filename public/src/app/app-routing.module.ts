import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {ContractsComponent} from './contracts/contracts.component';
import {NewContract} from './new_contract/new_contract.component';
import {ScheduleComponent} from './schedule/schedule.component';
import {ContractDetailsComponent} from './contract_details/contract_details.component';


const routes: Routes = [
    {path: 'contracts/:id', component: ContractDetailsComponent},
    {path: 'new', component: NewContract},
    {path: 'login', component: LoginComponent},
    {path: 'register', component: RegisterComponent},
    {path: 'carSchedule', component: ScheduleComponent},
    {path: '', component: ContractsComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {
}
