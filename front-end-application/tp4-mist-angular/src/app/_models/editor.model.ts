import { Game } from "./game.model"

export interface Editor {
    id: number,
    reference: number //od a uuid ??
    name: String,
    games: Game[]
}