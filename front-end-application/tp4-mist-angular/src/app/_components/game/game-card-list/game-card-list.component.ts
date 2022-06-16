import { Component, OnInit } from '@angular/core';
import { Game } from 'src/app/_models/game.model';
import { GameService } from 'src/app/_services/game.service';

@Component({
  selector: 'app-game-card-list',
  templateUrl: './game-card-list.component.html',
  styleUrls: ['./game-card-list.component.scss']
})
export class GameCardListComponent implements OnInit {

  games!: Game[];

  constructor(private gameService: GameService) {
    this.gameService.getGames().subscribe({
      next: games => this.games = games.slice(0, 15).sort((a, b) => a.download - b.download),
      error: err => alert("echec"),
      complete: () => console.log("get games - completed")
    })
   }

  ngOnInit(): void {
  }

}
