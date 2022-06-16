import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Developer } from 'src/app/_models/developer.model';
import { Editor } from 'src/app/_models/editor.model';
import { Game } from 'src/app/_models/game.model';
import { GameService } from 'src/app/_services/game.service';

@Component({
  selector: 'app-card-game-details',
  templateUrl: './card-game-details.component.html',
  styleUrls: ['./card-game-details.component.scss']
})
export class CardGameDetailsComponent implements OnInit {

  game!: Game;
  editor!: Editor;
  developers!: Developer[];
  reference!: String;

  constructor(private route: ActivatedRoute, private gameService: GameService) {
    this.reference = route.snapshot.params['reference'];
    this.gameService.getGameByReference(this.reference).subscribe({
      next: game => this.game = game,
      error: err => console.log("echec"),
      complete: () => console.log("get game - completed")
    });
   }

  ngOnInit(): void {
  }

}
