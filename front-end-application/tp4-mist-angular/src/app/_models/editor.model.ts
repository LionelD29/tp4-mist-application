import { Game } from "./game.model"

export interface Editor {
    id: number,
    reference: String,
    name: String,
    games: Game[]
}