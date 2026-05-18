import {Injectable} from '@angular/core';
import {Product} from '../models/Product';
import {WinkelmandProduct} from '../models/WinkelmandProduct';



@Injectable({
  providedIn: 'root'
})
export class WinkelmandService {
  private boeken: WinkelmandProduct[] = [];

  addProduct(product: Product, amount: number): void {
    console.log(product);

    const winkelmandProduct: WinkelmandProduct = {
      productID: product.productID,
      image: product.image,
      name: product.name,
      price: product.price,
      amount: amount,
    };

    const index = this.boeken.findIndex((e) => e.productID === winkelmandProduct.productID);

    if (index != -1){
      this.boeken[index].amount += amount;
      console.log ("product is geupdate");
    } else {
      this.boeken.push(winkelmandProduct);
      console.log ("product is nieuw");
    }

    this.updateLocalStorage();
  }

  public updateLocalStorage(): void {
    localStorage.setItem('winkelmand_producten',JSON.stringify(this.boeken));
  }

  public getBoeken(): WinkelmandProduct[] {
    return this.boeken;
  }

  public setBoeken(boeken: WinkelmandProduct[]) {
    this.boeken = boeken;
  }
}

