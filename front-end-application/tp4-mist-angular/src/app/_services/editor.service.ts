import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Editor } from '../_models/editor.model';
import { EditorForm } from '../_models/editorForm';

@Injectable({
  providedIn: 'root'
})
export class EditorService {

  private readonly BASE_URL = "http://10.27.1.17:8080/editor";

  constructor(private client: HttpClient) { }

  // --- GET ---
  getEditors(){
    return this.client.get<Editor[]>(this.BASE_URL);
  }

  getEditorByReference(reference: String){
    return this.client.get<Editor>(this.BASE_URL, {params: {reference: <string>reference} });
  }

  getEditorByName(name: String){
    return this.client.get<Editor>(this.BASE_URL, {params: {name: <string>name} })
  }

  // --- POST ---
  insertEditor(form: EditorForm){
    return this.client.post<Editor>(this.BASE_URL + "/add", form );
  }

  // --- PUT ---
  updateDeveloper(form: EditorForm){
    return this.client.put<Editor>(this.BASE_URL + "/update", form);
  }

  // --- DELETE ---
  deleteDeveloper(reference: String){
    return this.client.delete<Editor>(this.BASE_URL + "/delete", { params: {reference: <string>reference}});
  }
}
