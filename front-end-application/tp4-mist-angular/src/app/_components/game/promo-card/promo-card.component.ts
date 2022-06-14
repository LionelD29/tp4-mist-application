import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Game } from 'src/app/_models/game.model';

@Component({
  selector: 'app-promo-card',
  templateUrl: './promo-card.component.html',
  styleUrls: ['./promo-card.component.scss']
})
export class PromoCardComponent implements OnInit {

  @Input()
  game!: Game;

  constructor() { }

  ngOnInit(): void {
  }

}
