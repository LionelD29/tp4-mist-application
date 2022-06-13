import { Game } from "./game.model"

export interface Developer {
    id: number,
    reference: String,
    name: String,
    games: Game[]
}