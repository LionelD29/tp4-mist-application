import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-category-card',
  templateUrl: './category-card.component.html',
  styleUrls: ['./category-card.component.scss']
})
export class CategoryCardComponent implements OnInit {

  @Input()
  genre!: string;
  @Input("button-text")
  buttonText!: string;
  @Input("numb-img")
  numbImg: number = 0;

  constructor(
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  public onClick(): void {
    this.router.navigate(['genre', this.genre]);
  }

}
