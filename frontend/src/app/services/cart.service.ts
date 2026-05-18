import {Injectable} from '@angular/core';
import {Product} from '../models/Product';
import {CartProduct} from '../models/CartProduct';



@Injectable({
  providedIn: 'root'
})
export class CartService {
  private products: CartProduct[] = [];

  addProduct(product: Product, amount: number): void {
    console.log(product);

    const winkelmandProduct: CartProduct = {
      productID: product.productID,
      image: product.image,
      name: product.name,
      price: product.price,
      amount: amount,
    };

    const index = this.products.findIndex((e) => e.productID === winkelmandProduct.productID);

    if (index != -1){
      this.products[index].amount += amount;
    } else {
      this.products.push(winkelmandProduct);
    }

    this.updateLocalStorage();
  }

  public updateLocalStorage(): void {
    localStorage.setItem('cart_products',JSON.stringify(this.products));
  }

  public getProducts(): CartProduct[] {
    return this.products;
  }

  public setProducts(products: CartProduct[]) {
    this.products = products;
  }
}

