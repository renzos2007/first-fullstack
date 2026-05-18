import {inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Login} from '../models/Login';
import {ResponseLoginData} from '../models/ResponseLoginData';
import {Observable, tap} from 'rxjs';
import {environment} from '../../environments/environment';
import {Register} from '../models/Register';
import {Router} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private httpClient = inject(HttpClient);
  private router = inject(Router);
  private loggedIn = false;
  private token: string | null = null;

  constructor() {
    this.loadTokenFromLocalStorage();
    if (this.token != null) {
      this.loggedIn = true;
    }
  }

  public setLoggedIn(loggedIn: boolean): void {
    this.loggedIn = loggedIn;
  }

  public isLoggedIn(): boolean{
    return this.loggedIn;
  }

  public getToken(): string | null {
    return this.token;
  }

  public login(login: Login): Observable<ResponseLoginData> {
    const subscription = this.httpClient.post<ResponseLoginData>(
      environment.apiUrl+'/auth/login',
      login
    ).pipe(
      tap(responseData => {
        if (responseData.token) {
          this.loggedIn = true;
          this.token = responseData.token;
          this.saveTokenLocalStorage(responseData.token);
        }
      })
    );
    return subscription;
  }

  public registerAccount(register: Register): Observable<ResponseLoginData> {

    const subscription = this.httpClient.post<ResponseLoginData>(
      environment.apiUrl+'/auth/register',
      register
    ).pipe(
      tap(responseData => {
        if (responseData.token) {
          this.loggedIn = true;
          this.token = responseData.token;
          this.saveTokenLocalStorage(responseData.token);
        }
      })
    );
    return subscription;
  }

  private saveTokenLocalStorage(token: string): void{
    localStorage.setItem('authToken', token);
  }

  private loadTokenFromLocalStorage(): void{
    this.token = localStorage.getItem('authToken')
  }

  public resetToken(): void{
    this.token = "";
    this.saveTokenLocalStorage(this.token)
    this.setLoggedIn(false);
  }
  public logout(): void {
    this.resetToken();
    this.setLoggedIn(false)
    this.router.navigate(['/']);
  }
}
