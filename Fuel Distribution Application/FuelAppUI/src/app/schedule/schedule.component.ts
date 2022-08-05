import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";

export class Schedule {
  constructor(
    public orderRefId: number,
    public fuelType: string,
    public qty: number,
    public scheduleDate: string,
    public status: string
  ) {
  }
}

@Component({
  selector: 'app-schedule',
  templateUrl: './schedule.component.html',
  styleUrls: ['./schedule.component.css']
})
export class ScheduleComponent implements OnInit {

  schedules!:Schedule[];
  //private httpClient!: HttpClient;
  constructor(
    private httpClient: HttpClient
  ) { }

  ngOnInit(): void {
    this.getAllSchedule();
  }

  getAllSchedule(){
    this.httpClient.get<any>('http://localhost:8083/allschedule').subscribe(
      response => {
        console.log(response);
        this.schedules = response;
      }
    );
  }
}
