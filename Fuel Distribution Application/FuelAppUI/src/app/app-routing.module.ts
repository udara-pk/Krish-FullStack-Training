import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { OrderComponent } from './order/order.component';
import {MyorderComponent} from "./myorder/myorder.component";
import {AvailableComponent} from "./available/available.component";
import {ScheduleComponent} from "./schedule/schedule.component";

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'orders', component: OrderComponent},
  {path: 'myorder', component: MyorderComponent},
  {path: 'available', component: AvailableComponent},
  {path: 'allschedule', component: ScheduleComponent},
  {path: '', component: HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
