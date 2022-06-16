import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Game } from '../_models/game.model';
import { GameInsertForm } from '../_models/gameInsertForm.model';
import { GameUpdateForm } from '../_models/gameUpdateForm.model';

@Injectable({
  providedIn: 'root'
})
export class GameService {

  private readonly BASE_URL = "http://10.27.1.17:8080/game";

  constructor(private client: HttpClient) { }


  // --- GET ---
  getGames(){
    return this.client.get<Game[]>(this.BASE_URL);
  }

  getGameByReference(reference: String){
    return this.client.get<Game>(this.BASE_URL, {params: {reference: <string>reference} });
  }

  getGameByTitle(title: String){
    return this.client.get<Game>(this.BASE_URL, {params: {title: <string>title} });
  }

  // --- POST ---
  insertGame(form: GameInsertForm){
    return this.client.post<Game>(this.BASE_URL + "/add", form);
  }

  // --- PUT ---
  updateGame(form: GameUpdateForm){
    return this.client.put<Game>(this.BASE_URL + "/update", form);
  }

  // --- DELETE ---
  deleteGame(reference: String){
    return this.client.delete<Game>(this.BASE_URL + "/delete", {params: {reference: <string>reference} });
  }

  // --- UPDATE DEVELOPER & EDITOR ---
  updateDeveloperOfGame(reference: String, devReference: String){
    return this.client.patch<Game>(this.BASE_URL + "/updateDeveloper", {params: {reference: <string>reference} } , {params: {devReference: <string>devReference} });
  }

  updateEditorOfGame(reference: String, editReference: String){
    return this.client.patch<Game>(this.BASE_URL + "/updateEditor", {params: {reference: <string>reference}}, {params: {editReference: <string>editReference}});
  }

}
