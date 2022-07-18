import { Component } from '@angular/core';

@Component({
  selector: 'em-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'cosmos-Employee Management Solution';
  fullName: string = '';
}
