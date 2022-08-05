import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ModalDismissReasons, NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {FormBuilder, FormGroup} from "@angular/forms";

export class Order {
  constructor(
    public orderRefId: number,
    public name: string,
    public shedId: number,
    public location: string,
    public capacity: number,
    public fuelType: string,
    public status: string
  ) {
  }
}

@Component({
  selector: 'app-myorder',
  templateUrl: './myorder.component.html',
  styleUrls: ['./myorder.component.css']
})
export class MyorderComponent implements OnInit {

  constructor(private httpClient:HttpClient,private modalService: NgbModal,private fb: FormBuilder) { }
  id!:99;
  orders!: Order[];
  closeResult!: string;
  editForm!: FormGroup;

  ngOnInit(): void {
    this.editForm=this.fb.group(
      {
        orderRefId:[''],
        name: [''],
        shedId: [''],
        location: [''],
        capacity: [''],
        fuelType: [''],
        status: ['']
      }
    )
  }

  getSpecificOrder(){
    const editURL = 'http://localhost:8080/getorder/' + this.id;
    console.log(this.id);
    //console.log(document.getElementById('orderRefId'));
    this.httpClient.get<any>(editURL).subscribe(
      response => {
        console.log(response);
        this.orders = response;
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

  openDetails(targetModal, order: Order) {
    this.modalService.open(targetModal, {
      centered: true,
      backdrop: 'static',
      size: 'lg'
    });


    document.getElementById('sname')?.setAttribute('value', order.name);
    document.getElementById('sid')?.setAttribute('value', order.shedId.toString())
    document.getElementById('slocation')?.setAttribute('value', order.location);
    document.getElementById('sfuelType')?.setAttribute('value', order.fuelType);
    document.getElementById('scapacity')?.setAttribute('value', order.capacity.toString());
    document.getElementById('status')?.setAttribute('value', order.status);

  }

  openEdit(targetModal, order: Order) {
    this.modalService.open(targetModal, {
      centered: true,
      backdrop: 'static',
      size: 'lg'
    });
    this.editForm.patchValue( {

      orderRefId: order.orderRefId,
      name: order.name,
      shedId: order.shedId,
      location: order.location,
      capacity: order.capacity,
      fuelType: order.fuelType,
      status: order.status
    });

  }

  onSave() {
    const editURL = 'http://localhost:8080/getorder/orderreceived/' + this.editForm.value.orderRefId;
    console.log(this.editForm.value);
    //console.log(document.getElementById('orderRefId'));
    this.httpClient.put(editURL,"")
      .subscribe((results) => {
        this.ngOnInit();
        this.getSpecificOrder();
        this.modalService.dismissAll();
      });
  }

}
