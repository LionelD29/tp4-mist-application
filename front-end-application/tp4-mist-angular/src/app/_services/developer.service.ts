import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Developer } from '../_models/developer.model';
import { DeveloperForm } from '../_models/developerForm';

@Injectable({
  providedIn: 'root'
})
export class DeveloperService {

  private readonly BASE_URL = "http://10.27.1.17:8080/developer";

  constructor(private client: HttpClient) { }

  // --- GET ---
  getDevelopers(){
    return this.client.get<Developer[]>(this.BASE_URL);
  }

  getDeveloperByReference(reference: String){
    return this.client.get<Developer>(this.BASE_URL, {params: {reference: <string>reference} });
  }

  getDeveloperByName(name: String){
    return this.client.get<Developer>(this.BASE_URL, {params: {name: <string>name} })
  }

  // --- POST ---
  insertDeveloper(form: DeveloperForm){
    return this.client.post<Developer>(this.BASE_URL + "/add", form );
  }

  // --- PUT ---
  updateDeveloper(form: DeveloperForm){
    return this.client.put<Developer>(this.BASE_URL + "/update", form);
  }

  // --- DELETE ---
  deleteDeveloper(reference: String){
    return this.client.delete<Developer>(this.BASE_URL + "/delete", { params: {reference: <string>reference}});
  }
}
