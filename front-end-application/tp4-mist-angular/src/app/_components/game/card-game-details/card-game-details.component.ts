import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Game } from 'src/app/_models/game.model';
import { GameService } from 'src/app/_services/game.service';

@Component({
  selector: 'app-card-game-details',
  templateUrl: './card-game-details.component.html',
  styleUrls: ['./card-game-details.component.scss']
})
export class CardGameDetailsComponent implements OnInit {

  game!: Game;
  id!: number;

  constructor(private route: ActivatedRoute, private gameService: GameService) {
    this.id = route.snapshot.params['reference'];
   }

  ngOnInit(): void {
  }

}
