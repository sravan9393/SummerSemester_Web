import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  // define list of items
  items = [];
  l = 1;
  p = '';
  vid1 = -1;
  vid = '';
  removelem = [];
  comp = 0;
  pen = 0;

  // Write code to push new item
  submitNewItem() {
    this.p = (document.getElementById('push_val') as HTMLInputElement).value ;
    this.items.push({text : this.p , status : 'fa fa-md fa-clock-o', num  : this.l });
    this.l = this.l + 1;
    (document.getElementById('push_val') as HTMLInputElement).value = '';
    this.cal_count();
  }

  cal_count() {
    this.comp = 0;
    this.pen = 0;
    for ( const i of this.items ) {
      if (i.status.toString() === 'fa fa-md fa-clock-o') {
        this.pen = this.pen + 1;
      }
      if (i.status.toString() === 'fa fa-md fa-check-square-o') {
        this.comp = this.comp + 1;

      }

    }
  }
  // Write code to complete item
  completeItem(i) {
    this.vid = (i.target as Element).id;
    for (let i = 0; i < this.items.length ; i++) {
      if ( this.items[i].num.toString() === this.vid.toString() ) {
        this.vid1 = i;
      }

    }
    if ( this.items[this.vid1].status.toString() === 'fa fa-md fa-clock-o') {
      this.items[this.vid1].status = 'fa fa-md fa-check-square-o';
    }
    this.cal_count();

  }


  // Write code to delete item
  deleteItem(i) {
    this.vid = (i.target as Element).id;
    for (const index of this.items ) {
      if ( index.num.toString() === this.vid.toString() ) {
        this.vid1 = index;
      }

    }
    this.items.splice(this.vid1, 1);
    this.cal_count();
  }

}
