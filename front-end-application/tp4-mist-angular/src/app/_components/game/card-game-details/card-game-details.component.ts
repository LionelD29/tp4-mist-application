import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
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
  truePrice: number = 0;
  constructor(private route: ActivatedRoute, private gameService: GameService, private router: Router) {
    this.reference = route.snapshot.params['reference'];
    this.gameService.getGameByReference(this.reference).subscribe({
      next: game => {
        this.game = game;
        this.truePrice = this.game.price * (1 - this.game.promotion/100);
        this.truePrice = Math.round(this.truePrice * 100)/100;
      },
      error: err => console.log("echec"),
      complete: () => console.log("get game - completed")
    });
   }

  ngOnInit(): void { 
  }

  onClick(event: any){
    this.router.navigate(['genre', event.target.innerText]);
  }

}
