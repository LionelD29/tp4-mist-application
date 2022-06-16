import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Game } from 'src/app/_models/game.model';
import { GameService } from 'src/app/_services/game.service';

@Component({
  selector: 'app-category-page',
  templateUrl: './category-page.component.html',
  styleUrls: ['./category-page.component.scss']
})
export class CategoryPageComponent implements OnInit {

  genre!: string | null;
  games!: Array<Game>;

  constructor(
    private gameService: GameService,
    private route: ActivatedRoute
  ) {
    this.genre = this.route.snapshot.paramMap.get('genre');
    if (this.genre && this.genre != '') {
      this.gameService.getGamesByGenre(this.genre).subscribe({
        next: games => this.games = games,
        error: () => console.log('An error occured during the communication with the backend service')
      });
    }
  }

  ngOnInit(): void {
  }

}
