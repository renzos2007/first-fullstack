import {inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Difficulty} from '../models/Difficulty';
import {Observable} from 'rxjs';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class DifficultyService {
  protected httpClient = inject(HttpClient);

  private apiUrlGetAllDifficulties = environment.apiUrl+"/difficulty";
  private apiUrlGetDifficultyByID = environment.apiUrl+"/difficulty/";

  public getDifficultiyList(): Observable<Difficulty[]> {
    return this.httpClient.get<Difficulty[]>(this.apiUrlGetAllDifficulties);
  }

  public getProductsByDifficulty(id: number): Observable<Difficulty> {
    return this.httpClient.get<Difficulty>(`${this.apiUrlGetDifficultyByID}${id}`);
  }


  constructor() { }
}
