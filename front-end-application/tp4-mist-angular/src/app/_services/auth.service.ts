import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LocalStorageUser, UserAccount, UserSignInForm, UserSignUpForm } from '../_models/user.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
 
  private BASE_URL: string = 'http://10.27.1.17:8080/auth';

  constructor(private http: HttpClient) { }

  public getLocalStorageItem(item: string) {
    return localStorage.getItem(item);
  }

  private getUserInfo(): Observable<UserAccount> {
    return this.http.get<UserAccount>(`${this.BASE_URL}/account`);
  }

  private getAndStoreUserData(token: string): void {
    localStorage.setItem("jwt", token);
    localStorage.setItem("isAuthenticated", "true");
    this.getUserInfo().subscribe({
      next: info => {
        localStorage.setItem('username', info.username);
        localStorage.setItem("email", info.email);
        localStorage.setItem("roles", JSON.stringify(info.roles));
        // let test: string = JSON.parse(localStorage.getItem('user') || '{}')
      },
      error: () => {
        console.log('An error has occured during communication with the back-end service');
      }
    });
  }

  public signIn(form: UserSignInForm): void {
      this.http.post(`${this.BASE_URL}/sign-in`, form, {responseType: 'text'}).subscribe({
        next: token => this.getAndStoreUserData(token),
        error: () => {
          console.log('An error has occured during communication with the back-end service');
        }
      });
  }

  public signUp(form: UserSignUpForm): void {
    this.http.post(`${this.BASE_URL}/sign-up`, form, {responseType: 'text'}).subscribe({
      next: token => this.getAndStoreUserData(token),
      error: () => {
        console.log('An error has occured during communication with the back-end service');
      }
    });
  }

  public signOut(): void {
    localStorage.clear();
  }
}
