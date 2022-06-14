import { Component, OnInit } from '@angular/core';
import { Game } from 'src/app/_models/game.model';
import { GameService } from 'src/app/_services/game.service';

@Component({
  selector: 'app-promo-card-list',
  templateUrl: './promo-card-list.component.html',
  styleUrls: ['./promo-card-list.component.scss']
})
export class PromoCardListComponent implements OnInit {

  games!: Game[];

  constructor(private gameService: GameService) {
    this.gameService.getGames().subscribe({
      next: games => this.games = games.slice(0, 15),
      error: err => alert("echec"),
      complete: () => console.log("get games - completed")
    });
   }

  ngOnInit(): void {
  }

}
