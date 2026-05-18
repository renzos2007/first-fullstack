import {inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {Observable} from 'rxjs';
import {UserData} from '../models/UserData';

@Injectable({
  providedIn: 'root'
})
export class GebruikersGegevensService {
  protected httpClient = inject(HttpClient);

  private apiUrlGetGebruikersGegevens = environment.apiUrl+"/gebruiker/me";

  public getGebruikersGegevens(): Observable<UserData>{
    return this.httpClient.get<UserData>(this.apiUrlGetGebruikersGegevens);
  }
}
