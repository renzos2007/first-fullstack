import {inject, Injectable, Signal, signal} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Product} from '../models/Product';
import {Observable} from 'rxjs';
import {environment} from '../../environments/environment';


@Injectable({
  providedIn: 'root'
})
export class ProductService {

  protected httpClient = inject(HttpClient);

  private apiUrlGetAllProducts = environment.apiUrl+"/product";
  private apiUrlGetProductByID = environment.apiUrl+"/product/";

  public getProducts(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(this.apiUrlGetAllProducts);
  }

  public getProductByID(id: number): Observable<Product> {
    return this.httpClient.get<Product>(`${this.apiUrlGetProductByID}${id}`);
  }
}
