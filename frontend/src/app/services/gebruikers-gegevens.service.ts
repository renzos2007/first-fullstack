import {inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {Observable} from 'rxjs';
import {GebruikersGegevens} from '../models/GebruikersGegevens';

@Injectable({
  providedIn: 'root'
})
export class GebruikersGegevensService {
  protected httpClient = inject(HttpClient);

  private apiUrlGetGebruikersGegevens = environment.apiUrl+"/gebruiker/me";

  public getGebruikersGegevens(): Observable<GebruikersGegevens>{
    return this.httpClient.get<GebruikersGegevens>(this.apiUrlGetGebruikersGegevens);
  }
}
