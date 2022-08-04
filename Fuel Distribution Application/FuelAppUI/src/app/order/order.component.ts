import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, NgForm} from '@angular/forms';
import {ModalDismissReasons, NgbModal} from '@ng-bootstrap/ng-bootstrap';

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
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  orders!: Order[];
  closeResult!: string;
  editForm!: FormGroup;

  constructor(private httpClient:HttpClient, private modalService: NgbModal,private fb: FormBuilder) {

  }

  ngOnInit(): void {
    this.getAllOrders();
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

  getAllOrders(){
    this.httpClient.get<any>('http://localhost:8080/getallorders').subscribe(
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

  onSubmit(f: NgForm) {
    const url = 'http://localhost:8080/getallorders/addnew';
    this.httpClient.post(url, f.value)
      .subscribe((result) => {
        this.ngOnInit(); //reload the table
      });
    this.modalService.dismissAll(); //dismiss the modal
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
     id: order.shedId,
     location: order.location,
     capacity: order.capacity,
     fuelType: order.fuelType,
     status: order.status
   });

}

onSave() {
  const editURL = 'http://localhost:8080/getallorders/orderreceived/' + this.editForm.value.id;
  console.log(this.editForm.value);
  //console.log(document.getElementById('orderRefId'));
  this.httpClient.put(editURL,"")
    .subscribe((results) => {
      this.ngOnInit();
      this.modalService.dismissAll();
    });
}

}
