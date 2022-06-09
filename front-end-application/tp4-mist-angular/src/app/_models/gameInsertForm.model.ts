import { Developer } from "./developer.model";
import { Editor } from "./editor.model";
import { Genre } from "./genre.model";

export interface GameInsertForm{
    title: String,
    releaseDate: Date,
    genre: Genre[],
    developer: Developer,
    editor: Editor
}