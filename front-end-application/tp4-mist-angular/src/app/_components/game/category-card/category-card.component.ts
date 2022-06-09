import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-category-card',
  templateUrl: './category-card.component.html',
  styleUrls: ['./category-card.component.scss']
})
export class CategoryCardComponent implements OnInit {
  @Input() numb_img:number = 0;
  gameSection: string[] = ["solo","arcade","aventure","fight","fps","rpg"];
  constructor() { }

  ngOnInit(): void {
  }

}
