import { Component, Input, OnInit } from '@angular/core';
import { Game } from 'src/app/_models/game.model';

@Component({
  selector: 'app-game-card',
  templateUrl: './game-card.component.html',
  styleUrls: ['./game-card.component.scss']
})
export class GameCardComponent implements OnInit {

  @Input()
  game!: Game;
  truePrice: number = 0;
  constructor() { }

  ngOnInit(): void {
    this.truePrice = this.game.price * (1 - this.game.promotion / 100.0);
    this.truePrice = Math.round(this.truePrice * 100)/100;
  }

}
