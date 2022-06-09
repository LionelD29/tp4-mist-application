import { Game } from "./game.model"

export interface Developer {
    id: number,
    reference: number //od a uuid ??
    name: String,
    games: Game[]
}