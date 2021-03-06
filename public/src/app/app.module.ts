import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {ContractsComponent} from './contracts/contracts.component';
import {MatTableModule} from '@angular/material/table';
import {MatButtonModule} from '@angular/material/button';
import {MatFormFieldModule, MatInputModule} from '@angular/material';
import {MatSelectModule} from '@angular/material/select';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatNativeDateModule} from '@angular/material';

import {ResourceService} from './resource.service';

import {FlexLayoutModule} from '@angular/flex-layout';
import {HttpClientModule} from '@angular/common/http';
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {NewContract} from './new_contract/new_contract.component';
import {ScheduleComponent} from './schedule/schedule.component';
import {ContractDetailsComponent} from './contract_details/contract_details.component';
import {AdditionalAgreementComponent} from './additional_agreement/additional_agreement.component'

@NgModule({
    declarations: [
        AppComponent,
        ContractsComponent,
        LoginComponent,
        RegisterComponent,
        NewContract,
        ScheduleComponent,
        ContractDetailsComponent,
        AdditionalAgreementComponent
    ],
    imports: [
        BrowserAnimationsModule,
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        MatButtonModule,
        MatTableModule,
        MatFormFieldModule,
        MatInputModule,
        FlexLayoutModule,
        FormsModule,
        MatSelectModule,
        ReactiveFormsModule,
        MatDatepickerModule,
        MatNativeDateModule
    ],
    providers: [ResourceService],
    bootstrap: [AppComponent]
})
export class AppModule {
}
