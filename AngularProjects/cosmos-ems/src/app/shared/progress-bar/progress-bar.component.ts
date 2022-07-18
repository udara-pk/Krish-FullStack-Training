import { outputAst } from '@angular/compiler';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'em-progress-bar',
  templateUrl: './progress-bar.component.html',
  styleUrls: ['./progress-bar.component.scss']
})
export class ProgressBarComponent implements OnInit {

  @Input() progress:number = 0; //getting values from the parent
  @Input() firstName:string = '';
  @Output() progressClick: EventEmitter<string> = new EventEmitter<string>(); //passing values from child to parent
  color:string = '';

  constructor() { }

  ngOnInit(): void {

    if(this.progress<0 || this.progress>100){
      this.progress = 0;
    }

    if(this.progress<35){
      this.color = 'red';
    }else if(this.progress<75){
      this.color = 'yellow';
    }else{
      this.color = 'green';
    }
  }

  onClick(){
    this.progressClick.emit(`${this.firstName}'s progress is ${this.progress} %`)
  }

}
