import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { EmployeeComponent } from './employee/employee.component';
import { LkrFormatterPipe } from './shared/lkr-formatter.pipe';
import { ProgressBarComponent } from './shared/progress-bar/progress-bar.component';
import { HomeComponent } from './home/home/home.component';
import { RouterModule } from '@angular/router';
import { CreateEmployeeGuard } from './employee/create-employee.guard';
import {HttpClientModule} from '@angular/common/http'

@NgModule({
  declarations: [
    AppComponent,
    EmployeeComponent,
    LkrFormatterPipe,
    ProgressBarComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot([
      {path : 'employees', component : EmployeeComponent},
      {path : 'home', component : HomeComponent},
      {path : 'employees/:id',component : EmployeeComponent, canActivate : [CreateEmployeeGuard]},
      {path : '', redirectTo : 'home', pathMatch : 'full'},
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
