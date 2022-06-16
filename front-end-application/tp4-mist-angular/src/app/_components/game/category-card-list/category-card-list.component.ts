import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-category-card-list',
  templateUrl: './category-card-list.component.html',
  styleUrls: ['./category-card-list.component.scss']
})
export class CategoryCardListComponent implements OnInit {

  genres: string[] = ["SOLO","MULTI","ADVENTURE","ACTION","FPS","RPG"];
  buttonText: string[] = ["solo","multi","aventure","action","fps","rpg"];

  constructor() { }

  ngOnInit(): void {
  }
}
