import {inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Difficulty} from '../models/Difficulty';
import {Observable} from 'rxjs';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class FilterService {
  protected httpClient = inject(HttpClient);

  private apiUrlGetAllNiveau = environment.apiUrl+"/niveau";
  private apiUrlGetNiveauByID = environment.apiUrl+"/niveau/";

  public getNiveaus(): Observable<Difficulty[]> {
    return this.httpClient.get<Difficulty[]>(this.apiUrlGetAllNiveau);
  }

  public getProductsByNiveau(id: number): Observable<Difficulty> {
    return this.httpClient.get<Difficulty>(`${this.apiUrlGetNiveauByID}${id}`);
  }


  constructor() { }
}
