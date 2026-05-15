import {inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Filter} from '../models/Filter';
import {Observable} from 'rxjs';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class FilterService {
  protected httpClient = inject(HttpClient);

  private apiUrlGetAllNiveau = environment.apiUrl+"/niveau";
  private apiUrlGetNiveauByID = environment.apiUrl+"/niveau/";

  public getNiveaus(): Observable<Filter[]> {
    return this.httpClient.get<Filter[]>(this.apiUrlGetAllNiveau);
  }

  public getProductsByNiveau(id: number): Observable<Filter> {
    return this.httpClient.get<Filter>(`${this.apiUrlGetNiveauByID}${id}`);
  }


  constructor() { }
}
