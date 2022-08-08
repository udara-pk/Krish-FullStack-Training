import { Component, OnInit } from '@angular/core';
import {Schedule} from "../schedule/schedule.component";
import {HttpClient} from "@angular/common/http";

export class Deliver {
  constructor(
    public orderRefId: number,
    public fuelType: string,
    public qty: number,
    public status: string
  ) {
  }
}

@Component({
  selector: 'app-deliver',
  templateUrl: './deliver.component.html',
  styleUrls: ['./deliver.component.css']
})
export class DeliverComponent implements OnInit {

  delivers!:Deliver[];

  constructor(
    private httpClient: HttpClient
  ) { }

  ngOnInit(): void {
    this.getAllDeliver();
  }

  getAllDeliver(){
    this.httpClient.get<any>('http://localhost:8084/alldelivers').subscribe(
      response => {
        console.log(response);
        this.delivers = response;
      }
    );
  }

}
