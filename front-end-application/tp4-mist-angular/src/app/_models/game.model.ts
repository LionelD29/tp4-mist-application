import { Developer } from "./developer.model";
import { Editor } from "./editor.model";
import { Genre } from "./genre.model";

export interface Game {
    id: number,
    reference: String,
    title: String,
    releaseDate: Date,
    genres: Genre[],
    editor: Editor
    developer: Developer
}