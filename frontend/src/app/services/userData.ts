import {inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {Observable} from 'rxjs';
import {UserData} from '../models/UserData';

@Injectable({
  providedIn: 'root'
})
export class UserDataService {
  protected httpClient = inject(HttpClient);

  private apiUrlGetUserData = environment.apiUrl+"/user/me";

  public getUserData(): Observable<UserData>{
    return this.httpClient.get<UserData>(this.apiUrlGetUserData);
  }
}
