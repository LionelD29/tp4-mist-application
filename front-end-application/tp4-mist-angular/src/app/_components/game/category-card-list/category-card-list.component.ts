import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-category-card-list',
  templateUrl: './category-card-list.component.html',
  styleUrls: ['./category-card-list.component.scss']
})
export class CategoryCardListComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  
  counter(i: number) {
    return new Array(i);
}
}
