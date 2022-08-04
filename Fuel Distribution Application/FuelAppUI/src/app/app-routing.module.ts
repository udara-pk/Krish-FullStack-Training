import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { OrderComponent } from './order/order.component';
import {MyorderComponent} from "./myorder/myorder.component";

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'orders', component: OrderComponent},
  {path: 'myorder', component: MyorderComponent},
  {path: '', component: HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
