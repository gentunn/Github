import { Component } from '@angular/core';

@Component({
  selector: 'todo-root',
  template: `
    <div>
    <todo-list-manager></todo-list-manager>
    </div>
  `,
  styleUrls: ['./app.component.css']
})
export class AppComponent {

}
