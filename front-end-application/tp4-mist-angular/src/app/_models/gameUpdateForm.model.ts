import { Genre } from "./genre.model";

export interface GameUpdateForm{
    title: String,
    releaseDate: Date,
    genres: Genre[]
}