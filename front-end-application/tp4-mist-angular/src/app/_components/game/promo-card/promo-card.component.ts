import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Game } from 'src/app/_models/game.model';

@Component({
  selector: 'app-promo-card',
  templateUrl: './promo-card.component.html',
  styleUrls: ['./promo-card.component.scss']
})
export class PromoCardComponent implements OnInit {

  @Input()
  game!: Game;
  truePrice: number = 0;
  constructor() {}

  ngOnInit(): void {
    this.truePrice = this.game.price * (1 - this.game.promotion / 100.0);
    this.truePrice = Math.round(this.truePrice * 100)/100;
  }

}
