import {Injectable} from '@angular/core';
import {Product} from '../models/Product';
import {WinkelmandProduct} from '../models/WinkelmandProduct';



@Injectable({
  providedIn: 'root'
})
export class WinkelmandService {
  private boeken: WinkelmandProduct[] = [];

  addProduct(product: Product, hoeveelheid: number): void {
    console.log(product);

    const winkelmandProduct: WinkelmandProduct = {
      BoekID: product.boekID,
      plaatje: product.plaatje,
      naam: product.naam,
      prijs: product.prijs,
      hoeveelheid: hoeveelheid,
    };

    const index = this.boeken.findIndex((e) => e.BoekID === winkelmandProduct.BoekID);

    if (index != -1){
      this.boeken[index].hoeveelheid += hoeveelheid;
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

