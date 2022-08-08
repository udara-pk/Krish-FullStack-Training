import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ModalDismissReasons, NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {FormBuilder} from "@angular/forms";

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
  closeResult!: string;
  //private httpClient!: HttpClient;
  private deleteId!: number;
  constructor(
    private httpClient: HttpClient,private modalService: NgbModal,private fb: FormBuilder
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

  open(content) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }


  openDelete(targetModal, schedule:Schedule) {
    this.deleteId=schedule.orderRefId;
    this.modalService.open(targetModal,{
      backdrop:'static',
      size:'lg'
    });
  }

  onDelete() {
    const deleteURL = 'http://localhost:8084/allschedule/deliver/' + this.deleteId;
    this.httpClient.delete(deleteURL)
      .subscribe((results) => {
        this.ngOnInit();
        this.modalService.dismissAll();
      });
  }
}
