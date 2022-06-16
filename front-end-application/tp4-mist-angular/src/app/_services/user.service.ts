import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserInfoDetail } from '../_models/user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private readonly BASE_URL = "http://10.27.1.17:8080/user";
  constructor(private http: HttpClient) {}

  getInformation():Observable<UserInfoDetail>{
    return this.http.get<UserInfoDetail>(`${this.BASE_URL}/details`);
  }
}
