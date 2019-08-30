import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component'
import { ContractsComponent } from './contracts/contracts.component'
import { NewContract } from './new_contract/new_contract.component'


const routes: Routes = [
    { path: 'new', component: NewContract},
    { path: 'login', component: LoginComponent},
    { path: '', component: ContractsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
