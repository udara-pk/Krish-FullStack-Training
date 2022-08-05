import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ModalDismissReasons, NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {FormBuilder, FormGroup} from "@angular/forms";
import {Order} from "../myorder/myorder.component";

export class Available {
  constructor(
    public id: number,
    public fuelType: string,
    public qty: number
  ) {
  }
}

@Component({
  selector: 'app-available',
  templateUrl: './available.component.html',
  styleUrls: ['./available.component.css']
})
export class AvailableComponent implements OnInit {

  available1!:Available[];
  closeResult!: string;
  editForm!: FormGroup;

  constructor(
    private httpClient: HttpClient,private modalService: NgbModal,private fb: FormBuilder
  ) { }

  ngOnInit(): void {
    this.getAvailable();
    this.editForm=this.fb.group(
      {
        id:[''],
        fuelType: [''],
        qty: ['']
      }
    )
  }

  getAvailable(){
    this.httpClient.get<any>('http://localhost:8081/available').subscribe(
      response => {
        console.log(response);
        this.available1 = response;
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

  openEdit(targetModal, available: Available) {
    this.modalService.open(targetModal, {
      centered: true,
      backdrop: 'static',
      size: 'lg'
    });
    this.editForm.patchValue( {

      id: available.id,
      fuelType: available.fuelType,
      qty: available.qty
    });

  }

  onSave() {
    const editURL = 'http://localhost:8081/available/edit/' + this.editForm.value.id;
    console.log(this.editForm.value);
    //console.log(document.getElementById('orderRefId'));
    this.httpClient.put(editURL,this.editForm.value)
      .subscribe((results) => {
        this.ngOnInit();
        this.modalService.dismissAll();
      });
  }



}
