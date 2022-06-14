import { Developer } from "./developer.model";
import { Editor } from "./editor.model";
import { Genre } from "./genre.model";

export interface Game {
    id: number,
    reference: String,
    title: String,
    imageUrl: String,
    releaseDate: Date,
    genres: Genre[],
    developer: Developer,
    editor: Editor,
    price: number,
    stock: number,
    promotion: number,
    download: number
}