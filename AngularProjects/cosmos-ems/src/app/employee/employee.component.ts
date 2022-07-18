import { Component, OnInit } from '@angular/core';
//import employees from './data/employees.json'
import { Employee } from './employee.model';
import { EmployeeService } from './employee.service';

@Component({
 // selector: 'em-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.scss']
})


export class EmployeeComponent implements OnInit {

  title:string = "Employee Management Solution";
  employees!: Employee[];  //= employees;
  filteredEmployees!: Employee[]; //= employees;
  showIcon: boolean = false;
  private _designationFilter: string = '';
  message:string = '';

  set designationFilter(value:string){
    console.log("Setter fired"+ " " +value);
    this._designationFilter = value;
    this.filterByDesignation();
  }

  get designationFilter():string{
    return this._designationFilter;
  }

  constructor(private employeeService:EmployeeService) { }

  ngOnInit(): void {
    this.employeeService.getEmployees().subscribe({
      next:data=>{
      this.filteredEmployees = data;
      this.employees = this.filteredEmployees
    }
    })
  }

  toggleIcon(){
    this.showIcon = !this.showIcon;
  }

  filterByDesignation(){
    this.filteredEmployees = this.employees.filter(employee => employee.designation.includes(this.designationFilter))
  }

  onMessageRecieved(value:string){
    this.message = value;
  }

}
