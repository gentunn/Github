import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'todo-item',
  template: `
    {{ todoItem.title }}
    <button (click)="removeItem()">
      remove
    </button>
  `,
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {
  @Input() todoItem: any;
  @Output() remove: EventEmitter<any> = new EventEmitter();

  constructor() { }


  ngOnInit() {
  }
  removeItem() {
    this.remove.emit();
  }
}
