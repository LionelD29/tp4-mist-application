import { Developer } from "./developer.model";
import { Editor } from "./editor.model";
import { Genre } from "./genre.model";

export interface Game {
    id: number,
    reference: number, //do a uuid ??
    title: String,
    releaseDate: Date,
    genres: Genre,
    editor: Editor
    developer: Developer
}