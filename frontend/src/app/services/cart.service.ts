import {inject, Injectable} from '@angular/core';
import {Product} from '../models/Product';
import {CartProduct} from '../models/CartProduct';
import { environment } from '../../environments/environment';
import { catchError, throwError } from 'rxjs';
import { HttpClient } from '@angular/common/http';



@Injectable({
  providedIn: 'root'
})
export class CartService {
  private http = inject(HttpClient);

  private cartProductList: CartProduct[] = [];

  addProduct(product: Product, amount: number): void {
    console.log(product);

    const CartProduct: CartProduct = {
      productID: product.productID,
      image: product.image,
      name: product.name,
      price: product.price,
      amount: amount,
    };

    const index = this.cartProductList.findIndex((e) => e.productID === CartProduct.productID);

    if (index != -1){
      this.cartProductList[index].amount += amount;
    } else {
      this.cartProductList.push(CartProduct);
    }

    this.updateLocalStorage();
  }

  public updateLocalStorage(): void {
    localStorage.setItem('cart_products',JSON.stringify(this.cartProductList));
  }

  public getProducts(): CartProduct[] {
    return this.cartProductList;
  }

  public setProducts(cartProductList: CartProduct[]) {
    this.cartProductList = cartProductList;
  }

  public createOrder(productData: any) {
    this.http.post(environment.apiUrl + "/order", productData).pipe(
      catchError(error => {
        console.error('Er is een fout opgetreden bij het verzenden van de order:', error);
        return throwError(() => error);
      })
    ).subscribe(response => {
      console.log('Order succesvol verzonden:', response);
    });
  }
}

