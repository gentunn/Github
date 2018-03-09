import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'todo-input',
  template: `
    <input  [value]="title" (keyup.enter)="changeTitle($event.target.v)" #inputElement>

    <button (click)="changeTitle(inputElement.value)" class="btn btn-primary">
      Save
    </button>
  `,
  styleUrls: ['./input.component.css']
})
export class InputComponent implements OnInit {
  @Output() submit: EventEmitter<string> = new EventEmitter();
  title = 'Add task';

  changeTitle(newTitle: string): void {
    this.submit.emit(newTitle);
  }



  constructor() {
    this.changeTitle('Hello new Title');
    console.log('in constructor');
    this.changeTitle('I love Angular');
    console.log(this.title);

  }

  ngOnInit() {}


}
